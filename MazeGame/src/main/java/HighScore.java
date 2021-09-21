
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pamela
 */
public class HighScore {
        public void higScore(String name, int minutes, int seconds, int level) throws FileNotFoundException{
        try {
            //Imprimir los highScore en scores.txt
            String outData = "PlayerName: " + name + " Total time: " + minutes + ":" + seconds + " Level Reached: " + level; 
            PrintWriter out = new PrintWriter (new FileOutputStream("scores.txt", true)); 
            out.println("");
            out.println(outData);
            out.close();
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

