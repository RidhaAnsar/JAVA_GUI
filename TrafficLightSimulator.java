import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    private JRadioButton redButton, yellowButton, greenButton;
    private JPanel lightPanel;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 300);

        // Create radio buttons
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Group the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(redButton);
        buttonGroup.add(yellowButton);
        buttonGroup.add(greenButton);

        // Add action listeners
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Create light panel
        lightPanel = new JPanel();
        lightPanel.setBackground(Color.gray);
        lightPanel.setPreferredSize(new Dimension(100, 100));

        // Add components to the frame
        setLayout(new BorderLayout());
        add(redButton, BorderLayout.NORTH);
        add(yellowButton, BorderLayout.CENTER);
        add(greenButton, BorderLayout.SOUTH);
        add(lightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            lightPanel.setBackground(Color.RED);
        } else if (e.getSource() == yellowButton) {
            lightPanel.setBackground(Color.YELLOW);
        } else if (e.getSource() == greenButton) {
            lightPanel.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new TrafficLightSimulator();
    }
}
