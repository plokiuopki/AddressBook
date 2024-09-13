
 //Represents the address book, storing entries as a linked list of Nodes.

 public class Table {
    private Node head; // The head of the linked list
    private Node mark; // A marker for traversing the list

    public boolean insert(String key, String value) {
        // Check if the key already exists (ignoring case)
        if (lookup(key.toLowerCase()) != null) {
            return false; // Name already exists
        }

        Node newNode = new Node(key, value); // Creates a new Node with the given name and address

        // This set the new Node as the head, if the list is empty, 
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // Add the new Node to the end of the list
            current.setNext(newNode);
        }

        return true;
    }

    public String lookup(String key) {
        Node current = head; // Start from the beginning of the list
        while (current != null) {
            if (current.getKey().equalsIgnoreCase(key)) {
                return current.getValue(); // Found the entry
            }
            current = current.getNext(); // Move to the next Node
        }
        return null; // If name not found
    }


    public boolean delete(String key) {
        if (head == null) {
            return false; // List is empty
        }

        if (head.getKey().equals(key)) {
            head = head.getNext();
            return true;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getKey().equals(key)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }

        return false; // Name not found
    }


    public boolean update(String key, String newValue) {
        Node current = head;
        while (current != null) {
            if (current.getKey().equalsIgnoreCase(key)) {
                current.setValue(newValue);
                return true;
            }
            current = current.getNext();
        }
        return false; // Name not found
    }

    // Methods for marking and traversing


    public boolean markToStart() {
        mark = head;
        return mark != null;
    }


    public boolean advanceMark() {
        if (mark == null) {
            return false;
        }
        mark = mark.getNext();
        return true;
    }

 
    public String keyAtMark() {
        if (mark == null) {
            return null;
        }
        return mark.getKey();
    }


    public String valueAtMark() {
        if (mark == null) {
            return null;
        }
        return mark.getValue();
    }


    public int displayAll() {
        int count = 0;
        Node current = head;
        while (current != null) {
            System.out.println("Name: " + current.getKey() + ", Address: " + current.getValue());
            current = current.getNext();
            count++;
        }
        return count;
    }


    public boolean isEmpty() {
        return head == null;
    }
}