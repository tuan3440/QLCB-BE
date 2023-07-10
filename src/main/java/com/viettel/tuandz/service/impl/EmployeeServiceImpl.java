package com.viettel.tuandz.service.impl;

import com.viettel.tuandz.domain.Employee;
import com.viettel.tuandz.repository.EmployeeRepository;
import com.viettel.tuandz.service.EmployeeService;
import com.viettel.tuandz.service.dto.EmployeeDTO;
import com.viettel.tuandz.service.mapper.EmployeeMapper;
import com.viettel.tuandz.service.mapper.EmployeeMapperImpl;
import com.viettel.tuandz.web.rest.errors.BadRequestAlertException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    private static final String ENTITY_NAME = "employee";

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        if (employeeRepository.existsByCodeId(employeeDTO.getCodeId()) && employeeDTO.getId() == null) {
            throw new BadRequestAlertException("A new employee with code exist", ENTITY_NAME, "codeIdexists");
        }
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee result = employeeRepository.save(employee);
        return employeeMapper.toDto(result);
    }

    @Override
    public List<EmployeeDTO> doSearch(EmployeeDTO employeeDTO) {
        List<Employee> res = employeeRepository.doSearch(employeeDTO);
        List<EmployeeDTO> dto = employeeMapper.toDto(res);
        return dto;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            return employeeMapper.toDto(employee);
        }
        return null;
    }
}
