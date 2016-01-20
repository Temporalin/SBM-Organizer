package SBMO;

import java.util.*;
import challonge.model.Match;
import challonge.model.Participant;
import javax.swing.JTextField;

/* Aquí iría la gestión interna del programa */
/* Metemos enfrentamientos en las setups */

public class Internal {
    
    /* ATRIBUTOS */
    

    private int nSetups;
    
    public Queue<Match> colaEnfrentamientos; // Cola con TODOS los enfrentamientos
    public Setup[] enfrentamientosSetups; // Lista de matches con los enfrentamientos para cada setup
    public List<Match> listaFinalizados; // Lista de matches finalizados
    public Map<Integer,Participant> mapaParticipantes; // Mapa de Id/Participante
    //private Queue<Integer> nextSetup; por si se necesita

    public Internal(int nSetups) {
        this.nSetups = nSetups;
        enfrentamientosSetups = new Setup[nSetups];
        listaFinalizados = new ArrayList();
        mapaParticipantes = new HashMap();
    }
    
    /* MÉTODOS */ 
    
    // Inicializamos cola de enfrentamientos
    public void setQueue(List<Match> enfrentamientos){
        setColaEnfrentamientos(new LinkedList(enfrentamientos));       
    }
    
    // Actualizamos una setup
    public void updateSetup(int ID){
        // Sacamos el próximo enfrentamiento
        Match m = getColaEnfrentamientos().poll();
        
        // Creamos la setup con sus datos
        Setup s = new Setup(ID,getMapaParticipantes().get(m.getPlayerOneId()),getMapaParticipantes().get(m.getPlayerTwoId()),m);
        
        // Metemos la nueva Setup en los enfrentamientos jugándose
        getEnfrentamientosSetups()[ID] = s;
    }
    
    // Devuelve el nombre a partir de la ID del Participante
    public String devolverNombre(int pID){
        return this.getMapaParticipantes().get(pID).getName();
    }
    
    
        
    /* GET Y SETS */
    

    public int getnSetups() {
        return nSetups;
    }

    public void setnSetups(int n) {
        this.nSetups = n;
    }

    public void setColaEnfrentamientos(Queue<Match> c) {
        this.colaEnfrentamientos = c;
    }
    
    public Queue<Match> getColaEnfrentamientos() {
        return colaEnfrentamientos;
    }

    public void setEnfrentamientosSetups(Setup[] e) {
        this.enfrentamientosSetups = e;
    }

    public Setup[] getEnfrentamientosSetups() {
        return enfrentamientosSetups;
    }

    public List<Match> getListaFinalizados() {
        return listaFinalizados;
    }

    public void setListaFinalizados(List<Match> listaFinalizados) {
        this.listaFinalizados = listaFinalizados;
    }

    public Map<Integer, Participant> getMapaParticipantes() {
        return mapaParticipantes;
    }

    public void setMapaParticipantes(Map<Integer, Participant> mapaPartipantes) {
        this.mapaParticipantes = mapaPartipantes;
    }

    
}
