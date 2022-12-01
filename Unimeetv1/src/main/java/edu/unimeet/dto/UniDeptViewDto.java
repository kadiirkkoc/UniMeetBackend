package edu.unimeet.dto;

import java.io.Serializable;

import edu.unimeet.entities.Post;
import edu.unimeet.entities.UniDept;

public class UniDeptViewDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private DepartmentViewDto departmentViewDto;
	private UniViewDto uniViewDto;
	public UniDeptViewDto(DepartmentViewDto departmentViewDto, UniViewDto uniViewDto) {
		this.departmentViewDto = departmentViewDto;
		this.uniViewDto = uniViewDto;
	}
	
	public static UniDeptViewDto of(UniDept uniDept) {
		

        return new UniDeptViewDto(DepartmentViewDto.of(uniDept.getDepartments()),UniViewDto.of(uniDept.getUniversities()));

    }
	
	

}
