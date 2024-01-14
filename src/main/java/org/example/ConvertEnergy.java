package org.example;

import java.util.Scanner;

public class ConvertEnergy {

    public static void main(String[] args) {
        // Här skapas en Scanner för att läsa användarens input
        Scanner scanner = new Scanner(System.in);

        // Skriver ut välkomsttexten och instruktionerna för användaren
        System.out.println("Energy Converter");
        System.out.print("Enter energy amount: ");
        // Här läser vi in ett flyttal (double) från användaren som sedan lagras
        double amount = scanner.nextDouble();

        // Presenterar de olika enheterna för energin som användaren kan välja
        System.out.println("Choose unit for the given value");
        System.out.println("1. Joule");
        System.out.println("2. Kilojoule");
        System.out.println("3. Kilokalori");
        System.out.println("4. Wattimme");
        System.out.println("5. Kilowattime");
        System.out.println("Choose desired unit: ");

        // Här sparar vi användarens val av enhet
        int choice = scanner.nextInt();

        // Deklarera en variabel vid namn resultat
        double result;

        // Här används en switch sats för att välja rätt konverteringsmetod

        switch (choice) {
            case 1:
                result = convertToJoule(amount);
                System.out.println(amount + " enheter är lika med " + result + " Joule. ");
                break;
            case 2:
                result = convertToKilojoule(amount);
                System.out.println(amount + " enheter är lika med " + result + " Kilojoule.");
                break;
        }

        // Här stänger vi vår scanner
        scanner.close();
    }

    public static double convertToJoule(double amount) {
        return amount;
    }

    public static double convertToKilojoule(double amount) {
        // Implementerar konvertering för kilojoule
        return amount;
    }
}
