<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<c:set value="${thongtin}" var="t" />
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Chi Tiết Đơn Hàng</h1>
</div>
<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-light text-dark">
			     <li class="breadcrumb-item"><a href="<c:url value="/noibo/donhang"/>">Quản Lý Đơn Hàng</a></li>
	   			 <li class="breadcrumb-item active" aria-current="page">Chi Tiết Đơn Hàng</li>
			  </ol>
	</nav>
<hr>
<div class="container mb-3">
	<div class="row">
		<h1 class="h4 text-gray-800 col">Đơn Hàng</h1>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-hover text-center">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col">Tên Sách</th>
						<th scope="col">Hình Ảnh</th>			
						<th scope="col">Số Lượng</th>
						<th scope="col">Giá Đặt Hàng</th>
					</tr>
				</thead>
				<tbody class="text-dark">
					<c:forEach items="${chitietdonhang}" var="d">
						<tr>
							<td>${d.maSoSach.tenSach}</td>
							<td><img
								src="<c:url value="${d.maSoSach.hinh}"/>"
								height="100px;" width="auto" /></td>
							<td>${d.soLuong}</td>
							<td><f:formatNumber value="${d.giaDatHang}"
									pattern="#,### VNĐ" /></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<div class="row">
		<h1 class="h4 text-gray-800 col">Khách Hàng</h1>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-hover text-center">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col">Mã Số</th>
						<th scope="col">Họ Tên</th>
						<th scope="col">Địa Chỉ</th>
						<th scope="col">Email</th>
						<th scope="col">Số Điện Thoại</th>
					</tr>
				</thead>
				<tbody class="text-dark">

					<tr>
						<td>${t.maSoKhachHang.id}</td>
						<td>${t.maSoKhachHang.hoTen}</td>
						<td>${t.maSoKhachHang.diaChi}</td>
						<td>${t.maSoKhachHang.email}</td>
						<td>${t.maSoKhachHang.soDienThoai}</td>
					</tr>
				</tbody>

			</table>
		</div>
	</div>

	<c:if test="${t.maSoNhanVien.id != null}">
		<div class="row">
			<h1 class="h4 text-gray-800 col">Nhân Viên</h1>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-hover text-center">
					<thead class="bg-dark text-white">
						<tr>
							<th scope="col">Mã Số</th>
							<th scope="col">Họ Tên</th>
							<th scope="col">Chức Vụ</th>
							<th scope="col">Email</th>
							<th scope="col">Số Điện Thoại</th>
						</tr>
					</thead>
					<tbody class="text-dark">

						<tr>
							<td>${t.maSoNhanVien.id}</td>
							<td>${t.maSoNhanVien.hoTen}</td>
							<td>${t.maSoNhanVien.chucVu}</td>
							<td>${t.maSoNhanVien.email}</td>
							<td>${t.maSoNhanVien.soDienThoai}</td>
						</tr>
					</tbody>

				</table>
			</div>
		</div>
	</c:if>

	<div class="row">
		<h1 class="h4 text-gray-800 col">Giao Hàng</h1>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-hover text-center">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col">Mã Số Đơn</th>
						<th scope="col">Ngày Đặt Hàng</th>
						<th scope="col">Ngày Giao Hàng</th>
						<th scope="col">Nơi Giao Hàng</th>
						<th scope="col">Tình Trạng</th>
					</tr>
				</thead>
				<tbody class="text-dark">

					<tr>
						<td>${t.id}</td>
						<td>${t.ngayDatHang}</td>
						<td>${t.ngayGiaoHang}</td>
						<td>${t.maSoKhachHang.diaChi}</td>
						<c:if
							test="${t.maSoNhanVien.id == null or t.ngayGiaoHang == null}">
							<td><a href="<c:url value="/noibo/donhang/sua/${t.id}"/>"
								class="btn btn-warning btn-sm"> <i class="fas fa-spinner"></i>
									Chờ Xử Lý
							</a></td>
						</c:if>
						<c:if
							test="${t.maSoNhanVien.id != null and t.ngayGiaoHang != null}">
							<td><span class="btn btn-success btn-sm"><i
									class="far fa-check-circle"></i> Đã Xử Lý</span></td>
						</c:if>
					</tr>
				</tbody>

			</table>
		</div>
	</div>


</div>