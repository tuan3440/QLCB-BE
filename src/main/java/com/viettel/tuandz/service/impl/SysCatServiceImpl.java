package com.viettel.tuandz.service.impl;

import com.viettel.tuandz.repository.SysCatRepository;
import com.viettel.tuandz.service.SysCatService;
import com.viettel.tuandz.service.dto.SysCatDTO;
import com.viettel.tuandz.service.utils.DataUtil;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class SysCatServiceImpl implements SysCatService {

    @Autowired
    public SysCatRepository sysCatRepository;

    @Override
    public Page<SysCatDTO> doSearch(String code, String name, Pageable pageable) {
        if (StringUtils.isNotEmpty(code) && StringUtils.isNotBlank(code)) {
            code = DataUtil.makeLikeParam(code);
        }
        if (StringUtils.isNotEmpty(name) && StringUtils.isNotBlank(name)) {
            name = DataUtil.makeLikeParam(name);
        }
        Page<SysCatDTO> res = sysCatRepository.doSearch(code, name, pageable);
        List<SysCatDTO> sysCatDTOList = res.getContent();
        return new PageImpl<>(sysCatDTOList, pageable, res.getTotalElements());
    }
}
