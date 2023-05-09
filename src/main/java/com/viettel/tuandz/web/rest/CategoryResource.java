package com.viettel.tuandz.web.rest;

import com.viettel.tuandz.service.SysCatItemService;
import com.viettel.tuandz.service.SysCatService;
import com.viettel.tuandz.service.dto.SysCatDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping("/api")
@Slf4j
public class CategoryResource {

    @Autowired
    private SysCatService sysCatService;

    @PostMapping(value = "/cat/doSearch")
    public ResponseEntity<List<SysCatDTO>> doSearch(@RequestBody SysCatDTO paramSearch, Pageable pageable) {
        Page<SysCatDTO> res = sysCatService.doSearch(paramSearch.getCode(), paramSearch.getName(), pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), res);
        return ResponseEntity.ok().headers(headers).body(res.getContent());
    }
}
