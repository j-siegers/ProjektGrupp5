package org.example;

import org.junit.jupiter.api.Test;
import org.example.ConvertLength.LengthUnit;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertLengthTest {

    @Test
    public void testChooseLengthUnit() {
        ConvertLength converter = new ConvertLength();
        LengthUnit chosenUnit = converter.chooseLengthUnit();
        assertNotNull(chosenUnit);
    }

    @Test
    public void testGetInput() {
        ConvertLength converter = new ConvertLength();
        double inputValue = converter.getInput("Enter a value:");
        assertTrue(inputValue >= 0);
    }

    @Test
    public void testPerformConversion() {
        ConvertLength converter = new ConvertLength();
        double inputValue = 10.0;
        double conversionFactor = 0.1;
        double result = converter.performConversion(inputValue, conversionFactor);
        assertEquals(1.0, result);
    }

    @Test
    public void testGetConversionFactor() {
        ConvertLength converter = new ConvertLength();
        LengthUnit inputUnit = LengthUnit.Millimeter;
        LengthUnit outputUnit = LengthUnit.Centimeter;
        double conversionFactor = converter.getConversionFactor(inputUnit, outputUnit);
        assertEquals(0.1, conversionFactor);
    }

    @Test
    public void testAskForAnotherConversion() {
        ConvertLength convertLength = new ConvertLength();
        assertTrue(convertLength.askForAnotherConversion());
        assertFalse(convertLength.askForAnotherConversion());
    }
}
