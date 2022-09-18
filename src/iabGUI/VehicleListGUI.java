package iabGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VehicleListGUI extends JFrame {

	private JPanel contentPane;
	private JTextField dealerIdText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleListGUI frame = new VehicleListGUI();
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
	public VehicleListGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vehicle List");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(161, 10, 122, 13);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(25, 70, 745, 359);
		Dealer dealer = new Dealer();
		textArea.setText(dealer.getVehicleList());
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(407, 143, 2, 2);
		contentPane.add(scrollPane);
		
		dealerIdText = new JTextField();
		dealerIdText.setBounds(124, 41, 145, 19);
		contentPane.add(dealerIdText);
		dealerIdText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Dealer ID");
		lblNewLabel_1.setBounds(38, 44, 123, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Display Dealer Vehicle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Dealer dealer = new Dealer(Integer.parseInt(dealerIdText.getText()))	;
			textArea.setText(dealer.getVehicleList());
			}
		});
		btnNewButton.setBounds(279, 39, 160, 21);
		contentPane.add(btnNewButton);
		
		JButton backBtn = new JButton("Go Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrameGUI newMain = new MainFrameGUI();
				newMain.setVisible(true);
				dispose();
			}
		});
		backBtn.setBounds(667, 439, 85, 21);
		contentPane.add(backBtn);
		
		JButton clearSearch_btn = new JButton("Clear Search");
		clearSearch_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dealer dealer = new Dealer()	;
				textArea.setText(dealer.getVehicleList());
			}
		});
		clearSearch_btn.setBounds(459, 40, 122, 21);
		contentPane.add(clearSearch_btn);
	}
}
