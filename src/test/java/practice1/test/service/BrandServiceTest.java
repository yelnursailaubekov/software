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
public class BrandServiceTest {

    @Autowired
    private BrandService service;



    @Test
    void getAllTest() {

        List<BrandDto> dtos = service.getAll();


        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (BrandDto dto : dtos) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
        }

    }


    @Test
    void getByIdTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        BrandDto dto = service.getById(someIndex);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());

    }


    @Test
    void addTest() {

        int before = service.getAll().size();



        BrandDto brandDto = new BrandDto();
        brandDto.setNameDto("Test-Country");
        BrandDto saved = service.add(brandDto);


        Assertions.assertNotNull(saved);
        Assertions.assertNotNull(saved.getId());
        Assertions.assertNotNull(saved.getNameDto());


        BrandDto savedTest = service.getById(saved.getId());

        Assertions.assertNotNull(savedTest);
        Assertions.assertNotNull(savedTest.getId());
        Assertions.assertNotNull(savedTest.getNameDto());


        Assertions.assertEquals(saved.getId(), savedTest.getId());
        Assertions.assertEquals(saved.getNameDto(), savedTest.getNameDto());


        int after = service.getAll().size();
        Assertions.assertEquals(before+1, after);




    }

    @Test
    void updateTest() {

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        BrandDto current = service.getById(someIndex);

        BrandDto newBrand = new BrandDto(someIndex, "TestUpdate");

        BrandDto updated = service.update(someIndex, newBrand);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());


        BrandDto updateTest = service.getById(someIndex);

        Assertions.assertNotNull(updateTest);
        Assertions.assertNotNull(updateTest.getId());
        Assertions.assertNotNull(updateTest.getNameDto());

        Assertions.assertEquals(updated.getId(), updateTest.getId());
        Assertions.assertEquals(updated.getNameDto(), updateTest.getNameDto());


    }


    @Test
    void deleteTest() {
        int before = service.getAll().size();

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();

        boolean deleted = service.delete(someIndex);
        Assertions.assertTrue(deleted);

        BrandDto deletedTest = service.getById(someIndex);
        Assertions.assertNull(deletedTest);


        int after = service.getAll().size();
        Assertions.assertEquals(before-1,after);



    }


}
