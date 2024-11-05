import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * The Square class represents a square shape with specified properties, 
 * and includes a GUI for interacting with the square.
 */
public class Square extends DrawableShape {
    private int sideLength;  // Length of the sides of the square

    private JTextField centerXField;
    private JTextField centerYField;
    private JTextField colorField;
    private JTextField sideLengthField;
    private JLabel areaLabel;
    private JLabel perimeterLabel;
    private JPanel drawPanel;

    /**
     * No-argument constructor to create a Square with default values.
     */
    public Square() {
        super(0, 0, "black");
        this.sideLength = 1; // Default side length
    }

    /**
     * Constructor to initialize the Square with center coordinates, color, and side length.
     * @param centerX The X-coordinate of the square's center.
     * @param centerY The Y-coordinate of the square's center.
     * @param color The color of the square.
     * @param sideLength The length of the sides of the square.
     */
    public Square(int centerX, int centerY, String color, int sideLength) {
        super(centerX, centerY, color);
        this.sideLength = sideLength;
    }

    /**
     * Gets the length of the sides of the square.
     * @return The length of the sides of the square.
     */
    public int getSideLength() {
        return sideLength;
    }

    /**
     * Sets the length of the sides of the square.
     * @param sideLength The new length of the sides of the square.
     */
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * Calculates and returns the area of the square.
     * @return The area of the square.
     */
    public int calculateArea() {
        return sideLength * sideLength;
    }

    /**
     * Calculates and returns the perimeter of the square.
     * @return The perimeter of the square.
     */
    public int calculatePerimeter() {
        return 4 * sideLength;
    }

    /**
     * Draws the square using keyboard characters, displaying an outline based on the side length.
     */
    public void draw() {
        System.out.println("Drawing square with color " + color + " at center (" + centerX + ", " + centerY + ")");
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                if (i == 0 || i == sideLength - 1 || j == 0 || j == sideLength - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Launches the GUI for interacting with the square.
     */
    public void launchGUI() {
        JFrame frame = new JFrame("Square Properties GUI");
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Square Properties"));

        centerXField = new JTextField(String.valueOf(centerX));
        centerYField = new JTextField(String.valueOf(centerY));
        colorField = new JTextField(color);
        sideLengthField = new JTextField(String.valueOf(sideLength));

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

        frame.add(inputPanel, BorderLayout.NORTH);

        // Output panel for area and perimeter
        JPanel outputPanel = new JPanel(new GridLayout(2, 1));
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));

        areaLabel = new JLabel("Area: ");
        perimeterLabel = new JLabel("Perimeter: ");
        outputPanel.add(areaLabel);
        outputPanel.add(perimeterLabel);

        frame.add(outputPanel, BorderLayout.CENTER);

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
        frame.add(drawPanel, BorderLayout.SOUTH);

        // Action listener for Calculate & Draw button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAndDrawSquare();
            }
        });

        frame.setVisible(true);
    }

    /**
     * Reads input, calculates area and perimeter, and triggers the draw.
     */
    private void calculateAndDrawSquare() {
        try {
            centerX = Integer.parseInt(centerXField.getText());
            centerY = Integer.parseInt(centerYField.getText());
            color = colorField.getText();
            sideLength = Integer.parseInt(sideLengthField.getText());

            areaLabel.setText("Area: " + calculateArea());
            perimeterLabel.setText("Perimeter: " + calculatePerimeter());

            // Repaint to trigger drawing the square
            drawPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for center coordinates and side length.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Draws a representation of the square on the drawPanel based on current properties.
     * @param g Graphics object used to draw the square.
     */
    private void drawSquare(Graphics g) {
        try {
            // Calculate top-left corner to center the square around the specified coordinates
            int x = centerX - sideLength / 2;
            int y = centerY - sideLength / 2;

            // Set color if specified; default to black
            Color squareColor = Color.BLACK;
            try {
                squareColor = (Color) Color.class.getField(color.toLowerCase()).get(null);
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
     * Main method to launch the GUI application for the Square.
     */
    public static void main(String[] args) {
        Square square = new Square();
        square.launchGUI();
    }
}
