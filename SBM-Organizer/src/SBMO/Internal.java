package SBMO;

import java.util.*;
import challonge.model.Match;
import challonge.model.Participant;
import challonge.model.Tournament;
import challonge.model.TournamentType;
import challonge.request.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Aquí iría la gestión interna del programa */
/* Metemos enfrentamientos en las setups */
public class Internal {

    private String apiKey;
    private int nSetups;
    private Challonge challonge;
    private Tournament tournament;

    private Map<Integer, Participant> mapaJugadores; //Mapa de jugadores. Clave: id tipo int. Valor: jugdador tipo Participant.
    private Match[] enfrentamientosSetups; // Lista de matches con los enfrentamientos para cada setup
    private List<Match> listaFinalizados = new ArrayList(); // Lista de matches finalizados
    private Queue<Match> colaEnfrentamientos; // Cola con TODOS los enfrentamientos

    public Internal(String apiKey, int nSetups) {
        this.apiKey = apiKey;
        this.nSetups = nSetups;
        this.challonge = new Challonge(apiKey);
        mapaJugadores = new HashMap<>();
    }

    public Tournament createStandardTournament(String name, String url) {
        CreateTournamentRequest.Builder ctr = new CreateTournamentRequest.Builder(name,TournamentType.DOUBLE_ELIMINATION,url);
        tournament = challonge.createTournament(ctr.build());

        return tournament;
    }

    public Participant addParticipant(String name, int seed) {
        CreateParticipantRequest.Builder cprb = new CreateParticipantRequest.Builder(tournament.getUrl(), name);
        cprb.withSeed(seed);

        Participant p = challonge.createParticipant(cprb.build());
        mapaJugadores.put(p.getId(), p);

        return p;
    }

    public void startTournament() {
        StartTournamentRequest str = new StartTournamentRequest(tournament.getUrl(),false,false);
        
        challonge.startTournament(str);
        
        colaEnfrentamientos = new LinkedList<>();
        
        ListMatchRequest.Builder lmrb = new ListMatchRequest.Builder(tournament.getUrl());
        lmrb.withState("open");
        List<Match> listaPartidas = challonge.listMatches(lmrb.build());
        
        for(Match m:listaPartidas){
            colaEnfrentamientos.add(m);
        }
        
    }

    public void deleteTournament() {
        DeleteTournamentRequest dtr = new DeleteTournamentRequest(tournament.getUrl());
        
        challonge.deleteTournament(dtr);
    }
    
    
    public Match peekNextMatch(){
        return colaEnfrentamientos.peek();
    }
    
    public Match pollNextMatch(){
        return colaEnfrentamientos.poll();
    }
    
    public boolean hasNextMatch(){
        return colaEnfrentamientos.size()>0;
    }
    
    /**
     * ***********
     */
    /* GET Y SETS */
    /**
     * ***********
     */
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String a) {
        apiKey = a;
    }

    public int getnSetups() {
        return nSetups;
    }

    public void setnSetups(int n) {
        nSetups = n;
    }

    public void setColaEnfrentamientos(Queue<Match> c) {
        colaEnfrentamientos = c;
    }

    public Queue<Match> getColaEnfrentamientos() {
        return colaEnfrentamientos;
    }

    public void setEnfrentamientosSetups(Match[] e) {
        setEnfrentamientosSetups(e);
    }

    public Match[] getEnfrentamientosSetups() {
        return enfrentamientosSetups;
    }

    public List<Match> getListaFinalizados() {
        return listaFinalizados;
    }

    public void setListaFinalizados(List<Match> listaFinalizados) {
        this.listaFinalizados = listaFinalizados;
    }

    /**
     * ***********
     */
    /* END GETSET */
    /**
     * ***********
     */
    // Inicialmente rellenamos las setups (que están vacías)
    public void initializeSetups() {

        Match[] listaS = new Match[getnSetups()];

        for (int i = 0; i < getnSetups(); i++) {
            listaS[i] = getColaEnfrentamientos().poll();
        }

        setEnfrentamientosSetups(listaS);
    }

    // Rellenamos las setups vacías
    public void updateSetups() {

        //Sacamos elementos de la cola y los metemos en el array
        for (int i = 0; i < getnSetups(); i++) {
            if (getEnfrentamientosSetups()[i] == null) // Si está vacío...
            {
                getEnfrentamientosSetups()[i] = getColaEnfrentamientos().poll();
            }
        }

    }
    
    public static void main(String[] args){
        
        Internal internal = new Internal("7qFUMnSyDCqoES42Kvh0mJJnYOwgma1wtGZRbdYn",4);
        Tournament t = internal.createStandardTournament("testTournament","test"+Double.toString(Math.random()*100).replace('.', '_'));
        for(int i=1;i<=32;i++){
            internal.addParticipant("J"+i,i);
        }
        internal.startTournament();
        
        while(internal.hasNextMatch()){
            Match m = internal.pollNextMatch();
            Participant one = internal.mapaJugadores.get(m.getPlayerOneId());
            Participant two = internal.mapaJugadores.get(m.getPlayerTwoId());
            
            System.out.println(one.getName()+"  vs  "+two.getName());
        }
        
        System.out.println("Finalizado torneo, comprueba todo en Challonge y pulsa enter");
        try {
            System.in.read();
            internal.deleteTournament();
        } catch (IOException ex) {
            Logger.getLogger(Internal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
