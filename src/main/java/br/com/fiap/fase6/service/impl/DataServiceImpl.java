package br.com.fiap.fase6.service.impl;

import br.com.fiap.fase6.domain.datainfo.DataInfo;
import br.com.fiap.fase6.domain.datainfo.DataInfoDto;
import br.com.fiap.fase6.domain.datainfo.DataInfoStatusEnum;
import br.com.fiap.fase6.repository.DataRepository;
import br.com.fiap.fase6.service.DataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataServiceImpl implements DataService {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private DataRepository dataRepository;

  @Override
  public DataInfoDto input(DataInfoDto data) {
    if (data != null && data.getId() != null) {
      Optional<DataInfo> found = this.dataRepository.findById(data.getId());
      if (found.isPresent()) {
        DataInfo existing = found.get();
        existing.setStatus(DataInfoStatusEnum.NOK);
        return modelMapper.map(existing, DataInfoDto.class);
      }
    }

    DataInfo entry = modelMapper.map(data, DataInfo.class);
    entry.setStatus(DataInfoStatusEnum.OK);
    DataInfo saved = this.dataRepository.save(entry);
    return modelMapper.map(saved, DataInfoDto.class);
  }

}
