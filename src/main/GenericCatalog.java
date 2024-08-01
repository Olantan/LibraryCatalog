package main;

import java.util.ArrayList;
import java.util.List;

public class GenericCatalog<T> {
    private List<T> items;

    public GenericCatalog() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public List<T> getAllItems() {
        return items;
    }
}
