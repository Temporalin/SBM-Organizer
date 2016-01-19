package SBMO;

import challonge.model.Match;
import challonge.model.Participant;
import interfaz.*;
import java.util.List;

/* Controlador */

public class Main {
    public static final Boolean debug = true;
    
    public static void main(String[] args) {
        
        Internal i;
        
        // Llamamos a la ventana de configuración
        if(!debug){
            Config ventanita = new Config(new javax.swing.JDialog(),true);
            ventanita.setVisible(true);
            
            i = new Internal(ventanita.getApiKey(),ventanita.getUrl(),ventanita.getnSetups());
            
        }else{
            
            i = new Internal("3Eum2ckuPLG7XEni1t4nYwn1qI45IsZZbQlAFPEf","test20D",5);

        }

        // El objeto Admin hace de enlace entre la API (clase Challonge) y nuestro programa
        Admin a = new Admin(i.getApiKey());
       
        // Sacamos la lista de enfrentamientos 
        List<Match> listaEnf = a.listaEnfrentamientos(i.getUrl());
        
        // Sacamos la lista de nombres a partir de la de enfrentamientos
        List<Participant> listaPar = a.listaParticipantes(i.getUrl());
        
        // Metemos los participantes en el mapa
        for(Participant p:listaPar)
            Internal.mapaPartipantes.put(p.getId(),p);
        
        // Metemos la lista de enfrentamientos en la cola
        i.setQueue(listaEnf);
        // Sacamos los n enfrentamientos de la cola y los metemos en la lista de Enfrentamientos en Setups
        i.initializeSetups();
        
        // Llamamos a la interfaz principal
        MainUI ventana = new MainUI(i.getnSetups());
        ventana.setVisible(true);
        
    }
}
