/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author FD314
 */
public class Secuencial {
     public static FileOutputStream fos;
    public static FileInputStream fis;    

    public static String readFile(File file)
            throws IOException{
        String cadena = "";
        int n ;
        if(!file.exists()){
            return null;
        }
        fis = new FileInputStream(file);
        while((n = fis.read()) != -1){
            cadena += (char)n;
        }
        fis.close();
        return cadena;
    }
    
    public static void writeFile(File file,String cadena)
            throws IOException{
        if(!file.exists()){
            file.createNewFile();
        }
        fos = new FileOutputStream(file,true);
        fos.write(cadena.getBytes());
        fos.close();
    }
    
}
