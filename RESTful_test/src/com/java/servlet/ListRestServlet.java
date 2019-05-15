package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.MemberList;
import com.java.dto.MemberVO;

@WebServlet("/listJson")
public class ListRestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> memberList=new ArrayList<MemberVO>();
		memberList.add(new MemberVO("mimi","mimi","mimi","mimi"));
		memberList.add(new MemberVO("mama","mama","mama","mama"));
		
		MemberList dataList = new MemberList();
		dataList.setMemberList(memberList);
		
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		out.println(mapper.writeValueAsString(dataList));
		
	}

}
