
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
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders;


public class ProjectFrame4 extends JFrame{
        JFrame thisFrame = this;
        String id;

    private String pizzaName[] = {"Select", "BBQ Temtation", "Tropical Chicken", "Spicy Beef", "BBQ Blast", "Chicken Hawalian", "Ren N hot", "Meat Lovens", "Chicken Royal", "Neapolitan"};
    private String pizzaSize[] = {"Select", "Small", "Medium", "Large"};
    
    
    public ProjectFrame4() {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    public ProjectFrame4(String id) {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.id = id;

    }

    

    JButton jbPrintBill;
    JButton jbBack;
    JButton jbLogout;
    JComboBox jcPizzaName;
    JComboBox jcPizzaSize;
    JTextField jtPizzaAmount;
    JTextArea jtMoneyRecept;

    public void addComponent() {
        this.setLayout(null);
        
        //System.out.println(userTypeFromComboBox);
        
        
        ImageIcon image = new ImageIcon("src/pizza.png");
        JLabel label = new JLabel(image);
        label.setBounds(400, 200, 400, 300);
        add(label);

        jbPrintBill = new JButton("Print Bill");
        jbPrintBill.setBounds(680, 500, 90, 40);
        this.add(jbPrintBill);

        jbBack = new JButton("Back");
        jbBack.setBounds(590, 500, 70, 40);
        this.add(jbBack);

        jbLogout = new JButton("Logout");
        jbLogout.setBounds(480, 500, 90, 40);
        this.add(jbLogout);

        JLabel jlMoneyRecept = new JLabel("Money Recept : ");
        jlMoneyRecept.setBounds(40, 20, 100, 20);
        this.add(jlMoneyRecept);

        jtMoneyRecept = new JTextArea();
        jtMoneyRecept.setBounds(40, 50, 400, 440);
        jtMoneyRecept.setBorder(new MetalBorders.TextFieldBorder());
        this.add(jtMoneyRecept);

        JLabel jlPizzaName = new JLabel("Pizza Name : ");
        jlPizzaName.setBounds(480, 20, 100, 20);
        this.add(jlPizzaName);

        jcPizzaName = new JComboBox(pizzaName);
        jcPizzaName.setBounds(480, 50, 250, 40);
        this.add(jcPizzaName);

        JLabel jlPizzaSize = new JLabel("Pizza Size : ");
        jlPizzaSize.setBounds(480, 100, 100, 20);
        this.add(jlPizzaSize);

        jcPizzaSize = new JComboBox(pizzaSize);
        jcPizzaSize.setBounds(480, 130, 250, 40);
        this.add(jcPizzaSize);

        JLabel jlPizzaAmount = new JLabel("Pizza Amount : ");
        jlPizzaAmount.setBounds(480, 180, 100, 20);
        this.add(jlPizzaAmount);

        jtPizzaAmount = new JTextField();
        jtPizzaAmount.setBounds(480, 210, 250, 40);
        this.add(jtPizzaAmount);

    }

    public void addActionFrame2() {

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

        ActionListener backButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ProjectFrame3 pf3 = new ProjectFrame3(id);
                      
                    pf3.setResizable(false);
                    pf3.addComponent();
                    pf3.addActionFrame1();
                    pf3.setVisible(true);
                    thisFrame.dispose();
                }
              
        };
        jbBack.addActionListener(backButton);

        //set default pizza amount
        jtPizzaAmount.setText("0");

        ActionListener printBillButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int pizzaName, pizzaSize, totalAmount;
                //String totalAmount;

                pizzaName = jcPizzaName.getSelectedIndex();
                pizzaSize = jcPizzaSize.getSelectedIndex();
                //totalAmount = jtPizzaAmount.getText();
                totalAmount = Integer.parseInt(jtPizzaAmount.getText());

                //cheak pizza when pizza name,size not given
                if (pizzaSize == 0 || pizzaName == 0 || totalAmount == 0) {
                    jtMoneyRecept.setText("No Pizza name, Pizza size or Pizza amount selected yet ......."
                            + "\n\nPlease Select Pizza name, Pizza size and Pizza amount.");
                } else {

                    PizzaInfo[] p = new PizzaInfo[27];

                    String stringArrayFromFileLine[] = null;
                    FileReader frPizza = null;
                    BufferedReader brPizza = null;

                    try {
                        frPizza = new FileReader("src/pizzaInfo.txt");
                        brPizza = new BufferedReader(frPizza);

                        int count = 0;
                        String s = brPizza.readLine();

                        while (s != null) {

                            stringArrayFromFileLine = s.split("\\|");
                            //             pizzaInfo(name,                       size,                       prize)
                            p[count] = new PizzaInfo(stringArrayFromFileLine[0], stringArrayFromFileLine[1], Integer.parseInt(stringArrayFromFileLine[2]));

                            s = brPizza.readLine();
                            count++;
                        }
                        brPizza.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (frPizza != null) {
                                frPizza.close();
                            }
                            if (brPizza != null) {
                                brPizza.close();
                            }

                        } catch (Exception e) {
                        }
                    }

                    int NumOFOrder = 0;
                    Order[] order = new Order[27];

                    Orderinfo[] p1 = new Orderinfo[1000];
                    int count1 = 0;
                    String stringArrayFromFileLine1[] = null;
                    FileReader fr1Manager = null;
                    BufferedReader br1Manager = null;

