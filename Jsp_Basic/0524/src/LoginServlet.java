

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// DB체크
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		response.sendRedirect("sessionLoginSuccess.jsp"); // url이 달라짐, 데이터를 다시 받아와야함
//		RequestDispatcher dispatcher = request.getRequestDispatcher("sessionLoginSuccess.jsp"); 
//		dispatcher.forward(request,response); // 위임을 한다, 데이터를 연계해서 보내줌
	}

}
