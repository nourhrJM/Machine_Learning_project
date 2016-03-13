package Methodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//import algo.AlgosConstantes;
import Methodes.ChiffreFreeman;

public class KNN_Algo {
	
    public static final int _3_VOISINS = 3;
    public static final int _5_VOISINS = 5;
    public static final int _7_VOISINS = 7;
	
	public int kppv(int[][] matrice_x, ArrayList<DataSet> s, int nombre_voisin, int ALGO_DISTANCE) {
        int classe_y = -1;
        Iterator<DataSet> it_s = null;
        int tab_kppv[] = {0,0,0,0,0,0,0,0,0,0};
        
        //Si matrice est vide
        if (matrice_x.length == 0) {
            System.out.println("ERREUR : Matrice vide !");
            return -1;
        }

        //Si la base de connnaissance est vide
        if (s == null) {
            System.out.println("ERREUR : Probleme à la lecture de la base de connaissance");
            return -1;
        }
        
        if (s.isEmpty()) {
            System.out.println("ERREUR : Base de connaissance vide");
            return -1;
        }

        it_s = s.iterator();
        //Calcul des distances par rapport à x pour chaque point de la base
        while (it_s.hasNext()) {
            DataSet cmf = it_s.next();
            
            switch (ALGO_DISTANCE) {

                case 0:
                    cmf.setDistance(manhattanDistance(matrice_x, cmf.getMatrice()));
                    break;

                case 1:
                    cmf.setDistance(euclideanDistance(matrice_x, cmf.getMatrice()));
                    break;

                case 2:
                    cmf.setDistance(chebyshevDistance(matrice_x, cmf.getMatrice()));
                    break;

                default:
                    System.out.println("ERREUR : Algorithme de calcule de distance non existant");
                    return -1;
            }
        }

        //Trie par ordre croissant selon la distance (voir methode compareTo de ChiffreMatriceFreeman)
        Collections.sort(s);
        
        if(nombre_voisin != _3_VOISINS && nombre_voisin != _5_VOISINS && nombre_voisin != _7_VOISINS) {
            // par défaut on choisit les 3-ppv
            nombre_voisin = _3_VOISINS;
        }
        
        for( int i = 0; i < nombre_voisin; i++) {
            tab_kppv[Integer.valueOf(s.get(i).getChiffre())]++;
            System.out.println("voisin : " + s.get(i).getChiffre());
        }
        
        int max = tab_kppv[0];
        classe_y = 0;
        for(int i = 1 ; i < tab_kppv.length; i++) {
            if(max < tab_kppv[i]) {
                classe_y = i;
                max = tab_kppv[i];
            }
        }
        System.out.println("classe_ y : " + classe_y);
        return classe_y;
    }
	 /**
     * Manhattan Distance
     *
     * @param matrice_x
     * @param matrice_y
     * @return Manhattan distance between matrix x and matrix y
     */
    public double manhattanDistance(int[][] matrix_x, int[][] matrix_y) {
        //hello
        double s = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    s = s + Math.abs(matrix_x[i][j] - matrix_y[i][j]);
                }
            }
        }
        return s;
    }

    /**
     * Euclidean Distance
     *
     * @param matrix_x
     * @param matrix_y
     * @return Euclidean distance between matrix x and matrix y
     */
    public double euclideanDistance(int[][] matrix_x, int[][] matrix_y) {
        double s = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    s = s + Math.pow(matrix_x[i][j] - matrix_y[i][j], 2);
                }
            }
        }

        return Math.sqrt(s);
    }

    /**
     * Chebyshev Distance
     *
     * @param matrix_x
     * @param matrix_y
     * @return Chebyshev Distance between matrix x and matrix y
     */
    public double chebyshevDistance(int[][] matrix_x, int[][] matrix_y) {
        double s = 0;
        double max = 0;
        for (int i = 0; i < matrix_x.length; i++) {
            for (int j = 0; j < matrix_x[0].length; j++) {
                if (matrix_x[i][j] != matrix_y[i][j]) {
                    if (Math.abs(matrix_x[i][j] - matrix_y[i][j]) > max) {
                        max = Math.abs(matrix_x[i][j] - matrix_y[i][j]);
                        s = max;
                    }
                }
            }
        }
        return s;
    }


}
