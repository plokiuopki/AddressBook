
 //Node represents a single entry in the address book.
 //Each Node object stores a name (key) and an address (value).
 //It also has a `next` pointer to link it to the next Node in the linked list.
 
public class Node {
    private String key; // The name (key) of the entry
    private String value; // The address (value) associated with the name
    private Node next; // A pointer to the next Node in the linked list

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getters and setters for key and value
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}