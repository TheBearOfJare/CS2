public class LinkedList {
    
    private Node<String> root;
    private Node<String> end;

    public void add(String data) {
        
        System.out.println("Adding: " + data);

        if (root == null) {
            System.out.println("Making new tree.");
            root = new Node<>(data);
            end = root;
        }
        else {
            
            for (Node<String> current = root, previous = null; current != null; previous = current, current = current.next) {
                if (current.data.compareTo(data) > 0) {
                    
                    Node<String> insertable = new Node<>(data);
                    insertable.next = current;
                    if(previous != null) {
                        System.out.println("Inserting between " + previous.data + " and " + current.data);
                        previous.next = insertable;
                    } else {
                        System.out.println("Inserting at root (Before " + insertable.next.data + ")");
                        root = insertable;
                    }
                    
                    return;
                }
            }
            System.out.println("Appending " + data);
            end.next = new Node<>(data);
            end = end.next;

        }

    }

    public boolean remove(String data) {

        for (Node<String> current = root, previous = null; current != null; current = current.next) {
            if (current.data.equals(data)) {

                if (current != root) {
                    System.out.println("Removing " + data + " after " + previous.data);
                    if (current.next == null) {
                        end = previous;
                        previous.next = null;
                    }
                    else {
                        previous.next = current.next;
                    }

                    // System.out.println(current.next + " " + end);
                }
                
                else {
                    if (root.next == end ) {
                        root = end = null;
                    }
                    else {
                        System.out.println("Removing " + data + " at root and before " + root.next.data);
                        root = root.next;
                    }
                }
                
                return true;

            }
            previous = current;
        }

        System.out.println("No " + data + " to remove");
        return false;

    }

    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (Node<String> current = root; current != null; current = current.next) {
            builder.append(current.data);
            if(current.next != null) {
                builder.append(", ");
            }
        }
        builder.append(']');

        return builder.toString();

    }

    public int indexOf(String data) {

        int index = 0;
        for (Node<String> current = root; current != null; current = current.next) {
            if (current.data.equals(data)) {
                return index;
            }
            else {
                index++;
            }
        }

        return Integer.MIN_VALUE;

    }

    public String removeNodeAt(int index) {

        if (index == 0) {
            String returnable = root.data;

            System.out.println("Removing " + returnable + " at " + index);

            if (root.next != null) {
                root = root.next;
            }
            else {
                root = end = null;
            }
            
            return returnable;
        }

        int currentDex = 1;
        for (Node<String> current = root.next, previous = root; current != null; current = current.next) {

            if (currentDex == index) {
                String returnable = current.data;

                System.out.println("Removing " + returnable + " at " + index);

                previous.next = current.next;
                return returnable;
            }
            previous = current;
            currentDex ++;
        }

        System.out.println("Nothing at index " + index);
        return "";
    }

}
