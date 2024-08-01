import java.util.Scanner;

public class LibraryCatalogApp {
    public static void main(String[] args) {
        GenericCatalog<String> catalog = new GenericCatalog<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Catalog System:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Item");
            System.out.println("4. Display Catalog");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    String itemID = scanner.nextLine();
                    LibraryItem<String> newItem = new LibraryItem<>(title, author, itemID);
                    catalog.addItem(newItem);
                    break;
                case 2:
                    System.out.print("Enter item ID to remove: ");
                    String removeID = scanner.nextLine();
                    catalog.removeItem(removeID);
                    break;
                case 3:
                    System.out.print("Enter item ID to view: ");
                    String viewID = scanner.nextLine();
                    LibraryItem<String> item = catalog.getItem(viewID);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found with ID: " + viewID);
                    }
                    break;
                case 4:
                    catalog.displayCatalog();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
