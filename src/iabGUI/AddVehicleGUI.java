package iabGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddVehicleGUI extends JFrame {

	private JPanel contentPane;
	private JTextField vehicleId;
	private JTextField dealerID;
	private JTextField vehicleType;
	private JTextField vehicleModel;
	private JTextField price;
	private JTextField acquisition_date;
	private JTextField manufacturerValue;
	private Vehicle newVehicle ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicleGUI frame = new AddVehicleGUI();
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
	public AddVehicleGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Add Vehicle");
		title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(253, 10, 149, 68);
		contentPane.add(title);
		
		JLabel dealerId_Label = new JLabel("DealerID");
		dealerId_Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dealerId_Label.setBounds(85, 102, 75, 13);
		contentPane.add(dealerId_Label);
		
		JLabel vehicleId_Label = new JLabel("VehicleID");
		vehicleId_Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		vehicleId_Label.setBounds(85, 139, 75, 13);
		contentPane.add(vehicleId_Label);
		
		vehicleId = new JTextField();
		vehicleId.setBounds(232, 137, 96, 19);
		contentPane.add(vehicleId);
		vehicleId.setColumns(10);
		
		dealerID = new JTextField();
		dealerID.setBounds(232, 100, 96, 19);
		contentPane.add(dealerID);
		dealerID.setColumns(10);
		
		JLabel VehicleTypeLabel = new JLabel("Vehicle Type");
		VehicleTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		VehicleTypeLabel.setBounds(85, 171, 91, 13);
		contentPane.add(VehicleTypeLabel);
		
		vehicleType = new JTextField();
		vehicleType.setColumns(10);
		vehicleType.setBounds(232, 169, 96, 19);
		contentPane.add(vehicleType);
		
		vehicleModel = new JTextField();
		vehicleModel.setColumns(10);
		vehicleModel.setBounds(490, 100, 96, 19);
		contentPane.add(vehicleModel);
		
		JLabel vehiclemodel_Label = new JLabel("Vehicle Model");
		vehiclemodel_Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		vehiclemodel_Label.setBounds(392, 103, 88, 13);
		contentPane.add(vehiclemodel_Label);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(490, 140, 96, 19);
		contentPane.add(price);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceLabel.setBounds(392, 140, 75, 13);
		contentPane.add(priceLabel);
		
		acquisition_date = new JTextField();
		acquisition_date.setColumns(10);
		acquisition_date.setBounds(490, 172, 96, 19);
		contentPane.add(acquisition_date);
		
		JLabel acquisitiondate_label = new JLabel("Acquisition Date");
		acquisitiondate_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		acquisitiondate_label.setBounds(392, 172, 88, 13);
		contentPane.add(acquisitiondate_label);
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(490, 116, 45, 13);
		contentPane.add(errorLabel);
		
		JLabel vehicleManufacturerLabel = new JLabel("Vehicle Manufacture");
		vehicleManufacturerLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		vehicleManufacturerLabel.setBounds(83, 205, 139, 13);
		contentPane.add(vehicleManufacturerLabel);
		
		manufacturerValue = new JTextField();
		manufacturerValue.setBounds(232, 202, 96, 19);
		contentPane.add(manufacturerValue);
		manufacturerValue.setColumns(10);
		
		JLabel emptyLabel = new JLabel("");
		emptyLabel.setForeground(new Color(255, 0, 0));
		emptyLabel.setBounds(131, 257, 45, 13);
		contentPane.add(emptyLabel);
		
		JButton addBtn = new JButton("Add Vehicle");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!vehicleId.getText().trim().isEmpty() && !dealerID.getText().trim().isEmpty()
						&&  !vehicleType.getText().trim().isEmpty() &&
						!price.getText().trim().isEmpty() && !acquisition_date.getText().isEmpty() &&
						!manufacturerValue.getText().isEmpty() ) {
					
				int id = Integer.parseInt(vehicleId.getText());
				int dealer=  Integer.parseInt(dealerID.getText());
				String type =  vehicleType.getText();
				String model = vehicleModel.getText();
				double value = Double.parseDouble(price.getText());
				String date = acquisition_date.getText();
				String manufacturer = manufacturerValue.getText();
				
				emptyLabel.setText("");
				newVehicle = new Vehicle(id,dealer,type, model,manufacturer, value,date);
				String checkType = type.toLowerCase().trim();
				if(checkType.compareToIgnoreCase("suv") == 0 ||
						checkType.compareToIgnoreCase("sedan") == 0 ||
								checkType.compareToIgnoreCase("pickup") == 0 ||
										checkType.compareToIgnoreCase("sports car")==0) {
					Dealer newAdd = new Dealer();
					newAdd.addIncomingVehicle(newVehicle);
					errorLabel.setText(null);
					vehicleId.setText(null);
					dealerID.setText(null);
					vehicleType.setText(null);
					vehicleModel.setText(null);
					price.setText(null);
					acquisition_date.setText(null);
					manufacturerValue.setText(null);
				}else {
					errorLabel.setText("Enter valid type (suv, sedan,pickup, or sports car.)");
				}
					
				}else {
					emptyLabel.setText("Empty Field Detected");
				}
				
			}
		});
		addBtn.setBounds(447, 215, 139, 21);
		contentPane.add(addBtn);
		
		JButton goBackBtn = new JButton("Go Back");
		goBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrameGUI newMain = new MainFrameGUI();
				newMain.setVisible(true);
				dispose();
			}
		});
		goBackBtn.setBounds(131, 329, 85, 21);
		contentPane.add(goBackBtn);
	
	
	}
}
