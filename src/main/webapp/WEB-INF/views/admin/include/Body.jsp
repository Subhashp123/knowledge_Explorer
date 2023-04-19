
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		
		<div class="alert alert-primary text-center" role="alert">
			<h2>Available Stations List</h2>
		</div>

		

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Name</th>
							<th scope="col">Mobile No</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							int sr_no = 0;
						%>
						<c:forEach var="station" items="#">
							<tr>
								<td scope="row">${sr_no=sr_no+1}</td>
								<td>Hello</td>
								<td>Hello</td>
								<td>Hello</td>
								<td>Hello</td>
								<td><a
									href='<spring:url value="/Admin/station_status?sid=Hello"/>'><button
											type="button" class="btn btn-primary">
											<i class="far fa-eye"></i>
										</button></a> <a
									href='<spring:url value="/Admin/station_delete?sid=Hello"/>'><button
											type="button" class="btn btn-danger">
											<i class="fa fa-bomb" style="color:red"></i>
										</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>