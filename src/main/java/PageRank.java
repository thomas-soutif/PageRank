import Fonctions.Fraction;
import Fonctions.Gauss;
import Fonctions.Pair;
import Fonctions.ScoreRank;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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

        System.out.println();
        System.out.println();

        ScoreRank score = new ScoreRank(gauss.getMatrice()); // On passe le tableau de matrice pour construire le score.
        double tabScore[] = score.getScore(); // On peut récuperer le score dans un tableau

        score.afficher();

        Set<Pair> scoresTries = new TreeSet<Pair>(new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                int res = o2.getValeur().compareTo(o1.getValeur());
                if(res == 0)
                    return 1;
                else return res;
            }
        });

        int i = 1;
        for(double val: score.getScore()){
            scoresTries.add(new Pair("x"+i, val));
            ++i;
        }

        System.out.println();
        System.out.println("Affichage croissant des scores: ");
        for(Pair p: scoresTries)
            System.out.println(p.toString());




    }
}
