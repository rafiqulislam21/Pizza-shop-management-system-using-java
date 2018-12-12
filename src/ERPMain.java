
public class ERPMain {

    public static void main(String[] args) {

        Login login = new Login();
        login.setResizable(false);
        login.addComponent();
        login.addAction();

        login.setVisible(true);

    }
}
