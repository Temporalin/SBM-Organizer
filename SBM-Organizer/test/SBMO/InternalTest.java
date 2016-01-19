/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBMO;

import challonge.model.Participant;
import challonge.model.Tournament;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andres
 */
public class InternalTest {
    
    Internal internal;
    String tournamentName = "TestingTheCode";
    
    @Before
    public void setUp() {
        internal = new Internal("7qFUMnSyDCqoES42Kvh0mJJnYOwgma1wtGZRbdYn",4);
        Tournament t = internal.createStandardTournament("testTournament","21stCenturySmashingMan");
        for(int i=1;i<=32;i++){
            internal.addParticipant("J"+i,i%4);
        }
        internal.startTournament();
        
    }
    
    @After
    public void tearDown() {
        System.out.println("Finalizado torneo, comprueba todo en Challonge y pulsa enter");
        try {
            System.in.read();
            internal.deleteTournament();
        } catch (IOException ex) {
            Logger.getLogger(InternalTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testSetUp() {
    }

    @Test
    public void testInitializeSetups() {
    }

    @Test
    public void testUpdateSetups() {
    }
    
}
