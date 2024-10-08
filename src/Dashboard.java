import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }

    public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");

        setForeground(Color.CYAN);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("dash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1950, 1000);
        add(NewLabel);


        JLabel AirlineManagementSystem = new JLabel("WELCOME");
        AirlineManagementSystem.setForeground(Color.WHITE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 46));
        AirlineManagementSystem.setBounds(600, 60, 1000, 85);
        NewLabel.add(AirlineManagementSystem);


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        JMenu hotelManagementMenu = new JMenu("HOTEL MANAGEMENT");
        hotelManagementMenu.setForeground(Color.BLUE);
        menuBar.add(hotelManagementMenu);

        JMenuItem receptionMenuItem = new JMenuItem("RECEPTION");
        hotelManagementMenu.add(receptionMenuItem);


        JMenu adminMenu = new JMenu("ADMIN");
        adminMenu.setForeground(Color.RED);
        menuBar.add(adminMenu);

        JMenuItem addEmployeeMenuItem = new JMenuItem("ADD EMPLOYEE");
        adminMenu.add(addEmployeeMenuItem);
        addEmployeeMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddEmployee().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem addRoomMenuItem = new JMenuItem("ADD ROOMS");
        adminMenu.add(addRoomMenuItem);
        addRoomMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddRoom().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        receptionMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Reception().setVisible(true);
            }
        });

        JMenuItem addDriversMenuItem = new JMenuItem("ADD DRIVERS");
        adminMenu.add(addDriversMenuItem);
        addDriversMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddDrivers().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        setSize(1950, 1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
}