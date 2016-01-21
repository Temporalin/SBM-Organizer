package SBMO;

import java.util.*;
import challonge.model.Match;
import challonge.model.Participant;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/* Aquí iría la gestión interna del programa */
/* Metemos enfrentamientos en las setups */

public class Internal {
    
    /* ATRIBUTOS */
    

    private int nSetups;
    public int nOS;
    
    private PriorityQueue<Match> colaEnfrentamientos; // Cola con TODOS los enfrentamientos
    private Map<Integer,Setup> currentSetups; //Mapa con los matches que se están jugando
    private Map<Integer,Match> currentMatches; // Mapa de SetupID / Match*
    //* Podríamos privarnos de ella pero tendríamos un bucle O(n^2) en setQueue()
    private List<Match> listaFinalizados; // Lista de matches finalizados
    private Map<Integer,Participant> mapaParticipantes; // Mapa de Id/Participante
    //private Queue<Integer> nextSetup; por si se necesita

    public Internal(int nSetups) {
        this.nSetups = nSetups;
        this.nOS = nSetups;
        currentSetups = new HashMap();
        listaFinalizados = new ArrayList();
        mapaParticipantes = new HashMap();
        this.currentMatches = new HashMap();
        this.colaEnfrentamientos = new PriorityQueue(new ComparadorMatches());
    }
    
    /* MÉTODOS */ 
    
    // Inicializamos cola de enfrentamientos
    public void setQueue(List<Match> enfrentamientos){
        
        for(Match e:enfrentamientos){

            // Si no se está jugando el enfrentamiento...
            if(!this.currentMatches.containsValue(e)) //*** Comparar jugadores
                this.colaEnfrentamientos.offer(e);
        }
        
    }
    
    // Actualizamos una setup con un enfrentamiento (de los próximos)
    public void updateSetup(int ID){
        // Sacamos el próximo enfrentamiento
        Match m = this.getColaEnfrentamientos().poll();
        // Creamos la setup con sus datos
        Setup s = new Setup(ID,this.getMapaParticipantes().get(m.getPlayerOneId()),this.getMapaParticipantes().get(m.getPlayerTwoId()),m);
        
        // Metemos el Match en el mapa
        this.getCurrentMatches().put(ID,m);
        
        // Metemos la nueva Setup en los enfrentamientos jugándose
        this.getCurrentSetups().put(ID,s);
    }
    
    // Devuelve el nombre a partir de la ID del Participante
    public String devolverNombre(int pID){
        return this.getMapaParticipantes().get(pID).getName();
    }
    
    public void checkFreeplays(){
        if(this.getnSetups() > this.getColaEnfrentamientos().size()){
            this.setnSetups(this.getnSetups() - (this.getnSetups() - this.getColaEnfrentamientos().size()) );
            JOptionPane.showMessageDialog(null, "¡Por fin podemos jugar freeplays!"); // Poner en la UI un cartelito de Freeplays en X setups
        }
    }    
    /* GET Y SETS */
    

    public int getnSetups() {
        return nSetups;
    }

    public void setnSetups(int n) {
        this.nSetups = n;
    }
    
    public PriorityQueue<Match> getColaEnfrentamientos() {
        return colaEnfrentamientos;
    }

    public Map<Integer, Setup> getCurrentSetups() {
        return currentSetups;
    }

    public void setCurrentSetups(Map<Integer, Setup> currentSetups) {
        this.currentSetups = currentSetups;
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

    public Map<Integer, Match> getCurrentMatches() {
        return currentMatches;
    }
    
    
    
}
