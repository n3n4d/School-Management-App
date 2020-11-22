<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/css/style.css">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">School
				Management App</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end"
				id="navbarSupportedContent">
				<ul class="navbar-nav">
					<c:url var="logoutURL" value="/" />
				</ul>
				<form action="${logoutURL}" method="post">
					<input type="submit" value="Logout" class="btn btn-primary" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</nav>

		<div class="row navigation">
			<div class="col-6 col-sm-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/students'">Students</button>
			</div>
			<div class="col-6 col-sm-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/groups'">Groups</button>
			</div>
			<div class="col-6 col-sm-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/teachers'">Teachers</button>
			</div>
			<div class="col-6 col-sm-3">
				<button class="btn btn-primary nav-button"
					onclick="location.href='${pageContext.request.contextPath}/classrooms'">Classrooms</button>
			</div>
		</div>