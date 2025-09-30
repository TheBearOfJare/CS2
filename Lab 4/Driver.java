public class Driver {
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();

        list.add("A");
        System.out.println(list.toString());
        list.add("C");
        System.out.println(list.toString());
        list.add("B");
        System.out.println(list.toString());
        list.add("D");
        System.out.println(list.toString());
        list.add("C");
        System.out.println(list.toString());

        System.out.println(list.indexOf("A"));
        System.out.println(list.indexOf("B"));
        System.out.println(list.indexOf("C"));
        System.out.println(list.indexOf("D"));
        System.out.println(list.indexOf("Z"));

        list.remove("A");
        System.out.println(list.toString());
        list.remove("C");
        System.out.println(list.toString());
        list.remove("D");
        System.out.println(list.toString());
        list.remove("Z");

        list.add("A");
        System.out.println(list.toString());
        list.add("D");
        System.out.println(list.toString());
        list.removeNodeAt(0);
        System.out.println(list.toString());
        list.removeNodeAt(1);
        System.out.println(list.toString());
        list.removeNodeAt(1);
        System.out.println(list.toString());
        list.removeNodeAt(5);
        System.out.println(list.toString());



    }
}
