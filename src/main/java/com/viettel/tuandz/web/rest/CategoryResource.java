package com.viettel.tuandz.web.rest;

import com.viettel.tuandz.service.SysCatItemService;
import com.viettel.tuandz.service.SysCatService;
import com.viettel.tuandz.service.dto.SysCatDTO;
import com.viettel.tuandz.service.dto.SysCatItemDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping("/api")
public class CategoryResource {

    @Autowired
    private SysCatService sysCatService;

    @Autowired
    private SysCatItemService sysCatItemService;

    @PostMapping(value = "/cat/doSearch")
    public ResponseEntity<List<SysCatDTO>> doSearch(@RequestBody SysCatDTO paramSearch, Pageable pageable) {
        Page<SysCatDTO> res = sysCatService.doSearch(paramSearch.getCode(), paramSearch.getName(), pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), res);
        return ResponseEntity.ok().headers(headers).body(res.getContent());
    }

    @PostMapping(value = "/cat/insert")
    public ResponseEntity<SysCatDTO> createCat(@RequestBody SysCatDTO sysCatDTO) {
        SysCatDTO result = sysCatService.save(sysCatDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/cat/update")
    public ResponseEntity<SysCatDTO> updateCat(@RequestBody SysCatDTO sysCatDTO) {
        SysCatDTO result = sysCatService.update(sysCatDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/cat/delete/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id) {
        sysCatService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/cat-item/doSearch")
    public ResponseEntity<List<SysCatItemDTO>> doSearch(@RequestBody SysCatItemDTO paramSearch, Pageable pageable) {
        Page<SysCatItemDTO> res = sysCatItemService.doSearch(
            paramSearch.getCatTypeId(),
            paramSearch.getCode(),
            paramSearch.getName(),
            pageable
        );
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), res);
        return ResponseEntity.ok().headers(headers).body(res.getContent());
    }

    @PostMapping(value = "/cat-item/insert")
    public ResponseEntity<SysCatItemDTO> createCatItem(@RequestBody SysCatItemDTO sysCatItemDTO) {
        SysCatItemDTO result = sysCatItemService.save(sysCatItemDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/cat-item/update")
    public ResponseEntity<SysCatItemDTO> updateCat(@RequestBody SysCatItemDTO sysCatItemDTO) {
        SysCatItemDTO result = sysCatItemService.update(sysCatItemDTO);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping(value = "/cat-item/delete/{id}")
    public ResponseEntity<Void> deleteCatItem(@PathVariable Long id) {
        sysCatItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
