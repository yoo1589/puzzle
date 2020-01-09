package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReportService;
import vo.Report;

@WebServlet("/ReportListTopToday")
public class ReportListTopToday extends HttpServlet {
	private ReportService reportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		Report report = new Report();
		reportService = new ReportService();
		List<Report> list = reportService.reportListTopToday(report);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		response.getWriter().write(json);
	}
}
