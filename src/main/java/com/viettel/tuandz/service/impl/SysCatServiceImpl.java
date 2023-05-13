package com.viettel.tuandz.service.impl;

import com.viettel.tuandz.domain.SysCat;
import com.viettel.tuandz.repository.SysCatRepository;
import com.viettel.tuandz.service.SysCatService;
import com.viettel.tuandz.service.dto.SysCatDTO;
import com.viettel.tuandz.service.mapper.SysCatMapper;
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
public class SysCatServiceImpl implements SysCatService {

    @Autowired
    public SysCatRepository sysCatRepository;

    @Autowired
    public SysCatMapper sysCatMapper;

    private static final String ENTITY_NAME = "sysCat";

    @Override
    public Page<SysCatDTO> doSearch(String code, String name, Pageable pageable) {
        if (StringUtils.isNotEmpty(code) && StringUtils.isNotBlank(code)) {
            code = DataUtil.makeLikeParam(code);
        }
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotBlank(name)) {
            name = DataUtil.makeLikeParam(name);
        }
        Page<SysCat> res = sysCatRepository.doSearch(code, name, pageable);
        List<SysCatDTO> sysCatDTOList = sysCatMapper.toDto(res.getContent());
        return new PageImpl<>(sysCatDTOList, pageable, res.getTotalElements());
    }

    @Override
    public SysCatDTO save(SysCatDTO sysCatDTO) {
        if (sysCatDTO.getId() != null) {
            throw new BadRequestAlertException("A new syscat cannot already have an ID", ENTITY_NAME, "idexists");
        }
        if (sysCatRepository.existsByCode(sysCatDTO.getCode())) {
            throw new BadRequestAlertException("A new syscat with code exist", ENTITY_NAME, "codeexists");
        }
        SysCat sysCat = sysCatMapper.toEntity(sysCatDTO);
        sysCat = sysCatRepository.save(sysCat);
        return sysCatMapper.toDto(sysCat);
    }

    @Override
    public SysCatDTO update(SysCatDTO sysCatDTO) {
        if (sysCatDTO.getId() == null) {
            throw new BadRequestAlertException("ERROR", ENTITY_NAME, "idnotfound");
        }
        if (!sysCatDTO.getCode().equals(sysCatRepository.findById(sysCatDTO.getId()).get().getCode())) {
            if (sysCatRepository.existsByCode(sysCatDTO.getCode())) {
                throw new BadRequestAlertException("A new syscat with code exist", ENTITY_NAME, "codeexists");
            }
        }
        Optional<SysCat> sysCatOptional = sysCatRepository.findById(sysCatDTO.getId());
        SysCat sysCat = sysCatOptional.get();
        sysCat.setCode(sysCatDTO.getCode());
        sysCat.setName(sysCatDTO.getName());
        sysCat.setDescription(sysCatDTO.getDescription());
        sysCat = sysCatRepository.save(sysCat);
        return sysCatMapper.toDto(sysCat);
    }

    @Override
    public void delete(Long id) {
        sysCatRepository.deleteById(id);
    }
}
