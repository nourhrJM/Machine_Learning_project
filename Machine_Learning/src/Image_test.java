import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image_test {

    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\nour\\workspace\\Machine_Learning\\4.png"));
        } catch (IOException e) {

        }
        int height = img.getHeight();
        int width = img.getWidth();

        int amountPixel = 0;
        int amountBlackPixel = 0;

        int rgb;
        int red;
        int green;
        int blue;

        double percentPixel = 0;

        System.out.println(height  + "  " +  width + " " + img.getRGB(30, 30));

        for (int h = 1; h<height; h++)
        {
            for (int w = 1; w<width; w++)
            {
                amountPixel++;

                rgb = img.getRGB(w, h);
                red = (rgb >> 16 ) & 0x000000FF;
                green = (rgb >> 8 ) & 0x000000FF;
                blue = (rgb) & 0x000000FF;

                if (red == 0 && green == 0 && blue == 0)
                {
                    int pix=img.getRGB(h, w);
                    System.out.print(1);
                	amountBlackPixel ++;
                }else
                	System.out.print(0);
            }
            System.out.println("\n");
        }
        percentPixel = (double)amountBlackPixel / (double)amountPixel;

        System.out.println("amount pixel: "+amountPixel);
        System.out.println("amount black pixel: "+amountBlackPixel);
        System.out.println("amount pixel black percent: "+percentPixel);
    }
}