package client;

import net.codejava.sound.SoundRecordingUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Client{


//    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+-=[]\\;',./{}|:\"<>?0123456789";
    private static boolean isRecording = false;
    private static SoundRecordingUtil recorder = new SoundRecordingUtil();
    private static String name;
    private static ArrayList fname = new ArrayList();
    private static String uname = new String();
    public static ArrayList<JButton> arrayBtn= new ArrayList<>();
    private static int PORT=9081;
    private static String SERVER = "127.0.0.1";

    private static final String os = System.getProperty("os.name").toLowerCase();


    public static void main(String[] args) throws Exception  {
        Process variable;
        if(os.contains("win"))
            variable = Runtime.getRuntime().exec("NET VIEW ");
        else
            variable = Runtime.getRuntime().exec("sudo Netdiscover");
        System.out.println(variable);

//        Socket soc = new Socket("192.168.43.28",9081);
        Socket soc = new Socket(SERVER,PORT);
        BufferedReader nis = new BufferedReader(
                                new InputStreamReader( soc.getInputStream() ) );
        PrintWriter nos =  new PrintWriter(
                                new BufferedWriter( new OutputStreamWriter( soc.getOutputStream() ) ),true);

//        uname=uname();

        JFrame f1 = new JFrame(uname);
        String mic ="\uD83C\uDF99",emoji = "\uD83D\uDE04",camera="\uD83D\uDCF7";
        JButton b1 = new JButton("Send");JButton b2 = new JButton(mic+"Micro");
        JButton b3 = new JButton(camera+"camera");JButton b4 = new JButton(emoji+"Emoji");
//        JTextArea ta = new JTextArea();JTextArea te = new JTextArea();
        JTextField tf = new JTextField(20);
        JPanel p1 = new JPanel();JPanel p2 = new JPanel();JPanel p3 = new JPanel();


        p2.setBackground(Color.gray);
        System.out.println("\uD83C\uDF99");
        p2.setLayout(new BoxLayout(p2,BoxLayout.PAGE_AXIS));

//        b2.setIcon(new ImageIcon("client/Media/micro.jpeg"));
//        b2.setPreferredSize(new Dimension(40,40));
//        b3.setPreferredSize(new Dimension(20,20));

        p1.add(tf);
        p1.add(b1);p1.add(b3);p1.add(b2);p1.add(b4);

        p2.setMinimumSize(new Dimension(400,250));
        p3.setSize(new Dimension(400,100));
        p3.add( emoji() );

        f1.add(p2);
//        f1.add(p3);
        f1.add(BorderLayout.SOUTH,p1);


        ChatListener l1 = new ChatListener(tf,nos,uname);
        b1.addActionListener(l1);
        tf.addActionListener(l1);

        final boolean[] ver = {false,false};
//        mic action

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ver[0]){
                    ver[0] =true;
                    tf.hide();
                    b1.hide();
                    b3.hide();
                    b4.hide();
                    b2.setText("Stop");
                    startRecording();
                }else{
                    ver[0]=false;
                    tf.show();
                    b1.show();
                    b3.show();
                    b4.show();
                    b2.setText("Micro");
                    stopRecording();
                    JButton play = new JButton(name);
                    arrayBtn.add(play);
                    fname.add(name);

//                    arrayBtn.get(arrayBtn.size()-1).setText("Lire: "+name);
//                    p2.add(arrayBtn.get(arrayBtn.size()-1));
                    String s = "FiLe$;voice;"+name;
                    nos.println(uname+" : "+s);
                }
                int i=0;
                for (JButton play:arrayBtn) {
                    int finalI = i;
                    play.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(fname.get(finalI));
                        }
                    });
                    i++;
                }
            }
        });
//        screenshot action
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    screen(f1);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
//        emoji action
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ver[1]){
                    ver[1] =true;
                    f1.setSize(600,400);
                    f1.add(BorderLayout.SOUTH,new JScrollPane( emoji() ) );
                }else{
                    ver[1]=false;
                    f1.remove(emoji());
                    f1.setSize(500,400);
                }
            }
        });

        f1.setSize(500,400);
        f1.setMinimumSize(new Dimension(450,400));
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        System.out.println("map pase bo kot while la");

        String str = nis.readLine();
        while(!str.equals("End")){
            System.out.println("konnya nu anndan while la");
            if(str.contains("FiLe$;")){
                String[] name = str.split(";");
                if (name[name.length-2].contains("Voice") ){
                    System.out.println("Voice");
                }else /*if (!name[name.length-2].contains(null) )*/{
                    System.out.println(name[name.length-2]);
                }
                new Thread(new SimpleFileClient(PORT+1,SERVER)).start();
                JButton button = new JButton(/*name[name.length-1]*/);
                p2.add(button);
                button.setPreferredSize(new Dimension(30,10));
                button.setText("Play"+name[name.length-1]);
            }else
            {
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false);
                textArea.setSize(new Dimension(360, 20));
                p2.add(textArea, BorderLayout.WEST);
                textArea.append(str);
            }
            str = nis.readLine();
        }
//        ta.append("Client Signing Off");
        Thread.sleep(1000);
        System.exit(0);
    }
