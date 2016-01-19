package interfaz;

import SBMO.Internal;
import SBMO.Admin;
import SBMO.SBMOrganizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import challonge.model.*;

public class Main extends javax.swing.JFrame implements ActionListener {
    
    private int updated = 0;
    
    // Mapa que gu
    private Map<String,JTextField> listForm = new HashMap();
    private Map<String,JLabel> nombresLabel = new HashMap();
    
    private int espacio = 30;
    private int anchura = 100;
    
    private JScrollPane scrollIzq = new JScrollPane();
    private JScrollPane scrollDer = new JScrollPane();
    DefaultListModel proximosEnf = new DefaultListModel();
    DefaultListModel finalizadosEnf = new DefaultListModel();
    
    public Main(int nSetups) {
        
        
        initComponents();
        
        inicializarInterfaz(nSetups);
        
        cargarCola();
        
        
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
            setup.setText("Setup "+i);
            setup.setBounds(k, 10, anchura, 30);
            jPanel1.add(setup);
            
            pintarEnfrentamiento(i);
            
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
            update.setText("Update"+i);
            update.setSize(80,30);
            update.setBounds(k-espacio,90,80,30);
            jPanel1.add(update);
            
            // Añadir evento
            update.addActionListener(this);
            
            // Mostrar por pantalla el contenido
        }   
    }
    
    private void pintarEnfrentamiento(int numeroSetup){
    
        int k;
        if(numeroSetup==0)
            k = espacio;
        else
            k = (espacio*numeroSetup)+(anchura*numeroSetup);
        
        // Jugador 1
        JLabel j1 = new JLabel();
        j1.setText(admin.returnNombres(Internal.getEnfrentamientosSetups()[numeroSetup])[0]);
        j1.setBounds(k, 30, anchura, 30);
        jPanel1.add(j1);
        nombresLabel.put("j1_"+numeroSetup,j1);

        // Jugador 2
        JLabel j2 = new JLabel();
        j2.setText(admin.returnNombres(Internal.getEnfrentamientosSetups()[numeroSetup])[1]);
        j2.setBounds(k, 60, anchura, 30);
        jPanel1.add(j2);
        nombresLabel.put("j2_"+numeroSetup,j2);
    }
    
    /* Encapsular #2 */
    // Próximos enfrentamientos
    public void cargarCola(){
       
        Queue<Match> colaAux = new LinkedList(Internal.getColaEnfrentamientos());
        String[] nombres;
        
        for(int i=0;i<Internal.getColaEnfrentamientos().size();i++){
            nombres = admin.returnNombres(colaAux.poll());
            proximosEnf.addElement(nombres[0]+" vs "+nombres[1]);
        }

    }
    
    /* Encapsular #2 */
    // Enfrentamientos finalizados
    public void rellenarLista(int i){
    
        finalizadosEnf.addElement(
                    admin.returnResultados(Internal.getListaFinalizados().get(i))[0]
            + " " +
                    admin.returnNombres(Internal.getListaFinalizados().get(i))[0]
            +" vs "+
                    admin.returnResultados(Internal.getListaFinalizados().get(i))[1]
            + " " +
                    admin.returnNombres(Internal.getListaFinalizados().get(i))[1]
        );
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Nombre del botón
        String comando = e.getActionCommand();
        String nSetup = comando.substring(comando.length() - 1);
        
        String[] resultados = new String[2];
        MatchScore resultado;
        int i = 0;
        
        Iterator it = listForm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            
            // Identificador del formulario (ej. j1_0)
            String key = entry.getKey().toString();
            
            // Si el identificador del botón es igual al número de setup
            if(key.substring(key.length() - 1).equals(nSetup)){
                // Sacamos el texto del formulario
                JTextField texto = (JTextField) entry.getValue();
                resultados[i] = texto.getText();
            }
            if(i==0)
                i++;
            else
                i = 0;
        }
        // Borramos las etiquetas
        jPanel1.remove(nombresLabel.get("j1_"+Integer.parseInt(nSetup)));
        jPanel1.remove(nombresLabel.get("j2_"+Integer.parseInt(nSetup)));
        jPanel1.revalidate();
        jPanel1.repaint();
        
        // Metemos en la lista los jugadores + el resultado
        Match m = Internal.getEnfrentamientosSetups()[Integer.parseInt(nSetup)];
        resultado = new MatchScore(Integer.parseInt(resultados[0]),Integer.parseInt(resultados[1]));
        List<MatchScore> lM = new ArrayList();
        lM.add(resultado);
        Match mNew = new Match(m,lM);
        
        // Actualizamos lista de finalizados
        Internal.getListaFinalizados().add(mNew);        
        // Borramos el enfrentamiento
        Internal.getEnfrentamientosSetups()[Integer.parseInt(nSetup)] = null;
        // Actualizamos Challonge
        if(!SBMOrganizer.debug) //*** CAMBIAR ESTO
            admin.actualizarEnfrentamiento(Internal.getUrl(), m.getId(), resultado);
        
        // Actualizamos la lista de enfrentamientos en setups
        Internal.updateSetups();
        // Pintamos el nuevo enfrentamiento
        pintarEnfrentamiento(Integer.parseInt(comando.substring(comando.length() - 1)));
        // Eliminamos enfrentamiento nuevo de próximos enfrentamientos
        proximosEnf.removeElementAt(0);
        // Actualizamos lista visual de enfrentamientos
        rellenarLista(updated);
        updated++;
    }
   
    
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
*/
        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
