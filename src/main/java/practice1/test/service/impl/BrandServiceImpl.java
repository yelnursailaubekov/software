package practice1.test.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice1.test.dto.BrandDto;
import practice1.test.dto.FeatureDto;
import practice1.test.mapper.BrandMapper;
import practice1.test.mapper.FeatureMapper;
import practice1.test.repository.BrandRepository;
import practice1.test.repository.FeatureRepository;
import practice1.test.service.BrandService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {


    private final BrandRepository repository;
    private final BrandMapper mapper;


    @Override
    public List<BrandDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public BrandDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public BrandDto add(BrandDto dto) {
        if (Objects.isNull(dto)) return null;

        return mapper.toDto(repository.save(mapper.toEntity(dto)));

    }

    @Override
    public BrandDto update(Long id, BrandDto dto) {
        BrandDto update = getById(id);

        if (Objects.isNull(update) || Objects.isNull(dto)) return null;

        update.setNameDto(dto.getNameDto());
        return mapper.toDto(repository.save( mapper.toEntity(update)));
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);

        BrandDto check = getById(id);
        if (Objects.isNull(check)) return true;

        return false;
    }
}
