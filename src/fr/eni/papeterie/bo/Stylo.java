package fr.eni.papeterie.bo;

public class Stylo extends Article
{
	private String couleur;

	//Getters/Setters
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	//Constructors
	public Stylo(int idArticle, String marque, String reference, String designation, float prixUnitaire, int qteStock,
			String couleur) {
		super(idArticle, marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}
	public Stylo(String marque, String reference, String designation, float prixUnitaire, int qteStock,
			String couleur) {
		super(marque, reference, designation, prixUnitaire, qteStock);
		this.couleur = couleur;
	}

	//toString
	@Override
	public String toString() {
		return "Stylo [couleur=" + couleur + ", idArticle=" + this.getIdArticle() + ", reference=" + this.getReference() + ", marque="
				+ this.getMarque() + ", designation=" + this.getDesignation() + ", prixUnitaire=" + this.getPrixUnitaire() + ", qteStock=" + this.getQteStock()
				+ "]";
	}
	
}
