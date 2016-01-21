package interfaz;

import SBMO.*;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import challonge.model.*;

public class MainUI extends javax.swing.JFrame implements ActionListener {
    
    private int updated = 0;
    
    private final JScrollPane scrollIzq = new JScrollPane();
    private final JScrollPane scrollDer = new JScrollPane();
    DefaultListModel proximosEnf = new DefaultListModel();
    DefaultListModel finalizadosEnf = new DefaultListModel();
    
    // Le pasamos Admin e Internal
    private final Admin admin;
    private final Internal internal;

    public MainUI(Admin a, Internal i) {        
        this.admin = a;
        this.internal = i;
        
        // Interfaz
        initComponents();
        
        inicializarInterfaz(i.getnSetups());
        
        // Cargamos los próximos enfrentamientos
        cargarProximosEnf();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SBM Organizer");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );

        jLabel2.setText("Próximos Enfrentamientos");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setText("Enfrentamientos Finalizados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Inicializamos la interfaz generando los elementos necesarios
    public void inicializarInterfaz(int nSetups){        
        /* Próximos enfrentamientos */
        JList listaIzq = new JList(proximosEnf);        
        scrollIzq.setViewportView(listaIzq);
        scrollIzq.setSize(250,150);
        scrollIzq.setBounds(50, 10, 250, 150);
        jPanel2.add(scrollIzq);
        
        /* Enfrentamientos finalizados */        
        JList listaDer = new JList(finalizadosEnf);        
        scrollDer.setViewportView(listaDer);
        scrollDer.setSize(250,150);
        scrollDer.setBounds(50, 10, 250, 150);
        jPanel3.add(scrollDer);
        
        /* Setups */
        int nfilas = (int) (nSetups/6) + 1;
        jPanel1.setLayout(new GridLayout(nfilas, 6));
        
        inputTFs = new JTextField[nSetups*2];
        setupNameLabels = new javax.swing.JLabel[2*nSetups];
        setupPanels = new javax.swing.JPanel[nSetups];
        
        for(int i=0;i<nSetups;i++){
            String n1 = internal.getCurrentSetups().get(i).getOne().getName();
            String n2 = internal.getCurrentSetups().get(i).getTwo().getName();
            setupPanels[i] = getPanelSetup(i,n1,n2);
            jPanel1.add(setupPanels[i]);
        }
    }
    
    private javax.swing.JPanel getPanelSetup(int numSetup, String nombrej1, String nombrej2) {
        javax.swing.JPanel auxPanel = new JPanel(); 
        auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
                        
        // Etiqueta Setup #
        JLabel setup = new JLabel();
        if (numSetup > 9) setup.setText("Setup "+numSetup);
        else setup.setText("Setup 0"+numSetup);
        auxPanel.add(setup);
        auxPanel.add(Box.createRigidArea(new Dimension(0,5)));
                
        // Jugador 1            
        javax.swing.JPanel jug1 = new JPanel(); 
        jug1.setLayout(new BoxLayout(jug1, BoxLayout.X_AXIS));
            
        inputTFs[numSetup*2] = new JTextField();
        inputTFs[numSetup*2].setMinimumSize(new Dimension(40,20));
        inputTFs[numSetup*2].setMaximumSize(new Dimension(40,20));
        jug1.add(inputTFs[numSetup*2]);     
        setupNameLabels[numSetup*2] = new JLabel();
        setupNameLabels[numSetup*2].setText(nombrej1); 
        jug1.add(setupNameLabels[numSetup*2]);
        
        jug1.setAlignmentX( Component.LEFT_ALIGNMENT );
        auxPanel.add(jug1);
        
        // Jugador 2
        javax.swing.JPanel jug2 = new JPanel(); 
        jug2.setLayout(new BoxLayout(jug2, BoxLayout.X_AXIS));
            
        inputTFs[numSetup*2+1] = new JTextField();
        inputTFs[numSetup*2+1].setMinimumSize(new Dimension(40,20));
        inputTFs[numSetup*2+1].setMaximumSize(new Dimension(40,20));
        jug2.add(inputTFs[numSetup*2+1]);          
        setupNameLabels[numSetup*2+1] = new JLabel();
        setupNameLabels[numSetup*2+1].setText(nombrej2);
        jug2.add(setupNameLabels[numSetup*2+1]);
        
        jug2.setAlignmentX( Component.LEFT_ALIGNMENT );
        auxPanel.add(jug2);
        auxPanel.add(Box.createRigidArea(new Dimension(0,5)));   
        
        // Botón actualizar
        JButton update = new JButton();
        if (numSetup > 9) update.setText("Update"+numSetup);
        else update.setText("Update0"+numSetup);
        update.setSize(80,30);
        auxPanel.add(update);
        auxPanel.add(Box.createRigidArea(new Dimension(0,20)));           
        // Añadir evento
        update.addActionListener(this);
        
        return auxPanel;
    }
    
    private void pintarEnfrentamientoSetup(int numeroSetup){
        String nj1 = internal.getCurrentSetups().get(numeroSetup).getOne().getName();
        String nj2 = internal.getCurrentSetups().get(numeroSetup).getTwo().getName();

        setupNameLabels[2*numeroSetup].setText(nj1);
        setupNameLabels[2*numeroSetup+1].setText(nj2);
    }
    
    // Próximos enfrentamientos
    public void cargarProximosEnf(){       
        Queue<Match> colaAux = new LinkedList(internal.getColaEnfrentamientos());
        Match matchAux;
        
        for(int i=0;i<internal.getColaEnfrentamientos().size();i++){
            // Tenemos un Match
            matchAux = colaAux.poll();
            // Desde el match sacamos los Participants
            int p1 = matchAux.getPlayerOneId();
            int p2 = matchAux.getPlayerTwoId();
            
            proximosEnf.addElement(internal.devolverNombre(p1)+" vs "+internal.devolverNombre(p2));
        }

    }
    
    // Enfrentamientos finalizados
    public void actualizarEnfFinalizados(int i){
    
        finalizadosEnf.addElement(
                    internal.devolverNombre(internal.getListaFinalizados().get(i).getPlayerOneId())
            + "  " +
                    Admin.returnResultados(internal.getListaFinalizados().get(i))[0]
            +" - "+
                    Admin.returnResultados(internal.getListaFinalizados().get(i))[1]
            + "  " +
                    internal.devolverNombre(internal.getListaFinalizados().get(i).getPlayerTwoId())
        );
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        // Nombre del botón
        String comando = e.getActionCommand();
        // *** Cogemos el identificador (ej. 00)
        String strSetup = comando.substring(6);
        if(strSetup.substring(0,1).equals("0")) strSetup = strSetup.substring(1);
        int nSetup = Integer.parseInt(strSetup);
        
        // Variable auxiliar con los resultados de las casillas
        String[] resultados = new String[2];
        MatchScore resultado;
        
        resultados[0] = inputTFs[2*nSetup].getText();
        resultados[1] = inputTFs[2*nSetup+1].getText();
        
        // Metemos en la lista los jugadores + el resultado
        // *** ENCAPSULAR EN UN NUEVO MÉTODO
        Match m = internal.getCurrentSetups().get(nSetup).getMatch();
        resultado = new MatchScore(Integer.parseInt(resultados[0]),Integer.parseInt(resultados[1]));
        List<MatchScore> lM = new ArrayList();
        lM.add(resultado);
        Match mNew = new Match(m,lM);
        
        // Actualizamos lista de finalizados
        internal.getListaFinalizados().add(mNew);
        // Borramos el enfrentamiento
        internal.getCurrentSetups().remove(nSetup);

        // Actualizamos Challonge
        admin.actualizarEnfrentamiento(m.getId(), resultado,this.getWinner(mNew));
        
        // Si no hay más enfrentamientos lo rellenamos
        if(internal.getColaEnfrentamientos().isEmpty()){
            List<Match> listaEnf = admin.listaEnfrentamientos();
            internal.setQueue(listaEnf);
        }
        
        // Si quedan menos enfrentamientos que setups activamos las freeplays
        //***internal.checkFreeplays(); Funciona mal, aún no implementarlo
        
        // Actualizamos la lista de enfrentamientos en setups
        internal.updateSetup(nSetup);
        
        // Pintamos nuevos próximos enfrentamientos
        cargarProximosEnf();
        
        // Pintamos el nuevo enfrentamiento en las setups de la interfaz
        pintarEnfrentamientoSetup(nSetup);
        // Eliminamos enfrentamiento nuevo de próximos enfrentamientos
        if(!proximosEnf.isEmpty())
            proximosEnf.removeElementAt(0);
        // Actualizamos lista de enfrentamientos finalizados de la interfaz
        actualizarEnfFinalizados(updated);
        updated++;   
    }
    
    private int getWinner(Match m){
        int a = m.getScores().get(0).getPlayerOneScore();
        int b = m.getScores().get(0).getPlayerTwoScore();        
        if(a > b) return m.getPlayerOneId();
        else return m.getPlayerTwoId();
    }
   
    private javax.swing.JPanel[] setupPanels;
    private JTextField[] inputTFs;
    private javax.swing.JLabel[] setupNameLabels;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
