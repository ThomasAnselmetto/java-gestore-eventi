package org.lessons.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        aggiungo le dichiarazioni necessarie per poi avere i vari scope dovuti ai cicli e ai try catch


        Evento evento1;
        LocalDate dataFormattata;
        String nomeEvento;
        int postiEvento = 0;
        boolean dataIsValid = false;

//        adesso se c'e un errore nella compilazione torna indietro almeno'
        while(!dataIsValid){

                try {
                    System.out.println("Inserisci il nome dell'evento: ");
                    nomeEvento = scanner.nextLine();
                    System.out.println("L'evento creato è " + nomeEvento);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                System.out.println("--------------------------------");

                try {
                    System.out.println("Inserisci la data nel seguente formato: gg/mm/aaaa ");
                    String dateUser = scanner.nextLine();
                    dataFormattata = LocalDate.parse(dateUser, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("La data dell'evento è " + dataFormattata);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                System.out.println("--------------------------------");

                try {
                    System.out.println("Inserisci il numero di posti totali: (il massimo per il forum è 12700)");
                    postiEvento = Integer.parseInt(scanner.nextLine());
                    System.out.println("Il numero selezionato di posti è " + postiEvento);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("--------------------------------");

                evento1 = new Evento(nomeEvento, dataFormattata, postiEvento);

                System.out.println("Perfetto hai creato un nuovo evento denominato: " + nomeEvento + "\n" + "sarà in data: " + dataFormattata + "\n" + "Ed il palazzetto avrà una capienza massima di: " + postiEvento + " Spettatori");
                dataIsValid = true;


        System.out.println("--------------------------------");

        System.out.println("vuoi effettuare una prenotazione o una cancellazione? Y/N");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("y")){
            System.out.println("Al momento i posti disponibili sono " + postiEvento + " Affrettati");
            dataIsValid = false;
            while (!dataIsValid) {
                System.out.println("quanti biglietti vuoi prenotare?");
                try {
                    int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());
                    if (numeroPrenotazioni != 0)
                        for (int i = 0; i < numeroPrenotazioni; i++) {
                            evento1.prenota(numeroPrenotazioni);
                        }
                    dataIsValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Riscontrato un errore");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Al momento i posti disponibili sono " + evento1.postiDisponibili());

            dataIsValid = false;

            while (!dataIsValid) {
                System.out.println("quante prenotazioni di biglietti vuoi cancellare?");
                try {
                    int numerocancellazioni = Integer.parseInt(scanner.nextLine());
                    if (numerocancellazioni != 0)
                        for (int i = 0; i < numerocancellazioni; i++) {
                            evento1.disdici(numerocancellazioni);
                        }
                    dataIsValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Riscontrato un errore");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Al momento i posti disponibili sono " + evento1.postiDisponibili());

        } else if (confirm.equalsIgnoreCase("n")) {
            System.out.println("Alla Prossima!!!");
        }


        scanner.close();
    }
}}
