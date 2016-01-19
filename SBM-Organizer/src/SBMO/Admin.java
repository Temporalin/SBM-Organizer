package SBMO;

import java.util.List;
import challonge.model.*;
import challonge.request.*;
import java.util.Collections;

/* Hacemos las peticiones a challonge */
public class Admin {
    
    private Challonge challonge;
    
    public Admin(String api_link) {
        challonge = new Challonge(api_link);
    }
    
    /* API */
    
    public List<Match> listaEnfrentamientos(String urlPath) {
        final ListMatchRequest request = new ListMatchRequest.Builder(urlPath).withState("open").build();
        final List<Match> matches = challonge.listMatches(request);
        return matches;
    }
    
    public Participant mostrarParticipante(String urlPath, int participantID) {
        final GetParticipantRequest request = new GetParticipantRequest.Builder(urlPath, participantID)
                .build();
        final Participant participant = challonge.getParticipant(request);
        return participant;
    }
    
    public void actualizarEnfrentamiento(String urlPath, int matchID, MatchScore ms) {
        final UpdateMatchRequest request = new UpdateMatchRequest.Builder(urlPath, matchID)
                .withMatchScores(Collections.singletonList(ms))
                .doTie(true)
                .build();
        final Match match = challonge.updateMatch(request);
        // *** RETURN?
    }
    
    public List<Participant> listaParticipantes(String urlPath) {
        final ListParticipantRequest request = new ListParticipantRequest(urlPath);
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
    
    
}
