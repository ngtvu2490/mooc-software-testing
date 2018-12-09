package tudelft.chocolate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MyChocolateBagsTest {

    private ChocolateBags bags;

    @BeforeEach
    public void initialize() {
        this.bags = new ChocolateBags();
    }

    @ParameterizedTest(name = "small={0}, big={1}, total={2}, expectedResult={3}")
    @CsvSource({"1,1,5,0", "1,1,6,1", "1,1,7,-1", "1,1,8,-1"})
    public void totalIsTooBig(int small, int big, int total, int expectedResult) {
        int result = bags.calculate(small, big, total);
        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = " small={0}, big={1}, total={2}, expectedResult={3}")
    @CsvSource({"4,0,10,-1", "4,1,10,-1", "5,2,10,0", "5,3,10,0"})
    public void onlyBigBars(int small, int big, int total, int expectedResult) {
        int result = bags.calculate(small, big, total);
        Assertions.assertEquals(expectedResult, result);
    }
}
