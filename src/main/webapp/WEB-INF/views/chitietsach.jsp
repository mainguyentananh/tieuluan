
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<div class="container space-s">
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Chi Tiết Sách</h1>
	</div>

	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-white text-dark">
			     <li class="breadcrumb-item"><a href="<c:url value="/trangchu"/>">Trang Chủ</a></li>
	   			 <li class="breadcrumb-item active" aria-current="page">Chi Tiết Sách</li>
			  </ol>
	</nav>

	<div class="row">
		<div class="col">
			<div class="card mb-3">
				<div class="row no-gutters" >
					<div class="col-md-6">
						<img src="<c:url value="${chiTietSach.hinh}"/>" class="card-img " alt="Sách ${chiTietSach.tenSach}"/>
					</div>
					<div class="col-md-6">
						<div class="card-body" >
							<h2 class="card-title font-weight-bold ">${chiTietSach.tenSach}</h2>
							<br>
							<p class="card-text"><span class="font-weight-bold">Tác Giả:</span> ${chiTietSach.tacGia}</p>                                             	
							<p class="card-text"><span class="font-weight-bold">Năm Xuất Bản:</span> ${chiTietSach.namXuatBan}</p>
							<p class="card-text"><span class="font-weight-bold">Công Khai:</span> ${chiTietSach.congKhai}</p>
                             <p class="card-text font-weight-bold">Giá: <f:formatNumber value="${chiTietSach.gia}"  pattern="#,### VNĐ" /></p>
							<a href="<c:url value="/trangchu"/>" class="btn btn-outline-primary btn-lg add-card mr-2" data-id="${chiTietSach.maSoSach}"><i class="fas fa-shopping-cart"></i> Cho Vào Giỏ</a>	
							<button type="button" class="btn btn-outline-danger btn-lg add-card" id="thanhToan" data-id="${chiTietSach.maSoSach}"><i class="far fa-credit-card"></i> Thanh Toán</button>
						</div>		
					</div>		
				</div>	
			</div>					
		</div>
	</div>
<p class="d-flex justify-content-end"><small class="text-muted">Mong Khách Hàng Điền Thông Tin Chính Xác Để Đảm Bảo Giao Nhận Hàng. Xin Cảm Ơn!</small></p>
</div>