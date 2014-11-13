/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player; 


/**
 *
 * @author User
 */
public class SimulaçãoMp3 {

    /**
     * @param args the command line arguments
     */
    
    String path;
    InputStream FIS;
    BufferedInputStream BIS;
    public Player player;
    
    
    
    
    public void close(){
        if(player != null){
            player.close();
        }
    }    
    
  
        public void Play(String path){  
        try{
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            
        }
        catch(FileNotFoundException | JavaLayerException e){
        }   
    new Thread()
    {
       @Override
       public void run(){
       try{
        player.play();
    }
       catch(JavaLayerException ex){}
    }
        
}.start();
            }

}



 