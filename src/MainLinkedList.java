public class MainLinkedList {

    public static void main(String[] args) {

        System.out.println("Test 1: Even number of nodes");
        LinkedList ll1 = new LinkedList(1);
        ll1.append(2);
        ll1.append(3);
        ll1.append(4);
        System.out.print("BEFORE: ");
        ll1.printList();
        ll1.swapPairs();
        System.out.print("AFTER:  ");
        ll1.printList();

        System.out.println("\nTest 2: Odd number of nodes");
        LinkedList ll2 = new LinkedList(1);
        ll2.append(2);
        ll2.append(3);
        ll2.append(4);
        ll2.append(5);
        System.out.print("BEFORE: ");
        ll2.printList();
        ll2.swapPairs();
        System.out.print("AFTER:  ");
        ll2.printList();

        System.out.println("\nTest 3: Single node");
        LinkedList ll3 = new LinkedList(1);
        System.out.print("BEFORE: ");
        ll3.printList();
        ll3.swapPairs();
        System.out.print("AFTER:  ");
        ll3.printList();

        System.out.println("\nTest 4: Empty list");
        LinkedList ll4 = new LinkedList(1);
        ll4.makeEmpty();
        System.out.print("BEFORE: ");
        ll4.printList();
        ll4.swapPairs();
        System.out.print("AFTER:  ");
        ll4.printList();

        System.out.println("\nTest 5: Two nodes");
        LinkedList ll5 = new LinkedList(1);
        ll5.append(2);
        System.out.print("BEFORE: ");
        ll5.printList();
        ll5.swapPairs();
        System.out.print("AFTER:  ");
        ll5.printList();
    }

}


