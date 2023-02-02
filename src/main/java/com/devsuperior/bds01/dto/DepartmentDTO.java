package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

public class DepartmentDTO {

    public long id;
    public String name;

    public DepartmentDTO(long id, String name){
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(){

    }

    public DepartmentDTO(Department entity){
        id = entity.getId();
        name = entity.getName();
    }

    public long getId(){return  id;}

    public String getName(){return  name;}

    public void setId(long id){this.id = id;}

    public void setName(String name){this.name = name;}
}
