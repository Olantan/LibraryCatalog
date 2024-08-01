package main;

import java.util.Scanner;

public class LibraryCatalogApp {
    public static void main(String[] args) {
        GenericCatalog<LibraryItem> catalog = new GenericCatalog<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View items");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter item ID: ");
                    String itemID = scanner.nextLine();
                    LibraryItem item = new LibraryItem(title, author, itemID);
                    catalog.addItem(item);
                    break;
                case 2:
                    System.out.print("Enter item ID to remove: ");
                    String removeID = scanner.nextLine();
                    LibraryItem removeItem = null;
                    for (LibraryItem i : catalog.getAllItems()) {
                        if (i.getItemID().equals(removeID)) {
                            removeItem = i;
                            break;
                        }
                    }
                    if (removeItem != null) {
                        catalog.removeItem(removeItem);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 3:
                    for (LibraryItem i : catalog.getAllItems()) {
                        System.out.println("Title: " + i.getTitle() + ", Author: " + i.getAuthor() + ", ID: " + i.getItemID());
                    }
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
