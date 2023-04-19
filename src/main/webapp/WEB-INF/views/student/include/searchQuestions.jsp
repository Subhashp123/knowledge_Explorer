<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:forEach var="questions" items="${sessionScope.searchQuestionList}">

	<div class="col-md-12 col-xl-12" style="margin-bottom: 10px;">
		<div class="card mb-12 widget-content bg-white-smile">
			<div class="widget-content-wrapper text-black">
				<div class="widget-content-left">
					<a
						href='<spring:url value="/student/questionAnswer?qid=${questions.id}"/>'><div
							class="widget-heading">${questions.question}</div></a>
					<div class="widget-subheading">Posted by
						${questions.student.name}</div>
					<div class="widget-subheading">On ${questions.date} At
						${questions.time}</div>
				</div>
				<div class="widget-content-right">

					<div class="widget-numbers text-black">
						<a
						href='<spring:url value="/student/inc_que_like?qid=${questions.id}"/>'><i class='fa fa-heart' style='color: red'></i> </a><span>Likes
							${questions.likes}</span>
					</div>
				</div>
			</div>
		</div>
	</div>

</c:forEach>
<h3
			style="color: red; background-color: white; margin-right: 150px; margin-left: 150px;"> ${requestScope.error}</h3>