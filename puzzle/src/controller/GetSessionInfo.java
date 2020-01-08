package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/GetSessionInfo")
public class GetSessionInfo extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession();
		//session.setAttribute("sessionInfo", "test@test.co.kr"); // 로그인 테스트
		//session.invalidate(); // 세션 지우기
		String sessionInfo = (String)session.getAttribute("sessionInfo");
		System.out.println(sessionInfo);
		Gson gson = new Gson();
		String json = gson.toJson(sessionInfo);
		System.out.println(json);
		response.getWriter().write(json);	
	}
}
