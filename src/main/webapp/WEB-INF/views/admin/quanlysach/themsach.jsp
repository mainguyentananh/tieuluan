<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Thêm Sách</h1>
</div>

<nav aria-label="breadcrumb">
	<ol class="breadcrumb bg-light text-dark">
		<li class="breadcrumb-item"><a
			href="<c:url value="/noibo/quanlysach"/>">Quản Lý Sách</a></li>
		<li class="breadcrumb-item active" aria-current="page">Thêm Sách</li>
	</ol>
</nav>

<hr>
<c:url value="/noibo/luusach" var="save" />
<form:form action="${save}" method="POST" modelAttribute="n_sach">

	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Tên Sách</label>
			<form:input path="tenSach" class="form-control" required="required" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Liên Kết Hình</label> <input type="text"
				class="form-control" required="required"
				placeholder="Dán liên kết mới của hình ảnh vào đây" name="url" />
		</div>
	</div>
	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Tác Giả</label>
			<form:input path="tacGia" class="form-control" required="required" />
		</div>
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Giá</label>
			<form:input path="gia" class="form-control"/>
		</div>
	</div>
	<div class="form-row">
		<div class="col-md-6 col-sm-12">
			<label class="text-dark">Năm Xuất Bản</label>
			<form:input path="namXuatBan" class="form-control"
				required="required" />
		</div>

		<div class="col-md-6 col-sm-12">
			<label class="text-dark col">Công khai</label>
			<form:input path="congKhai" class="form-control" required="required" />
		</div>
	</div>

	<div class="form-row mt-3">
		<div class="col-md-6 col-sm-12">
			<button type="submit" class="btn btn-primary btn rounded-0 ">Thêm
				Sách</button>
		</div>
	</div>
</form:form>
