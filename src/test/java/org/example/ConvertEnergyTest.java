package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertEnergyTest {

    @Test
    void testGetConversionFactor() {
        // Här testar vi GetConversionFactor för olika enheter

        // Test case: Joule till Kilojoule
        double result1 = ConvertEnergy.getConversionFactor(1, 2);
        assertEquals(0.001, result1, 0.0001);

        // Test case: Kilowatt-timmar till Joule
        double result2 = ConvertEnergy.getConversionFactor(5, 1);
        assertEquals(3600000.0, result2, 0.0001);

        // Test case: Kilocalorie till Watt-timmar
        double result3 = ConvertEnergy.getConversionFactor(3, 4);
        assertEquals(1.162222, result3, 0.0001);

        // Test case: Watt-hours till Kilowatt-timmar
        double result4 = ConvertEnergy.getConversionFactor(4, 5);
        assertEquals(0.001, result4, 0.0001);

    }

    @Test
    void testGetUnitIndex() {
        // Testar GetUnitIndex för olika enheter

        assertEquals(1, ConvertEnergy.getUnitIndex("Joule"));
        assertEquals(2, ConvertEnergy.getUnitIndex("Kilojoule"));
        assertEquals(3, ConvertEnergy.getUnitIndex("Kilokalorie"));
        assertEquals(4, ConvertEnergy.getUnitIndex("Watt-timmar"));
        assertEquals(5, ConvertEnergy.getUnitIndex("Kilowatt-timmar"));
    }
}
