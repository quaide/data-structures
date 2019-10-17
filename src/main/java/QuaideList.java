import java.util.Arrays;

public class QuaideList {

    private int size;
    private String[] quaideArray;

    public QuaideList() {
        quaideArray = new String[10];
        this.size = 0;
    }

    public void add(String nextElement) {
        if (size >= quaideArray.length) {
            String[] newArray = new String[quaideArray.length * 2];
            System.arraycopy(quaideArray, 0, newArray, 0, size);
            quaideArray = new String[newArray.length];
            System.arraycopy(newArray, 0, quaideArray, 0, size);
        }
        quaideArray[size] = nextElement;
        size++;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index does not exist in this QuaideList!");
        } else {
            return quaideArray[index];
        }
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("This index does not exist!");
        } else {
            String[] newArray = new String[quaideArray.length];
            System.arraycopy(quaideArray, 0, newArray, 0, index);
            System.arraycopy(quaideArray, index + 1, newArray, index, quaideArray.length - (index + 1));
            System.arraycopy(newArray, 0, quaideArray, 0, size);
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String element) {
        for (int i = 0; i < size; i++) {
            if (quaideArray[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "QuaideList{" +
                "quaideArray=" + Arrays.toString(quaideArray) +
                '}';
    }
}
