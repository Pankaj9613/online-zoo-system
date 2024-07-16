<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="component/navbar.jsp"%>
<%@include file="component/allCss.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zoo Management - Admin Login</title>
</head>
<body style="background-color: #2b76b1ba;">
	
	<%
		String validMsg = (String) session.getAttribute("validMsg");
		String invalidMsg = (String) session.getAttribute("invalidMsg");

		if (validMsg != null) {
	%>
	<script>
		alert("Logged in Successfully");
		window.location.assign("dashboard.jsp");
	</script>
	<%
		session.removeAttribute("validMsg");
		}
	%>
	<%
		if (invalidMsg != null) {
	%>
	<script>
		alert("Invalid Credential, Try Again..");
	</script>
	<%
		session.removeAttribute("invalidMsg");
		}
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card mt-5">

					<div class="card-header primary-background text-white text-center">
						<h2>Admin Login</h2>
					</div>

					<div class="card-body">
						<form action="login" method="post">

							<div class="form-group">
								<label>UserName</label> <input type="text" name="username"
									class="form-control" placeholder="Enter Username" required>
							</div>

							<div class="form-group">
								<label>Password</label> <input type="password" name="password"
									class="form-control" placeholder="Enter Password" required>
							</div>
							<hr>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>