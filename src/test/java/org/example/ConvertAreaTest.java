package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertAreaTest {


    @Test
    void testConverter() {
        ConvertArea convertMethod = new ConvertArea();

        // 1cm² ska alltså bli 0.0001m²
        double result1 = convertMethod.convert("cm²", "m²", 1);
        assertEquals(result1, 0.0001);

        // 1dm² ska bli 0.01m²
        double result2 = convertMethod.convert("dm²", "m²", 1);
        assertEquals(result2, 0.01);

        // 1m² ska bli 1.0e-6km²
        double result3 = convertMethod.convert("m²", "km²", 1);
        assertEquals(result3, 1.0e-6);

        // 1km² ska bli 1km²
        double result4 = convertMethod.convert("km²", "km2²", 1.0);
        assertEquals(result4, 1.0);

    }

    // test med faliktiga parametrar för convert-metoden
    @Test
    void testWrongConverts() {
        ConvertArea convertMethod = new ConvertArea();

        // 1cm² ska alltså bli 0.0001m²
        double result1 = convertMethod.convert("cm²", "m²", 1000); // anger felaktigt värde
        assertNotEquals(result1, 1);

    }

    // När du kör detta test så uppstår en dialogruta där du får välja enhet som ska kontrolleras
    @Test
    void testCm2() {
        // Skapa en ny ConvertArea-instans
        ConvertArea inputMethod = new ConvertArea();

        // Skapa ett array med alla möjliga areaenheter
        String[] areaChoice = {"cm²", "dm²", "m²", "km²"};

        // Hämta menyn från inputMethod
        String menu = inputMethod.inputDialog("Välj en areaenhet:", areaChoice);

        // Kontrollera att cm2 finns med i menyn
        assertTrue(menu.contains("cm²"));

        // Om cm2 inte finns med i menyn så skriv ut ett felmeddelande
        if (!menu.contains("cm²")) {
            System.out.println("Fel: cm² finns inte med i menyn.");
        }
    }
}