

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class InformationSystem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField citizenshipNumberText;
	private JTextField nameText;
	private JTextField telephoneNumberText;
	private JTextField mailText;
	private JTextField dateText;
	private JTextField serviceProviderNameText;
	private JTextField subscriptionPlanNameText;
	private JComboBox<String> subscriptionPlanComboBox;
	private JComboBox<String> possibleCustomerComboBox;
	private JComboBox<String> existingCustomerComboBox;
	private JComboBox<String> serviceProviderTypesComboBox;
	private JComboBox<String> gsmProvidersComboBox;
	private JComboBox<String> cableProvidersComboBox;
	private JTextArea subscriptionPlansText;
	private String subText = "";
	
	private ArrayList<GSMProvider> gsmProviders = new ArrayList<>();
	private ArrayList<CableProvider> cableProviders = new ArrayList<>();
	private ArrayList<PossibleCustomer> possibleCustomers = new ArrayList<>();
	private ArrayList<ExistingCustomer> existingCustomers = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationSystem frame = new InformationSystem();
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
	public InformationSystem() {
		createGUI();
	}
	
	public void createGUI() {
		setResizable(false);
		setTitle("GCO Provider");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		//CREATE A TABBED PANE CONSISTING OF CUSTOMER AND SERVICE PROVIDER PANEL
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("FreeSerif", Font.BOLD, 20));
		contentPane.add(tabbedPane);
		
		//////////////////////////////////////////////////////////////////CUSTOMER PANEL////////////////////////////////////////////////////
		
		//CREATE THE CUSTOMER PANEL
		JPanel customerPanel = new JPanel();
		customerPanel.setBackground(SystemColor.activeCaptionBorder);
		tabbedPane.addTab("Customer", null, customerPanel, null);
		customerPanel.setLayout(null);
		
		//ADD NAME LABEL AND TEXT FIELD TO GET INFO
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(560, 120, 91, 31);
		customerPanel.add(nameLabel);
		nameLabel.setFont(new Font("Liberation Mono", Font.BOLD, 20));
		
		
		nameText = new JTextField();
		nameText.setFont(new Font("Dialog", Font.PLAIN, 20));
		nameText.setBounds(651, 114, 262, 40);
		customerPanel.add(nameText);
		nameText.setColumns(10);
		
		//ADD CITIZENSHIP NR LABEL AND TEXT FIELD TO GET INFO
		JLabel citizenshipNumberLabel = new JLabel("Citizenship Number: ");
		citizenshipNumberLabel.setBounds(12, 120, 252, 40);
		customerPanel.add(citizenshipNumberLabel);
		citizenshipNumberLabel.setFont(new Font("Liberation Mono", Font.BOLD, 20));
		
		
		citizenshipNumberText = new JTextField();
		citizenshipNumberText.setFont(new Font("Dialog", Font.PLAIN, 20));
		citizenshipNumberText.setBounds(260, 120, 245, 40);
		customerPanel.add(citizenshipNumberText);
		citizenshipNumberText.setColumns(10);
		
		//ADD TELEPHONE NUMBER LABEL AND TEXT FIELD TO GET INFO
		JLabel telephoneNumberLabel = new JLabel("Telephone Number: ");
		telephoneNumberLabel.setBounds(12, 220, 245, 40);
		customerPanel.add(telephoneNumberLabel);
		telephoneNumberLabel.setFont(new Font("Liberation Mono", Font.BOLD, 20));
		
		telephoneNumberText = new JTextField();
		telephoneNumberText.setBounds(260, 220, 245, 40);
		customerPanel.add(telephoneNumberText);
		telephoneNumberText.setFont(new Font("Dialog", Font.PLAIN, 20));
		telephoneNumberText.setColumns(10);
		
		//ADD MAIL LABEL AND TEXT FIELD TO GET INFO
		JLabel mailLabel = new JLabel("Mail: ");
		mailLabel.setBounds(560, 225, 91, 30);
		customerPanel.add(mailLabel);
		mailLabel.setFont(new Font("Liberation Mono", Font.BOLD, 20));
		
		mailText = new JTextField();
		mailText.setFont(new Font("Dialog", Font.PLAIN, 20));
		mailText.setBounds(651, 219, 262, 40);
		customerPanel.add(mailText);
		mailText.setColumns(10);
		
		//ADD DATE LABEL AND TEXT FIELD TO GET INFO
		JLabel dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(560, 320, 91, 31);
		customerPanel.add(dateLabel);
		dateLabel.setFont(new Font("Liberation Mono", Font.BOLD, 20));
		
		dateText = new JTextField();
		dateText.setFont(new Font("Dialog", Font.PLAIN, 20));
		dateText.setBounds(651, 314, 262, 40);
		customerPanel.add(dateText);
		dateText.setColumns(10);
		
		
		
		// CREATE AND ADD PLANS TO SUBSCRIPTION PLAN COMBOBOX TO CHOOSE FROM IT
		// AND ADD SUBSCRIPTION PLAN LABEL
		subscriptionPlanComboBox = new JComboBox<>();
		subscriptionPlanComboBox.setFont(new Font("Dialog", Font.BOLD, 18));
		subscriptionPlanComboBox.addItem("Select Plan");
		
		for(GSMProvider gsm:gsmProviders) {
			LinkedList<SubscriptionPlan> subPlans = gsm.getSubscriptionPlans();
			for(SubscriptionPlan sub:subPlans){
				subscriptionPlanComboBox.addItem(gsm.getName() +" : "+sub.getName());
			}
		}
		
		for(CableProvider cable:cableProviders) {
			LinkedList<SubscriptionPlan> subPlans = cable.getSubscriptionPlans();
			for(SubscriptionPlan sub:subPlans){
				subscriptionPlanComboBox.addItem(cable.getName() +" : "+ sub.getName());
			}
		}
		
		
		JLabel subscriptionPlanLabel = new JLabel("Subscription Plan: ");
		subscriptionPlanLabel.setBounds(12, 320, 228, 45);
		customerPanel.add(subscriptionPlanLabel);
		subscriptionPlanLabel.setFont(new Font("Liberation Mono", Font.BOLD, 20));
		
		
		subscriptionPlanComboBox.setBounds(259, 320, 246, 40);
		customerPanel.add(subscriptionPlanComboBox);
		
		
		//CREATE POSSIBLE CUSTOMER COMBOBOX CONSISTING OF POSSIBLE CUSTOMERS
		possibleCustomerComboBox = new JComboBox<>();
		updatePossibleCustomerComboBox();
		
		
		//IF ONE OF THE CUSTOMER IS CHOSEN UPLOAD HIS/HER INFORMATION
		possibleCustomerComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(possibleCustomerComboBox.getSelectedItem() != null ) {
					if(!possibleCustomerComboBox.getSelectedItem().toString().equalsIgnoreCase("Possible Customers")) {
						String customerInfo[] = possibleCustomerComboBox.getSelectedItem().toString().split(" ");
						for(PossibleCustomer pCustomer:possibleCustomers) {
							if(pCustomer.getCitizenshipNr().equalsIgnoreCase(customerInfo[0])){
								nameText.setText(pCustomer.getName());
								mailText.setText(pCustomer.getMail());
								telephoneNumberText.setText(pCustomer.getTel());
								citizenshipNumberText.setText(pCustomer.getCitizenshipNr());
								dateText.setText("");
								subscriptionPlanComboBox.setSelectedItem("Select Plan");
								
								existingCustomerComboBox.setSelectedItem("Existing Customers");
								
								break;
							}
						}
					}
					else {
						if(existingCustomerComboBox.getSelectedItem().toString().equalsIgnoreCase("Existing Customers")) {
							clearCustomerPanel();
						}
					}
				}
			}
		});
		
		
		
		possibleCustomerComboBox.setFont(new Font("Dialog", Font.BOLD, 16));
		possibleCustomerComboBox.setBounds(31, 20, 300, 40);
		customerPanel.add(possibleCustomerComboBox);
		
		
		//CREATE AN EXISTING CUSTOMER COMBO BOX CONSISTING OF EXISTING CUSTOMERS
		existingCustomerComboBox = new JComboBox<>();
		updateExistingCustomerComboBox();
		
		//IF ONE OF THE CUSTOMER IS CHOSEN UPLOAD HIS/HER INFORMATION
		existingCustomerComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(existingCustomerComboBox.getSelectedItem() != null) {
					if(! existingCustomerComboBox.getSelectedItem().toString().equalsIgnoreCase("Existing Customers")) {
						String customerInfo[] = existingCustomerComboBox.getSelectedItem().toString().split(" ");
						
						for(ExistingCustomer eCustomer:existingCustomers) {
							if(eCustomer.getCitizenshipNr().equalsIgnoreCase(customerInfo[0])){
								nameText.setText(eCustomer.getName());
								mailText.setText(eCustomer.getMail());
								telephoneNumberText.setText(eCustomer.getTel());
								citizenshipNumberText.setText(eCustomer.getCitizenshipNr());
								
								subscriptionPlanComboBox.setSelectedItem(eCustomer.getSubscription().getSubscriptionPlan().getServiceProvider().getName() + " " + 
								eCustomer.getSubscription().getSubscriptionPlan().getName());
								
								Date date = eCustomer.getSubscription().getSubscriptionStartDate();
								DateFormat formatter = new SimpleDateFormat("dd.MM.yyy");
								dateText.setText(formatter.format(date));
								
								possibleCustomerComboBox.setSelectedItem("Possible Customers");
								

								break;
							}
						}
					}
					else {
						if(possibleCustomerComboBox.getSelectedItem().toString().equalsIgnoreCase("Possible Customers")) {
							clearCustomerPanel();
						}
					}
				}
			}
		});
		
		
		existingCustomerComboBox.setFont(new Font("Dialog", Font.BOLD, 16));
		existingCustomerComboBox.setBounds(367, 20, 300, 40);
		customerPanel.add(existingCustomerComboBox);
		
		
		//CREATE A BUTTON TO CLEAR THE TEXT FIELDS ON CUSTOMER PANEL
		JButton newCustomerButton = new JButton("New Customer");
		newCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCustomerPanel();		
			}
		});
		newCustomerButton.setFont(new Font("Dialog", Font.BOLD, 18));
		newCustomerButton.setBounds(726, 20, 187, 50);
		customerPanel.add(newCustomerButton);
		
		
		//CREATE A BUTTON TO CONFIRM THE CHANGES AND ADD NEW CUSTOMERS
		JButton confirmCustomerButton = new JButton("Confirm");
		confirmCustomerButton.setBounds(726, 430, 150, 50);
		customerPanel.add(confirmCustomerButton);
		confirmCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(possibleCustomerComboBox.getSelectedItem().toString() == "Possible Customers") {
					if(existingCustomerComboBox.getSelectedItem().toString() == "Existing Customers") {
						//IF NEW CITIZENSHIP ID IS GIVEN CREATE A CUSTOMER 
						createCustomer();
						}
					
					else {
						//IF THE CITIZENSHIP ID BELONGS TO SOMEONE IN EXISTING CUSTOMER UPDATE THE CUSTOMER 
						updateExistingCustomer();
					}
				}
				
				else {
					//IF THE CITIZENSHIP ID BELONGS TO SOMEONE IN POSSIBLE CUSTOMER UPDATE THE CUSTOMER
					//IF A SUBSCRIPTION PLAN IS CHOSEN ADD THE CUSTOMER TO EXISTING CUSTOMERS
					updatePossibleCustomer();				
				}
			}
		});
		confirmCustomerButton.setFont(new Font("Dialog", Font.BOLD, 20));
		
		//TO INFROM THE USER ABOUT DATE FORMAT
		JLabel dateInfoLabel = new JLabel("DD.MM.YYYY");
		dateInfoLabel.setBounds(799, 350, 102, 25);
		customerPanel.add(dateInfoLabel);
		
		//CREATE A BUTTON TO DELET CUSTOMER
		JButton deleteCustomerButton = new JButton("Delete");
		deleteCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!possibleCustomerComboBox.getSelectedItem().toString().equalsIgnoreCase("Possible Customers")) {
					deletePossibleCustomer();
				}
				else if(!existingCustomerComboBox.getSelectedItem().toString().equalsIgnoreCase("Existing Customers")) {
					deleteExistingCustomer();
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Choose a Customer to Delete");
				}
			}
		});
		deleteCustomerButton.setFont(new Font("Dialog", Font.BOLD, 20));
		deleteCustomerButton.setBounds(50, 430, 120, 50);
		customerPanel.add(deleteCustomerButton);
		
		
		
		
		////////////////////////////////////////////////////////////SERVICE PROVIDER SECTION /////////////////////////////////////////////////////////////////////
		
		//CRATE A SERVICE PROVIDER PANEL
		JPanel serviceProviderPanel = new JPanel();
		serviceProviderPanel.setBackground(SystemColor.windowBorder);
		tabbedPane.addTab("Service Provider", null, serviceProviderPanel, null);
		serviceProviderPanel.setLayout(null);
		
		//CREATE A BUTTON TO CLEAR THE TEXT FIELDS IN THE SERVICE PROVIDER PANEL
		JButton newServiceProviderButton = new JButton("New Service Provider");
		newServiceProviderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearServiceProviderPanel();
				
			}
		});
		newServiceProviderButton.setFont(new Font("Lato Heavy", Font.BOLD | Font.ITALIC, 18));
		newServiceProviderButton.setBounds(692, 17, 220, 40);
		serviceProviderPanel.add(newServiceProviderButton);
		
		
		//CREATE A COMBOBOX TO CHOOSE A PROVIDER (GSM OR CABLE PROVIDERS)
		JLabel providerType = new JLabel("Provider Type: ");
		providerType.setFont(new Font("Liberation Mono", Font.BOLD, 22));
		providerType.setBounds(12, 125, 197, 40);
		serviceProviderPanel.add(providerType);
		
		String types[] = {"Select Type","GSM Provider","Cable Provider"};
		serviceProviderTypesComboBox = new JComboBox<>(types);
		serviceProviderTypesComboBox.setFont(new Font("Liberation Mono", Font.BOLD, 20));
		serviceProviderTypesComboBox.setBounds(216, 125, 227, 40);
		serviceProviderPanel.add(serviceProviderTypesComboBox);
		
		//CREATE A PROVIDER NAME LABEL AND TEXT FIELD 
		JLabel serviceProviderName = new JLabel("Provider Name:");
		serviceProviderName.setFont(new Font("Liberation Mono", Font.BOLD, 22));
		serviceProviderName.setBounds(501, 125, 197, 40);
		serviceProviderPanel.add(serviceProviderName);
		
		serviceProviderNameText = new JTextField();
		serviceProviderNameText.setFont(new Font("Dialog", Font.PLAIN, 20));
		serviceProviderNameText.setBounds(708, 125, 204, 40);
		serviceProviderPanel.add(serviceProviderNameText);
		serviceProviderNameText.setColumns(10);
		
		
		//CREATE A TEXT FIELD TO SHOW THE WHOLE SUBSCRIPTION PLANS BELONGING TO THE CHOSEN PROVIDER
		JLabel SubscriptionPlansLabel = new JLabel("Subscription Plans:");
		SubscriptionPlansLabel.setFont(new Font("Lato Heavy", Font.BOLD, 25));
		SubscriptionPlansLabel.setBounds(28, 237, 240, 40);
		serviceProviderPanel.add(SubscriptionPlansLabel);
		
		subscriptionPlansText = new JTextArea();
		subscriptionPlansText.setEditable(false);
		subscriptionPlansText.setBackground(SystemColor.windowBorder);
		subscriptionPlansText.setFont(new Font("Dialog", Font.PLAIN, 18));
		subscriptionPlansText.setBounds(28, 289, 256, 203);
		serviceProviderPanel.add(subscriptionPlansText);

		
		//CAPTION
		JLabel lblAddSubscriptionPlan = new JLabel("Add Subscription Plan:");
		lblAddSubscriptionPlan.setFont(new Font("Lato Heavy", Font.BOLD, 25));
		lblAddSubscriptionPlan.setBounds(545, 237, 280, 40);
		serviceProviderPanel.add(lblAddSubscriptionPlan);
		
		
		// CREATE A SUBSCRIPTION PLAN NAME LABEL AND TEXT FIELD 
		JLabel subscriptionPlanNameLabel = new JLabel("Plan Name: ");
		subscriptionPlanNameLabel.setFont(new Font("Liberation Mono", Font.BOLD, 22));
		subscriptionPlanNameLabel.setBounds(477, 310, 150, 40);
		serviceProviderPanel.add(subscriptionPlanNameLabel);
		
		subscriptionPlanNameText = new JTextField();
		subscriptionPlanNameText.setFont(new Font("Dialog", Font.PLAIN, 20));
		subscriptionPlanNameText.setBounds(646, 310, 266, 40);
		serviceProviderPanel.add(subscriptionPlanNameText);
		subscriptionPlanNameText.setColumns(10);
		
		
		//CREATE A COMBOBOX CONTAINING ALL OF THE GSM PROVIDERS AVAILABLE
		gsmProvidersComboBox = new JComboBox<>();
		updateGSMProviderComboBox();
		gsmProvidersComboBox.setFont(new Font("Liberation Mono", Font.BOLD, 18));
		gsmProvidersComboBox.setBounds(12, 17, 240, 40);
		serviceProviderPanel.add(gsmProvidersComboBox);
		
		//IF ONE OF THE GSM PROVDER IS CHOSEN UPLOAD ITS INFORMATION
		gsmProvidersComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gsmProvidersComboBox.getSelectedItem() != null) {
					String name = gsmProvidersComboBox.getSelectedItem().toString();
					if(!name.equalsIgnoreCase("Select GSM Provider")) {
						for(GSMProvider gsm:gsmProviders) {
							if(gsm.getName().equalsIgnoreCase(name)) {
								serviceProviderTypesComboBox.setSelectedItem("GSM Provider");
								serviceProviderNameText.setText(name);
								
								
								subText = "";
								for(SubscriptionPlan subPlan:gsm.getSubscriptionPlans()) {
									subText += (subPlan.getName()+"\n");
								}
								
								subscriptionPlansText.setText(subText);
								cableProvidersComboBox.setSelectedItem("Select Cable Provider");
								
								break;
							}
						}
					}
					else {
						if(cableProvidersComboBox.getSelectedItem().toString().equalsIgnoreCase("Select Cable Provider")) {
							clearServiceProviderPanel();
						}
					}
				}
			}
		});
		
		
		//CREATE A COMBOBOX CONTAINING ALL OF THE CABLE PROVIDERS AVAILABLE
		cableProvidersComboBox = new JComboBox<>();
		updateCableProviderComboBox();
		cableProvidersComboBox.setFont(new Font("Liberation Mono", Font.BOLD, 18));
		cableProvidersComboBox.setBounds(333, 16, 262, 40);
		serviceProviderPanel.add(cableProvidersComboBox);
		
		//IF ONE OF THE CABLE PROVDER IS CHOSEN UPLOAD ITS INFORMATION
		cableProvidersComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cableProvidersComboBox.getSelectedItem() != null) {
					String name = cableProvidersComboBox.getSelectedItem().toString();
					if(!name.equalsIgnoreCase("Select Cable Provider")) {
						for(CableProvider cable:cableProviders) {
							if(cable.getName().equalsIgnoreCase(name)) {
								
								serviceProviderTypesComboBox.setSelectedItem("Cable Provider");
								serviceProviderNameText.setText(name);
								
								subText = "";
								for(SubscriptionPlan subPlan:cable.getSubscriptionPlans()) {
									subText += (subPlan.getName()+"\n");
								}
								
								subscriptionPlansText.setText(subText);
								gsmProvidersComboBox.setSelectedItem("Select GSM Provider");
								
								break;
							}
						}
					}
					else {
						if(gsmProvidersComboBox.getSelectedItem().toString().equalsIgnoreCase("Select GSM Provider")) {
							clearServiceProviderPanel();
						}
					}
				}
				
			}
		});
		
		
		
		// CREATE A BUTTON TO CONFIRM THE CHANGES CAN BE USED TO CREATE OR UPDATE THE PROVIDERS
		JButton confirmServiceProviderButton = new JButton("Confirm");
		confirmServiceProviderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gsmProvidersComboBox.getSelectedItem().toString().equalsIgnoreCase("Select GSM Provider")) {
					if(cableProvidersComboBox.getSelectedItem().toString().equalsIgnoreCase("Select Cable Provider")) {
						if(!serviceProviderName.getText().isBlank()) {
							String serviceProviderType = serviceProviderTypesComboBox.getSelectedItem().toString();
							if(serviceProviderType == "GSM Provider" ) {
								createGSMProvider();
							}
							else if(serviceProviderType == "Cable Provider") {
								createCableProvider();
								
							}
						}
					}
					else {
						updateCableProvider();
					}
				}
				else {
					updateGSMProvider();
				}
			}
		});
		confirmServiceProviderButton.setFont(new Font("Dialog", Font.BOLD, 20));
		confirmServiceProviderButton.setBounds(762, 419, 150, 50);
		serviceProviderPanel.add(confirmServiceProviderButton);
		
		
		//CREATE A BUTTON TO DELETE SERVICE PROVIDERS OR SUBSCRIPTION PLAN
		JButton deleteServiceProviderButton_1 = new JButton("Delete");
		deleteServiceProviderButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!subscriptionPlanNameText.getText().isBlank()) {
					deleteServiceProviderSubscription();
				}
				
				else {
					deleteServiceProvider();
				}
			}
		});
		deleteServiceProviderButton_1.setFont(new Font("Dialog", Font.BOLD, 20));
		deleteServiceProviderButton_1.setBounds(518, 419, 150, 50);
		serviceProviderPanel.add(deleteServiceProviderButton_1);
		

		
		
	}
	
	//////////////////////////////////////////////////////////////////SERVICE PROVIDER FUNCTIONALITIES/////////////////////////////////////////////////////////////
	
	public void deleteServiceProviderSubscription() {
		String cableName = cableProvidersComboBox.getSelectedItem().toString();
		String gsmName = gsmProvidersComboBox.getSelectedItem().toString();
		
		if(!cableName.equalsIgnoreCase("Select Cable Provider")) {
			for(CableProvider cable:cableProviders) {
				if(cable.getName().equalsIgnoreCase(cableName)) {
					if(cable.removeSubscriptionPlan(subscriptionPlanNameText.getText())) {
						
						
						subscriptionPlanComboBox.removeItem(cable.getName()+" "+subscriptionPlanNameText.getText());
						
						cableProvidersComboBox.setSelectedItem(cableName);
						subscriptionPlanNameText.setText("");
						JOptionPane.showMessageDialog(null, "The Subscription Has Been Deleted");
					}
					else {
						subscriptionPlanNameText.setText("");
						JOptionPane.showMessageDialog(null, "The Service Provider Doesn't Have the Selected Subscription");
					}
					break;
				}
			}
		}
		
		else if(!gsmName.equalsIgnoreCase("Select GSM Provider")) {
			for(GSMProvider gsm:gsmProviders) {
				if(gsm.getName().equalsIgnoreCase(gsmName)) {
					if(gsm.removeSubscriptionPlan(subscriptionPlanNameText.getText())) {
						
						subscriptionPlanComboBox.removeItem(gsm.getName()+" "+subscriptionPlanNameText.getText());
						
						gsmProvidersComboBox.setSelectedItem(gsmName);
						subscriptionPlanNameText.setText("");
						JOptionPane.showMessageDialog(null, "The Subscription Has Been Deleted");
					}
					else {
						subscriptionPlanNameText.setText("");
						JOptionPane.showMessageDialog(null, "The Service Provider Doesn't Have the Selected Subscription");
					}
					break;
				}
			}
		}
		
		else {
			subscriptionPlanNameText.setText("");
			JOptionPane.showMessageDialog(null, "Select a Service Provider to Delete its Subscription");
		}
	}
	
	public void deleteServiceProvider() {
		String cableName = cableProvidersComboBox.getSelectedItem().toString();
		String gsmName = gsmProvidersComboBox.getSelectedItem().toString();
		if(!cableName.equalsIgnoreCase("Select Cable Provider")) {
			for(CableProvider cable:cableProviders) {
				if(cable.getName().equalsIgnoreCase(cableName)) {
					
					//DELETE SUBSCRIPTION PLANS ON SUBPLAN COMBO BOX THAT BELONGS TO THE DELETED SERVICE PROVIDER
					for(SubscriptionPlan subPlan:cable.getSubscriptionPlans()) {
						subscriptionPlanComboBox.removeItem(cable.getName()+" "+subPlan.getName());
					}
					
					cableProviders.remove(cable);
					updateCableProviderComboBox();
					clearServiceProviderPanel();
					
					
					
					JOptionPane.showMessageDialog(null, "The Service Provider Has Been Deleted");
					break;
				}
			}
		}
		
		else if(!gsmName.equalsIgnoreCase("Select GSM Provider")) {
			for(GSMProvider gsm:gsmProviders) {
				if(gsm.getName().equalsIgnoreCase(gsmName)) {
					
					//DELETE SUBSCRIPTION PLANS ON SUBPLAN COMBO BOX THAT BELONGS TO THE DELETED SERVICE PROVIDER
					for(SubscriptionPlan subPlan:gsm.getSubscriptionPlans()) {
						subscriptionPlanComboBox.removeItem(gsm.getName()+" "+subPlan.getName());
					}
					
					gsmProviders.remove(gsm);
					updateGSMProviderComboBox();
					clearServiceProviderPanel();
					JOptionPane.showMessageDialog(null, "The Service Provider Has Been Deleted");
					break;
				}
			}
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Select a Service Provider to Delete");
		}
	}
	
	public void createGSMProvider() {
		String name = serviceProviderNameText.getText();
		if(!name.isBlank()) {
			boolean isExist = false;
			
			//CHECK IF THE NAME EXIST IN GSM PROVIDERS
			for(GSMProvider gsm:gsmProviders) {
				if(gsm.getName().equalsIgnoreCase(name)) {
					isExist = true;
					break;
				}
			}
			
			//CHECK IF THE NAME EXIST IN CABLE PROVIDERS
			if(!isExist) {
				for(CableProvider cable:cableProviders) {
					if(cable.getName().equalsIgnoreCase(name)) {
						isExist = true;
						break;
					}
				}
			}
			
			
			
			if(isExist) {
				JOptionPane.showMessageDialog(null, "The Service Provider Already Exist");
			}
			else {
				//IF IT DOESN'T EXIST CREATE A GSM PROVIDER
				String subPlanName = subscriptionPlanNameText.getText();
				GSMProvider gsmProvider = new GSMProvider(name);
				if(!subPlanName.isBlank()) {
					SubscriptionPlan subPlan = new SubscriptionPlan(subPlanName,gsmProvider);
					gsmProvider.addSubscriptionPlan(subPlan);
					subscriptionPlanComboBox.addItem(gsmProvider.getName() +" "+subPlan.getName());
					subscriptionPlanNameText.setText("");
					
				}
				gsmProviders.add(gsmProvider);
				updateGSMProviderComboBox();
				gsmProvidersComboBox.setSelectedItem(gsmProvider.getName());
			}
		}
	}
	
	public void createCableProvider() {
		String name = serviceProviderNameText.getText();
		if(!name.isBlank()) {
			
			boolean isExist = false;
			
			//CHECK IF THE NAME EXIST IN GSM PROVIDERS
			for(GSMProvider gsm:gsmProviders) {
				if(gsm.getName().equalsIgnoreCase(name)) {
					isExist = true;
					break;
				}
			}
			
			//CHECK IF THE NAME EXIST IN CABLE PROVIDERS
			if(!isExist) {
				for(CableProvider cable:cableProviders) {
					if(cable.getName().equalsIgnoreCase(name)) {
						isExist = true;
						break;
					}
				}
			}
			
			if(isExist) {
				JOptionPane.showMessageDialog(null, "The Service Provider Already Exist");
			}
			else {
				//IF IT DOESN'T EXIST CREATE A GSM PROVIDER
				String subPlanName = subscriptionPlanNameText.getText();
				CableProvider cableProvider = new CableProvider(name);
				if(!subPlanName.isBlank()) {
					SubscriptionPlan subPlan = new SubscriptionPlan(subPlanName,cableProvider);
					cableProvider.addSubscriptionPlan(subPlan);
					subscriptionPlanComboBox.addItem(cableProvider.getName() +" "+subPlan.getName());
					subscriptionPlanNameText.setText("");
				}
				cableProviders.add(cableProvider);
				updateCableProviderComboBox();
				cableProvidersComboBox.setSelectedItem(cableProvider.getName());
			}
		}
	}
	
	public void updateGSMProvider() {
		String name = gsmProvidersComboBox.getSelectedItem().toString();
		for(GSMProvider gsm:gsmProviders) {
			if(name.equalsIgnoreCase(gsm.getName())) {
				
				//IF NAME OF THE SERVICE PROVIDER HAS CHANGED CHANGE THE NAME
				if(!serviceProviderNameText.getText().isBlank() && !name.equals(serviceProviderNameText.getText())) {
					//REMOVE SUBSCRIPTION PLANS THAT BELONGS TO THE OLD NAME
					for(SubscriptionPlan subPlan:gsm.getSubscriptionPlans()) {
						subscriptionPlanComboBox.removeItem(gsm.getName() + " "+subPlan.getName());
					}
					
					//UPDATE THE NAME
					gsm.setName(serviceProviderNameText.getText());
					updateGSMProviderComboBox();
					gsmProvidersComboBox.setSelectedItem(gsm.getName());
					
					// ADD SUBSCRIPTION PLANS WITH NEW NAME 
					for(SubscriptionPlan subPlan:gsm.getSubscriptionPlans()) {
						subscriptionPlanComboBox.addItem(gsm.getName() + " "+subPlan.getName());
					}
					
					// CHANGE THE NAME OF THE SERVICE PROVIDER FOR THE CUSTOMERS THAT ALREADY REGISTERED
					clearCustomerPanel();
					for(ExistingCustomer eCustomer:existingCustomers) {
						if(eCustomer.getSubscription().getSubscriptionPlan().getServiceProvider().getName().equalsIgnoreCase(name)) {
							eCustomer.getSubscription().getSubscriptionPlan().getServiceProvider().setName(gsm.getName());
						}
					}
					
				}
				
				String subPlanName = subscriptionPlanNameText.getText();
				if(!subPlanName.isBlank()) {
					SubscriptionPlan subPlan = gsm.findSubscriptionPlan(subPlanName);
					if(subPlan == null) {
						subPlan = new SubscriptionPlan(subPlanName,gsm);
						gsm.addSubscriptionPlan(subPlan);
						subscriptionPlanComboBox.addItem(gsm.getName() +" "+subPlan.getName());
						subText += (subPlanName+"\n");
						subscriptionPlansText.setText(subText);
						subscriptionPlanNameText.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "The Plan Already Exist");
						subscriptionPlanNameText.setText("");
					}
				}
				
				
				break;
			}
		}
	}
	
	public void updateCableProvider() {
		String name = cableProvidersComboBox.getSelectedItem().toString();
		for(CableProvider cable:cableProviders) {
			if(name.equalsIgnoreCase(cable.getName())) {
				//IF NAME OF THE SERVICE PROVIDER HAS CHANGED CHANGE THE NAME
				if(!serviceProviderNameText.getText().isBlank() && !name.equals(serviceProviderNameText.getText())) {
					//REMOVE SUBSCRIPTION PLANS THAT BELONGS TO THE OLD NAME
					for(SubscriptionPlan subPlan:cable.getSubscriptionPlans()) {
						subscriptionPlanComboBox.removeItem(cable.getName() + " "+subPlan.getName());
					}
					
					
					//UPDATE THE NAME
					cable.setName(serviceProviderNameText.getText());
					updateCableProviderComboBox();
					cableProvidersComboBox.setSelectedItem(cable.getName());
					
					// ADD SUBSCRIPTION PLANS WITH NEW NAME 
					for(SubscriptionPlan subPlan:cable.getSubscriptionPlans()) {
						subscriptionPlanComboBox.addItem(cable.getName() + " "+subPlan.getName());
					}
					
					
					// CHANGE THE NAME OF THE SERVICE PROVIDER FOR THE CUSTOMERS THAT ALREADY REGISTERED
					clearCustomerPanel();
					for(ExistingCustomer eCustomer:existingCustomers) {
						if(eCustomer.getSubscription().getSubscriptionPlan().getServiceProvider().getName().equalsIgnoreCase(name)) {
							eCustomer.getSubscription().getSubscriptionPlan().getServiceProvider().setName(cable.getName());
						}
					}
					
				}
				
				String subPlanName = subscriptionPlanNameText.getText();
				if(!subPlanName.isBlank()) {
					SubscriptionPlan subPlan = cable.findSubscriptionPlan(subPlanName);
					if(subPlan == null) {
						subPlan = new SubscriptionPlan(subPlanName,cable);
						cable.addSubscriptionPlan(subPlan);
						subscriptionPlanComboBox.addItem(cable.getName() +" "+subPlan.getName());
						subText += (subPlanName+"\n");
						subscriptionPlansText.setText(subText);
						subscriptionPlanNameText.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "The Plan Already Exist");
						subscriptionPlanNameText.setText("");
					}
				}
				
				
				break;
				
			}
		}
	}
	
	public void clearServiceProviderPanel() {
		serviceProviderNameText.setText("");
		subscriptionPlanNameText.setText("");
		subscriptionPlansText.setText("");
		cableProvidersComboBox.setSelectedItem("Select Cable Provider");
		gsmProvidersComboBox.setSelectedItem("Select GSM Provider");
		serviceProviderTypesComboBox.setSelectedItem("Select Type");
	}
	
	public void updateCableProviderComboBox() {
		cableProvidersComboBox.removeAllItems();
		cableProvidersComboBox.addItem("Select Cable Provider");
		for(CableProvider cable:cableProviders) {
			cableProvidersComboBox.addItem(cable.getName());
		}
	}
	
	public void updateGSMProviderComboBox() {
		gsmProvidersComboBox.removeAllItems();
		gsmProvidersComboBox.addItem("Select GSM Provider");
		for(GSMProvider gsm:gsmProviders) {
			gsmProvidersComboBox.addItem(gsm.getName());
		}
	}
	
	//////////////////////////////////////////////////////////////////CUSTOMER FUNCTIONALITIES//////////////////////////////////////////////////////////
	
	public void deleteExistingCustomer() {
		String citizenShipNr = citizenshipNumberText.getText();
		for(ExistingCustomer eCustomer:existingCustomers) {
			if(eCustomer.getCitizenshipNr().equalsIgnoreCase(citizenShipNr)) {
				existingCustomers.remove(eCustomer);
				updateExistingCustomerComboBox();
				clearCustomerPanel();
				JOptionPane.showMessageDialog(null, "CUSTOMER DELETED");
				break;
			}
		}
	}
	
	public void deletePossibleCustomer() {
		String citizenShipNr = citizenshipNumberText.getText();
		for(PossibleCustomer pCustomer:possibleCustomers) {
			if(pCustomer.getCitizenshipNr().equalsIgnoreCase(citizenShipNr)) {
				possibleCustomers.remove(pCustomer);
				updatePossibleCustomerComboBox();
				clearCustomerPanel();
				JOptionPane.showMessageDialog(null, "CUSTOMER DELETED");
				break;
			}
		}
	}
	
	public void clearCustomerPanel() {
		citizenshipNumberText.setText("");
		nameText.setText("");
		telephoneNumberText.setText("");
		mailText.setText("");
		dateText.setText("");
		possibleCustomerComboBox.setSelectedItem("Possible Customers");
		existingCustomerComboBox.setSelectedItem("Existing Customers");
		subscriptionPlanComboBox.setSelectedItem("Select Plan");
	}
	
	public void updateExistingCustomerComboBox() {
		existingCustomerComboBox.removeAllItems();
		existingCustomerComboBox.addItem("Existing Customers");
		
		for(ExistingCustomer eCustomer:existingCustomers) {
			existingCustomerComboBox.addItem(eCustomer.getCitizenshipNr() +" "+ eCustomer.getName());
		}
	}
	
	public void updatePossibleCustomerComboBox() {
		possibleCustomerComboBox.removeAllItems();
		possibleCustomerComboBox.addItem("Possible Customers");
		
		for(PossibleCustomer pCustomer:possibleCustomers) {
			possibleCustomerComboBox.addItem(pCustomer.getCitizenshipNr()+ " "+pCustomer.getName());
		}
	}
	
	public void createCustomer() {
		String citizenshipNumber = citizenshipNumberText.getText(); 
		if(! citizenshipNumber.isBlank()) {
			boolean isExist = false;
			
			//CHECK IF THE CUSTOMER EXIST IN POSSIBLE CUSTOMERS
			for(PossibleCustomer pCustomer:possibleCustomers) {
				if(pCustomer.getCitizenshipNr().equalsIgnoreCase(citizenshipNumber)){
					isExist = true;
					JOptionPane.showMessageDialog(null, "The Customer Could Not Be Created. There Is a Customer With the Same Citizenship ID. ");
					break;
				}
			}
			
			//CHECK IF THE CUSTOMER EXIST IN EXISTING CUSTOMERS
			if(!isExist) {
				for(ExistingCustomer eCustomer:existingCustomers) {
					if(eCustomer.getCitizenshipNr().equalsIgnoreCase(citizenshipNumber)) {
						isExist = true;
						JOptionPane.showMessageDialog(null, "The Customer Could Not Be Created. There Is a Customer With the Same Citizenship ID. ");
						break;
					}
				}
			}
			
			//IF NOT CREATE A POSSIBLE CUSTOMER
			if(! isExist) {
				PossibleCustomer possibleCustomer = new PossibleCustomer(citizenshipNumber);
				if(!nameText.getText().isBlank())
					possibleCustomer.setName(nameText.getText());
				
				if(!mailText.getText().isBlank())
					possibleCustomer.setMail(mailText.getText());
				
				if(!telephoneNumberText.getText().isBlank())
					possibleCustomer.setTel(telephoneNumberText.getText());
					
			
				//IF SUBSCRIPTION PLAN HAS CHOSEN, UPGRADE THE CUSTOMER TO EXISTING CUSTOMER
				if(subscriptionPlanComboBox.getSelectedItem().toString() != "Select Plan") {
					String dateString = dateText.getText();
					SubscriptionPlan subPlan = null;
					if(!dateString.isBlank()) {
						try {
							//CREATE A DATE FROM GOTTEN STRING FORM TEXT FIELD
							Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
							String subPlanInfo[] = subscriptionPlanComboBox.getSelectedItem().toString().split(" ");
							boolean hasSubscriptionPlan = false;
							
							//TRY TO FIND THE SUBSCRIPTION FROM GSM PROVIDERS
							for(GSMProvider gsm:gsmProviders) {
								if(gsm.getName().equalsIgnoreCase(subPlanInfo[0])) {
									subPlan = gsm.findSubscriptionPlan(subPlanInfo[1]);
									hasSubscriptionPlan = true;
									break;
								}
							}
							
							//TRY TO FIND THE SUBSCRIPTION FROM CABLE PROVIDERS
							if(!hasSubscriptionPlan) {
								for(CableProvider cable:cableProviders) {
									if(cable.getName().equalsIgnoreCase(subPlanInfo[0])) {
										subPlan = cable.findSubscriptionPlan(subPlanInfo[1]);
										hasSubscriptionPlan = true;
										break;
									}
								}
							}
							
							//IF SUBSCRIPTION PLAN HAS FOUND UPGRADE THE CUSTOMER TO EXISTING CUSTOMER AND ADD TO THE LIST
							if(hasSubscriptionPlan) {
								Subscription subscription = new Subscription(startDate,subPlan);
								//CREATE AN EXISTING CUSTOMER FROM POSSIBLE CUSTOMER
								ExistingCustomer existingCustomer = new ExistingCustomer(possibleCustomer.getCitizenshipNr());
								existingCustomer.setMail(possibleCustomer.getMail());
								existingCustomer.setName(possibleCustomer.getName());
								existingCustomer.setTel(possibleCustomer.getTel());
								
								//SET SUBSCRIPTION FOR EXISTING CUSTOMER
								existingCustomer.setSubscription(subscription);
								existingCustomers.add(existingCustomer);
								updateExistingCustomerComboBox();
								existingCustomerComboBox.setSelectedItem(existingCustomer.getCitizenshipNr()+" "+existingCustomer.getName());
						
							}
							
						} 
						
						//IF DATE IS GIVEN WRONG DISPLAY A MESSAGE
						catch (ParseException error) {
							// TODO Auto-generated catch block
							dateText.setText("");
							JOptionPane.showMessageDialog(null, "The Date You Have Entered Is In Wrong Format (DD.MM.YYYY)");
							error.printStackTrace();
							
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Please Enter a Date");
					}
					
				}
				
				else {
					possibleCustomers.add((PossibleCustomer) possibleCustomer);
					updatePossibleCustomerComboBox();
					System.out.println("Added to the possible customers");
					possibleCustomerComboBox.setSelectedItem(possibleCustomer.getCitizenshipNr() + " "+possibleCustomer.getName());
				}
			}
		}
	}
	
	public void updateExistingCustomer() {
		String customerInfo[] = existingCustomerComboBox.getSelectedItem().toString().split(" ");
		for(ExistingCustomer existingCustomer:existingCustomers) {
			if(existingCustomer.getCitizenshipNr().equalsIgnoreCase(customerInfo[0])) {
				if(!nameText.getText().isBlank() &&  (existingCustomer.getName()==null || !existingCustomer.getName().equalsIgnoreCase(nameText.getText()))) {
					existingCustomer.setName(nameText.getText());
					updateExistingCustomerComboBox();
					existingCustomerComboBox.setSelectedItem(existingCustomer.getCitizenshipNr() + " "+existingCustomer.getName());
				}
				
				if(!mailText.getText().isBlank() &&  (existingCustomer.getMail()==null || !existingCustomer.getMail().equalsIgnoreCase(mailText.getText()))) {
					existingCustomer.setMail(mailText.getText());
				}
				
				if(!telephoneNumberText.getText().isBlank() && (existingCustomer.getTel() == null || !existingCustomer.getTel().equalsIgnoreCase(telephoneNumberText.getText()))) {
					existingCustomer.setTel(telephoneNumberText.getText());
				}
				
				String subPlanInfo[] = subscriptionPlanComboBox.getSelectedItem().toString().split(" ");
				
				if(!existingCustomer.getSubscription().getSubscriptionPlan().getName().equalsIgnoreCase(subPlanInfo[0])
						|| !existingCustomer.getSubscription().getSubscriptionPlan().getServiceProvider().getName().equalsIgnoreCase(subPlanInfo[1]) ) {
					
					try {
						//CREATE A DATE FROM GOTTEN STRING FORM TEXT FIELD
						String dateString = dateText.getText();
						SubscriptionPlan subPlan = null;
						Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
						boolean hasSubscriptionPlan = false;
						
						//TRY TO FIND THE SUBSCRIPTION FROM GSM PROVIDERS
						for(GSMProvider gsm:gsmProviders) {
							if(gsm.getName().equalsIgnoreCase(subPlanInfo[0])) {
								subPlan = gsm.findSubscriptionPlan(subPlanInfo[1]);
								hasSubscriptionPlan = true;
								break;
							}
						}
						
						//TRY TO FIND THE SUBSCRIPTION FROM CABLE PROVIDERS
						if(!hasSubscriptionPlan) {
							for(CableProvider cable:cableProviders) {
								if(cable.getName().equalsIgnoreCase(subPlanInfo[0])) {
									subPlan = cable.findSubscriptionPlan(subPlanInfo[1]);
									hasSubscriptionPlan = true;
									break;
								}
							}
						}
						
						//IF SUBSCRIPTION PLAN HAS FOUND CHANGE THE CUSTOMERS SUBSCRIPTION
						if(hasSubscriptionPlan) {
							Subscription subscription = new Subscription(startDate,subPlan);
							existingCustomer.setSubscription(subscription);
					
						}
						
					} 
					
					//IF DATE IS GIVEN WRONG DISPLAY A MESSAGE
					catch (ParseException error) {
						// TODO Auto-generated catch block
						dateText.setText("");
						JOptionPane.showMessageDialog(null, "The Date You Have Entered Is In Wrong Format (YYYY.MM.DD)");
						error.printStackTrace();
						
					}

					
					
				}
				
				break;
			}
		}
		System.out.println("Existing: "+existingCustomers.size());

	}

	public void updatePossibleCustomer() {
		String customerInfo[] = possibleCustomerComboBox.getSelectedItem().toString().split(" ");
		for(PossibleCustomer possibleCustomer:possibleCustomers) {
			if(possibleCustomer.getCitizenshipNr().equalsIgnoreCase(customerInfo[0])) {
				if(!nameText.getText().isBlank() && (possibleCustomer.getName() == null || !possibleCustomer.getName().equalsIgnoreCase(nameText.getText()))) {
					possibleCustomer.setName(nameText.getText());
					updatePossibleCustomerComboBox();
					possibleCustomerComboBox.setSelectedItem(possibleCustomer.getCitizenshipNr() + " "+possibleCustomer.getName());
				}
				
				if(!mailText.getText().isBlank() && (possibleCustomer.getMail() == null || !possibleCustomer.getMail().equalsIgnoreCase(mailText.getText())))
					possibleCustomer.setMail(mailText.getText());
				
				if(!telephoneNumberText.getText().isBlank() && (possibleCustomer.getTel() == null || !possibleCustomer.getTel().equalsIgnoreCase(telephoneNumberText.getText())))
					possibleCustomer.setTel(telephoneNumberText.getText());
				
				//IF SUBSCRIPTION PLAN HAS CHOSEN, UPGRADE THE CUSTOMER TO EXISTING CUSTOMER
				if(subscriptionPlanComboBox.getSelectedItem().toString() != "Select Plan") {
					String dateString = dateText.getText();
					SubscriptionPlan subPlan = null;
					if(!dateString.isBlank()) {
						try {
							//CREATE A DATE FROM GOTTEN STRING FORM TEXT FIELD
							Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
							String subPlanInfo[] = subscriptionPlanComboBox.getSelectedItem().toString().split(" ");
							boolean hasSubscriptionPlan = false;
							
							//TRY TO FIND THE SUBSCRIPTION FROM GSM PROVIDERS
							for(GSMProvider gsm:gsmProviders) {
								if(gsm.getName().equalsIgnoreCase(subPlanInfo[0])) {
									subPlan = gsm.findSubscriptionPlan(subPlanInfo[1]);
									hasSubscriptionPlan = true;
									break;
								}
							}
							
							//TRY TO FIND THE SUBSCRIPTION FROM CABLE PROVIDERS
							if(!hasSubscriptionPlan) {
								for(CableProvider cable:cableProviders) {
									if(cable.getName().equalsIgnoreCase(subPlanInfo[0])) {
										subPlan = cable.findSubscriptionPlan(subPlanInfo[1]);
										hasSubscriptionPlan = true;
										break;
									}
								}
							}
							
							//IF SUBSCRIPTION PLAN HAS FOUND UPGRADE THE CUSTOMER TO EXISTING CUSTOMER AND ADD TO THE LIST
							if(hasSubscriptionPlan) {
								Subscription subscription = new Subscription(startDate,subPlan);
								//CREATE AN EXISTING CUSTOMER FROM POSSIBLE CUSTOMER
								ExistingCustomer existingCustomer = new ExistingCustomer(possibleCustomer.getCitizenshipNr());
								existingCustomer.setMail(possibleCustomer.getMail());
								existingCustomer.setName(possibleCustomer.getName());
								existingCustomer.setTel(possibleCustomer.getTel());
								
								System.out.println("Existing Customer Created");
								existingCustomer.setSubscription(subscription);
								existingCustomers.add(existingCustomer);
								possibleCustomers.remove(possibleCustomer);
								updateExistingCustomerComboBox();
								updatePossibleCustomerComboBox();
								existingCustomerComboBox.setSelectedItem(existingCustomer.getCitizenshipNr() + " "+existingCustomer.getName());
						
							}
							
						} 
						
						//IF DATE IS GIVEN WRONG DISPLAY A MESSAGE
						catch (ParseException error) {
							// TODO Auto-generated catch block
							dateText.setText("");
							JOptionPane.showMessageDialog(null, "The Date You Have Entered Is In Wrong Format (DD.MM.YYYY)");
							error.printStackTrace();
							
						}
					}			
				}
				
				
				
				break;
			}
		}
	}
}








