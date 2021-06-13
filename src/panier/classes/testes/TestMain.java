package panier.classes.testes;

import java.sql.ResultSet;
import java.sql.SQLException;

import panier.classes.Client;
import panier.classes.Connexion;
import panier.classes.Famille;
import panier.classes.Produit;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//Connexion c=new Connexion();
		Client cl=new Client(123, "Ali", "Ahmed", "Gabes", null);
		//cl.addClient();
		Famille f=new Famille();
		f.setNumFam(14);
		Produit p=new Produit(13, "Beure",800, f);
		p.addproduit();
	ResultSet res=p.aff();
	while(res.next())
	{
		System.out.print(res.getString("nomPro"));
	}
	}

}
