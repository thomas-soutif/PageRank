import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.security.jca.GetInstance;

import java.util.Arrays;

public class Gauss {

    private double matrice[][];


    public Gauss(double copie[][]) {
        matrice = new double[copie.length][copie.length];

        for (int i = 0; i < copie.length; i++)
            for (int j = 0; j < copie.length; j++)
                matrice[i][j] = copie[i][j];


        remplirDiagonale();

        for (int m = 0; m < matrice.length ; m++) {
            for (int i = m + 1; i < matrice.length; i++) {
                double coeff = getCoeff(i, m);
                appliquerPivot(i, coeff, m);
            }
        }


    }

    private void remplirDiagonale() {

        for (int i = 0; i < matrice.length; i++)
            matrice[i][i] -= 1;
    }

    private double getCoeff(int i, int m) {
        if (matrice[m][m] != 0)
            return (-(matrice[i][m] / matrice[m][m]));
        return 0;
    }

    private void appliquerPivot(int i, double coeff, int m) {

        for (int j = 0; j < matrice.length; j++) {
            if (matrice[m][j] != 0)
                matrice[i][j] += coeff * matrice[m][j];

        }

    }

    public double[][] getMatrice() {

        return matrice;
    }

   public void afficher(){

        System.out.println("Matrice de gauss : ");
       System.out.println("[");
       for(int i =0; i < matrice.length; i++)
       {
           for(int j = 0; j < matrice.length; j++)
               System.out.print(matrice[i][j] + ", ");

           System.out.print("\n");
       }
       System.out.print("]");

   }
}
