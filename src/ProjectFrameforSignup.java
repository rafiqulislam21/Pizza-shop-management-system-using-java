
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders;

public class ProjectFrameforSignup extends JFrame {

    JFrame thisFrame = this;

    public ProjectFrameforSignup() {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    JButton jbManager;
    JButton jbOrder;
    JButton jbExit;
    JButton jbLogout;
    JTextField textName;
    JTextField textName2;
    JTextField textName3;
    JTextField textName4;
    JPasswordField passField2;

    public void addComponent() {
        this.setLayout(null);

        ImageIcon image = new ImageIcon("src/pizza.png");
        JLabel label = new JLabel(image);
        label.setBounds(420, 200, 400, 300);
        add(label);

        jbExit = new JButton("Back");
        jbExit.setBounds(605, 500, 70, 40);
        this.add(jbExit);

        jbLogout = new JButton("Submit");
        //button3.setBackground(Color.RED);
        jbLogout.setBounds(500, 500, 80, 40);
        this.add(jbLogout);

        JLabel jlList = new JLabel("Fill the Blanks with Propeer Information :");
        jlList.setBounds(40, 20, 300, 20);
        this.add(jlList);

        JLabel jlList2 = new JLabel("Full Name:");
        jlList2.setBounds(40, 70, 200, 20);
        this.add(jlList2);

        JLabel jlList3 = new JLabel("User Id:");
        jlList3.setBounds(40, 140, 200, 20);
        this.add(jlList3);

        JLabel jlList4 = new JLabel("Email:");
        jlList4.setBounds(40, 200, 200, 20);
        this.add(jlList4);
        JLabel jlList5 = new JLabel("Password:");
        jlList5.setBounds(40, 260, 200, 20);
        this.add(jlList5);

        textName = new JTextField();////////full name//
        textName.setBounds(40, 90, 250, 30);
        this.add(textName);

        textName2 = new JTextField();////////username/id////////
        textName2.setBounds(40, 160, 250, 30);
        this.add(textName2);

        textName3 = new JTextField();////////mail/////////
        textName3.setBounds(40, 220, 250, 30);
        this.add(textName3);

        passField2 = new JPasswordField();////////pass///////////
        passField2.setBounds(40, 280, 250, 30);
        this.add(passField2);

    }

    void addActionFrame1() {
/////////////////////////////for how many user/////////////////////
        int count1 = 0;
        String stringArrayFromFileLine1[] = null;
        FileReader fr1Manager = null;
        BufferedReader br1Manager = null;

        try {
            fr1Manager = new FileReader("src/user.txt");
            br1Manager = new BufferedReader(fr1Manager);

            String s1 = br1Manager.readLine();

            while (s1 != null) {
                //System.out.println(s);
                stringArrayFromFileLine1 = s1.split("\\|");

                s1 = br1Manager.readLine();
                count1++;
            }
            br1Manager.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr1Manager != null) {
                    fr1Manager.close();
                }
                if (br1Manager != null) {
                    br1Manager.close();
                }

            } catch (Exception e) {
            }
        }
        int z = count1;

        User u[] = new User[z];

        String stringArrayFromFileLin[] = null;

        BufferedReader brManage = null;
        FileReader frManage = null;
        int j = 0;
        try {
            frManage = new FileReader("src/user.txt");
            brManage = new BufferedReader(frManage);

            String s = brManage.readLine();

            while (s != null) {
                //System.out.println(s);
                stringArrayFromFileLin = s.split("\\|");
                //manager(name,                       address,                    status,                     id)                                                 password
                u[j] = new User(stringArrayFromFileLin[0], stringArrayFromFileLin[1], stringArrayFromFileLin[2], stringArrayFromFileLin[3], stringArrayFromFileLin[4]);

                s = brManage.readLine();
                j++;
            }
            brManage.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (frManage != null) {
                    frManage.close();
                }
                if (brManage != null) {
                    brManage.close();
                }

            } catch (Exception e) {
            }
        }

///////////////////////////////////////////////////
        ActionListener exitButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                thisFrame.dispose();
                Login login = new Login(u[0].getStatus());
                login.setResizable(false);
                login.addComponent();
                login.addAction();

                login.setVisible(true);
            }
        };
        jbExit.addActionListener(exitButton);

        ActionListener SubmitButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                /////////signup/////////////
                if (textName.getText() == null || textName.getText().equals("")
                        || (textName2.getText() == null || textName2.getText().equals(""))
                        || (textName3.getText() == null || textName3.getText().equals(""))
                        || (passField2.getPassword() == null || passField2.getText().equals(""))) {
                    //labelTestLogin.setText("Login id or password not provided");
                    JOptionPane.showMessageDialog(null, "Some info is missing" + "\nFill Each Information CorrectLy");

                } else if ((textName.getText() != null)//////////name
                        && (textName2.getText() != null)/////id
                        && (textName3.getText() != null)////mail
                       && (passField2.getPassword() != null)) {

                    String idFromText = textName.getText();///name
                    String idFromText1 = textName2.getText();///id
                    String idFromText2 = textName3.getText();//mail
                    String passwordFromText = new String(passField2.getPassword());
                    int k = 0;
                    for (int i = 0; i < u.length; i++) {

                        if (idFromText1.equalsIgnoreCase(u[i].getId())) {

                            JOptionPane.showMessageDialog(null, "User id caannot be this ");
                            k++;

                            ProjectFrameforSignup pfs = new ProjectFrameforSignup();

                            pfs.addComponent();
                            pfs.addActionFrame1();
                            pfs.setResizable(false);
                            pfs.setVisible(true);
                            thisFrame.dispose();
                            break;
                        }
                        

                    }
                    if (k == 0) {    ////////////write code goes here////////
                        File f = null;
                        FileWriter fw = null;
                        BufferedWriter bw = null;

                        try {

                            fw = new FileWriter("src/user.txt", true);

                            bw = new BufferedWriter(fw);
                            bw.newLine();
                    /////////            name                id              mail                 pass                  status    
                            bw.write(idFromText + "|" + idFromText2 + "|" + idFromText1 + "|" + passwordFromText + "|" + u[0].getStatus());

                        } catch (FileNotFoundException e) {
                            System.out.println("File not found");
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {

                                if (bw != null) {
                                    bw.close();
                                }
                                if (fw != null) {
                                    fw.close();
                                }
                            } catch (Exception e) {
                            }
                        }
                        ////////////////////////////////////////////////////
                        JOptionPane.showMessageDialog(null, "sign up Succesfull");
                        thisFrame.dispose();
                        Login login = new Login(u[0].getStatus());
                        login.setResizable(false);
                        login.addComponent();
                        login.addAction();

                        login.setVisible(true);

                    }

                }

            }

        };
        jbLogout.addActionListener(SubmitButton);

    }
}
