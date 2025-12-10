package practice1.test.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice1.test.dto.BrandDto;
import practice1.test.dto.FeatureDto;
import practice1.test.dto.ItemDto;

import java.util.List;
import java.util.Random;


@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService service;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private BrandService brandService;

    @Test
    void getAllTest() {

        List<ItemDto> dtos = service.getAll();


        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (ItemDto dto : dtos) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getPrice());
            Assertions.assertNotNull(dto.getDescriptionDto());
            Assertions.assertNotNull(dto.getBrand());
            Assertions.assertNotNull(dto.getFeatures());
        }

    }


    @Test
    void getByIdTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        ItemDto dto = service.getById(someIndex);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getPrice());
        Assertions.assertNotNull(dto.getDescriptionDto());
        Assertions.assertNotNull(dto.getBrand());
        Assertions.assertNotNull(dto.getFeatures());

    }


    @Test
    void addTest() {

        int before = service.getAll().size();


        FeatureDto featureDto = new FeatureDto();
        featureDto.setNameDto("Test-Categ");
        FeatureDto savedFeature = featureService.add(featureDto);
        BrandDto brandDto = new BrandDto();
        brandDto.setNameDto("Test-Country");
        BrandDto savedBrand = brandService.add(brandDto);

        ItemDto itemDto = new ItemDto();
        itemDto.setNameDto("TestName");
        itemDto.setPrice(1333);
        itemDto.setDescriptionDto("test");
        itemDto.setBrand(savedBrand);
        itemDto.setFeatures(List.of(savedFeature));
        ItemDto savedItem = service.addItem(itemDto);

        Assertions.assertNotNull(savedItem);
        Assertions.assertNotNull(savedItem.getId());
        Assertions.assertNotNull(savedItem.getNameDto());
        Assertions.assertNotNull(savedItem.getPrice());
        Assertions.assertNotNull(savedItem.getDescriptionDto());
        Assertions.assertNotNull(savedItem.getBrand());
        Assertions.assertNotNull(savedItem.getFeatures());

        ItemDto savedTest = service.getById(savedItem.getId());

        Assertions.assertNotNull(savedTest);
        Assertions.assertNotNull(savedTest.getId());
        Assertions.assertNotNull(savedTest.getNameDto());
        Assertions.assertNotNull(savedTest.getPrice());
        Assertions.assertNotNull(savedTest.getDescriptionDto());
        Assertions.assertNotNull(savedTest.getBrand());
        Assertions.assertNotNull(savedTest.getFeatures());

        Assertions.assertEquals(savedItem.getId(), savedTest.getId());
        Assertions.assertEquals(savedItem.getNameDto(), savedTest.getNameDto());
        Assertions.assertEquals(savedItem.getPrice(), savedTest.getPrice());
        Assertions.assertEquals(savedItem.getDescriptionDto(), savedTest.getDescriptionDto());
        Assertions.assertEquals(savedItem.getBrand(), savedTest.getBrand());
        Assertions.assertEquals(savedItem.getFeatures(), savedTest.getFeatures());

        int after = service.getAll().size();
        Assertions.assertEquals(before+1, after);




    }

    @Test
    void updateTest() {

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        ItemDto current = service.getById(someIndex);

        ItemDto newItem = new ItemDto(someIndex, "TestUpdate","desc", 200, current.getBrand(), current.getFeatures());

        ItemDto updated = service.updateItem(someIndex, newItem);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getPrice());
        Assertions.assertNotNull(updated.getDescriptionDto());
        Assertions.assertNotNull(updated.getBrand());
        Assertions.assertNotNull(updated.getFeatures());

        ItemDto updateTest = service.getById(someIndex);

        Assertions.assertNotNull(updateTest);
        Assertions.assertNotNull(updateTest.getId());
        Assertions.assertNotNull(updateTest.getNameDto());
        Assertions.assertNotNull(updateTest.getPrice());
        Assertions.assertNotNull(updateTest.getDescriptionDto());
        Assertions.assertNotNull(updateTest.getBrand());
        Assertions.assertNotNull(updated.getFeatures());

        Assertions.assertEquals(updated.getId(), updateTest.getId());
        Assertions.assertEquals(updated.getNameDto(), updateTest.getNameDto());
        Assertions.assertEquals(updated.getPrice(), updateTest.getPrice());
        Assertions.assertEquals(updated.getDescriptionDto(), updateTest.getDescriptionDto());
        Assertions.assertEquals(updated.getBrand(), updateTest.getBrand());
        Assertions.assertEquals(updated.getFeatures(), updateTest.getFeatures());



    }


    @Test
    void deleteTest() {
        int before = service.getAll().size();

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();

        boolean deleted = service.deleteItem(someIndex);
        Assertions.assertTrue(deleted);

        ItemDto deletedTest = service.getById(someIndex);
        Assertions.assertNull(deletedTest);


        int after = service.getAll().size();
        Assertions.assertEquals(before-1,after);



    }

}
