package org.example;
import javax.swing.*;

public class ConvertArea {
    // kör programmet, anropar de andra metoderna
    public void runConversion() {
        double inputAmount;

        // Alternativ i dropdown meny
        String[] areaChoice = {"cm²", "dm²", "m²", "km²"};
        // Från - Dropdown-lista
        String inputFrom = inputDialog("Från: ", areaChoice);
        // Till - Dropdown-lista
        String inputTo = inputDialog("Till: ", areaChoice);

        // Ange tal som ska konverteras
        String inputAmountStr = JOptionPane.showInputDialog("Tal");
        try {
            inputAmount = Double.parseDouble(inputAmountStr);       // talet typomvandlas från sträng till double
        } catch (NumberFormatException e) {                         // Om användaren skriver något som ej går att omvandlas till double.
            JOptionPane.showMessageDialog(null,
                    "Fel. Ange ett tal", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // anropar metoden med användarens val som argument
        double result = convert(inputFrom, inputTo, inputAmount);

        // Presenterar resultatet.
        JOptionPane.showMessageDialog(
                null, inputAmount + inputFrom + " är " + result + inputTo, "Resultat", JOptionPane.INFORMATION_MESSAGE);
    }



    // Metoden skapar en dialiogruta med lista av alternativ
    public String inputDialog(String message, String[] options) {
        return (String) JOptionPane.showInputDialog(
                null, message, "Area", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    // --Metod för att göra konvertering, baserat på användarens val.
    public double convert(String inputFrom, String inputTo, double inputAmount) {
        // Logik för omvnadling
        double result = inputAmount;                    // Här lagras resultatet från omvandlingen

        switch (inputFrom) {                            // Det användaren valt att konvertera FRÅN
            case "cm²":                                 // Om användaren valt FRÅN cm²
                switch (inputTo) {                      // Vad användaren vill konvertera TILL
                    case "cm²" -> result *= 1.0;        // utförs en beräkning beroende på vad användaren vill kovnertera TILL
                    case "dm²" -> result *= 0.01;       // konverteringsfaktorer
                    case "m²" -> result *= 0.0001;
                    case "km²" -> result *= 1.0e-10;
                }
                break;
            case "dm²":
                switch (inputTo) {
                    case "cm²" -> result *= 100.0;
                    case "dm²" -> result *= 1.0;
                    case "m²" -> result *= 0.01;
                    case "km²" -> result *= 1.0e-8;
                }
                break;
            case "m²":
                switch (inputTo) {
                    case "cm²" -> result *= 10000.0;
                    case "dm²" -> result *= 100.0;
                    case "m²" -> result *= 1.0;
                    case "km²" -> result *= 1.0e-6;
                }
                break;
            case "km²":
                switch (inputTo) {
                    case "cm²" -> result *= 1.0e10;
                    case "dm²" -> result *= 1.0e8;
                    case "m²" -> result *= 1.0e6;
                    case "km²" -> result *= 1.0;
                }
                break;
        }
        return result;
    }
}