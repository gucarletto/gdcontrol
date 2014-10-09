package com.gdcontrol.desktop.visao;

import com.gdcontrol.desktop.visao.consulta.VisaoConsultaAlimento;
import com.gdcontrol.desktop.visao.consulta.VisaoConsultaGrupoAlimento;
import com.gdcontrol.desktop.visao.consulta.VisaoConsultaLocalAplicacao;
import com.gdcontrol.desktop.visao.consulta.VisaoConsultaMedico;
import com.gdcontrol.desktop.visao.consulta.VisaoConsultaTipoEvento;
import com.gdcontrol.desktop.visao.consulta.VisaoConsultaTipoTeste;
import com.gdcontrol.desktop.visao.consulta.VisaoConsultaMedicacao;
import com.gdcontrol.desktop.visao.manutencao.VisaoManutencaoUsuario;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author gustavo
 */
public class VisaoPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ViewPrincipal
     */
    public VisaoPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btMedicamentos = new javax.swing.JButton();
        btGrupoAlimento = new javax.swing.JButton();
        btUsuario = new javax.swing.JButton();
        btAlimento = new javax.swing.JButton();
        btRefeicao = new javax.swing.JButton();
        btAplicacao = new javax.swing.JButton();
        btLocalAplicacao = new javax.swing.JButton();
        btMedico = new javax.swing.JButton();
        btPosologia = new javax.swing.JButton();
        btTipoTeste = new javax.swing.JButton();
        btTeste = new javax.swing.JButton();
        btSincronizacao = new javax.swing.JButton();
        btRelatorios = new javax.swing.JButton();
        btTipoEvento = new javax.swing.JButton();
        btEvento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GD-Control");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setName("viewPrincipal"); // NOI18N

        btMedicamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/icone_medicamentos_2.png"))); // NOI18N
        btMedicamentos.setIconTextGap(6);
        btMedicamentos.setMaximumSize(new java.awt.Dimension(135, 137));
        btMedicamentos.setMinimumSize(new java.awt.Dimension(135, 137));
        btMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMedicamentosMouseClicked(evt);
            }
        });
        btMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedicamentosActionPerformed(evt);
            }
        });

        btGrupoAlimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/grupoAlimento.png"))); // NOI18N
        btGrupoAlimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btGrupoAlimentoMouseClicked(evt);
            }
        });
        btGrupoAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGrupoAlimentoActionPerformed(evt);
            }
        });

        btUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/icone_perfil.png"))); // NOI18N
        btUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUsuarioActionPerformed(evt);
            }
        });

        btAlimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/alimento.png"))); // NOI18N
        btAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlimentoActionPerformed(evt);
            }
        });

        btRefeicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/refeicao.png"))); // NOI18N

        btAplicacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/aplicacao.png"))); // NOI18N

        btLocalAplicacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/localAplicacao.png"))); // NOI18N
        btLocalAplicacao.setBorder(new javax.swing.border.MatteBorder(null));
        btLocalAplicacao.setPreferredSize(new java.awt.Dimension(68, 68));
        btLocalAplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocalAplicacaoActionPerformed(evt);
            }
        });

        btMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/medico.png"))); // NOI18N
        btMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMedicoActionPerformed(evt);
            }
        });

        btPosologia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/posologia.png"))); // NOI18N

        btTipoTeste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/tipo_teste.png"))); // NOI18N
        btTipoTeste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTipoTesteMouseClicked(evt);
            }
        });

        btTeste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/teste.png"))); // NOI18N

        btSincronizacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/sincronizacao.png"))); // NOI18N

        btRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/relatorios.png"))); // NOI18N

        btTipoEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/icone_tipo_evento.png"))); // NOI18N
        btTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTipoEventoActionPerformed(evt);
            }
        });

        btEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/evento.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Perfil");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Médico");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Grupo Alimento");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Alimento");

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Refeição");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Medicação");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Prescrição");

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Local Aplicação");

        jLabel9.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Aplicação");

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tipo Teste");

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Teste");

        jLabel12.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Tipo Evento");

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Evento");

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sincronização");

        jLabel15.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Relatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btPosologia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTipoTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSincronizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btGrupoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btLocalAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, Short.MAX_VALUE)
                        .addComponent(btGrupoAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btLocalAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPosologia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btTipoTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btTeste, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRelatorios, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSincronizacao, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedicamentosActionPerformed
        
    }//GEN-LAST:event_btMedicamentosActionPerformed

    private void btGrupoAlimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btGrupoAlimentoMouseClicked
        
    }//GEN-LAST:event_btGrupoAlimentoMouseClicked

    private void btMedicamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMedicamentosMouseClicked
        VisaoConsultaMedicacao visaoMedicamento = new VisaoConsultaMedicacao(this, true);
        visaoMedicamento.setVisible(true);
    }//GEN-LAST:event_btMedicamentosMouseClicked

    private void btTipoTesteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTipoTesteMouseClicked
        VisaoConsultaTipoTeste visaoTipoTeste = new VisaoConsultaTipoTeste(this, true);
        visaoTipoTeste.setVisible(true);
    }//GEN-LAST:event_btTipoTesteMouseClicked

    private void btMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMedicoActionPerformed
        VisaoConsultaMedico visaoMedico = new VisaoConsultaMedico(this, true);
        visaoMedico.setVisible(true);
    }//GEN-LAST:event_btMedicoActionPerformed

    private void btTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTipoEventoActionPerformed
        VisaoConsultaTipoEvento visaoTipoEvento = new VisaoConsultaTipoEvento(this, true);
        visaoTipoEvento.setVisible(true);
    }//GEN-LAST:event_btTipoEventoActionPerformed

    private void btUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUsuarioActionPerformed
        VisaoManutencaoUsuario visaoUsuario = new VisaoManutencaoUsuario(this, true);
        visaoUsuario.verificaUsuarioExistente();
        visaoUsuario.setVisible(true); 
    }//GEN-LAST:event_btUsuarioActionPerformed

    private void btLocalAplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocalAplicacaoActionPerformed
        VisaoConsultaLocalAplicacao visaoLocalAplicacao = new VisaoConsultaLocalAplicacao(this, true);
        visaoLocalAplicacao.setVisible(true);
    }//GEN-LAST:event_btLocalAplicacaoActionPerformed

    private void btAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlimentoActionPerformed
        VisaoConsultaAlimento visaoAlimento = new VisaoConsultaAlimento(this, true);
        visaoAlimento.setVisible(true);
    }//GEN-LAST:event_btAlimentoActionPerformed

    private void btGrupoAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGrupoAlimentoActionPerformed
        VisaoConsultaGrupoAlimento visaoGrupoAlimento = new VisaoConsultaGrupoAlimento(this, true);
        visaoGrupoAlimento.setVisible(true);
    }//GEN-LAST:event_btGrupoAlimentoActionPerformed

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
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisaoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisaoPrincipal().setVisible(true);
            }
        });
    }

    @Override
    public Image getIconImage() {
        ImageIcon icone = new javax.swing.ImageIcon(getClass().getResource("/com/gdcontrol/desktop/util/img/ic_launcher-web.png"));
        return icone.getImage();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlimento;
    private javax.swing.JButton btAplicacao;
    private javax.swing.JButton btEvento;
    private javax.swing.JButton btGrupoAlimento;
    private javax.swing.JButton btLocalAplicacao;
    private javax.swing.JButton btMedicamentos;
    private javax.swing.JButton btMedico;
    private javax.swing.JButton btPosologia;
    private javax.swing.JButton btRefeicao;
    private javax.swing.JButton btRelatorios;
    private javax.swing.JButton btSincronizacao;
    private javax.swing.JButton btTeste;
    private javax.swing.JButton btTipoEvento;
    private javax.swing.JButton btTipoTeste;
    private javax.swing.JButton btUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
