package com.viettel.tuandz.service;

import com.viettel.tuandz.service.dto.EmployeeDTO;
import java.util.List;
import org.springframework.stereotype.Service;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> doSearch(EmployeeDTO employeeDTO);

    void delete(Long id);

    EmployeeDTO findById(Long id);
}
