package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConvertSpeedTest {

    // Testar kmphToMph-metoden i ConvertSpeed för att säkerställa korrekt omvandling.
    // Från kilometer per timme till engelska mil per timme.
    // Enheten omvandlas från 100 km/h till mph.
    // Enheten omvandlas från 0 km/h till mph.
    // Enheten omvandlas från 200 km/h till mph.
    @Test
    public void testKmphToMph() {
        ConvertSpeed converter = new ConvertSpeed();
        assertEquals(62.1371, converter.kmphToMph(100), 0.0001);
        assertEquals(0, converter.kmphToMph(0), 0.0001);
        assertEquals(124.2742, converter.kmphToMph(200), 0.0001);
    }

    // Testar mphToKmph-metoden i ConvertSpeed för att säkerställa korrekt omvandling.
    // Från engelska mil per timme till kilometer per timme.
    // Enheten omvandlas från 100 mph till km/h.
    // Enheten omvandlas från 0 mph till km/h.
    // Enheten omvandlas från 200 mph till km/h.
    @Test
    public void testMphToKmph() {
        ConvertSpeed converter = new ConvertSpeed();
        assertEquals(160.9344, converter.mphToKmph(100), 0.0001);
        assertEquals(0, converter.mphToKmph(0), 0.0001);
        assertEquals(321.8688, converter.mphToKmph(200), 0.0001);
    }

    // Testar getDoubleInput-metoden i ConvertSpeed.
    // För att säkerställa korrekt inmatningshantering av decimaltal från användaren.
    // Användaren anger 5.0, förväntat resultat är 5.0.
    // Användaren anger -10.5, förväntat resultat är -10.5.
    @Test
    public void testGetDoubleInput() {
        ConvertSpeed converter = new ConvertSpeed();
        assertEquals(5.0, converter.getDoubleInput("Enter a number:"), 0.0001);
        assertEquals(-10.5, converter.getDoubleInput("Enter a negative number:"), 0.0001);
    }

    // Testar att kmphToMph och mphToKmph är inversa operationer av varandra.
    @Test
    public void testKmphToMphAndMphToKmph() {
        ConvertSpeed converter = new ConvertSpeed();
        double originalSpeed = 100.0;
        double mphSpeed = converter.kmphToMph(originalSpeed);
        double kmphSpeed = converter.mphToKmph(mphSpeed);
        assertEquals(originalSpeed, kmphSpeed, 0.0001);
    }

}
