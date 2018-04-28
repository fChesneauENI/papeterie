package fr.eni.papeterie.dal;

import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
//import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.papeterie.dal.jdbc.JdbcConnect;

public class AppliTestDAL {

	public static void main(String[] args) throws DALException {

		
		//Déclaration et instanciation de la DAO
		ArticleDAO articleDAO = (ArticleDAO) ArticleDAOJdbcImpl.getInstance();

		JdbcConnect.getInstance();
		
		//Instanciation du jeu d'essai 
		Article a1 = new Stylo( "Bic", "BBOrange","Bic bille Orange", 1.2f, 20, "bleu");
		Article a2 = new Ramette(  "Clairef", "CRA4S", "Ramette A4 Sup", 9f, 20, 80);
		Article a3 = new Stylo( "Stypen", "PlumeS", "Stylo Plume Stypen", 5.5f, 20, "jaune");


		System.out.println("Ajout des articles... ");

			articleDAO.insert(a1);
			
			articleDAO.insert(a2);
			
			articleDAO.insert(a3);


			//Sélection de l'article par id
			a2.setIdArticle(500);
			System.out.println(a2.getIdArticle());
//			Article a = articleDAO.selectById(203);
			
			//Sélection de tous les articles
			List<Article> articles = articleDAO.selectAll();
			
			//Modification d'un article
			a1.setIdArticle(298);
			System.out.println("\nModification d'un article  : " );
			System.out.println("Article avant modification : "  + a1.toString());
			((Stylo) a1).setCouleur("noir");
			((Stylo) a1).setDesignation("Bic bille noir");
			((Stylo) a1).setReference("BBNoir");
			articleDAO.update(a1);
			System.out.println("Article après modification  : " + a1.toString() );
			
			
			//Suppression d'un article
			System.out.println("\nSuppression de l'article  : " + a1.toString());
			articleDAO.delete(292);
			articles = articleDAO.selectAll();
			System.out.println("Liste des articles après suppression : "  );
			afficherArticles(articles);
			System.out.println("---------------------------------------------------------------");

	}

	
	private static void afficherArticles(List<Article> articles){
		/*StringBuffer sb = new StringBuffer();
		for(Article art: articles){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());*/
		
		for (Article art: articles)
		  {
			  System.out.println(art.toString()); 
		  }
	}
}
