import sun.security.jca.GetInstance;

public class Gauss {

    private double matrice[][];


    public Gauss(double copie[][])
    {
        matrice = new double[copie.length][copie.length];

        for(int i=0; i < copie.length; i++)
            for(int j=0; j < copie.length; j++)
                matrice[i][j] = copie[i][j];


        remplirDiagonale();

        for(int i = 0; i < matrice.length-1; i++ )
            for(int j = i+1; j < matrice.length-1; j++ )
            {
                double coeff = getCoeff(i,j);
                appliquerPivot(i,coeff,j);
            }


    }

    private void remplirDiagonale()
    {

        for(int i =0; i < matrice.length; i++)
            matrice[i][i] -= 1;
    }

    private double getCoeff(int i, int j)
    {
        if(matrice[i][i] != 0)
            return (-(matrice[i][j] / matrice[i][i]));
        return 0;
    }

    private void appliquerPivot(int i,double coeff, int j)
    {

        for(int m = 0; m < matrice.length-1; m++)
        {
            if(matrice[i][m] != 0)
                matrice[j][m] += coeff * matrice[i][m];

        }

    }

    public double[][] getMatrice(){

        return matrice;
    }

}
