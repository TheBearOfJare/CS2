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
        for (; current != end && current.data.compareTo(data) < 0; current = current.next)
            ;

        newNode.next = current;
        newNode.prev = current.prev;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        
    }

    public void clear() {
        root = end = null;
    }

    public E removeFirst() { // sometimes called "poll"
        if (root.next != end) {
            E data = root.next.data;
            root.next = root.next.next;
            if (root == null) { // list had only one element
                end = null;
            }
            return data;
        }
        return null;
    }

    public boolean isEmpty() {
        return root.next == end;
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

        StringBuilder bob = new StringBuilder();

        bob.append('[');

        for (Node<E> current = root; current != end; current = current.next) {
            bob.append(current.data);
            bob.append(", ");
        }
        if (bob.length() > 1) {
            bob.setCharAt(bob.length() - 2, ']');
        }
        else {
            bob.append(']');
        }
    }
}
