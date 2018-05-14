/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsm.util;

import com.jsm.BotaoMenu;
import com.jsm.Exemplo;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author moises
 */
public class ImageAsyncLoad {

    private static final int IMG_WIDTH = 80;
    private static final int IMG_HEIGHT = 60;

    private String placeHolder;
    private String urlImage;

    public static void load(Component label, String placeHolder, String urlImage) {
        loadPlaceHolder(label, placeHolder);
        loadUrlAsync(label, urlImage);
    }

    private static void loadPlaceHolder(Component button, String placeHolder) {
        ImageIcon icon = new ImageIcon(placeHolder);
        resizeImage(icon, button);

    }

    private static void loadUrlAsync(Component label, String urlImage) {
        if (isLocalFile(urlImage)) {
            readFromPath(label, urlImage);
        } else if (ImageCache.isCached(urlImage)) {
            readFromPath(label, ImageCache.getFullPathFromImageUrl(urlImage));
        } else {
            Thread t = new Thread(new ConnectUrl(label, urlImage));
            t.start();
        }

    }

    private static void readFromPath(Component button, String file) {
        ImageIcon icon = new ImageIcon(file);
        resizeImage(icon, button);
    }

    private static void resizeImage(ImageIcon icon, Component button) {
        Image img = icon.getImage();
        Image newImage = img.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon ic = new ImageIcon(newImage);
        setIcon(button, ic);
        //BotaoMenu bm = new BotaoMenu(p, p.getNome(), ic);
    }
    
    private static void setIcon(Component obj, ImageIcon icon){
        if(obj instanceof BotaoMenu){
            ((BotaoMenu) obj).setIcon(icon);
        }else if(obj instanceof JLabel){
            ((JLabel) obj).setIcon(icon);
        }else if(obj instanceof JButton){
            ((JButton) obj).setIcon(icon);
        }
    }

    private static class ConnectUrl implements Runnable {

        private final Component button;
        private final String urlImage;

        public ConnectUrl(Component button, String urlImage) {
            this.button = button;
            this.urlImage = urlImage;
        }

        @Override
        public void run() {
            Image image;
            ImageIcon icon;
            try {
                URL url = new URL(urlImage);
                image = ImageIO.read(url);
                if (image != null) {
                    icon = new ImageIcon(image);
                    resizeImage(icon, button);
                    ImageCache.cache(urlImage);
                }

            } catch (NullPointerException e) {
                Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, e);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (javax.imageio.IIOException ex) {
                Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Exemplo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static boolean isLocalFile(String arquivo) {
        File file = new File(arquivo);
        //System.out.println("IsLocalFile " + file.isFile());
        return file.isFile();
    }

}
