public class LinkedList<E> {
    private Node<E> root;
    private Node<E> end;

    // public Node getLastElement() {
    //     Node current = root;
    //     while (current.next != null) {
    //         current = current.next;
    //     }

    //     return current;
    // }

    public void print() {
        System.out.print("[");
        for (Node<E> current = root; current != end; current = current.next) {
            System.out.print(current.data + ", ");
        }
        if (end != null) {
            System.out.println(end.data + "]");
        }
        else {
            System.out.print("]");
        }
    }

    public void add(E data) {
        if (root != null) {
            end.next = new Node<>(data);
            end = end.next;
        }
        else {
            end = root = new Node<>(data);
        }
    }

    public void clear() {
        root = end = null;
    }

    public E removeFirst() {
        E data = root.data;
        root = root.next;
        return data;
    }

    public boolean contains(E data) {
        for (Node<E> current = root; current != null; current = current.next) {
            if (current.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(E data) {
        for (Node<E> current = root, previous = null; current != null; previous = current, current = current.next) {
            if (current.data.equals(data)) {
                
                if (previous == null) {
                    root = root.next;
                } else if (current == end) {
                    previous.next = null;
                    end = previous;
                } else {
                    previous.next = current.next;
                }

                return true;
            }
            
        }
        return false;
    }


}