package practice1.test.dto;


import lombok.*;
import practice1.test.model.Feature;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long id;

    private String nameDto;

    private String descriptionDto;

    private int price;


    private BrandDto brand;

    private List<FeatureDto> features;
}
