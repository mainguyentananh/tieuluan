<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Quản Lý Đơn Hàng</h1>
</div>
<hr>
<div class=container>
	<div class="row">
		<div class="col">
			<table class="table table-hover text-center">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">Mã Số Đơn</th>
				      <th scope="col">Mã Số Nhân Viên</th>
				      <th scope="col">Mã Số Khách Hàng</th>
				      <th scope="col">Ngày Đặt Hàng</th>
				      <th scope="col">Ngày Giao Hàng</th>
				      <th scope="col">Tình Trạng</th>
				      <th scope="col">Chi Tiết Đơn Hàng</th>
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				    <c:forEach items="${l_donhang}" var="dh">
				    <tr>
				     	 <td>${dh.id}</td>
				     	 <td>${dh.maSoNhanVien.id}</td>
				     	 <td>${dh.maSoKhachHang.id}</td>
				     	 <td>${dh.ngayDatHang}</td>
				     	 <td>${dh.ngayGiaoHang}</td>
				     	 <c:if test="${dh.maSoNhanVien.id == null or dh.ngayGiaoHang == null}">
				     	 	<td><a href="<c:url value="/noibo/donhang/sua/${dh.id}"/>" class="btn btn-warning btn-sm" >
				     	 	<i class="fas fa-spinner"></i> Chờ Xử Lý
				     	 	</a>
				     	 	</td>
				     	 </c:if>
				     	 <c:if test="${dh.maSoNhanVien.id != null and dh.ngayGiaoHang != null}">
				     	 	<td><span class="btn btn-success btn-sm"><i class="far fa-check-circle"></i> Đã Xử Lý</span></td>
				     	 </c:if>
				     	 
				     	 <td><a href="<c:url value="/noibo/chitietdonhang/${dh.id}"/>">Xem</a></td>
					</tr>
					</c:forEach>
				    
				 
				  </tbody>
			</table>
		</div>
		</div>
</div>