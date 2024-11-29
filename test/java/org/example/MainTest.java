import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    @Test
    public void testReadArray() {
        int n = 5;
        int high = 10;
        int lov = 1;
        int[] array = org.example.Main.readArray(n, high, lov);
        assertEquals(n, array.length);
        for (int value : array) {
            assertTrue(value >= lov && value <= high);
        }
    }

    @Test
    public void testFindMaxAbsIndex() {
        int[] array = {1, -2, 3, -4, 5};
        assertEquals(4, org.example.Main.findMaxAbsIndex(array)); // 5 is the max absolute value

        array = new int[]{-10, -20, -30, -40, -50};
        assertEquals(4, org.example.Main.findMaxAbsIndex(array)); // -50 is the max absolute value

        array = new int[]{10, 20, 30, 40, 50};
        assertEquals(4, org.example.Main.findMaxAbsIndex(array)); // 50 is the max absolute value

        array = new int[]{-10, 20, -30, 40, -50};
        assertEquals(3, org.example.Main.findMaxAbsIndex(array)); // 40 is the max absolute value
    }

    @Test
    public void testProductAfterFirstPositive() {
        int[] array = {1, -2, 3, -4, 5};
        assertEquals(-20, org.example.Main.productAfterFirstPositive(array)); // 3 * -4 * 5 = -20

        array = new int[]{-1, -2, -3, 4, 5, 6};
        assertEquals(120, org.example.Main.productAfterFirstPositive(array)); // 4 * 5 * 6 = 120

        array = new int[]{-1, -2, -3, -4, -5};
        assertEquals(0, org.example.Main.productAfterFirstPositive(array)); // No positive number

        array = new int[]{0, 0, 0, 0};
        assertEquals(0, org.example.Main.productAfterFirstPositive(array)); // No positive number

        array = new int[]{1, 2, 3, 4, 5};
        assertEquals(120, org.example.Main.productAfterFirstPositive(array)); // 2 * 3 * 4 * 5 = 120
    }
}
