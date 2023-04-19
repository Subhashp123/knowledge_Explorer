
<%@page import="com.app.pojo.Faculty"%>
<%@page import="com.app.pojo.Student"%>
<%@page import="com.app.pojo.Admin"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	<form action='<spring:url value="/faculty/updateImage"/>' method="post"
		enctype="multipart/form-data">
		<div class="container-fluid">
			<div class="alert alert-primary text-center" role="alert">
				<h1>Faculty Profile</h1>
			</div>

<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.success}</h3>
			<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.erroor}</h3>
			<div class="row">
			
				<div class="col col-sm-12 col-lg-4 mb-4" style="margin-top: 5%;">
				<%
				Faculty a=(Faculty)session.getAttribute("userDetails");
				if(a.getImage()!=null){
					%>
				<img src="data:image/jpeg;base64,${sessionScope.userDetails.imgUtility}" height=400px width=400px
				/>
				<% }else{%>
					<img src="https://www.w3schools.com/bootstrap/paris.jpg"
							class="img-rounded" alt="Cinque Terre">
				<% }
			%>
			
				
					 <br> <br>
					<hr>
					<br>
					<div class="class=" colcol-sm-12col-lg-12mb-4"">
						<label class="form-control-label">Update Profile Image:</label> <input
							type="file" id="myFile" name="image" class="form-control">
					</div>
					<br>
					<button class="btn btn-primary btn-lg">Submit</button>
				</div>
	</form>
	<div class="col col-sm-12 col-lg-8">
		<section class="vh-100" style="background-color: #eee;">
			<form action='<spring:url value="/faculty/updateProfile"/>' method="post">
				<div class="container">
					<div class="col">
						<div class="card text-black" style="border-radius: 25px;">
							<div class="card-body p-md-5">
								<div class="row justify-content-center">
									<div class="col-md-10 col-lg-12">
										<div class="row">
											<div class="col col-lg-12 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Your Name </label> <input
														value="${sessionScope.userDetails.name}" type="text"
														name="name" class="form-control col-lg-12 text-center" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Your Email</label> <input
														value="${sessionScope.userDetails.email}" type="email"
														name="email" class="form-control col-lg-12" />
												</div>
											</div>


											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Your Date Of Birth</label> <input
														value="${sessionScope.userDetails.dob}" type="text"
														name="dob" class="form-control col-lg-12" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Your Mobile </label> <input
														value="${sessionScope.userDetails.mobile}" type="text"
														name="mobile" class="form-control col-lg-12" />
												</div>
											</div>


											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">City </label> <input
														value="${sessionScope.userDetails.address.city}"
														type="text" name="city" class="form-control col-lg-12" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">District </label> <input
														value="${sessionScope.userDetails.address.district}"
														type="text" name="district" class="form-control col-lg-12" />
												</div>
											</div>

											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">State </label> <input
														value="${sessionScope.userDetails.address.state}"
														type="text" name="state" class="form-control col-lg-12" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col col-lg-6 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Pin Code </label> <input
														value="${sessionScope.userDetails.address.pinCode}"
														type="text" name="pincode" class="form-control col-lg-12" />
												</div>
											</div>

											<div class="col col-lg-16 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Country </label> <input
														value="${sessionScope.userDetails.address.country}"
														type="text" name="country" class="form-control col-lg-16" />
												</div>
											</div>
										</div>



										<div class="row">
											<div class="col col-lg-12 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Address Line </label> <input
														value="${sessionScope.userDetails.address.streetLine}"
														type="text" name="streetLine"
														class="form-control col-lg-12" />
												</div>
											</div>


										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<input type="submit" class="btn btn-primary btn-lg" value="Update">
										</div>
			</form>
	</div>

</div>
</div>
</div>
</section>
</div>
</div>
