package fly.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginController", urlPatterns={"/LoginController"})

public class Login extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		if(un.equals("admin") && pw.equals("admin"))
		{
			response.sendRedirect("index.html");
			return;
		}
		else
		{       
			response.sendRedirect("error.html");
			return;
		}
	}
}