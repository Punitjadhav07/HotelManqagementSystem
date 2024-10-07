import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {

    Dashboard() {

        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        setTitle("Dashboard");

        // Load and scale the background image
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("dash.jpg"));
        Image i2 = i.getImage().getScaledInstance(1550, 1000, Image.SCALE_SMOOTH);  // Better scaling
        ImageIcon i3 = new ImageIcon(i2);

        // Add background image
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        // Add welcome text on top of the image
        JLabel AirlineManagementSystem = new JLabel("Welcome");
        AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        AirlineManagementSystem.setBounds(600, 60, 1000, 85);
        image.add(AirlineManagementSystem);  // Added to the background image

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Hotel Management menu
        JMenu AirlineSystem = new JMenu("HOTEL MANAGEMENT");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("RECEPTION");
        AirlineSystem.add(FlightDetails);

        // Admin menu
        JMenu AirlineSystemHello = new JMenu("ADMIN");
        AirlineSystemHello.setForeground(Color.RED);
        menuBar.add(AirlineSystemHello);

        JMenuItem FlightDetailshello1 = new JMenuItem("ADD EMPLOYEE");
        AirlineSystemHello.add(FlightDetailshello1);



        // Frame properties
        setSize(1550, 1000);  // Set window size
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}