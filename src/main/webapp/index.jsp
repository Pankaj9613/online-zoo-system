<%@page import="com.zoo.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="component/navbar.jsp"%>
<%@include file="component/allCss.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zoo Management System</title>
</head>
<style type="text/css">
.zoom {
	transition: transform .1s; /* Animation */
	margin: 0 auto;
}

.zoom:hover {
	transform: scale(1.2); /* (150% zoom)*/
}
</style>
<body style="background-color: #2b76b1ba;">
<img src="images/index.jpeg" style="width:100%; height:550px;">

<div class="container">
		<h3 class="page-title text-center"><u><span style="font-family: 'Monotype Corsiva'; font-size: 50px; color: red;">Animals</span></u></h3>
        <hr>
		<div class="row mb-5">

			<!-- Using for loop -->
			
			<%
				try {
					Connection con = DBConnect.getConn();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from animal");
					int i = 0;
					while (rs.next()) {
						i++;
			%>
			<div class="col-sm-4 p-2 zoom">
				<div class="card" style="width: 300px">
				    <h5 class="card-text text-justify text-center"><%=rs.getString("AnimalName")%></h5>
					<img src='images2/<%=rs.getString("photo")%>' style="width: 100%; height: 200px">
					<p class="card-text text-justify text-center"><%=rs.getString("Description")%></p>
					<div class="card-text text-justify text-center"><b>Breed :</b><%=rs.getString("Breed")%></div>
					<div class="card-text text-justify text-center"><b>Feed No :</b><%=rs.getString("FeedNumber")%></div>
					<div class="card-text text-justify text-center"><b>Cage No. :</b><%=rs.getString("CageNumber")%></div>
				</div>
			</div>
			<%
				}
				} catch (Exception e) {
					System.out.println(e);
				}
			%>
		</div>
	</div>

</body>
</html>