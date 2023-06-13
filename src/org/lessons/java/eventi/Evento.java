package org.lessons.java.eventi;

import java.time.LocalDate;

public class Evento {
    //FIELDS
    private String titolo;
    private LocalDate data;
    private int postiASedereTotali;
    private int numeroPrenotatiTotali;

    //CONSTRUCTOR
    public Evento(String titolo, LocalDate data, int postiASedereTotali) {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Il titolo è obbligatorio");
        }
        this.titolo = titolo;

        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data inserita è già passata");
        }
        this.data = data;

        if (postiASedereTotali <= 0 || postiASedereTotali > 12700) {
            throw new IllegalArgumentException("Devi inserire un numero di posti valido (1-12700)");
        }
        this.postiASedereTotali = postiASedereTotali;

        this.numeroPrenotatiTotali = 0;
    }

    //GETTERS
    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getPostiASedereTotali() {
        return postiASedereTotali;
    }

    public int getNumeroPrenotati() {
        return numeroPrenotatiTotali;
    }

    //METHODS
    public void prenota() {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Hai cercato di prenotare un evento già concluso");
        }
        if (numeroPrenotatiTotali >= postiASedereTotali) {
            throw new IllegalStateException("Non ci sono abbastanza biglietti disponibili per soddisfare la tua richiesta");
        }
        numeroPrenotatiTotali++;
    }

    public void disdici() {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Hai cercato di disdire un evento già concluso");
        }
        if (numeroPrenotatiTotali <= 0) {
            throw new IllegalStateException("Nessuna prenotazione registrata");
        }
        numeroPrenotatiTotali--;
    }

    public int postiDisponibili() {
        return postiASedereTotali - numeroPrenotatiTotali;
    }

    @Override
    public String toString() {
        return "Evento del: " + data + ", dal titolo: '" + titolo + "'";
    }
}
