package practice1.test.service;


import practice1.test.dto.BrandDto;
import practice1.test.dto.FeatureDto;

import java.util.List;

public interface FeatureService {

    List<FeatureDto> getAll();
    FeatureDto getById(Long id);
    FeatureDto add(FeatureDto dto);
    FeatureDto update(Long id, FeatureDto dto);
    boolean delete(Long id);

}