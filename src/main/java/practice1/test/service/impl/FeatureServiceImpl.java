package practice1.test.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice1.test.dto.FeatureDto;
import practice1.test.dto.ItemDto;
import practice1.test.mapper.FeatureMapper;
import practice1.test.repository.FeatureRepository;
import practice1.test.service.FeatureService;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {


    private final FeatureRepository repository;
    private final FeatureMapper mapper;


    @Override
    public List<FeatureDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public FeatureDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public FeatureDto add(FeatureDto dto) {
        if (Objects.isNull(dto)) return null;

        return mapper.toDto(repository.save(mapper.toEntity(dto)));

    }

    @Override
    public FeatureDto update(Long id, FeatureDto dto) {
        FeatureDto update = getById(id);

        if (Objects.isNull(update) || Objects.isNull(dto)) return null;

        update.setNameDto(dto.getNameDto());
        return mapper.toDto(repository.save( mapper.toEntity(update)));
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);

        FeatureDto check = getById(id);
        if (Objects.isNull(check)) return true;

        return false;
    }
}
