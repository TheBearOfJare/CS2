
public class Node<D> {

    D data;
    Node<D> next;
    Node<D> prev;

    public Node() {
    }

    public Node(D data) {
        this.data = data;
    }
}
