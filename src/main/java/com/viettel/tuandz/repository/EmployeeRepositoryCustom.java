package com.viettel.tuandz.repository;

import com.viettel.tuandz.domain.Employee;
import com.viettel.tuandz.service.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> doSearch(EmployeeDTO employeeDTO);
}
