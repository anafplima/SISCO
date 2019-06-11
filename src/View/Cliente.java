package View;

import Model.*;
import Dao.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cliente extends javax.swing.JFrame {

    public String user_login;
    public int idLista;

    public Cliente(String login, int idLista,String nomeLista) {
        this.user_login = login;
        this.idLista = idLista;
        initComponents();
        setLocationRelativeTo(null);
        getDataTableProduto();
        getDataTableListaCliente();
        if (idLista != 0) {
            lidLista.setText(String.valueOf(idLista));
            tNomeLista.setText(nomeLista);
        }
        System.out.println(user_login);
    }

    public Cliente() {
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
        bIncluirnaLista = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        bSalvarLista = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tNomeLista = new javax.swing.JTextField();
        lidLista = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
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

            },
            new String [] {
                "Cod", "Nome do Produto", "Peso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        bIncluirnaLista.setText("Incluir Item na Lista");
        bIncluirnaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIncluirnaListaActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                "Nome do Produto", "Peso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setText("Selecione o produto da lista:");

        bSalvarLista.setText("Salvar Lista");
        bSalvarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarListaActionPerformed(evt);
            }
        });

        bExcluir.setText("Excluir Item");
        bExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        jLabel5.setText("Nome da Lista:");

        lidLista.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bIncluirnaLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bSalvarLista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bExcluir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lidLista, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addComponent(tNomeLista, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(bIncluirnaLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tNomeLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lidLista, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bExcluir)
                    .addComponent(bSalvarLista))
                .addContainerGap())
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

    private void bSalvarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarListaActionPerformed

        if (tNomeLista.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inserir Nome da Lista.");
            System.out.println("Nome da Lista vazio");
        } else {
            ClienteDAO cliente = new ClienteDAO();
            int idLista = 0;
            int idUsuario = cliente.getUsuario(user_login);
            String nomeLista;
            if (!lidLista.getText().isEmpty()) {
                idLista = Integer.valueOf(lidLista.getText());
            }
            nomeLista = tNomeLista.getText();
            Lista lista = new Lista(idLista, idUsuario, nomeLista, null, 0);
            idLista = cliente.salvarListaCliente(lista);

            if (idLista != 0) {

                Produto produto;
                ArrayList<Item> listItem = new ArrayList<Item>();

                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    String nomeProduto, aux;
                    String array[] = new String[2];
                    int idProduto, idItem = 0;
                    Item item = new Item();

                    if (!jTable1.getValueAt(i, 0).toString().isEmpty()) {
                        idItem = Integer.valueOf(jTable1.getValueAt(i, 0).toString());
                    }
                    item.setIdItem(idItem);
                    System.out.println(idItem);

                    item.setIdLista(idLista);
                    System.out.println(idLista);

                    produto = new Produto();
                    aux = (String) jTable1.getValueAt(i, 1).toString();
                    System.out.println(aux);
                    array = aux.split(":");// Agua (Ref:2)
                    nomeProduto = array[0].replace(" (Ref", "");
                    idProduto = Integer.valueOf(array[1].replace(")", ""));
                    produto.setCodigo(idProduto);
                    System.out.println(idProduto);
                    produto.setNome(nomeProduto);
                    System.out.println(nomeProduto);
                    produto.setPeso((String) jTable1.getValueAt(i, 2).toString());
                    item.setProduto(produto);

                    listItem.add(item);
                }
                if (cliente.salvarItemListaCliente(listItem)) {
                    JOptionPane.showMessageDialog(null, "Lista salva com sucesso");
                    this.dispose();
                } else {
                   JOptionPane.showMessageDialog(null, "Erro ao salvar itens da lista, tente novamente.");
                }

                //getDataTableListaCliente();
            } else {
                System.out.println("Erro ao Salvar lista, tente novamente.");
                JOptionPane.showMessageDialog(null, "Erro ao Salvar lista, tente novamente.");
            }
        }
    }//GEN-LAST:event_bSalvarListaActionPerformed

    private void bIncluirnaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIncluirnaListaActionPerformed

        DefaultTableModel modelAdiciona = (DefaultTableModel) jTable1.getModel();

        Object[] produto_selecionados = {"", jTable2.getValueAt(jTable2.getSelectedRow(), 0), jTable2.getValueAt(jTable2.getSelectedRow(), 1)};

        modelAdiciona.addRow(produto_selecionados);

        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.removeRow(jTable2.getSelectedRow());
        jTable2.setModel(dtm);
    }//GEN-LAST:event_bIncluirnaListaActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRow() >= 0) {
            /*DefaultTableModel modelAdiciona = (DefaultTableModel) jTable2.getModel();
            Object[] produto_selecionados = {jTable1.getValueAt(jTable1.getSelectedRow(), 1), jTable1.getValueAt(jTable1.getSelectedRow(), 2)};
            modelAdiciona.addRow(produto_selecionados);*/

            if (!jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString().isEmpty()) {
                ClienteDAO cli = new ClienteDAO();
                cli.excluirItem(Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
            }

            dtm.removeRow(jTable1.getSelectedRow());
            jTable1.setModel(dtm);

            getDataTableProduto();
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
    }//GEN-LAST:event_bExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(Fornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Fornecedor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bIncluirnaLista;
    private javax.swing.JButton bSalvarLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbtnSair;
    private javax.swing.JLabel lidLista;
    private javax.swing.JTextField tNomeLista;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Produto> getDataTableProduto() {
        int i;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        // atribui 0 linhas à coluna
        model.setNumRows(0);
        // atribui um tamanho fixo a coluna codigo
        //jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
        ArrayList<Produto> listProdutos = new ArrayList<Produto>();
        listProdutos = new ClienteDAO().getListaProduto(idLista);
        //adiciona alunos as tabelas
        for (i = 0; i <= listProdutos.size() - 1; i++) {
            model.addRow(new Object[]{listProdutos.get(i).getNome() + " (Ref:" + listProdutos.get(i).getCodigo() + ")", listProdutos.get(i).getPeso()});
        }
        return listProdutos;

    }

    private ArrayList<Item> getDataTableListaCliente() {
        int i;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // atribui 0 linhas à coluna
        model.setNumRows(0);
        // atribui um tamanho fixo a coluna codigo
        //jTable1.getColumnModel().getColumn(0).setPreferredWidth(2);
        ArrayList<Item> listItem = new ArrayList<Item>();
        listItem = new ClienteDAO().getListaProdutoCliente(idLista);
        //adiciona alunos as tabelas
        for (i = 0; i <= listItem.size() - 1; i++) {
            model.addRow(new Object[]{listItem.get(i).getIdItem(), listItem.get(i).getProduto().getNome() + " (Ref:" + listItem.get(i).getProduto().getCodigo() + ")", listItem.get(i).getProduto().getPeso(), listItem.get(i).getValorCotacao()});
        }
        return listItem;
    }

}
