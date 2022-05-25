

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.Person;

/**
 * Servlet implementation class JstlServlet
 */
@WebServlet("/jstlServlet")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> pers = new ArrayList<>();
		pers.add(new Person("홍길동",20));
		pers.add(new Person("김길동",30));
		pers.add(new Person("고길동",40));
		pers.add(new Person("박길동",50));
		request.setAttribute("pers", pers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("personList.jsp");
		dispatcher.forward(request, response);
		
	}


}
