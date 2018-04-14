package fr.eni.papeterie.bo;

public class Ramette extends Article
{
	private int grammage;

	//Getters/Setters
	public int getGrammage() {
		return grammage;
	}

	public void setGrammage(int grammage) {
		this.grammage = grammage;
	}

	//Constructors
	public Ramette(int idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock,
			int grammage) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}
	public Ramette(String marque, String reference, String designation, float prixUnitaire, int qteStock,
			int grammage) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.grammage = grammage;
	}

	//toString
	@Override
	public String toString() {
		return "Ramette [grammage=" + grammage + ", idArticle=" + this.getIdArticle() + ", reference=" + this.getReference() + ", marque="
				+ this.getMarque() + ", designation=" + this.getDesignation() + ", prixUnitaire=" + this.getPrixUnitaire() + ", qteStock=" + this.getQteStock()
				+ "]";
	}
	
	
}