//    Fonction option pane pour recuperer le nom
    public static String uname(){

        JFrame frame = new JFrame("Get Username");

        uname = JOptionPane.showInputDialog(frame, "Enter your Username :");
        if (uname == null) {
            uname = "Unknown";
        }
        return uname;
    }
    public static JPanel emoji(){
        JPanel panel = new JPanel();
        ArrayList<JButton> buttons = new ArrayList<>();
        //        emojis
        File file = new File("Media/emojis.json");
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Object o : jsonArray) {
            JSONObject person = (JSONObject) o;
            String strName = (String) person.get("emoji");
//            System.out.println("Name::::" + strName);
            buttons.add(new JButton(strName));

        }

        GridLayout gridLayout = new GridLayout(4,8/*(buttons.size()-1)/4*/,3,3);
        panel.setLayout(gridLayout);
        for (JButton a: buttons ) {
            panel.add( a ,gridLayout);
            a.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(a.getText());
                }
            });
        }
//        end
        return panel;
    }
    public static void screen(Frame frame) throws Exception {
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(frame.getSize()));
        ImageIO.write(screenShot, "JPG", new File("Media/"+mnt()+".jpg"));
        System.out.println(mnt());
    }
    private static void startRecording() {
        Thread recordThread = new Thread(new Runnable() {


            @Override
            public void run() {
                try {

                    isRecording = true;

                    recorder.start();

                } catch (LineUnavailableException ex) {

                    ex.printStackTrace();
                }
            }
        });
        recordThread.start();
    }
    private static void stopRecording() {
        isRecording = false;
        try {
            recorder.stop();
            name = (/*new File("").getPath()+*/"Media/" +mnt()+".wav");
            recorder.save(new File(name));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String mnt(){
//        fonction pour recuperer l heure et la data actuel
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-hh:mm:ss:a");
        Calendar now = Calendar.getInstance();
        return formatter.format(now.getTime());
    }

//     public static String encrypt(String plainText, int shiftKey)
//    {
//        plainText = plainText.toLowerCase();
//        String cipherText = "";
//        for (int i = 0; i < plainText.length(); i++)
//        {
//            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
//            int keyVal = (shiftKey + charPosition) % 26;
//            char replaceVal = ALPHABET.charAt(keyVal);
//            cipherText += replaceVal;
//        }
//        return cipherText;
//    }
//     public static String decrypt(String cipherText, int shiftKey)
//    {
//        cipherText = cipherText.toLowerCase();
//        String plainText = "";
//        for (int i = 0; i < cipherText.length(); i++)
//        {
//            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
//            int keyVal = (charPosition - shiftKey) % 26;
//            if (keyVal < 0)
//            {
//                keyVal = ALPHABET.length() + keyVal;
//            }
//            char replaceVal = ALPHABET.charAt(keyVal);
//            plainText += replaceVal;
//        }
//        return plainText;
//    }
    
}

class ChatListener implements ActionListener{
   JTextField tf ;
   PrintWriter nos;
   String uname;
    public ChatListener(JTextField tf, PrintWriter nos, String uname){
        this.tf = tf;
        this.nos = nos;
        this.uname = uname;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str  = tf.getText();
        nos.println(uname+" : "+str);
        tf.setText("");
    }
    

}

class VoiceListener implements ActionListener{
    JTextField tf ;
    PrintWriter nos;
    String uname;
    public VoiceListener(JTextField tf, PrintWriter nos, String uname){
        this.tf = tf;
        this.nos = nos;
        this.uname = uname;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String str  = tf.getText();
        nos.println(uname+" : "+str);
        tf.setText("");
    }


}

 class SimpleFileClient implements Runnable{

    private int PORT;
    private String FILE_TO_RECEIVED = Client.mnt(),SERVER;
    private int FILE_SIZE = 1024*1024;
    private BufferedOutputStream bos;

    public SimpleFileClient(int PORT, String SERVER){
        this.PORT = PORT;
        this.SERVER = SERVER;
    }

    public void run() {
        this.start();
    }

    public void start() {
        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        Socket sock = null;


        try {
            sock = new Socket(SERVER, PORT);
            System.out.println("Connecting...");

            // receive file
            byte [] mybytearray  = new byte [FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVED);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray,0,mybytearray.length);
            current = bytesRead;

            do {
                bytesRead =
                        is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);

            bos.write(mybytearray, 0 , current);
            bos.flush();
            System.out.println("File " + FILE_TO_RECEIVED
                    + " downloaded (" + current + " bytes read)");
        }catch(Exception ex ){
            ex.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//class server
class Server {

    public static ArrayList<PrintWriter> al = new ArrayList<>();
    public Server() throws Exception  {
        System.out.println("Server signing On");
        ServerSocket ss = new ServerSocket(9081);
        for (int i = 0; i < 100; i++) {
            Socket soc = ss.accept();
            Conversation c = new Conversation(soc);
            c.start();
        }
        System.out.println("Server signing Off");
    }
    class Conversation extends Thread {

        Socket soc;
        public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
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
                    System.out.println("Server Recieved  "+encrypt(str,3));
                    for(PrintWriter o : Server.al){
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
}

