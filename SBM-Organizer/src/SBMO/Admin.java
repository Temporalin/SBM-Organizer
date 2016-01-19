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
    
    /* PROPIOS */
    
    public String[] returnNombres(String url, Match e){
        
        String[] s = new String[2];
        
        Participant p1 = mostrarParticipante(url, e.getPlayerOneId());
        s[0] = p1.getName();
        Participant p2 = mostrarParticipante(url, e.getPlayerTwoId());
        s[1] = p2.getName();
        
        return s;
    }
    
    public int[] returnResultados(Match e){
        int[] r = new int[2];
        e.getScores();
        r[0] = e.getScores().get(0).getPlayerOneScore();
        r[1] = e.getScores().get(0).getPlayerTwoScore();
        
        return r;
    }
    
    //public void enviarResultado(){}
    
    
/*
    public void obtenerEnfrentamiento(String urlPath, int single_match) {
        final GetMatchRequest request = new GetMatchRequest(urlPath, single_match);
        final Match match = challonge.getMatch(request);
    }
*/
}
