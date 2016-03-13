package Methodes;



import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;


public class CodeFreeman {
    private String Code;
    private final Erreurs err = new Erreurs();

    
    
    
    // cette fonction récupère la matrice binair et retourne la code de freeman 
    public String matriceToFreeman(int[][] matrice) throws Erreurs.MatriceVide, Erreurs.MatriceNull {
        if (matrice == null) {
            throw err.new MatriceNull();
        }
        
        String morgan = "";
        int vect = 2, vectSv;
        int i = 0, j = 0;
        int x0, y0;
        int x = 0, y = 0;
        
        while (j < matrice.length && matrice[j][i] == 0) {
            if (i == matrice[j].length) {
                ++j;
                i = 0;
            } else {
                ++i;
            }
        }
        
        if (matrice[j][i] == 1) {
            x0 = i;
            y0 = j;
        } else {
            throw err.new MatriceVide();
        }

        do {
            vectSv = (vect + 5) % 8;

            try {
                do {
                    do{
                        x = prochainX(vectSv);
                        y = prochainY(vectSv);
                        vectSv = (vectSv + 1) % 8;
                    }while((j + y) >= matrice.length || (i + x) >= matrice[j].length || (j + y) < 0 || (i + x) < 0);
                } while (matrice[j + y][i + x] != 1);

                i += x;
                j += y;
            } catch (Erreurs.VecteurFaux ex) {
            }

            if (vectSv == 0) {
                vectSv = 7;
            } else {
                --vectSv;
            }

            morgan += vectSv;
            vect = vectSv;
        } while (i != x0 || j != y0);

        return morgan;
    }
    
    public int[][] freemanToMatrice(String morgan,File f) throws Erreurs.FreemanFaux, IOException{
    	BufferedImage image = null;
    	image=ImageIO.read(f);
    	int l = image.getWidth()*2;
    	int h=image.getHeight();
    	int x = image.getWidth()*2;
    	
        
    	
    	//int l = IgConstante.LARGEUR_IMAGE*2, h = IgConstante.HAUTEUR_IMAGE;
//        int x = IgConstante.LARGEUR_IMAGE, 
        		int y = 0;
        int i, j;
        int[][] matrice = new int[h][l];
        int stringL = morgan.length();
        int vect;
        
        for(j = 0; j < h; ++j){
            for(i = 0; i < l; ++i){
                matrice[j][i] = 0;
            }
        }
        
        for(i = 0; i < stringL; ++i){
            vect = Character.getNumericValue(morgan.charAt(i));
            
            try {
                x = x + prochainX(vect);
                y = y + prochainY(vect);
                
                if(x < 0 || x >= l || y < 0 || y >= h){
                    throw err.new FreemanFaux();
                }
                
                matrice[y][x] = 1;
            } catch (Erreurs.VecteurFaux ex) {
                Logger.getLogger(CodeFreeman.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return matrice;
    }

    public int prochainX(int vect) throws Erreurs.VecteurFaux {
        if(vect == 0 || vect == 4) {
            return 0;
        }
        else if(vect == 1 || vect == 2 || vect == 3) {
            return 1;
        }
        else if(vect == 5 || vect == 6 || vect == 7) {
            return -1;
        }
        
        throw err.new VecteurFaux();
    }
    
     public int prochainY(int vect) throws Erreurs.VecteurFaux {
        if(vect == 6 || vect == 2) {
            return 0;
        }
        else if(vect == 5 || vect == 4 || vect == 3) {
            return 1;
        }
        else if(vect == 0 || vect == 1 || vect == 7) {
            return -1;
        }
        
        throw err.new VecteurFaux();
    }
     
    public int sensChiffre(String morgan) throws Erreurs.VecteurFaux{
        int sens = 0;
        int i, l = morgan.length();
        char vect;
        
        for(i = 0; i < l; ++i) {
            vect = morgan.charAt(i);
            if (vect == '1' || vect == '2' || vect == '3') {
                sens++;
            } else if (vect == '5' || vect == '6' || vect == '7') {
                sens--;
            } else if(vect != '0' && vect !='4') {
                throw err.new VecteurFaux();
            }
        }
        
        return sens;
    }


    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }
}
