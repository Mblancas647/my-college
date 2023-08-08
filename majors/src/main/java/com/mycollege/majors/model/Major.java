package com.mycollege.majors.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("majors")
public class Major {
	@Id
	private String majorName;
	private String majorDescription;
	private String[] majorRequirements;
	private MajorType majorType;
	public Major(String majorName, String majorDescription, String[] majorRequirements, MajorType majorType) {
		super();
		this.majorName = majorName;
		this.majorDescription = majorDescription;
		this.majorRequirements = majorRequirements;
		this.majorType = majorType;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajorDescription() {
		return majorDescription;
	}
	public void setMajorDescription(String majorDescription) {
		this.majorDescription = majorDescription;
	}
	public String[] getMajorRequirements() {
		return majorRequirements;
	}
	public void setMajorRequirements(String[] majorRequirements) {
		this.majorRequirements = majorRequirements;
	}
	public MajorType getMajorType() {
		return majorType;
	}
	public void setMajorType(MajorType majorType) {
		this.majorType = majorType;
	}
	@Override
	public String toString() {
		return "Major [majorName=" + majorName + ", majorDescription=" + majorDescription + ", majorRequirements="
				+ Arrays.toString(majorRequirements) + ", majorType=" + majorType + "]";
	}
	
	
}
