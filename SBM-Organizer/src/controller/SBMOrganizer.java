package controller;
import java.util.List;
import model.*;
import model.model.*;
import view.*;

/* Controlador */

public class SBMOrganizer {
    
    public static void main(String[] args) {
        
        // Llamamos a la vista
        main ventana = new main();
        ventana.setVisible(true);
       /* String toName = "smashmadrid-rom2";
        Admin modelo = new Admin("3Eum2ckuPLG7XEni1t4nYwn1qI45IsZZbQlAFPEf");
        int numeroSetups = 5;*/
        /*
        List<Match> lista = modelo.listaEnfrentamientos(toName);
        //La metemos en la cola
        Internal internal = new Internal(lista,numeroSetups);
        
        for(int i=0;i<numeroSetups;i++){
            System.out.println("Setup:"+i);

            Participant p1 = modelo.mostrarParticipante(toName, internal.getListaSetups()[i].getPlayerOneId());
            System.out.println(p1.getName());
            Participant p2 = modelo.mostrarParticipante(toName, internal.getListaSetups()[i].getPlayerTwoId());
            System.out.println(p2.getName());
            
            System.out.println("***");
        }*/
    }
    
}
