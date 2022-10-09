<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>

<c:set var="session" value="${sessionScope['scopedTarget.gioHangSession']}"/>
<div class="container">	
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Thanh Toán</h1>
	</div>
	<nav aria-label="breadcrumb">
		  <ol class="breadcrumb bg-white text-dark">
		   <li class="breadcrumb-item"><a href="<c:url value="/trangchu"/>">Trang Chủ</a></li>
	   		<li class="breadcrumb-item"><a href="<c:url value="/giohang"/>">Giỏ Hàng</a></li>
	   		<li class="breadcrumb-item active" aria-current="page">Thanh Toán</li>
		  </ol>
	</nav>

		<div class="row">
			<div class="table-responsive text-center">
					<table class="table table-hover">
						  <thead class="thead-dark">
						    <tr>
						      <th scope="col">Tên Sách</th>
						      <th scope="col">Hình</th>
						      <th scope="col">Giá</th>
							  <th scope="col">Số Lượng</th>
						    </tr>
						  </thead>
						  	 <tbody class="text-dark  font-weight-bold" >
						  		 <c:forEach items="${session.getItems()}" var="s">
						  		 <tr>
						  			<td >${s.tenSach}</td>
						  			<td><img src="<c:url value="${s.hinh}"/>" height="100px;" width="auto"/></td>
						  			<td><f:formatNumber value="${s.soLuong * s.gia}"  pattern="#,### VNĐ" /></td>
						  			<td>${s.soLuong}</td>
						  		</tr>
						  		</c:forEach>  		
						  	</tbody>
						  </table>	  
						  <span class="text-dark font-weight-bold d-flex justify-content-end mb-3">Tổng Giỏ Hàng: <f:formatNumber value="${session.getAmount()}"  pattern="#,### VNĐ" /></span>
				</div>
</div>
</div>
<div class="container">
	<div class="row">
		<div class="col">
			<c:url value="/dathang" var="dathang" />
			<form:form action="${dathang}" method="POST" modelAttribute="kh">
			<div class="col text-center h3">Thông Tin Khách Hàng</div>
			    <div class="form-row">
			    <div class="form-group col-md-6">
			      <label>Họ Tên Khách Hàng</label>
			      <form:input path="hoTen" type="text" class="form-control" required="true"/>
			    </div>
			    <div class="form-group col-md-6">
			      <label >Số Điện Thoại</label>
			      <form:input path="soDienThoai" type="text" class="form-control" required="true"/>
			    </div>
			  </div>
			 
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label >Email</label>
			      <form:input path="email" type="text" class="form-control" required="true"/>
			    </div>  
			
			     <div class="form-group col-md-6">
			      <label >Địa Chỉ</label>
			      <form:input path="diaChi" type="text" class="form-control" required="true"/>
			    </div> 
			  </div>
			  <button type="submit" class="btn btn-primary col text-center h3 ">Tiến Hành Đặt Hàng</button>
			</form:form>
			</div>
		</div>
</div>