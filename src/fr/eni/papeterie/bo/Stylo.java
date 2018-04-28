package fr.eni.papeterie.bo;


public class Stylo extends Article {

	private String couleur;

	// Constructeurs
	public Stylo(Integer idArticle, String reference, String marque, String designation, float prixUnitaire,
			int qteStock, String couleur) {
		// TODO Auto-generated constructor stub
		super(idArticle, reference, marque, designation, prixUnitaire, qteStock);
		this.couleur = couleur;

	}

	public Stylo(String reference, String marque, String designation, float prixUnitaire, int qteStock,
			String couleur) {
		// TODO Auto-generated constructor stub
		super(reference, marque, designation, prixUnitaire, qteStock);
		this.couleur = couleur;

	}

	// getters et setters
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	// Méthode to String
	@Override
	public String toString() {
		return "Article [idArticle=" + this.getIdArticle() + ", reference=" + this.getReference() + ", marque="
				+ this.getMarque() + ", designation=" + this.getDesignation() + ", prixUnitaire=" + this.getPrixUnitaire() + ", "
						+ "qteStock=" + this.getQteStock() +"] Stylo [couleur=" + this.getCouleur() +  "]";
	}
}
