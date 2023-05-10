package com.viettel.tuandz.service.mapper;

import com.viettel.tuandz.domain.SysCat;
import com.viettel.tuandz.service.dto.SysCatDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SysCatMapper extends EntityMapper<SysCatDTO, SysCat> {}
