package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtill;
import dto.Account;

public class AccountDAO {
	public void insertAccount(Connection conn, Account acc) throws SQLException{
		String sql = "insert into account (id,name,balance) values(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, acc.getId());
			pstmt.setNString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			throw e;
		}finally {
			JdbcUtill.close(pstmt);
		}
	}
	
	public Account selectAccount(Connection conn, String id) throws SQLException{
		String sql = "select * from account where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Account acc = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				acc = new Account(rset.getNString(1),rset.getNString(2),rset.getInt(3));
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			JdbcUtill.close(rset);
			JdbcUtill.close(pstmt);
		}
		return acc;
	}
	
	public List<Account> selectAccountList(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rset = null;
		List<Account> accs = new ArrayList<>();
		String sql = "select * from account";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				String id = rset.getNString("id");
				String name = rset.getNString("name");
				int balance = rset.getInt("balance");
				accs.add(new Account(id,name,balance));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtill.close(rset);
			JdbcUtill.close(stmt);
		}
		return accs;
	}
	
	public void updateBalance(Connection conn, Account acc) throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "update account set balance =? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setNString(2, acc.getId());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			JdbcUtill.close(pstmt);
		}
	}
	
	
}
