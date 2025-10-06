package practice1.test.service;
import practice1.test.model.Item;
import java.util.List;
public interface ItemService {
    List<Item> getAll();
    Item getById(Long id);
    void addItem(Item item);
    void updateItem(Long id, Item item);
    void deleteItem(Long id);

}
