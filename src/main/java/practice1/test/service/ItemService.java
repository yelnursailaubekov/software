package practice1.test.service;
import practice1.test.dto.ItemDto;
import practice1.test.model.Item;
import java.util.List;
public interface ItemService {
    List<ItemDto> getAll();
    ItemDto getById(Long id);
    boolean addItem(ItemDto item);
    boolean updateItem(Long id, ItemDto item);
    void deleteItem(Long id);

}
