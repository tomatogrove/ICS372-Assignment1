import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrameGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameGUI frame = new MainFrameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrameGUI() {
		setTitle("Main");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle Car Software");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(105, 38, 218, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Vehicle List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehicleListGUI vehicle = new VehicleListGUI();
				vehicle.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(256, 126, 118, 21);
		contentPane.add(btnNewButton_1);
		
		JButton addVehicle = new JButton("Add Vehicle");
		addVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVehicleGUI addVehicleFrame = new AddVehicleGUI();
				addVehicleFrame.setVisible(true);
				dispose();
			}
		});
		addVehicle.setBounds(77, 126, 128, 21);
		contentPane.add(addVehicle);
	}
}
