package org.example;

import java.util.Scanner;

/**
 * -Fixa alla konverterings faktorer
 * -Skriv tester
 * -Implementera dialogrutor istället för att köra allt i konsol
 * -Möjligtsvis hitta annat alternativ för att lagra konverteringarna för en mindre klottrad och upprepande kod
 */

public class ConvertEnergy {

    public static void main(String[] args) {
        // Skapa en Scanner-objekt för användarinmatning
        Scanner scanner = new Scanner(System.in);

        // Skriv ut välkomstmeddelande och instruktioner för användaren
        System.out.println("Energieomvandlare");
        System.out.print("Ange energimängd: ");

        // Läs användarens inmatning, vilket i detta fall är en double
        double amount = scanner.nextDouble();

        // Visa en lista över tillgängliga energienheter till användaren
        System.out.println("Välj enheten för den angivna värden: ");
        System.out.println("1. Joule");
        System.out.println("2. Kilojoule");
        System.out.println("3. Kilokalorie");
        System.out.println("4. Watt-timmar");
        System.out.println("5. Kilowatt-timmar");
        System.out.print("Välj önskad enhet: ");

        // Hämta användarens val
        int fromUnit = scanner.nextInt();

        // Visa en lista över enheter att konvertera till
        System.out.println("Välj enheten du vill konvertera till: ");
        System.out.println("1. Joule");
        System.out.println("2. Kilojoule");
        System.out.println("3. Kilokalorie");
        System.out.println("4. Watt-timmar");
        System.out.println("5. Kilowatt-timmar");
        System.out.print("Välj din önskade enhet: ");

        // Hämta användarens val
        int toUnit = scanner.nextInt();

        // Beräkna konverteringsfaktorn
        double conversionFactor = getConversionFactor(fromUnit, toUnit);

        // Beräkna den omvandlade energin
        double convertedEnergy = amount * conversionFactor;

        // Visa den omvandlade energin
        System.out.println(amount + " enheter är lika med " + convertedEnergy + " i den valda enheten.");

        scanner.close();
    }

    // Privat metod för att hämta konverteringsfaktorn mellan två enheter
    private static double getConversionFactor(int fromUnit, int toUnit) {
        switch (fromUnit) {
            case 1: // Joule
                switch (toUnit) {
                    case 1: return 1.0; // Joule till Joule
                    case 2: return 0.001; // Joule till Kilojoule
                    case 3: return 0.000239; // Joule till Kilokalori
                    case 4: return 0.0002778; // Joule till Watt-timme
                    case 5: return 0.00002778; // Joule till Kilowatt-timme
                }
                break;

            case 2: // Kilojoule
                switch (toUnit) {
                    case 1: return 1000.0; // Kilojoule till Joule
                    case 2: return 1.0; // Kilojoule till Kilojoule
                    case 3: return 239.0; // Kilojoule till Kilokalori
                    case 4: return 2778.0; // Kilojoule till Watt-timme
                    case 5: return 277.8; // Kilojoule till Kilowatt-timme
                }
                break;

            case 3: // Kilokalori
                switch (toUnit) {
                    case 1: return 4184.0; // Kilokalori till Joule
                    case 2: return 4.184; // Kilokalori till Kilojoule
                    case 3: return 1.0; // Kilokalori till Kilokalori
                    case 4: return 4.184; // Kilokalori till Watt-timme
                }
                break;

            case 4: // Watt-hour
                switch (toUnit) {
                    case 3: return 0.00036; // Watt-timme till Kilokalori
                    case 5: return 0.001; // Watt-timme till Kilowatt-timme
                }
                break;

            case 5: // Kilowatt-hour
                switch (toUnit) {
                    case 1: return 3600000.0; // Kilowatt-timme till Joule
                    case 2: return 3600.0; // Kilowatt-timme till Kilojoule
                    case 3: return 860.0; // Kilowatt-timme till Kilokalori
                    case 4: return 86000.0; // Kilowatt-timme till Watt-timme
                    case 5: return 860.0; // Kilowatt-timme till Kilowatt-timme
                }
                break;
        }

        // Default case
        return 1.0;
    }
}
