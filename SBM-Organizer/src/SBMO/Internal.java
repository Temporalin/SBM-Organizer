package SBMO;

import java.util.*;
import challonge.model.Match;

/* Aquí iría la gestión interna del programa */
/* Metemos enfrentamientos en las setups */

public class Internal {
    public static String apiKey;
    public static String url;
    public static int nSetups;
    public static Queue<Match> colaEnfrentamientos; // Cola con TODOS los enfrentamientos
    
    public static Match[] enfrentamientosSetups; // Lista de matches con los enfrentamientos para cada setup
    public static List<Match> listaFinalizados; // Lista de matches finalizados
        
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

    public void setEnfrentamientosSetups(Match[] enfrentamientosSetups) {
        this.enfrentamientosSetups = enfrentamientosSetups;
    }

    public Match[] getEnfrentamientosSetups() {
        return enfrentamientosSetups;
    }

    public static List<Match> getListaFinalizados() {
        return listaFinalizados;
    }

    public static void setListaFinalizados(List<Match> listaFinalizados) {
        Internal.listaFinalizados = listaFinalizados;
    }

    
    /**************/
    /* END GETSET */
    /**************/
    
    // Inicializamos cola de enfrentamientos
    public void setUp(List<Match> enfrentamientos){
        this.setColaEnfrentamientos(new LinkedList(enfrentamientos));       
        Match[] listaS = new Match[getnSetups()];
    }
    
    // Inicialmente rellenamos las setups (que están vacías)
    public void updateSetups(){
        
        // IF esVacio
        
        //Sacamos elementos de la cola y los metemos en el array
        for(int i=0;i<getnSetups();i++)
            getEnfrentamientosSetups()[i] = getColaEnfrentamientos().poll();
        
    }
    
    //public Match[] actualizarSetups(){}
    
    
}
