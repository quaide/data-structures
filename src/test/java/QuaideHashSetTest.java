import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuaideHashSetTest {

    @Test
    void addElement() {
        QuaideHashSet<String> quaideHashSet = new QuaideHashSet<>();

        Assertions.assertTrue(quaideHashSet.add("Quaide"));
        Assertions.assertFalse(quaideHashSet.add("Quaide"));
        Assertions.assertEquals(1, quaideHashSet.size());
        Assertions.assertTrue(quaideHashSet.contains("Quaide"));
    }

    @Test
    void removeElement() {
        QuaideHashSet<String> quaideHashSet = new QuaideHashSet<>();

        quaideHashSet.add("Quaide");

        Assertions.assertTrue(quaideHashSet.contains("Quaide"));
        Assertions.assertTrue(quaideHashSet.remove("Quaide"));
        Assertions.assertFalse(quaideHashSet.contains("Quaide"));
        Assertions.assertEquals(0, quaideHashSet.size());
    }

    @Test
    void removeManyElements() {
        QuaideHashSet<String> quaideHashSet = new QuaideHashSet<>();

        for (int i = 0; i < 20; i++) {
            quaideHashSet.add(String.valueOf(i));
        }

        for (int i = 19; i >= 0; i--) {
            boolean contains = quaideHashSet.contains(String.valueOf(i));
            Assertions.assertTrue(quaideHashSet.contains(String.valueOf(i)));
            Assertions.assertTrue(quaideHashSet.remove(String.valueOf(i)));
            Assertions.assertFalse(quaideHashSet.contains(String.valueOf(i)));
            Assertions.assertEquals(i, quaideHashSet.size());
        }
    }

    @Test
    void addManyElements() {
        QuaideHashSet<String> quaideHashSet = new QuaideHashSet<>();

        for (int i = 0; i < 20; i++) {
            Assertions.assertFalse(quaideHashSet.contains(String.valueOf(i)));
            Assertions.assertTrue(quaideHashSet.add(String.valueOf(i)));
            Assertions.assertTrue(quaideHashSet.contains(String.valueOf(i)));
            Assertions.assertEquals(i + 1, quaideHashSet.size());
        }
    }
}
