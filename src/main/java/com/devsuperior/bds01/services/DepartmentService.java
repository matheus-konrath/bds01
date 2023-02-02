package com.devsuperior.bds01.services;

import com.devsuperior.bds01.Repositories.DepartmentRepository;
import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Page<DepartmentDTO> findAllPage(Pageable pageable){
        Page<Department> list = departmentRepository.findAll(pageable);
        return list.map(x -> new DepartmentDTO(x));
    }
}
