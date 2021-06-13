package panier.classes.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import panier.classes.Client;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numero=Integer.parseInt(request.getParameter("numero"));
String nom=request.getParameter("nom");
String prenom=request.getParameter("prenom");
String adresse=request.getParameter("adresse");
Client client=new Client(numero, nom, prenom, adresse, null);
	client.addClient();
	response.sendRedirect("index.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int numero=Integer.parseInt(request.getParameter("id"));
		Client cl=new Client(numero);
		try {
			if(cl.auth()!=null)
			{
				HttpSession session =request.getSession();
				session.setAttribute("user",cl.auth().first());
				response.sendRedirect("produits.jsp");
			}
			else
				response.sendRedirect("erreur.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
