package com.viettel.tuandz.service;

import com.viettel.tuandz.service.dto.SysCatItemDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysCatItemService {
    List<SysCatItemDTO> doSearch(Long sysCatId, String code, String name);

    SysCatItemDTO save(SysCatItemDTO sysCatItemDTO);

    SysCatItemDTO update(SysCatItemDTO sysCatItemDTO);

    void delete(Long id);
}
