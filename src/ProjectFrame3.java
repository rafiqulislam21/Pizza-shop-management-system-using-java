
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalBorders;

public class ProjectFrame3 extends JFrame {
    
    public String idFromText;
    JFrame thisFrame = this;
    
    public ProjectFrame3(String idFromText) {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.idFromText = idFromText;

    }
    
    public ProjectFrame3() {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    JButton jbUger;
    JButton jbOrder;
    JButton jbExit;
    JButton jbLogout;

    public void addComponent() {
        this.setLayout(null);

        ImageIcon image = new ImageIcon("src/pizza.png");
        JLabel label = new JLabel(image);
        label.setBounds(420, 200, 400, 300);
        add(label);

        jbUger = new JButton("User Information");
        jbUger.setBounds(545, 100, 170, 40);
        this.add(jbUger);

        jbOrder = new JButton("Order");
        jbOrder.setBounds(700, 500, 70, 40);
        this.add(jbOrder);

        jbExit = new JButton("Exit");
        jbExit.setBounds(605, 500, 70, 40);
        this.add(jbExit);

        jbLogout = new JButton("Logout");
        //button3.setBackground(Color.RED);
        jbLogout.setBounds(500, 500, 80, 40);
        this.add(jbLogout);

        JLabel jlList = new JLabel("Pizza List : ");
        jlList.setBounds(40, 20, 100, 20);
        this.add(jlList);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(40, 50, 400, 500);
        textArea.setBorder(new MetalBorders.TextFieldBorder());
        textArea.setBackground(Color.lightGray);
        textArea.setText("Pizza name                              |       Size              |    Prize(tk)\n"
                + "--------------------------------------|----------------------|-------------------------------------------\n"
                + "1) BBQ Temtation                   |       Small           |    600\n"
                + "2) BBQ Temtation                   |       Medium       |    750\n"
                + "3) BBQ Temtation                   |       Large           |    1000\n"
                + "4) Tropical Chicken                |       Small           |    550\n"
                + "6) Tropical Chicken                |       Medium       |    700\n"
                + "7) Tropical Chicken                |       Large           |    950\n"
                + "8) Spicy Beef                            |       Small           |    650\n"
                + "9) Spicy Beef                            |       Medium       |    800\n"
                + "10) Spicy Beef                          |       Large           |    1200\n"
                + "11) BBQ Blast                          |       Small           |    550\n"
                + "12) BBQ Blast                          |       Medium       |    700\n"
                + "13) BBQ Blast                          |       Large           |    1000\n"
                + "14) Chicken Hawalian           |       Small           |    500\n"
                + "15) Chicken Hawalian           |       Medium       |    680\n"
                + "16) Chicken Hawalian           |       Large           |    980\n"
                + "17) Red N hot                          |       Small           |    520\n"
                + "18) Red N hot                          |       Medium       |    720\n"
                + "19) Red N hot                          |       Large           |    920\n"
                + "19) Meat Lovens                     |       Small           |    480\n"
                + "20) Meat Lovens                     |       Medium       |    650\n"
                + "21) Meat Lovens                     |       Large           |    980\n"
                + "22) Chicken Royal                  |       Small           |    510\n"
                + "23) Chicken Royal                  |       Medium       |    710\n"
                + "24) Chicken Royal                  |       Large           |    1100\n"
                + "25) Neapolitan                        |       Small           |    650\n"
                + "26) Neapolitan                        |       Medium       |    850\n"
                + "27) Neapolitan                        |       Large           |    1250\n"
        );

        this.add(textArea);

    }

    void addActionFrame1() {

        ActionListener logoutButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Login lgn = new Login();
                lgn.setResizable(false);
                lgn.addComponent();
                lgn.addAction();
                lgn.setVisible(true);
                thisFrame.dispose();
            }
        };
        jbLogout.addActionListener(logoutButton);

        
        ActionListener orderButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProjectFrame4 pf4 = new ProjectFrame4(idFromText);
                pf4.setResizable(false);
                pf4.addComponent();
                pf4.addActionFrame2();		
                pf4.setVisible(true);
                thisFrame.dispose();
            }
        };
        jbOrder.addActionListener(orderButton);
        
        
        ActionListener exitButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        };
        jbExit.addActionListener(exitButton);
        //////////////////////user array///////////////////////////////////////
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
                  
                  
        
        
        //////////////////////////////////////////////////////////////////
        
        //manager information button
         
        ActionListener managerInformationButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                 
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
                        u[j] = new User(stringArrayFromFileLin[0], stringArrayFromFileLin[1], stringArrayFromFileLin[2], stringArrayFromFileLin[3],stringArrayFromFileLin[4]);
                        
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
                  
                
                //Display currently login manager info 
                for(int i=0;i<z;i++){
                if(idFromText.equals(u[i].getId())){
                    u[i].addComponent();
                    u[i].setResizable(false);
                    u[i].setVisible(true);
                    u[i].addActionManager();
                    thisFrame.dispose();
                    break;
                }
                }
                
            }
        };
        jbUger.addActionListener(managerInformationButton);
    }
}
