package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao {
	
	public void deleteMember(Connection conn, Member member) {
		System.out.println("-----MemberDao.Delete-----");
		System.out.println(member.getMemberId());
		
		PreparedStatement stmt = null;
		String sql = "DELETE FROM member_pz WHERE member_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateMember(Connection conn, Member member) {
		System.out.println("-----MemberDao.Update-----");
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		
		PreparedStatement stmt = null;
		String sql = "UPDATE member_pz SET member_pw=? WHERE member_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertMember(Connection conn, Member member) throws Exception{
		System.out.println("-----MemberDao.Join-----");
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		System.out.println(conn);
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO member_pz(member_id, member_pw, member_level) values(?,password(?),'Y')";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Member login(Connection conn, Member member) throws Exception{
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT member_id FROM member_pz WHERE member_id = ? AND member_pw = password(?) AND member_level = 'Y'");
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberId(rs.getString(1));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return returnMember;
	}
}
