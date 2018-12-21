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
											<td style="BORDER: none;">待消费队列数</td>
											<td style="BORDER: none;">已经消费队列数</td>
<!-- 											<td style="BORDER: none;">总队列数</td> -->
										</tr>
										<tr class=info>
											<td style="BORDER: none;">${waits}</td>
											<td style="BORDER: none;">${finishs}</td>
<%-- 											<td style="BORDER: none;">${all}</td> --%>
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