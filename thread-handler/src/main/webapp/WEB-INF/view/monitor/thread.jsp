<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/head.jsp"%>
<div style='height: 60px;'></div>



<article class="container">
	<section class="row" id="contact1"
		style='margin: 0px 0 0px 0; width: 100%'>
		<!-- 			<div class="span12 panel" style="display: block;margin:10px 0 10px 0; "> -->
		<div class="span12 panel "
			style='margin: 0 0 0 0; width: 100%; display: block;'>
			<div class="row">
				<div class="span12">
					<div class="padding-large">
						<div class="sns">
							<div class="bs-docs-example">
								<table class="table">
									<tbody>
										<tr class=info>
											<td style="BORDER: none;">运行线程数</td>
											<td style="BORDER: none;">线程池线程数</td>
											<td style="BORDER: none;">调整线程池线程数</td>
										</tr>
										<tr class=info>
											<td style="BORDER: none;">${runs}</td>
											<td style="BORDER: none;">${threads}</td>
											<td style="BORDER: none;"><form id ="frm" class="form-group" action="${ctx}/monitor/set" method="get">
					 
						 
						 
							 
						 <input id="kw" class="form-control"  
								type="text"   style="width: 50px;" name='kw' >&nbsp;&nbsp;&nbsp; 
							<button class="btn btn-primary" type="submit" onclick="return cl();">设置</button>
							 
					 
					</form> </td>
										</tr>
									</tbody>
								</table>
					
 <script type="text/javascript">
 
function cl(){
	var val= $("#kw").val();
// 	 alert(typeof(val));
	
	var ival = parseInt(val);//如果变量val是字符类型的数则转换为int类型 如果不是则ival为NaN
//     alert(typeof(ival));
    if(!isNaN(ival)){
//         alert(val +"是数字");
        $("#frm").submit();
        return true;
    } else{
        alert(val +"不是数字");
return false;
    }


// 	 $("#frm").attr("action",encodeURL("${ctx}/so/"+v+"/p/1"))  ;
// 	location.href=encodeURL("${ctx}/so/"+v+"/p/1");
// 	v=escape(v);
// 	alert(v);
// 	 $("#frm").attr("action","${ctx}/so?kw="+v);
// 	location.href=  encodeURI("${ctx}/so/"+v+"/p/1")  ;
	
}
 
</script>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</section>


</article>

<%@include file="/common/footer.jsp"%>