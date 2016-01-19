package SBMO;

import challonge.model.Match;
import interfaz.*;
import java.util.List;

/* Controlador */

public class SBMOrganizer {
    
    public static final Boolean debug = true;
    
    public static void main(String[] args) {
        
        // El objeto internal tiene la configuración
        Internal i = new Internal();
        
        // Llamamos a la ventana de configuración
        if(!debug){
            Config ventanita = new Config(new javax.swing.JDialog(),true);
            ventanita.setVisible(true);
            
            i.setUrl(ventanita.getUrl());
            i.setApiKey(ventanita.getApiKey());
            i.setnSetups(ventanita.getnSetups());
            
        }else{
            i.setUrl("test20D");
            i.setApiKey("3Eum2ckuPLG7XEni1t4nYwn1qI45IsZZbQlAFPEf");
            i.setnSetups(5);
        }
        
        // El objeto Admin hace de enlace entre la API (clase Challonge) y nuestro programa
        Admin a = new Admin(i.getApiKey());
        
        // Sacamos la lista de enfrentamientos 
        List<Match> lista = a.listaEnfrentamientos(i.getUrl());
        
        // Metemos la lista de enfrentamientos en la cola
        i.setQueue(lista);
        // Sacamos los n enfrentamientos de la cola y los metemos en la lista de Enfrentamientos en Setups
        i.initializeSetups();
        
        // Llamamos a la interfaz principal
        Main ventana = new Main(i.getnSetups());
        ventana.setVisible(true);

    }
    
}
