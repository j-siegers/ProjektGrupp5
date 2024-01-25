package org.example;
import javax.swing.JOptionPane;

//ConvertSpeed-klassen för att hantera hastighetsomvandlingar mellan kilometer per timme och engelska mil per timme.
public class ConvertSpeed {

    // Konverterar hastigheten från kilometer per timme till engelska mil per timme.
    // Implementation multiplicerar den givna hastigheten med omvandlingsfaktorn.
    public double kmphToMph(double kmph) {
        return kmph * 0.621371;
    }

    // Konverterar hastigheten från engelska mil per timme till kilometer per timme.
    // Implementation delar den givna hastigheten med omvandlingsfaktorn.
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
                "Select type of speed conversion:",
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
                showMessage("Invalid selection");
        }
    }

    //  Använder en GUI-dialog för att ta emot användarens inmatning.
    //  Hanterar ogiltig inmatning genom rekursivt anrop.
    double getDoubleInput(String message) {
        String input = JOptionPane.showInputDialog(null, message);
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            showMessage("Invalid input. Please enter a valid number.");
            return getDoubleInput(message);
        }
    }

    //  Visar meddelanden för användaren genom ett GUI-dialogfönster.
    //  Använder JOptionPane.showMessageDialog för att visa meddelanden.
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    // Utför hastighetsomvandling och visar resultatet för användaren.
    private void convertAndShowMessage(String fromUnit, String toUnit, Converter converter) {
        double input = getDoubleInput("Enter speed in " + fromUnit + ":");
        double result = converter.convert(input);
        showMessage(input + " " + fromUnit + " is equal to " + result + " " + toUnit + ".");
    }

    // Definierar ett funktionellt gränssnitt för hastighetsomvandlare.
    @FunctionalInterface
    private interface Converter {
        double convert(double input);
    }
    // Huvudmetod för att skapa en instans av ConvertSpeed och köra hastighetsomvandlingen.
    // Använder objektmetoden runConversion för att initiera och driva hastighetsomvandlingen.
    public static void main(String[] args) {
        // Skapa en instans av ConvertSpeed
        ConvertSpeed speedConverter = new ConvertSpeed();

        // Kör hastighetsomvandlingen
        speedConverter.runConversion();
    }
}
