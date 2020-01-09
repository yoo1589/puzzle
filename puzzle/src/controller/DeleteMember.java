package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

@WebServlet("/DeleteMember")
public class DeleteMember extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		String loginState = request.getParameter("loginState");
		System.out.println("-----DeleteMember.servlet-----");
		System.out.println("loginState : " + loginState);
		
		Member member = new Member();
		member.setMemberId(loginState);
		
		memberService = new MemberService();
		memberService.deleteMember(member);
		
		Gson gson = new Gson();
		String json = gson.toJson(member);
		response.getWriter().write(json);
	}
}
