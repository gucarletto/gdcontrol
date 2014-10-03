package com.gdcontrol.desktop.visao;

import com.gdcontrol.desktop.controle.ControleMedico;
import com.gdcontrol.desktop.controle.ControlePadrao;
import com.gdcontrol.desktop.util.tablemodel.MedicoTableModel;
import com.gdcontrol.entidade.Medico;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class VisaoConsultaMedico extends VisaoConsultaPadrao {
    
    public final static String OPCAO_ID = "ID";
    public final static String OPCAO_NOME = "Nome";
    public final static String OPCAO_TELEFONE = "Telefone";
    public final static String OPCAO_CRM = "CRM";
    public final static String OPCAO_ESPECIALIZACAO = "Especialização";

    /**
     * Creates new form VisaoConsultaMedico
     */
    public VisaoConsultaMedico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregaMedicos();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCampoPesquisa = new javax.swing.JComboBox();
        edPesquisa = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMedicos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        tbMedicos.setModel(tableModelMedico);
        tbMedicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMedicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMedicos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cbCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisa))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        VisaoManutencaoMedico manutencaoMedico = new VisaoManutencaoMedico(null, true);
        manutencaoMedico.setVisible(true);
        carregaMedicos();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int indice = tbMedicos.getSelectedRow();
        if (indice >= 0) {
            int opcao = JOptionPane.showConfirmDialog(this, "Confirma exclusão do Médico selecionado?");
            if(opcao == JOptionPane.YES_OPTION){
                getControle().excluir(tableModelMedico.getMedico(indice));
                carregaMedicos();
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int indice = tbMedicos.getSelectedRow();
        if (indice >= 0) {
            VisaoManutencaoMedico manutencao = new VisaoManutencaoMedico(null, true);
            ControleMedico controleManutencao = (ControleMedico) manutencao.getControle();
            controleManutencao.setModelo(tableModelMedico.getMedico(indice));
            controleManutencao.setTela(manutencao);
            controleManutencao.carregaTela();
            manutencao.setVisible(true);
            carregaMedicos();
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tbMedicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMedicosMouseClicked
        if (evt.getClickCount() == 2) {
            btAlterarActionPerformed(null);
        }
    }//GEN-LAST:event_tbMedicosMouseClicked

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
        if(!edPesquisa.getText().isEmpty()){
            tableModelMedico.limpar();
            String pesquisa = (String) cbCampoPesquisa.getSelectedItem();
            switch(pesquisa){
                case OPCAO_ID:
                    try{
                        filtraId(Integer.parseInt(edPesquisa.getText()));
                    }catch(NumberFormatException e){}
                    break;
                case OPCAO_NOME:
                    filtraNome(edPesquisa.getText());
                    break;
                case OPCAO_TELEFONE:
                    filtraTelefone(edPesquisa.getText());
                    break;
                case OPCAO_CRM:
                    filtraCrm(edPesquisa.getText());
                    break;
                case OPCAO_ESPECIALIZACAO:
                    filtraEspecializacao(edPesquisa.getText());
                    break;
            }
            tableModelMedico.fireTableDataChanged();
        }else{
            carregaMedicos();
        }
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void edPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edPesquisaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
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
            java.util.logging.Logger.getLogger(VisaoConsultaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoConsultaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoConsultaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoConsultaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisaoConsultaMedico dialog = new VisaoConsultaMedico(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tbMedicos;
    // End of variables declaration//GEN-END:variables

    ControleMedico controle = new ControleMedico();
    MedicoTableModel tableModelMedico = new MedicoTableModel();
    
    private void carregaMedicos() {
        tableModelMedico.limpar();
        for (Medico grp : (List<Medico>) getControle().listar()) {
            tableModelMedico.addMedico(grp);
        }
        tableModelMedico.fireTableDataChanged();
    }
    
    private void filtraId(int id){
        for (Medico med : (List<Medico>) getControle().listar()) {
            if(med.getId() == id){
                tableModelMedico.addMedico(med);
                break;
            }
        }
    }
    
    private void filtraNome(String nome){
        for (Medico med : (List<Medico>) getControle().listar()) {
            if(med.getNome().toUpperCase().contains(nome.toUpperCase())){
                tableModelMedico.addMedico(med);
            }
        }
    }
    
    private void filtraTelefone(String telefone){
        for (Medico med : (List<Medico>) getControle().listar()) {
            if(med.getTelefone().toUpperCase().contains(telefone.toUpperCase())){
                tableModelMedico.addMedico(med);
            }
        }
    }
    
    private void filtraCrm(String crm){
        for (Medico med : (List<Medico>) getControle().listar()) {
            if(med.getCrm().toUpperCase().contains(crm.toUpperCase())){
                tableModelMedico.addMedico(med);
            }
        }
    }
    
    private void filtraEspecializacao(String espec){
        for (Medico med : (List<Medico>) getControle().listar()) {
            if(med.getEspecializacao().toUpperCase().contains(espec.toUpperCase())){
                tableModelMedico.addMedico(med);
            }
        }
    }
    
    @Override
    public void getOpcoesPesquisa() {
        Vector comboBoxItems = new Vector();
        comboBoxItems.add(OPCAO_ID);
        comboBoxItems.add(OPCAO_NOME);
        comboBoxItems.add(OPCAO_TELEFONE);
        comboBoxItems.add(OPCAO_CRM);
        comboBoxItems.add(OPCAO_ESPECIALIZACAO);
        final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
        this.cbCampoPesquisa.setModel(model);
    }

    @Override
    public ControlePadrao getControle() {
        return this.controle;
    }
}
