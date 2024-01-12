package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertLength {
    private BufferedReader br;

    public enum LengthUnit {
        MM, CM, DM , M, KM, MIL, INCHES, FEET, YARDS, MILE
    }

    public static void main(String[] args) throws IOException {
        ConvertLength converter = new ConvertLength();
        converter.br = new BufferedReader(new InputStreamReader(System.in));

        boolean done = false;
        while (!done) {
            int choice = converter.runMenu();
            if (choice == LengthUnit.values().length + 1) {
                System.out.println("Exited");
                done = true;
            } else {
                converter.convertAndDisplay(choice);

                System.out.print("Do you want to convert another length? (y/n): ");
                String answer = converter.br.readLine().trim().toLowerCase();
                if (!answer.equals("y")) {
                    done = true;
                }
            }
        }
    }
    public int runMenu() throws IOException {
        System.out.println("=========================");
        System.out.println("Length Conversion Table");

        int optionNumber = 1;
        for (LengthUnit unit : LengthUnit.values()) {
            System.out.println(optionNumber + ". " + unit);
            optionNumber++;
        }
        System.out.println(optionNumber + ". Quit");

        int tableChoice;
        while (true) {
            try {
                System.out.print("Enter choice: ");
                String input = br.readLine().trim();
                tableChoice = Integer.parseInt(input);
                if (tableChoice >= 1 && tableChoice <= optionNumber) {
                    break;
                } else {
                    System.out.println("Invalid choice, please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
        return tableChoice;
    }

    public void convertAndDisplay(int choice) throws IOException {
        LengthUnit inputUnit = LengthUnit.values()[choice - 1];
        double inputValue = getInput();

        int outputChoice;
        while (true) {
            try {
                System.out.print("Enter the desired length unit: ");
                String input = br.readLine().trim();
                outputChoice = Integer.parseInt(input);
                if (outputChoice >= 1 && outputChoice <= LengthUnit.values().length) {
                    break;
                } else {
                    System.out.println("Invalid choice, please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }

        LengthUnit outputUnit = LengthUnit.values()[outputChoice - 1];

        double conversionFactor = getConversionFactor(inputUnit, outputUnit);
        double result = convertLength(inputValue, conversionFactor);
        displayResult(result, outputUnit);
    }

    private double getInput() throws IOException {
        while (true) {
            try {
                System.out.print("Enter the length: ");
                String input = br.readLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }

    private double convertLength(double input, double conversionFactor) {
        return input * conversionFactor;
    }

    private double getConversionFactor(LengthUnit inputUnit, LengthUnit outputUnit) {
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

        // If conversion factor is not defined, return 1.0
        return 1.0;
    }
    private void displayResult(double result, LengthUnit outputUnit) {
        System.out.println(outputUnit + ": " + result);
    }
}