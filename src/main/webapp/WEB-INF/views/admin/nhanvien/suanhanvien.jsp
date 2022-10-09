<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Chỉnh Sửa Nhân Viên</h1>
</div>

<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-light text-dark">
			     <li class="breadcrumb-item"><a href="<c:url value="/admin/nhanvien"/>">Quản Lý Nhân Viên</a></li>
	   			 <li class="breadcrumb-item active" aria-current="page">Chỉnh Sửa Nhân Viên</li>
			  </ol>
</nav>

<hr>
<c:url value="/admin/suanhanvien" var="save" />
<form:form action="${save}" method="POST" modelAttribute="e_nhanvien" >

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
			<form:input path="diaChi" class="form-control" />
		</div>
	</div>

	<div class="form-row">
		<div class="col-md-4 col-sm-12">
			<label class="text-dark">Chức Vụ:</label><br/>
			
				<span class="ml-3 "></span>
				<form:radiobutton  path="chucVu" value="Quản Lý"/>
				<label>Quản Lý</label>
				<span class="mr-3 ml-3"></span>
				<form:radiobutton path="chucVu" value="Nhân Viên" />
				<label>Nhân Viên</label>
	
		</div>
		<div class="col-md-4 col-sm-12">
			<label class="text-dark">Email</label>
			<form:input path="email" class="form-control" />
		</div>
		
			<div class="col-md-4 col-sm-12">
			<label class="text-dark">Số Điện Thoại </label> 
			<form:input path="soDienThoai" class="form-control" />
		</div>
	</div>

	<div class="form-row mt-3">
	<div class="col-md-6 col-sm-12">
		<button type="submit" class="btn btn-primary btn rounded-0 ">Chỉnh Sửa
			Sách</button>
	</div>
	</div>
</form:form>
    