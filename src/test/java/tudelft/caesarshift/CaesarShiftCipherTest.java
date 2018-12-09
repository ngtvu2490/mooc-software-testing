package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher csc;

    @BeforeEach
    public void initialize() {
        this.csc = new CaesarShiftCipher();
    }

    @ParameterizedTest(name = "message={0}, shift={1}")
    @CsvSource({"0abc, 1", "ab@yz, 26", "xyz!, -15"})
    public void invalidCsc(String message, int shift) {
        Assertions.assertEquals("invalid", csc.CaesarShiftCipher(message, shift));
    }

    @ParameterizedTest(name = "message={0}, shift={1}, expectedResult={2}")
    @CsvSource({"abc, 29, def", "nochange, 0, nochange", "attackatonce, 4, exxegoexsrgi", "xyz, -10, nop", "xyz, 26, xyz"})
    public void validCsc(String message, int shift, String expectedResult) {
        Assertions.assertEquals(expectedResult, csc.CaesarShiftCipher(message, shift));
    }
}
