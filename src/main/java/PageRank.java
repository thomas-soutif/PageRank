import Fonctions.Fraction;
import Fonctions.Gauss;
import Fonctions.Pair;
import Fonctions.ScoreRank;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/**
 * Created by s16005532 on 19/10/17.
 */
public class PageRank extends Application {


    final GridPane grid = new GridPane();
    public static void main(String[] agrs){


        launch(agrs); // lancer la fenetre 2D
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
    @Override
    public void start(Stage primaryStage){

        Pane root = new Pane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        addButton();

        root.getChildren().add(grid);
        Scene scene = new Scene(root,500,500);

        primaryStage.setTitle("Page Rank");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void addButton() {

        Button btn = new Button();
        btn.setText("Trier selon la méthode PageRank");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                javafx.scene.text.Text buttonText = new javafx.scene.text.Text("A mettre ici");
                grid.add(buttonText,0,0);

            }
        });
        grid.add(btn,13,30);
    }

}
