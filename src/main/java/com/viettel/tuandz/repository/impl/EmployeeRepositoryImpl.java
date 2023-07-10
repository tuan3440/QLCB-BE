package com.viettel.tuandz.repository.impl;

import com.viettel.tuandz.domain.Employee;
import com.viettel.tuandz.repository.EmployeeRepositoryCustom;
import com.viettel.tuandz.service.dto.EmployeeDTO;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @Autowired
    public EntityManager entityManager;

    @Override
    public List<Employee> doSearch(EmployeeDTO employeeDTO) {
        String sql =
            "select * from employee e where                              " +
            ":name is null or e.name like concat('%', :name, '%')                 " +
            "and (:codeId is null or e.code_id like concat('%', :codeId, '%'))           " +
            "and (:phone is null or e.phone like concat('%', :phone, '%'))              " +
            "and (:email is null or e.email like concat('%', :email, '%'))              " +
            "and (:dateBirthFrom is null or e.birthDay >= :dateBirthFrom)               " +
            "and (:dateBirthTo is null or e.birthDay <= :dateBirthTo)                   " +
            "and (:gender is null or e.gender = :gender)                                " +
            "order by e.id";
        Query query = entityManager.createNativeQuery(sql, Employee.class);
        query.setParameter("name", employeeDTO.getName());
        query.setParameter("codeId", employeeDTO.getCodeId());
        query.setParameter("phone", employeeDTO.getPhone());
        query.setParameter("email", employeeDTO.getEmail());
        query.setParameter("gender", employeeDTO.getGender());
        query.setParameter("dateBirthTo", employeeDTO.getDateBirthTo());
        query.setParameter("dateBirthFrom", employeeDTO.getDateBirthFrom());
        List<Employee> result = query.getResultList();
        List<Employee> result1 = result
            .stream()
            .filter(r -> {
                if (employeeDTO.getDateBirthFrom() != null) {
                    return r.getBirthDay().isAfter(employeeDTO.getDateBirthFrom());
                }
                return true;
            })
            .collect(Collectors.toList());
        List<Employee> result2 = result1
            .stream()
            .filter(r -> {
                if (employeeDTO.getDateBirthTo() != null) {
                    return r.getBirthDay().isBefore(employeeDTO.getDateBirthTo());
                }
                return true;
            })
            .collect(Collectors.toList());
        return result2;
    }
}
