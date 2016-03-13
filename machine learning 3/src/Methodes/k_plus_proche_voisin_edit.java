package Methodes;

import java.util.ArrayList;
import Methodes.EditDistance;
import java.util.Collections;



public class k_plus_proche_voisin_edit {
	
	 public static final int _3_VOISINS = 3;
	    public static final int _5_VOISINS = 5;
	    public static final int _7_VOISINS = 7;
	
	public int kppv(String FreemanIn, ArrayList<DataSet> liste, int nombre_voisin) {
        int[] mesPlusProcheVoisins = new int[10];
        
        int classe_y;
        EditDistance ed =new EditDistance();
        for (int i=0;i<liste.size();i++) {
            int distanse = ed.levenshteinDistance(FreemanIn, liste.get(i).getFreeman());
            System.out.println("la distance de knn "+distanse);
            liste.get(i).setDistance(distanse);
        }
        Collections.sort(liste);
        
        for (int i = 0; i < 10; i++) {
            mesPlusProcheVoisins[i] = Integer.valueOf(liste.get(i).getChiffre());
        }
        
        if(nombre_voisin != _3_VOISINS && nombre_voisin != _5_VOISINS && nombre_voisin != _7_VOISINS) {
            // par défaut on choisit les 3-ppv
            nombre_voisin = _3_VOISINS;
        }
        classe_y = maClasse(mesPlusProcheVoisins,nombre_voisin);
        return classe_y;
    }
    
    public int maClasse(int[] Tableau, int k){
        int redandance;
        int maxRedandance = 0;
        int classeY = -1;
        for (int i = 0; i < k; i++) {
            redandance = 0;
            for (int j = i; j < k; j++) {
                if(Tableau[i] == Tableau[j]){
                    redandance++;
                }
            }
            if(redandance > maxRedandance){
                classeY = Tableau[i];
                maxRedandance = redandance;
            }
        }
        return classeY;
    }

}
