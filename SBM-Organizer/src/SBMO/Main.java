package SBMO;

import challonge.model.Match;
import challonge.model.Participant;
import interfaz.*;
import java.util.List;

/* Controlador */

public class Main {
    public static final Boolean debug = true;
    
    public static void main(String[] args) {
        
        // El objeto Internal hace todas las gestiones internas del programa
        Internal i;
        // El objeto Admin hace de enlace entre la API (clase Challonge) y nuestro programa
        Admin a;
        
        // Llamamos a la ventana de configuración
        if(!debug){
            Config ventanita = new Config(new javax.swing.JDialog(),true);
            ventanita.setVisible(true);
            
            a = new Admin(ventanita.getApiKey(),ventanita.getUrl());
            i = new Internal(ventanita.getnSetups());
        }else{
            a = new Admin("3Eum2ckuPLG7XEni1t4nYwn1qI45IsZZbQlAFPEf","test20D");
            i = new Internal(5);
        }

        // Sacamos la lista de enfrentamientos 
        List<Match> listaEnf = a.listaEnfrentamientos();
        
        // Sacamos la lista de nombres a partir de la de enfrentamientos
        List<Participant> listaPar = a.listaParticipantes();
        
        // Metemos los participantes en el mapa
        for(Participant p:listaPar)
            i.mapaParticipantes.put(p.getId(),p);
        
        // Metemos la lista de enfrentamientos en la cola
        i.setQueue(listaEnf);
        
        // Sacamos los n enfrentamientos de la cola y los metemos en la lista de Enfrentamientos en Setups
        for(int j=0;j<i.getnSetups();j++)
            i.updateSetup(j);
        
        // Llamamos a la interfaz principal
        MainUI ventana = new MainUI(a,i);
        ventana.setVisible(true);
        
    }
}
