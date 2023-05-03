<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!Doctype html>
<html lang="en">
  <head>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

    <title>Page Title</title>
  </head>
  <body>
  <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>
  <div class="container">
        <h1>Login Page</h1>
      ${error}
      <form method="post" >
      Name:<input type="text" name="name" placeholder="enter name"/>
      Password:<input type="password" name="password" placeholder="enter password"/>
      <input type="submit"/>
      </form>
     </div>
     
  </body>
</html>