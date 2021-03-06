package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allaccountinfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService service = new AccountService();
		try {
			request.setAttribute("accs", service.allAccountInfo());
			RequestDispatcher dispatcher = request.getRequestDispatcher("allAccountInfo.jsp");
			dispatcher.forward(request, response);
		}catch (Exception e) {
			request.setAttribute("err", "전체계좌 조회 오류");
			RequestDispatcher dispatcher = request.getRequestDispatcher("err.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
