/**
 * Vous qui entrez dans ce code, abandonnez tout espoir
 */
package fr.eni.papeterie.dal.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;

/**
 * @author All by myyyyysellllf !!
 */

public class ArticleDAOJdbcImpl implements ArticleDAO
{
	//Properties

	
	//JDBC objects
	Connection con = null; 
    Statement stmt = null;
    PreparedStatement pStmt= null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    
    //Objects Lists
    private List <Article> articleList= new ArrayList <Article>();
	
	private static ArticleDAOJdbcImpl instance= new ArticleDAOJdbcImpl();
	
	
	//Setters/Getters

	private ArticleDAOJdbcImpl()
	{
		
	}
	
	public static ArticleDAOJdbcImpl getInstance()
	{
		return instance;
	}	
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
	
	//Methods
	
	/*public Connection connect() throws DALException
	{
		return JdbcConnect.getInstance();
	}*/

	@Override
	public void insert (Article a) throws DALException
	{
		
		try
		{
			con = JdbcConnect.getInstance();
			//Preparing statement
			pStmt= con.prepareStatement("INSERT INTO dbo.Articles "+
				"([reference]" + 
				",[marque]" + 
				",[designation]" + 
				",[prixUnitaire]" + 
				",[qteStock]" + 
				",[grammage]" + 
				",[couleur]" + 
				",[type])"+
				" VALUES ("+
				"?"+
				",?"+
				",?"+
				",?"+
				",?"+
				",?"+
				",?"+
				",?"+				
				")");
		if (a instanceof Stylo)
		{				
			insertStylo ((Stylo) a);
		}
		
		if (a instanceof Ramette)
		{
			insertRamette ((Ramette) a);
		}
		
		//executing statement

		pStmt.executeUpdate();
		System.out.println("Insertion done");
		
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}
		finally
		{
			if (rs !=null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (con!=null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
		}
	}
	
	private void insertStylo (Stylo s) throws DALException
	{
		try
		{
			//Insert db data
			pStmt.setString(1,s.getReference());
			pStmt.setString(2,s.getMarque());
			pStmt.setString(3,s.getDesignation());
			pStmt.setFloat(4,s.getPrixUnitaire());
			pStmt.setInt(5,s.getQteStock());
			pStmt.setString(6,null);
			pStmt.setString(7,s.getCouleur());
			pStmt.setString(8,s.getClass().getSimpleName());
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}
	}
	
	private void insertRamette (Ramette r) throws DALException
	{				
		try
		{
			//Insert db data
			pStmt.setString(1,r.getReference());
			pStmt.setString(2,r.getMarque());
			pStmt.setString(3,r.getDesignation());
			pStmt.setFloat(4,r.getPrixUnitaire());
			pStmt.setInt(5,r.getQteStock());
			pStmt.setInt(6,r.getGrammage());
			pStmt.setString(7,null);
			pStmt.setString(8,r.getClass().getSimpleName());
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}
	}
	
	@Override
	public List <Article> selectAll() throws DALException
	{
		con=JdbcConnect.getInstance();
		try
		{
			stmt = con.createStatement(); 
	        rs = stmt.executeQuery("SELECT * FROM Articles");
	        rsmd = rs.getMetaData();
			articleList.clear();
	        
			while (rs.next())
	         {
				if (rs.getString(9).trim().equalsIgnoreCase("Stylo"))
				{
					articleList.add(new Stylo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getString(8)));
				}
				if (rs.getString(9).trim().equalsIgnoreCase("Ramette"))
				{
					articleList.add(new Ramette(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7)));
				}
	         }				
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}
		finally
		{
			if (rs !=null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (con!=null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
		}
		return articleList;
	}
	
	@Override
	public Article selectById(int id) throws DALException
	{
		Article art=null;
		id=203;
		
		con=JdbcConnect.getInstance();
		try
		{				
			pStmt= con.prepareStatement("SELECT * FROM Articles WHERE idArticle=?");
			pStmt.setInt(1, 291);
			rs=pStmt.executeQuery();	
			
			rs.next();
			if (rs.getString(9).contains("Stylo"))
				{
				art=new Stylo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getString(8));
				}

			else if (rs.getString(9).contains("Ramette"))
				{
				art=new Ramette(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getInt(7));
				}	
			
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}
		finally
		{
			if (rs !=null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (con!=null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
		}
		return art;
	}
	
	@Override
	public void delete (int id) throws DALException
	{
		con=JdbcConnect.getInstance();
		try
		{				
			pStmt= con.prepareStatement("DELETE FROM Articles "+
			"WHERE idArticle=?");
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}
		finally
		{
			if (rs !=null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (con!=null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
		}
	}
	
	@Override
	public void update (Article a) throws DALException
	{
			/*try
			{	connect();		
				pStmt= con.prepareStatement("UPDATE Articles SET reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=?, type=? WHERE idArticle=?");
				pStmt.setInt(1, a.getIdArticle());
				if (a instanceof Stylo)
				{				
					updateStylo ((Stylo) a);
				}
				
				if (a instanceof Ramette)
				{
					updateRamette ((Ramette) a);
				}
				pStmt.executeUpdate();
				System.out.println("Update done");}
			catch (SQLException e)
			{
				throw new DALException(e.getMessage(), e);
			}
			finally
		{
			if (rs !=null)
			{
				try
				{
					rs.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
			if (con!=null)
			{
				try
				{
					con.close();
				}
				catch (SQLException e)
				{
					throw new DALException(e.getMessage(), e);
				}
			}
		}
			
	}
	private void updateStylo (Stylo s) throws DALException
	{
		try
		{
			//update db data
			pStmt.setString(1,s.getReference());
			pStmt.setString(2,s.getMarque());
			pStmt.setString(3,s.getDesignation());
			pStmt.setFloat(4,s.getPrixUnitaire());
			pStmt.setInt(5,s.getQteStock());
			pStmt.setNull(6,Types.INTEGER);
			pStmt.setString(7,s.getCouleur());
			pStmt.setString(8,s.getClass().getSimpleName());
			pStmt.setInt(9,s.getIdArticle());
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}
	}
	
	private void updateRamette (Ramette r) throws DALException
	{				
		try
		{
			//update db data
			pStmt.setString(1,r.getReference());
			pStmt.setString(2,r.getMarque());
			pStmt.setString(3,r.getDesignation());
			pStmt.setFloat(4,r.getPrixUnitaire());
			pStmt.setInt(5,r.getQteStock());
			pStmt.setInt(6,r.getGrammage());
			pStmt.setNull(7,Types.VARCHAR);
			pStmt.setString(8,r.getClass().getSimpleName());
			pStmt.setInt(9,r.getIdArticle());
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage(), e);
		}*/
	}

	
}
