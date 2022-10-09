<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="session" value="${sessionScope['scopedTarget.gioHangSession']}"></c:set>
       <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark text-white" >
            <div class="container">
                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href='<c:url value="/trangchu"/>'>Trang Chủ</a>
                        </li>                          	  
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/giohang"/>">Giỏ Hàng</a>
                        </li>
                        <li class="nav-item">
                            <sec:authorize access="!isAuthenticated()">
								<a class="nav-link" href="<c:url value="/dangnhap"/>">Đăng Nhập</a>
							</sec:authorize>
							
                        	<sec:authorize access="isAuthenticated()"> 
							 	<li class="nav-item"> 
                        			<li class="nav-item dropdown">
						        	<a class="nav-link dropdown-toggle " id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						       		 ${pageContext.request.userPrincipal.name}
						        	</a>
						        		<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							        		<a class="dropdown-item" href="<c:url value="/noibo/trangchu"/>">Nội Bộ</a>
							        		<a class="dropdown-item" href="<c:url value="/dangxuat"/>">Đăng Xuất</a> 
						        		</div>
					      			</li>
                  				</li> 
							</sec:authorize>
                        
                        </li>  
                    </ul>
                    <form action="<c:url value="/search"/>" class="form-inline my-2 my-lg-0 " method="POST">
		                 <input class="form-control mr-sm-2 input-s" name="sach" value="${param.sach}" type="search" placeholder="search" aria-label="Search" >
            		</form>
                </div>
                 <a class="text-white nav-link" href="<c:url value="/giohang"/>" ><i class="fas fa-shopping-cart" ></i> <sup class="count-p badge badge-warning rounded-circle" id="check-cart">${session.getCount()}</sup></a>
            </div>
</nav>

