package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transcript {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;
	@Column(name = "Degree_Title")
	private String degreeTitle;

	public Transcript() {

	}

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

}
