package Methodes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Methodes.Erreurs.MatriceNull;
import Methodes.Erreurs.MatriceVide;

public class main {

	public static void main(String[] args) throws IOException, MatriceVide, MatriceNull {
//
//		File repertoire = new File("C:\\Users\\nour\\workspace\\Machine_Learning\\digits\\88\\1.png");
		BufferedImage image = null;
//		image = ImageIO.read(repertoire);
//		File repertoire2 = new File("C:\\Users\\nour\\workspace\\Machine_Learning\\digits\\88\\5.png");
		BufferedImage image1 = null;
//		image2 = ImageIO.read(repertoire2);
//
//		File repertoiretest = new File("C:\\Users\\nour\\workspace\\Machine_Learning\\digits\\9test.png");
//		BufferedImage imagetest = null;
//		imagetest = ImageIO.read(repertoiretest);
//
//		//
//
//		BufferedImageToMatrix BIM = new BufferedImageToMatrix(image);
//		//
//		BufferedImageToMatrix BIM1 = new BufferedImageToMatrix(image1);
//		//
//		BIM.getMatrix();
//		//
//		int[][] matrix = BIM.getMatrix();
//		//
//		//
//		BIM.printMatrice(matrix);
//		//
//		int[][] matrix2 = BIM1.getMatrix();
//		//
//
//		//
//		CodeFreeman cf = new CodeFreeman();
//		//
//		String chaine = cf.matriceToFreeman(matrix);
//		//
//		System.out.println("la chaine de freeman est " + chaine);
//		//
//
//		CodeFreeman cf1 = new CodeFreeman();
//		String chaine1 = cf1.matriceToFreeman(matrix2);
//		System.out.println("la chaine de freeman est " + chaine1);
//
//		EditDistance ed = new EditDistance();
//		int distance = ed.levenshteinDistance(chaine, chaine1);
//		System.out.println("la distance est " + distance);
		

		 ArrayList<DataSet>dataset=new ArrayList<DataSet>();
		 File repertoire1 = new
		 File("C:\\Users\\nour\\workspace\\Machine_Learning\\digits\\9");
		 File[] files = repertoire1.listFiles();
		 File repertoire2 = new
		 File("C:\\Users\\nour\\workspace\\Machine_Learning\\digits\\8");
		 File[] files2 = repertoire2.listFiles();
		
		
		 for (int i=0;i<9;i++){
		 if((files[i].getName().endsWith(".png"))){
		 image=ImageIO.read(files[i]);
		 image1=ImageIO.read(files2[i]);
		 CodeFreeman cf=new CodeFreeman();
		 CodeFreeman cf1=new CodeFreeman();
		
		 BufferedImageToMatrix BIM=new BufferedImageToMatrix(image);
		 BufferedImageToMatrix BIM1=new BufferedImageToMatrix(image1);
		 int [][]matrix= BIM.getMatrix();
		 int [][]matrix1= BIM1.getMatrix();
		 String chaine=cf.matriceToFreeman(matrix);
		 System.out.println("Le fichier "+files[i].getName() +" la chaine de freeman pour le chiffre 9 est "+chaine);
		 String chaine2=cf.matriceToFreeman(matrix1);
		 System.out.println("Le fichier "+files2[i].getName() +"la chaine de freeman pour le chiffre 8 est "+chaine2);
		 
		 
		 dataset.add(new DataSet(matrix, chaine, "9"));
		 dataset.add(new DataSet(matrix1, chaine2, "8"));
		
		 }
		
	
		 }
		 BufferedImage image3=null;
		 File file3 = new File("C:\\Users\\nour\\workspace\\Machine_Learning\\digits\\9test.png");
		 image3=ImageIO.read(file3);
		 CodeFreeman cf3=new CodeFreeman();
		 BufferedImageToMatrix BIM3=new BufferedImageToMatrix(image3);
		 int [][]matrix3= BIM3.getMatrix();
		 String chaine3=cf3.matriceToFreeman(matrix3);
		 for (int j=0; j<dataset.size();j++){
			 
		 EditDistance ed=new EditDistance();
		 int distance=ed.levenshteinDistance(dataset.get(j).getFreeman(),chaine3 );
		 System.out.println("Le code est "+dataset.get(j).getFreeman());
		 System.out.println("Le code est "+chaine3);
		 
		 System.out.println("la "+(j+1)+" distance entre "+dataset.get(j).getChiffre()+" et unknown est "+distance);}
		
		 k_plus_proche_voisin_edit kppe=new k_plus_proche_voisin_edit();
		 int kp=kppe.kppv(chaine3, dataset, 5);
		 System.out.println(kp);
		 
		 KNN_Algo knn=new KNN_Algo();
		 KNN_Algo knn1=new KNN_Algo();
		 KNN_Algo knn2=new KNN_Algo();
		 int resKNN= knn.kppv(matrix3, dataset, 5, 0);
		 System.out.println("Resultat avec manathan "+resKNN);
		 int resKNN1= knn1.kppv(matrix3, dataset, 5, 1);
		 System.out.println("Resultat avec eucledien  "+resKNN1);
		 int resKNN2= knn2.kppv(matrix3, dataset, 5, 2);
		 System.out.println("Resultat avec blabla distance  "+resKNN2);
		
		 
	}

}
