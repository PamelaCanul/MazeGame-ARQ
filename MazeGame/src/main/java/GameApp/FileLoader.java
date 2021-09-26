package GameApp;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pamela
 */
public class FileLoader {
    private int exitXCord=0;
    private int exitYCord=0;;
    private String[][] MatrixGame;
    private int column;
    private int row;
    
    public void fileLoader (String fileName) throws FileNotFoundException{
        try{
            //Leemos el archivo
            BufferedReader file = new BufferedReader(new FileReader (fileName));
            String letter; 
            int lineNum = 0;
            while ((letter = file.readLine()) != null){
                //Pasamos el numeor de lineas al metodo de MatrixLoader
                MatrixLoader(letter,lineNum); 
                //El numero de lineas lo vamos a pasar mas tarde en la clase
                lineNum++;
            }
        }catch (IOException e){
            
        }
    }

    private void MatrixLoader(String fileTextLine, int lineNum) throws gameFileError {
        int sumLine = 0; 
        char text; 
        if(lineNum == 0){
            //Creamos la matriz del nivel del juego basandonos en la primera linea del archivo maze
            for(int i = 0; i<fileTextLine.length(); i++){
                //Encontramos la primera area blanca en la pimera linea
                if(fileTextLine.charAt(i) == ' '){
                    //Cuantos espacion en blanco hay, para el espacio de la matriz
                    sumLine+=1; 
                }
                //Analizamos los posibles espacios en balnco que puede tener el tamaño de la matriz del archivo
                int spaceLocation = fileTextLine.indexOf(" "); 
                String cFile = fileTextLine.substring(0, spaceLocation);
                String rFile = fileTextLine.substring(spaceLocation+sumLine, fileTextLine.length());
                int columnFile = Integer.parseInt(cFile);
                int rowFile = Integer.parseInt(rFile); 
                //Creamos una nueva matriz basandonos en el tamaño que tenia el archvi
                MatrixGame = new String[rowFile][columnFile]; 
            }
        } else {
            char textVar = ' ';
            //Las lineas que se van a leer aqui no incluye a la primera linea del archivo maze
            for(int i = 0; i<fileTextLine.length(); i++){
                //Tomamos los caracteres individuales de cada String
                textVar = fileTextLine.charAt(i); 
                //Cambiamos el . por N, esto es para no tener ningun problema inecesario en la lectura del archivo
                if(textVar == '.'){
                    textVar='N';
                }
                String textVariable = "" + textVar; 
                //Guardamos la posicion de salida para poder usarlo mas tarde
                if (textVar == 'E'){
                    int exitXcoordinate = lineNum-1; 
                    int exitYCoordinate = i; 
                    //Cambiamos la salida por un muro
                    textVariable = "" + textVar;
                }
                
                //Cargamos la matriz
                MatrixGame[lineNum-1][i] = textVariable; 
            }
        }
    }
    
    public String[][] getMatrixGame(){
        //Debemos resetear las variables desde cero para el siguiente nivel        
        int exitCount = 0; 
        int x_axis=0; 
        int y_axis=0;
        //Antes de retornar la matriz se revisa si hay algun error
        int playerCount = 0; 
        
        for(int i = 0; i<MatrixGame.length; i++){
            for ( int j = 0; j<MatrixGame[i].length; j++){
                if(MatrixGame[i][j].equals("P")){
                    playerCount+=1; 
                }else if(MatrixGame[i][j].equals("E")){
                    exitCount +=1; 
                    x_axis = i; 
                    y_axis = j; 
                }
                
                System.out.println(playerCount + "playerCount");
                System.out.println(exitCount + "playerCount"); 
            }
        }
        if (playerCount > 1 || exitCount > 1){
            throw new gameFileError();
        } else {
            MatrixGame[x_axis][y_axis] = "W"; 
        }
        
        return MatrixGame; 
    }
    
    public int getMatrixSizeColumn (){
        return column; 
    }
    
    public int getMatrixSizeRow(){
        return row; 
    }
    
    public int ExitXCord(){
        return exitXCord; 
    }
    
    public int ExitYCord(){
        return exitYCord;
    }
    
    public int dimondCount(){
      int totalDimonds = 0; 
      for(int i=0; i < MatrixGame.length; i++){
          for (int j = 0; j < MatrixGame[i].length; j++){
              if (MatrixGame[i][j].equals("D") || MatrixGame[i][j].equals("H")){
                  totalDimonds +=1; 
              }
            }
        }
      //Retonamos el numero de diamantes en total
        return totalDimonds;
    }
    
    public class gameFileError extends RuntimeException{
       public gameFileError(){
           //JFrame
       } 
    }
}