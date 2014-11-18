/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
/**
 *
 * @author Dog
 */
public class Client {
    public static int port = 8080;
    
    public static void main(String args[]) throws Exception{
        String ip = "127.0.0.1";
        Socket client  = new Socket(ip,port);
        InputStream input = client.getInputStream();
        StringBuffer buffer = new StringBuffer();
        try{
            while(true){
                int by = input.read();
                if(by == -1){
                    break;
                }
                byte b = (byte) by;
                buffer.append((char)b);
                System.out.println(buffer.toString());
            }
        }catch(Exception ex){
            input.close();
        }
        
        System.out.println(buffer);
        //one time test should be close client!
        client.close();
    }
}