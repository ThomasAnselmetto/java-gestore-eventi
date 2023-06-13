package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, LocalDate data, int postiASedereTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, postiASedereTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String dataFormatter() {
        return this.ora.format(DateTimeFormatter.ofPattern("yyyy/MM/dd - hh:mm"));
    }

    public String prezzoFormatter() {
        DecimalFormat przformat = new DecimalFormat("#,###,00€");
        return przformat.format(prezzo);
    }

//    @Override
//    public String toString() {
//        return "Concerto{" +
//                "ora=" + ora +
//                ", prezzo=" + prezzo +
//                '}';
//    }
}
