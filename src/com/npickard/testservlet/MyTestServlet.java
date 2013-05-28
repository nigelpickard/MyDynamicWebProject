package com.npickard.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Friend;

/**
 * Servlet implementation class MyTestServlet
 */
@WebServlet(description = "a test servlet", urlPatterns = { "/MyTestServlet" })
public class MyTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceUnit
	EntityManagerFactory emf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("<html><body>");
		pw.print("hello world from a servlet..... and served at " + request.getServletPath());
		
		int count;
		if (request.getSession().getAttribute("count")==null){
			count = 0;
		}else{
			count = (Integer)request.getSession().getAttribute("count");
		}
		request.getSession().setAttribute("count", ++count);
		pw.print(" session count is " + request.getSession().getAttribute("count"));
		
		Friend f = (Friend)emf.createEntityManager().createQuery("select f from Friend f").getResultList().get(0);
		pw.print(" Friend retrieved is " + f.getName()  + " and is " + f.getAge() + " years old.");
		
		
		pw.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
