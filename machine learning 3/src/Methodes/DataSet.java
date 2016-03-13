package Methodes;

import java.io.Serializable;


public class DataSet implements Serializable, Comparable<DataSet>{
	private int[][] matrice;
	private String freeman;
	private double distance = 0;
	private String chiffre;
	
	

	public DataSet(int[][] matrice, String freeman, String chiffre)  {
		super();
		this.matrice = matrice;
		this.freeman = freeman;
		this.chiffre = chiffre;
	}

	public String getChiffre() {
		return chiffre;
	}

	public void setChiffre(String chiffre) {
		this.chiffre = chiffre;
	}

	public int[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
	}

	public String getFreeman() {
		return freeman;
	}

	public void setFreeman(String freeman) {
		this.freeman = freeman;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	
	//cette fonction on l'utilise pour que après on puisse utiliser collection.sort
	@Override
	public int compareTo(DataSet ds) {
		 if(this.distance < ds.distance) {
	            return -1;
	        }
	        
	        if(this.distance == ds.distance) {
	            return 0;
	        }
	        
	        return 1;
	}

}
