import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelManagementSystem implements ActionListener {

    private JFrame frame;

    HotelManagementSystem() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1336, 565);
        frame.setLayout(null);


        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("nostravilla.jpg"));
        Image img = il.getImage();
        Image scaledImg = img.getScaledInstance(1336, 565, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);


        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 1336, 565);
        frame.add(image);


        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20, 430, 1200, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 70));
        image.add(text);


        JButton next = new JButton("NEXT");
        next.setBounds(1150, 450, 150, 50);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        image.add(next);

        // Frame properties
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new Login();
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}