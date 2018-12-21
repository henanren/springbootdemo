<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/head.jsp"%>
<%-- <%@include file="/common/so.jsp"%> --%>
<!-- <div style='height: 30px;'></div> -->

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
											<td style="BORDER: none;">服务状态：红色是故障，绿色是正常</td>
										</tr>
										<tr class=info>
											<td
												style="  BORDER: none;  background-color: <c:if test="${status == 0}">green;</c:if>
															<c:if test="${status  == 1}">red;</c:if>
															"></td>
										</tr>
									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</section>


</article>


<%@include file="/common/footer.jsp"%>