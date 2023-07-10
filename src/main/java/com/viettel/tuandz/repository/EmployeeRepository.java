package com.viettel.tuandz.repository;

import com.viettel.tuandz.domain.Employee;
import com.viettel.tuandz.service.dto.EmployeeDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {
    boolean existsByCodeId(Long codeId);
}
