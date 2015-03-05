<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
 	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="${pageContext.request.contextPath}/bootstrap-3.3.2-dist/js/jquery-1.11.2.min.js"></script>
	
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="${pageContext.request.contextPath}/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<title>登陆</title>
<style type="text/css">
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #eee;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

</style>
</head>
<body>
    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath}/user/login.do" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
	        <label for="inputUserName" class="sr-only">用户名</label>
	        <input type="text" id="inputUserName" name="username" class="form-control" placeholder="用户名" required autofocus>
	        <label for="inputPassword" class="sr-only">密码</label>
	        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
