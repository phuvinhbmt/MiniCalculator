package minicalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Class name: Calculator -> CalcFrame, MyPanel -> ComponentPanel
 * 
 */
public class Calculator extends JFrame{
    JTextArea resultText, arithmeticText;
    JButton[] numberButtons, signButtons;
    JPanel arithmeticPanel, resultPanel;
    MyPanel numbersPanel, signsPanel;
    public Calculator() {
        // arithetmetics bar
        super("Simple Calculator");
        setLayout( new FlowLayout());
        arithmeticPanel = new JPanel();
        arithmeticText = new JTextArea(2,28);
        arithmeticText.setEditable(false);
        arithmeticPanel.add(arithmeticText);
        add(arithmeticPanel, BorderLayout.NORTH);
        
        // result bar
        resultPanel = new JPanel();        
        resultText = new JTextArea(4,28);
        resultText.setEditable(false);
        resultText.setFont( new Font("Arial", Font.PLAIN, 14));
        resultPanel.add(resultText);
        add(resultPanel, BorderLayout.NORTH );

        // number buttons
        numberButtons = new JButton[11];
        numbersPanel = new MyPanel(3, 4);
        numbersPanel.addButtons(numberButtons);
        add(numbersPanel, BorderLayout.SOUTH);
        
        // sign buttons
        signsPanel = new MyPanel(3,2);
        signButtons = new JButton[6];
        String[] symbols ={"+", "-", "x", ":", "=", "AC"};
        signsPanel.addButtons(signButtons, symbols);
        add(signsPanel);        
        
        // Register ActionListener // needs to put these inside class MyPanel
        for (JButton numberButton : numberButtons) {
            numberButton.addActionListener(new Handler());
        }        
        for (JButton signButton : signButtons) {
            signButton.addActionListener(new Handler());            
        }
    }    
    String operator = "nothing";
    String numberString = "";
    double result, numberInput ;    
    class Handler implements ActionListener {        
        public double operator(String operator) {
            switch(operator) {
                case "nothing":
                    result = numberInput;
                    //System.out.println("new result(nothing) = "+result);
                    break;
                case "+":
                    result += numberInput;
                    System.out.println("new result(+) = "+result);
                    break;
                case "-":
                    result -= numberInput;
                    System.out.println("new result(-) = "+result);
                    break;
                case "x":
                    result *= numberInput;
                    System.out.println("new result(x) = "+result);
                    break;
                case ":":
                    result /= numberInput;   
                    System.out.println("new result(:) = "+result);
                    break;                              
                case "=":
                    System.out.println("real result = " + result); break;
            }
            return result;
        }
        @Override
        public void actionPerformed(ActionEvent e) {            
            arithmeticText.setText(e.getActionCommand() );     // show in the 1st textarea number or sign button has been clicked
            // check which number button has been clicked
            for (JButton numberButton : numberButtons) {
                if (e.getSource() == (numberButton)) {  
                    numberString += e.getActionCommand();
                    numberInput = Double.parseDouble(numberString);
                    arithmeticText.setText(""+numberInput);
                    System.out.printf("numberString = %s and numberInput = %f\n", numberString, numberInput);
                }
            } 
            for (JButton signButton : signButtons) {
                if (e.getSource() == signButton) {
                    if(e.getActionCommand().equals("AC")) { //when user click AC, all variables are reset to the beginning
                        result = 0;
                        numberString = "";
                        operator = "nothing";
                        System.out.println("this works");
                        resultText.setText(""+ result);
                    }  
                    else {   // when user clicks basic symbols, arithmetics are operated
                        result = operator(operator);         //calculate the result using method operator
                        resultText.setText("" +result);   // show result in the 2nd textarea             
                        operator = e.getActionCommand();
                        System.out.println("operator is " +operator);
                        System.out.println("--------------------");
                        numberString ="";  // reset number string
                    }
                }
            } 
        }        
    }
}
