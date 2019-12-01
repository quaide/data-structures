public class QuaideHashSet<T> {
    private int size = 0;
    private Object[] quaideArray;
    private double loadFactor;

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public QuaideHashSet() {
        quaideArray = new Object[10];
        this.loadFactor = 0;
        this.size = 0;
    }

    private int getHashedIndex(T o) {
        return Math.abs(o.hashCode()) % quaideArray.length;
    }

    public boolean add(T element) {
        if (!contains(element)) {
            int hashedIndex = getHashedIndex(element);
            Node<T> headNode = (Node<T>) quaideArray[hashedIndex];
            if(headNode == null) {
                headNode = new Node<T>();
                headNode.setValue(element);
                headNode.setNext(null);
                quaideArray[hashedIndex] = headNode;
            }
            else {
                while(headNode.next != null) {
                    headNode = headNode.next;
                }
                headNode.next = new Node<T>();
                headNode.next.setValue(element);
                headNode.next.setNext(null);
            }
            updateLoadFactor();
            updateArray();
            size = size + 1;
            return true;
        } else {
            return false;
        }
    }

    //fix this, doesn't account for linked list
    public boolean remove(T element) {
        if (contains(element)) {
            quaideArray[getHashedIndex(element)] = null;
            size = size - 1;
            updateLoadFactor();
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(T element) {
        int hashedIndex = getHashedIndex(element);
        Node<T> headNode = (Node<T>) quaideArray[hashedIndex];
        if(headNode == null) {
            return false;
        }
        else {
            do {
                if(headNode.value.equals(element)) {
                    return true;
                }
                else {
                    headNode = headNode.next;
                }
            }
            while(headNode != null);
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    private void updateLoadFactor() {
        loadFactor = size / quaideArray.length;
    }

    public void updateArray() {
        if (this.loadFactor > 0.7) {
            Object[] newArray = new Object[quaideArray.length * 2];
            System.arraycopy(quaideArray, 0, newArray, 0, size);
            quaideArray = new Object[newArray.length];
            System.arraycopy(newArray, 0, quaideArray, 0, size);
        }
    }
}
