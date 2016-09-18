<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String contextPath = request.getContextPath(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
html,body {height: 100%;}
#floater{
	float:left;
	height:50%;/*相对于父元素高度的50%*/
	margin-bottom: -120px;/*值大小为居中元素高度的一半（240px/2）*/
}
#content {
	clear:both;/*清除浮动*/
	height: 240px;
	position: relative;
}
</style>
<%@ include file="header.jsp" %>
<link rel="stylesheet" href="<%=basePath%>js/jqueryui/jquery-ui.min.css">
<script src="<%=basePath%>js/jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		$( "#input" ).autocomplete({
			source: function( request, response ) {
				$.ajax({
		            type: "post",
		            url: "<%=basePath%>command/getCommandList",
		            data: {command:request.term},
		            dataType: "json",
		            success: function(data,textStatus){
		            	response(data);
				    }
				});
			},
			minLength:2
		});
	});
</script>
</head>
<body>
<div id="floater"></div>
<div id="content" class="container">
	<div class="row">
		<div class="col-md-6 col-sm-4 col-md-offset-3 col-sm-offset-4" >
			<input type="text" class="form-control input-lg" id="input">
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>