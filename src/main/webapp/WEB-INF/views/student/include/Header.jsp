
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>

<head>

<title>Knowledge Explorer : Dashboard</title>

<link rel="stylesheet" href="<spring:url value='/css/style.css'/>" />
<script type="text/javascript" src="<spring:url value='/js/script.js'/>"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<div
		class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		<div class="app-header header-shadow">
			<div class="app-header__logo">
				<div class="logo-src"></div>
				<div class="header__pane ml-auto">
					<div>
						<button type="button"
							class="hamburger close-sidebar-btn hamburger--elastic"
							data-class="closed-sidebar">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
			</div>

			<div class="app-header__content">
				<form action='<spring:url value="/student/searchQuestion"/>' method="post">
					<div class="app-header-left">
						<div class="search-wrapper">

							<div class="input-group">
								<div class="form-outline">
									<input type="text" name="searchkey" style="width: 330px; margin-right: 10px" class="form-control" />
								</div>
								<button class="btn btn-primary search-icon">
									<i class="fa fa-search" aria-hidden="true"></i>
								</button>
							</div>
						</div>
				</form>
			</div>
			<div class="app-header-right">
				<div class="header-btn-lg pr-0">
					<div class="widget-content p-0">
						<div class="widget-content-wrapper">
							<div class="widget-content-left">
								<div class="btn-group">
									<a data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false" class="p-0 btn"> <img width="42"
										class="rounded-circle"
										src="data:image/jpeg;base64,${sessionScope.userDetails.imgUtility}"
										alt="">
									</a>
								</div>
							</div>
							<div class="widget-content-left  ml-3 header-user-info">
								<div class="widget-heading">
									<a href='<spring:url value="/student/studentProfile"/>'>
										${sessionScope.userDetails.name} </a>
								</div>
								<div class="widget-subheading">Student</div>
							</div>
							<div class="widget-content-right header-user-info ml-3">
								<a href='<spring:url value="/logout"/>' type="button"
									class="btn-shadow p-1 btn btn-danger btn-sm show-toastr-example">
									<i class="text-white fa fa-space-shuttle">LOGOUT</i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>