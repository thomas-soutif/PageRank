import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.List;

/**
 * Created by s16005532 on 19/10/17.
 */
public class PageRank {
    public static void main(String[] agrs){


        //double Mat[5][5] = { {0,1,1.5,1/3,2},{0,1,1.5,1/3,2},{0,1,1.5,1/3,2},{0,1,1.5,1/3,2},{0,1,1.5,1/3,2}};
        //List<List<Double>> myL = new List<List<Double>>;

        //myL[1][1] = 5;

        //B = Matrix([[0,0,new Fraction(1,3),0,0],[1/3,0,0,1/2,0],[0,1,0,0,1],[1/3,0,1/3,0,0],[1/3,0,1/3,1/2,0]]);
    double t[][] = new double[][]{
            {0,0,new Fraction(1,3).doubleValue(),0,0},
            {new Fraction(1,3).doubleValue(),0,0,new Fraction(1,2).doubleValue(),0},
            {0,1,0,0,1},
            {new Fraction(1,3).doubleValue(),0,new Fraction(1,3).doubleValue(),0,0},
            {new Fraction(1,3).doubleValue(),0,new Fraction(1,3).doubleValue(),new Fraction(1,2).doubleValue(),0},
    };

        Gauss gauss = new Gauss(t);

        double matrice[][] = gauss.getMatrice();

        for(int i=0; i < matrice.length; i++)
            for(int j=0; j < matrice.length; j++)
                System.out.println(matrice[i][j]);



    }
}
