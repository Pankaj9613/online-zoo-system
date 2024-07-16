<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="component/navbar.jsp"%>
<%@include file="component/allCss.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Zoo Management - Contact Us</title>
</head>
<body style="background-color: #2b76b1ba;">
<br><br><br>

<%
	String successMsg = (String) session.getAttribute("successMsg");
	String errorMsg = (String) session.getAttribute("errorMsg");

	if (successMsg != null) {
%>
<script>
	alert("Your Contact Query has been Send.");
	window.location.assign("contact.jsp");
</script>
<%
	session.removeAttribute("successMsg");
	}
%>
<%
	if (errorMsg != null) {
%>
<script>
	alert("Something went Wrong..!!");
</script>
<%
	session.removeAttribute("errorMsg");
	}
%>
	<div class="container mt-5">
		<div class="card shadow">
			<div class="card-body">
				<h1 class="text-center text-danger"
					style="font-family: 'Monotype Corsiva'; font-size: 50px;">Contact
					Us</h1>
				<hr>
				<div class="row">
					<div class="col-sm-6">
						<img src="images/zoocontact.jpg" style="width: 90%; height: 380px">
					</div>

					<div class="col-sm-6">
						<form method="post" action="contact">
							<div class="form-row">
								<div class="col-sm-12">
									<div class="form-group">
										<label>Name</label> <input type="text" name="name"
											class="form-control" placeholder="Enter Name" required>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="form-group">
										<label>Contact No.</label> <input type="text" name="contact"
											class="form-control" placeholder="Enter Contact Number"
											required>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="form-group">
										<label>Email</label> <input type="email" name="emailid"
											class="form-control" placeholder="Enter Email" required>
									</div>
								</div>

								<div class="col-sm-12">
									<div class="form-group">
										<label>Message</label>
										<textarea name="message" class="form-control"
											placeholder="Any Query ?" required></textarea>
									</div>
								</div>
							</div>
								<input type="submit" value="Send"
									class="btn btn-primary float-right">
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>