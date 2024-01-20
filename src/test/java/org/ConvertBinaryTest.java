import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.example.ConvertBinary.*;

/**
 * Created by Johan Siegers <BR>
 * Date: 2024-01-16 <BR>
 * Time: 20:31 <BR>
 * Project: ProjektGrupp5 <BR>
 * Copyright: MIT <BR>
 * <BR>
 * Test klass för metoderna <BR>
 * i ConvertBinary
 */
class ConvertBinaryTest {

    // Tester av textToBinary
    @Test
    void testTextToBinary_hej (){
        String result = textToBinary("hej");
        assertEquals("1101000 1100101 1101010", result);
    }
    @Test
    void testTextToBinary_EmptyString() {
        String result = textToBinary("");
        assertEquals("", result);
    }
    @Test
    void testTextToBinary_NullInput() {
        assertThrows(NullPointerException.class, () -> textToBinary(null));
    }

    // Tester av textToHexadecimal
    @Test
    void testTextToHexadecimal_hej (){
        String result = textToHexadecimal("hej hej");
        assertEquals("68656A 68656A", result);
    }
    @Test
    void testTextToHexadecimal_EmptyString() {
        String result = textToHexadecimal("");
        assertEquals("", result);
    }
    @Test
    void testTextToHexadecimal_NullInput() {
        assertThrows(NullPointerException.class, () -> textToHexadecimal(null));
    }

    // Tester av resterande metoder
    @Test
    void testInputConverter () {
        org.example.ConvertBinary converter = new org.example.ConvertBinary();
        converter.menuChoice = 0;
        converter.inputData = "hej";
        assertEquals("1101000 1100101 1101010", inputConverter(converter));
    }

    @Test
    void testBytesConverter () {
        String inputData = "1024 tb";
        assertEquals("""
                1024 terabyte =\s
                1048576.0 Gigabyte
                1.0 Petabyte""", bytesConverter(inputData));
    }
}