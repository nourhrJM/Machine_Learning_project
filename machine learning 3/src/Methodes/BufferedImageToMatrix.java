package Methodes;



import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author kaldoran
 */
public class BufferedImageToMatrix {

    private int[][] matrix;
    private int width;
    private int height;
    
    
    //Cette Fonction permet d'afficher l'image en binair 
    public BufferedImageToMatrix(BufferedImage image) {
        width = image.getWidth();
        height = image.getHeight();
        matrix = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                matrix[row][col] = (image.getRGB(col, row) == 0 ? 0 : 1);
               // System.out.print(matrix[row][col] + " ");
            }
            //System.out.println("");
        }
        
        System.out.println("Matrix done");
    }

    public int[][] getMatrix() {
        return reductionMatrice(matrix);
    }
    
    public int[][] reductionMatrice(int[][] matrice){
        int j=0, i=0, y, x;
        int l = matrice[0].length-1;
        int h = matrice.length-1;
        while (j < h && matrice[j][i] == 0) {
            if (i == l) {
                ++j;
                i = 0;
            } else {
                ++i;
            }
        }
        y = j--;
        
        i = 0;
        j = 0;
        while (i < l && matrice[j][i] == 0) {
            if (j == h) {
                ++i;
                j = 0;
            } else {
                ++j;
            }
        }
        x = i--;       
        
        
        int[][] matriceR = new int[h][l];
        int m = 0, n = 0;
        
        for(j = y; j < h; ++j){
            for(i = x; i < l; ++i){
                matriceR[n][m] = matrice[j][i];
                ++m;
            }
            for(i = 0; i < x; ++i){
                matrice[n][m] = 0;
                ++m;
            }
            ++n;
            m = 0;
        }
        
        for(j = 0; j < y; ++j){
            for(i = 0; i < l; ++i){
                matrice[n][m] = 0;
                ++m;
            }
            ++n;
            m = 0;
        }
        
        return matriceR;
    }
    
    public static void printMatrice(int[][] matrice){
        
        for (int row = 0; row < matrice.length; row++) {
            for (int col = 0; col < matrice[row].length; col++) {
                System.out.print(matrice[row][col] + " ");
            }
            System.out.println("");
        }
    }
    
//    public static void enregister(BufferedImage image, String nomF){
//        Writer.verifDossier(FichierConstante.REPERTOIRE_APPRENTISSAGE);
//        File outputfile = new File(FichierConstante.REPERTOIRE_APPRENTISSAGE + nomF + ".png");
//        
//        try {
//            ImageIO.write(image, "png", outputfile);
//        } catch (IOException ex) {
//            Logger.getLogger(BufferedImageToMatrix.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }





