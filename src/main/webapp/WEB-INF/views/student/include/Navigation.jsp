 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


		<div class="app-main">
			<div class="app-sidebar sidebar-shadow">
				<div class="app-header__logo">
					<div class="logo-src"></div>
					<div class="header__pane ml-auto">
						<div>
							<button type="button"
								class="hamburger close-sidebar-btn hamburger--elastic"
								data-class="closed-sidebar">
								<span class="hamburger-box"> <span
									class="hamburger-inner"></span>
								</span>
							</button>
						</div>
					</div>
				</div>
				
				<div class="scrollbar-sidebar">
					<div class="app-sidebar__inner">
						<ul class="vertical-nav-menu">
							<li class="app-sidebar__heading">Dashboards</li>
							<li><a href='<spring:url value="/student/Dashboard"/>' class="mm-active"> <i class="fa fa-television" style="font-size:20px;color:red"></i> HOME
							</a></li>
							<li class="app-sidebar__heading">Knowledge Explorer</li>
							<li><a href="#"> <i class="fa fa-sort-amount-desc"></i>
									Menu <i class="fa fa-sort-amount-asc"></i>
							</a>
								<ul>
									<li><a href='<spring:url value="/student/addQuestion"/>'> <i
											class="metismenu-icon"></i> Add New Question
									</a></li>
									<li><a href='<spring:url value="/student/myQuestion"/>'> <i
											class="metismenu-icon"> </i> My Questions List
									</a></li>
									<li><a href='<spring:url value="/student/allQuestionList"/>'> <i
											class="metismenu-icon"> </i> All Questions
									</a></li>
								
									
								</ul></li>
							
					</div>
				</div>
			</div>

