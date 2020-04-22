package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="servletLogin", urlPatterns="/Senha_Login")
public class Senha_Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String name = request.getParameter("login");
		String pass = request.getParameter("senha");
		
		String login = "root";
		String senha = "admin";
		
		if(name.equals(login) && pass.equals(senha)) {
			RequestDispatcher rd=request.getRequestDispatcher("CalculoIdade.html");
			rd.forward(request, response);
			
		}else {
			
			response.getWriter().println("Senha ou nome incorreto! Tente novamente");
			
			RequestDispatcher rd=request.getRequestDispatcher("Indexx.jsp");
			rd.include(request, response);
		}

	}
	
}
