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
    public static List<Match> listaFinalizados = new ArrayList(); // Lista de matches finalizados
        
    public Internal(){}
    
    /**************/
    /* GET Y SETS */
    /**************/
    
    public static String getApiKey() {
        return apiKey;
    }

    public static void setApiKey(String a) {
        apiKey = a;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String u) {
        url = u;
    }

    public static int getnSetups() {
        return nSetups;
    }

    public static void setnSetups(int n) {
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
    public static void setUp(List<Match> enfrentamientos){
        setColaEnfrentamientos(new LinkedList(enfrentamientos));       
    }
    
    // Inicialmente rellenamos las setups (que están vacías)
    public static void initializeSetups(){
    
        Match[] listaS = new Match[getnSetups()];
        
        for(int i=0;i<getnSetups();i++)
            listaS[i] = getColaEnfrentamientos().poll();
        
        setEnfrentamientosSetups(listaS);
    }
    
    // Rellenamos las setups vacías
    public static void updateSetups(){

        //Sacamos elementos de la cola y los metemos en el array
        for(int i=0;i<getnSetups();i++)
            if(getEnfrentamientosSetups()[i] == null) // Si está vacío...
                getEnfrentamientosSetups()[i] = getColaEnfrentamientos().poll();
        
    }
    //public Match[] actualizarSetups(){}
    
    
}
