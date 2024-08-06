package clientcode;

import data.airport.model.*;

import java.util.Scanner;

public class Airport {
    private static final Scanner scanner = new Scanner(System.in);
    private final FlightDataCollection collection = new FlightDataCollection();
    private final BoardingTotem boardingTotem = new BoardingTotem(collection);
    private final LandingTotem landingTotem = new LandingTotem(collection);
    private final BoardingLandingTotem boardingLandingTotem = new BoardingLandingTotem(boardingTotem, landingTotem);

    public void run() {
        int option;
        do{
            System.out.println("1 - Novo voo");
            System.out.println("2 - Alterar estado");
            System.out.println("3 - Lista de Voos");
            System.out.println("4 - Lista de voos que irão decolar");
            System.out.println("5 - Lista de voos que irão aterrisar");
            System.out.println("6 - Lista de voos que irão aterrisar e decolar");
            System.out.println("0 - Encerrar");
            System.out.println("Opção: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    collection.insertFlight(readFlight());
                    System.out.println("Voo adicionado.");
                    break;

                case 2:
                    updateFlight();
                    break;

                case 3:
                    for (FlightData flight : collection.allFlights()){
                        System.out.println(flight);
                    }
                    break;

                case 4:
                    System.out.println(boardingTotem);
                    break;

                case 5:
                    System.out.println(landingTotem);
                    break;

                case 6:
                    System.out.println(boardingLandingTotem);
                    break;

                default:
                    System.out.println("Aeroporto fechado!");
                    break;
            }
        }while (option != 0);
    }

    private void updateFlight(){
        Long number;
        System.out.println("Número do voo: ");
        number = scanner.nextLong();
        collection.updateFlight(number);
        System.out.println("Estado do voo editado.");
    }

    private FlightData readFlight(){
        Long number;
        String company;
        String time;

        System.out.println("Número do voo.: ");
        number = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Companhia.....: ");
        company = scanner.nextLine();
        System.out.println("Horário.......: ");
        time = scanner.nextLine();

        return new FlightData(number, company, time);
    }

    public static void main(String[] args) {
        new Airport().run();
    }
}
