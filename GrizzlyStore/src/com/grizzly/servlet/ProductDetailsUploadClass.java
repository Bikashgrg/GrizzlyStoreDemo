package com.grizzly.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetailsUploadClass
 */
@WebServlet(name = "ProductDetailsUpload", urlPatterns = { "/productdetailsupload" })
public class ProductDetailsUploadClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsUploadClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id, price;
		String name, category, desc;
		
		
		id = Integer.parseInt(request.getParameter("productId"));
		name = request.getParameter("productName");
		category = request.getParameter("productCategory");
		price = Integer.parseInt(request.getParameter("productPrice"));
		desc = request.getParameter("productDesc");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","cognizant");
			PreparedStatement pst = conn.prepareStatement("insert into PRODUCTDETAILS values(?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, category);
			pst.setInt(4, price);
			pst.setString(5, desc);
			
			pst.executeUpdate();
			pst.close();
			
			response.getWriter().println("Product successfully added!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
