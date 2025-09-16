public class Node<D> {
    D data;
    Node<D> next;

    public Node(D data) {
        this.data = data;
    }
    
    public Node(D data, Node<D> next) {
        this.data = data;
        this.next = next;
    }
}
