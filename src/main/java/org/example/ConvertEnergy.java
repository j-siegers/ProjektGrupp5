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
        System.out.println("Choose unit for the given value: ");
        System.out.println("1. Joule");
        System.out.println("2. Kilojoule");
        System.out.println("3. Kilokalori");
        System.out.println("4. Wattimme");
        System.out.println("5. Kilowattime");
        System.out.println("Choose desired unit:  ");

        // Här sparar vi användarens val av enhet
        int fromUnit = scanner.nextInt();

        System.out.println("Choose the unit you want to convert to: ");
        System.out.println("1. Joule");
        System.out.println("2. Kilojoule");
        System.out.println("3. Kilocalorie");
        System.out.println("4. Watt-hour");
        System.out.println("5. Kilowatt-hour");
        System.out.print("Choose your desired unit: ");
        int toUnit = scanner.nextInt();

        // Deklarera en variabel vid namn resultat
        double result = convertEnergy(amount, fromUnit, toUnit);

        System.out.println(amount + " units are equal to " + result + " in the chosen unit.");

        scanner.close();
    }

    private static double convertEnergy(double amount, int fromUnit, int toUnit) {
        double jouleAmount;
        // Här används en switch sats för att välja rätt konverteringsmetod

        switch (fromUnit) {
            case 1:
                jouleAmount = amount;
                break;
            case 2:
                jouleAmount = amount * 1000;
                break;
            case 3:
                jouleAmount = amount * 4184; // Konvertera Kilocalorie till Joule
                break;
            case 4:
                jouleAmount = amount * 3.6e6; // Konvertera Watt-timme till Joule
                break;
            case 5:
                jouleAmount = amount * 3.6e6 * 1000; // Convert from Kilowatt-hour to Joule
                break;
            default:
                throw new IllegalArgumentException("Invalid current unit choice. Please choose 1, 2, 3, 4, or 5.");
        }

        switch (toUnit) {
            case 1:
                return jouleAmount;
            case 2:
                return jouleAmount / 1000; // Konvertera Joule till kilojoule
            case 3:
                return jouleAmount / 4184; // Convert from Joule to Kilocalorie
            case 4:
                return jouleAmount / 3.6e6; // Convert from Joule to Watt-hour
            case 5:
                return jouleAmount / (3.6e6 * 1000); // Convert from Joule to Kilowatt-hour
            default:
                throw new IllegalArgumentException("Invalid desired unit choice. Please choose 1, 2, 3, 4, or 5.");
        }
    }
}