package GameApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pamela
 */
public class TimeOfGame {
    int minutes = 0;
    int seconds = 0; 
    
    public void calcTime (int totalDimonds, int xSize, int ySize){
        //El tiempo que el jugador tiene para pasar el nivel, depende de el total de diamantes y el tamaño del mapa
        if(xSize/ySize < 1){
            minutes += (ySize/xSize) * 1 + 1; 
        }else{
            minutes += (ySize/xSize) * 1 + 1;
        } if (totalDimonds > 6 && totalDimonds * .10 +seconds <= 60){
            minutes += (ySize/xSize) * 1 + 1;
        } else {
            minutes += 1; 
        }if (minutes == 0){
            minutes = 2; 
        }
    }
    
    public int getMinutes(){
        return minutes; 
    }
    
    public int getSeconds() {
        return seconds; 
    }
    
}
