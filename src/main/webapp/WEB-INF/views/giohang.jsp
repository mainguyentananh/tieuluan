<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<c:set var="session" value="${sessionScope['scopedTarget.gioHangSession']}"/>
<div class="space-s">
<c:if test="${session.getCount()==0 or empty session}">
    <div class="container">
    	<div class="row">
    		<div class="col text-center">
    			 <img src="<c:url value="/resources/images/empty-card.png"/>" height="100px;" class="mb-3"/>
    			<div class="text-dark font-weight-bold mb-2">Không có sản phẩm nào trong giỏ hàng.</div>
    			<a href="<c:url value="/trangchu"/>" class="btn btn-outline-primary btn-lg" ><i class="fas fa-home"></i> Về Trang Chủ</a>
    		</div>
    	</div>
    </div>
    
</c:if>

<c:if test="${session.getCount()>0 }">
	<div class="container">
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Giỏ Hàng</h1>
	</div>
	
	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb bg-white text-dark">
			     <li class="breadcrumb-item"><a href="<c:url value="/trangchu"/>">Trang Chủ</a></li>
	   			 <li class="breadcrumb-item active" aria-current="page">Giỏ Hàng</li>
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
						 	  <th scope="col"></th>
						    </tr>
						  </thead>
						  	 <tbody class="text-dark  font-weight-bold">
						  		 <c:forEach items="${session.getItems()}" var="s">
						  		 <tr>
						  			<td >${s.tenSach}</td>
						  			<td><img src="<c:url value="${s.hinh}"/>" height="100px;" width="auto"/></td>
						  			<td><f:formatNumber value="${s.soLuong * s.gia}"  pattern="#,### VNĐ" /></td>
						  			<td>
						  			<a href="<c:url value="/tang/${s.maSoSach}"/>" ><i class="fas fa-plus"></i></a>
						  				<span class="ml-1 mr-1">${s.soLuong}</span>
						  			<a href="<c:url value="/giam/${s.maSoSach}"/>"><i class="fas fa-minus"></i></a>	
						  			</td>
						  			<td><a href="<c:url value="/xoa/${s.maSoSach}"/>" class="btn btn-outline-danger" ><i class="far fa-trash-alt"></i></a></td>
						  		</tr>
						  		</c:forEach>  		
						  	</tbody>
						  </table>	  
						  <span class="text-dark font-weight-bold d-flex justify-content-end mb-3">Tổng Giỏ Hàng: <f:formatNumber value="${session.getAmount()}"  pattern="#,### VNĐ" /></span>
				</div>
				<div class="col">
				  <a href="<c:url value="/thanhtoan"/>" class="btn btn-outline-primary mr-2" ><i class="far fa-credit-card"></i> Tiếp Tục Thanh Toán</a>
				  <a href="<c:url value="/huygiohang"/>" class="btn btn-outline-danger" ><i class="far fa-trash-alt"></i> Hủy Giỏ Hàng</a>
				</div>
		</div>
	</div>			  
</c:if>
</div>