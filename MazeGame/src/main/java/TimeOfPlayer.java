/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pamela
 */
public class TimeOfPlayer {
    int minutes = 0;
    int seconds = 0;
    public void timeOfPlayer(int min, int sec){
        //Contador que mide el tiempo que el jugador ha pasado en el nivel
        if (sec + seconds <= 60){
            minutes += min; 
            seconds = sec + seconds;
        } else {
            minutes += min;
            minutes += 1 *((sec + seconds) / 60);
            seconds = (sec + seconds) %60;
        }
    }
    
    public int getMinutes(){
        return minutes;
    }
    
    public int getSeconds(){
        return seconds;
    }
}
