package org.example;
import javax.swing.*;

public class ConvertArea {
    public void runConversion() {
        double inputAmount;

        // Alternativ i dropdown meny
        String[] areaChoice = {"cm²", "dm²", "m²", "km²"};

        // Från - Dropdown-lista
        String inputFrom = showInputDialog("Area", "Från:", areaChoice);

        // Till - Dropdown-lista
        String inputTo = showInputDialog("Area", "Till:", areaChoice);

        // Ange tal som ska konverteras
        String inputAmountStr = showInputDialog("Tal");
        try {
            inputAmount = Double.parseDouble(inputAmountStr);       // talet typomvandlas från sträng till double
        } catch (NumberFormatException e) {
            showMessageDialog("Fel. Ange ett tal", "Fel", JOptionPane.ERROR_MESSAGE); // Om användaren skriver något som ej går att omvandlas till double.
            return;
        }

        // Skapar en instans av klassen ConvertArea för att använda convert-metoden
        ConvertArea doConversion = new ConvertArea();
        double result = doConversion.convert(inputFrom, inputTo, inputAmount
        );

        // Presenterar resultatet.
        JOptionPane.showMessageDialog(
                null, inputAmount + inputFrom + " är " + result + inputTo, "Resultat", JOptionPane.INFORMATION_MESSAGE);
    }


    // --Metoder för Dialogrutor
    // privata klasser, gör så att de endast fungerar innuti denna klass
    private String showInputDialog(String title, String message, String[] options) {
        return (String) JOptionPane.showInputDialog(
                null, message, title, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }

    private String showInputDialog(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    private void showMessageDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }


    // --Metod för att göra okoovertering, baserat på användarens val.
    public double convert(String inputFrom, String inputTo, double inputAmount) {
        // Logik för omvnadling
        double result = inputAmount;                    // Här lagras resultatet från omvandlingen, skriver över med det nya värdet.

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


    // Kör programmet för sig självt, alltså utan Main klassen
    public static void main(String[] args){
        ConvertArea runProgram = new ConvertArea();
        runProgram.runConversion();
    }
}