<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<br />
	 <br /> 
	 <br /> 
	 <span> Hệ thống đã gửi mã kích hoạt, vui lòng kiểm tra.</span>
		<br/>
		<div>
		<form action="VerifyCode" method ="post" class ="log-reg-block sky-form">
		<div class="input-group">
		<input type="text" name="authcode" class="form-control margin-top-20">
		</div>
		<input type="submit" value="Kích hoạt" class="btn-u btn-u-sea-shop margin-top-20">
		</form>
		</div>
		<br />
		 <br /> 
		 <br /> 

</div> --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verify Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <br />
    <br />
    <br />
    <h3 class="text-center">Xác thực tài khoản</h3>
    <span>Hệ thống đã gửi mã kích hoạt, vui lòng kiểm tra.</span>
    <br/>
    
    <c:if test="${message != null}">
        <div class="alert alert-success" role="alert">${message}</div>
    </c:if>
    
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">${error}</div>
    </c:if>
    
    <div>
        <form action="VerifyCode" method="post" class="log-reg-block sky-form">
            <div class="input-group">
                <input type="text" name="authcode" class="form-control margin-top-20" placeholder="Nhập mã xác thực" required>
            </div>
            <input type="submit" value="Kích hoạt" class="btn btn-primary margin-top-20">
        </form>
    </div>
    <br />
    <br />
    <br />
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>