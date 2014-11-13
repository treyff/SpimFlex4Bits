package imagens.fundos;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import static javafx.scene.input.DataFormat.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagemPrincipal implements Border{
    public BufferedImage fundo;
 
    public ImagemPrincipal(){
        try {
            URL imagePath = new URL(getClass().getResource("/imagens.fundos/fundo.jpg").toString()); // Felipe aqui aonde esta Fundo.png fica a imagem...eu criei uma pasta chamada Imagens e coloquei tudo dentro do projeto 
            fundo = ImageIO.read(imagePath);// A imagem que eu coloquei tem 1600x800 porque a tela ja esta abrindo assim, faz o teste ai e depois me fala.
        } catch (IOException ex) {            
        }
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(fundo, (x + (width - fundo.getWidth())/2),(y + (height - fundo.getHeight())/2), null);
    }
 
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }
 
    public boolean isBorderOpaque() {
        return false;
    }

    //@Override
   // public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   //}

   // @Override
   // public Insets getBorderInsets(Component c) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
    }


