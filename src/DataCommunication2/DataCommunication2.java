/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataCommunication2;

import java.io.*;
import java.net.*;


/**
 *
 * @author Muhammed
 */
public class DataCommunication2 {
     static Socket socket = null;
    static int maxsize = 999999999;
    static int byteread;
    static int current = 0;
    public static void main(String[] args) throws FileNotFoundException, IOException{
        byte[] buffer = new byte[maxsize];
        Socket socket = new Socket("localhost", 9099);
        InputStream is = socket.getInputStream();
        File test = new File("D:\\AtomSetup.exe");
        test.createNewFile();
        FileOutputStream fos = new FileOutputStream(test);
        BufferedOutputStream out = new BufferedOutputStream(fos);
        byteread = is.read(buffer, 0, buffer.length);
        current = byteread;

        do{
            byteread = is.read(buffer, 0, buffer.length - current);
            if (byteread >= 0) current += byteread;
        } while (byteread > -1);
        out.write(buffer, 0, current);
        out.flush();

        socket.close();
        fos.close();
        is.close();

    }
}
