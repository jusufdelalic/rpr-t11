package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


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



    public static void main(String[] args) {

        /*Connection conn = DriverManager.getConnection(jdbc:sqlite:filename);
        Statement stmt = conn.createStatement();

  */


        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();
    }
}
