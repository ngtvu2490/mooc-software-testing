package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    private GHappy gHappy;

    @BeforeEach
    public void initialize() {
        this.gHappy = new GHappy();
    }

    @ParameterizedTest(name = "str={0}")
    @CsvSource({"gHappy", "hagpy", "Hgappyg", "Haggyg"})
    public void noGHappy(String str) {
        Assertions.assertFalse(gHappy.gHappy(str));
    }

    @ParameterizedTest(name = "str={0}")
    @CsvSource({"Haggy", "Hagggy", "xxggyygg"})
    public void hasGHappy(String str) {
        Assertions.assertTrue(gHappy.gHappy(str));
    }
}
