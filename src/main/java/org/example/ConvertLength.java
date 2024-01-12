package org.example;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ConvertLength {
    private static final String EXIT_MESSAGE = "Exited";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input! Please enter a numeric value.";

    public enum LengthUnit {
        MM, CM, DM, M, KM, MIL, INCHES, FEET, YARDS, MILE
    }

    public void runConversion() {
        // Skapar en instans av ConvertLength-klassen
        ConvertLength converter = new ConvertLength();

        // En flagga som indikerar om konverteringen är klar
        boolean done = false;

        // En loop som fortsätter tills konverteringen är klar
        while (!done) {
            // Använder ConvertLength-instansen för att välja en längdenhet
            LengthUnit chosenUnit = converter.chooseLengthUnit();

            // Om användaren väljer att avsluta konverteringen
            if (chosenUnit == null) {
                // Visar ett meddelande om att programmet avslutas
                JOptionPane.showMessageDialog(null, EXIT_MESSAGE);

                // Sätter flaggan done till true för att avsluta loopen
                done = true;
            } else {
                // Konverterar och visar resultatet för den valda längdenheten
                converter.convertAndDisplay(chosenUnit);

                // Frågar användaren om de vill göra en annan konvertering
                // Om användaren väljer att inte göra en annan konvertering, sätts done till true
                done = !converter.askForAnotherConversion();
            }
        }
    }
    private LengthUnit chooseLengthUnit() {
        // Hämtar en array av alla möjliga längdenheter från enum LengthUnit
        LengthUnit[] lengthUnits = LengthUnit.values();

        // Skapar en JComboBox (rullista) med längdenheterna
        JComboBox<LengthUnit> comboBox = new JComboBox<>(lengthUnits);

        // Visar en dialogruta med rullistan och en OK/Cancel-knapp
        int option = JOptionPane.showConfirmDialog(null, comboBox, "Choose a Length Unit", JOptionPane.OK_CANCEL_OPTION);

        // Returnerar den valda längdenheten om användaren klickar på OK, annars returneras null
        return (option == JOptionPane.OK_OPTION) ? (LengthUnit) comboBox.getSelectedItem() : null;
    }


    private void convertAndDisplay(LengthUnit inputUnit) {
        // Hämtar användarens inmatade längdvärde
        double inputValue = getInput("Enter the length:");

        // Använder den tidigare förklarade metoden för att låta användaren välja en önskad längdenhet för resultatet
        LengthUnit outputUnit = chooseLengthUnit();

        // Om användaren väljer en giltig längdenhet
        if (outputUnit != null) {
            // Hämtar omvandlingsfaktorn mellan inputUnit och outputUnit
            double conversionFactor = getConversionFactor(inputUnit, outputUnit);

            // Utför själva konverteringen och får resultatet
            double result = convertLength(inputValue, conversionFactor);

            // Visar resultatet för användaren
            displayResult(result, outputUnit);
        }
    }


    private double getInput(String prompt) {
        // Visar en inmatningsdialogruta med det givna meddelandet (prompt)
        String input = JOptionPane.showInputDialog(null, prompt);

        // Använder en annan metod för att konvertera och hantera inmatningen
        return parseDoubleInput(input, prompt);
    }


    private double parseDoubleInput(String input, String prompt) {
        // Om användaren klickar på Avbryt i inmatningsdialogrutan
        if (input == null) {
            // Visar ett meddelande om att programmet avslutas och avslutar programmet
            JOptionPane.showMessageDialog(null, EXIT_MESSAGE);
            System.exit(0);
        }

        try {
            // Försöker konvertera inmatningen till en double efter att ha trimmat bort eventuella mellanslag
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            // Om det uppstår ett NumberFormatException (inmatningen är inte ett giltigt nummer)
            // Visar ett felmeddelande och ber användaren om ny inmatning genom att rekursivt anropa getInput-metoden
            JOptionPane.showMessageDialog(null, INVALID_INPUT_MESSAGE);
            return getInput(prompt);
        }
    }


    private double getConversionFactor(LengthUnit inputUnit, LengthUnit outputUnit) {
        // Använder en nästlad switch-sats för att matcha inputUnit och outputUnit och returnera rätt omvandlingsfaktor
        switch (inputUnit) {
            case MM:
                switch (outputUnit) {
                    case CM: return 0.1;
                    case DM: return 0.01;
                    case M: return 0.001;
                    case KM: return 0.000001;
                    case MIL: return 1.00e-7;
                    case INCHES: return 0.0394;
                    case FEET: return 0.00328;
                    case YARDS: return 0.00109;
                    case MILE: return 6.21e-7;
                }
                break;
            case CM:
                switch (outputUnit) {
                    case MM: return 10.0;
                    case DM: return 0.1;
                    case M: return 0.01;
                    case KM: return 0.00001;
                    case MIL: return 0.000001;
                    case INCHES: return 0.394;
                    case FEET: return 0.0328;
                    case YARDS: return 0.0109;
                    case MILE: return 0.0000062137;
                }
                break;
            case DM:
                switch (outputUnit) {
                    case MM: return 100.0;
                    case CM: return 10.0;
                    case M: return 0.1;
                    case KM: return 0.0001;
                    case MIL: return 0.00001;
                    case INCHES: return 3.94;
                    case FEET: return 0.328;
                    case YARDS: return 0.109;
                    case MILE: return 0.000062137;
                }
                break;
            case M:
                switch (outputUnit) {
                    case MM: return 1000.0;
                    case CM: return 100.0;
                    case DM: return 10.0;
                    case KM: return 0.001;
                    case MIL: return 0.0001;
                    case INCHES: return 39.37;
                    case FEET: return 3.28;
                    case YARDS: return 1.09;
                    case MILE: return 0.000621;
                }
                break;
            case KM:
                switch (outputUnit) {
                    case MM: return 1000000.0;
                    case CM: return 100000.0;
                    case DM: return 10000.0;
                    case M: return 1000.0;
                    case MIL: return 0.1;
                    case INCHES: return 39370.08;
                    case FEET: return 3280.84;
                    case YARDS: return 1093.61;
                    case MILE: return 0.621;
                }
                break;
            case MIL:
                switch (outputUnit) {
                    case MM: return 10000000.0;
                    case CM: return 1000000.0;
                    case DM: return 100000.0;
                    case M: return 10000.0;
                    case KM: return 10.0;
                    case INCHES: return 393700.79;
                    case FEET: return 32808.4;
                    case YARDS: return 10936.13;
                    case MILE: return 6.21;
                }
                break;
            case INCHES:
                switch (outputUnit) {
                    case MM: return 25.4;
                    case CM: return 2.54;
                    case DM: return 0.254;
                    case M: return 0.0254;
                    case KM: return 0.0000254;
                    case MIL: return 0.00000254;
                    case FEET: return 0.0833;
                    case YARDS: return 0.0278;
                    case MILE: return 0.0000158;
                }
                break;
            case FEET:
                switch (outputUnit) {
                    case MM: return 304.8;
                    case CM: return 30.48;
                    case DM: return 3.048;
                    case M: return 0.3048;
                    case KM: return 0.0003048;
                    case MIL: return 0.00003048;
                    case INCHES: return 12.0;
                    case YARDS: return 0.333;
                    case MILE: return 0.000189;
                }
                break;
            case YARDS:
                switch (outputUnit) {
                    case MM: return 914.4;
                    case CM: return 91.44;
                    case DM: return 9.144;
                    case M: return 0.9144;
                    case KM: return 0.0009144;
                    case MIL: return 0.00009144;
                    case INCHES: return 36.0;
                    case FEET: return 3.0;
                    case MILE: return 0.000568;
                }
                break;
            case MILE:
                switch (outputUnit) {
                    case MM: return 1609344.0;
                    case CM: return 160934.4;
                    case DM: return 16093.44;
                    case M: return 1609.344;
                    case KM: return 1.61;
                    case MIL: return 0.161;
                    case INCHES: return 63360.0;
                    case FEET: return 5280.0;
                    case YARDS: return 1760.0;
                }
                break;
        }
        return 1.0;
    }

    private double convertLength(double inputValue, double conversionFactor) {
        // Utför längdkonverteringen genom att multiplicera längdvärdet med omvandlingsfaktorn
        return inputValue * conversionFactor;
    }


    private void displayResult(double result, LengthUnit outputUnit) {
        // Visar en dialogruta med det beräknade resultatet och den valda längdenheten
        JOptionPane.showMessageDialog(null, "Result: " + result + " " + outputUnit);
    }


    private boolean askForAnotherConversion() {
        // Visar en bekräftelsedialogruta med alternativen "Ja" och "Nej"
        int response = JOptionPane.showConfirmDialog(null, "Do you want to convert another length?", "Confirmation", JOptionPane.YES_NO_OPTION);

        // Returnerar true om användaren väljer "Ja", annars false
        return response == JOptionPane.YES_OPTION;
    }

}