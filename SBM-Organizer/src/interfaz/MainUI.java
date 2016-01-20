package interfaz;

import SBMO.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import challonge.model.*;

public class MainUI extends javax.swing.JFrame implements ActionListener {
    
    private int updated = 0;
    
    // Mapa que guarda los campos de texto
    private Map<String,JTextField> listForm = new HashMap();
    // Mapa que guarda las etiquetas
    private Map<String,JLabel> nombresLabel = new HashMap();
    
    // Medidas para las setups
    private int espacio = 30;
    private int anchura = 150;
    
    private JScrollPane scrollIzq = new JScrollPane();
    private JScrollPane scrollDer = new JScrollPane();
    DefaultListModel proximosEnf = new DefaultListModel();
    DefaultListModel finalizadosEnf = new DefaultListModel();
    
    // Le pasamos Admin e Internal
    // *** Alternativa a static
    private Admin admin;
    private Internal internal;

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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SBM ORGANIZER");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        
        for(int i=0;i<nSetups;i++){
            
            // Posición horizontal
            int k;
            if(i==0)
                k = espacio;
            else
                k = (espacio*i)+(anchura*i);
            
            // Etiqueta Setup #
            JLabel setup = new JLabel();
            if (i > 9) setup.setText("Setup "+i);
            else setup.setText("Setup 0"+i);
            setup.setBounds(k, 10, anchura, 30);
            jPanel1.add(setup);
            
            pintarEnfrentamientoSetup(i);
            
            // Formulario resultados 1
            JTextField r1 = new JTextField();
            r1.setSize(30,20);
            r1.setBounds(k-espacio, 40, 30, 20);
            jPanel1.add(r1);
            listForm.put("j1_"+i,r1);
            
            // Formulario resultados 2
            JTextField r2 = new JTextField();
            r2.setSize(30,20);
            r2.setBounds(k-espacio, 65, 30, 20);
            jPanel1.add(r2);
            listForm.put("j2_"+i,r2);
            
            // Botón actualizar
            JButton update = new JButton();
            if (i > 9) update.setText("Update"+i);
            else update.setText("Update0"+i);
            update.setSize(80,30);
            update.setBounds(k-espacio,90,100,30);
            jPanel1.add(update);
            
            // Añadir evento
            update.addActionListener(this);
        }   
    }
    
    private void pintarEnfrentamientoSetup(int numeroSetup){
    
        int k;
        if(numeroSetup==0)
            k = espacio;
        else
            k = (espacio*numeroSetup)+(anchura*numeroSetup);
        
        // Jugador 1
        JLabel j1 = new JLabel();
        j1.setText(internal.devolverNombre(internal.getEnfrentamientosSetups()[numeroSetup].getOne().getId())); 
        j1.setBounds(k, 30, anchura, 30);
        jPanel1.add(j1);
        nombresLabel.put("j1_"+numeroSetup,j1);

        // Jugador 2
        JLabel j2 = new JLabel();
        j2.setText(internal.devolverNombre(internal.getEnfrentamientosSetups()[numeroSetup].getTwo().getId()));
        j2.setBounds(k, 60, anchura, 30);
        jPanel1.add(j2);
        nombresLabel.put("j2_"+numeroSetup,j2);
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
        String nSetup = comando.substring(comando.length() - 1);
        
        // Variable auxiliar con los resultados de las casillas
        String[] resultados = new String[2];
        MatchScore resultado;
        int i = 0; // Guarda la posición para el string resultados
        
        Iterator it = listForm.entrySet().iterator(); // *** Hay que cambiar 0 por 00
        while (it.hasNext()) {
            // Iteramos
            Map.Entry entry = (Map.Entry)it.next();
            
            // Identificador del formulario (ej. j1_0)
            String key = entry.getKey().toString();
            
            // Si el identificador del botón es igual al número de setup
            if(key.substring(key.length() - 1).equals(nSetup)){
                // Sacamos el texto del formulario
                JTextField texto = (JTextField) entry.getValue();
                resultados[i] = texto.getText();
            }
            // Alternamos entre 0 y 1
            if(i==0)
                i++;
            else
                i = 0;
        }
        // Borramos las etiquetas
        jPanel1.remove(nombresLabel.get("j1_"+Integer.parseInt(nSetup)));
        jPanel1.remove(nombresLabel.get("j2_"+Integer.parseInt(nSetup)));
        // *** Habría que poner a 0 los contadores
        // Actualizamos la interfaz
        jPanel1.revalidate();
        jPanel1.repaint();
        
        // Metemos en la lista los jugadores + el resultado
        // *** ENCAPSULAR EN UN NUEVO MÉTODO
        Match m = internal.getEnfrentamientosSetups()[Integer.parseInt(nSetup)].getMatch();
        resultado = new MatchScore(Integer.parseInt(resultados[0]),Integer.parseInt(resultados[1]));
        List<MatchScore> lM = new ArrayList();
        lM.add(resultado);
        Match mNew = new Match(m,lM);
        
        // Actualizamos lista de finalizados
        internal.getListaFinalizados().add(mNew);        
        // Borramos el enfrentamiento
        internal.getEnfrentamientosSetups()[Integer.parseInt(nSetup)] = null;
        // Actualizamos Challonge
        admin.actualizarEnfrentamiento(m.getId(), resultado,this.getWinner(mNew));
        
        // Actualizamos la lista de enfrentamientos en setups
        internal.updateSetup(Integer.parseInt(nSetup));
        // Pintamos el nuevo enfrentamiento en las setups de la interfaz
        pintarEnfrentamientoSetup(Integer.parseInt(nSetup));
        // Eliminamos enfrentamiento nuevo de próximos enfrentamientos
        proximosEnf.removeElementAt(0);
        // Actualizamos lista de enfrentamientos finalizados de la interfaz
        actualizarEnfFinalizados(updated);
        updated++;
        
    }
    
    private int getWinner(Match m){
        int a = m.getScores().get(0).getPlayerOneScore();
        int b = m.getScores().get(0).getPlayerTwoScore();
        
        if(a > b)
            return m.getPlayerOneId();
        else
            return m.getPlayerTwoId();
    }
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
