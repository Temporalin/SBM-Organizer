package SBMO;

import java.util.List;
import challonge.model.*;
import challonge.request.*;
import java.util.Collections;

/* Hacemos las peticiones a challonge */
public class Admin {
    
    private static Challonge challonge;
    private String apiKey;
    private static String url;

    public Admin(String apiKey, String url) {
        this.challonge = new Challonge(apiKey);
        this.apiKey = apiKey;
        this.url = url;
    }
    
    /* API */
    
    // *** Hay que hacer que esta lista esté ordenada, primero W1, luego L1, etc
    
    public static List<Match> listaEnfrentamientos() {
        final ListMatchRequest request = new ListMatchRequest.Builder(getUrl()).withState("open").build();
        final List<Match> matches = challonge.listMatches(request);
        return matches;
    }
    
    public Participant mostrarParticipante(int participantID) {
        final GetParticipantRequest request = new GetParticipantRequest.Builder(getUrl(), participantID)
                .build();
        final Participant participant = challonge.getParticipant(request);
        return participant;
    }
    
    public void actualizarEnfrentamiento(int matchID, MatchScore ms,int wID) {
        final UpdateMatchRequest request = new UpdateMatchRequest.Builder(getUrl(), matchID)
                .withMatchScores(Collections.singletonList(ms))
                .withWinnerId(wID)
                .build();
        final Match match = challonge.updateMatch(request);
    }
    
    public List<Participant> listaParticipantes() {
        final ListParticipantRequest request = new ListParticipantRequest(getUrl());
        final List<Participant> participants = challonge.listParticipants(request);
        return participants;
    }
    
    /* TEMPI 
    
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

    
    */
    
    /* PROPIOS */
    
    public static int[] returnResultados(Match e){
        int[] r = new int[2];
        e.getScores();
        r[0] = e.getScores().get(0).getPlayerOneScore();
        r[1] = e.getScores().get(0).getPlayerTwoScore();
        
        return r;
    }
    
    /* GET SET */
    
    public static String getUrl() {
        return url;
    }
    
}
