/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moises
 */
public class ImageCache {
//    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.io.tmpdir"));
//        System.out.println("File Exist = "+isCached("http://"));
//        System.out.println(getNameFile("http://wfarm3.dataknet.com/static/resources/icons/set41/de4d7870.png"));
//    }
    
    public static final boolean isCached(String fileName){
        fileName = getNameFile(fileName);
        
        String temp = getTempDir();
        File file  = new File(temp+File.separator+fileName);
        //System.out.println(file.getAbsoluteFile().toString());
        return file.exists();
    }
    
    public static void cache(String urlImage){
        try {
            String fileName = getNameFile(urlImage);
            String destino = getTempDir()+File.separator+fileName;
            URL url = new URL(urlImage);
            InputStream is =  url.openStream();
            OutputStream os = new FileOutputStream(destino);
            
            byte[] b = new byte[2048];
            int lenght=0;
            System.out.println("Baixando imagem em cache...");
            while((lenght = is.read(b))!=-1){
                os.write(b, 0, lenght);
            }
            System.out.println("Donwload concluído...");
            is.close();
            os.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImageCache.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImageCache.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getTempDir(){
         String temp = System.getProperty("java.io.tmpdir")+File.separator+"app";
         File file = new File(temp);
         if(!file.exists()){
             file.mkdirs();
         }
         return temp;
    }
    
    public static String getFullPathFromImageUrl(String imageUrl){
        return getTempDir()+File.separator+getNameFile(imageUrl);
    }
    
    public static String getNameFile(String url){
        String fileName = url;
        fileName= fileName.replace("http","");
        fileName = fileName.replace("/", "");
        fileName = fileName.replace(":", "");
        return fileName;
    }
}
