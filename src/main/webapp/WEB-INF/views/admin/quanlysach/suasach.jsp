<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Chỉnh Sửa Sách</h1>
</div>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb bg-light text-dark">
		<li class="breadcrumb-item"><a
			href="<c:url value="/noibo/quanlysach"/>">Quản Lý Sách</a></li>
		<li class="breadcrumb-item active" aria-current="page">Chỉnh Sửa
			Sách</li>
	</ol>
</nav>
<hr>
<div class="mb-3">
	<c:url value="/noibo/suasach" var="save" />
	<form:form action="${save}" method="POST" modelAttribute="s_sach">
		<div class="form-row">
			<div class="col-md-2 col-sm-12 mt-2">
				<form:hidden path="hinh" class="form-control" />
				<label class="text-dark col">Hình </label> <img
					src="<c:url value="${s_sach.hinh}"/>" height="200px" width="" />
			</div>
			<div class="col-md-10 col-sm-12 mt-2">
				<div class="form-row">
					<div class="col-md-6 col-sm-12">
						<label class="text-dark">Mã Số</label>
						<form:input path="maSoSach" class="form-control" readonly="true" />
					</div>

					<div class="col-md-6 col-sm-12">
						<label class="text-dark">Tên Sách</label>
						<form:input path="tenSach" class="form-control" />
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6 col-sm-12">
						<label class="text-dark">Tác Giả</label>
						<form:input path="tacGia" class="form-control" />
					</div>
					<div class="col-md-6 col-sm-12">
						<label class="text-dark">Giá</label>
						<form:input path="gia" class="form-control" />
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6 col-sm-12">
						<label class="text-dark">Năm Xuất Bản</label>
						<form:input path="namXuatBan" class="form-control" />
					</div>

					<div class="col-md-6 col-sm-12">
						<label class="text-dark col">Công khai</label>
						<form:input path="congKhai" class="form-control" />
					</div>
				</div>
			</div>
		</div>
		<input type="text" class="form-control" placeholder="Dán liên kết mới của hình ảnh vào đây" name="url"/>


		<div class="form-row mt-3">
			<div class="col-md-6 col-sm-12">
				<button type="submit" class="btn btn-primary btn rounded-0 ">Sữa
					Sách</button>
			</div>
		</div>
	</form:form>
</div>