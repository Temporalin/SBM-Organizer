package SBMO;

import java.util.*;
import challonge.model.Match;

/* Aquí iría la gestión interna del programa */
/* Metemos enfrentamientos en las setups */

public class Internal {
    
    public String apiKey;
    public String url;
    public int nSetups;
    public static Queue<Match> colaEnfrentamientos; // Cola con TODOS los enfrentamientos
    
    public static Match[] enfrentamientosSetups; // Lista de matches con los enfrentamientos para cada setup
    public static List<Match> listaFinalizados = new ArrayList(); // Lista de matches finalizados
        
    public Internal(){}
    
    /**************/
    /* GET Y SETS */
    /**************/
    
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String a) {
        apiKey = a;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String u) {
        url = u;
    }

    public int getnSetups() {
        return nSetups;
    }

    public void setnSetups(int n) {
        nSetups = n;
    }

    public static void setColaEnfrentamientos(Queue<Match> c) {
        colaEnfrentamientos = c;
    }
    
    public static Queue<Match> getColaEnfrentamientos() {
        return colaEnfrentamientos;
    }

    public static void setEnfrentamientosSetups(Match[] e) {
        enfrentamientosSetups = e;
    }

    public static Match[] getEnfrentamientosSetups() {
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
    public void setQueue(List<Match> enfrentamientos){
        setColaEnfrentamientos(new LinkedList(enfrentamientos));       
    }
    
    // Inicialmente rellenamos las setups (que están vacías)
    public void initializeSetups(){
    
        Match[] listaS = new Match[getnSetups()];
        
        for(int i=0;i<getnSetups();i++)
            listaS[i] = getColaEnfrentamientos().poll();
        
        setEnfrentamientosSetups(listaS);
    }
    
    // Rellenamos las setups vacías
    public void updateSetups(){

        //Sacamos elementos de la cola y los metemos en el array
        for(int i=0;i<getnSetups();i++)
            if(getEnfrentamientosSetups()[i] == null) // Si está vacío...
                getEnfrentamientosSetups()[i] = getColaEnfrentamientos().poll();
        
    }
    //public Match[] actualizarSetups(){}
    
    
}
