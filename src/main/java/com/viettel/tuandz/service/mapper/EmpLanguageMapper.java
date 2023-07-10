package com.viettel.tuandz.service.mapper;

import com.viettel.tuandz.domain.EmpLanguage;
import com.viettel.tuandz.service.dto.EmpLanguageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EmpLanguageMapper extends EntityMapper<EmpLanguageDTO, EmpLanguage> {}
