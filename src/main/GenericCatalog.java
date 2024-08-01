import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericCatalog<T> {
    private List<LibraryItem<T>> catalog;

    public GenericCatalog() {
        this.catalog = new ArrayList<>();
    }

    public void addItem(LibraryItem<T> item) {
        catalog.add(item);
        System.out.println("Item added: " + item);
    }

    public void removeItem(T itemID) {
        Optional<LibraryItem<T>> itemToRemove = catalog.stream()
                .filter(item -> item.getItemID().equals(itemID))
                .findFirst();

        if (itemToRemove.isPresent()) {
            catalog.remove(itemToRemove.get());
            System.out.println("Item removed: " + itemToRemove.get());
        } else {
            System.out.println("Item not found with ID: " + itemID);
        }
    }

    public LibraryItem<T> getItem(T itemID) {
        return catalog.stream()
                .filter(item -> item.getItemID().equals(itemID))
                .findFirst()
                .orElse(null);
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            catalog.forEach(System.out::println);
        }
    }
}
