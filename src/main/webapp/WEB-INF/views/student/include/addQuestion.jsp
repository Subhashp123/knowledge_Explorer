
<%@page import="com.app.pojo.Student"%>
<%@page import="com.app.pojo.Admin"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content-wrapper">
	
		<div class="container-fluid">
			<div class="alert alert-primary text-center" role="alert">
				<h1>Post Question</h1>
			</div>

<h3
			style="color: green; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.success}</h3>
			<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;">${requestScope.error}</h3>
		

	<div class="col col-sm-12 col-lg-12">
		
			<form action='<spring:url value="/student/postQuestion"/>' method="post">
				<div class="container">
					<div class="col">
						<div class="card text-black" style="border-radius: 25px;">
							<div class="card-body p-md-5">
								
									<div class="col-md-10 col-lg-12">
									<div class="row">
											<div class="col col-lg-12 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label" >Select Subject </label> 
													<select name="subject" type="text" class="form-control col-lg-12 ">
													<option value="java">Java</option>
													<option value="database">Database</option>
													<option value="Data Structure">Data Structure</option>
													
													</select>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col col-lg-12 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Your Question </label> <textarea
														type="text"
														name="question" class="form-control col-lg-12 " ></textarea>
												</div>
											</div>
										</div>
										

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<input type="submit" class="btn btn-primary btn-lg" value="Post Question">
										</div>
			</form>
			
	</div>

</div>
</div>
</div>

</div>
</div>
