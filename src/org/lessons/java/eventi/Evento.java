package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    //FIELDS
//    intellij suggerisce final
    private final String titolo;
    private final LocalDate data;
    private  int postiASedereTotali;
    private  int numeroPrenotatiTotali;

    //CONSTRUCTOR
    public Evento(String titolo, LocalDate data, int postiASedereTotali) {
        if (titolo == null || titolo.isEmpty()) {
            throw new RuntimeException("Il titolo è obbligatorio");
        }
        this.titolo = titolo;

        if (data.isBefore(LocalDate.now())) {
            throw new RuntimeException("La data inserita è già passata");
        }
        this.data = data;

        if (postiASedereTotali <= 0 || postiASedereTotali > 12700) {
            throw new RuntimeException("Devi inserire un numero di posti valido (1-12700)");
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
    public void prenota(int numeroPrenotazioni) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Hai cercato di prenotare un evento già concluso");
        }
        if (numeroPrenotatiTotali >= postiASedereTotali) {
            throw new IllegalStateException("Non ci sono abbastanza biglietti disponibili per soddisfare la tua richiesta");
        }
        numeroPrenotatiTotali++;
    }

    public void disdici(int numerocancellazioni) {
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

//    @Override
//    public String toString(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
//        String dataFormattata = getData().format(formatter);
//        return dataFormattata + "-" + getTitolo();
//    }
}
