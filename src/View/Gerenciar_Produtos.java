package View;

import Model.Teclado;
import Model.Fone_de_Ouvido;
import Model.Produto;
import java.util.Date;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

public class Gerenciar_Produtos extends javax.swing.JFrame {

    private Fone_de_Ouvido objFone; // cria o vinculo com o objFone
    private Teclado objTeclado;
    
    public Gerenciar_Produtos() {
        initComponents();
        this.objFone = new Fone_de_Ouvido(); //Carrega Fone do Objeto
        this.objTeclado = new Teclado();
        addTipoActionListener();
        updateVisibility();
        this.carregaTabela();
    }
    private void addTipoActionListener() {
        c_tipo.addActionListener(new ActionListener() {
//            @Override
            public void actionPerformed(ActionEvent e) {
                updateVisibility(); // Atualiza a visibilidade dos componentes quando o tipo é alterado
            }
        });
    }

    private void updateVisibility() {
        if (c_tipo.getSelectedItem().toString().equals("Teclado")) {
            jLabel11.setVisible(false); // Esconde o JLabel
            c_conectividade.setVisible(false); // Esconde o JComboBox
            jLabel12.setVisible(false);
            c_material.setVisible(false);
            Label_dimensao_GT.setVisible(true);
            c_conectividade_teclado.setVisible(true);
            jLabel10.setVisible(true);
            c_dimensao.setVisible(true);
            
        } else if (c_tipo.getSelectedItem().toString().equals("Fone de Ouvido")) {
            jLabel11.setVisible(true); // Mostra o JLabel
            c_conectividade.setVisible(true); // Mostra o JComboBox   
            c_material.setVisible(true);         
            c_conectividade_teclado.setVisible(false); 
            c_dimensao.setVisible(false);
            Label_dimensao_GT.setVisible(false);
             jLabel10.setVisible(false);
             jLabel12.setVisible(true);

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFone = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        c_marca = new javax.swing.JTextField();
        c_modelo = new javax.swing.JTextField();
        c_qtd_estoque = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        c_tipo = new javax.swing.JComboBox<>();
        c_material = new javax.swing.JTextField();
        c_preco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_conectividade = new javax.swing.JComboBox<>();
        b_cancelar = new javax.swing.JButton();
        Label_dimensao_GT = new javax.swing.JLabel();
        c_dimensao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        c_conectividade_teclado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        c_descricao = new javax.swing.JTextArea();
        b_alterar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        b_apagar = new javax.swing.JButton();
        c_data = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();

        setTitle("Gerenciamento de Produtos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableFone.setBackground(new java.awt.Color(204, 204, 204));
        jTableFone.setForeground(new java.awt.Color(0, 0, 0));
        jTableFone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tipo", "Preço", "Descrição", "Marca", "Modelo", "Qtd. Estoque", "Data Cadastro", "Conectividade do fone", "Material", "Dimensao ", "Conectividade_teclado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFone.setSelectionBackground(new java.awt.Color(0, 0, 102));
        jTableFone.setSelectionForeground(new java.awt.Color(255, 102, 0));
        jTableFone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFoneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFone);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1030, 140));

        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("Modelo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 52, -1));

        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Quantidade em Estoque:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Data de Cadastro:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));
        getContentPane().add(c_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 153, -1));
        getContentPane().add(c_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 341, -1));
        getContentPane().add(c_qtd_estoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 143, -1));

        jLabel11.setForeground(new java.awt.Color(255, 102, 0));
        jLabel11.setText("conectividade do fone:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 102, 0));
        jLabel12.setText("Material:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, 55, -1));

        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        c_nome.setCaretColor(new java.awt.Color(102, 102, 102));
        c_nome.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        c_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nomeActionPerformed(evt);
            }
        });
        getContentPane().add(c_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 298, -1));

        c_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fone de Ouvido", "Teclado" }));
        getContentPane().add(c_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 210, -1));
        getContentPane().add(c_material, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 188, -1));
        getContentPane().add(c_preco, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 76, -1));

        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Preço:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 37, -1));

        c_conectividade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Com fio", "Sem fio" }));
        getContentPane().add(c_conectividade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, -1, -1));

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(b_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 522, 92, 33));

        Label_dimensao_GT.setForeground(new java.awt.Color(255, 102, 0));
        Label_dimensao_GT.setText("Dimensão: ");
        getContentPane().add(Label_dimensao_GT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, -1, -1));
        getContentPane().add(c_dimensao, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 120, -1));

        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setText("Conectividade:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 102, 0));
        jLabel13.setText("Tipo:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));
        getContentPane().add(c_conectividade_teclado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 110, -1));

        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Descrição:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 64, -1));

        c_descricao.setColumns(20);
        c_descricao.setRows(5);
        c_descricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(c_descricao);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 270, 60));

        b_alterar.setText("Alterar");
        b_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_alterarActionPerformed(evt);
            }
        });
        getContentPane().add(b_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 522, 102, 33));

        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Marca:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 46, -1));

        b_apagar.setText("Apagar");
        b_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_apagarActionPerformed(evt);
            }
        });
        getContentPane().add(b_apagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 522, 85, 33));

        c_data.setDateFormatString("dd '/' MM '/' y");
        getContentPane().add(c_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 119, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens2/BACKGROUND GT 1090.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void c_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nomeActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void jTableFoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFoneMouseClicked
 if (this.jTableFone.getSelectedRow() != -1) {
        Object tipoObject = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 2);

        if (tipoObject != null) {
            String tipo = tipoObject.toString();

            String nome = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 1).toString();
            String preco = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 3).toString();
            String descricao = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 4).toString();
            String marca = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 5).toString();
            String modelo = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 6).toString();
            String qtd_estoque = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 7).toString();
            String data_cadastroString = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 8).toString();
            Date data_cadastro = null;
            String dimensao = "";
            String conectividade = "";

            if (tipo.equals("Teclado")) {
                Object dimensaoObject = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 11);
                if (dimensaoObject != null) {
                    dimensao = dimensaoObject.toString();
                }

                Object conectividadeObject = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 12);
                if (conectividadeObject != null) {
                    conectividade = conectividadeObject.toString();
                }
            } else if (tipo.equals("Fone de Ouvido")) {
                String conectividade_do_fone = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 9).toString();
                String material = this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 10).toString();

                this.c_conectividade.setSelectedItem(conectividade_do_fone);
                this.c_material.setText(material);
            }

            this.c_nome.setText(nome);
            this.c_tipo.setSelectedItem(tipo);
            this.c_preco.setText(preco);
            this.c_descricao.setText(descricao);
            this.c_marca.setText(marca);
            this.c_modelo.setText(modelo);
            this.c_qtd_estoque.setText(qtd_estoque);
            try {
                data_cadastro = new SimpleDateFormat("dd/MM/yyyy").parse(data_cadastroString);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao converter a data: ");               
            }
            this.c_data.setDate(data_cadastro);
            this.c_dimensao.setText(dimensao);
            this.c_conectividade_teclado.setText(conectividade);
        }
    }     
    }//GEN-LAST:event_jTableFoneMouseClicked

    private void b_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_alterarActionPerformed
        if (c_tipo.getSelectedItem().toString().equals("Fone de Ouvido")) {
        try {
            //recebendo e validando dados da interface gráfica.
            int id = 0;
            String nome = "";
            String tipo = "";
            float preco = 0;
            String descricao = "";
            String marca = "";
            String modelo = "";
            int qtd_estoque =  0;       
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data_cadastro = sdf.format(c_data.getDate());           
            String conectividade_do_fone = "";
            String material = "";
            
            
            
            if (this.c_nome.getText().length() < 2 || this.c_nome.getText().length() > 45 ) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres e menos de 45 caracteres.");
            } else {
                nome = this.c_nome.getText();
            }
            if (this.c_tipo.getSelectedItem() == "Fone de Ouvido"){
                tipo = this.c_tipo.getSelectedItem().toString();
            }  else {
                throw new Mensagens ("Tipo de produto inválido!");
            }
             try {
                float preco2 = Float.parseFloat(this.c_preco.getText());

                if (preco2 < 0 || preco2 > 50000) {
                    throw new Mensagens("O preço não pode ser menor que ZERO ou maior que CINQUENTA MIL!");
                } else {
                    preco = Float.parseFloat(this.c_preco.getText());
                }
            } catch (NumberFormatException e) {
                throw new Mensagens("O valor inserido não é um número válido!");
            }
//            if (this.c_preco.getText().length() <= 0) {
//                throw new Mensagens("Preço deve ser maior ou igual a zero.");
//            } else {
//                preco = Float.parseFloat(this.c_preco.getText());
//            }
            if (this.c_descricao.getText().length() < 5 || this.c_descricao.getText().length() >250) {
                throw new Mensagens("Descrição deve conter ao menos 5 caracteres e menos de 250 caracteres.");
            } else {
                descricao = this.c_descricao.getText();
            }
            if (this.c_data.getDate() == null) { 
                throw new Mensagens("Insira uma data valida");
            } else {
                data_cadastro = sdf.format(this.c_data.getDate());                  
            }
            try {
                qtd_estoque = Integer.parseInt(this.c_qtd_estoque.getText());
                if (qtd_estoque < 0) {
                    throw new Mensagens("Estoque não pode ser negativo");
                }
            } catch (NumberFormatException e) {
                throw new Mensagens("Quantidade em estoque deve ser um número válido");
            }
//            if (this.c_qtd_estoque.getText().length() <0) {  
//               throw new Mensagens("Estoque não pode ser negativo");
//            } else {
//                qtd_estoque = Integer.parseInt(this.c_qtd_estoque.getText());
//            } 
            if (this.c_marca.getText().length() < 2 || this.c_marca.getText().length() > 45 ) {
                throw new Mensagens("Marca deve conter ao menos 2 caracteres e menos de 45 caracteres.");
            } else {
                marca = this.c_marca.getText();
            }
            if (this.c_modelo.getText().length() < 2 || this.c_modelo.getText().length() > 45 ) {
                throw new Mensagens("Modelo deve conter ao menos 2 caracteres e menos de 45 caracteres.");
            } else {
                modelo = this.c_modelo.getText();
            }
            if (this.c_conectividade.getSelectedItem().toString().length() < 2 || this.c_conectividade.getSelectedItem().toString().length() > 45 ) {
                throw new Mensagens("conectividade do fone deve conter ao menos 2 caracteres e menos de 45 caracteres.");
            } else {
                conectividade_do_fone = this.c_conectividade.getSelectedItem().toString();
            }
            if (this.c_material.getText().length() < 2 || this.c_material.getText().length() > 45 ) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres e menos de 45 caracteres.");
            } else {
                material = this.c_material.getText();
            }
            
            if (this.jTableFone.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Fone para Alterar");
            } else {
                id = Integer.parseInt(this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 0).toString());
            }
            // envia os dados para o Fone processar
            if (this.objFone.UpdateFoneBD(conectividade_do_fone, material, id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro)) {
                JOptionPane.showMessageDialog(rootPane, "Fone de Ouvido Alterado com Sucesso!");
                
            // limpa campos da interface
                this.c_nome.setText("");
                this.c_tipo.setSelectedItem("Fone de Ouvido");
                this.c_preco.setText("");
                this.c_descricao.setText("");
                this.c_marca.setText("");
                this.c_modelo.setText("");
                this.c_qtd_estoque.setText("");
                this.c_data.setDate(null);               
                this.c_conectividade.setSelectedItem("");           
                this.c_material.setText("");
               
                
        
        }  
            System.out.println(this.objFone.getMinhaLista().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um numero.");
        } finally {
            carregaTabela(); //Atualiza a tabela
        }  
} else if (c_tipo.getSelectedItem().toString().equals("Teclado")) {
    try {
        // Recebendo e validando dados da interface gráfica.
        int id;
        String nome_teclado;
        String marca_teclado;
        String modelo_teclado;
        float preco_teclado;
        int qtd_estoque_teclado;
        String datacadastro_teclado;
        String descricao_teclado;
        String dimensao_teclado;
        String conectividade_teclado;
        String tipo_teclado;

        if (this.jTableFone.getSelectedRow() == -1) {
            throw new Mensagens("Primeiro Selecione um Teclado para Alterar");
        } else {
            id = Integer.parseInt(this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 0).toString());
        }

        nome_teclado = this.c_nome.getText();
        tipo_teclado = this.c_tipo.getSelectedItem().toString();

        if (!tipo_teclado.equals("Teclado")) {
            throw new Mensagens("Tipo de produto inválido!");
        }

        marca_teclado = this.c_marca.getText();

        modelo_teclado = this.c_modelo.getText();

        preco_teclado = Float.parseFloat(this.c_preco.getText());
        if (preco_teclado < 0 || preco_teclado > 50000) {
            throw new Mensagens("O preço não pode ser menor que ZERO ou maior que CINQUENTA MIL!");
        }

        qtd_estoque_teclado = Integer.parseInt(this.c_qtd_estoque.getText());
        if (qtd_estoque_teclado < 0) {
            throw new Mensagens("Estoque não pode ser negativo");
        }

        datacadastro_teclado = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        descricao_teclado = this.c_descricao.getText();

        dimensao_teclado = this.c_dimensao.getText();

        conectividade_teclado = this.c_conectividade_teclado.getText();

        // Envie os dados para o Controlador cadastrar
        if (this.objTeclado.UpdateTecladoBD(dimensao_teclado, conectividade_teclado, id, nome_teclado, tipo_teclado, preco_teclado, descricao_teclado, marca_teclado, modelo_teclado, qtd_estoque_teclado, datacadastro_teclado)) {
            JOptionPane.showMessageDialog(rootPane, "Teclado Alterado com Sucesso!");
        }

        // Limpar campos da interface
        this.c_nome.setText("");
        this.c_marca.setText("");
        this.c_modelo.setText("");
        this.c_preco.setText("");
        this.c_qtd_estoque.setText("");
        this.c_data.setDate(null);
        this.c_descricao.setText("");
        this.c_dimensao.setText("");
        this.c_conectividade_teclado.setText("");
        this.c_tipo.setSelectedItem("Teclado");

    } catch (Mensagens erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage());
    } catch (NumberFormatException erro2) {
        JOptionPane.showMessageDialog(null, "Preencha o campo usando números!");
    } catch (NullPointerException erroNull) {
        JOptionPane.showMessageDialog(null, "Preencha o campo data!");
    } catch (SQLException ex) {
        Logger.getLogger(GerenciaTeclado.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Atualiza a tabela independentemente do resultado da operação
        carregaTabela();
    }

    }//GEN-LAST:event_b_alterarActionPerformed

}


    private void b_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_apagarActionPerformed
     
          try {
            // validando dados da interface grafica.
            int id = 0;
            if (this.jTableFone.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Produto para APAGAR");
            } else {
                id = Integer.parseInt(this.jTableFone.getValueAt(this.jTableFone.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro bot�o | 1 -> segundo bot�o | 2 -> terceiro bot�o
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR este Produto?");

            if (resposta_usuario == 0) {// clicou em SIM

                // envia os dados para o Fone de Ouvido processar
                if (this.objFone.DeleteFoneBD(id)) {

                    // limpa os campos
                    this.c_nome.setText("");
                this.c_tipo.setSelectedItem("Fone de Ouvido");
                this.c_preco.setText("");
                this.c_descricao.setText("");
                this.c_marca.setText("");
                this.c_modelo.setText("");
                this.c_qtd_estoque.setText("");
                this.c_data.setDate(null);    
                this.c_conectividade.setSelectedItem("");
                this.c_material.setText("");               
                    JOptionPane.showMessageDialog(rootPane, "Produto Apagado com Sucesso!");

                }

            }

            System.out.println(this.objFone.getMinhaLista().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um numero.");
        } finally {
            carregaTabela(); //Atualiza a tabela
        }
    }//GEN-LAST:event_b_apagarActionPerformed
    public void carregaTabela() {
     DefaultTableModel modelo = (DefaultTableModel) this.jTableFone.getModel();
    modelo.setNumRows(0);

    // Carregar lista de fones de ouvido
    ArrayList<Fone_de_Ouvido> listaFones = objFone.getMinhaLista();
    for (Fone_de_Ouvido fone : listaFones) {
        modelo.addRow(new Object[]{
            fone.getId(),
            fone.getNome(),
            fone.getTipo(),
            fone.getPreco(),
            fone.getDescricao(),
            fone.getMarca(),
            fone.getModelo(),
            fone.getQtd_estoque(),
            fone.getData_cadastro(),
            fone.getConectividade_do_fone(),
            fone.getMaterial(),
            "", // Dimensão (não aplicável a fones)
            ""  // Conectividade do Teclado (não aplicável a fones)
        });
    }

    // Carregar lista de teclados
    ArrayList<Teclado> listaTeclados = objTeclado.getListaTeclado();
    for (Teclado teclado : listaTeclados) {
        modelo.addRow(new Object[]{
            teclado.getId(),
            teclado.getNome(),
            teclado.getTipo(),
            teclado.getPreco(),
            teclado.getDescricao(),
            teclado.getMarca(),
            teclado.getModelo(),
            teclado.getQtd_estoque(),
            teclado.getData_cadastro(),
            "", // Conectividade do Fone (não aplicável a teclados)
            "", // Material (não aplicável a teclados)
            teclado.getDimensao(), // Dimensão do Teclado
            teclado.getConectividade() // Conectividade do Teclado
        });
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
            java.util.logging.Logger.getLogger(Gerenciar_Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gerenciar_Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gerenciar_Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerenciar_Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerenciar_Produtos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_dimensao_GT;
    private javax.swing.JButton b_alterar;
    private javax.swing.JButton b_apagar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JComboBox<String> c_conectividade;
    private javax.swing.JTextField c_conectividade_teclado;
    private com.toedter.calendar.JDateChooser c_data;
    private javax.swing.JTextArea c_descricao;
    private javax.swing.JTextField c_dimensao;
    private javax.swing.JTextField c_marca;
    private javax.swing.JTextField c_material;
    private javax.swing.JTextField c_modelo;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_preco;
    private javax.swing.JTextField c_qtd_estoque;
    private javax.swing.JComboBox<String> c_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFone;
    // End of variables declaration//GEN-END:variables
}
