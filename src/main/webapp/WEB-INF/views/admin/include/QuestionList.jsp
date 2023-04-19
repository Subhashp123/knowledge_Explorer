<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:forEach var="questions" items="${sessionScope.questionList}">

	<div class="col-md-12 col-xl-12" style="margin-bottom: 10px;">
		<div class="card mb-12 widget-content bg-white-smile">
			<div class="widget-content-wrapper text-black">
				<div class="widget-content-left">
					<div
							class="widget-heading">${questions.question}</div>
					<div class="widget-subheading">Posted by
						${questions.student.name}</div>
					<div class="widget-subheading">On ${questions.date} At
						${questions.time}</div>
				</div>
				<div class="widget-content-right">

					<div class="widget-numbers text-black">
						<a
						href='<spring:url value="/admin/inc_que_like?qid=${questions.id}"/>'><i class='fa fa-heart' style='color: red'></i> </a><span>Likes
							${questions.likes}</span>
					</div>
				</div>
			</div>
		</div>
	</div>

</c:forEach>