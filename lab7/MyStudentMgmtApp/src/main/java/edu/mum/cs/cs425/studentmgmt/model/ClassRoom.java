package edu.mum.cs.cs425.studentmgmt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ClassRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long classRoomId;
	@Column(name = "Building_Name", nullable = false)
	private String buildingName;
	@Column(name = "Room_Number", nullable = false)
	private Long roomNumber;
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "classRoom")
    private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public ClassRoom() {

	}

	public ClassRoom(String buildingName, long roomNumber) {

		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Long getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(Long classRoomId) {
		this.classRoomId = classRoomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

}
