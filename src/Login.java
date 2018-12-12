
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    JFrame thisFrame = this;

    JLabel labelId;
    JLabel labelPass;
    JLabel labelTestLogin;

    JTextField textLogin;
    JPasswordField passField;

    JButton btnLogin;
    JButton btnSignUp;

    JComboBox cBoxUserType;
    String[] userTypes = {"Manager", "User"};

    public String typeofuse;

    public Login() {
        super("Pizza Management System");
        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public Login(String type) {
        super("Pizza Management System");
        this.setLayout(null);
        this.setSize(600, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.typeofuse = type;

    }

    public void addComponent() {

        ImageIcon image = new ImageIcon("src/login.png");
        JLabel label = new JLabel(image);
        label.setBounds(120, 0, 400, 300);
        add(label);

        labelId = new JLabel("ID : ");
        labelPass = new JLabel("Password : ");
        labelTestLogin = new JLabel();
        textLogin = new JTextField();
        passField = new JPasswordField();

        cBoxUserType = new JComboBox(userTypes);

        btnLogin = new JButton("Login");
        btnSignUp = new JButton("Signup");

        labelId.setBounds(100, 350, 100, 30);
        labelPass.setBounds(100, 400, 100, 30);
        labelTestLogin.setBounds(200, 500, 350, 30);

        textLogin.setBounds(200, 350, 250, 30);
        passField.setBounds(200, 400, 250, 30);
        cBoxUserType.setBounds(200, 300, 250, 30);

        btnLogin.setBounds(200, 450, 250, 30);
        btnLogin.setBackground(Color.blue);
        btnLogin.setForeground(Color.WHITE);
        btnSignUp.setBounds(325, 490, 125, 30);
        btnSignUp.setBackground(Color.red);
        btnSignUp.setForeground(Color.WHITE);

        this.add(labelId);
        this.add(labelPass);
        this.add(labelTestLogin);

        this.add(textLogin);
        this.add(passField);
        this.add(cBoxUserType);

        this.add(btnLogin);
        this.add(btnSignUp);

    }

    public void addAction() {

        //read manager info
        Manager m[] = new Manager[3];

        String stringArrayFromFileLine[] = null;

        BufferedReader brManager = null;
        FileReader frManager = null;
        int i = 0;
        try {
            frManager = new FileReader("src/Manager.txt");
            brManager = new BufferedReader(frManager);

            String s = brManager.readLine();

            while (s != null) {
                //System.out.println(s);
                stringArrayFromFileLine = s.split("\\|");
                //manager(name,                       address,                    status,                     id)                                                 password
                m[i] = new Manager(stringArrayFromFileLine[0], stringArrayFromFileLine[1], stringArrayFromFileLine[2], stringArrayFromFileLine[3], stringArrayFromFileLine[4]);

                s = brManager.readLine();
                i++;
            }
            brManager.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (frManager != null) {
                    frManager.close();
                }
                if (brManager != null) {
                    brManager.close();
                }

            } catch (Exception e) {
            }
        }

        //////////////////////////userStart/////////////////////////////////////////////
        ///////////////////////////for how many user//////////////////////////////////////////
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

        //////////////////////////////////////////////////////////////////////////////////
        User u[] = new User[z];

        String stringArrayFromFileLin[] = null;

        BufferedReader brManage = null;
        FileReader frManage = null;
        int j = 0;
        try {
            frManage = new FileReader("src/user.txt");
            brManage = new BufferedReader(frManage);

            String f = brManage.readLine();

            while (f != null) {
                //System.out.println(s);
                stringArrayFromFileLin = f.split("\\|");
                             //manager(name,                       mail,                    id,                     password)                           status
                u[j] = new User(stringArrayFromFileLin[0], stringArrayFromFileLin[1], stringArrayFromFileLin[2], stringArrayFromFileLin[3], stringArrayFromFileLin[4]);

                f = brManage.readLine();
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

        //////////////////////////////userEnd///////////////////////////////////////////////
        ActionListener loginButton = new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {

                //cheaking valid password    
                if (textLogin.getText() == null || textLogin.getText().equals("")) {
                    //labelTestLogin.setText("Login id or password not provided");
                    JOptionPane.showMessageDialog(null, "Please Enter id and password." + "\nLogin id or password not provided");

                } else {

                    String idFromText = textLogin.getText();

                    String passwordFromText = new String(passField.getPassword());
                    String type = (String) cBoxUserType.getSelectedItem();

                    String f = "Manager";
                    String h = "User";

                    if (type.equalsIgnoreCase(f) || f.equalsIgnoreCase(typeofuse)) {
                        if ((idFromText.equals(m[0].getId()) && passwordFromText.equals(m[0].getPassword()))
                                || (idFromText.equals(m[1].getId()) && passwordFromText.equals(m[1].getPassword()))
                                || (idFromText.equals(m[2].getId()) && passwordFromText.equals(m[2].getPassword()))) {
                            JOptionPane.showMessageDialog(null, "Login Success.");

                            ProjectFrame1 pf1 = new ProjectFrame1(idFromText);
                            pf1.addComponent();
                            pf1.addActionFrame1();
                            pf1.setResizable(false);
                            pf1.setVisible(true);
                            thisFrame.dispose();
                            //System.out.println((m[0].getPassword()));
                            //ProjectFrame2 pf2 = new ProjectFrame2(0);//////////////////
                        } else {

                            JOptionPane.showMessageDialog(null, "Try Again" + "\nLogin id or password is incorrect.");

                        }
                    } //////////////////////////user///////////////////////////////////////
                    else if (type.equalsIgnoreCase(h) || h.equalsIgnoreCase(typeofuse)) {
                        boolean flag = false;
                        for (int i = 0; i < z; i++) {

                            if (idFromText.equalsIgnoreCase(u[i].getId()) && passwordFromText.equalsIgnoreCase(u[i].getPassword())) {
                                JOptionPane.showMessageDialog(null, "Login Success.");

                                ProjectFrame3 pf3 = new ProjectFrame3(idFromText);
                                pf3.addComponent();
                                pf3.addActionFrame1();
                                pf3.setResizable(false);
                                pf3.setVisible(true);
                                thisFrame.dispose();
                                flag = true;
                                //ProjectFrame2 pf2 = new ProjectFrame2(1);//////////////////
                                break;

                            }
                        }
                        if (flag == false) {
                            JOptionPane.showMessageDialog(null, "Try Again" + "\nLogin id or password is incorrect.");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Please Enter id and password." + "\nLogin id or password not provided");

                    }

                }
            }

        };
        btnLogin.addActionListener(loginButton);
        ///////////////////////////////signup///////////////////////////////////////////////////////////////////////////    

        ActionListener signup = new ActionListener() {
            public void actionPerformed(ActionEvent me) {

                String type = (String) cBoxUserType.getSelectedItem();
                String h = "user";
                if (type.equalsIgnoreCase(h)) {

                    ProjectFrameforSignup pfs = new ProjectFrameforSignup();

                    pfs.addComponent();
                    pfs.addActionFrame1();
                    pfs.setResizable(false);
                    pfs.setVisible(true);
                    thisFrame.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "No permission to signup as a manager !");
                }

            }
        };

        btnSignUp.addActionListener(signup);
        //System.out.println(type);
        //////////////////////////////////////////////////////////////////////////////////      
    }

}
