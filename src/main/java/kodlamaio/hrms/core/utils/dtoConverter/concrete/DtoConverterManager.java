package kodlamaio.hrms.core.utils.dtoConverter.concrete;

import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtoConverterManager implements DtoConverterService {

    private ModelMapper modelMapper;

    @Autowired
    public DtoConverterManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <S, T> List<T> entityToDto(List<S> listTypeEntityClass, Class<T> targetDtoClass) {

        return listTypeEntityClass.stream().map(element -> modelMapper.map(element, targetDtoClass))
                .collect(Collectors.toList());
    }

    @Override
    public <T> Object dtoToEntity(Object dtoClass, Class<T> targetEntityClass) {
        return modelMapper.map(dtoClass, targetEntityClass);
    }
}