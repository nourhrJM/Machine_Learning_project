import java.awt.Color;
   import java.awt.Graphics2D;
   import java.awt.image.BufferedImage;
   import java.awt.image.*;
   import java.io.File;
   import java.io.IOException;
   import javax.imageio.ImageIO;
 
 
    public class Reading_Image {
    
       public Reading_Image() {
         try {
            BufferedImage img = new BufferedImage(72, 72, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D)img.getGraphics();
            g2d.setColor(Color.GRAY);
            g2d.fillRect(0, 0, 72, 72);
          
            g2d.dispose();
                 
            ImageIO.write(img, "png", new File("pouet.png"));
         }
             catch(IOException e){System.out.println(e);}
       
      }
    
     
       public static void main(String[] args) {
         new Reading_Image();
      }
    
     
   }