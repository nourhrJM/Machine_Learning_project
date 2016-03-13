package Methodes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Erreurs {
    public class MatriceNull extends Exception {

        public MatriceNull() {
            System.out.println("La matrice à traduire en code de freeman est null.");
        }
    }
        
    public class MatriceVide extends Exception {

        public MatriceVide() {
            System.out.println("La matrice à traduire en code de freeman est vide.");
        }
    }
    
    public class VecteurFaux extends Exception {
        
        public VecteurFaux() {
            System.out.println("Erreur de vecteur de Freeman.");
        }
    }
    
    public class FreemanFaux extends Exception {
        
        public FreemanFaux(){
            System.out.println("Erreur de code de freeman.");
        }
    }
    
    public class LigneNonPresente extends Exception {
        
        public LigneNonPresente(){
            System.out.println("Erreur ligne vide.");
        }
    }
}
