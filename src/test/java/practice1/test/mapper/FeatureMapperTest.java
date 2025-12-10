package practice1.test.mapper;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice1.test.dto.BrandDto;
import practice1.test.dto.FeatureDto;
import practice1.test.model.Brand;
import practice1.test.model.Feature;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FeatureMapperTest {

    @Autowired
    private FeatureMapper mapper;


    @Test
    void convertEntityToDtoTest() {

        Feature entity = new Feature(1L, "brand");

        FeatureDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());



        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());

    }

    @Test
    void convertDtoToEntityTest() {
        FeatureDto dto = new FeatureDto(1L, "Cat");

        Feature entity = mapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getName());


        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());


    }


    @Test
    void convertEntityListToDtoListTest() {

        List<Feature> entities = new ArrayList<>();
        entities.add(new Feature(1L, "test1"));
        entities.add(new Feature(2L, "test2"));
        entities.add(new Feature(3L, "test3"));

        List<FeatureDto> dtos = mapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        Assertions.assertEquals(dtos.size(), entities.size());

        for ( int i = 0; i < dtos.size(); i++) {
            Feature entity = entities.get(i);
            FeatureDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());

            Assertions.assertEquals(dto.getId(), entity.getId());
            Assertions.assertEquals(dto.getNameDto(), entity.getName());

        }

    }
}
