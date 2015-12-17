package SBMO;

import java.util.List;
import java.util.Queue;
import challonge.model.*;
import challonge.request.*;

/* Hacemos las peticiones a challonge */
public class Admin {
    private Challonge challonge;
    
    public Admin(String api_link) {
        challonge = new Challonge(api_link);
    }
    
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
    
    public String[][] getlistaNombres(Match[] listaIDs, int nSetups){
        
        Internal i = new Internal();
        String[][] s = new String[nSetups][2];
        
        for(int j=0;j<i.getnSetups();j++){
            Participant p1 = mostrarParticipante(i.getUrl(), i.getListaSetups()[j].getPlayerOneId());
            s[j][0] = p1.getName();
            Participant p2 = mostrarParticipante(i.getUrl(), i.getListaSetups()[j].getPlayerTwoId());
            s[j][1] = p2.getName();
        }
        
        return s;
    }
    
    public String[][] getarrayNombre(Queue<Match> cola){

        Internal i = new Internal();
        String[][] s = new String[cola.size()][2];
        
        for(int j=0;j<cola.size();j++){
            Participant p1 = mostrarParticipante(i.getUrl(), cola.poll().getPlayerOneId());
            s[j][0] = p1.getName();
            Participant p2 = mostrarParticipante(i.getUrl(), cola.poll().getPlayerTwoId());
            s[j][1] = p2.getName();
        }
        
        return s;
    }
    
    //public void enviarResultado(){}
    
    
/*
    public void obtenerEnfrentamiento(String urlPath, int single_match) {
        final GetMatchRequest request = new GetMatchRequest(urlPath, single_match);
        final Match match = challonge.getMatch(request);
    }

    public void actualizarEnfrentamiento() {
        final UpdateMatchRequest request = new UpdateMatchRequest.Builder("sceond", 11040933)
                .withMatchScores(Collections.singletonList(new MatchScore(1, 2)))
                .doTie(true)
                .build();
        final Match match = challonge.updateMatch(request);
    }
*/
}
