import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.List;

/**
 * Created by s16005532 on 19/10/17.
 */
public class PageRank {
    public static void main(String[] agrs){


        //La matrice qu'on test ici ([[0,0,1/3,0,0],[1/3,0,0,1/2,0],[0,1,0,0,1],[1/3,0,1/3,0,0],[1/3,0,1/3,1/2,0]]);
    double t[][] = new double[][]{
            {0,0,new Fraction(1,3).doubleValue(),0,0},
            {new Fraction(1,3).doubleValue(),0,0,new Fraction(1,2).doubleValue(),0},
            {0,1,0,0,1},
            {new Fraction(1,3).doubleValue(),0,new Fraction(1,3).doubleValue(),0,0},
            {new Fraction(1,3).doubleValue(),0,new Fraction(1,3).doubleValue(),new Fraction(1,2).doubleValue(),0},
    };

        Gauss gauss = new Gauss(t); // on créer un objet qui contient à présent une matrice résolue.
        double matrice[][] = gauss.getMatrice(); // on peut récuperer cette matrice dans une nouvelle variable.
        gauss.afficher(); // gauss contient toujours la matrice, donc on affiche son contenue .


        // A FAIRE :
        // Implementer la fonction SolveEquation dans la classe ScoreRank (dans le constructeur)
    }
}
