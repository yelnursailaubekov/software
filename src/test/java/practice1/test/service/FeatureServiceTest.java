package practice1.test.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practice1.test.dto.BrandDto;
import practice1.test.dto.FeatureDto;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class FeatureServiceTest {


    @Autowired
    private FeatureService service;



    @Test
    void getAllTest() {

        List<FeatureDto> dtos = service.getAll();


        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (FeatureDto dto : dtos) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
        }

    }


    @Test
    void getByIdTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        FeatureDto dto = service.getById(someIndex);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());

    }


    @Test
    void addTest() {

        int before = service.getAll().size();



        FeatureDto featureDto = new FeatureDto();
        featureDto.setNameDto("Test-Country");
        FeatureDto saved = service.add(featureDto);


        Assertions.assertNotNull(saved);
        Assertions.assertNotNull(saved.getId());
        Assertions.assertNotNull(saved.getNameDto());


        FeatureDto savedTest = service.getById(saved.getId());

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


        FeatureDto current = service.getById(someIndex);

        FeatureDto newFeature = new FeatureDto(someIndex, "TestUpdate");

        FeatureDto updated = service.update(someIndex, newFeature);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());


        FeatureDto updateTest = service.getById(someIndex);

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

        FeatureDto deletedTest = service.getById(someIndex);
        Assertions.assertNull(deletedTest);


        int after = service.getAll().size();
        Assertions.assertEquals(before-1,after);



    }

}
