package GameApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audny Correa
 */
public class startingMenu extends javax.swing.JFrame {
    private String playerName;
    private FileLoader fl = new FileLoader();
    private TheArchitect theArc = new TheArchitect();
    private JPanel newPanel;
    private JPanel progBarPanel;
    private String[][] scrapMatrix; 
    private TimeOfGame timeCalc;
    private int timeLeft;
    private int ix;
    private int jx;
    private  Timer timely;
    private Container cp;
    private int catFileName=01;
    private  JProgressBar progressBar;
    private HighScore hs;
    private TimeOfPlayer tk;
    private int levelNum=1;
    private JLabel[][] labelMatrix;
    private mazeObject mo;
    private JLabel shagLabel;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    
    /**
     * Creates new form startingMenu
     */
    public startingMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("New Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Open Maze File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("High Score");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Maze, a game of wondering ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane optionPane = new JOptionPane();
        playerName=optionPane.showInputDialog("Please Enter your Earth Name");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
            int returnVal = chooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) 
            {
                try {
                    fl.fileLoader("level1.maz");//load the file we need
                    theArc.setExit(fl.ExitXCord(),fl.ExitYCord());
                    loadMatrixGui("newLoad"); 
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(startingMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        HighScore scores = new HighScore();
        scores.showHighScores();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(startingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(startingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(startingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(startingMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new startingMenu().setVisible(true);
            }
        });
    }
        Action updateCursorAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e)throws SlowAssPlayer //this inner class generates an exeption if the player takes to long to finish a level 
    {
        ix-=1;
        jx+=1;
        if(ix<0)
        {
            ix=60;
            timeLeft-=1;
        }
    if(timeLeft==0 && ix==0)
    {
        timely.stop();
        JLabel yousuckLabel = new JLabel("",new ImageIcon("yousuck.jpg"),JLabel.LEFT);
        cp.add(yousuckLabel);
        remove(newPanel);
        remove(progBarPanel);
        pack();
        setVisible (true);
        timely.stop();
        catFileName-=01;
    if(catFileName<01)
        try {
            throw new SlowAssPlayer("Slow ass took to long.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(startingMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    else
        loadMatrixGui("newLoad");
    }//end first if
        progressBar.setValue(jx);
        progressBar.setString(timeLeft+":"+ix);
    }//end actionPerformed
    };//end class

    private class mazeObject extends JLabel {
    
        private JLabel imageLabel;
        public mazeObject(String fileName)
        {
            fileName+=".png";
            JLabel fancyLabel;
            fancyLabel = new JLabel("",new ImageIcon(fileName),JLabel.LEFT);
            newPanel.add(fancyLabel);
        }
        //end inner class
    }
        
        private class SlowAssPlayer extends RuntimeException
    {
        public SlowAssPlayer(String event) throws FileNotFoundException
        {
            //the game is over, here we must tell our high score method to recond the details.
            hs.highScore(playerName,tk.getMinutes(),tk.getSeconds(),levelNum);
            JFrame frame = new JFrame("Warning");
            JOptionPane.showMessageDialog(frame, "You Stupid Ass, Did you eat to much for dinner?  Move Faster!");//the entire game has ended.
        }
    }//end class
        
         public void loadMatrixGui(String event){
        newPanel = new JPanel();
        if (event == "newLoad")
         {       
             remove(newPanel);//remove the previous level's game from the screen
             if(progBarPanel !=null)//remove the progress bar from the gui as long as its already been created.
             remove(progBarPanel);
             String[][] temp = fl.getMatrixGame();
             scrapMatrix = new String[fl.getMatrixSizeRow()][fl.getMatrixSizeColumn()];   
             for (int i = 0; i < scrapMatrix.length; i++){
                for (int j = 0; j < scrapMatrix[i].length; j++){
                    scrapMatrix[i][j]= temp[i][j];//create a new matrix so we dont have a refrence to another objects matrix!
              }}//end double for loop
             timeCalc = new TimeOfGame();//create the time calculator used to determine how much time each level is given.
             timeCalc.calcTime(fl.dimondCount(),fl.getMatrixSizeRow(),fl.getMatrixSizeColumn());//let time calculator know the parameters of the game 
             timeLeft=timeCalc.getMinutes();//get the minutes allowed for the level
             ix=timeCalc.getSeconds();//get the seconds allowed for the level;
             jx=0;//reset the variable used for keeping time to zero since its a new level
             timely = new Timer(1000,updateCursorAction);//create a timer to update the progress bar
             timely.start();//start the timer
             progBarPanel = new JPanel();//panel for progress bar
             progressBar = new JProgressBar(0, timeCalc.getMinutes()*100);//minutes returns a single digit, we have to multiply it for Bar.
             progressBar.setStringPainted(true);
             progBarPanel.add(progressBar);
             cp.add(progBarPanel,BorderLayout.NORTH);
             newPanel = new JPanel();
             newPanel.setLayout(new GridLayout(fl.getMatrixSizeRow(),fl.getMatrixSizeColumn()));//set our panel for the game to the size of the matrix      
             labelMatrix=new JLabel[fl.getMatrixSizeRow()][fl.getMatrixSizeColumn()];
             newPanel.addKeyListener( new MyKeyHandler() );
        }//end if
        else if(event =="updateLoad")//every time the player moves the gui must be updated.
        {
            scrapMatrix = theArc.getUpdatedMatrix();//get the new matrix to be displayed from the architect
            remove(newPanel);//remove the old game
            newPanel = new JPanel();
            newPanel.setLayout(new GridLayout(fl.getMatrixSizeRow(),fl.getMatrixSizeColumn()));
            newPanel.addKeyListener( new MyKeyHandler() );
            newPanel.grabFocus();        
        }
          for (int i = 0; i < labelMatrix.length; i++){
              for (int j = 0; j < labelMatrix[i].length; j++){
                  mo=new mazeObject(scrapMatrix[i][j]);//add our maze images into the gui
                  labelMatrix[i][j]= mo;
              }}//end double for loop
         cp.add(newPanel);
         remove(shagLabel);//remove the constructors initial background
         System.gc();//force java to clean up memory use.
         pack();
         setVisible (true);
         newPanel.grabFocus();  
     }
         
    private class MyKeyHandler extends KeyAdapter //captures arrow keys movement
    {
        public void keyPressed (KeyEvent theEvent)
       {         
           switch (theEvent.getKeyCode())
           {
               case KeyEvent.VK_UP:
               {
                 theArc.playerMove(-1,0,scrapMatrix,fl.dimondCount());//let the Architect know we moved, along with the current matrix
                 loadMatrixGui("updateLoad");//reload the gui to show the move
                 if (theArc.getLevel()==true)
                 {
                     try {
                         nextLevelLoad();//if the player hit an exit door, load the next level
                     } catch (FileNotFoundException ex) {
                         Logger.getLogger(startingMenu.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 break;
              }
              case KeyEvent.VK_DOWN:
              {
                 theArc.playerMove(1,0,scrapMatrix,fl.dimondCount());//see above
                 loadMatrixGui("updateLoad");//see above
                 if (theArc.getLevel()==true)//see above
                 {
                     try {
                         nextLevelLoad();//see above
                     } catch (FileNotFoundException ex) {
                         Logger.getLogger(startingMenu.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 break;
             }
             case KeyEvent.VK_LEFT:
             {
                theArc.playerMove(0,-1,scrapMatrix,fl.dimondCount());//see above
                loadMatrixGui("updateLoad");//see above
                 if (theArc.getLevel()==true)//see above
                 {
                    try {
                        nextLevelLoad();//see above
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(startingMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                break;
             }
             case KeyEvent.VK_RIGHT:
             { 
                theArc.playerMove(0,1,scrapMatrix,fl.dimondCount()); //see above
                loadMatrixGui("updateLoad");//see above
                 if (theArc.getLevel()==true)
                 {
                    try {
                        nextLevelLoad();//see above
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(startingMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                break;   
             }
           }//end switch
           JLabel mainLabel=new JLabel("Total Dimonds Left to Collect"+theArc.getDimondsLeft()+"", JLabel.CENTER);//show how many dimonds are left to collect on the gui!
           JPanel dimondsPanel = new JPanel();
           dimondsPanel.add(mainLabel);
           cp.add(dimondsPanel,BorderLayout.SOUTH);
       }//end method
        
        public void nextLevelLoad() throws FileNotFoundException
    {
        levelNum+=1;
        tk.timeOfPlayer(timeLeft,ix);//The TimeKeeper object keeps a running tab of the total time the player has used.(for high score)
        timely.stop();//dont count while we are loading the next level.
        theArc = new TheArchitect();//flush everything from TheArchitect so we dont get goffee results
        catFileName+=01;//the next file to be loaded (number)
        String fileName="level"+catFileName+".maz";
        System.gc();
        fl.fileLoader(fileName);//load the file we need
        scrapMatrix=fl.getMatrixGame();//get the new matrix from the fileloader for the next level.
        theArc.setExit(fl.ExitXCord(),fl.ExitYCord());
        loadMatrixGui("newLoad");         
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
   }
}
