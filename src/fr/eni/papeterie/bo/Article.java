package fr.eni.papeterie.bo;


public abstract class Article {
	private Integer idArticle;
	private String reference;
	private String marque;
	private String designation;
	private float prixUnitaire;
	private int qteStock;

	// Constructeurs
	public Article(Integer idArticle, String reference, String marque, String designation, float prixUnitaire,
			int qteStock) {
		this.idArticle = idArticle;
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}

	public Article(String reference, String marque, String designation, float prixUnitaire, int qteStock) {		
		this.reference = reference;
		this.marque = marque;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.qteStock = qteStock;
	}

	// getters et setters
	public Integer getIdArticle() {
		return idArticle;
	}

	public String getReference() {
		return reference;
	}

	public String getMarque() {
		return marque;
	}

	public String getDesignation() {
		return designation;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	// M�thode to String
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", reference=" + reference + ", marque=" + marque + ", designation="
				+ designation + ", prixUnitaire=" + prixUnitaire + ", qteStock=" + qteStock + "]";
	}

}
