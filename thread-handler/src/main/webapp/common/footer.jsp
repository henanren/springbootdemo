<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- <div style='height:30px;'></div>	 -->


<article class="container">
<section class="row" id="contact">
		<div class="span12  " style="display: block;margin:10px  0 10px 0; text-align: center;  ">
			<div class="row">
				<div class="span12">
					<div class="padding-large">
					 <div  >
							  <span > 
<%-- 							  <a href="${ctx}/">返回主页</a>&nbsp;&nbsp;&nbsp; --%>
<%-- 							  <a href="${ctx}/">联系我们</a>&nbsp;&nbsp;&nbsp; --%>
									  </span>
										
						 
						</div>
						<div  >
<!-- 							  <span style="color: #369">版权所有，维权必究 -->
<!-- 									  </span> -->
										
							<!--[if lt IE 9]>
                            <p class="text-warning">当前浏览器不支持该模块的交互效果，无法动态展示联系方式，建议换用更高级的浏览器。</p>
                            <p class="text-info">Twitter, Instagram, Path, 新浪微博、腾讯微博和微信的名称为  </p>
                            <![endif]-->
						</div>
		 
					 
						
					</div>
				</div>
			</div>
		</div>
	</section>	


	 
</article>



 
<%@include file="/common/commonjs.jsp"%>
 
<script type="text/javascript">
//  $(document).ready(function(){

// 	    $(document).off('click.bs.dropdown.data-api');
// 	    dropdownOpen();//调用
// 	});
 
//  function dropdownOpen() {

	 

// 	    var $dropdownLi = $('li.dropdown');

	 

// 	    $dropdownLi.mouseover(function() {

// 	        $(this).addClass('open');

// 	    }).mouseout(function() {

// 	        $(this).removeClass('open');

// 	    }); 
//  }
 $(function() {
// 		var $me = $('ul.nav li');
// 		alert(1)
// 		$me.hover(function() {
// 			$(this).addClass('brand');
// 		}, function() {
// 			$(this).removeClass('brand');
// 		})
// 		$me.click(function() {
			
// 			var $me_id=$(this).attr("id");
// 			if($me_id=="1"){
// 				window.location = ctx +"/monitor/status";
// 			}else if($me_id=="2"){
				
// 			}else if($me_id=="3"){
				
// 			}else if($me_id=="4"){
				
// 			}
// 			$(this).addClass("three").siblings().removeClass("three");
// 		})
	})
 </script>
</body>
</html>