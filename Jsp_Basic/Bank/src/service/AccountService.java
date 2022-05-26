package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.AccountDAO;
import db.JdbcUtill;
import dto.Account;

public class AccountService {
	public void makeAccount(Account acc) throws Exception {
		Connection conn = JdbcUtill.getConnection();
		AccountDAO dao = new AccountDAO();
		try {
		dao.insertAccount(conn, acc);
		}catch(Exception e) {
			throw e;
		}finally {
			JdbcUtill.close(conn);
		}
	}
	
	public Account accountInfo(String id) throws Exception{
		Connection conn = JdbcUtill.getConnection();
		AccountDAO dao = new AccountDAO();
		Account acc = null;
		try {
			acc = dao.selectAccount(conn, id);
			if(acc == null) throw new Exception();
		}catch(SQLException e) {
			throw e;
		}finally {
			JdbcUtill.close(conn);
		}
		return acc;
	}
	
	public List<Account> allAccountInfo() throws Exception{
		Connection conn = JdbcUtill.getConnection();
		AccountDAO dao = new AccountDAO();
		List<Account> accs = null;
		try {
			accs = dao.selectAccountList(conn);
			if(accs.isEmpty()) throw new SQLException();
		}catch(SQLException e) {
			throw e;
		}finally {
			JdbcUtill.close(conn);
		}
		return accs;
	}
	
	public void deposit(String id, int money) throws Exception {
		Connection conn = JdbcUtill.getConnection();
		AccountDAO dao = new AccountDAO();
		try {
			if(money <= 0) throw new SQLException("입금액 오류");
			Account acc = dao.selectAccount(conn, id);
			if(acc == null) throw new SQLException("계좌번호 오류");
			acc.deposit(money);
			dao.updateBalance(conn, acc);
		}catch(SQLException e) {
			throw e;
		}finally {
			JdbcUtill.close(conn);
		}
	}
	
	public void withdraw(String id, int money) throws SQLException {
		Connection conn = JdbcUtill.getConnection();
		AccountDAO dao = new AccountDAO();
		try {
			if(money <= 0) throw new SQLException("출금액 오류");
			Account acc = dao.selectAccount(conn, id);
			if(acc == null) throw new SQLException("계좌번호 오류");
			if(acc.getBalance() < money) throw new SQLException("잔액 부족");
			acc.withdraw(money);
			dao.updateBalance(conn, acc);
		}catch(SQLException e) {
			throw e;
		}finally {
			JdbcUtill.close(conn);
		}
	}
}
