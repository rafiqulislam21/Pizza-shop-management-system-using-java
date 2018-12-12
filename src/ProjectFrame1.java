
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
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalBorders;

public class ProjectFrame1 extends JFrame {

    JFrame thisFrame = this;
    public String idFromText;
    //public String type;
    public boolean userTypeFromComboBox;

    public ProjectFrame1(String idFromText) {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.idFromText = idFromText;

    }

    public ProjectFrame1() {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    //-------------------------------------------------------------------------------------------------
    JButton jbManager;
    JButton jbOrder;
    JButton jbExit;
    JButton jbLogout;

    public void addComponent() {
        this.setLayout(null);

        ImageIcon image = new ImageIcon("src/pizza.png");
        JLabel label = new JLabel(image);
        label.setBounds(420, 200, 400, 300);
        add(label);

        jbManager = new JButton("Manager Information");
        jbManager.setBounds(545, 100, 170, 40);
        this.add(jbManager);

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
                + "17) Ren N hot                          |       Small           |    520\n"
                + "18) Ren N hot                          |       Medium       |    720\n"
                + "19) Ren N hot                          |       Large           |    920\n"
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
                ProjectFrame2 pf2 = new ProjectFrame2(idFromText);
                pf2.setResizable(false);
                pf2.addComponent();
                pf2.addActionFrame2();
                pf2.setVisible(true);
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

        //manager information button
        Manager m[] = new Manager[3];
        ActionListener managerInformationButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

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

                //Display currently login manager info 
                if (idFromText.equals(m[0].getId())) {
                    m[0].addComponent();
                    m[0].setResizable(false);
                    m[0].setVisible(true);
                    m[0].addActionManager();
                    thisFrame.dispose();
                } else if (idFromText.equals(m[1].getId())) {
                    m[1].addComponent();
                    m[1].setResizable(false);
                    m[1].setVisible(true);
                    m[1].addActionManager();
                    thisFrame.dispose();
                } else if (idFromText.equals(m[2].getId())) {
                    m[2].addComponent();
                    m[2].setResizable(false);
                    m[2].setVisible(true);
                    m[2].addActionManager();
                    thisFrame.dispose();
                }

            }
        };
        jbManager.addActionListener(managerInformationButton);
    }
}
