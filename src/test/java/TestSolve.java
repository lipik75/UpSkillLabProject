import junit.Equation;
import org.junit.Assert;
import org.junit.Test;


/**
 * Test of solve method, of class Equation.
 */
public class TestSolve {
    @Test
    public void testSolve(){
        Equation equation = new Equation();

        double[] result = equation.solve(1, -3, 5);
        double[] expectedResult = {-1, 5};

        Assert.assertArrayEquals(expectedResult, result, 0.01);


    }
}
