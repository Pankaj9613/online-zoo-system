<%@page import="com.zoo.DBConnect"%>
<%@page import="java.sql.*"%>
<%
	String id = request.getParameter("id");
	try {
		Connection con = DBConnect.getConn();
		Statement st = con.createStatement();
		st.executeUpdate("delete from ticindian where id='"+id+"'");
		response.sendRedirect("manageNativeTicket.jsp?msg=delete");
	} catch (Exception e) {
		System.out.println(e);
	}
%>