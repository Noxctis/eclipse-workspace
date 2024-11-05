import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SquareGUI represents a graphical user interface to create and display properties of a square.
 */
public class SquareGUI extends JFrame {
    private JTextField centerXField;
    private JTextField centerYField;
    private JTextField colorField;
    private JTextField sideLengthField;
    private JLabel areaLabel;
    private JLabel perimeterLabel;
    private JPanel drawPanel;

    /**
     * Constructor to set up the GUI components.
     */
    public SquareGUI() {
        setTitle("Square Properties GUI");
        setLayout(new BorderLayout());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Square Properties"));

        centerXField = new JTextField();
        centerYField = new JTextField();
        colorField = new JTextField();
        sideLengthField = new JTextField();

        inputPanel.add(new JLabel("Center X:"));
        inputPanel.add(centerXField);
        inputPanel.add(new JLabel("Center Y:"));
        inputPanel.add(centerYField);
        inputPanel.add(new JLabel("Color:"));
        inputPanel.add(colorField);
        inputPanel.add(new JLabel("Side Length:"));
        inputPanel.add(sideLengthField);

        JButton calculateButton = new JButton("Calculate & Draw");
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        // Output panel for area and perimeter
        JPanel outputPanel = new JPanel(new GridLayout(2, 1));
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));

        areaLabel = new JLabel("Area: ");
        perimeterLabel = new JLabel("Perimeter: ");
        outputPanel.add(areaLabel);
        outputPanel.add(perimeterLabel);

        add(outputPanel, BorderLayout.CENTER);

        // Panel to draw the square
        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSquare(g);
            }
        };
        drawPanel.setPreferredSize(new Dimension(200, 200));
        drawPanel.setBackground(Color.WHITE);
        add(drawPanel, BorderLayout.SOUTH);

        // Action listener for Calculate & Draw button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAndDrawSquare();
            }
        });

        setVisible(true);
    }

    /**
     * Reads input, calculates area and perimeter, and triggers the draw.
     */
    private void calculateAndDrawSquare() {
        try {
            int centerX = Integer.parseInt(centerXField.getText());
            int centerY = Integer.parseInt(centerYField.getText());
            String color = colorField.getText();
            int sideLength = Integer.parseInt(sideLengthField.getText());

            Square square = new Square(centerX, centerY, color, sideLength);
            areaLabel.setText("Area: " + square.calculateArea());
            perimeterLabel.setText("Perimeter: " + square.calculatePerimeter());

            // Repaint to trigger drawing the square
            drawPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for center coordinates and side length.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Draws a representation of the square on the drawPanel based on current properties.
     * @param g Graphics object used to draw the square.
     */
    private void drawSquare(Graphics g) {
        try {
            int sideLength = Integer.parseInt(sideLengthField.getText());
            int centerX = Integer.parseInt(centerXField.getText());
            int centerY = Integer.parseInt(centerYField.getText());

            // Calculate top-left corner to center the square around the specified coordinates
            int x = centerX - sideLength / 2;
            int y = centerY - sideLength / 2;

            // Set color if specified; default to black
            Color squareColor = Color.BLACK;
            try {
                squareColor = (Color) Color.class.getField(colorField.getText().toLowerCase()).get(null);
            } catch (Exception e) {
                // Default to black if color is invalid
            }

            g.setColor(squareColor);
            g.drawRect(x, y, sideLength, sideLength);
        } catch (NumberFormatException e) {
            // Ignore invalid values during drawing
        }
    }

    /**
     * Main method to run the SquareGUI application.
     */
    public static void main(String[] args) {
        new SquareGUI();
    }
}
