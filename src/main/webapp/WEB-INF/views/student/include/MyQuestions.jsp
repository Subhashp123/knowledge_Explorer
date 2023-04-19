
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content-wrapper">
	<div class="container-fluid">
		
		<div class="alert alert-primary text-center" role="alert">
			<h2>My Posted Questions</h2>
		</div>

		

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-info">
					<thead>
						<tr>
							<th scope="col">Sr No</th>
							<th scope="col">Question</th>
							<th scope="col">Posted Date</th>
							<th scope="col">Total Likes</th>
							<th scope="col">Status</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							int sr_no = 0;
						%>
						<c:forEach var="q" items="${sessionScope.questionList}">
							<tr>
								<td scope="row">${sr_no=sr_no+1}</td>
								<td>${q.question }</td>
								<td> ${q.date} </td>
								<td>${q.likes}</td>
								<td>${q.status}</td>
								<td>
								<a
									href='<spring:url value="/student/question_status?qid=${q.id}"/>'><button
											type="button" class="btn btn-primary">
											<i class="fa fa-tags"></i>
										</button></a> <a
									href='<spring:url value="/student/question_delete?qid=${q.id}"/>'><button
											type="button" class="btn btn-danger">
											<i class="fa fa-minus-circle"></i>
										</button></a>
										
										<a
									href='<spring:url value="/student/questionAnswer?qid=${q.id}"/>'><button
											type="button" class="btn btn-success">
											<i class="fa fa-file-code-o" style="color:green"></i>
										</button></a>
										</td>
										
										
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>