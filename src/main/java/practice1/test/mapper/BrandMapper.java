package practice1.test.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import practice1.test.dto.BrandDto;
import practice1.test.model.Brand;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper{


    @Mapping(target = "name", source = "nameDto")
    Brand toEntity(BrandDto dto);


    @Mapping(target = "nameDto", source = "name")
    BrandDto toDto(Brand brand);


    List<BrandDto> toDtoList(List<Brand> brands);


}
