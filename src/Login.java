import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField username, password;
    JButton login, cancel;

    // Constructor
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Username and Password text fields
        username = new JTextField();
        password = new JTextField();

        JLabel user = new JLabel("Username");
        user.setBounds(42, 20, 100, 30);
        add(user);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);

        username.setBounds(150, 20, 150, 30);
        add(username);

        password.setBounds(150, 70, 150, 30);
        add(password);

        // Login Button
        login = new JButton("Login");
        login.setBounds(40, 150, 140, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 140, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        // Adding an image
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("loginpic.jpg"));
        Image i2 = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);
        add(image);

        setBounds(500, 200, 600, 300);
        setVisible(true);
        setResizable(false);
    }

    // Main method
    public static void main(String[] args) {
        new Login();
    }

    // Action performed for login and cancel buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            // Get the text entered by the user
            String user = username.getText();
            String pass = password.getText();

            try {
                conn c = new conn();  // Create an instance of the connection class

                // Use parameterized query to avoid SQL injection (more secure)
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";

                // Prepare the statement and set the values
                PreparedStatement ps = c.c.prepareStatement(query);
                ps.setString(1, user);
                ps.setString(2, pass);

                // Execute the query
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful");
                    // Add logic to open the next window or functionality
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();  // Display the error for debugging
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);  // Close the login window if "Cancel" is pressed
        }
    }
}