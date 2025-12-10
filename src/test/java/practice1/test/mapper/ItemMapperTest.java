package practice1.test.mapper;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice1.test.dto.BrandDto;
import practice1.test.dto.FeatureDto;
import practice1.test.dto.ItemDto;
import practice1.test.model.Brand;
import practice1.test.model.Feature;
import practice1.test.model.Item;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper mapper;


    @Test
    void convertEntityToDtoTest() {
        Feature feature = new Feature(1L, "Cat");
        Brand brand = new Brand(1L, "brand");
        Item entity = new Item(1L, "Name", "Desc",234, brand, List.of(feature));

        ItemDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getDescriptionDto());
        Assertions.assertNotNull(dto.getPrice());
        Assertions.assertNotNull(dto.getBrand());
        Assertions.assertNotNull(dto.getFeatures());


        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getPrice(), entity.getPrice());
        Assertions.assertEquals(dto.getDescriptionDto(), entity.getDescription());


        Assertions.assertEquals(dto.getBrand().getId(), entity.getBrand().getId());
        Assertions.assertEquals(dto.getBrand().getNameDto(), entity.getBrand().getName());


        Assertions.assertEquals(dto.getFeatures().size(), entity.getFeatures().size());
        for (int i = 0; i < dto.getFeatures().size(); i ++) {
            Assertions.assertEquals(dto.getFeatures().get(i).getId(), entity.getFeatures().get(i).getId());
            Assertions.assertEquals(dto.getFeatures().get(i).getNameDto(), entity.getFeatures().get(i).getName());
        }

    }

    @Test
    void convertDtoToEntityTest() {
        BrandDto brand = new BrandDto(1L, "Cat");
        FeatureDto feature = new FeatureDto(1L, "country");
        ItemDto dto = new ItemDto(1L, "Name", "Dadfa", 234, brand, List.of(feature));

        Item entity = mapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getName());
        Assertions.assertNotNull(entity.getPrice());
        Assertions.assertNotNull(entity.getDescription());
        Assertions.assertNotNull(entity.getBrand());
        Assertions.assertNotNull(entity.getFeatures());

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getPrice(), entity.getPrice());
        Assertions.assertEquals(dto.getDescriptionDto(), entity.getDescription());


        Assertions.assertEquals(dto.getBrand().getId(), entity.getBrand().getId());
        Assertions.assertEquals(dto.getBrand().getNameDto(), entity.getBrand().getName());



        Assertions.assertEquals(dto.getFeatures().size(), entity.getFeatures().size());
        for (int i = 0; i < dto.getFeatures().size(); i ++) {
            Assertions.assertEquals(dto.getFeatures().get(i).getId(), entity.getFeatures().get(i).getId());
            Assertions.assertEquals(dto.getFeatures().get(i).getNameDto(), entity.getFeatures().get(i).getName());
        }



    }


    @Test
    void convertEntityListToDtoListTest() {
        Feature feature = new Feature(1L, "Cat");
        Brand brand = new Brand(1L, "country");

        List<Item> entities = new ArrayList<>();
        entities.add(new Item(1L, "test1", "asdf", 133, brand, List.of(feature)));
        entities.add(new Item(2L, "test2", "asgdadg", 234, brand, List.of(feature)));
        entities.add(new Item(3L, "test3","adsgagd", 49494, brand, List.of(feature)));

        List<ItemDto> dtos = mapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        Assertions.assertEquals(dtos.size(), entities.size());

        for ( int i = 0; i < dtos.size(); i++) {
            Item entity = entities.get(i);
            ItemDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getPrice());
            Assertions.assertNotNull(dto.getDescriptionDto());
            Assertions.assertNotNull(dto.getBrand());
            Assertions.assertNotNull(dto.getFeatures());


            Assertions.assertEquals(dto.getId(), entity.getId());
            Assertions.assertEquals(dto.getNameDto(), entity.getName());
            Assertions.assertEquals(dto.getPrice(), entity.getPrice());
            Assertions.assertNotNull(dto.getDescriptionDto(), entity.getDescription());

            Assertions.assertEquals(dto.getBrand().getId(), entity.getBrand().getId());
            Assertions.assertEquals(dto.getBrand().getNameDto(), entity.getBrand().getName());



            Assertions.assertEquals(dto.getFeatures().size(), entity.getFeatures().size());
            for (int j = 0; j < dto.getFeatures().size(); j ++) {
                Assertions.assertEquals(dto.getFeatures().get(j).getId(), entity.getFeatures().get(j).getId());
                Assertions.assertEquals(dto.getFeatures().get(j).getNameDto(), entity.getFeatures().get(j).getName());
            }

        }

    }
}

