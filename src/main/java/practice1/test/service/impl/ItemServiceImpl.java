package practice1.test.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice1.test.dto.ItemDto;
import practice1.test.mapper.ItemMapper;
import practice1.test.model.Item;
import practice1.test.repository.ItemRepository;
import practice1.test.service.ItemService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDto> getAll() {
        return itemMapper.toDtoList(itemRepository.findAll());
    }

    @Override
    public ItemDto getById(Long id) {
        return itemMapper.toDto(itemRepository.findById(id).orElse(null));
    }

    @Override
    public ItemDto addItem(ItemDto item) {
        if (Objects.isNull(item)) return null;

        return itemMapper.toDto(itemRepository.save(itemMapper.toEntity(item)));

    }

    @Override
    public ItemDto updateItem(Long id, ItemDto item) {
        ItemDto updateItem = getById(id);

        if (Objects.isNull(updateItem) || Objects.isNull(item)) return null;

        updateItem.setNameDto(item.getNameDto());
        updateItem.setDescriptionDto(item.getDescriptionDto());
        updateItem.setPrice(item.getPrice());
        updateItem.setBrand(item.getBrand());
        updateItem.setFeatures(item.getFeatures());
        return itemMapper.toDto(itemRepository.save(itemMapper.toEntity(updateItem)));

    }

    @Override
    public boolean deleteItem(Long id) {
        itemRepository.deleteById(id);

        ItemDto check = getById(id);
        if (Objects.isNull(check)) return true;

        return false;

    }
}
