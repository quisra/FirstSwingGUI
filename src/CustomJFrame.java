/** 
 * Initializes GUI to be called once program runs. 
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.*;


public class CustomJFrame extends JFrame{
	
	private JLabel headingLabel = new JLabel("Personal Information");
	private JLabel firstNameLabel = new JLabel("First Name:");
	private JLabel lastNameLabel = new JLabel("Last Name:");
	private JLabel phoneNumberLabel = new JLabel("Phone Number:");
	private JLabel emailLabel = new JLabel("Email:");
	private JLabel dietaryLabel = new JLabel("Dietary Questions");
	private JLabel genderLabel = new JLabel("Sex:");
	private JLabel waterLabel = new JLabel("How many cups of water on average do you drink a day?");
	private JLabel mealsLabel = new JLabel("How many meals on average do you eat a day?");
	private JLabel checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
	private JLabel walkLabel = new JLabel("On average how many miles do you walk in a day?");
	private JLabel weightLabel = new JLabel("How much do you weigh?");
	private JTextField firstNameTextField = new JTextField();
	private JTextField lastNameTextField = new JTextField();
	private JTextField phoneNumberTextField = new JTextField();
	private JTextField emailTextField = new JTextField();
	private JRadioButton maleRadioButton = new JRadioButton();
	private JRadioButton femaleRadioButton = new JRadioButton();
	private JRadioButton preferRadioButton = new JRadioButton();
	private ButtonGroup radioButtonGroup = new ButtonGroup();
	private JSpinner waterIntakeSpinner = new JSpinner();
	private JSlider mealSlider = new JSlider();
	private JCheckBox wheatCheckBox = new JCheckBox();
	private JCheckBox sugarCheckBox = new JCheckBox();
	private JCheckBox diaryCheckBox = new JCheckBox();
	private JComboBox walkCombo = new JComboBox();
	private String[] walkOptions = {"Less than 1 Mile","More than 1 mile but less than 2 miles","More than 2 miles but less than 3 miles","More than 3 miles"};
	private NumberFormat numberFormatter = NumberFormat.getNumberInstance();
	private JFormattedTextField weightFormattedTextField = new JFormattedTextField(numberFormatter);
	private JButton clearButton = new JButton("Clear");
	private JButton submitButton = new JButton("Submit");
	private FileHandler fileHandler;
	
	
	
	public CustomJFrame() {
		
		setTitle("Dietary Survey");
		
		this.firstNameTextField.setColumns(15);
		this.lastNameTextField.setColumns(15);
		this.emailTextField.setColumns(15);
		this.phoneNumberTextField.setColumns(15);
		this.weightFormattedTextField.setColumns(15);
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints layoutManager  = new GridBagConstraints();
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		layoutManager.insets= new Insets(10, 10, 10, 10);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 0;
		this.add(headingLabel, layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 1;
		this.add(firstNameLabel, layoutManager);
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 1;
		this.add(firstNameTextField, layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 2;
		this.add(lastNameLabel, layoutManager);
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 2;
		this.add(lastNameTextField, layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 3;
		this.add(phoneNumberLabel, layoutManager);
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 3;
		this.add(phoneNumberTextField,layoutManager);
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 4;
		this.add(emailLabel,layoutManager);
		
		layoutManager.gridx = 1;
		layoutManager.gridy = 4;
		this.add(emailTextField,layoutManager);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 5;
		this.add(genderLabel,layoutManager);
		
		maleRadioButton.setText("Male");
		maleRadioButton.setSelected(false);
		maleRadioButton.setActionCommand("male");
		layoutManager.gridx = 1;
		layoutManager.gridy = 5;
		layoutManager.insets = new Insets(0, 0, 0, 0);
		this.add(maleRadioButton, layoutManager);
		
		femaleRadioButton.setText("Female");
		femaleRadioButton.setSelected(false);
		femaleRadioButton.setActionCommand("female");
		layoutManager.gridx = 1;
		layoutManager.gridy = 6;
		this.add(femaleRadioButton, layoutManager);
		
		preferRadioButton.setText("Prefer not to say");
		preferRadioButton.setSelected(false);
		preferRadioButton.setActionCommand("prefer not to say");
		layoutManager.gridx = 1;
		layoutManager.gridy = 7;
		this.add(preferRadioButton, layoutManager);
		
		radioButtonGroup.add(maleRadioButton);
		radioButtonGroup.add(femaleRadioButton);
		radioButtonGroup.add(preferRadioButton);
		
		
		layoutManager.gridx = 0;
		layoutManager.gridy = 8;
		layoutManager.insets= new Insets(12,12,12,12);
		this.add(dietaryLabel,layoutManager);
		
		layoutManager.gridwidth= 2;
		layoutManager.gridx = 0;
		layoutManager.gridy = 9;
		this.add(waterLabel, layoutManager);
		
		double initSpin = 15;
		double minSpin = 0;
		double maxSpin = 50;
		double step = 1;
		SpinnerNumberModel spinerModel = new SpinnerNumberModel(initSpin, minSpin, maxSpin, step);
		waterIntakeSpinner = new JSpinner(spinerModel);
		
		layoutManager.gridwidth= 1;
		layoutManager.gridx= 2;
		layoutManager.gridy = 9;
		this.add(waterIntakeSpinner, layoutManager);
		
		layoutManager.gridwidth= 2;
		layoutManager.gridx= 0;
		layoutManager.gridy = 10;
		this.add(mealsLabel, layoutManager);
		
		int min = 0;
		int max = 10;
		int init = 3;
		mealSlider = new JSlider(SwingConstants.HORIZONTAL, min, max, init);
		mealSlider.setMinorTickSpacing(10);
		mealSlider.setMajorTickSpacing(2);
		mealSlider.setPaintTicks(true);
		mealSlider.setPaintLabels(true);
		
		layoutManager.gridwidth= 2;
		layoutManager.gridx= 0;
		layoutManager.gridy = 11;
		this.add(mealSlider, layoutManager);
		
		layoutManager.gridwidth= 2;
		layoutManager.gridx= 0;
		layoutManager.gridy = 12;
		this.add(checkBoxLabel, layoutManager);
		
		wheatCheckBox.setText("wheat");
		wheatCheckBox.setSelected(false);
		
		diaryCheckBox.setText("Diary");
		diaryCheckBox.setSelected(false);
		
		
		sugarCheckBox.setText("Sugar");
		sugarCheckBox.setSelected(false);
		
		
		
		layoutManager.gridx= 0;
		layoutManager.gridy = 13;
		this.add(diaryCheckBox,layoutManager);
		
		
		layoutManager.gridx= 1;
		layoutManager.gridy = 13;
		this.add(wheatCheckBox,layoutManager);
		
		
		layoutManager.gridx= 2;
		layoutManager.gridy = 13;
		this.add(sugarCheckBox,layoutManager);
		
		layoutManager.gridx= 0;
		layoutManager.gridy = 14;
		this.add(walkLabel,layoutManager);
		
		walkCombo = new JComboBox<String>(walkOptions);
		layoutManager.gridwidth= 2;
		layoutManager.gridx = 1;
		layoutManager.gridy = 15;
		this.add(walkCombo, layoutManager);
		
		
		layoutManager.gridx= 0;
		layoutManager.gridy = 16;
		this.add(weightLabel,layoutManager);
		
		layoutManager.gridwidth= 2;
		layoutManager.gridx= 0;
		layoutManager.gridy = 17;
		this.add(weightFormattedTextField,layoutManager);
		
		layoutManager.gridx= 0;
		layoutManager.gridy = 18;
		this.add(clearButton,layoutManager);
		
		layoutManager.gridx= 1;
		layoutManager.gridy = 18;
		this.add(submitButton,layoutManager);
		
		submitButton.setName("submit");
		clearButton.setName("clear");
		
		/** 
		 * Action listener class 
		 */ 
		class InnerActionListener implements ActionListener{
			
			/** 
		     * Clears the input fields and sets all input to default. 
		     * 
		     */ 
			private void clearForm() {
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				phoneNumberTextField.setText("");
				emailTextField.setText("");
				radioButtonGroup.clearSelection();
				waterIntakeSpinner.setValue(initSpin);
				mealSlider.setValue(init);
				wheatCheckBox.setSelected(false);
				diaryCheckBox.setSelected(false);
				sugarCheckBox.setSelected(false);
				walkCombo.setSelectedIndex(0);
				weightFormattedTextField.setText("");
				
			}
			
			/** 
		     * Assigns the input at the click of a button 
		     * @param e The name of the button clicked
		     * 
		     */ 
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton button = (JButton) e.getSource();
				String name = button.getName();
				
				if(name.equals("submit")) {
					String firstName = firstNameTextField.getText();
					String lastName = lastNameTextField.getText();
					String phoneNum = phoneNumberTextField.getText();
					String email = emailTextField.getText();
					String sex;
					if(radioButtonGroup.getSelection() == null ) {
						sex = "null";
					}else {
						sex = radioButtonGroup.getSelection().getActionCommand();
					}
					
					String value = String.valueOf(waterIntakeSpinner.getValue());
					String sliderValue =  String.valueOf(mealSlider.getValue());
					String wheatSelected = String.valueOf(wheatCheckBox.isSelected()).toUpperCase();
					String diarySelected = String.valueOf(diaryCheckBox.isSelected()).toUpperCase() ;
					String sugarSelected = String.valueOf(sugarCheckBox.isSelected()).toUpperCase();
					String option = (String) walkCombo.getSelectedItem();
					String weight = String.valueOf(weightFormattedTextField.getValue());
					
					String survey = firstName  + "," + lastName + "," + phoneNum + "," + email + "," + sex+ "," + value + "," + sliderValue + "," + wheatSelected + "," + diarySelected + "," + sugarSelected + "," + option + "," + weight;
					FileHandler fileHandler = new FileHandler();
					fileHandler.writeResults(survey);
					
					clearForm();
				}else {
					clearForm();
				}	
			}	
		}

		InnerActionListener listener = new InnerActionListener();
		submitButton.addActionListener(listener);
		clearButton.addActionListener(listener);
		
		
		
	}
	
}
