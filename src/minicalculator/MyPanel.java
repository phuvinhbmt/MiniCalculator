package minicalculator;

import java.awt.GridLayout;
import javax.swing.*;


/**
 *
 * @author Vinh
 */
public class MyPanel extends JPanel{
    public MyPanel(int row, int col) { 
        this.setLayout( new GridLayout(row, col));
    }
    public void addButtons( JButton[] numberButtons) {
        for(int i=0; i< numberButtons.length-1; i++) {
            numberButtons[i] = new JButton(""+ i);
            add(numberButtons[i]);
        }        
        numberButtons[numberButtons.length - 1] = new JButton(".");
        add( numberButtons[numberButtons.length-1]);
    }
    public void addButtons( JButton[] signButtons, String[] signSymbol) {
        for(int i=0; i< signButtons.length; i++) {
            signButtons[i] = new JButton(""+ signSymbol[i]);
            add(signButtons[i]);
        }
    }
}
