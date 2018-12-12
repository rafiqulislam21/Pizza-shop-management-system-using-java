
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.plaf.metal.MetalBorders;

public class Manager extends JFrame {

    private String name;
    private String address;
    private String status;
    public String id;
    private String password;

    public Manager(String name, String adderss, String status, String id, String password) {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.name = name;
        this.address = adderss;
        this.status = status;
        this.id = id;
        this.password = password;

    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    /*public void managerInfo(){
        System.out.println("Manager Information : ");
        System.out.println("Name : "+name);
        System.out.println("Id : "+id);
        System.out.println("Status : "+status);
        System.out.println("Address : "+address);
        
    }*/

    JFrame thisFrame = this;

    JButton jbBack;
    JButton jbLogout;

    public void addComponent() {
        this.setLayout(null);

        ImageIcon image = new ImageIcon("src/pizza.png");
        JLabel label = new JLabel(image);
        label.setBounds(420, 200, 400, 300);
        add(label);

        jbBack = new JButton("Back");
        jbBack.setBounds(605, 500, 70, 40);
        this.add(jbBack);

        jbLogout = new JButton("Logout");
        //button3.setBackground(Color.RED);
        jbLogout.setBounds(500, 500, 80, 40);
        this.add(jbLogout);

        JLabel jlList = new JLabel("Manager Information : ");
        jlList.setBounds(40, 20, 200, 20);
        this.add(jlList);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(40, 50, 300, 400);
        textArea.setBorder(new MetalBorders.TextFieldBorder());
        textArea.setBackground(Color.lightGray);
        textArea.setText("Name : " + name + "\nId : " + id + "\nPassword : " + password + "\nStatus : " + status + "\nAddress : " + address);
        this.add(textArea);

    }

    //Action
    void addActionManager() {

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
                ProjectFrame1 pf1 = new ProjectFrame1(id);
                pf1.setResizable(false);
                pf1.addComponent();
                pf1.addActionFrame1();
                pf1.setVisible(true);
                thisFrame.dispose();
            }
        };
        jbBack.addActionListener(backButton);
    }
}
