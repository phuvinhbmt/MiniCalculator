/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minicalculator;

import javax.swing.*;

/**
 *
 * @author Vinh
 */
public class MiniCalculator {
    public static void main(String[] args) {
        Calculator frame = new Calculator();        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(350, 280);
    }

}
