package View;

import Dao.ClienteDAO;
import Model.Lista;
import Model.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaCliente extends javax.swing.JFrame {

    public String user_login;

    public ListaCliente(String login) {
        this.user_login = login;
        initComponents();
        getDataTableLista();
        setLocationRelativeTo(null);
    }

    public ListaCliente() {

    }

    private ArrayList<Lista> getDataTableLista() {
        int i;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // atribui 0 linhas à coluna
        model.setNumRows(0);
        // atribui um tamanho fixo a coluna codigo
        //jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
        ArrayList<Lista> listListas = new ArrayList<Lista>();
        listListas = new ClienteDAO().getListaCliente(user_login);
        //adiciona alunos as tabelas
        for (i = 0; i <= listListas.size() - 1; i++) {
            //Mostra apenas listas não cotadas
            if(listListas.get(i).getDataCotacao()==null){
                model.addRow(new Object[]{listListas.get(i).getIdLista(), listListas.get(i).getNomeLista()});
            }
        }
        return listListas;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bCriarLista = new javax.swing.JButton();
        bExcluirLista = new javax.swing.JButton();
        bGerarCotacao = new javax.swing.JButton();
        bEditarLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(64, 140, 206));

        jbtnSair.setBackground(new java.awt.Color(60, 104, 138));
        jbtnSair.setForeground(new java.awt.Color(254, 254, 254));
        jbtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/sign-out.png"))); // NOI18N
        jbtnSair.setText("Sair");
        jbtnSair.setBorder(null);
        jbtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSairActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/logo sisco.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Noto Sans", 2, 18)); // NOI18N
        jLabel2.setText("Sistema de Cotação - SISCO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(jbtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome da Lista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bCriarLista.setText("Criar Nova Lista");
        bCriarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCriarListaActionPerformed(evt);
            }
        });

        bExcluirLista.setLabel("Excluir Lista");
        bExcluirLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirListaActionPerformed(evt);
            }
        });

        bGerarCotacao.setText("Gerar Cotação");
        bGerarCotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGerarCotacaoActionPerformed(evt);
            }
        });

        bEditarLista.setText("Editar Lista");
        bEditarLista.setName(""); // NOI18N
        bEditarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bCriarLista)
                        .addGap(18, 18, 18)
                        .addComponent(bEditarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bGerarCotacao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bExcluirLista, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCriarLista)
                    .addComponent(bEditarLista)
                    .addComponent(bGerarCotacao)
                    .addComponent(bExcluirLista))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSairActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnSairActionPerformed

    private void bCriarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCriarListaActionPerformed
        Cliente cli = new Cliente(user_login, 0,null);
        cli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bCriarListaActionPerformed

    private void bGerarCotacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGerarCotacaoActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            int idLista = Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            //String nomeLista = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
            
            ClienteDAO cliente = new ClienteDAO();
            cliente.gerarCotacao(idLista);
            this.dispose();
        }
    }//GEN-LAST:event_bGerarCotacaoActionPerformed

    private void bExcluirListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirListaActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRow() >= 0) {

            if (!jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().isEmpty()) {
                ClienteDAO cliente = new ClienteDAO();
                cliente.excluirLista(Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            }

            dtm.removeRow(jTable1.getSelectedRow());
            jTable1.setModel(dtm);
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar uma lista.");
        }
    }//GEN-LAST:event_bExcluirListaActionPerformed

    private void bEditarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarListaActionPerformed
        if (jTable1.getSelectedRow() >= 0) {
            int idLista = Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            String nomeLista = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
            
            Cliente cli = new Cliente(user_login, idLista, nomeLista);
            cli.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_bEditarListaActionPerformed

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
            java.util.logging.Logger.getLogger(ListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCriarLista;
    private javax.swing.JButton bEditarLista;
    private javax.swing.JButton bExcluirLista;
    private javax.swing.JButton bGerarCotacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnSair;
    // End of variables declaration//GEN-END:variables

}
