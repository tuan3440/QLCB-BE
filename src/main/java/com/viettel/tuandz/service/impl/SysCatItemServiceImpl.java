package com.viettel.tuandz.service.impl;

import com.viettel.tuandz.domain.SysCatItem;
import com.viettel.tuandz.repository.SysCatItemRepository;
import com.viettel.tuandz.service.SysCatItemService;
import com.viettel.tuandz.service.dto.SysCatItemDTO;
import com.viettel.tuandz.service.mapper.SysCatItemMapper;
import com.viettel.tuandz.service.utils.DataUtil;
import com.viettel.tuandz.web.rest.errors.BadRequestAlertException;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysCatItemServiceImpl implements SysCatItemService {

    @Autowired
    public SysCatItemRepository sysCatItemRepository;

    @Autowired
    public SysCatItemMapper sysCatItemMapper;

    private static final String ENTITY_NAME = "sysCatItem";

    @Override
    public Page<SysCatItemDTO> doSearch(Long sysCatId, String code, String name, Pageable pageable) {
        if (StringUtils.isNotEmpty(code) && StringUtils.isNotBlank(code)) {
            code = DataUtil.makeLikeParam(code);
        }
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotBlank(name)) {
            name = DataUtil.makeLikeParam(name);
        }
        Page<SysCatItem> res = sysCatItemRepository.doSearch(sysCatId, code, name, pageable);
        List<SysCatItemDTO> sysCatItemDTOList = sysCatItemMapper.toDto(res.getContent());
        return new PageImpl<>(sysCatItemDTOList, pageable, res.getTotalElements());
    }

    @Override
    public SysCatItemDTO save(SysCatItemDTO sysCatItemDTO) {
        if (sysCatItemDTO.getCatId() != null) {
            throw new BadRequestAlertException("A new syscat item cannot already have an ID", ENTITY_NAME, "idexists");
        }
        if (sysCatItemRepository.existsByCode(sysCatItemDTO.getCode())) {
            throw new BadRequestAlertException("A new syscat item with code exist", ENTITY_NAME, "codeexists");
        }
        SysCatItem sysCatItem = sysCatItemMapper.toEntity(sysCatItemDTO);
        sysCatItem = sysCatItemRepository.save(sysCatItem);
        return sysCatItemMapper.toDto(sysCatItem);
    }

    @Override
    public SysCatItemDTO update(SysCatItemDTO sysCatItemDTO) {
        if (sysCatItemDTO.getCatId() == null) {
            throw new BadRequestAlertException("ERROR", ENTITY_NAME, "idnotfound");
        }
        if (!sysCatItemDTO.getCode().equals(sysCatItemRepository.findById(sysCatItemDTO.getCatId()).get().getCode())) {
            if (sysCatItemRepository.existsByCode(sysCatItemDTO.getCode())) {
                throw new BadRequestAlertException("A new syscat with code exist", ENTITY_NAME, "codeexists");
            }
        }
        Optional<SysCatItem> sysCatItemOptional = sysCatItemRepository.findById(sysCatItemDTO.getCatId());
        SysCatItem sysCatItem = sysCatItemOptional.get();
        sysCatItem.setCode(sysCatItemDTO.getCode());
        sysCatItem.setName(sysCatItemDTO.getName());
        sysCatItem.setCatTypeId(sysCatItemDTO.getCatTypeId());
        sysCatItem = sysCatItemRepository.save(sysCatItem);
        return sysCatItemMapper.toDto(sysCatItem);
    }

    @Override
    public void delete(Long id) {
        sysCatItemRepository.deleteById(id);
    }
}
