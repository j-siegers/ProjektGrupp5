package org.example;

import javax.swing.*;

public class ConvertEnergy {

    public void runConversion() {

        // Läs användarens inmatning som en sträng och använder J0ptionPane för att visa en input dialog
        String amountStr = JOptionPane.showInputDialog("Ange energimängd:");
        double amount = Double.parseDouble(amountStr);

        // Visa lista över energienheter och låt användaren välja med dropdown-lista
        String[] fromOptions = {"Joule", "Kilojoule", "Kilokalorie", "Watt-timmar", "Kilowatt-timmar"};
        String fromUnit = (String) JOptionPane.showInputDialog(null, "Välj enheten för den angivna värden:", "Välj enhet",
                JOptionPane.QUESTION_MESSAGE, null, fromOptions, fromOptions[0]);

        // Visa lista över enheter att konvertera till och låt användaren välja med dropdown-lista
        String[] toOptions = {"Joule", "Kilojoule", "Kilokalorie", "Watt-timmar", "Kilowatt-timmar"};
        String toUnit = (String) JOptionPane.showInputDialog(null, "Välj enheten du vill konvertera till:", "Välj enhet",
                JOptionPane.QUESTION_MESSAGE, null, toOptions, toOptions[0]);

        // Beräkna konverteringsfaktorn
        double conversionFactor = getConversionFactor(getUnitIndex(fromUnit), getUnitIndex(toUnit));

        // Beräknar den omvandlade energin
        double convertedEnergy = amount * conversionFactor;

        // Formatera resultatet och begränsa antalet decimaler för att göra det mer lättläst
        String formattedResult = String.format("%.3f", convertedEnergy);

        // Visa den omvandlade energin i en dialogruta med inkluderade kommentarer som säger vilka enheter som använts
        JOptionPane.showMessageDialog(null, amount + " " + fromUnit + " is equal to " + formattedResult + " " + toUnit + ".");
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
                    case 5: return 0.0000002778; // Joule till Kilowatt-timme
                }
                break;

            case 2: // Kilojoule
                switch (toUnit) {
                    case 1: return 1000.0; // Kilojoule till Joule
                    case 2: return 1.0; // Kilojoule till Kilojoule
                    case 3: return 0.239006; // Kilojoule till Kilokalori
                    case 4: return 0.277778; // Kilojoule till Watt-timme
                    case 5: return 0.0002777778; // Kilojoule till Kilowatt-timme
                }
                break;

            case 3: // Kilokalori
                switch (toUnit) {
                    case 1: return 4184.0; // Kilokalori till Joule
                    case 2: return 4.184; // Kilokalori till Kilojoule
                    case 3: return 1.0; // Kilokalori till Kilokalori
                    case 4: return 1.162222; // Kilokalori till Watt-timme
                    case 5: return 0.001162; // Kilokalori till kilowatt-timme
                }
                break;

            case 4: // Watt-timme
                switch (toUnit) {
                    case 1: return 3600; // watt-timme till Joule
                    case 2: return 3.6; // watt-timme till Kilojoule
                    case 3: return 0.00036; // Watt-timme till Kilokalori
                    case 4: return 1.0; // watt-timme till watt-timme
                    case 5: return 0.001; // Watt-timme till Kilowatt-timme
                }
                break;

            case 5: // Kilowatt-timme
                switch (toUnit) {
                    case 1: return 3600000.0; // Kilowatt-timme till Joule
                    case 2: return 3600.0; // Kilowatt-timme till Kilojoule
                    case 3: return 860.4; // Kilowatt-timme till Kilokalori
                    case 4: return 86000.0; // Kilowatt-timme till Watt-timme
                    case 5: return 1.0; // Kilowatt-timme till Kilowatt-timme
                }
                break;
        }
        // Default case
        return 1.0;
    }

    // Hjälpmetod för att hämta index för en enhet
    private static int getUnitIndex(String unit) {
        return switch (unit) {
            case "Joule" -> 1;
            case "Kilojoule" -> 2;
            case "Kilokalorie" -> 3;
            case "Watt-timmar" -> 4;
            case "Kilowatt-timmar" -> 5;
            default -> 1;
        };
    }
}
