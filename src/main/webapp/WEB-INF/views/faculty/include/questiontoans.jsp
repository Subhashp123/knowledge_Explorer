<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="col-md-12 col-xl-12" style="margin-bottom: 10px;">
	<div class="card mb-12 widget-content bg-white-smile">
		<div class="widget-content-wrapper text-black">
			<div class="widget-content-left">
				<div class="widget-heading">${sessionScope.Question.question}</div>
				<div class="widget-subheading">Posted by
					${sessionScope.Question.student.name}</div>
				<div class="widget-subheading">On
					${sessionScope.Question.date} At ${sessionScope.Question.time}</div>
			</div>
			<div class="widget-content-right"></div>
		</div>
	</div>
</div>

<div class="col col-sm-12 col-lg-12">


	<div class="container">
		<div class="col">
			<div class="card text-black" style="border-radius: 25px;">
				<div class="card-body p-md-5">

					<div class="col-md-10 col-lg-12">
						<div class="row">
							<div class="col col-lg-12 mb-4">
								<div class="form-outline flex-fill mb-0">
									<label class="form-label"><h3>Answers to This
											Question</h3> <i class="fa fa-sort-amount-desc"
										style="font-size: 48px; color: red"></i></label>
								</div>
							</div>
						</div>
						<c:forEach var="ans" items="${sessionScope.answersList}">
							<div class="col-md-12 col-xl-12" style="margin-bottom: 10px;">
								<div class="card mb-12 widget-content bg-white-smile">
									<div class="widget-content-wrapper text-black">
										<div class="widget-content-left">
											<div class="widget-heading">${ans.answer}</div>
											<div class="widget-subheading">Posted by
												${ans.faculty.name}</div>
											<div class="widget-subheading">On
												${ans.date} At
												${ans.time}</div>
										</div>
										<div class="widget-content-right">
										<div class="widget-numbers text-black">
						<a
						href='<spring:url value="/faculty/inc_ans_like?aid=${ans.id}&qid=${sessionScope.Question.id}"/>'><i class='fa fa-heart' style='color: red'></i> </a><span>Likes
							${ans.likes}</span>
					</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>