/**
 * @author joshua albufera, darren jake ambong
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents a registration form that allows the user to input and register their user information.
 * the user information includes name, course, year level, gender, address, email, and contact number.
 */
public class RegistrationForm extends JFrame implements ActionListener {

    private Container container;
    private JLabel titleLabel, nameLabel, courseLabel, yearLabel, genderLabel, addressLabel, emailLabel, contactLabel;
    private JTextField nameField, addressField, emailField, contactField;
    private JComboBox<String> courseComboBox, yearComboBox;  
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;
    private JButton submitButton, clearButton, exitButton;

    Font titleFont = new Font("Arial", Font.BOLD, 14);
    Font mainFont = new Font("Arial", Font.PLAIN, 12);

    public RegistrationForm() {
        //Main Window Title
        setTitle("User Registration Form");
        setLocation(700, 250);
        setSize(400, 345);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        //Main Container
        container = getContentPane();
        container.setLayout(null);
        
        //Title
        titleLabel = new JLabel("Registration Form");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(130, 5, 300, 30);
        container.add(titleLabel);
        
        //Name Section
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(mainFont);
        nameLabel.setBounds(10, 35, 100, 30);
        container.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setFont(mainFont);
        nameField.setBounds(75, 40, 300, 20);
        container.add(nameField);
        
        //Course Section
        courseLabel = new JLabel("Course:");
        courseLabel.setFont(mainFont);
        courseLabel.setBounds(10, 70, 100, 30);
        container.add(courseLabel);

        String[] courses = {"[Select Course]", "BSCS-SE", "BSCS-DS", "BSIT-WMA", "BSIT-ADG", "BSIT-DA", "BSIT-IB", "BMMA", "BSCE", "BSME", "BSECE", "BSEE"};
        courseComboBox = new JComboBox<>(courses);
        courseComboBox.setFont(mainFont);
        courseComboBox.setBounds(75, 75, 300, 20);
        container.add(courseComboBox);
        
        //Year Section
        yearLabel = new JLabel("Year:");
        yearLabel.setFont(mainFont);
        yearLabel.setBounds(10, 105, 100, 30);
        container.add(yearLabel);

        String[] years = {"1", "2", "3", "4"};
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setFont(mainFont);
        yearComboBox.setBounds(75, 110, 40, 20);
        container.add(yearComboBox);

        //Gender Section
        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(mainFont);
        genderLabel.setBounds(170, 110, 72, 20);
        container.add(genderLabel);
        
        //Gender Radio Buttons
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(mainFont);
        maleRadioButton.setBounds(220, 105, 100, 30);
        container.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(mainFont);
        femaleRadioButton.setBounds(220, 128, 100, 30);
        container.add(femaleRadioButton);
        
        //Radio Buttons Group
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        
        //Address Section 
        addressLabel = new JLabel("Address:");
        addressLabel.setFont(mainFont);
        addressLabel.setBounds(10, 160, 100, 30);
        container.add(addressLabel);

        addressField = new JTextField();
        addressField.setFont(mainFont);
        addressField.setBounds(75, 165, 300, 20);
        container.add(addressField);

        //Email Section
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(mainFont);
        emailLabel.setBounds(10, 195, 100, 30);
        container.add(emailLabel);

        emailField = new JTextField();
        emailField.setFont(mainFont);
        emailField.setBounds(75, 200, 300, 20);
        container.add(emailField);
        
        //Contact Number Section
        contactLabel = new JLabel("Contact Number:");
        contactLabel.setFont(mainFont);
        contactLabel.setBounds(10, 230, 100, 30);
        container.add(contactLabel);

        contactField = new JTextField();
        contactField.setFont(mainFont);
        contactField.setBounds(120, 235, 255, 20);
        container.add(contactField);

        //Submit Button
        submitButton = new JButton("Register");
        submitButton.setFont(mainFont);
        submitButton.setBounds(10, 270, 100, 25);
        submitButton.setFocusable(false); 
        submitButton.addActionListener(this);
        container.add(submitButton);
        
        //Clear Button
        clearButton = new JButton("Clear");
        clearButton.setFont(mainFont);
        clearButton.setBounds(141, 270, 100, 25);
        clearButton.setFocusable(false); 
        clearButton.addActionListener(this);
        container.add(clearButton);

        //Exit Button
        exitButton = new JButton("Exit");
        exitButton.setFont(mainFont);
        exitButton.setBounds(273, 270, 100, 25);
        exitButton.setFocusable(false); 
        exitButton.addActionListener(this);
        container.add(exitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) { //User information submission 
            String name = nameField.getText();
            String course = (String) courseComboBox.getSelectedItem();  
            String year = (String) yearComboBox.getSelectedItem();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String address = addressField.getText();
            String email = emailField.getText();
            String contact = contactField.getText();
            
            /**
             * This part of the code displays an error message when there is an empty filled.
             */
            
            if (name.isEmpty() || course == "[Select Course]" || year == null || address.isEmpty() || email.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else { //Pop-up window -- register user information
                String userInfo = "Name: " + name + "\n"  
                        + "Course: " + course + "\n"
                        + "Year: " + year + "\n"
                        + "Gender: " + gender + "\n"
                        + "Address: " + address + "\n"
                        + "Email: " + email + "\n"
                        + "Contact: " + contact;

                JOptionPane.showMessageDialog(this, userInfo, "User Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == clearButton) { //Clearing inputs
            nameField.setText("");
            courseComboBox.setSelectedIndex(0);  
            yearComboBox.setSelectedIndex(0);
            addressField.setText("");
            emailField.setText("");
            contactField.setText("");
            genderGroup.clearSelection();
        } else if (e.getSource() == exitButton) {//Exit
            System.exit(0); 
        }
    }

    public static void main(String[] args) {
        try { //Look and Feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        new RegistrationForm();
    }
}
