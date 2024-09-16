import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonGui2 extends JFrame {
    // Input fields for Person 1
    private JTextField nameField1 = new JTextField(10);
    private JTextField ageField1 = new JTextField(10);

    // Input fields for Person 2
    private JTextField nameField2 = new JTextField(10);
    private JTextField ageField2 = new JTextField(10);

    // Output field (using JTextArea instead of JLabel)
    private JTextArea outputArea = new JTextArea(5, 30);

    public PersonGui2() {
        // Setup the frame
        setTitle("Person Comparison");
        setSize(500, 400); // Increased size to fit larger output
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Add input fields for Person 1
        panel.add(new JLabel("Person 1 Name:"));
        panel.add(nameField1);
        panel.add(new JLabel("Person 1 Age:"));
        panel.add(ageField1);

        // Add input fields for Person 2
        panel.add(new JLabel("Person 2 Name:"));
        panel.add(nameField2);
        panel.add(new JLabel("Person 2 Age:"));
        panel.add(ageField2);

        // Make the outputArea non-editable and wrap text
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        // Add a scroll pane for the JTextArea in case of long output
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add buttons for comparisons
        JButton sameNameButton = new JButton("Same Name?");
        JButton sameAgeButton = new JButton("Same Age?");
        JButton olderButton = new JButton("Is Person 1 Older?");
        JButton youngerButton = new JButton("Is Person 1 Younger?");
        
        // Create a new panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sameNameButton);
        buttonPanel.add(sameAgeButton);
        buttonPanel.add(olderButton);
        buttonPanel.add(youngerButton);

        // Add everything to the frame
        add(panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH); // Adding scrollable output area

        // Button actions
        sameNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                compareNames();
            }
        });

        sameAgeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                compareAges();
            }
        });

        olderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkOlder();
            }
        });

        youngerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkYounger();
            }
        });
    }

    // Get Person 1 and Person 2 details
    private Person getPerson1() {
        String name = nameField1.getText();
        int age = Integer.parseInt(ageField1.getText());
        return new Person(name, age);
    }

    private Person getPerson2() {
        String name = nameField2.getText();
        int age = Integer.parseInt(ageField2.getText());
        return new Person(name, age);
    }

    // Comparison methods
    private void compareNames() {
        Person person1 = getPerson1();
        Person person2 = getPerson2();
        if (person1.isEqualsName(person2)) {
            outputArea.setText("Both persons have the same name.");
        } else {
            outputArea.setText("Persons have different names.");
        }
    }

    private void compareAges() {
        Person person1 = getPerson1();
        Person person2 = getPerson2();
        if (person1.isEqualsAge(person2)) {
            outputArea.setText("Both persons are the same age.");
        } else {
            outputArea.setText("Persons are of different ages.");
        }
    }

    private void checkOlder() {
        Person person1 = getPerson1();
        Person person2 = getPerson2();
        if (person1.isOlder(person2)) {
            outputArea.setText("Person 1 is older than Person 2.");
        } else {
            outputArea.setText("Person 1 is not older than Person 2.");
        }
    }

    private void checkYounger() {
        Person person1 = getPerson1();
        Person person2 = getPerson2();
        if (person1.isYounger(person2)) {
            outputArea.setText("Person 1 is younger than Person 2.");
        } else {
            outputArea.setText("Person 1 is not younger than Person 2.");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        PersonGui2 frame = new PersonGui2();
        frame.setVisible(true);
    }
}
