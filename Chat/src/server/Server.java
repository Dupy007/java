package server;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    private static int PORT= 9081;
    public static ArrayList<PrintWriter> al = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new Server();
    }
    public Server() throws Exception  {
        System.out.println("Server signing On");
        ServerSocket ss = new ServerSocket(PORT);
        for (int i = 0; i < 100; i++) {
            Socket soc = ss.accept();
            Conversation c = new Conversation(soc);
            c.start();
        }
        System.out.println("Server signing Off");
    }
    class Conversation extends Thread {

        Socket soc;
        public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+-=[]\\;',./{}|:\"<>?0123456789";
        public Conversation(Socket soc) {
            this.soc = soc;
        }

        @Override
        public void run() {
            System.out.println("Conversation thread  "+
                    Thread.currentThread().getName() +
                    "   signing On");
            try {

                BufferedReader nis = new BufferedReader(
                        new InputStreamReader(
                                soc.getInputStream()
                        )
                );
                PrintWriter nos = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        soc.getOutputStream()
                                )
                        ), true
                );
                Server.al.add(nos);
                String str = nis.readLine();
                while(!str.equals("End")){
                    if(str.contains("FiLe$;")){
                        String[] name = str.split(";");
                        System.out.println(name[name.length-1]);
                        new Thread(new SimpleFileServer(name[name.length-1], PORT+1)).start();

                    }
                    System.out.println("Server Recieved  " + str/*encrypt(str, 3)*/);
                    for (PrintWriter o : Server.al) {
                        o.println(str);
                    }
                    str = nis.readLine();
                }
                nos.println("End");
            }
            catch(Exception e){
                System.out.println("Client Seems to have abruptly closed the connection");
            }
            System.out.println("Conversation thread  "+
                    Thread.currentThread().getName() +
                    "   signing Off");
        }
        public String encrypt(String plainText, int shiftKey)
        {
            plainText = plainText.toLowerCase();
            String cipherText = "";
            for (int i = 0; i < plainText.length(); i++)
            {
                int charPosition = ALPHABET.indexOf(plainText.charAt(i));
                int keyVal = (shiftKey + charPosition) % 26;
                char replaceVal = ALPHABET.charAt(keyVal);
                cipherText += replaceVal;
            }
            return cipherText;
        }
        public String decrypt(String cipherText, int shiftKey)
        {
            cipherText = cipherText.toLowerCase();
            String plainText = "";
            for (int i = 0; i < cipherText.length(); i++)
            {
                int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
                int keyVal = (charPosition - shiftKey) % 26;
                if (keyVal < 0)
                {
                    keyVal = ALPHABET.length() + keyVal;
                }
                char replaceVal = ALPHABET.charAt(keyVal);
                plainText += replaceVal;
            }
            return plainText;
        }
    }
    private static class SimpleFileServer implements Runnable{

        private int SOCKET_PORT ;
        private String FILE_TO_SEND ;

        public SimpleFileServer(String FILE_TO_SEND, int SOCKET_PORT){
            this.FILE_TO_SEND=FILE_TO_SEND;
            this.SOCKET_PORT=SOCKET_PORT;
        }

        public void run() {
            this.start();
        }

        public void start() {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            ServerSocket servsock = null;
            Socket sock = null;
            try {
                servsock = new ServerSocket(SOCKET_PORT);
                while (true) {
                    System.out.println("Waiting...");
                    try {
                        sock = servsock.accept();
                        // send file
                        File myFile = new File (FILE_TO_SEND);
                        byte [] mybytearray  = new byte [(int)myFile.length()];
                        fis = new FileInputStream(myFile);
                        bis = new BufferedInputStream(fis);
                        bis.read(mybytearray,0,mybytearray.length);
                        os = sock.getOutputStream();
                        System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
                        os.write(mybytearray,0,mybytearray.length);
                        os.flush();
                        System.out.println("Done.");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage()+": An Inbound Connection Was Not Resolved");
                    } finally {
                        if (bis != null) {
                            try {
                                bis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (os != null) {
                            try {
                                os.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (sock != null) {
                    try {
                        sock.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Ending...");
                    }
        }

    }
}
