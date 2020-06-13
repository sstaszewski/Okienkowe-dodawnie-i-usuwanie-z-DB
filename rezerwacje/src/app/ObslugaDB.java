package app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DBconnector;

@WebServlet("/ObslugaDB")
public class ObslugaDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ObslugaDB() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static String[] wyswietlDostepnePokoje() {
		String[] dostepnePokoje = null;
		try {
			Connection conn = DBconnector.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate("select nrPokoju from pokoje");
			
			
			
			
			
			conn.close();
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
	return dostepnePokoje;
	}
	
	

}
