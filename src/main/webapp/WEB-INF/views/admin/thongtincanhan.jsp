<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Chỉnh Sửa Thông Tin</h1>
</div>

<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-light text-dark">
	   			 <li class="breadcrumb-item active" aria-current="page">Chỉnh Sửa Thông Tin</li>
			  </ol>
</nav>

<hr>
<c:url value="/noibo/suathongtincanhan" var="save" />
<form:form action="${save}" method="POST" modelAttribute="e_canhan" >

	<div class="form-row">
		<form:hidden path="id"/>
		
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Tên Nhân Viên</label>
			<form:input path="hoTen" class="form-control" readonly="true"/>
		</div>

		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Ngày Sinh</label>
			<form:input path="ngaySinh" class="form-control" readonly="true"/>
		</div>
	</div>


	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Giới tính</label><br>
			<form:hidden path="gioiTinh"/>
			<c:if test="${e_nhanvien.gioiTinh == true}">
				<input value="Nam" readonly class="form-control" />
			</c:if>
			<c:if test="${e_nhanvien.gioiTinh != true}">
				<input value="Nữ" readonly class="form-control" />
			</c:if>
			
		</div>

		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Địa Chỉ</label>
			<form:input path="diaChi" class="form-control" required="required"/>
		</div>
	</div>

	<div class="form-row">
		
		<div class="col-md-4 col-sm-12">
			<label class="text-dark">Chức Vụ</label>
			<form:input path="chucVu" class="form-control" readonly="true"/>
		</div>
	
		<div class="col-md-4 col-sm-12">
			<label class="text-dark">Email</label>
			<form:input path="email" class="form-control" readonly="true"/>
		</div>
		
			<div class="col-md-4 col-sm-12">
			<label class="text-dark">Số Điện Thoại </label> 
			<form:input path="soDienThoai" class="form-control" required="required"/>
		</div>
	</div>

	<hr class="mt-3"/>
	<div class="form-row">
	<label class="text-dark h4">Thay đổi mật khẩu</label>
	</div>
	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Mật khẩu mới</label>
			<input type="password" name="npassword" class="form-control"/>
		</div>
		
			<div class="col-md-6 col-sm-12">
			<label class="text-dark">Nhập lại mật khẩu mới </label> 
			<input type="password" name="rpassword" class="form-control"/>
		</div>
	</div>

	<div class="form-row mt-3">
	<div class="col-md-6 col-sm-12">
		<button type="submit" class="btn btn-primary btn rounded-0 ">Chỉnh Sửa
			Thông Tin</button>
	</div>
	</div>
</form:form>
    