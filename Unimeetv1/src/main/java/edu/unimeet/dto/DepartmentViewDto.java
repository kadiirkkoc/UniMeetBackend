package edu.unimeet.dto;

import java.io.Serializable;

import edu.unimeet.entities.Department;
import edu.unimeet.entities.User;
import lombok.Getter;

@Getter
public class DepartmentViewDto implements Serializable {
	private static final long serialVersionUID = 1L;
	String DeptName;

	public DepartmentViewDto(String deptName) {
		
		this.DeptName = deptName;
	}
	
	 public static DepartmentViewDto of(Department dept) {

	        return new DepartmentViewDto(dept.getDeptName());}
	
	
	

}
