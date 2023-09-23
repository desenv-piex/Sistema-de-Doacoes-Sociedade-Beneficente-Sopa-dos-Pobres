/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.sdp.view;

/**
 *
 * @author anacl
 */
public class CadastroDoacao extends javax.swing.JDialog {

    /**
     * Creates new form CadastroProduto
     */
    public CadastroDoacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
       jBtnSalvarValor.setVisible(false);
       CampoValor.setVisible(false);
       labelvalor.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cbTipoDoação = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutosSelecionados = new javax.swing.JTable();
        jLProdutos1 = new javax.swing.JLabel();
        jlPesquisarProduto = new javax.swing.JTextField();
        jBPesquisa1 = new javax.swing.JButton();
        jBtnSelecionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTProdutosCadastrados = new javax.swing.JTable();
        jlProdutos2 = new javax.swing.JLabel();
        CampoValor = new javax.swing.JTextField();
        labelvalor = new javax.swing.JLabel();
        jBtnSalvarValor = new javax.swing.JButton();
        jBtnSalvarPRoduto = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(254, 240, 218));

        cbTipoDoação.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doação de Produto", "Doação de Valores" }));
        cbTipoDoação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDoaçãoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Doação:");

        jTProdutosSelecionados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTProdutosSelecionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produtos", "Qtde Doada [PREENCHER]", "Valor Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTProdutosSelecionados);

        jLProdutos1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLProdutos1.setText("Selecionar Produto(s):");

        jBPesquisa1.setBackground(new java.awt.Color(218, 209, 187));
        jBPesquisa1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBPesquisa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBPesquisa1.setText("Pesquisar");
        jBPesquisa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisa1ActionPerformed(evt);
            }
        });

        jBtnSelecionar.setBackground(new java.awt.Color(206, 187, 159));
        jBtnSelecionar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selecionar.png"))); // NOI18N
        jBtnSelecionar.setText("Selecionar");
        jBtnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelecionarActionPerformed(evt);
            }
        });

        jTProdutosCadastrados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTProdutosCadastrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Produtos Cadastrados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTProdutosCadastrados);

        jlProdutos2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlProdutos2.setText("Produtos doados:");

        CampoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoValorActionPerformed(evt);
            }
        });

        labelvalor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelvalor.setText("Valor Doado:");

        jBtnSalvarValor.setBackground(new java.awt.Color(117, 181, 47));
        jBtnSalvarValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnSalvarValor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doacao.png"))); // NOI18N
        jBtnSalvarValor.setText("Salvar");
        jBtnSalvarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarValorActionPerformed(evt);
            }
        });

        jBtnSalvarPRoduto.setBackground(new java.awt.Color(117, 181, 47));
        jBtnSalvarPRoduto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnSalvarPRoduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doacao.png"))); // NOI18N
        jBtnSalvarPRoduto.setText("Salvar");
        jBtnSalvarPRoduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvarPRodutoActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(207, 180, 120));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saida.png"))); // NOI18N
        btnVoltar.setText("Sair");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnSalvarPRoduto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBPesquisa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlProdutos2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoDoação, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CampoValor)
                                .addGap(38, 38, 38)
                                .addComponent(jBtnSalvarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelvalor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoDoação, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalvarValor)
                    .addComponent(CampoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLProdutos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBPesquisa1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnSelecionar)))
                .addGap(34, 34, 34)
                .addComponent(jlProdutos2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jBtnSalvarPRoduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenuBar2.setBackground(new java.awt.Color(59, 31, 27));
        jMenuBar2.setToolTipText("");

        jMenu3.setText("Cadastros");

        jMenu8.setText("Cadastro de Doação ");
        jMenu3.add(jMenu8);

        jMenu7.setText("Cadastro de Produto");
        jMenu3.add(jMenu7);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Relatórios");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Ajuda");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Sair");
        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelecionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSelecionarActionPerformed

    private void jBtnSalvarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSalvarValorActionPerformed

    private void CampoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoValorActionPerformed

    private void jBtnSalvarPRodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarPRodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSalvarPRodutoActionPerformed

    private void cbTipoDoaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDoaçãoActionPerformed
        // TODO add your handling code here:
        if(cbTipoDoação.getSelectedItem().toString().equals("Doação de Valores")){
            jBtnSalvarValor.setVisible(true);
            CampoValor.setVisible(true);
            labelvalor.setVisible(true);
            jBPesquisa1.setVisible(false);
            jBtnSalvarPRoduto.setVisible(false);
            jBtnSelecionar.setVisible(false);
            jLProdutos1.setVisible(false);
            jlProdutos2.setVisible(false);
            jlPesquisarProduto.setVisible(false);
            jTProdutosCadastrados.setVisible(false);
            jTProdutosSelecionados.setVisible(false);
        }else{
            jBtnSalvarValor.setVisible(false);
            CampoValor.setVisible(false);
            labelvalor.setVisible(false);
            jBPesquisa1.setVisible(true);
            jBtnSalvarPRoduto.setVisible(true);
            jBtnSelecionar.setVisible(true);
            jLProdutos1.setVisible(true);
            jlProdutos2.setVisible(true);
            jlPesquisarProduto.setVisible(true);
            jTProdutosCadastrados.setVisible(true);
            jTProdutosSelecionados.setVisible(true);
        }
    }//GEN-LAST:event_cbTipoDoaçãoActionPerformed

    private void jBPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBPesquisa1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CadastroDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDoacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroDoacao dialog = new CadastroDoacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoValor;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbTipoDoação;
    private javax.swing.JButton jBPesquisa1;
    private javax.swing.JButton jBtnSalvarPRoduto;
    private javax.swing.JButton jBtnSalvarValor;
    private javax.swing.JButton jBtnSelecionar;
    private javax.swing.JLabel jLProdutos1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTProdutosCadastrados;
    private javax.swing.JTable jTProdutosSelecionados;
    private javax.swing.JTextField jlPesquisarProduto;
    private javax.swing.JLabel jlProdutos2;
    private javax.swing.JLabel labelvalor;
    // End of variables declaration//GEN-END:variables
}