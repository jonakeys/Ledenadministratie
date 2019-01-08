/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ledenadmingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import ledenadmin.Ledenlijst;
import ledenadmin.Bestandsbeheer;

/**
 * Klasse die de grafische weergave van het programma verzorgt.
 *
 * @author jonathan
 */
public class Ledenadmingui extends javax.swing.JFrame {

    Ledenlijst lijst = new Ledenlijst();
    Bestandsbeheer bestandsbeheer = new Bestandsbeheer();

    /**
     * Creates new form Ledenadmingui
     */
    public Ledenadmingui() {
        initComponents();
        mijnInit();
    }

    /**
     * Initialiseren van standaardwaarden, zoals de invoervelden en
     * keuzelijsten.
     */
    private void mijnInit() {
        int huidigJaar = LocalDate.now().getYear();
        naamTekstveld.setText("");
        woonplaatsTekstveld.setText("");
        dagComboBox.removeAllItems();
        maandComboBox.removeAllItems();
        jaarComboBox.removeAllItems();
        for (int i = 1; i <= 31; i++) {
            dagComboBox.addItem("" + i);
        }
        for (int i = 1; i <= 12; i++) {
            maandComboBox.addItem("" + i);
        }
        for (int i = 1900; i <= huidigJaar; i++) {
            jaarComboBox.addItem("" + i);
        }
        ledenlijstTekstGebied.setText("Voeg een lid toe of klik op 'Open lijst' om het bestand te openen.");
        statusTekstveld.setText("Status...");
        updateElementen();
        startComboBox();
    }

