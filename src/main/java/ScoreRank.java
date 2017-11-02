public class ScoreRank {

    private double[] score; // stocker les scores dans ce tableau


    public ScoreRank(double[][] matrice)
    {
        score = new double[matrice.length];

        score[matrice.length-1] = 1;
        System.out.println(score[matrice.length-1]);
        for(int i = matrice.length-2; i >= 0; i--)
        {

            double res = 0;
            for(int j=i+1; j < matrice.length; j++) {
                res -= matrice[i][j] * score[j];
            }
            score[i] = res / matrice[i][i];

        }

    }

    public void afficher(){

       for(int i=0; i < score.length; i++)
           System.out.println("X"+ (i+1) + "=" + score[i]);


    }

    public double[] getScore(){




        return score;
    }
}
