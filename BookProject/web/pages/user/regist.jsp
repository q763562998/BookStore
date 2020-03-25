<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">

		
		
		$(function () {



			$("#putcode").click(function () {
				this.src="http://localhost:8080/BookProject/kaptchaServlet.jpg?d="+new Date();
			});
			$("#sub_btn").click(function () {
				var usernameText = $("#username").val();
				var usernamePatt = /^\w{5,12}$/;
				if (!usernamePatt.test(usernameText)) {
					$("span.errorMsg").text("用户名不合法");
					return false;
				}
				// $("span.errorMsg").text("");
				var passwordText = $("#password").val()
				var passwordPatt = /^\w{5,12}$/;
				if (!passwordPatt.test(passwordText)) {
					$("span.errorMsg").text("密码不合法");
					return false;
				}

				var comfirmPassword = $("#repwd").val();
				if (comfirmPassword != passwordText) {
					$("span.errorMsg").text("两次密码不一样");
					return false;
				}
				var emailText = $("#email").val();
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if (!emailPatt.test(emailText)) {
					$("span.errorMsg").text("邮箱错误");
					return false;
				}
				var correctCode = $("#code").val();
				var s = correctCode.trim();
				if (s == null || s == "") {
					$("span.errorMsg").text("验证码不能为空");
					return false;
				}
			});
		});
	</script>

	<style type="text/css">
		.login_form {
			height: 420px;
			margin-top: 25px;
		}

	</style>
</head>
<body>
<div id="login_header">
	<img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

	<div id="l_content">
		<span class="login_word">欢迎注册</span>
	</div>

	<div id="content">
		<div class="login_form">
			<div class="login_box">
				<div class="tit">
					<h1>注册尚硅谷会员</h1>
					<span class="errorMsg"><%=



					request.getAttribute("msg")==null?"请输入要注册的信息":request.getAttribute("msg")

					%>



					</span>
				</div>
				<div class="form">
					<form action="regisiter" method="post">
						<label>用户名称：</label>
						<input class="itxt" type="text" placeholder="请输入用户名"
							   autocomplete="off" tabindex="1" name="username" id="username"
								value=<%=

									request.getAttribute("username")==null?"":request.getAttribute("username")

									%>
						>
						<br/>
						<br/>
						<label>用户密码：</label>
						<input class="itxt" type="password" placeholder="请输入密码"
							   autocomplete="off" tabindex="1" name="password" id="password"


							   value=<%=

									request.getAttribute("password")==null?"":request.getAttribute("password")

									%>

						>
						<br/>
						<br/>
						<label>确认密码：</label>
						<input class="itxt" type="password" placeholder="确认密码"
							   autocomplete="off" tabindex="1" name="repwd" id="repwd"

							   value=<%=

									request.getAttribute("repwd")==null?"":request.getAttribute("repwd")

									%>
						>
						<br/>
						<br/>
						<label>电子邮件：</label>
						<input class="itxt" type="text" placeholder="请输入邮箱地址"
							   autocomplete="off" tabindex="1" name="email" id="email"

							   value=<%=

									request.getAttribute("email")==null?"":request.getAttribute("email")

									%>
						>
						<br/>
						<br/>
						<label>验证码：</label>
						<input class="itxt" type="text" name="code" style="width: 100px;" id="code"


							   value=<%=

									request.getAttribute("code")==null?"":request.getAttribute("code")

									%>

						>
						<img  id="putcode"  alt="" src="kaptchaServlet.jpg" style="float: right;
						 margin-right: 40px ;width: 100px ;height: 26px">
						<br/>
						<br/>
						<input type="submit" value="注册" id="sub_btn"/>

					</form>
				</div>

			</div>
		</div>
	</div>
</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>