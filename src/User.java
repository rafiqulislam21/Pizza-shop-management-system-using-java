
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

public class User extends JFrame {

    private String name;
    private String address;
    private String status;
    public String id;
    private String password;

    public User(String name, String adderss, String id, String password, String status) {
        super("Pizza Management System");
        this.setSize(800, 600);
        this.setLocation(300, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.name = name;
        this.address = adderss;

        this.id = id;
        this.password = password;
        this.status = status;

    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

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

        JLabel jlList = new JLabel("User Information : ");
        jlList.setBounds(40, 20, 200, 20);
        this.add(jlList);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(40, 50, 300, 400);
        textArea.setBorder(new MetalBorders.TextFieldBorder());
        textArea.setBackground(Color.lightGray);
        textArea.setText("Name : " + name + "\nId : " + id + "\nPassword : " + password + "\nStatus : " + status + "\nEmail : " + address);
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
                thisFrame.dispose();
                ProjectFrame3 pf3 = new ProjectFrame3(id);
                pf3.addComponent();
                pf3.setResizable(false);
                pf3.setVisible(true);
                pf3.addActionFrame1();

            }
        };
        jbBack.addActionListener(backButton);
    }
}
