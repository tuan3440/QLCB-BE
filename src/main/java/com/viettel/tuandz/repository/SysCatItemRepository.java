package com.viettel.tuandz.repository;

import com.viettel.tuandz.domain.SysCat;
import com.viettel.tuandz.domain.SysCatItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SysCatItemRepository extends JpaRepository<SysCatItem, Long> {
    @Query(
        value = "select sysCatItem " +
        "from SysCatItem sysCatItem " +
        "where 1=1 " +
        "and (:code is null or sysCatItem.code like :code) " +
        "and (:sysCatId is null or sysCatItem.catTypeId = :sysCatId) " +
        "and (:name is null or sysCatItem.name like :name)",
        countQuery = "select count(sysCatItem) from SysCatItem sysCatItem " +
        "where 1=1 " +
        "and (:code is null or sysCatItem.code like :code) " +
        "and (:sysCatId is null or sysCatItem.catTypeId = :sysCatId) " +
        "and (:name is null or sysCatItem.name like :name)"
    )
    Page<SysCatItem> doSearch(@Param("sysCatId") Long sysCatId, @Param("code") String code, @Param("name") String name, Pageable pageable);

    boolean existsByCode(String code);
}
