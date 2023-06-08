package com.viettel.tuandz.service.mapper;

import com.viettel.tuandz.domain.Employee;
import com.viettel.tuandz.service.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {}
