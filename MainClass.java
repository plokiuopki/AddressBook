import java.util.Scanner; //imports scanner so that it can read user input

public class MainClass {

    public static void main(String[] args) {
        // Creates a Scanner object to read user input
        try (Scanner scanner = new Scanner(System.in)) {

            // Creates a new table object to represent the address book
            Table addressBook = new Table();

            // Loop continuously until the user quits
            while (true) {
                // Display the menu of options
                System.out.println("Add a name (n)");
                System.out.println("Look up a name (l)");
                System.out.println("Update address (u)");
                System.out.println("Delete an entry (d)");
                System.out.println("Display all entries (a)");
                System.out.println("Quit (q)");
                System.out.print("-> ");

                // Read the user's choice (first character of their input)
                char choice = scanner.nextLine().charAt(0);

                // Perform the action based on the user's choice
                switch (choice) {
                    case 'n':
                        // Adds a new entry
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Address: ");
                        String address = scanner.nextLine();

                        if (addressBook.insert(name, address)) {
                            System.out.println("Entry added successfully.");
                        } else {
                            System.out.println("Name already exists.");
                        }
                        break;
                    case 'l':
                        // Look up a name to see if it is already in the list or not and initiates next steps
                        System.out.print("Name: ");
                        String lookupName = scanner.nextLine();
                        if (addressBook.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            String foundAddress = addressBook.lookup(lookupName);
                            if (foundAddress != null) {
                                System.out.println("Address is " + foundAddress);
                            } else {
                                System.out.println("Name not found.");
                            }
                        }
                        break;
                    case 'u':
                        // Updates an address
                        System.out.print("Name: ");
                        String updateName = scanner.nextLine();
                        if (addressBook.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            String oldAddress = addressBook.lookup(updateName);
                            if (oldAddress != null) {
                                System.out.println("Old address is " + oldAddress);
                                System.out.print("New address: ");
                                String newAddress = scanner.nextLine();
                                addressBook.update(updateName, newAddress);
                                System.out.println("Address updated successfully.");
                            } else {
                                System.out.println("Name not found.");
                            }
                        }
                        break;
                    case 'd':
                        // Delete an entry
                        System.out.print("Name to delete: ");
                        String deleteName = scanner.nextLine();
                        if (addressBook.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            if (addressBook.delete(deleteName)) {
                                System.out.println("Entry deleted successfully.");
                            } else {
                                System.out.println("Name not found.");
                            }
                        }
                        break;
                    case 'a':
                        // Display all entries
                        if (addressBook.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            addressBook.displayAll();
                        }
                        break;
                    case 'q':
                        // Quits the program
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        // Handles invalid choices
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}