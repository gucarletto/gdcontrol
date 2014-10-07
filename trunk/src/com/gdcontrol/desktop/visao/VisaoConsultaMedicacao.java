package com.gdcontrol.desktop.visao;

import com.gdcontrol.desktop.controle.consulta.ControleConsultaMedicacao;
import com.gdcontrol.desktop.controle.manutencao.ControleManutencaoMedicacao;
import com.gdcontrol.desktop.util.tablemodel.MedicacaoTableModel;
import com.gdcontrol.entidade.Medicacao;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class VisaoConsultaMedicacao extends VisaoConsultaPadrao {

    private static final String OPCAO_ID = "ID";
    private static final String OPCAO_MARCA = "Marca";
    private static final String OPCAO_NOME_COMERCIAL = "Nome Comercial";
    private static final String OPCAO_NOME_QUIMICO = "Nome Químico";
    private static final String OPCAO_UNIDADE = "Unidade";

    /**
     * Creates new form VisaoConsultaMedicamento
     */
    public VisaoConsultaMedicacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregaGrupoAlimentos();
        getOpcoesPesquisa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMedicacao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCampoPesquisa = new javax.swing.JComboBox();
        edPesquisa = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        tbMedicacao.setModel(tableModelMedicacao);
        tbMedicacao.setToolTipText("");
        jScrollPane1.setViewportView(tbMedicacao);

        jLabel1.setText("Campo Pesquisa:");

        jLabel2.setText("Pesquisa:");

        edPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edPesquisaKeyPressed(evt);
            }
        });

        btPesquisa.setText("Pesquisar");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisa)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(cbCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btPesquisa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        VisaoManutencaoMedicacao manutencao = new VisaoManutencaoMedicacao(null, true);
        manutencao.setVisible(true);
        carregaGrupoAlimentos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int indice = tbMedicacao.getSelectedRow();
        if (indice >= 0) {
            int opcao = JOptionPane.showConfirmDialog(this, "Confirma exclusão da Medicação selecionada?");
            if (opcao == JOptionPane.YES_OPTION) {
                getControle().excluir(tableModelMedicacao.getMedicacao(indice));
                carregaGrupoAlimentos();
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int indice = tbMedicacao.getSelectedRow();
        if (indice >= 0) {
            VisaoManutencaoMedicacao manutencao = new VisaoManutencaoMedicacao(null, true);
            ControleManutencaoMedicacao controle = (ControleManutencaoMedicacao) manutencao.getControle();
            controle.setModelo(tableModelMedicacao.getMedicacao(indice));
            controle.setTela(manutencao);
            controle.carregaTela();
            manutencao.setVisible(true);
            carregaGrupoAlimentos();
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        if (!edPesquisa.getText().isEmpty()) {
            tableModelMedicacao.limpar();
            String pesquisa = (String) cbCampoPesquisa.getSelectedItem();
            switch (pesquisa) {
                case OPCAO_ID:
                    try {
                        filtraId(Integer.parseInt(edPesquisa.getText()));
                    } catch (NumberFormatException e) {
                    }
                    break;
                case OPCAO_MARCA:
                    filtraMarca(edPesquisa.getText());
                    break;
                case OPCAO_NOME_COMERCIAL:
                    filtraNomeComercial(edPesquisa.getText());
                    break;
                case OPCAO_NOME_QUIMICO:
                    filtraNomeQuimico(edPesquisa.getText());
                    break;
                case OPCAO_UNIDADE:
                    filtraUnidade(edPesquisa.getText());
                    break;
            }
            tableModelMedicacao.fireTableDataChanged();
        } else {
            carregaGrupoAlimentos();
        }
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void edPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btPesquisaActionPerformed(null);
        }
    }//GEN-LAST:event_edPesquisaKeyPressed

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
            java.util.logging.Logger.getLogger(VisaoConsultaMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoConsultaMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoConsultaMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoConsultaMedicacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisaoConsultaMedicacao dialog = new VisaoConsultaMedicacao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JComboBox cbCampoPesquisa;
    private javax.swing.JTextField edPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMedicacao;
    // End of variables declaration//GEN-END:variables

    private MedicacaoTableModel tableModelMedicacao = new MedicacaoTableModel();
    private ControleConsultaMedicacao controle = new ControleConsultaMedicacao();

    @Override
    public ControleConsultaMedicacao getControle() {
        return this.controle;
    }

    private void carregaGrupoAlimentos() {
        tableModelMedicacao.limpar();
        for (Medicacao med : (List<Medicacao>) getControle().listar()) {
            tableModelMedicacao.addMedicacao(med);
        }
        tableModelMedicacao.fireTableDataChanged();
    }

    private void filtraId(int id) {
        Medicacao med = getControle().filtraId(id);
        tableModelMedicacao.addMedicacao(med);
    }

    private void filtraMarca(String marca) {
        for (Medicacao med : (List<Medicacao>) getControle().filtraMarca(marca)) {
            tableModelMedicacao.addMedicacao(med);
        }
    }

    private void filtraNomeComercial(String nome) {
        for (Medicacao med : (List<Medicacao>) getControle().filtraNomeComercial(nome)) {
            tableModelMedicacao.addMedicacao(med);
        }
    }

    private void filtraNomeQuimico(String nome) {
        for (Medicacao med : (List<Medicacao>) getControle().filtraNomeQuimico(nome)) {
            tableModelMedicacao.addMedicacao(med);
        }
    }

    private void filtraUnidade(String und) {
        for (Medicacao med : (List<Medicacao>) getControle().filtraUnidade(und)) {
            tableModelMedicacao.addMedicacao(med);
        }
    }

    @Override
    public void getOpcoesPesquisa() {
        Vector comboBoxItems = new Vector();
        comboBoxItems.add(OPCAO_ID);
        comboBoxItems.add(OPCAO_MARCA);
        comboBoxItems.add(OPCAO_NOME_COMERCIAL);
        comboBoxItems.add(OPCAO_NOME_QUIMICO);
        comboBoxItems.add(OPCAO_UNIDADE);
        final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
        this.cbCampoPesquisa.setModel(model);
    }
}
