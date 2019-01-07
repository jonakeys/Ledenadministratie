/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ledenadmin;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * Klasse die de gegevens van een lid beheert.
 *
 * @author jonathan
 */
public class Lid implements Comparable<Lid> {

    private final String naam;
    private final LocalDate geboortedatum;
    private final LocalDate vandaag = LocalDate.now();
    private final String woonplaats;

    /**
     * Constructor
     *
     * @param naam Naam van lid.
     * @param geboortedatum Geboortedatum van lid.
     * @param woonplaats Woonplaats van lid.
     */
    public Lid(String naam, LocalDate geboortedatum, String woonplaats) {
        this.naam = naam;
        this.geboortedatum = geboortedatum;
        this.woonplaats = woonplaats;
    }

    /**
     * Geeft de naam.
     *
     * @return Naam van lid.
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Geeft de leeftijd.
     *
     * @return Leeftijd van lid.
     */
    public int getLeeftijd() {
        int leeftijd;
        long longleeftijd;
        longleeftijd = YEARS.between(geboortedatum, vandaag);
        leeftijd = (int) longleeftijd;
        return leeftijd;
    }

    /**
     * Geeft de geboortedatum (01.JANUARY.1900)
     *
     * @return Geboortedatum van lid.
     */
    public String getGeboortedatum() {
        String datum = "";
        datum += geboortedatum.getDayOfMonth() + "." + geboortedatum.getMonth() + "." + geboortedatum.getYear();
        return datum;
    }

    /**
     * Geeft de geboortedatum in opmaak om in bestand op te slaan (1900 1 1).
     *
     * @return Geboortedatum van lid.
     */
    public String getGeboortedatumOpslaan() {
        String datum = "";
        datum += geboortedatum.getYear() + " " + geboortedatum.getMonthValue() + " " + geboortedatum.getDayOfMonth();
        return datum;
    }

    /**
     * Geeft de woonplaats.
     *
     * @return Woonplaats van lid.
     */
    public String getWoonplaats() {
        return woonplaats;
    }

    /**
     * Vergelijkt lid met een ander lid om te sorteren op basis van naam.
     *
     * @param anderLid Ander lid om mee te vergelijken.
     * @return
     */
    @Override
    public int compareTo(Lid anderLid) {
        return this.getNaam().compareTo(anderLid.getNaam());
    }

}
