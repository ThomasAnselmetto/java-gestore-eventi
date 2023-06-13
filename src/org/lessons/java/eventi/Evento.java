package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())){
            throw new RuntimeException ("Hai cercato di prenotare un Evento gia' concluso");
        }

        this.data = data;
    }

    //METHODS
    public int prenota(){

    }

    public int disdici(){

    }




    @Override
    public String toString() {
        return "Evento del :{" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy,")) +
                "dal titolo='" + titolo + '\'' +
                '}';
    }
}
