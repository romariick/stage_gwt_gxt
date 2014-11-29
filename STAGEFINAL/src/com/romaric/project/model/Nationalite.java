package com.romaric.project.model;

import java.io.Serializable;

public class Nationalite implements Serializable{
	
	public String nationalite;

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Nationalite() {
		// TODO Auto-generated constructor stub
	}

	public Nationalite(String nationalite) {
		super();
		this.nationalite = nationalite;
	}
	
}
