package com.viettel.tuandz.service;

import com.viettel.tuandz.service.dto.SysCatItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysCatItemService {
    Page<SysCatItemDTO> doSearch(Long sysCatId, String code, String name, Pageable pageable);

    SysCatItemDTO save(SysCatItemDTO sysCatItemDTO);

    SysCatItemDTO update(SysCatItemDTO sysCatItemDTO);

    void delete(Long id);
}
