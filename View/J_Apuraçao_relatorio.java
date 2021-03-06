/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.C_Pdf;
import Controller.C_Selic;
import Model.Apuraçao;
import Model.Modelo_tabelas.Model_table_resultado_apuraçao;
import Model.Rubrica_apuraçao;
import Model.Selic;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Victony
 */
public class J_Apuraçao_relatorio extends javax.swing.JFrame {
    
    Model_table_resultado_apuraçao modelo;
    float empresa = 0, terceiro = 0, rat = 0;
    int index_combo = 0;
    ArrayList<ArrayList<Apuraçao>> list_rubricas_apuradas;
    ArrayList<Rubrica_apuraçao> list_rubricas_selecionada;
    ArrayList<ArrayList<Selic>> matriz_selic;
    ArrayList<Selic> list_selic_tratada;
    J_Inicial jj_inicial;
    
    public J_Apuraçao_relatorio(J_Inicial j_inicial, ArrayList<ArrayList<Apuraçao>> list_rubricas_recebidas, ArrayList<Rubrica_apuraçao> list_rubricas_selecionadas) {
        initComponents();
        this.setLocationRelativeTo(null);
        jj_inicial = j_inicial;
//        
        list_rubricas_apuradas = list_rubricas_recebidas;
        list_rubricas_selecionada = list_rubricas_selecionadas;
        Combo_Rubrica.removeAllItems();
        for(int i=0; i<list_rubricas_apuradas.size(); i++){
            Combo_Rubrica.addItem(list_rubricas_apuradas.get(i).get(0).getCod_rubr()+ " - "+list_rubricas_apuradas.get(i).get(0).getDes_rubr());
        }
        Combo_Rubrica.setEnabled(false);
        Label_Erro.setText("");
        matriz_selic = C_Selic.Buscar_selic_completa();
        
        modelo = new Model_table_resultado_apuraçao();      
        modelo.setDados(list_rubricas_apuradas, matriz_selic, empresa, rat, terceiro);
        modelo.setTipo_cabecalho(3);
        Table_Relatorio.setModel(modelo);
        list_selic_tratada = modelo.getList_selic_tratada();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel_Incidencia = new javax.swing.JPanel();
        B_Inserir_incidencias = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Combo_Rubrica = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Combo_Tipo_tabela = new javax.swing.JComboBox<>();
        Label_Erro = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        Text_Empresa = new javax.swing.JTextField();
        Text_Terceiro = new javax.swing.JTextField();
        Text_Rat = new javax.swing.JTextField();
        B_Retornar = new javax.swing.JButton();
        Painel_Busca = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Relatorio = new javax.swing.JTable();
        B_Imprimir_relatorio_apuraçao = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Painel_Incidencia.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Incidencia.setPreferredSize(new java.awt.Dimension(900, 160));

        B_Inserir_incidencias.setBackground(new java.awt.Color(102, 102, 102));
        B_Inserir_incidencias.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Inserir_incidencias.setForeground(new java.awt.Color(0, 0, 0));
        B_Inserir_incidencias.setText("Inserir Percentuais de Incidências");
        B_Inserir_incidencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Inserir_incidenciasActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Apuração");

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Percentual Empresa");

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Percentual Terceiros");

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Percentual RAT");

        Combo_Rubrica.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Rubrica.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Rubrica.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Rubrica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descrição RUBR - Cod", " " }));
        Combo_Rubrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_RubricaActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Modelo de Tabela");

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Rubricas");

        Combo_Tipo_tabela.setBackground(new java.awt.Color(153, 153, 153));
        Combo_Tipo_tabela.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Combo_Tipo_tabela.setForeground(new java.awt.Color(0, 0, 0));
        Combo_Tipo_tabela.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tabela Resumo", "Tabela Anual", "Tabela Mensal" }));
        Combo_Tipo_tabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_Tipo_tabelaActionPerformed(evt);
            }
        });

        Label_Erro.setBackground(new java.awt.Color(153, 153, 153));
        Label_Erro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Label_Erro.setForeground(new java.awt.Color(153, 0, 0));
        Label_Erro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Erro.setText("Erro");

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));

        Text_Empresa.setBackground(new java.awt.Color(153, 153, 153));
        Text_Empresa.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Text_Empresa.setForeground(new java.awt.Color(0, 0, 0));

        Text_Terceiro.setBackground(new java.awt.Color(153, 153, 153));
        Text_Terceiro.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Text_Terceiro.setForeground(new java.awt.Color(0, 0, 0));

        Text_Rat.setBackground(new java.awt.Color(153, 153, 153));
        Text_Rat.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        Text_Rat.setForeground(new java.awt.Color(0, 0, 0));
        Text_Rat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_RatActionPerformed(evt);
            }
        });

        B_Retornar.setBackground(new java.awt.Color(102, 102, 102));
        B_Retornar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Retornar.setForeground(new java.awt.Color(0, 0, 0));
        B_Retornar.setText("Retornar");
        B_Retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RetornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Painel_IncidenciaLayout = new javax.swing.GroupLayout(Painel_Incidencia);
        Painel_Incidencia.setLayout(Painel_IncidenciaLayout);
        Painel_IncidenciaLayout.setHorizontalGroup(
            Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Label_Erro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel_IncidenciaLayout.createSequentialGroup()
                                        .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Text_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Text_Terceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Text_Rat, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Combo_Rubrica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(23, 23, 23)
                                        .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Combo_Tipo_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(B_Inserir_incidencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 44, Short.MAX_VALUE))
                            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(B_Retornar))))
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4))
                .addContainerGap())
        );
        Painel_IncidenciaLayout.setVerticalGroup(
            Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_IncidenciaLayout.createSequentialGroup()
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(B_Retornar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(B_Inserir_incidencias)
                    .addComponent(Text_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_Terceiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_Rat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel_IncidenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Combo_Rubrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(Combo_Tipo_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Erro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Painel_Incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 160));

        Painel_Busca.setBackground(new java.awt.Color(204, 204, 204));
        Painel_Busca.setPreferredSize(new java.awt.Dimension(900, 340));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(888, 334));

        Table_Relatorio.setBackground(new java.awt.Color(153, 153, 153));
        Table_Relatorio.setForeground(new java.awt.Color(0, 0, 0));
        Table_Relatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_Relatorio.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(Table_Relatorio);

        B_Imprimir_relatorio_apuraçao.setBackground(new java.awt.Color(102, 102, 102));
        B_Imprimir_relatorio_apuraçao.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 12)); // NOI18N
        B_Imprimir_relatorio_apuraçao.setForeground(new java.awt.Color(0, 0, 0));
        B_Imprimir_relatorio_apuraçao.setText("Gerar Relatório de Apuração em PDF");
        B_Imprimir_relatorio_apuraçao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Imprimir_relatorio_apuraçaoActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(153, 153, 153));
        jLabel17.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Pré visualização do relatório de apuração");

        javax.swing.GroupLayout Painel_BuscaLayout = new javax.swing.GroupLayout(Painel_Busca);
        Painel_Busca.setLayout(Painel_BuscaLayout);
        Painel_BuscaLayout.setHorizontalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel_BuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Painel_BuscaLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_BuscaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(B_Imprimir_relatorio_apuraçao, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Painel_BuscaLayout.setVerticalGroup(
            Painel_BuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel_BuscaLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_Imprimir_relatorio_apuraçao)
                .addContainerGap())
        );

        getContentPane().add(Painel_Busca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 900, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Text_RatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_RatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_RatActionPerformed

    private void B_Inserir_incidenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Inserir_incidenciasActionPerformed
        boolean inserir = true;
        float aux_empresa = 0, aux_rat = 0, aux_terceiro = 0;
        try{
            aux_empresa = Float.parseFloat(Text_Empresa.getText());
            aux_rat = Float.parseFloat(Text_Rat.getText());
            aux_terceiro = Float.parseFloat(Text_Terceiro.getText());
            if(empresa == aux_empresa && rat == aux_rat && terceiro == aux_terceiro)
                inserir = false;
            
        }catch(NumberFormatException e){
            Label_Erro.setText("Percentual de Incidencias Incorreto");
            inserir = false;
        }
        if(inserir){
            empresa = aux_empresa;
            rat = aux_rat;
            terceiro = aux_terceiro; 
            modelo.setDados(list_rubricas_apuradas, matriz_selic, empresa, rat, terceiro);
            Combo_Rubrica.setSelectedIndex(0);
            Combo_Tipo_tabela.setSelectedIndex(0);
        }
    }//GEN-LAST:event_B_Inserir_incidenciasActionPerformed

    private void Combo_Tipo_tabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_Tipo_tabelaActionPerformed
        if(Combo_Tipo_tabela.getSelectedIndex() == 0){
            if(modelo.getTipo_cabecalho() != 3){
                modelo.setTipo_cabecalho(3);
                Combo_Rubrica.setEnabled(false);
            }            
        }
        else if(Combo_Tipo_tabela.getSelectedIndex() == 1){
            if(modelo.getTipo_cabecalho() != 2){
                modelo.setTipo_cabecalho(2);
                Combo_Rubrica.setEnabled(false);
            }
        }
        else if(Combo_Tipo_tabela.getSelectedIndex() == 2){
            if(modelo.getTipo_cabecalho() != 1){
                modelo.setTipo_cabecalho(1);     
                Combo_Rubrica.setEnabled(true);
                Combo_Rubrica.setSelectedIndex(0);
            }          
        }
            
    }//GEN-LAST:event_Combo_Tipo_tabelaActionPerformed

    private void Combo_RubricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_RubricaActionPerformed
        if(modelo!=null)
            if(Combo_Rubrica.getSelectedIndex() != index_combo){
                index_combo = Combo_Rubrica.getSelectedIndex();
                modelo.Selecionar_rubr_exibida(index_combo);
            }
    }//GEN-LAST:event_Combo_RubricaActionPerformed

    private void B_Imprimir_relatorio_apuraçaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Imprimir_relatorio_apuraçaoActionPerformed

        Label_Erro.setText("O Relatório de Apuração foi inserido na pasta \"Apuraçao\"");
        C_Pdf c_pdf = new C_Pdf();
        c_pdf.Escrever_relatorio_apuraçao(modelo.getList_apuraçao_resumo(), modelo.getList_apuraçao_ano(), modelo.getList_apuraçao_mensal(), jj_inicial.getDados_empresa(), empresa, rat, terceiro, modelo.getMes_inicial(), modelo.getAno_inicial(), modelo.getMes_final(), modelo.getAno_final(), list_rubricas_selecionada, list_selic_tratada);
        
        try {
            Desktop.getDesktop().open(new File("Apuraçao/"+ jj_inicial.getDados_empresa() +".pdf"));
        } catch (IOException ex) {
            Logger.getLogger(J_Apuraçao_relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_B_Imprimir_relatorio_apuraçaoActionPerformed

    private void B_RetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RetornarActionPerformed
        jj_inicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_B_RetornarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Imprimir_relatorio_apuraçao;
    private javax.swing.JButton B_Inserir_incidencias;
    private javax.swing.JButton B_Retornar;
    private javax.swing.JComboBox<String> Combo_Rubrica;
    private javax.swing.JComboBox<String> Combo_Tipo_tabela;
    private javax.swing.JLabel Label_Erro;
    private javax.swing.JPanel Painel_Busca;
    private javax.swing.JPanel Painel_Incidencia;
    private javax.swing.JTable Table_Relatorio;
    private javax.swing.JTextField Text_Empresa;
    private javax.swing.JTextField Text_Rat;
    private javax.swing.JTextField Text_Terceiro;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
