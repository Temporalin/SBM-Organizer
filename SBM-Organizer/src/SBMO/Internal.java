package SBMO;

import java.util.*;
import challonge.model.Match;
import challonge.model.Participant;
import javax.swing.JTextField;

/* Aquí iría la gestión interna del programa */
/* Metemos enfrentamientos en las setups */

public class Internal {
    
    /* ATRIBUTOS */
    
    private String apiKey;
    private String url;
    private int nSetups;
    
    public static Queue<Match> colaEnfrentamientos; // Cola con TODOS los enfrentamientos
    public static Setup[] enfrentamientosSetups; // Lista de matches con los enfrentamientos para cada setup
    public static List<Match> listaFinalizados; // Lista de matches finalizados
    public static Map<Integer,Participant> mapaPartipantes; // Mapa de Id/Participante
    //private Queue<Integer> nextSetup; por si se necesita

    public Internal(String apiKey, String url, int nSetups) {
        this.apiKey = apiKey;
        this.url = url;
        this.nSetups = nSetups;
        enfrentamientosSetups = new Setup[nSetups];
        listaFinalizados = new ArrayList();
        mapaPartipantes = new HashMap();
    }
    
    /* MÉTODOS */ 
    
    // Inicializamos cola de enfrentamientos
    public static void setQueue(List<Match> enfrentamientos){
        setColaEnfrentamientos(new LinkedList(enfrentamientos));       
    }
    // *** Juntar estos dos métodos en uno
    
    // Inicialmente rellenamos todas las setups
    public void initializeSetups(){
    
        Match[] listaS = new Match[this.getnSetups()];
        
        for(int i=0;i<this.getnSetups();i++)
            listaS[i] = getColaEnfrentamientos().poll();
        
        setEnfrentamientosSetups(listaS);
    }
    
    // Rellenamos las setups vacías
    public void updateSetups(){ // *** Añadir parámetro ID

        //Sacamos elementos de la cola y los metemos en el array de enfrentamientos en setups
        for(int i=0;i<this.getnSetups();i++)
            if(getEnfrentamientosSetups()[i] == null) // Si está vacío...
                getEnfrentamientosSetups()[i] = getColaEnfrentamientos().poll();
        
    }
    
        
    /* GET Y SETS */
    
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

    public static void setEnfrentamientosSetups(Setup[] e) {
        enfrentamientosSetups = e;
    }

    public static Setup[] getEnfrentamientosSetups() {
        return enfrentamientosSetups;
    }

    public static List<Match> getListaFinalizados() {
        return listaFinalizados;
    }

    public static void setListaFinalizados(List<Match> listaFinalizados) {
        Internal.listaFinalizados = listaFinalizados;
    }

}
