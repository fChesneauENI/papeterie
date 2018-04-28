package fr.eni.papeterie.bo;


public class Ramette extends Article {

	private int grammage;

	// Constructeurs
	public Ramette(Integer idArticle, String reference, String marque, String designation, float prixUnitaire,
			int qteStock, int grammage) {
		// TODO Auto-generated constructor stub
		super(idArticle, reference, marque, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	public Ramette(String reference, String marque, String designation, float prixUnitaire, int qteStock,
			int grammage) {
		// TODO Auto-generated constructor stub
		super(reference, marque, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	// getters et setters
	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	// Méthode to String
	@Override
	public String toString() {
		return "Article [idArticle=" + this.getIdArticle() + ", reference=" + this.getReference() + ", marque="
				+ this.getMarque() + ", designation=" + this.getDesignation() + ", prixUnitaire=" + this.getPrixUnitaire() 
				+ ", qteStock=" + this.getQteStock() + "] Ramette [grammage=" + this.getGrammage() + "]";
	}

}
