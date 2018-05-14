/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsm;

import com.jsm.util.ImageAsyncLoad;
import com.jsm.view.SelecionaQuantidadeProduto;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author moises
 */
public class Exemplo extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Exemplo
     */
    public Exemplo() {
        initComponents();
        preencherMenu();
        config();
        
        //this.panelMenu.setPreferredSize(new Dimension(100, 100));

    }
    
    private void config(){
        this.getContentPane().setBackground(Color.white);
        this.panelMenu.setBackground(Color.DARK_GRAY);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void preencherMenu() {
        panelMenu.removeAll();
        panelMenu.invalidate();
        JButton b = null;
        int rows = CategoriaController.categorias().size() / 4;

        GridLayout gl = new GridLayout(rows, 4);

        panelMenu.setLayout(new FlowLayout());

        int i = 0;
        for (Categoria c : CategoriaController.categorias()) {

            BotaoMenu bm = new BotaoMenu(c, c.getNome());
            configButton(bm);
            ImageAsyncLoad.load(bm, "src/images/place_holder.jpeg", c.getFoto());         

            panelMenu.add(bm);
        }

        panelMenu.validate();
        panelMenu.repaint();
        System.gc();

    }

    private void processarClickProduto(Produto produto) {
        if (produto.getId() == -1L) {
            preencherMenu();
        } else {
            SelecionaQuantidadeProduto sqp = new SelecionaQuantidadeProduto(produto);
            //sqp.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
            sqp.setVisible(true);
            // Realiza a venda do produto
        }

    }

    private void processarClickCategoria(Categoria categoria) {
        List<Produto> produtos = ProdutoController.produtosPorCategoria(categoria);
        panelMenu.removeAll();
        panelMenu.invalidate();

        produtos.forEach(p -> {

            BotaoMenu bm = new BotaoMenu(p, p.getNome());
            configButton(bm);
            ImageAsyncLoad.load(bm, "src/images/place_holder.jpeg", p.getFoto());
            
            panelMenu.add(bm);
        });
        panelMenu.validate();
        panelMenu.repaint();

        System.gc();
    }

    private void configButton(BotaoMenu bm) {
        bm.setVerticalTextPosition(SwingConstants.BOTTOM);
        bm.setHorizontalTextPosition(SwingConstants.CENTER);
        bm.setBackground(Color.WHITE);
        bm.setForeground(Color.RED);
        bm.addActionListener(this);
    }

    private void readAsyncFromUrl(String url, BotaoMenu bm) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ImageIcon ic = readImageFromUrl(url);
                if (ic != null) {
                    if (ic.getImage() != null) {
                        System.out.println("Passou aqui");
                        Image img = ic.getImage();
                        Image newImage = img.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
                        bm.setIcon(new ImageIcon(newImage));

                    }

                }

            }
        }).start();
    }

    private ImageIcon readFromPath(String file) {
        ImageIcon icon = new ImageIcon(file);
        return icon;
    }

    private ImageIcon readFromPackge(String packageAndFileName) {
        // packageAndFileName = packageAndFileName.replace("//", File.separator);

        ImageIcon icon = new ImageIcon(packageAndFileName);
        return icon;

    }

    private ImageIcon readImageFromUrl(String location) {
        Image image = null;
        ImageIcon icon = null;
        try {
            URL url = new URL(location);
            image = ImageIO.read(url);
            icon = new ImageIcon(image);

        } catch (NullPointerException e) {
            Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, e);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.imageio.IIOException ex) {
            Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return icon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuScrollPane = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(89, 129, 133));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelMenu.setPreferredSize(new java.awt.Dimension(300, 100));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        menuScrollPane.setViewportView(panelMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(622, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Exemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exemplo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane menuScrollPane;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        BotaoMenu bm = (BotaoMenu) e.getSource();
        if (bm.getObject() instanceof Categoria) {
            processarClickCategoria((Categoria) bm.getObject());
        } else if (bm.getObject() instanceof Produto) {
            processarClickProduto((Produto) bm.getObject());
        }
    }

}
