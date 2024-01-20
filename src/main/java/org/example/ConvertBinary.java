package org.example;
import javax.swing.*;


/**
 * Created by Johan Siegers <BR>
 * Date: 2024-01-16 <BR>
 * Time: 20:29 <BR>
 * Project: ProjektGrupp5 <BR>
 * Copyright: MIT <BR>
 * <BR>
 * Klassen innehåller metoder som konverterar: <BR>
 * text-sträng till binärt format <BR>
 * text-sträng till hexadecimalt format <BR>
 * mellan bytes/KB/MB/GB/TB
 */
public class ConvertBinary {

    // Instansvariabler
    public String inputData;  // Sparar inmatad användardata i objekt
    public String outputData;  // Sparar utdata i objekt
    public int menuChoice;  // Sparar valt menyalternativ


    /**
     * Huvudmeny för ConvertBinary
     */
    public static void runConversion() {

        // Skapar en instans av ConvertBinary objekt
        ConvertBinary converter = new ConvertBinary();

       // Array med alternativ för konvertering
        String[] options = { "Text till binärt", "Text till hexadecimalt", "Bytes"};
        // JOptionPane valmeny
        converter.menuChoice = JOptionPane.showOptionDialog(null, "Vad vill du konvertera?",
                "ConvertBinary - Välj ett alternativ:",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Inmatning av sträng som ska konverteras. If satsen körs om valet är byteskonvertering
        if (converter.menuChoice == 2)
            converter.inputData = JOptionPane.showInputDialog(null,
                    "Skriv värdet du vill konvertera från (t.ex 1000 KB)\n" +
                            "Tillåtna enheter: B, KB, MB, GB & TB");

        else
            converter.inputData = JOptionPane.showInputDialog(null,
                    "Skriv texten du vill konvertera");

        // Efter gjort val skickas objektet till inputConverter där resultat inhämtas
        String result = inputConverter(converter);

        // Svaret skrivs sedan ut
        JOptionPane.showMessageDialog(null, result);

    }


    /**
     * Metod som hanterar användarens inmatade data
     * @param choice ConvertBinary object
     * @return Resultat av val i strängformat
     */
    public static String inputConverter (ConvertBinary choice){
        // Vid binär omvandling körs denna kod
        if (choice.menuChoice == 0) {

          // Inmatad data skickas till binäromvandlaren
          choice.outputData = textToBinary(choice.inputData);

          // Vid hexadecimal omvandling körs denna kod
        } else if (choice.menuChoice == 1) {

            // Inmatad data skickas till hexadecimala omvandlaren
            choice.outputData = textToHexadecimal(choice.inputData);

          // Vid bytesomvandling körs denna kod
        } else if (choice.menuChoice == 2) {

            // Inmatad data skickas till bytesomvandlaren
            choice.outputData = bytesConverter(choice.inputData);
        }

        return choice.outputData;  // Konverterad data skickas tillbaka
    }


    /**
     * Metod som konverterar en sträng till binärt format
     * @param text Tar emot en sträng i ASCII format
     * @return Sträng med binära siffror i 7-bit format
     */
    public static String textToBinary(String text) {
        // Använder StringBuilder för att lätt kunna göra append
        StringBuilder binaryString = new StringBuilder();

        // Loop som går igenom texten i array format. En bokstav i taget läses in och sparas i binär form
        // i binaryString.
        for (char c: text.toCharArray()){
            // Bokstaven sparas i binär form och ett mellanslag läggs till mellan varje "bokstav"
            binaryString.append(Integer.toBinaryString(c)).append(" ");
        }
        return binaryString.toString().trim();  // Eventuella mellanslag i början och slut tas bort
    }


    /**
     * Metod som konverterar en sträng till hexadecimalt format
     * @param text Tar emot en sträng i ASCII format
     * @return Sträng i hexadecimalt format
     */
    public static String textToHexadecimal(String text){
        // Använder StringBuilder för att lätt kunna göra append
        StringBuilder hexString = new StringBuilder();

        // Loop som går igenom texten i array format. En bokstav i taget läses in och sparas i hexadecimal form
        // i hexString.
        for (char c: text.toCharArray()){
            // Ett mellanslag läggs till mellan varje ord för bättre läsbarhet
            if (Character.isWhitespace(c)) {
                hexString.append(' ');
                continue;  // Vid tomt tecken börjar loopen om och hoppar över sista raden
            }
            hexString.append(Integer.toHexString(c));
        }
        // Görs om till String och mellanslag i början och slut tas bort, små bokstäver blir stora.
        return hexString.toString().trim().toUpperCase();
    }


    /**
     * Metod som konverter mellan Bytes/KB/MB/GB/TB
     * @param inputData En sträng med siffror och enheten som ska konverteras från
     * @return Sträng med konverterade värden
     */
    public static String bytesConverter(String inputData) {
        String error = String.valueOf(new NullPointerException());  // Felmeddelande
        long numericValue;  // Lagrar tal i bytesformat

        // Kontroll så inmatat värde inte är tomt
        if (!inputData.isEmpty()) {
            // Enhetsvärdet separeras och sparas
            String bytesString = inputData.replaceAll("[^a-zA-Z]", "");
            // Siffror sorteras här ut från inmatade strängen
            String numericString = inputData.replaceAll("[^0-9]", "");

            // Felhantering vid fel inmatning
            try {
                // Strängen omvandlas till en long
                numericValue = Long.parseLong(numericString);
            }
            catch (NumberFormatException e){
                return "Fel: " + e;
            }

            // Uträkningar av konverteringar beroende på inmatad enhet
            // Uträkning från bytes
            if (bytesString.equalsIgnoreCase("b")) {
                return numericValue + " byte = \n" + (numericValue / 1024.0) + " Kilobyte\n" +
                        (numericValue / (1024.0 * 1024.0)) + " Megabyte\n" +
                        (numericValue / (1024.0 * 1024.0 * 1024.0)) + " Gigabyte\n" +
                        (numericValue / (1024.0 * 1024.0 * 1024.0 * 1024.0)) + " Terabyte\n";

            // Uträkning från kilobytes
            } else if (bytesString.equalsIgnoreCase("kb")) {
                return numericValue + " kilobyte = \n" + (numericValue / 1024.0) + " Megabyte\n" +
                        (numericValue / (1024.0 * 1024.0)) + " Gigabyte\n" +
                        (numericValue / (1024.0 * 1024.0 * 1024.0)) + " Terabyte\n";

            // Uträkning från megabytes
            } else if (bytesString.equalsIgnoreCase("mb")) {
                return numericValue + " megabyte = \n" + (numericValue / 1024.0) + " Gigabyte\n" +
                        (numericValue / (1024.0 * 1024.0)) + " Terabyte\n";

            // Uträkning från gigabytes
            } else if (bytesString.equalsIgnoreCase("gb")) {
                return numericValue + " gigabyte = \n" + (numericValue * 1024.0) + " Megabyte\n"+
                        (numericValue / 1024.0) + " Terabyte";

            // Uträkning från terabytes
            } else if (bytesString.equalsIgnoreCase("tb")) {
                return numericValue + " terabyte = \n" + (numericValue * 1024.0) + " Gigabyte\n"+
                        (numericValue / 1024.0) + " Petabyte";

            // Felmeddelande
            } else
                return "Du måste skriva b, kb, mb, gb eller tb efter talet";

        // Retur av felmeddelande om inmatad data är tom
        } else
            return "Fel: " + error;

    }
}
