package interfaz;

import SBMO.*;
import java.awt.Font;
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
    public Set<Integer> freeSetups = new HashSet<>();
    
    private JSpinner[] inputSpinners;
    private javax.swing.JPanel[] setupPanels;
    private javax.swing.JPanel jPanel1;
    
    private javax.swing.JLabel[] setupNameLabels;
    private javax.swing.JLabel[] timeLabels;
    private int[] myTimers;
    private javax.swing.Timer clock;
    
    DefaultListModel proximosEnf = new DefaultListModel();
    DefaultListModel finalizadosEnf = new DefaultListModel();
    
    private final Admin admin;
    private final Internal internal;

    public MainUI(Admin a, Internal i) {        
        this.admin = a;
        this.internal = i;
        
        // Interfaz
        customInitComponents();        
        inicializarInterfaz(i.nOS);
        
        // Cargamos los próximos enfrentamientos
        cargarProximosEnf();        
    }
    
    private void customInitComponents() {
        //jPanel1 for setups, 2 & 3 for matches (future ones and past)
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SBM Organizer");

        /* Setups Panel */
        jPanel1.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
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
        
        /* Future sets */
        JPanel pendientes = new javax.swing.JPanel();
        pendientes.setLayout(new BoxLayout(pendientes, BoxLayout.Y_AXIS));
        jLabel2.setText("Próximos Enfrentamientos");
        pendientes.add(jLabel2);
        JList listaIzq = new JList(proximosEnf);  
        listaIzq.setFont(new Font("Tahoma",0,16));
        
        JScrollPane scrollIzq = new JScrollPane();
        scrollIzq.setViewportView(listaIzq);
        scrollIzq.setSize(250,150);
        scrollIzq.setBounds(50, 10, 250, 150);
        pendientes.add(scrollIzq);
        pendientes.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); 
                
        /* Completed sets */          
        JPanel finalizados = new javax.swing.JPanel();
        finalizados.setLayout(new BoxLayout(finalizados, BoxLayout.Y_AXIS));
        jLabel3.setText("Enfrentamientos Finalizados");
        finalizados.add(jLabel3);      
        JList listaDer = new JList(finalizadosEnf);
        
        JScrollPane scrollDer = new JScrollPane();
        scrollDer.setViewportView(listaDer);
        scrollDer.setSize(250,150);
        scrollDer.setBounds(50, 10, 250, 150);
        finalizados.add(scrollDer);
        finalizados.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
        
        
        JPanel listas = new javax.swing.JPanel();
        listas.setLayout(new BoxLayout(listas, BoxLayout.Y_AXIS));
        listas.setMinimumSize(new Dimension(100,100));
        listas.setMaximumSize(new Dimension(100,1000000));
        listas.add(pendientes);
        listas.add(finalizados);        
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().add(listas);        
        getContentPane().add(jPanel1);
        pack();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SBM Organizer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Inicializamos la interfaz generando los elementos necesarios
    public void inicializarInterfaz(int nSetups){        
        /* Timer */
        clock = new javax.swing.Timer(1000,taskPerformer);
        clock.start();
        
        /* Setups */
        int nfilas = ((int) (nSetups/5)) + 1;
        jPanel1.setLayout(new GridLayout(nfilas, 5));

        inputSpinners = new JSpinner[2*nSetups];      
        setupNameLabels = new javax.swing.JLabel[nSetups*2];
        timeLabels = new javax.swing.JLabel[nSetups];
        myTimers =  new int[nSetups];
        setupPanels = new javax.swing.JPanel[nSetups];
        
        int numFights = admin.listaEnfrentamientos().size();        
        for(int i=0;i<nSetups;i++){
            if (i < numFights) {
                Setup s = internal.getCurrentSetups().get(i);
                int r = s.getMatch().getRound();
                String n1 = s.getOne().getName();
                String n2 = s.getTwo().getName();
                setupPanels[i] = getPanelSetup(i,n1,n2,r);
            } else setupPanels[i] = getPanelSetupFreeplay(i);
            jPanel1.add(setupPanels[i]);
        }
    }
    
    private javax.swing.JPanel getPanelSetup(int numSetup, String nombrej1, String nombrej2, int r) {
        javax.swing.JPanel auxPanel = new JPanel(); 
        auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
                             
        // Label Setup #
        JLabel setup = new JLabel();
        setup.setText("SETUP "+numSetup);
        setup.setFont(new Font("Tahoma",Font.BOLD,15));
        auxPanel.add(setup);
        setup.setAlignmentX( Component.CENTER_ALIGNMENT);
        auxPanel.add(Box.createRigidArea(new Dimension(0,5)));
        
        // Players
        javax.swing.JPanel players = new JPanel();
        players.setLayout(new BoxLayout(players, BoxLayout.X_AXIS));
        
        setupNameLabels[numSetup*2] = new JLabel();
        setupNameLabels[numSetup*2].setText(nombrej1); 
        setupNameLabels[numSetup*2].setFont(new Font("Tahoma",Font.PLAIN,14));
        players.add(setupNameLabels[numSetup*2]);
        players.add(new JLabel(" vs. "));
        setupNameLabels[numSetup*2+1] = new JLabel();
        setupNameLabels[numSetup*2+1].setText(nombrej2); 
        setupNameLabels[numSetup*2+1].setFont(new Font("Tahoma",Font.PLAIN,14));    
        players.add(setupNameLabels[numSetup*2+1]);
        
        auxPanel.add(players);
        auxPanel.add(Box.createRigidArea(new Dimension(0,3)));
        players.setAlignmentX( Component.CENTER_ALIGNMENT);        
        
        // Results
        javax.swing.JPanel results = new JPanel(); 
        results.setLayout(new BoxLayout(results, BoxLayout.X_AXIS));   
        String[] possibleResults = {"0","1","2","3","4","5"};
        
        SpinnerListModel resSpinner1 = new SpinnerListModel(possibleResults);
        inputSpinners[2*numSetup] = new JSpinner(resSpinner1);
        inputSpinners[numSetup*2].setMinimumSize(new Dimension(40,20));
        inputSpinners[numSetup*2].setMaximumSize(new Dimension(40,20));
        results.add(inputSpinners[numSetup*2]);
        
        results.add(Box.createRigidArea(new Dimension(5,0)));      
        results.add(new JLabel("-"));
        results.add(Box.createRigidArea(new Dimension(5,0)));
        
        SpinnerListModel resSpinner2 = new SpinnerListModel(possibleResults);
        inputSpinners[numSetup*2+1] = new JSpinner(resSpinner2);
        inputSpinners[numSetup*2+1].setMinimumSize(new Dimension(40,20));
        inputSpinners[numSetup*2+1].setMaximumSize(new Dimension(40,20));
        results.add(inputSpinners[numSetup*2+1]);   
        
        auxPanel.add(results);
        results.setAlignmentX( Component.CENTER_ALIGNMENT);
        auxPanel.add(Box.createRigidArea(new Dimension(0,14)));
        
        // Temporizador y ronda
        timeLabels[numSetup] = new JLabel();
        myTimers[numSetup] = 900;
        int min = (int) myTimers[numSetup]/60;
        int sec = myTimers[numSetup]%60;
        String WL;
        if (r > 0) WL = "W"+r;
        else WL = "L"+(-r);
        timeLabels[numSetup].setText(WL+"     "+min+":"+sec);
        auxPanel.add(timeLabels[numSetup]);
        timeLabels[numSetup].setAlignmentX( Component.CENTER_ALIGNMENT);
        auxPanel.add(Box.createRigidArea(new Dimension(0,2)));    
        
        // Botón actualizar
        JButton update = new JButton();
        if (numSetup > 9) update.setText("Update"+numSetup);
        else update.setText("Update0"+numSetup);
        update.setSize(80,30);
        auxPanel.add(update);
        update.setAlignmentX( Component.CENTER_ALIGNMENT);
               
        // Añadir evento
        update.addActionListener(this);
        
        return auxPanel;
    }
    
    private javax.swing.JPanel getPanelSetupFreeplay(int numSetup) {
        javax.swing.JPanel auxPanel = new JPanel();
        auxPanel.setLayout(new BoxLayout(auxPanel, BoxLayout.Y_AXIS));
            
        // Etiqueta Setup #
        JLabel setup = new JLabel();
        setup.setText("Setup "+numSetup);
        auxPanel.add(setup);
        auxPanel.add(Box.createRigidArea(new Dimension(0,10)));    
        // Etiqueta de freeplays
        JLabel freeplays = new JLabel();
        freeplays.setText("FREEPLAYS");
        auxPanel.add(freeplays);
        
        return auxPanel;
    }
    
    private void pintarEnfrentamientoSetup(int numeroSetup){
        String nj1 = internal.getCurrentSetups().get(numeroSetup).getOne().getName();
        String nj2 = internal.getCurrentSetups().get(numeroSetup).getTwo().getName();
            
        setupNameLabels[2*numeroSetup].setText(nj1);
        setupNameLabels[2*numeroSetup+1].setText(nj2);
        
        String WL;
        int r = internal.getCurrentSetups().get(numeroSetup).getMatch().getRound();
        if (r > 0) WL = "W"+r;
        else WL = "L"+(-r);
        
        myTimers[numeroSetup] = 900;
        int min = (int) myTimers[numeroSetup]/60;
        int sec = myTimers[numeroSetup]%60;
        timeLabels[numeroSetup].setText(WL+"     "+min+":"+sec);
    }
    
    // Próximos enfrentamientos
    public void cargarProximosEnf(){       
        PriorityQueue<Match> colaAux = new PriorityQueue(internal.getColaEnfrentamientos());
        Match matchAux;
        
        for(int i=0;i<internal.getColaEnfrentamientos().size();i++){
            // Tenemos un Match
            matchAux = colaAux.poll();
            // Desde el match sacamos los Participants
            int p1 = matchAux.getPlayerOneId();
            int p2 = matchAux.getPlayerTwoId();
            
            String WL;
            int R = matchAux.getRound();
            if (R > 0) WL = "W"+R;
            else WL = "L"+(-R); 
            proximosEnf.addElement(WL+" "+internal.devolverNombre(p1)+" vs "+internal.devolverNombre(p2));
        }
    }
    
    // Enfrentamientos finalizados
    public void actualizarEnfFinalizados(int i){
        String WL;
        int R = internal.getListaFinalizados().get(i).getRound();
        if (R > 0) WL = "W"+R;
        else WL = "L"+(-R); 
        finalizadosEnf.addElement(WL + "  " +
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
        // Cogemos el identificador del setup
        String comando = e.getActionCommand();
        String strSetup = comando.substring(6);
        if(strSetup.substring(0,1).equals("0")) strSetup = strSetup.substring(1);
        int nSetup = Integer.parseInt(strSetup);
        
        // Variable auxiliar con los resultados de las casillas
        String[] resultados = new String[2];
        MatchScore resultado;
        
        resultados[0] = inputSpinners[2*nSetup].getValue().toString();
        resultados[1] = inputSpinners[2*nSetup+1].getValue().toString();
        
        if (resultados[0] == resultados[1]) {
            JOptionPane.showMessageDialog(null, "There can't be a draw");
            return;
        }
        
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
        internal.getCurrentMatches().remove(nSetup);

        // Actualizamos Challonge
        admin.actualizarEnfrentamiento(m.getId(), resultado,this.getWinner(mNew));
        
        actualizarEnfFinalizados(updated);
        updated++;
        
        // Si no hay más enfrentamientos lo rellenamos
        if(internal.getColaEnfrentamientos().isEmpty()){
            List<Match> listaEnf = admin.listaEnfrentamientos();
            internal.setQueue(listaEnf);
            
            // Pintamos nuevos próximos enfrentamientos
            cargarProximosEnf();

        }
        // Si no hay mas enfrentamientos, se pasa a freeplay
        if(proximosEnf.isEmpty()) {
            freeSetups.add(nSetup);
            for (int i = nSetup; i < setupPanels.length; ++i) jPanel1.remove(setupPanels[i]);
            setupPanels[nSetup] = new JPanel();
            setupPanels[nSetup] = getPanelSetupFreeplay(nSetup);
            for (int i = nSetup; i < setupPanels.length; ++i) jPanel1.add(setupPanels[i]);
        } else {
            // Actualizamos la lista de enfrentamientos en setups
            internal.updateSetup(nSetup);
            // Eliminamos enfrentamiento nuevo de próximos enfrentamientos
            proximosEnf.removeElementAt(0);
            // Pintamos el nuevo enfrentamiento en las setups de la interfaz
            pintarEnfrentamientoSetup(nSetup);
            // Si hay setups libres y partidas por jugar
            while (freeSetups.size() > 0 && !proximosEnf.isEmpty()) {
                int setup = freeSetups.iterator().next();
                for (int i = setup; i < setupPanels.length; ++i) jPanel1.remove(setupPanels[i]);
                setupPanels[setup] = new JPanel();
                setupPanels[setup] = getPanelSetup(setup,"","",0);
                for (int i = setup; i < setupPanels.length; ++i) jPanel1.add(setupPanels[i]);
                freeSetups.remove(setup);
                internal.updateSetup(setup);
                proximosEnf.removeElementAt(0);
                pintarEnfrentamientoSetup(setup);
            }
        }
    }
    
    private int getWinner(Match m){
        int a = m.getScores().get(0).getPlayerOneScore();
        int b = m.getScores().get(0).getPlayerTwoScore();        
        if(a > b) return m.getPlayerOneId();
        else return m.getPlayerTwoId();
    }
    
    // Cada segundo, cambian los relojes
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            for (int i = 0; i < myTimers.length; ++i) {
                if (myTimers[i] > 0 && !freeSetups.contains(i)) {
                    --myTimers[i];
                    int min = (int) myTimers[i]/60;
                    int sec = myTimers[i]%60;
                    String WL;
                    int r = internal.getCurrentSetups().get(i).getMatch().getRound();
                    if (r > 0) WL = "W"+r;
                    else WL = "L"+(-r);
                    timeLabels[i].setText(WL+"     "+min+":"+sec);
                    if (myTimers[i] == 0) JOptionPane.showMessageDialog(null, "Revisar setup "+i);
                }
            }
        }
    };
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}