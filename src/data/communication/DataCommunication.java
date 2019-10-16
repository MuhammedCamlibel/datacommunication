/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.communication;


import java.io.*;
import java.net.*;
/**
 *
 * @author Muhammed
 * Server Tarafı 
 */
public class DataCommunication {
     static ServerSocket serversoket = null;
    static OutputStream out = null;
    static Socket soket = null;
    static File metin = new File("C:\\Users\\Muhammed\\Documents\\test.txt");
    static byte[] buffer = new byte[(int) metin.length()];
    public static void main(String[] args) throws IOException{
        serversoket = new ServerSocket(9099);
        soket = serversoket.accept();
        System.out.println("Accepted connection from : " + soket);
        FileInputStream fis = new FileInputStream(metin);
        BufferedInputStream in = new BufferedInputStream(fis);
        in.read(buffer,0,buffer.length);
        out = soket.getOutputStream();
        System.out.println("Dosya gönderiliyor.");
        out.write(buffer,0, buffer.length);
        out.flush();
        out.close();
        in.close();
        soket.close();
        System.out.println("Yollama başarılı.");
    }
}
