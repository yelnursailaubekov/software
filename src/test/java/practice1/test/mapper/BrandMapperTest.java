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
public class BrandMapperTest {

    @Autowired
    private BrandMapper mapper;


    @Test
    void convertEntityToDtoTest() {

        Brand entity = new Brand(1L, "brand");

        BrandDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());



        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());

    }

    @Test
    void convertDtoToEntityTest() {
        BrandDto dto = new BrandDto(1L, "Cat");

        Brand entity = mapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getName());


        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());


    }


    @Test
    void convertEntityListToDtoListTest() {

        List<Brand> entities = new ArrayList<>();
        entities.add(new Brand(1L, "test1"));
        entities.add(new Brand(2L, "test2"));
        entities.add(new Brand(3L, "test3"));

        List<BrandDto> dtos = mapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        Assertions.assertEquals(dtos.size(), entities.size());

        for ( int i = 0; i < dtos.size(); i++) {
            Brand entity = entities.get(i);
            BrandDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());

            Assertions.assertEquals(dto.getId(), entity.getId());
            Assertions.assertEquals(dto.getNameDto(), entity.getName());

        }

    }
}
