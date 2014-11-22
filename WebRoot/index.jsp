<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AD过滤</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/source/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    	.blue{border-top: 1px solid #2FAEF0;}
    </style>
    
  </head>
  <body>
   <div class="container-fluid">
   <h3>过滤url</h3>
   <hr class="blue">
   	<div class="row">
     <form class="form-signin" action='${pageContext.request.contextPath}/filter.do' method="post">
			<div class="form-group col-sm-11">
				<div class="input-group">
					<div class="input-group-addon">url地址(包含http://)</div>
					<input type="text" class="form-control" name="url" placeholder="url地址">
				</div>
			</div> 
			<div class="col-sm-1"><button type="submit" class="btn btn-default">过滤</button></div>        
      </form>
      </div>
      <h3>信息</h3>
   <hr class="blue">
      ${urls}
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/source/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/source/js/bootstrap.min.js"></script>
  </body>
</html>
