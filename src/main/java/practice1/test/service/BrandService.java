package practice1.test.service;

import practice1.test.dto.BrandDto;
import practice1.test.dto.ItemDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAll();
    BrandDto getById(Long id);
    BrandDto add(BrandDto dto);
    BrandDto update(Long id, BrandDto dto);
    boolean delete(Long id);

}
