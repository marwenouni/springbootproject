package com.myapp.demo.entity;

import java.util.Objects;

public class Produit {

	private String ref;
	private int quantite;
	private float prixUnitaire;

	public String getRef() {
		return ref;
	}

	public Produit() {
		super();
	}

	public Produit(String ref, int quantite, float prixUnitaire) {
		this.ref = ref;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ref);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(ref, other.ref);
	}
}
