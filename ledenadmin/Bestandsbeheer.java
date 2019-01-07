/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ledenadmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Klasse die openen en opslaan van het bestand beheert.
 *
 * @author jonathan
 */
public class Bestandsbeheer {

    Ledenlijst lijst = new Ledenlijst();

    /**
     * Laad de gegevens uit het bestand in de lijst.
     */
    public void bestandLaden() {
        lijst.maakLeeg();
        try {
            Scanner sc = new Scanner(new File("ledenadmin.txt"));
            while (sc.hasNext()) {
                String naam = sc.next();
                int jaar = sc.nextInt();
                int maand = sc.nextInt();
                int dag = sc.nextInt();
                String woonplaats = sc.next();
                LocalDate geboortedatum = LocalDate.of(jaar, maand, dag);
                lijst.voegLidToe(naam, geboortedatum, woonplaats);
            }
            sc.close();
        } catch (FileNotFoundException e) {
        }
    }

    /**
     * Geeft de lijst.
     *
     * @return Lijst van leden.
     */
    public Ledenlijst getLijst() {
        return lijst;
    }

    /**
     * Sla de gegevens uit de lijst op in het bestand.
     *
     * @param lijst Lijst die opgeslagen moet worden.
     */
    public void bestandOpslaan(Ledenlijst lijst) {
        String opslaan = "";
        this.lijst = lijst;
        for (int i = 0; i < lijst.getSize(); i++) {
            opslaan += lijst.getLidOpslaan(i) + "\n";
        }
        try {
            PrintWriter out = new PrintWriter("ledenadmin.txt");
            out.print(opslaan);
            out.close();
        } catch (FileNotFoundException e) {
        }
    }
}
