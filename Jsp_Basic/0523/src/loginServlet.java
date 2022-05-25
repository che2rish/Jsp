

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("passwd");
		System.out.println(id);
		System.out.println(password);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("아이디 : "+ id+"</br>");
//		out.println("패스워드 : "+ password +"</br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
		request.setAttribute(id, id);
		request.setAttribute(password,password);
		request.setAttribute("addr", "서울시 강북구");
		dispatcher.forward(request, response);
	}
	

}
