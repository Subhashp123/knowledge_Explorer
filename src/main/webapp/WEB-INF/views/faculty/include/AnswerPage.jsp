<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


	<div class="col-md-12 col-xl-12" style="margin-bottom: 10px;">
		<div class="card mb-12 widget-content bg-white-smile">
			<div class="widget-content-wrapper text-black">
				<div class="widget-content-left">
					<div
							class="widget-heading">${sessionScope.Question.question}</div>
					<div class="widget-subheading">Posted by
						${sessionScope.Question.student.name}</div>
					<div class="widget-subheading">On ${sessionScope.Question.date} At
						${sessionScope.Question.time}</div>
				</div>
				<div class="widget-content-right">

					
				</div>
			</div>
		</div>
	</div>
	
		<div class="col col-sm-12 col-lg-12">
		
			<form action='<spring:url value="/faculty/postAnswer"/>' method="get">
				<div class="container">
					<div class="col">
						<div class="card text-black" style="border-radius: 25px;">
							<div class="card-body p-md-5">
								<input type="text" value="${sessionScope.Question.id}" name="qid" hidden>
									<div class="col-md-10 col-lg-12">
										<div class="row">
											<div class="col col-lg-12 mb-4">
												<div class="form-outline flex-fill mb-0">
													<label class="form-label">Your Answer </label> <textarea
														type="text"
														name="answer" class="form-control col-lg-12 " ></textarea>
												</div>
											</div>
										</div>
										

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<input type="submit" class="btn btn-primary btn-lg" value="Post Ansswer">
										</div>
			</form>
			
	</div>

