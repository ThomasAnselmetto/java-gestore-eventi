package org.lessons.java.eventi;


import java.time.DateTimeException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class Evento {
    //FIELDS
    private String titolo;
    private LocalDate data;
    private int postiASedereTotali;
    private int numeroPrenotati;


    //CONSTRUCTOR

    public Evento(String titolo, LocalDate data, int postiASedereTotali) {
        this.titolo = titolo;
        setData(data);
        this.postiASedereTotali = postiASedereTotali;
        this.numeroPrenotati = 0;

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
        return numeroPrenotati;
    }


    // SETTERS

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    //    La data dell'evento non deve essere passata'
    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())){
            throw new DateTimeException ("La data inserita e' gia' passata");
        }
        this.data = data;
    }
//    I posti a sedere devono essere (esempio forum assago) piu' di 0 e meno di 12700'
    public void setPostiASedereTotali(){
    if (postiASedereTotali <= 0){
        throw new RuntimeException("Il numero di posti deve essere positivo!");
    }
    if (postiASedereTotali > 12700){
        throw new RuntimeException("Il numero massimo di posti del forum e' 12700");
    }
    }

    //METHODS

//    La prenotazione deve agg. uno o piu'(questo se riesco) alle prenotazioni e lanciare eccezioni se evento passato o finiti i posti,tentato if (!setData(LocalDate data) ma non funziona
    public int prenota(){
        if (data.isBefore(LocalDate.now())){
            throw new DateTimeException("Hai cercato di prenotare un Evento gia' concluso");
        }
        if(postiPrenotati > postiDisponibili()){
            throw new RuntimeException("Non ci sono abbastanza biglietti disponibili per soddisfare la tua richiesta")
        }

    return numeroPrenotati++;
    }
//
    public int disdici(){
    if (data.isBefore(LocalDate.now())){
        throw new DateTimeException("Hai cercato di prenotare un Evento gia' concluso");
    }
    if (numeroPrenotati <= 0){
        throw new RuntimeException("Nessuna Prenotazione registrata")
    }
    return numeroPrenotati--;
    }



//    public int postiDisponibili(){
//        return postiASedereTotali - postiPrenotati;
//    }



    @Override
    public String toString() {
        return "Evento del :{" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy,")) +
                "dal titolo='" + titolo + '\'' +
                '}';
    }
}
