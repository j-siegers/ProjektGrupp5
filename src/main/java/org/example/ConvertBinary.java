package org.example;

import javax.swing.*;
import java.util.Objects;

/**
 * Created by Johan Siegers <BR>
 * Date: 2024-01-09 <BR>
 * Time: 19:17 <BR>
 * Project: ProjektGrupp5 <BR>
 * Copyright: MIT <BR>
 * <BR>
 * Klassen innehåller metoder som konverterar: <BR>
 * text-sträng till binärt format <BR>
 * text-sträng till hexadecimalt format <BR>
 */
public class ConvertBinary {

    public String inputData;  // Sparar inmatad användardata i objekt
    public String outputData;  // Sparar utdata i objekt


    /**
     * Huvudmeny för ConvertBinary
     */
    public static String runConversion() {

        // Skapar en instans av ConvertBinary objekt
        ConvertBinary converter = new ConvertBinary();

        // JOptionPane valmeny
        String[] options = { "Text till binärt", "Text till hexadecimalt", "Bytes"};
        var choice = JOptionPane.showOptionDialog(null, "Vad vill du konvertera?",
                "ConvertBinary - Välj ett alternativ:",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Val av binäromvandlare
        if (choice == 0)
            converter.inputData = "binary";

        // Val av hexadecimal omvandlare
        else if (choice == 1)
            converter.inputData = "hex";

        // Val av Byte omvandlare
        else if (choice == 2)
            converter.inputData = "byte";


        // Efter gjort val skickas objektet till inputChoice där användardata inhämtas och resultat sparas i result
        String result = inputChoice(converter);
        // Svaret skickas sedan till displayResult för utskrift
        return displayResult(result);
    }


    /**
     * Metod som hanterar användarens val
     * @param choice ConvertBinary object
     * @return Resultat av val i strängformat
     */
    public static String inputChoice (ConvertBinary choice){
        // Vid binär omvandling körs denna kod
        if (Objects.equals(choice.inputData, "binary")){
          choice.inputData = JOptionPane.showInputDialog(null, "Vad vill du konvertera?");
          // Inmatad data skickas till binäromvandlaren
          choice.outputData = textToBinary(choice.inputData);

        } else if (Objects.equals(choice.inputData, "hex")) {
            choice.inputData = JOptionPane.showInputDialog(null, "Vad vill du konvertera?");
            // Inmatad data skickas till hexadecimala omvandlaren
            choice.outputData = textToHexadecimal(choice.inputData);
        }

        return choice.outputData;  // Konverterad data skickas tillbaka
    }


    /**
     * Metod som hanterar utskrift av konverteringar
     * @param result sträng med konverterad data
     * @return En dialogruta med resultat och en sträng
     */
    public static String displayResult (String result){
        JOptionPane.showMessageDialog(null, result);
        return result;
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

    //TODO Omvandlare mellan bytes/kb/mb/gb/tb

}
