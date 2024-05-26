package View;

import DAO.Fone_de_OuvidoDAO;
import Model.Fone_de_Ouvido;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Relatorio_Geral extends javax.swing.JFrame {

    
    public Relatorio_Geral() {
        initComponents();
        carregaTabela(); // Carrega os dados quando o frame é inicializado        
    }
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableFone = new javax.swing.JTable();
        B_OrderByPrice = new javax.swing.JButton();
        b_OrderByID = new javax.swing.JButton();
        b_Produtos_Esgotados = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblQuantidadeTotalEstoque = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Relatorio Geral");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableFone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tipo", "Preço", "Marca", "Modelo", "Qtd. Estoque", "Data Cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableFone);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1140, 446));

        B_OrderByPrice.setBackground(new java.awt.Color(255, 102, 0));
        B_OrderByPrice.setForeground(new java.awt.Color(0, 0, 0));
        B_OrderByPrice.setText("Ordenar por Preço");
        B_OrderByPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_OrderByPriceActionPerformed(evt);
            }
        });
        getContentPane().add(B_OrderByPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 517, 150, -1));

        b_OrderByID.setBackground(new java.awt.Color(255, 102, 0));
        b_OrderByID.setForeground(new java.awt.Color(0, 0, 0));
        b_OrderByID.setText("Ordenar por ID");
        b_OrderByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_OrderByIDActionPerformed(evt);
            }
        });
        getContentPane().add(b_OrderByID, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 488, 150, -1));

        b_Produtos_Esgotados.setBackground(new java.awt.Color(255, 102, 0));
        b_Produtos_Esgotados.setForeground(new java.awt.Color(0, 0, 0));
        b_Produtos_Esgotados.setText("Produtos Esgotados");
        b_Produtos_Esgotados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_Produtos_EsgotadosActionPerformed(evt);
            }
        });
        getContentPane().add(b_Produtos_Esgotados, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 546, 150, -1));

        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setText("Épic Perifericos @");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 599, -1, -1));

        lblQuantidadeTotalEstoque.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblQuantidadeTotalEstoque.setForeground(new java.awt.Color(255, 102, 0));
        lblQuantidadeTotalEstoque.setText("Quantidade Total do Estoque:");
        getContentPane().add(lblQuantidadeTotalEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 491, 277, 36));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 290, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens2/2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1176, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void B_OrderByPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_OrderByPriceActionPerformed
        Fone_de_OuvidoDAO dao = new Fone_de_OuvidoDAO();
    ArrayList<Fone_de_Ouvido> listaFones = dao.getListaOrdenadaPorPreco();

    // Limpar a tabela
    DefaultTableModel modelo = (DefaultTableModel) this.jTableFone.getModel();
    modelo.setRowCount(0);
    // Adicionar os dados ordenados à tabela
    for (Fone_de_Ouvido a : listaFones) {
        modelo.addRow(new Object[]{
            a.getId(),
            a.getNome(),
            a.getTipo(),
            a.getPreco(),
//            a.getDescricao(),
            a.getMarca(),
            a.getModelo(),
            a.getQtd_estoque(),
            a.getData_cadastro(),
//            a.getConectividade_do_fone(),
//            a.getMaterial(),
        });
    }

    }//GEN-LAST:event_B_OrderByPriceActionPerformed

    private void b_OrderByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_OrderByIDActionPerformed
        Fone_de_OuvidoDAO dao = new Fone_de_OuvidoDAO();
      ArrayList<Fone_de_Ouvido> listaFones = dao.getListaOrdenadaPorID();
      
      // Limpar a tabela
    DefaultTableModel modelo = (DefaultTableModel) this.jTableFone.getModel();
    modelo.setRowCount(0);
    
     for (Fone_de_Ouvido a : listaFones) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getTipo(),
                a.getPreco(),
//                a.getDescricao(),
                a.getMarca(),
                a.getModelo(),
                a.getQtd_estoque(),
                a.getData_cadastro(),              
//                a.getConectividade_do_fone(),
//                a.getMaterial(),  
            });
        }
    }//GEN-LAST:event_b_OrderByIDActionPerformed

    private void b_Produtos_EsgotadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_Produtos_EsgotadosActionPerformed
          Fone_de_OuvidoDAO dao = new Fone_de_OuvidoDAO();
    ArrayList<Fone_de_Ouvido> listaProdutosEsgotados = dao.getProdutosEsgotados();

    // Limpar a tabela
    DefaultTableModel modelo = (DefaultTableModel) this.jTableFone.getModel();
    modelo.setRowCount(0);
    // Adicionar os produtos esgotados à tabela
    for (Fone_de_Ouvido produto : listaProdutosEsgotados) {
        modelo.addRow(new Object[]{
            produto.getId(),
            produto.getNome(),
            produto.getTipo(),
            produto.getPreco(),
//            produto.getDescricao(),
            produto.getMarca(),
            produto.getModelo(),
            produto.getQtd_estoque(),
            produto.getData_cadastro(),
//            produto.getConectividade_do_fone(),
//            produto.getMaterial(),
        });
    }
    }//GEN-LAST:event_b_Produtos_EsgotadosActionPerformed
      

       
     public void carregaTabela() {
     DefaultTableModel modelo = (DefaultTableModel) this.jTableFone.getModel();
     modelo.setNumRows(0);
     
     Fone_de_OuvidoDAO dao = new Fone_de_OuvidoDAO();
      ArrayList<Fone_de_Ouvido> listaFones = dao.getListaOrdenadaPorID();
        
      int quantidadeTotalEstoque = 0; // Inicializa a quantidade total do estoque

        for (Fone_de_Ouvido a : listaFones) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getTipo(),
                a.getPreco(),
//                a.getDescricao(),
                a.getMarca(),
                a.getModelo(),
                a.getQtd_estoque(),
                a.getData_cadastro(),              
//                a.getConectividade_do_fone(),
//                a.getMaterial(),  
            });
             quantidadeTotalEstoque += a.getQtd_estoque(); // Adiciona a quantidade de estoque deste produto à quantidade total
        }
        // Atualiza o rótulo com a quantidade total do estoque
        lblQuantidadeTotalEstoque.setText("Quantidade Total do Estoque: " + quantidadeTotalEstoque);
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
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio_Geral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio_Geral().setVisible(true);
            }
        });
    }
;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_OrderByPrice;
    private javax.swing.JButton b_OrderByID;
    private javax.swing.JButton b_Produtos_Esgotados;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableFone;
    private javax.swing.JLabel lblQuantidadeTotalEstoque;
    // End of variables declaration//GEN-END:variables
}
