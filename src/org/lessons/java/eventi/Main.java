package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        aggiungo le dichiarazioni necessarie per poi avere i vari scope dovuti ai cicli e ai try catch

//        francesco dice che ci stiamo complicando la vita 3 sec dopo che sono impazzito per creare il ciclo while
        Evento evento1 = null;
        LocalDate dataFormattata = null;
        String nomeEvento = null;
        int postiEvento = 0;
        boolean inputCorretto = false;

        while (!inputCorretto) {
            try {
                System.out.println("Inserisci il nome dell'evento: ");
                nomeEvento = scanner.nextLine();
                System.out.println("L'evento creato è " + nomeEvento);

                System.out.println("--------------------------------");

                System.out.println("Inserisci la data nel seguente formato: gg/mm/aaaa ");
                String dateUser = scanner.nextLine();
                dataFormattata = LocalDate.parse(dateUser, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println("La data dell'evento è " + dataFormattata);

                System.out.println("--------------------------------");

                System.out.println("Inserisci il numero di posti totali: (il massimo per il forum è 12700)");
                postiEvento = Integer.parseInt(scanner.nextLine());
                System.out.println("Il numero selezionato di posti è " + postiEvento);

                System.out.println("--------------------------------");

                evento1 = new Evento(nomeEvento, dataFormattata, postiEvento);

                inputCorretto = true; // L'input è corretto, esci dal loop
            } catch (RuntimeException e) {
                System.out.println("Errore nell'inserimento dei dati. Riprova.");
            }
        }

        System.out.println("Perfetto hai creato un nuovo evento denominato: " + nomeEvento + "\n" + "sarà in data: " + dataFormattata + "\n" + "Ed il palazzetto avrà una capienza massima di: " + postiEvento + " Spettatori");

        scanner.close();
    }
}
