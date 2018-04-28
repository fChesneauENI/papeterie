package fr.eni.papeterie.bo;


public class Ligne {
	protected int qte;
	protected Article article;

	// Constructeur
	public Ligne(Article article, int qte) {
		super();
		this.qte = qte;
		this.article = article;
	}
	
	// getters et setters
	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public float getPrix() { 
		return (this.article.getPrixUnitaire())*this.getQte();
	}

	// Méthode to String
	@Override
	public String toString() {
		return "Ligne [qte=" + qte  + ", prix="+this.article.getPrixUnitaire() + ", article=" + article;
	}

}
