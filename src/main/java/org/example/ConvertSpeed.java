package org.example;
import javax.swing.JOptionPane;

// ConvertSpeed-klassen för att hantera hastighetsomvandlingar mellan kilometer per timme och engelska mil per timme.
public class ConvertSpeed {

    // Konvertera från kilometer per timme till engelska mil per timme
    public double kmphToMph(double kmph) {
        return kmph * 0.621371;
    }

    // Konvertera från engelska mil per timme till kilometer per timme
    public double mphToKmph(double mph) {
        return mph / 0.621371;
    }

    // Kör speed converter genom att låta användaren välja typ av omvandling i en GUI.
    public void runConversion() {
        // Alternativ för hastighetsomvandling presenteras i en GUI-lista.
        String[] speedOptions = {
                "Kilometers per Hour to Miles per Hour",
                "Miles per Hour to Kilometers per Hour"
        };
        // Hämta användarens val av omvandlingstyp med hjälp av en GUI-dialog.
        String speedChoice = (String) JOptionPane.showInputDialog(
                null,
                "Choose the type of speed conversion:",
                "Speed Conversion",
                JOptionPane.QUESTION_MESSAGE,
                null,
                speedOptions,
                speedOptions[0]
        );
        // Hantera användarens avbokning.
        if (speedChoice == null) {
            return;
        }
        // Utför den valda omvandlingen baserat på användarens val.
        switch (speedChoice) {
            case "Kilometers per Hour to Miles per Hour":
                convertAndShowMessage("Kilometers per Hour", "Miles per Hour", this::kmphToMph);
                break;
            case "Miles per Hour to Kilometers per Hour":
                convertAndShowMessage("Miles per Hour", "Kilometers per Hour", this::mphToKmph);
                break;
            default:
                showMessage("Invalid choice");
        }
    }

    // Hjälpmetod för att hämta decimalinmatning från användaren
    private double getDoubleInput(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            showMessage("Invalid input. Please enter a valid number.");
            return getDoubleInput(message);
        }
    }

    // Hjälpmetod för att visa meddelanden för användaren
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // Hjälpmetod för att konvertera och visa resultatet
    private void convertAndShowMessage(String fromUnit, String toUnit, Converter converter) {
        double input = getDoubleInput("Enter speed in " + fromUnit + ":");
        double result = converter.convert(input);
        showMessage(input + " " + fromUnit + " is equal to " + result + " " + toUnit + ".");
    }

    // Funktionellt gränssnitt för omvandlare
    @FunctionalInterface
    private interface Converter {
        double convert(double input);
    }
    // Huvudmetod för att skapa en instans av ConvertSpeed och köra hastighetsomvandlingen.
    public static void main(String[] args) {
        // Skapa en instans av ConvertSpeed
        ConvertSpeed speedConverter = new ConvertSpeed();

        // Kör hastighetsomvandlingen
        speedConverter.runConversion();
    }
}
