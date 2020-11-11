
import jdk.internal.access.JavaLangInvokeAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PlayBook {

    public static void main(String[] args) {
    init();
    }

    public static void init() {
        JFrame frame = new JFrame("Dupy Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,250));
        frame.setResizable(false);
        JLabel label = new JLabel("Bienvenue\n");
        JTextField textField = new JTextField("Entrez l'url");
        JButton submit = new JButton("Submit");
//        textField.setPreferredSize(new Dimension(175,25));
//        submit.setPreferredSize(new Dimension(75,25));
        submit.disable();
//        textField.addFocusListener(new FocusAdapter() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                super.focusGained(e);
////                if (textField.getText().contains("Entrez l'url"))
////                        submit.enable();
//                if (!textField.getText().contains("Entrez l'url") || !textField.getText().equals("") ){
//                    submit.enable();
//                }
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                super.focusLost(e);
//                if (!textField.getText().equals("") ){
//                    submit.disable();
//                    textField.setText("Entrez l'url");
//                }else{
//
//                }
//
//
//            }
//        });
        submit.addActionListener(e -> {
            open(textField.getText());
        });
        JLabel label1 = new JLabel("Choissisez une image");
        JButton button = new JButton("Selectionner une image");
        button.addActionListener( e -> open());

        label1.setPreferredSize(new Dimension(250,250));
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(textField);
        frame.add(submit);
        frame.add(button);
        frame.add(label1);
        frame.setJMenuBar(Menu());
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public static JMenuBar Menu() {
//		--- Creation menu ---
        JMenuBar menu = new JMenuBar();

//		--- Creation des menus bar ---
        JMenu f = new JMenu("File");

//		--- Creation des items des menus ---
        JMenuItem ne = new JMenuItem("Ouvrir");

//		--- Evenement ---
        ne.addMouseListener( new MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
         open();
            }
        } );

//		--- ajoutation des menus bar ---
        menu.add(f);
        f.add(ne);

        return menu;
    }



    public static void open(String a) {
        BufferedImage image = null;
        String targetDirectory= new File("").getAbsolutePath();
        URL url = null;
        try {
            url = new URL(a);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try(
                InputStream in = url.openStream()){
            String ext = url.getFile();
            Files.copy(in , Paths.get(url.getFile()) , StandardCopyOption.REPLACE_EXISTING);
        System.out.println(url.getFile());
        Viewer viewer = new Viewer(url.getFile());
        viewer.start();

        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

//        try{
//
//
//            URL url =new URL(a);
//                    // read the url
//                    image = ImageIO.read(url);
//
////            for png
//            ImageIO.write(image, "png",new File("./image.png"));
//
//            // for jpg
//            ImageIO.write(image, "jpg",new File("./image.jpg"));
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }
        public static void open(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {


            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

            Viewer viewer = new Viewer(selectedFile.getAbsolutePath());
            viewer.start();
        }
    }

    private static class Viewer implements Runnable{

        private final String src ;
//        private final Dimension dimension = new Dimension(400,400);
        public Viewer(String src){
            this.src=src;
        }

        @Override
        public void run() {
this.start();
        }

        private void start() {
            JFrame frame = new JFrame("Dupy Viewer");
//            frame.setSize(dimension);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Container contentPane = frame.getContentPane();
            JLabel label = new JLabel();
            label.setIcon( new ImageIcon(src) );

// Add the cardPanel to the content pane
            contentPane.add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }

    }
}
