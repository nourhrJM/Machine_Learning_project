import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GetSetPixels{
  public static void main(String args[])throws IOException{
    BufferedImage img = null;
    File f = null;

    //read image
    try{
      f = new File("C:\\Users\\nour\\workspace\\Machine_Learning\\3.png");
      System.out.println("blam blam");    
      img = ImageIO.read(f);
      int Height = img.getHeight();
      int width =img.getWidth();
      for (int i=0; i<Height;i++){
    	  for (int j=0; j<width;j++){
    		  
    		  int  p = img.getRGB(i,j);
    		  System.out.print(p);
    	  }
    	  System.out.println("\n");
    	  
      }
    	
      
    }catch(IOException e){
      System.out.println(e);
    }

    // some code goes here...

  }//main() ends here
}//class ends here