                    try {
                        fr1Manager = new FileReader("src/OrderDetails.txt");
                        br1Manager = new BufferedReader(fr1Manager);

                        String s1 = br1Manager.readLine();

                        while (s1 != null) {
                            //System.out.println(s);
                            stringArrayFromFileLine1 = s1.split("\\|");
                            p1[count1] = new Orderinfo(stringArrayFromFileLine1[0]);

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

//cheak size and name to ensure prize
                    if (pizzaSize == 1 && pizzaName == 1) {
                        order[0] = new Order(p[0].getPname(), p[0].getSize(), p[0].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[0].finalBill());

                        order[0].file();

                    }

                    if (pizzaSize == 2 && pizzaName == 1) {
                        order[1] = new Order(p[1].getPname(), p[1].getSize(), p[1].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[1].finalBill());

                        order[1].file();
                    }

                    if (pizzaSize == 3 && pizzaName == 1) {
                        order[2] = new Order(p[2].getPname(), p[2].getSize(), p[2].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[2].finalBill());

                        order[2].file();
                    }
                    if (pizzaSize == 1 && pizzaName == 2) {
                        order[3] = new Order(p[3].getPname(), p[3].getSize(), p[3].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[3].finalBill());

                        order[3].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 2) {
                        order[4] = new Order(p[4].getPname(), p[4].getSize(), p[4].getPrize(), totalAmount, p1[z - 1].getP1name());
                        jtMoneyRecept.setText(order[4].finalBill());

                        order[4].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 2) {
                        order[5] = new Order(p[5].getPname(), p[5].getSize(), p[5].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[5].finalBill());

                        order[5].file();
                    }

                    if (pizzaSize == 1 && pizzaName == 3) {
                        order[6] = new Order(p[6].getPname(), p[6].getSize(), p[6].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[6].finalBill());

                        order[6].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 3) {
                        order[7] = new Order(p[7].getPname(), p[7].getSize(), p[7].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[7].finalBill());

                        order[7].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 3) {
                        order[8] = new Order(p[8].getPname(), p[8].getSize(), p[8].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[8].finalBill());

                        order[8].file();
                    }

                    if (pizzaSize == 1 && pizzaName == 4) {
                        order[9] = new Order(p[9].getPname(), p[9].getSize(), p[9].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[9].finalBill());

                        order[9].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 4) {
                        order[10] = new Order(p[10].getPname(), p[10].getSize(), p[10].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[10].finalBill());

                        order[10].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 4) {
                        order[11] = new Order(p[11].getPname(), p[11].getSize(), p[11].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[11].finalBill());

                        order[11].file();
                    }
                    if (pizzaSize == 1 && pizzaName == 5) {
                        order[12] = new Order(p[12].getPname(), p[12].getSize(), p[12].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[12].finalBill());

                        order[12].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 5) {
                        order[13] = new Order(p[13].getPname(), p[13].getSize(), p[13].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[13].finalBill());

                        order[13].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 5) {
                        order[14] = new Order(p[14].getPname(), p[14].getSize(), p[14].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[14].finalBill());

                        order[14].file();
                    }

                    if (pizzaSize == 1 && pizzaName == 6) {
                        order[15] = new Order(p[15].getPname(), p[15].getSize(), p[15].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[15].finalBill());

                        order[15].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 6) {
                        order[16] = new Order(p[16].getPname(), p[16].getSize(), p[16].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[16].finalBill());

                        order[16].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 6) {
                        order[17] = new Order(p[17].getPname(), p[17].getSize(), p[17].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[17].finalBill());

                        order[17].file();
                    }
                    if (pizzaSize == 1 && pizzaName == 7) {
                        order[18] = new Order(p[18].getPname(), p[18].getSize(), p[18].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[18].finalBill());

                        order[18].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 7) {
                        order[19] = new Order(p[19].getPname(), p[19].getSize(), p[19].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[19].finalBill());

                        order[19].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 7) {
                        order[20] = new Order(p[20].getPname(), p[20].getSize(), p[20].getPrize(), totalAmount, p1[z - 1].getP1name());
                        jtMoneyRecept.setText(order[20].finalBill());

                        order[20].file();
                    }
                    if (pizzaSize == 1 && pizzaName == 8) {
                        order[21] = new Order(p[21].getPname(), p[21].getSize(), p[21].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[21].finalBill());

                        order[21].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 8) {
                        order[22] = new Order(p[22].getPname(), p[22].getSize(), p[22].getPrize(), totalAmount, p1[z - 1].getP1name());
                        jtMoneyRecept.setText(order[22].finalBill());

                        order[22].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 8) {
                        order[23] = new Order(p[23].getPname(), p[23].getSize(), p[23].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[23].finalBill());

                        order[23].file();
                    }
                    if (pizzaSize == 1 && pizzaName == 9) {
                        order[24] = new Order(p[24].getPname(), p[24].getSize(), p[24].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[24].finalBill());

                        order[24].file();
                    }

                    if (pizzaSize == 2 && pizzaName == 9) {
                        order[25] = new Order(p[25].getPname(), p[25].getSize(), p[25].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[25].finalBill());

                        order[25].file();
                    }
                    if (pizzaSize == 3 && pizzaName == 9) {
                        order[26] = new Order(p[26].getPname(), p[26].getSize(), p[26].getPrize(), totalAmount, p1[z - 1].getP1name());

                        jtMoneyRecept.setText(order[26].finalBill());

                        order[26].file();
                    }

                }

            }
        };
        jbPrintBill.addActionListener(printBillButton);

    }

}
