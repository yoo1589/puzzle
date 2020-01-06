package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReportDao;
import vo.Report;

public class ReportService {
	
	public List<Report> reportListMyReport(Report report) {
		System.out.println("-----ReportDao.reportListMyReport-----");
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.reportListMyReport(conn, report);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Report> reportListTopMonth(Report report) {
		System.out.println("-----ReportDao.reportListTopMonth-----");
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.reportListTopMonth(conn, report);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<Report> reportListTopToday(Report report) {
		System.out.println("-----ReportDao.reportListTopToday-----");
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.reportListTopToday(conn, report);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public List<Report> reportListTop10(Report report) {
		System.out.println("-----ReportDao.reportListTop10-----");
		System.out.println(report.getMemberId());
		System.out.println(report.getCount());
		System.out.println(report.getTimer());
		System.out.println(report.getReportDate());
		
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.reportListTop10(conn, report);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void insertReport(Report report) {
		System.out.println("-----ReportService.Report-----");
		System.out.println(report.getMemberId());
		System.out.println(report.getCount());
		System.out.println(report.getTimer());
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			reportDao.insertReport(conn, report);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
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
}
