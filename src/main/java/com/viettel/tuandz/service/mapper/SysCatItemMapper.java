package com.viettel.tuandz.service.mapper;

import com.viettel.tuandz.domain.SysCatItem;
import com.viettel.tuandz.service.dto.SysCatItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SysCatItemMapper extends EntityMapper<SysCatItemDTO, SysCatItem> {}
