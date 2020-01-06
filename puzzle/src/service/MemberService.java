package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import vo.Member;

public class MemberService {
	
	public void deleteMember(Member member) {
		System.out.println("-----MemberService.deleteMember-----");
		System.out.println("member : " + member);
		
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			memberDao.deleteMember(conn, member);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateMember(Member member) {
		System.out.println("-----MemberService.UpdateMember-----");
		System.out.println("member : " + member);
		
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			memberDao.updateMember(conn, member);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertMember(Member member){
		System.out.println("-----MemberService.Join-----");
		System.out.println("memberId : " + member);
		
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			memberDao.insertMember(conn, member);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public String login(Member member) {
		Member returnMember = null;
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			// before
			returnMember = memberDao.login(conn, member);
			// after
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnMember.getMemberId();
	}
}
