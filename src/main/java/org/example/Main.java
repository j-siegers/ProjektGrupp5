package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Skapa instanser av varje konverteringsklass
        ConvertArea areaConverter = new ConvertArea();
        ConvertBinary binaryConverter = new ConvertBinary();
        ConvertEnergy energyConverter = new ConvertEnergy();
        ConvertLength lengthConverter = new ConvertLength();
        ConvertSpeed speedConverter = new ConvertSpeed();

        boolean runMain = true;

        while (runMain) {

            String[] conversionOptions = {
                    "Area Conversion",
                    "Binary Conversion",
                    "Energy Conversion",
                    "Length Conversion",
                    "Speed Conversion"
            };
            String userChoice = (String) JOptionPane.showInputDialog(
                    null,
                    "Välj typ av konvertering:",
                    "Huvudmeny",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    conversionOptions,
                    conversionOptions[0]
            );

            if (userChoice == null) {
                break;
            }

            switch (userChoice) {
                case "Area Conversion":
                    //areaConverter.runConversion();
                    break;
                case "Binary Conversion":
                    //binaryConverter.runConversion();
                    break;
                case "Energy Conversion":
                    energyConverter.runConversion();
                    break;
                case "Length Conversion":
                    lengthConverter.runConversion();
                    break;
                case "Speed Conversion":
                    //speedConverter.runConversion();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ogiltigt val");
            }
            int response = JOptionPane.showConfirmDialog(null, "Do you want to perform another conversion?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.NO_OPTION) {
                runMain = false;
            }
        }
    }
}