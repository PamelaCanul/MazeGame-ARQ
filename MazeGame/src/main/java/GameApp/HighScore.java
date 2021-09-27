package GameApp;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pamela
 */
public class HighScore extends JDialog implements ActionListener {
    private JLabel mainLabel;
    public HighScore(){
        super();
    }
    public void highScore(String name, int minutes, int seconds, int level) throws FileNotFoundException{
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
        public void showHighScores(){
            
            Container cp = getContentPane();
            JButton ok = new JButton("OK");
            ok.setActionCommand("OK");
            ok.addActionListener(this);
            int lineNum=0;
            cp.add(ok,BorderLayout.SOUTH);
            try{
                String line = "";
                String[] myScoreArray = new String[100];
                for(int i=0; i<myScoreArray.length;i++)
                    myScoreArray[i]=" ";
                    String line1="";
                BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("scores.txt")));//read in the scores data
                int recordsCount=0;
                while((line = br1.readLine()) != null) 
                {
                    line = br1.readLine();
                    if(line!="")
                    {
                        recordsCount+=1;
                        int tempPOS = line.indexOf("*");//use the star to indicate the next charator is going to be the maze level which we will sort by.
                        String pos=line.substring(tempPOS+1);
                        int index = Integer.parseInt(pos);
                        if(myScoreArray[index] == " ")
                            myScoreArray[index]=line;//add in the score to the array.
                        else
                        {
                            for(int i=0; i<myScoreArray.length;i++){
                                if(index+i<myScoreArray.length){//prevent array out of bounds errors.
                                   if(myScoreArray[index+i].equals(" ")){
                                       myScoreArray[index+1]=line;//add in a score to the next available area of the array
                                   }
                                }//end first if
                            }//end for loop
                        }//end else
                            JPanel scorePanel = new JPanel();
                             scorePanel.setLayout(new GridLayout(recordsCount,recordsCount));
                                 for(int i=0; i<myScoreArray.length;i++){
                                     if(myScoreArray[i]!=" "){
                                        mainLabel =new JLabel(myScoreArray[i], JLabel.LEFT);//display the score on the screen
                                        scorePanel.add(mainLabel);
                                     }
                                 }//end for loop
                                cp.add(scorePanel); 
                           }//end very first if
                     }//end first while loop            
                }//end try
                catch(IOException ex){
                    JFrame frame = new JFrame("Alert");
                    JOptionPane.showMessageDialog(frame, "Problem with scores.txt file.  Cant load high Scores");
                }//end catch
            pack();
            setVisible (true); 
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

