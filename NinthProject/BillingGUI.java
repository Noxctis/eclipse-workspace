import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillingGUI extends JFrame {
    private JTextField doctorNameField;
    private JTextField specialtyField;
    private JTextField visitFeeField;
    private JTextField patientNameField;
    private JTextField patientIDField;
    private JTextArea displayArea;
    private JLabel totalIncomeLabel;

    private ArrayList<Billing> billingRecords = new ArrayList<>();
    private double totalIncome = 0.0;

    public BillingGUI() {
        setTitle("Patient-Billing System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Doctor and Patient Information"));

        doctorNameField = new JTextField();
        specialtyField = new JTextField();
        visitFeeField = new JTextField();
        patientNameField = new JTextField();
        patientIDField = new JTextField();

        inputPanel.add(new JLabel("Doctor Name:"));
        inputPanel.add(doctorNameField);
        inputPanel.add(new JLabel("Specialty:"));
        inputPanel.add(specialtyField);
        inputPanel.add(new JLabel("Visit Fee:"));
        inputPanel.add(visitFeeField);
        inputPanel.add(new JLabel("Patient Name:"));
        inputPanel.add(patientNameField);
        inputPanel.add(new JLabel("Patient ID:"));
        inputPanel.add(patientIDField);

        // Create buttons
        JButton addBillingButton = new JButton("Add Billing Record");
        JButton calculateIncomeButton = new JButton("Calculate Total Income");
        
        // Add action listener for adding a billing record
        addBillingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBillingRecord();
            }
        });

        // Add action listener for calculating total income
        calculateIncomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalIncome();
            }
        });

        inputPanel.add(addBillingButton);
        inputPanel.add(calculateIncomeButton);

        // Display area for billing records and total income
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createTitledBorder("Billing Records"));

        totalIncomeLabel = new JLabel("Total Income: $0.0");
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        displayPanel.add(totalIncomeLabel, BorderLayout.SOUTH);

        // Add panels to the main frame
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    /**
     * Adds a new billing record based on the current input fields.
     */
    private void addBillingRecord() {
        try {
            String doctorName = doctorNameField.getText();
            String specialty = specialtyField.getText();
            double visitFee = Double.parseDouble(visitFeeField.getText());
            String patientName = patientNameField.getText();
            String patientID = patientIDField.getText();

            // Create Doctor and Patient objects
            Doctor doctor = new Doctor(doctorName, specialty, visitFee);
            Patient patient = new Patient(patientName, patientID);

            // Create a Billing record and add it to the list
            Billing billing = new Billing(patient, doctor);
            billingRecords.add(billing);

            // Display the billing record in the display area
            displayArea.append("Doctor: " + doctorName + " (" + specialty + ")\n");
            displayArea.append("Patient: " + patientName + " (ID: " + patientID + ")\n");
            displayArea.append("Visit Fee: $" + visitFee + "\n");
            displayArea.append("-----------\n");

            // Clear input fields
            clearInputFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for the visit fee.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calculates the total income based on the billing records and updates the display.
     */
    private void calculateTotalIncome() {
        totalIncome = 0.0;
        for (Billing billing : billingRecords) {
            totalIncome += billing.getBillingAmount();
        }
        totalIncomeLabel.setText("Total Income: $" + totalIncome);
    }

    /**
     * Clears all input fields.
     */
    private void clearInputFields() {
        doctorNameField.setText("");
        specialtyField.setText("");
        visitFeeField.setText("");
        patientNameField.setText("");
        patientIDField.setText("");
    }

    public static void main(String[] args) {
        new BillingGUI();
    }
}
