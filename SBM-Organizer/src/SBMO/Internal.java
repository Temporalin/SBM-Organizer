package SBMO;

import java.util.*;
import challonge.model.Match;
import challonge.model.MatchScore;
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

    private Map<Integer, Participant> mapaJugadoresPorID;
    private Map<String, Participant> mapaJugadoresPorNombre; //Mapas de jugadores
    private Setup[] enfrentamientosSetups; // Lista de matches con los enfrentamientos para cada setup
    private Queue<Integer> nextSetup;
    private List<Match> listaFinalizados = new ArrayList(); // Lista de matches finalizados
    private Queue<Match> colaEnfrentamientos; // Cola con TODOS los enfrentamientos
    
    public class Setup{
        private int number;
        private String name;
        private Participant one;
        private Participant two;
        private Match match;

        public Setup(int number, String name, Participant one, Participant two, Match match) {
            this.number = number;
            this.name = name;
            this.one = one;
            this.two = two;
            this.match = match;
        }
        public Setup(int number, Participant one, Participant two, Match match) {
            this.number = number;
            this.name = "Setup N"+number;
            this.one = one;
            this.two = two;
            this.match = match;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public Participant getOne() {
            return one;
        }

        public Participant getTwo() {
            return two;
        }

        public Match getMatch() {
            return match;
        }
        
    }

    public Internal(String apiKey, int nSetups) {
        this.apiKey = apiKey;
        this.nSetups = nSetups;
        this.challonge = new Challonge(apiKey);
        this.mapaJugadoresPorID = new HashMap<>();
        this.mapaJugadoresPorNombre = new HashMap<>();
        enfrentamientosSetups = new Setup[nSetups];
        colaEnfrentamientos = new ArrayDeque<>();
        listaFinalizados = new ArrayList<>();
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
        
        mapaJugadoresPorNombre.put(p.getName(),p);
        mapaJugadoresPorID.put(p.getId(), p);

        return p;
    }

    public void startTournament() {
        StartTournamentRequest str = new StartTournamentRequest(tournament.getUrl(),false,false);
        
        challonge.startTournament(str);
        
        updateOpenMatches();
        
        for(int i=0;i<nSetups;i++){
            Match m = colaEnfrentamientos.poll();
            Participant one = mapaJugadoresPorID.get(m.getPlayerOneId());
            Participant two = mapaJugadoresPorID.get(m.getPlayerTwoId());
            enfrentamientosSetups[i] = new Setup(i,one,two,m);
        }
    }
    
    private void updateOpenMatches(){
        if(colaEnfrentamientos.size()==0){
            ListMatchRequest.Builder lmrb = new ListMatchRequest.Builder(tournament.getUrl());
            lmrb.withState("open");
            List<Match> listaPartidas = challonge.listMatches(lmrb.build());

            for(Match m:listaPartidas){
                colaEnfrentamientos.add(m);
            }
        }
    }

    public void deleteTournament() {
        DeleteTournamentRequest dtr = new DeleteTournamentRequest(tournament.getUrl());
        
        challonge.deleteTournament(dtr);
    }
    
    public Setup getSetup(int i){
        return enfrentamientosSetups[i];
    }
    
    public void finishMatchInSetup(Setup set,int winnerID,List<MatchScore> ms){
        int i = set.getNumber();
        
        UpdateMatchRequest.Builder umrb = new UpdateMatchRequest.Builder(tournament.getUrl(), set.getMatch().getId());
        umrb.withMatchScores(ms).withWinnerId(winnerID);
        
        challonge.updateMatch(umrb.build());
        
        Match next=getNextMatch();
        enfrentamientosSetups[i] = new Setup(i,mapaJugadoresPorID.get(next.getPlayerOneId()),mapaJugadoresPorID.get(next.getPlayerTwoId()),next);
    }
    
    private Match getNextMatch(){
        updateOpenMatches();
        Match m = colaEnfrentamientos.poll();
        return m;
    }

    public static void main(String[] args){
        
        Internal internal = new Internal("7qFUMnSyDCqoES42Kvh0mJJnYOwgma1wtGZRbdYn",4);
        Tournament t = internal.createStandardTournament("testTournament","test"+Double.toString(Math.random()*100).replace('.', '_'));
        for(int i=1;i<=32;i++){
            internal.addParticipant("J"+i,i);
        }
        internal.startTournament();
        
        System.out.println("Finalizado torneo, comprueba todo en Challonge y pulsa enter");
        try {
            System.in.read();
            internal.deleteTournament();
        } catch (IOException ex) {
            Logger.getLogger(Internal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
