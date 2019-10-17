import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuaideListTest {
    @Test
    public void testConstructor() {
        QuaideList test = new QuaideList();
        Assertions.assertEquals(0, test.size());
    }

    @Test
    public void testAdd() {
        QuaideList test = new QuaideList();
        test.add("Placeholder");
        String firstElement = test.get(0);
        Assertions.assertEquals(1, test.size());
        Assertions.assertEquals("Placeholder", firstElement);
    }

    @Test
    public void addManyElements() {
        QuaideList test = new QuaideList();
        for (int i = 0; i < 100; i++) {
            test.add("i");
            //add the following two lines to create a test
            Assertions.assertEquals("i", test.get(i));
            Assertions.assertEquals(i + 1, test.size());
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test.get(-1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test.get(101);
        });
    }

    @Test
    public void testIsEmpty() {
        QuaideList test = new QuaideList();
        Assertions.assertEquals(true, test.isEmpty());
    }

    @Test
    public void testRemove() {
        QuaideList test = new QuaideList();
        test.add("Placeholder");
        test.add("Quaide");
        test.add("Kelsey");
        test.add("Mitch");
        Assertions.assertEquals(4, test.size());
        test.remove(1);
        Assertions.assertEquals("Kelsey", test.get((1)));
        Assertions.assertEquals(3, test.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test.remove(-1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            test.remove(3);
        });
    }

    @Test
    public void testContains() {
        QuaideList test = new QuaideList();
        test.add("Placeholder");
        Assertions.assertTrue(test.contains("Placeholder"));
        Assertions.assertFalse(test.contains("Quaide"));
    }

    @Test
    public void testGetOutOfBounds() {
        QuaideList test = new QuaideList();

    }
}
