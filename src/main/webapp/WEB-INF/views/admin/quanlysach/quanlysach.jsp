<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Quản Lý Sách</h1>
</div>
<hr>
<div class=container>
	<div class="row mb-2">
		<div class="col">
				<a class="btn btn-primary btn rounded-0"
					href="<c:url value="/noibo/themsach"  />">Thêm Sách</a>
		</div>
	</div>
	<div class="row">
		<div class="col ">
		<div class="table-responsive text-center">
			<table class="table table-hover">
				  <thead class="bg-dark text-white">
				    <tr>
				      <th scope="col">Mã Số</th>
				      <th scope="col">Tên Sách</th>
				      <th scope="col">Loại Sách</th>
				      <th scope="col">Ảnh</th>
				      <th scope="col">Tác Giả</th>
				      <th scope="col">Số Lượng</th>
				      <th scope="col">Giá</th>
				      <th scope="col">Giảm Giá</th>
				      <th scope="col">Mô Tả</th>
				      <th scope="col">Chỉnh Sửa</th>
				      <th scope="col">Xóa</th>
				      
				    </tr>
				  </thead>
				  <tbody class="text-dark">
				    <c:forEach items="${l_sach}" var="s">
				    <tr>
				     	 <td>${s.id}</td>
				     	 <td>${s.tenHangHoa}</td>
				     	 <td>${s.maSoLoaiHang.tenLoaiHang}</td>
				     	 <td><img src="<c:url value="/resources/images/product/${s.hinh}"/>" height="100px;" width="auto"/></td>
				     	 <td>${s.tacGia}</td>
				     	 <td>${s.soLuong}</td>
				     	 <td><f:formatNumber value="${s.gia}"  pattern="#,### đ" /></td>
				     	 <td><f:formatNumber pattern="#" value="${s.giamGia * 100}"/>%</td>
				     	  <td><textarea rows="10" cols="15" readonly
							class="bg-light">${s.moTa}
     										</textarea></td>   	  
				     	 <td><a href="<c:url value="/noibo/quanlysach/sua/${s.id}"/>" class="btn btn-outline-dark btn-sm" ><i class="fas fa-edit"></i></a></td>
				     	 <td><a href="<c:url value="/noibo/quanlysach/xoa/${s.id}"/>" class="btn btn-outline-danger btn-sm" ><i class="fas fa-trash-alt"></i></a></td>
					</tr>
					</c:forEach>
				    
				 
				  </tbody>
			</table>
		</div>
		</div>
		</div>
		
	<nav aria-label="Page navigation example">
		<ul class="pagination  justify-content-center">
			<c:if test="${param.page >= 2 and param.page != null}">
				<li class="page-item"><a class="page-link" href="<c:url value="/noibo/quanlysach?page=${param.page-1}"/>">Previous</a></li>
			</c:if>
			
			<c:forEach items="${total}" var="test">
				<li class="page-item"><a class="page-link" href="<c:url value="/noibo/quanlysach?page=${test}"/>">${test}</a></li>
			</c:forEach>
			
			<c:if test="${param.page < total.size() or param.page == null}">
				<li class="page-item"><a class="page-link" href="<c:url value="/noibo/quanlysach?page=${param.page+1}"/>">Next</a></li>
			</c:if>
		</ul>
	</nav>
		
		
</div>