    /**
     * Voeg een ActionListener toe aan de ComboBox voor bewerken.
     */
    private void startComboBox() {
        bewerkComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bewerkNaamWoonplaats();
            }
        });
    }

    /**
     * Vult de velden 'Naam:' en 'Woonplaats:' in met gegevens van geselecteerde
     * lid.
     */
    private void bewerkNaamWoonplaats() {
        if (lijst.getSize() > 0 && bewerkComboBox.getSelectedIndex() >= 0) {
            bewerkNaamTekstveld.setText(lijst.toonLidNaam(bewerkComboBox.getSelectedIndex()));
            bewerkWoonplaatsTekstveld.setText(lijst.toonLidWoonplaats(bewerkComboBox.getSelectedIndex()));
        }
    }

    /**
     * Voeg een lid toe aan de lijst.
     *
     * @param naam Naam van lid.
     * @param geboortedatum Geboortedatum van lid.
     * @param woonplaats Woonplaats van lid.
     */
    private void voegLidToe(String naam, LocalDate geboortedatum, String woonplaats) {
        lijst.voegLidToe(naam, geboortedatum, woonplaats);
        updateElementen();
        statusTekstveld.setText("Lid succesvol toegevoegd");
    }

    /**
     * Zet alle invoervelden terug naar beginwaarden.
     */
    private void resetVelden() {
        naamTekstveld.setText("");
        woonplaatsTekstveld.setText("");
        dagComboBox.setSelectedIndex(0);
        maandComboBox.setSelectedIndex(0);
        jaarComboBox.setSelectedIndex(0);
        bewerkNaamTekstveld.setText("");
        bewerkWoonplaatsTekstveld.setText("");
    }

    /**
     * Toon de gegevens van de ledenlijst in het uitvoerveld.
     */
    private void toonLedenlijst() {
        ledenlijstTekstGebied.setText(lijst.toonLeden());
    }

    /**
     * Sorteer de leden in de lijst.
     */
    private void sorteer() {
        lijst.sorteerLeden();
        updateElementen();
        statusTekstveld.setText("Lijst gesorteerd");
    }

    /**
     * Wis de huidige ledenlijst.
     */
    private void wisLijst() {
        lijst.maakLeeg();
    }

    /**
     * Vernieuw de gegevens in de ComboBox met de huidige lijst.
     */
    private void updateComboBox() {
        verwijderComboBox.removeAllItems();
        bewerkComboBox.removeAllItems();
        for (int i = 0; i < lijst.getSize(); i++) {
            verwijderComboBox.addItem(lijst.toonLid(i));
            bewerkComboBox.addItem(lijst.toonLid(i));
        }
        verwijderComboBox.setSelectedIndex(-1);
        bewerkComboBox.setSelectedIndex(-1);
    }

    /**
     * Verwijder een lid uit de lijst.
     *
     * @param i Volgnummer van lid in de lijst.
     */
    private void verwijderLid(int i) {
        lijst.verwijderLid(i);
        updateElementen();
        statusTekstveld.setText("Lid verwijderd");
    }

    /**
     * Bewerk de naam of woonplaats van een lid uit de lijst.
     *
     * @param i Volgnummer van lid in de lijst.
     */
    private void bewerkLid(int i) {
        String naam = "";
        String woonplaats = "";
        naam = bewerkNaamTekstveld.getText();
        woonplaats = bewerkWoonplaatsTekstveld.getText();
        lijst.bewerkLid(i, naam, woonplaats);
        updateElementen();
        statusTekstveld.setText("Lid bewerkt");
    }

    /**
     * Controleer of ingevoerde datum geldig is.
     *
     * @param jaar Jaar.
     * @param maand Maand.
     * @param dag Dag.
     * @return True als datum geldig is.
     */
    public boolean isDatumGeldig(int jaar, int maand, int dag) {
        boolean isGeldig = true;
        try {
            LocalDate.of(jaar, maand, dag);
        } catch (DateTimeException e) {
            isGeldig = false;
        }
        return isGeldig;
    }

    /**
     * Vernieuw alle dynamische velden met huidige gegevens.
     */
    public void updateElementen() {
        toonLedenlijst();
        updateComboBox();
        resetVelden();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ledenlijstTekstGebied = new javax.swing.JTextArea();
        toonLedenButton = new javax.swing.JButton();
        sorteerOpNaamButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        bewaarButton = new javax.swing.JButton();
        statusTekstveld = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        wisButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        toevoegenPanel = new javax.swing.JPanel();
        naamLabel = new javax.swing.JLabel();
        geboortedatumLabel = new javax.swing.JLabel();
        woonplaatsLabel = new javax.swing.JLabel();
        naamTekstveld = new javax.swing.JTextField();
        woonplaatsTekstveld = new javax.swing.JTextField();
        dagComboBox = new javax.swing.JComboBox<>();
        maandComboBox = new javax.swing.JComboBox<>();
        jaarComboBox = new javax.swing.JComboBox<>();
        resetButton = new javax.swing.JButton();
        voegToeButton = new javax.swing.JButton();
        bewerkenPanel = new javax.swing.JPanel();
        bewerkComboBox = new javax.swing.JComboBox<>();
        bewerkButton = new javax.swing.JButton();
        bewerkNaamLabel = new javax.swing.JLabel();
        bewerkWoonplaatsLabel = new javax.swing.JLabel();
        bewerkNaamTekstveld = new javax.swing.JTextField();
        bewerkWoonplaatsTekstveld = new javax.swing.JTextField();
        verwijderenPanel = new javax.swing.JPanel();
        verwijderComboBox = new javax.swing.JComboBox<>();
        verwijderLidButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ledenadministratie");
        setPreferredSize(new java.awt.Dimension(750, 600));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(681, 450));

        ledenlijstTekstGebied.setEditable(false);
        ledenlijstTekstGebied.setColumns(20);
        ledenlijstTekstGebied.setRows(5);
        ledenlijstTekstGebied.setPreferredSize(null);
        jScrollPane1.setViewportView(ledenlijstTekstGebied);

        toonLedenButton.setText("Vernieuw");
        toonLedenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toonLedenButtonActionPerformed(evt);
            }
        });

        sorteerOpNaamButton.setText("Sorteer op naam");
        sorteerOpNaamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sorteerOpNaamButtonActionPerformed(evt);
            }
        });

        openButton.setText("Open lijst");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        bewaarButton.setText("Bewaar lijst");
        bewaarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bewaarButtonActionPerformed(evt);
            }
        });

        statusTekstveld.setEditable(false);
        statusTekstveld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusTekstveldActionPerformed(evt);
            }
        });

        statusLabel.setText("Status:");

        wisButton.setText("Wis lijst");
        wisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(toonLedenButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sorteerOpNaamButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(wisButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bewaarButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(statusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusTekstveld)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toonLedenButton)
                    .addComponent(sorteerOpNaamButton)
                    .addComponent(openButton)
                    .addComponent(bewaarButton)
                    .addComponent(wisButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusTekstveld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        toevoegenPanel.setName(""); // NOI18N

        naamLabel.setText("Naam:");

        geboortedatumLabel.setText("Geboortedatum:");

        woonplaatsLabel.setText("Woonplaats:");

        woonplaatsTekstveld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woonplaatsTekstveldActionPerformed(evt);
            }
        });

        dagComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maandComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jaarComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        voegToeButton.setText("Voeg lid toe");
        voegToeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voegToeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toevoegenPanelLayout = new javax.swing.GroupLayout(toevoegenPanel);
        toevoegenPanel.setLayout(toevoegenPanelLayout);
        toevoegenPanelLayout.setHorizontalGroup(
            toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toevoegenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(geboortedatumLabel)
                    .addComponent(naamLabel)
                    .addComponent(woonplaatsLabel)
                    .addComponent(resetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toevoegenPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(voegToeButton))
                    .addComponent(naamTekstveld)
                    .addComponent(woonplaatsTekstveld)
                    .addGroup(toevoegenPanelLayout.createSequentialGroup()
                        .addComponent(dagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jaarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 295, Short.MAX_VALUE)))
                .addContainerGap())
        );
        toevoegenPanelLayout.setVerticalGroup(
            toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toevoegenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(naamLabel)
                    .addComponent(naamTekstveld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toevoegenPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(geboortedatumLabel)
                            .addComponent(dagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maandComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jaarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(woonplaatsLabel)
                            .addComponent(woonplaatsTekstveld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toevoegenPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(toevoegenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(voegToeButton)
                            .addComponent(resetButton))
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Toevoegen", toevoegenPanel);

        bewerkComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bewerkComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bewerkComboBoxItemStateChanged(evt);
            }
        });
        bewerkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bewerkComboBoxActionPerformed(evt);
            }
        });

        bewerkButton.setText("Bewerk lid");
        bewerkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bewerkButtonActionPerformed(evt);
            }
        });

        bewerkNaamLabel.setText("Naam:");

        bewerkWoonplaatsLabel.setText("Woonplaats:");

        bewerkNaamTekstveld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bewerkNaamTekstveldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bewerkenPanelLayout = new javax.swing.GroupLayout(bewerkenPanel);
        bewerkenPanel.setLayout(bewerkenPanelLayout);
        bewerkenPanelLayout.setHorizontalGroup(
            bewerkenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bewerkenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bewerkenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bewerkComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bewerkenPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bewerkButton))
                    .addGroup(bewerkenPanelLayout.createSequentialGroup()
                        .addGroup(bewerkenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bewerkWoonplaatsLabel)
                            .addComponent(bewerkNaamLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bewerkenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bewerkNaamTekstveld)
                            .addComponent(bewerkWoonplaatsTekstveld, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))))
                .addContainerGap())
        );
        bewerkenPanelLayout.setVerticalGroup(
            bewerkenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bewerkenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bewerkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bewerkenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bewerkNaamLabel)
                    .addComponent(bewerkNaamTekstveld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bewerkenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bewerkWoonplaatsLabel)
                    .addComponent(bewerkWoonplaatsTekstveld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(bewerkButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bewerken", bewerkenPanel);

        verwijderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        verwijderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verwijderComboBoxActionPerformed(evt);
            }
        });

        verwijderLidButton.setText("Verwijder lid");
        verwijderLidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verwijderLidButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout verwijderenPanelLayout = new javax.swing.GroupLayout(verwijderenPanel);
        verwijderenPanel.setLayout(verwijderenPanelLayout);
        verwijderenPanelLayout.setHorizontalGroup(
            verwijderenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verwijderenPanelLayout.createSequentialGroup()
                .addGroup(verwijderenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verwijderenPanelLayout.createSequentialGroup()
                        .addGap(0, 556, Short.MAX_VALUE)
                        .addComponent(verwijderLidButton))
                    .addGroup(verwijderenPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(verwijderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        verwijderenPanelLayout.setVerticalGroup(
            verwijderenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verwijderenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verwijderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(verwijderLidButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Verwijderen", verwijderenPanel);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void woonplaatsTekstveldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woonplaatsTekstveldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_woonplaatsTekstveldActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetVelden();
        statusTekstveld.setText("Invoervelden gewist");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void voegToeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voegToeButtonActionPerformed
        int jaar = jaarComboBox.getSelectedIndex() + 1900;
        int maand = maandComboBox.getSelectedIndex() + 1;
        int dag = dagComboBox.getSelectedIndex() + 1;
        if (isDatumGeldig(jaar, maand, dag)) {
            if (!naamTekstveld.getText().equals("") && !woonplaatsTekstveld.getText().equals("")) {
                voegLidToe(naamTekstveld.getText(), LocalDate.of(jaar, maand, dag), woonplaatsTekstveld.getText());
                statusTekstveld.setText("Lid succesvol toegevoegd");
            } else {
                statusTekstveld.setText("Geen lid toegevoegd");
            }
            updateElementen();
        } else {
            statusTekstveld.setText("Ongeldige datum ingevoerd");
        }
    }//GEN-LAST:event_voegToeButtonActionPerformed

    private void verwijderLidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verwijderLidButtonActionPerformed
        verwijderLid(verwijderComboBox.getSelectedIndex());
    }//GEN-LAST:event_verwijderLidButtonActionPerformed

    private void statusTekstveldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusTekstveldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusTekstveldActionPerformed

    private void bewaarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bewaarButtonActionPerformed
        bestandsbeheer.bestandOpslaan(lijst);
        statusTekstveld.setText("Bestand succesvol opgeslagen");
    }//GEN-LAST:event_bewaarButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        bestandsbeheer.bestandLaden();
        lijst = bestandsbeheer.getLijst();
        if (lijst.getSize() > 0) {
            statusTekstveld.setText("Bestand succesvol geopend");
        } else {
            statusTekstveld.setText("Bestand kon niet worden geopend");
        }
        updateElementen();
        resetVelden();
    }//GEN-LAST:event_openButtonActionPerformed

    private void sorteerOpNaamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sorteerOpNaamButtonActionPerformed
        sorteer();
    }//GEN-LAST:event_sorteerOpNaamButtonActionPerformed

    private void toonLedenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toonLedenButtonActionPerformed
        toonLedenlijst();
    }//GEN-LAST:event_toonLedenButtonActionPerformed

    private void wisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wisButtonActionPerformed
        wisLijst();
        updateElementen();
        statusTekstveld.setText("Lijst gewist");
    }//GEN-LAST:event_wisButtonActionPerformed

    private void bewerkNaamTekstveldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bewerkNaamTekstveldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bewerkNaamTekstveldActionPerformed

    private void verwijderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verwijderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verwijderComboBoxActionPerformed

    private void bewerkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bewerkComboBoxActionPerformed

    }//GEN-LAST:event_bewerkComboBoxActionPerformed

    private void bewerkComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bewerkComboBoxItemStateChanged

    }//GEN-LAST:event_bewerkComboBoxItemStateChanged

    private void bewerkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bewerkButtonActionPerformed
        bewerkLid(bewerkComboBox.getSelectedIndex());
    }//GEN-LAST:event_bewerkButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ledenadmingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ledenadmingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ledenadmingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ledenadmingui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ledenadmingui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bewaarButton;
    private javax.swing.JButton bewerkButton;
    private javax.swing.JComboBox<String> bewerkComboBox;
    private javax.swing.JLabel bewerkNaamLabel;
    private javax.swing.JTextField bewerkNaamTekstveld;
    private javax.swing.JLabel bewerkWoonplaatsLabel;
    private javax.swing.JTextField bewerkWoonplaatsTekstveld;
    private javax.swing.JPanel bewerkenPanel;
    private javax.swing.JComboBox<String> dagComboBox;
    private javax.swing.JLabel geboortedatumLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jaarComboBox;
    private javax.swing.JTextArea ledenlijstTekstGebied;
    private javax.swing.JComboBox<String> maandComboBox;
    private javax.swing.JLabel naamLabel;
    private javax.swing.JTextField naamTekstveld;
    private javax.swing.JButton openButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton sorteerOpNaamButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusTekstveld;
    private javax.swing.JPanel toevoegenPanel;
    private javax.swing.JButton toonLedenButton;
    private javax.swing.JComboBox<String> verwijderComboBox;
    private javax.swing.JButton verwijderLidButton;
    private javax.swing.JPanel verwijderenPanel;
    private javax.swing.JButton voegToeButton;
    private javax.swing.JButton wisButton;
    private javax.swing.JLabel woonplaatsLabel;
    private javax.swing.JTextField woonplaatsTekstveld;
    // End of variables declaration//GEN-END:variables

}
