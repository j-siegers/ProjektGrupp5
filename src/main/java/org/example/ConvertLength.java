package org.example;

import javax.swing.JOptionPane;
import java.util.Locale;

/**
 * Ändra utseendet i Return rutan. Det ska stå vad du har konverterat från och till inte bara till.
 * Skriv tester
 */

public class ConvertLength {
    public enum LengthUnit {
        Millimeter, Centimeter, Decimeter, Meter, Kilometer, Mil, Inch, Feet, Yard, Mile
    }

    public void runConversion() {
        ConvertLength converter = new ConvertLength();
        boolean done = false;
        while (!done) {
            LengthUnit chosenUnit = converter.chooseLengthUnit();

            if (chosenUnit == null) {
                done = true;
            } else {
                converter.convertAndDisplay(chosenUnit);
                done = !converter.askForAnotherConversion();
            }
        }
    }

    private LengthUnit chooseLengthUnit() {
        LengthUnit[] lengthUnits = LengthUnit.values();
        Object userInput = JOptionPane.showInputDialog(null, "Choose a Length Unit:", "Length Unit", JOptionPane.PLAIN_MESSAGE, null, lengthUnits, lengthUnits[0]);
        return (LengthUnit) userInput;
    }

    private double getInput(String prompt) {
        String input = JOptionPane.showInputDialog(null, prompt);
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a numeric value.");
            return getInput(prompt);
        }
    }

    private void convertAndDisplay(LengthUnit inputUnit) {
        double inputValue = getInput("Enter the length:");
        LengthUnit outputUnit = chooseLengthUnit();

        if (outputUnit != null) {
            double conversionFactor = getConversionFactor(inputUnit, outputUnit);
            double result = performConversion(inputValue, conversionFactor);
            displayConversionResult(result, inputUnit, inputValue, outputUnit);
        }

    }

    private double performConversion(double inputValue, double conversionFactor) {
        return inputValue * conversionFactor;
    }

    private void displayConversionResult(double result, LengthUnit inputUnit, double inputValue, LengthUnit outputUnit) {
        String formattedResult = String.format(Locale.US, "%.2f", result);
        String formattedInputValue = String.format(Locale.US, "%.2f", inputValue);
        JOptionPane.showMessageDialog(null, "Converted: " + formattedInputValue + " " + inputUnit + " to " + formattedResult + " " + outputUnit, "Conversion Result", JOptionPane.INFORMATION_MESSAGE);
    }

    private double getConversionFactor(LengthUnit inputUnit, LengthUnit outputUnit) {
        switch (inputUnit) {
            case Millimeter:
                switch (outputUnit) {
                    case Centimeter: return 0.1;
                    case Decimeter: return 0.01;
                    case Meter: return 0.001;
                    case Kilometer: return 0.000001;
                    case Mil: return 1.00e-7;
                    case Inch: return 0.0394;
                    case Feet: return 0.00328;
                    case Yard: return 0.00109;
                    case Mile: return 6.21e-7;
                }
                break;
            case Centimeter:
                switch (outputUnit) {
                    case Millimeter: return 10.0;
                    case Decimeter: return 0.1;
                    case Meter: return 0.01;
                    case Kilometer: return 0.00001;
                    case Mil: return 0.000001;
                    case Inch: return 0.394;
                    case Feet: return 0.0328;
                    case Yard: return 0.0109;
                    case Mile: return 0.0000062137;
                }
                break;
            case Decimeter:
                switch (outputUnit) {
                    case Millimeter: return 100.0;
                    case Centimeter: return 10.0;
                    case Meter: return 0.1;
                    case Kilometer: return 0.0001;
                    case Mil: return 0.00001;
                    case Inch: return 3.94;
                    case Feet: return 0.328;
                    case Yard: return 0.109;
                    case Mile: return 0.000062137;
                }
                break;
            case Meter:
                switch (outputUnit) {
                    case Millimeter: return 1000.0;
                    case Centimeter: return 100.0;
                    case Decimeter: return 10.0;
                    case Kilometer: return 0.001;
                    case Mil: return 0.0001;
                    case Inch: return 39.37;
                    case Feet: return 3.28;
                    case Yard: return 1.09;
                    case Mile: return 0.000621;
                }
                break;
            case Kilometer:
                switch (outputUnit) {
                    case Millimeter: return 1000000.0;
                    case Centimeter: return 100000.0;
                    case Decimeter: return 10000.0;
                    case Meter: return 1000.0;
                    case Mil: return 0.1;
                    case Inch: return 39370.08;
                    case Feet: return 3280.84;
                    case Yard: return 1093.61;
                    case Mile: return 0.621;
                }
                break;
            case Mil:
                switch (outputUnit) {
                    case Millimeter: return 10000000.0;
                    case Centimeter: return 1000000.0;
                    case Decimeter: return 100000.0;
                    case Meter: return 10000.0;
                    case Kilometer: return 10.0;
                    case Inch: return 393700.79;
                    case Feet: return 32808.4;
                    case Yard: return 10936.13;
                    case Mile: return 6.21;
                }
                break;
            case Inch:
                switch (outputUnit) {
                    case Millimeter: return 25.4;
                    case Centimeter: return 2.54;
                    case Decimeter: return 0.254;
                    case Meter: return 0.0254;
                    case Kilometer: return 0.0000254;
                    case Mil: return 0.00000254;
                    case Feet: return 0.0833;
                    case Yard: return 0.0278;
                    case Mile: return 0.0000158;
                }
                break;
            case Feet:
                switch (outputUnit) {
                    case Millimeter: return 304.8;
                    case Centimeter: return 30.48;
                    case Decimeter: return 3.048;
                    case Meter: return 0.3048;
                    case Kilometer: return 0.0003048;
                    case Mil: return 0.00003048;
                    case Inch: return 12.0;
                    case Yard: return 0.333;
                    case Mile: return 0.000189;
                }
                break;
            case Yard:
                switch (outputUnit) {
                    case Millimeter: return 914.4;
                    case Centimeter: return 91.44;
                    case Decimeter: return 9.144;
                    case Meter: return 0.9144;
                    case Kilometer: return 0.0009144;
                    case Mil: return 0.00009144;
                    case Inch: return 36.0;
                    case Feet: return 3.0;
                    case Mile: return 0.000568;
                }
                break;
            case Mile:
                switch (outputUnit) {
                    case Millimeter: return 1609344.0;
                    case Centimeter: return 160934.4;
                    case Decimeter: return 16093.44;
                    case Meter: return 1609.344;
                    case Kilometer: return 1.61;
                    case Mil: return 0.161;
                    case Inch: return 63360.0;
                    case Feet: return 5280.0;
                    case Yard: return 1760.0;
                }
                break;
        }
        return 1;
    }

    private boolean askForAnotherConversion() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to convert another length?", "Confirmation", JOptionPane.YES_NO_OPTION);
        return response == JOptionPane.YES_OPTION;
    }
}