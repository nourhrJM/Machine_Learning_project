package Methodes;

public class EditDistance {
	
	
	public int levenshteinDistance(String firstCodeFreeman, String secondCodeFreeman) {

        //longueur du premier et deuxième code de freeman 
        int firstLength = firstCodeFreeman.length() + 1;
        int secondLength = secondCodeFreeman.length() + 1;

        // tableau de distance
        int[] cost = new int[firstLength];
        int[] newcost = new int[firstLength];

        // cout initial 
        for (int i = 0; i < firstLength; i++) {
            cost[i] = i;
        }

        for (int j = 1; j < secondLength; j++) {

            // cout initial du deuxieme code de freeman
            newcost[0] = j - 1;

            // changement de cout pour chaque lettre dans le prmeier code de freeman
            for (int i = 1; i < firstLength; i++) {

                // verification des deux lettre dans les deux code de freeman
                int match = (firstCodeFreeman.charAt(i - 1) == secondCodeFreeman.charAt(j - 1)) ? 0 : 1;

                // changement de cout pour chaque transformation 
                int costReplace = cost[i - 1] + match;
                int costInsert = cost[i] + 1;
                int costDelete = newcost[i - 1] + 1;

                // prendre le coup minimal 
                newcost[i] = min(costInsert, costDelete, costReplace);
            }

            // changer les caleurs des tableau cost/newcost 
            int[] swap = cost;
            cost = newcost;
            newcost = swap;
        }

        //la distance c'est le cout pour trnasformer toutes les lettre dans les deux code de freeman
        return cost[firstLength - 1];
    }

    /**
     * tourve la valeur minimal entre trois valeurs
     *
     * @param costInsert
     * @param costDelete
     * @param costReplace
     * @return minimum value
     */
    public int min(int costInsert, int costDelete, int costReplace) {
        if (costInsert <= costDelete && costInsert <= costReplace) {
            return costInsert;
        } else if (costDelete <= costInsert && costDelete <= costReplace) {
            return costDelete;
        } else {
            return costReplace;
        }
    }
    
    

}
