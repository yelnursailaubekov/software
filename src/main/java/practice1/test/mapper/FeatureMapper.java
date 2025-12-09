package practice1.test.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import practice1.test.dto.BrandDto;
import practice1.test.dto.FeatureDto;
import practice1.test.model.Brand;
import practice1.test.model.Feature;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeatureMapper {

    @Mapping(target = "name", source = "nameDto")
    Feature toEntity(FeatureDto dto);


    @Mapping(target = "nameDto", source = "name")
    FeatureDto toDto(Feature entity);


    List<FeatureDto> toDtoList(List<Feature> entities);




}
