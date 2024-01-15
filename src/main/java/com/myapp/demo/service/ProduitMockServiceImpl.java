package com.myapp.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myapp.demo.entity.Produit;

@Service
public class ProduitMockServiceImpl implements IProduitService{

	List<Produit> produits;
	
	
	public ProduitMockServiceImpl() {
		
		 produits=new ArrayList<Produit>();
		 produits.add(new Produit("cahier",8,12));
		 produits.add(new Produit("stylo",7,12));
		 produits.add(new Produit("regle",13,18));
		 produits.add(new Produit("gomme",13,18));
	}

	@Override
	public List<Produit> getProduits() {
		return produits;
	}
	
	@Override
	public Produit getProduit(String ref) {
		for(Produit produit : this.produits)
		{
			if (produit.getRef().equals(ref))
				return produit;
						
		}
		return null;
	}

	@Override
	public void addProduit(Produit produit) {
		produits.add(produit);
		
	}

	@Override
	public void updateProduit(Produit produit) {
		System.out.println(getProduit(produit.getRef()));
		if(getProduit(produit.getRef())!=null)
		{
			deleteProduit(produit.getRef());
			produits.add(produit);
		}
		
		
	}

	@Override
	public void deleteProduit(String ref) {
		Produit produit= new Produit();
		produit.setRef(ref);
		produits.remove(produit);
		
	}

}
