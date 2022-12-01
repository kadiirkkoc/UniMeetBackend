package edu.unimeet.dto;

import java.io.Serializable;

import edu.unimeet.entities.Department;
import edu.unimeet.entities.University;
import lombok.Getter;

@Getter
public class UniViewDto implements Serializable {
	private static final long serialVersionUID = 1L;
	String UniName;

	public UniViewDto(String uniName) {
		
		this.UniName = uniName;
	}
	public static UniViewDto of(University uni) {

        return new UniViewDto(uni.getUniName());}
	
	
	

}
