package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import model.*;
import model.model.*;

public class main extends javax.swing.JFrame implements ActionListener {
        
    private Map<String,JTextField> listForm = new HashMap<>();
    
    public main() {
        /*config ventanita = new config(new javax.swing.JDialog(),true);
        ventanita.setVisible(true);*/
        
        initComponents();
        //Sacamos el array de enfrentamientos
        
        Internal internal = new Internal();

        internal.setUrl("smashmadrid-rom2");
        internal.setApiKey("3Eum2ckuPLG7XEni1t4nYwn1qI45IsZZbQlAFPEf");
        internal.setnSetups(5);
        
        //Llamamos a Admin
        Admin admin = new Admin(internal.getApiKey());
        //Sacamos la lista de enfrentamientos
        List<Match> lista = admin.listaEnfrentamientos(internal.getUrl());
        //La metemos en la cola
        internal.startUp(lista);
        
        // Sacamos array doble (dos por enfrentamiento) con los nombres
        String[][] listaNombres = admin.getlistaNombres(internal.getListaSetups(),internal.getnSetups());
        
        // Llenamos cada setup con los nombres de los participantes
        cargarSetups(internal.getnSetups(),listaNombres);
        
        // Llenamos los Próximos enfrentamientos pasando la cola de enfrentamientos a un array doble de nombres
        cargarCola(admin.getarrayNombre(internal.getColaEnfrentamientos()));
        
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
            .addGap(0, 0, Short.MAX_VALUE)
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

    
    public void cargarSetups(int nSetups,String[][] listaNombres){
        
        for(int i=0;i<nSetups;i++){
            
            // Posición horizontal
            int espacio = 30;
            int anchura = 100;
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
            
            // Jugador 1
            JLabel j1 = new JLabel();
            j1.setText(listaNombres[i][0]);
            j1.setBounds(k, 30, anchura, 30);
            jPanel1.add(j1);
            
            // Jugador 2
            JLabel j2 = new JLabel();
            j2.setText(listaNombres[i][1]);
            j2.setBounds(k, 60, anchura, 30);
            jPanel1.add(j2);
            
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
    
    public void cargarCola(String[][] array_nombres){
                    
        DefaultListModel listModel = new DefaultListModel();
        JScrollPane scrollPane = new JScrollPane();
        
        for(int i=0;i<array_nombres.length;i++){       
            listModel.addElement(array_nombres[i][0]+" vs "+array_nombres[i][1]);
        }
        
        JList list = new JList(listModel);
        list.setVisibleRowCount(4);
        scrollPane.setViewportView(list);
        scrollPane.setSize(250,150);
        scrollPane.setBounds(50, 10, 250, 150);
        jPanel2.add(scrollPane);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String parsed = comando.substring(comando.length() - 1);

        Iterator it = listForm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            
            String o_key = entry.getKey().toString();
            //System.out.println("Key - "+o_key);
            
            String key = o_key.substring(o_key.length() - 1);
            //System.out.println("SubKey - "+key);
            
            if(key.equals(parsed)){
                JTextField texto = (JTextField) entry.getValue();
                System.out.println("Valor: "+texto.getText());
            }
        }
    }
   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
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
