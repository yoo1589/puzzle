package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Member;
import vo.Report;

public class ReportDao {
	
	public List<Report> reportListMyReport(Connection conn, Report report) {
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM report WHERE member_id=? ORDER BY timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, report.getMemberId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));				
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				report.setReportdate(rs.getString("report_date"));
				list.add(report);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Report> reportListTopMonth(Connection conn, Report report) {
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM report WHERE month(report_date) = month(now()) ORDER BY timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));				
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				report.setReportdate(rs.getString("report_date"));
				list.add(report);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Report> reportListTopToday(Connection conn, Report report) {
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM report WHERE date(report_date) = date(now()) ORDER BY timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));				
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				report.setReportdate(rs.getString("report_date"));
				list.add(report);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Report> reportListTop10(Connection conn, Report report) {
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM report ORDER BY timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));				
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				report.setReportdate(rs.getString("report_date"));
				list.add(report);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	public void insertReport(Connection conn, Report report) throws Exception{
		System.out.println("-----ReportDao.Report-----");
		System.out.println(report.getMemberId());
		System.out.println(report.getCount());
		System.out.println(report.getTimer());
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO report(member_id, report_date, count, timer) VALUES(?, NOW(), ?, ?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, report.getMemberId());
			stmt.setInt(2, report.getCount());
			stmt.setInt(3, report.getTimer());
			stmt.executeUpdate();
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
