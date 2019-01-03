package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {


    private static void glavniGrad() {

    System.out.println("Unesite naziv drzave: ");

    String nazivDrzave;

    Scanner ulaz = new Scanner (System.in);

    nazivDrzave = ulaz.nextLine();

        GeografijaDAO geografija = GeografijaDAO.getInstance();

        ArrayList<Drzava> drzave = geografija.getDrzave();

        boolean drzavaPronadjena = false;

        for(var x : drzave) {
            if(x.getNaziv().equals(nazivDrzave)) {
                System.out.println("Glavni grad države " + nazivDrzave + " je " + x.getGlavniGrad().getNaziv());
                drzavaPronadjena = true;
                break;
            }
        }

        if(!drzavaPronadjena)
            System.out.println("Nepostojeća država");


    }



    public static String ispisiGradove() {

        GeografijaDAO geografija = GeografijaDAO.getInstance(); // getInstance za singleton klase...

        ArrayList<Grad> gradovi = geografija.gradovi();

        String rezultat = "";

        for(var grad : gradovi)
            rezultat += (grad.getNaziv() + " (" + grad.getDrzava() + ")" + " - " + grad.getBrojStanovnika()) + "\n";

        return rezultat;

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Gradovi.fxml"));
        primaryStage.setTitle("Gradovi"); //  naziv prozora
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.setResizable(false);
        primaryStage.show(); // prikaz pozornice
    }

    public static void main(String[] args) {



        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();

        launch(args);

    }
}
