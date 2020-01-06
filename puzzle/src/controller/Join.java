package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

@WebServlet("/Join")
public class Join extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		System.out.println("-----Join.doPost-----");
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		System.out.println("memberId : " + member.getMemberId());
		System.out.println("memberPw : " + member.getMemberPw());

		memberService = new MemberService();
		memberService.insertMember(member);
		
		Gson gson = new Gson();
		String json = gson.toJson(member);
		response.getWriter().write(json);
	}
}
