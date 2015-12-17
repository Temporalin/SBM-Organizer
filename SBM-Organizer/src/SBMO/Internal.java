package SBMO;

import java.util.*;
import challonge.model.Match;

/* Aquí iría la gestión interna del programa */
/* Metemos enfrentamientos en las setups */

public class Internal {
    public static String apiKey;
    public static String url;
    public static int nSetups;
    public static Queue<Match> colaEnfrentamientos;
    public static Match[] listaSetups;
        
    public Internal(){}
    
    /**************/
    /* GET Y SETS */
    /**************/
    
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getnSetups() {
        return nSetups;
    }

    public void setnSetups(int nSetups) {
        this.nSetups = nSetups;
    }

    public void setColaEnfrentamientos(Queue<Match> colaEnfrentamientos) {
        this.colaEnfrentamientos = colaEnfrentamientos;
    }
    
    public Queue<Match> getColaEnfrentamientos() {
        return colaEnfrentamientos;
    }

    public void setListaSetups(Match[] listaSetups) {
        this.listaSetups = listaSetups;
    }

    public Match[] getListaSetups() {
        return listaSetups;
    }
    
    /**************/
    /* END GETSET */
    /**************/
    
    public void startUp(List<Match> enfrentamientos){
        //inicializamos cola de enfrentamientos
        this.setColaEnfrentamientos(new LinkedList(enfrentamientos));
        
        initializeSetups();
    }
    
    // Inicialmente rellenamos las setups (que están vacías)
    public void initializeSetups(){
        
        Match[] l = new Match[getnSetups()];
        
        //Sacamos elementos de la cola y los metemos en el array
        for(int i=0;i<getnSetups();i++){

            l[i] = getColaEnfrentamientos().poll();
        }
        
        setListaSetups(l);
    }
    
    //public Match[] actualizarSetups(){}
    
    
}
