package com.devsuperior.bds01.services;

import com.devsuperior.bds01.Repositories.EmployeeRepository;
import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAllPaged(Pageable pageable){
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page.map(x-> new EmployeeDTO(x));
    }

    @Transactional
    public  EmployeeDTO insert(EmployeeDTO dto){
        Employee entity = new Employee();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setDepartment(new Department(dto.getDepartmentId(), null));
       entity =  employeeRepository.save(entity);
        return new EmployeeDTO(entity);
    }



}
