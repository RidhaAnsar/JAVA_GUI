import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private JButton[] digitButtons;
    private JButton[] operatorButtons;
    private JButton clearButton;
    private JButton equalsButton;

    private String currentInput = "";
    private double result = 0;
    private char lastOperator = ' ';

    public Calculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        digitButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
            buttonPanel.add(digitButtons[i]);
        }

        operatorButtons = new JButton[5];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        operatorButtons[4] = new JButton("%");

        for (JButton button : operatorButtons) {
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            currentInput += command;
            displayField.setText(currentInput);
        } else if ("+-*/%".contains(command)) {
            if (!currentInput.isEmpty()) {
                if (lastOperator != ' ') {
                    calculate();
                } else {
                    result = Double.parseDouble(currentInput);
                }
                lastOperator = command.charAt(0);
                currentInput = "";
            }
        } else if ("C".equals(command)) {
            currentInput = "";
            result = 0;
            lastOperator = ' ';
            displayField.setText("");
        } else if ("=".equals(command)) {
            calculate();
            lastOperator = ' ';
            currentInput = Double.toString(result);
            displayField.setText(currentInput);
        }
    }

    private void calculate() {
        try {
            double currentNumber = Double.parseDouble(currentInput);
            switch (lastOperator) {
                case '+':
                    result += currentNumber;
                    break;
                case '-':
                    result -= currentNumber;
                    break;
                case '*':
                    result *= currentNumber;
                    break;
                case '/':
                    if (currentNumber == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    result /= currentNumber;
                    break;
                case '%':
                    result %= currentNumber;
                    break;
            }
        } catch (NumberFormatException e) {
            displayField.setText("Invalid input");
        } catch (ArithmeticException e) {
            displayField.setText("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
