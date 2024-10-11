import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchRoom extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTable table;
    Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SearchRoom frame = new SearchRoom();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SearchRoom() throws SQLException {
        // Initialize the database connection here
        // conn = Javaconnect.getDBConnection();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridBagLayout());
        panelTop.setBackground(Color.WHITE);
        contentPane.add(panelTop, BorderLayout.NORTH);

        JLabel lblSearchForRoom = new JLabel("Search For Room");
        lblSearchForRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GridBagConstraints gbc_lblSearchForRoom = new GridBagConstraints();
        gbc_lblSearchForRoom.gridwidth = 2;
        gbc_lblSearchForRoom.insets = new Insets(0, 0, 5, 5);
        gbc_lblSearchForRoom.gridx = 1;
        gbc_lblSearchForRoom.gridy = 0;
        panelTop.add(lblSearchForRoom, gbc_lblSearchForRoom);

        JLabel lblRoomAvailable = new JLabel("Room Bed Type:");
        GridBagConstraints gbc_lblRoomAvailable = new GridBagConstraints();
        gbc_lblRoomAvailable.anchor = GridBagConstraints.EAST;
        gbc_lblRoomAvailable.insets = new Insets(0, 0, 5, 5);
        gbc_lblRoomAvailable.gridx = 0;
        gbc_lblRoomAvailable.gridy = 1;
        panelTop.add(lblRoomAvailable, gbc_lblRoomAvailable);

        c1 = new Choice();
        c1.add("Single Bed");
        c1.add("Double Bed");
        GridBagConstraints gbc_c1 = new GridBagConstraints();
        gbc_c1.fill = GridBagConstraints.HORIZONTAL;
        gbc_c1.insets = new Insets(0, 0, 5, 5);
        gbc_c1.gridx = 1;
        gbc_c1.gridy = 1;
        panelTop.add(c1, gbc_c1);

        JCheckBox checkRoom = new JCheckBox("Only display Available");
        checkRoom.setBackground(Color.WHITE);
        GridBagConstraints gbc_checkRoom = new GridBagConstraints();
        gbc_checkRoom.insets = new Insets(0, 0, 5, 0);
        gbc_checkRoom.gridx = 2;
        gbc_checkRoom.gridy = 1;
        panelTop.add(checkRoom, gbc_checkRoom);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        contentPane.add(panelCenter, BorderLayout.CENTER);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panelCenter.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        contentPane.add(panelBottom, BorderLayout.SOUTH);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String SQL = "select * from Room where bed_type = '" + c1.getSelectedItem() + "'";
                String SQL2 = "select * from Room where availability = 'Available' AND bed_type = '" + c1.getSelectedItem() + "'";
                try {
                    conn c = new conn(); // Assuming conn is a class that handles DB connection
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                    if (checkRoom.isSelected()) {
                        rs = c.s.executeQuery(SQL2);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                } catch (SQLException ss) {
                    ss.printStackTrace();
                }
            }
        });
        panelBottom.add(btnSearch);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        panelBottom.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
}
