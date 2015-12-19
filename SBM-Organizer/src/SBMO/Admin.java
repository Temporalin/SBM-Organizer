package SBMO;

import java.util.List;
import java.util.Queue;
import challonge.model.*;
import challonge.request.*;
import java.util.Collections;

/* Hacemos las peticiones a challonge */
public class Admin {
    private Challonge challonge;
    private Internal i = new Internal();
    
    public Admin(String api_link) {
        challonge = new Challonge(api_link);
    }
    
    /* API */
    public List<Match> listaEnfrentamientos(String urlPath) {
        final ListMatchRequest request = new ListMatchRequest.Builder(urlPath).build();
        final List<Match> matches = challonge.listMatches(request);
        return matches;
    }
    
    public Participant mostrarParticipante(String urlPath, int matchID) {
        final GetParticipantRequest request = new GetParticipantRequest.Builder(urlPath, matchID)
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
    
    /* Encapsular #1 */ 
    public String[][] getlistaNombres(Match[] listaIDs, int nSetups){
        
        String[][] s = new String[nSetups][2];
        
        for(int j=0;j<i.getnSetups();j++){
            s[j] = returnNombres(i.getEnfrentamientosSetups()[j]);
        }
        
        return s;
    }
    
    /* Encapsular #1 */
    public String[][] getarrayNombre(Queue<Match> cola){

        String[][] s = new String[cola.size()][2];
        
        for(int j=0;j<cola.size();j++){
            s[j] = returnNombres(cola.poll());
        }
        
        return s;
    }
    
    public String[] returnNombres(Match enfrentamiento){
        
        String[] s = new String[2];
        
        Participant p1 = mostrarParticipante(i.getUrl(), enfrentamiento.getPlayerOneId());
        s[0] = p1.getName();
        Participant p2 = mostrarParticipante(i.getUrl(), enfrentamiento.getPlayerTwoId());
        s[1] = p2.getName();
        
        return s;
    }
    
    //public void enviarResultado(){}
    
    
/*
    public void obtenerEnfrentamiento(String urlPath, int single_match) {
        final GetMatchRequest request = new GetMatchRequest(urlPath, single_match);
        final Match match = challonge.getMatch(request);
    }
*/
}
