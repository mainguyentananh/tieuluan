<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Xử Lý Đơn Hàng</h1>
</div>
<nav aria-label="breadcrumb">
	<ol class="breadcrumb bg-light text-dark">
		<li class="breadcrumb-item"><a
			href="<c:url value="/noibo/donhang"/>">Quản Lý Đơn Hàng</a></li>
		<li class="breadcrumb-item active" aria-current="page">Xử Lý Đơn
			Hàng</li>
	</ol>
</nav>
<hr>
<div class="container">
	<c:url value="/noibo/xulydonhang" var="save" />
	<form:form action="${save}" method="POST" modelAttribute="donhang"
		enctype="multipart/form-data">

		<div class="form-row">
			<div class=" col-md-6 col-sm-12">
				<label class="text-dark">Mã Số Đơn Hàng</label>
				<form:input path="id" class="form-control" readonly="true" />
			</div>

			<div class="col-md-6 col-sm-12">
				<label class="text-dark">Mã Số Khách Hàng</label>
				<form:input path="maSoKhachHang.id" class="form-control"
					readonly="true" />
			</div>
		</div>

		<div class="form-row">
			<div class=" col-md-6 col-sm-12">
				<label class="text-dark">Mã Số Nhân Viên</label>
				<form:input path="maSoNhanVien.id" class="form-control"
					value="${nv.id}" readonly="true" />
			</div>
			<div class=" col-md-6 col-sm-12">
				<label class="text-dark">Tên Nhân Viên</label> <input
					class="form-control" value="${nv.hoTen}" readonly />
			</div>
		</div>

		<div class="form-row">
			<div class="col-md-6 col-sm-12">
				<label class="text-dark">Ngày Đặt Hàng</label>
				<form:input path="ngayDatHang" class="form-control" readonly="true" />
			</div>

			<div class=" col-md-6 col-sm-12">
				<label class="text-dark">Ngày Giao Hàng</label>
				<c:if test="${donhang.ngayGiaoHang == null}">
					<input type="date" name="ngh" class="form-control" />
				</c:if>

				<c:if test="${donhang.ngayGiaoHang != null}">
					<input type="date" name="ngh" value="${donhang.ngayGiaoHang}" class="form-control" readonly/>
				</c:if>
			</div>
		</div>

		<div class="form-row">
			<div class="col-md-6 col-sm-12 mt-3">
				<button type="submit" class="btn btn-primary rounded-0 btn-lg">Xử
					Lý</button>
			</div>

		</div>
	</form:form>
</div>
<c:if test="${not empty param.notify}">
	<div class="text-danger mt-3 ml-3">Ngày Xét Duyệt Phải Sau Ngày Đặt Hàng</div>
</c:if>