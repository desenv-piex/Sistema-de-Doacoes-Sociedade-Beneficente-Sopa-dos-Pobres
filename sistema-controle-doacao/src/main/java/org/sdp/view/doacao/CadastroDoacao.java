/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.sdp.view.doacao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.sdp.database.dao.doacao.DoacaoDao;
import org.sdp.database.dao.doacao.DoacaoProdutoDao;
import org.sdp.database.dao.produto.ProdutoDao;
import org.sdp.model.Doacao;
import org.sdp.model.DoacaoProduto;
import org.sdp.model.Produto;
import org.sdp.model.e.ETipoDoacao;

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
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/icon_sopa.png")).getImage());

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
        cbTipoDoacao = new javax.swing.JComboBox<>();
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
        labelvalor = new javax.swing.JLabel();
        jBtnSalvarValor = new javax.swing.JButton();
        jBtnSalvarPRoduto = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jBtnRemoverSelecionados = new javax.swing.JButton();
        CampoValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(254, 240, 218));

        cbTipoDoacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doação de Produto", "Doação de Valores" }));
        cbTipoDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDoacaoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Doação:");

        jTProdutosSelecionados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTProdutosSelecionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produtos", "Qtde Doada [PREENCHER]"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produtos Cadastrados", "Valor Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTProdutosCadastrados);

        jlProdutos2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlProdutos2.setText("Produtos doados:");

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
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saida2.png"))); // NOI18N
        btnVoltar.setText("Sair");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jBtnRemoverSelecionados.setBackground(new java.awt.Color(255, 153, 153));
        jBtnRemoverSelecionados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jBtnRemoverSelecionados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jBtnRemoverSelecionados.setText("Remover selecionados");
        jBtnRemoverSelecionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverSelecionadosActionPerformed(evt);
            }
        });

        CampoValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnSalvarPRoduto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(labelvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(CampoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBtnSalvarValor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlProdutos2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBPesquisa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtnRemoverSelecionados)))))
                .addContainerGap())
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
                    .addComponent(cbTipoDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnRemoverSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlProdutos2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jBtnSalvarPRoduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelecionarActionPerformed
        int[] rowsSelected = jTProdutosCadastrados.getSelectedRows();

        if (allProdutosSelected == null) {
            allProdutosSelected = new ArrayList<>();
        }

        for (int i = 0; i < rowsSelected.length; i++) {
            int selectedIndex = rowsSelected[i];
            if (selectedIndex >= 0 && selectedIndex < allProdutos.size()) {
                Produto selectedProduto = allProdutos.get(selectedIndex);

                if (!allProdutosSelected.contains(selectedProduto)) {
                    allProdutosSelected.add(selectedProduto);
                }
            }
        }

        preencheTableSelecionados(allProdutosSelected);
    }//GEN-LAST:event_jBtnSelecionarActionPerformed

    private void jBtnSalvarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarValorActionPerformed
        if (cbTipoDoacao.getSelectedIndex() == -1 || CampoValor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar! ");
            return;
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        double valor = Double.parseDouble(CampoValor.getText().replace(',','.'));
        Doacao d = new Doacao(null, ETipoDoacao.Dinheiro, null, date, valor);

        try {
            new DoacaoDao().cadastrar(d);
            JOptionPane.showMessageDialog(null, "Doacao cadastrada com sucesso! ");
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a doacao no banco de dados. " + ex.getMessage());
        }

    }//GEN-LAST:event_jBtnSalvarValorActionPerformed

    private void jBtnSalvarPRodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvarPRodutoActionPerformed
        if (cbTipoDoacao.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de salvar! ");
            return;
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        try {

            Doacao d = new Doacao(null, ETipoDoacao.Produtos, null, date, 0);
            d = new DoacaoDao().cadastrarComRetorno(d);

            List<DoacaoProduto> dps = new ArrayList<>();

            int i = 0;
            for (Produto prod : allProdutosSelected) {
                DoacaoProduto dp = new DoacaoProduto(null, d, prod, Integer.parseInt((String) jTProdutosSelecionados.getValueAt(i,1)));
                dps.add(dp);
                i++;
            }

            new DoacaoProdutoDao().cadastrarList(dps);

            JOptionPane.showMessageDialog(null, "Doacao cadastrada com sucesso! ");
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a doacao no banco de dados. " + ex.getMessage());
        }

    }//GEN-LAST:event_jBtnSalvarPRodutoActionPerformed

    private void cbTipoDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDoacaoActionPerformed
        // TODO add your handling code here:
        if(cbTipoDoacao.getSelectedItem().toString().equals("Doação de Valores")){
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
    }//GEN-LAST:event_cbTipoDoacaoActionPerformed

    private void jBPesquisa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisa1ActionPerformed
        try {
            allProdutos = new ProdutoDao().buscarPorNomeProduto("%"+jlPesquisarProduto.getText()+"%");

            preencheTable(allProdutos);
        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o banco de dados para consultar os produtos. " + ex.getMessage());
        }
    }//GEN-LAST:event_jBPesquisa1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            allProdutos = new ProdutoDao().buscarTodos();

            preencheTable(allProdutos);

        } catch (PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar o banco de dados para consultar os produtos. " + ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void jBtnRemoverSelecionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverSelecionadosActionPerformed

        int[] rowsSelected = jTProdutosSelecionados.getSelectedRows();

        if (allProdutosSelected == null) {
            allProdutosSelected = new ArrayList<>();
        }

        for (int i = rowsSelected.length - 1; i >= 0; i--) {
            int rowIndex = rowsSelected[i];
            if (rowIndex >= 0 && rowIndex < allProdutosSelected.size()) {
                allProdutosSelected.remove(rowIndex);
            }
        }

        preencheTableSelecionados(allProdutosSelected);
    }//GEN-LAST:event_jBtnRemoverSelecionadosActionPerformed



    private List<Produto> allProdutos = new ArrayList<>();

    private List<Produto> allProdutosSelected = new ArrayList<>();;
    public List<Produto> getAllProdutos() {
        return allProdutos;
    }

    public List<Produto> getAllProdutosSelected() {
        return allProdutosSelected;
    }

    private void preencheTable(List<Produto> allProdutos){
        DefaultTableModel dtm = (DefaultTableModel) jTProdutosCadastrados.getModel();

        while(dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        for(Produto p : allProdutos) {
            String[] linha = { p.getNomeProduto(), p.getValorProduto()+""};
            dtm.addRow(linha);
        }
    }

    private void preencheTableSelecionados(List<Produto> allProdutosSelecionados){
        DefaultTableModel dtm = (DefaultTableModel) jTProdutosSelecionados.getModel();

        while(dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }

        for(Produto p : allProdutosSelecionados) {
            String[] linha = { p.getNomeProduto(), 1+"",p.getValorProduto()+""};
            dtm.addRow(linha);
        }

    }
    

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
    private javax.swing.JFormattedTextField CampoValor;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbTipoDoacao;
    private javax.swing.JButton jBPesquisa1;
    private javax.swing.JButton jBtnRemoverSelecionados;
    private javax.swing.JButton jBtnSalvarPRoduto;
    private javax.swing.JButton jBtnSalvarValor;
    private javax.swing.JButton jBtnSelecionar;
    private javax.swing.JLabel jLProdutos1;
    private javax.swing.JLabel jLabel1;
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