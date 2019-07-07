package com.initapp.activitiesApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {

	@Id
	@GeneratedValue
	private Integer id;
	private String naziv;
	private String kategorija;
	private String podkategorija;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	public String getPodkategorija() {
		return podkategorija;
	}
	public void setPodkategorija(String podkategorija) {
		this.podkategorija = podkategorija;
	}
	public Activity(String naziv, String kategorija, String podkategorija) {
		this.naziv = naziv;
		this.kategorija = kategorija;
		this.podkategorija = podkategorija;
	}
	public Activity() {
		
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", naziv=" + naziv + ", kategorija=" + kategorija + ", podkategorija="
				+ podkategorija + "]";
	}
	
	
}
