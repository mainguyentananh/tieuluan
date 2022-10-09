
$(document).ready(function(){
		//Start Hover Product
          $(".card-s").hover(
			function(){
	           $(this).removeClass("border-light");
	           $(this).addClass("bg-light");
	         }
			,function(){
             	$(this).addClass("border-light");
              	$(this).removeClass("bg-light");    
          });
		//End Hover Product
		
		//Add To Card
			$(".add-card").click(function(){
			    var id = $(this).data("id");
				 $.ajax({	
						url: "/sunshop/themvaogio/"+id, 
						success: function(response){
					    $(".count-p").html(response);
						
						if(response==1){
							$('#thongBao').modal('show');
						}
						
					  }});
					
			  });
		//End Add To Card
		
		
		//thanhToan
			$('#thanhToan').click(function(){
				$('#thongBao').modal('show');
			});
		
		//end thanhToan
	

});