<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

	<%--静态包含 base标签 css样式 jquery文件--%>
	<%@include file="/pages/common/head.jsp"%>

	<script>

		$(function () {
			$("#username").blur(function () {
				//1 获取当前用户名
				var username = this.value;
				$.getJSON("http://localhost:9000/book/userServlet", "action=ajaxExistUsername&username="+username, function (data) {
					if (data.existUsername&&data.existUsername!="") {
				      $("span.errorMsg").text("用户名已存在!!!")
					} else {
						$("span.errorMsg").text("用户名可用!!!")
					}


				});

			});

			$("#code_img").click(function () {
				// alert(this.src);
				this.src="${basePath}kaptcha.jpg"

			});

			$("#sub_btn").click(function () {

				var usernameText = $("#username").val();
				var usernamePatt = /^\w{5,12}$/;
				if (!usernamePatt.test(usernameText)) {
					$("span.errorMsg").text("用户名不合法！");
					return false;
				}
				var passwordText = $("#password").val();
				var passwordPatt = /^\w{5,12}$/;
				if (!passwordPatt.test(passwordText)) {
					$("span.errorMsg").text("密码不合法！");
					return false;
				}
				var repwdText = $("#repwd").val();
				if (repwdText != passwordText) {
					$("span.errorMsg").text("密码不一致!");
					return  false;
				}
				var valText = $("#email").val();
				var emailPatt= /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				if (!emailPatt.test(valText)) {
					$("span.errorMsg").text("邮箱不合法！");
					return false;
				}
				var codeText = $("#code").val();
				var codeText = $.trim(codeText);
				if (codeText == null || codeText == "") {
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}
				$("span.errorMsg").text("");
			});
		});
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>


</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
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
								<span class="errorMsg">
									<%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
										   name="username" id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
										   name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
										   name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
										   name="email" id="email" value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 80px;" id="code"/>
									<img alt="" id="code_img" src="kaptcha.jpg" style="float: right; margin-right: 40px;width: 120px;height: 32px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%-- 静态包含页脚--%>
		<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>