package com.viettel.tuandz.repository;

import com.viettel.tuandz.domain.SysCat;
import com.viettel.tuandz.service.dto.SysCatDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SysCatRepository extends JpaRepository<SysCat, Long> {
    @Query(
        value = "select sysCat " +
        "from SysCat sysCat " +
        "where 1=1 " +
        "and (:code is null or sysCat.code like :code) " +
        "and (:name is null or sysCat.name like :name)",
        countQuery = "select count(sysCat) from SysCat sysCat " +
        "where 1=1 " +
        "and (:code is null or sysCat.code like :code) " +
        "and (:name is null or sysCat.name like :name)"
    )
    List<SysCat> doSearch(@Param("code") String code, @Param("name") String name);

    boolean existsByCode(String code);
}
