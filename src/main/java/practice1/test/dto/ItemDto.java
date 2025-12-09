package practice1.test.dto;


import lombok.Getter;
import lombok.Setter;
import practice1.test.model.Feature;

import java.util.List;

@Getter
@Setter
public class ItemDto {
    private Long id;

    private String nameDto;

    private String descriptionDto;

    private int price;


    private BrandDto brand;

    private List<Feature> features;
}
