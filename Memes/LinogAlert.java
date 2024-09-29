import javax.swing.JOptionPane;

public class LinogAlert {

    public static void main(String[] args) {
        // Display the Yes/No dialog
        int response = JOptionPane.showConfirmDialog(null, "IS THERE LINOG?", "Linog Alert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Check the user's response
        if (response == JOptionPane.YES_OPTION) {
            // If "Yes" is selected, display the message "DUCK, COVER"
            JOptionPane.showMessageDialog(null, "DUCK, COVER", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (response == JOptionPane.NO_OPTION) {
            // Optional: You can handle the "No" case here if needed
            // For example, no action or display a different message
            System.out.println("No action taken.");
        }
    }
}
