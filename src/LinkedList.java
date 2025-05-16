import javax.xml.transform.stream.StreamSource;
import java.sql.SQLOutput;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

//    public Node removeLast() {
//        Node temp = head;
//        Node pre = head;
//        if (length == 0) {
//            return null;
//        }
//        while (temp.next != null) {
//            pre = temp;
//            temp = temp.next;
//        }
//        tail = pre;
//        tail.next = null;
//        length--;
//        if (length == 0) {
//            head = null;
//            tail = null;
//        }
//        return temp;
//    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        // Now, temp is the last node, pre is the second last
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = pre;
            tail.next = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node node = get(index);
        if (node == null) {
            return false;
        } else {
            node.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value) {
        boolean isPossible = false;
        if (index < 0 || index > length) {
            return false;
        } else if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;

        }
    }

    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;
        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        if (k <= 0) return null;
        Node first = head;
        Node second = head;
        // Move first pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (first == null) return null; // k is larger than the list size
            first = first.next;
        }
        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.value == current.value) {
                    // Remove duplicate
                    runner.next = runner.next.next;
                    length--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public int binaryToDecimal() {
        Node current = head;
        int num = 0;
        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }
        return num;
    }

    public Node partitionList(int value) {
        Node D1 = new Node(0);
        Node D2 = new Node(0);
        Node prev1 = D1;
        Node prev2 = D2;
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current != null) { // Corrected condition
            if (current.value < value) {
                prev1.next = current;
                prev1 = prev1.next;
            } else {
                prev2.next = current;
                prev2 = prev2.next;
            }
            current = current.next;
        }

        prev2.next = null; // Terminate the second list
        prev1.next = D2.next; // Connect the first list to the second list

        return D1.next; // Return the head of the new list
    }

    public void reverseBetween(int startIndex, int endIndex){
        if (head == null) {
            return;
        }
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node prev = dummyNode;
        for (int i = 0; i < startIndex ; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        for (int j = 0; j < (endIndex - startIndex); j++) {
            Node tomove = current.next;
            current.next = tomove.next;
            tomove.next = prev.next;
            prev.next = tomove;
        }
        head = dummyNode.next;
    }

    public void swapPairs() {
        if (head == null || head.next == null) {
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevNode = dummy;
        Node currNode = head;

        while (currNode != null && currNode.next != null) {
            Node first = currNode;
            Node second = currNode.next;

            // Swapping
            prevNode.next = second;
            first.next = second.next;
            second.next = first;

            // Reinitializing for next swap
            prevNode = first;
            currNode = first.next;
        }

        head = dummy.next;
    }

}
