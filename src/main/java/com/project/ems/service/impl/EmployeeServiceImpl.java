package com.project.ems.service.impl;

import com.project.ems.dto.EmployeeDto;
import com.project.ems.entity.Employee;
import com.project.ems.mapper.EmployeeMapper;
import com.project.ems.repository.EmployeeRepository;
import com.project.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //convert employeeDto to employee JPA entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        //save this employee JPA entity into the database
        Employee savedEmployee = employeeRepository.save(employee);

        //convert employee JPA entity to employeeDto and return
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
