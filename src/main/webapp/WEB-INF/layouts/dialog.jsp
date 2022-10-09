<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal " tabindex="-1" id="thongBao">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">SunShop</h5>
		        <a href="<c:url value="/trangchu"/>" class="btn close"  aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </a>
		      </div>
		      <div class="modal-body">
		        <p>Sản Phẩm Đã Được Cho Vào Giỏ Hàng.</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Tiếp Tục Mua Hàng</button>
		        <a href="<c:url value="/giohang"/>" class="btn btn-primary" >Xem Giỏ Hàng</a>
		      </div>
		    </div>
		  </div>
</div>
