/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameApp;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pamela
 */
public class StupidAssMove extends RuntimeException
    {
         public StupidAssMove(String event)
         {
             JFrame frame = new JFrame("Warning");
             JOptionPane.showMessageDialog(frame, "Did you really collide with something? What a fool -_-");
         }
}
    
