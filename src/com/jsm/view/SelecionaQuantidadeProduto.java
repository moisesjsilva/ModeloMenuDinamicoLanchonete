/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsm.view;

import com.jsm.Produto;
import com.jsm.util.ImageAsyncLoad;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author moises
 */
public class SelecionaQuantidadeProduto extends javax.swing.JDialog {

    private Produto produto;
    private DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
    Locale ptBr = new Locale("pt", "BR");
    NumberFormat currency = NumberFormat.getCurrencyInstance(ptBr);

    /**
     * Creates new form SelecionaQuantidadeProduto
     */
    public SelecionaQuantidadeProduto() {
        initComponents();
        config();

    }

    public SelecionaQuantidadeProduto(Produto produto) {
        initComponents();
        config();
        this.produto = produto;
        displayInfo();
    }

    private void config() {
        //this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setModal(true);

    }

    private void displayInfo() {

        ImageAsyncLoad.load(lblImage, "src/images/place_holder.jpeg", produto.getFoto());
        lblNomeProduto.setText(produto.getNome());
        lblCodigoProduto.setText("Codigo: " + produto.getCodigo());
        updateLabelPreco(produto.getPreco());

    }
    
    private void updateLabelPreco(BigDecimal valor){
        lblPreco.setText(currency.format(valor));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeProduto = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btOk = new javax.swing.JButton();
        lblCodigoProduto = new javax.swing.JLabel();
        jftQuantidade = new javax.swing.JFormattedTextField();

        lblNomeProduto.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblNomeProduto.setForeground(new java.awt.Color(66, 205, 32));
        lblNomeProduto.setText("jLabel1");

        lblImage.setText("jLabel2");

        lblPreco.setText("R$ 1.50");

        jLabel2.setText("Quantidade");

        btOk.setBackground(new java.awt.Color(248, 249, 249));
        btOk.setText("Adicionar");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        lblCodigoProduto.setText("jLabel3");

        jftQuantidade.setText("1");
        jftQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jftQuantidadeKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jftQuantidadeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCodigoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btOk, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btOk)
                    .addComponent(jftQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btOkActionPerformed

    private void jftQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftQuantidadeKeyTyped
        
    }//GEN-LAST:event_jftQuantidadeKeyTyped

    private void jftQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftQuantidadeKeyReleased
       if(jftQuantidade.getText().isEmpty()){
           updateLabelPreco(BigDecimal.ZERO);
           return;
        }
        Integer quantidade = Integer.valueOf(jftQuantidade.getText());
        updateLabelPreco(produto.getPreco().multiply(BigDecimal.valueOf(quantidade)));
    }//GEN-LAST:event_jftQuantidadeKeyReleased

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
            java.util.logging.Logger.getLogger(SelecionaQuantidadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionaQuantidadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionaQuantidadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionaQuantidadeProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecionaQuantidadeProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField jftQuantidade;
    private javax.swing.JLabel lblCodigoProduto;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNomeProduto;
    private javax.swing.JLabel lblPreco;
    // End of variables declaration//GEN-END:variables
}
