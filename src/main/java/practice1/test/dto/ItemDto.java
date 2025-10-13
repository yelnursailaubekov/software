package practice1.test.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private Long id;

    private String nameDto;

    private String descriptionDto;

    private int price;
}
