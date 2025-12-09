package practice1.test.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import practice1.test.dto.ItemDto;
import practice1.test.model.Item;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BrandMapper.class, FeatureMapper.class})
public interface ItemMapper {


    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "descriptionDto", source = "description")
    ItemDto toDto(Item item);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "description", source = "descriptionDto")
    Item toEntity(ItemDto dto);


    List<ItemDto> toDtoList(List<Item> items);
}
