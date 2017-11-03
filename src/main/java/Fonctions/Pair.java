package Fonctions;

public class Pair {

    private String cle;
    private Double valeur;

    public Pair(String cle, double valeur){
        this.cle = cle;
        this.valeur = valeur;
    }

    public Double getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return  cle +
                "= " + valeur;
    }
}
