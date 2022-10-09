<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Quản Lý Nhân Viên</h1>
</div>
<hr>
<div class=container>
	<div class="row mb-2">
		<div class="col">
			<a class="btn btn-primary btn rounded-0"
				href="<c:url value="/admin/themnhanvien"  />">Thêm Nhân Viên</a>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-hover text-center">
				<thead class="bg-dark text-white">
					<tr>
						<th scope="col">Mã Số</th>
						<th scope="col">Tên</th>
						<th scope="col">Ngày Sinh</th>
						<th scope="col">Giới Tính</th>
						<th scope="col">Địa Chỉ</th>
						<th scope="col">Chức Vụ</th>
						<th scope="col">Email</th>
						<th scope="col">Số Điện Thoại</th>
						<th scope="col">Chỉnh Sửa</th>
					</tr>
				</thead>
				<tbody class="text-dark">
					<c:forEach items="${l_nhanvien}" var="nv">
						<tr>
							<td>${nv.id}</td>
							<td>${nv.hoTen}</td>
							<td>${nv.ngaySinh}</td>
							<c:if test="${nv.gioiTinh == true}">
								<td>Nam</td>
							</c:if>
							<c:if test="${nv.gioiTinh != true}">
								<td>Nữ</td>
							</c:if>
							<td>${nv.diaChi}</td>
							<td>${nv.chucVu}</td>
							<td>${nv.email}</td>
							<td>${nv.soDienThoai}</td>
							<td><a href="<c:url value="/admin/nhanvien/sua/${nv.id}"/>" class="btn btn-outline-dark btn-sm" ><i class="fas fa-edit"></i></a></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>
</div>