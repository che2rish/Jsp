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
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int money = Integer.parseInt(request.getParameter("money"));
		
		AccountService service = new AccountService();
		try {
			service.deposit(id, money);
			Account acc= service.accountInfo(id);
			request.setAttribute("acc", acc);
			RequestDispatcher dispatcher = request.getRequestDispatcher("accountInfo_res.jsp");
			dispatcher.forward(request, response);
		}catch(Exception e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("err.jsp");
			dispatcher.forward(request, response);
		}
	}

}
