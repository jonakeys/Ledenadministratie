/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ledenadmin;

import java.util.Arrays;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collections;

/**
 * Klasse die een lijst van leden beheert.
 *
 * @author jonathan
 */
public class Ledenlijst {

    ArrayList<Lid> lijst = new ArrayList<>();

    public Ledenlijst() {

    }

    /**
     * Constructor om lijst te vullen met reeds gemaakte lijst.
     *
     * @param lijst Lijst met leden.
     */
    public Ledenlijst(ArrayList<Lid> lijst) {
        this.lijst = lijst;
    }

    /**
     * Maak de lijst leeg.
     */
    public void maakLeeg() {
        lijst.clear();
    }

    /**
     * Voeg een lid toe.
     *
     * @param naam Naam van lid.
     * @param geboortedatum Geboortedatum van lid.
     * @param woonplaats Woonplaats van lid.
     */
    public void voegLidToe(String naam, LocalDate geboortedatum, String woonplaats) {
        lijst.add(new Lid(naam, geboortedatum, woonplaats));
    }

    /**
     * Toon een overzicht van de leden in de lijst.
     *
     * @return Overzicht van de gegevens van alle leden.
     */
    public String toonLeden() {
        String leden = "";
        for (Lid l : lijst) {
            leden += "Naam: " + l.getNaam() + " (" + l.getLeeftijd() + ")\n";
            //leden += "Leeftijd: " + l.getLeeftijd() + " jaar " + "(" + l.getGeboortedatum() + ") " + "\n";
            leden += "Geboortedatum: " + l.getGeboortedatum() + "\n";
            leden += "Woonplaats: " + l.getWoonplaats() + "\n\n";
        }
        return leden;
    }

    /**
     * Sorteer de leden in de lijst.
     */
    public void sorteerLeden() {
        Collections.sort(lijst);
    }

    /**
     * Toon de gegevens van een specifiek lid. (Wordt gebruikt voor de ComboBox)
     *
     * @param i Volgnummer van lid in de lijst.
     * @return Geeft gegevens van een lid.
     */
    public String toonLid(int i) {
        String gegevens = "";
        Lid lid = lijst.get(i);
        gegevens += lid.getNaam() + ", " + lid.getGeboortedatum() + ", " + lid.getWoonplaats();
        return gegevens;
    }
    
    public String toonLidNaam(int i) {
        return lijst.get(i).getNaam();
    }
    
    public String toonLidWoonplaats(int i) {
        return lijst.get(i).getWoonplaats();
    }

    /**
     * Geeft de grootte van de lijst.
     *
     * @return Grootte van de lijst.
     */
    public int getSize() {
        return lijst.size();
    }

    /**
     * Verwijder een lid uit de lijst.
     *
     * @param i Volgnummer van lid in de lijst.
     */
    public void verwijderLid(int i) {
        lijst.remove(i);
    }
    
    public void bewerkLid(int i, String naam, String woonplaats) {
        lijst.get(i).setNaam(naam);
        lijst.get(i).setWoonplaats(woonplaats);
    }

    /**
     * Geeft de gegevens van een lid in formaat om op te slaan in bestand.
     *
     * @param i Volgnummer van lid in de lijst.
     * @return Geeft gegevens van een lid.
     */
    public String getLidOpslaan(int i) {
        String info = "";
        Lid lid = lijst.get(i);
        info += lid.getNaam() + " " + lid.getGeboortedatumOpslaan() + " " + lid.getWoonplaats();
        return info;
    }
}
