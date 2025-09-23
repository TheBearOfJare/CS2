
public class LinkedList<E extends Comparable<E>> {

    private Node<E> root;
    private Node<E> end;

    public LinkedList() {
        root = new Node<>();
        end = new Node<>();
        root.next = end;
        end.prev = root;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        Node<E> current = root.next;
        for (; current.next != end && current.data.compareTo(data) < 0; current = current.next)
            ;

        if (current.data.compareTo(data) >= 0) {
            // new data on left
            newNode.next = current;
            newNode.prev = current.prev;
            newNode.next.prev = newNode;
            newNode.prev.next = newNode;
        } else {
            // new data on right
            newNode.prev = current;
            newNode.next = null;
            newNode.prev.next = newNode;
            end = newNode;
        }
    }

    public void clear() {
        root = end = null;
    }

    public E removeFirst() { // sometimes called "poll"
        if (root != null) {
            E data = root.data;
            root = root.next;
            if (root == null) { // list had only one element
                end = null;
            }
            return data;
        }
        return null;
    }

    public boolean remove(E data) {
        for (Node<E> current = root; current != null; current = current.next) {
            if (current.data.equals(data)) {
                if (current == root) {// remove at root
                    if (root != end) {
                        current.next.prev = null;
                        root = current.next;
                    } else {
                        root = end = null;
                    }
                } else if (current == end) { // remove at end
                    end = current.prev;
                    end.next = null;
                } else { // remove in the middle
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                }
                return true;
            }
        }
        return false;
    }

    public boolean contains(E data) {
        for (Node<E> current = root; current != null; current = current.next) {
            if (current.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.print("[");
        for (Node<E> current = root; current != end; current = current.next) {
            System.out.print(current.data + ", ");
        }
        if (end != null) {
            System.out.println(end.data + "]");
        } else {
            System.out.println("]");
        }
    }
}
