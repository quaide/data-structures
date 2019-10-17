package linkedlist;

public class QuaideNode<T> {
    private QuaideNode<T> nextInLine;
    private QuaideNode<T> inFrontOfMe;
    private T value;

    public QuaideNode(QuaideNode<T> nextInLine, QuaideNode<T> inFrontOfMe, T value) {
        this.nextInLine = nextInLine;
        this.inFrontOfMe = inFrontOfMe;
        this.value = value;
    }

    public QuaideNode<T> getNextInLine() {
        return nextInLine;
    }

    public void setNextInLine(QuaideNode<T> nextInLine) {
        this.nextInLine = nextInLine;
    }

    public QuaideNode<T> getInFrontOfMe() {
        return inFrontOfMe;
    }

    public void setInFrontOfMe(QuaideNode<T> inFrontOfMe) {
        this.inFrontOfMe = inFrontOfMe;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "QuaideNode{value=" + value +
                '}';
    }
}
