<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
<!--     <link rel="icon" href="../../favicon.ico">
 -->
    <title>登陆</title>

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
    <jsp:include page="include/top.jsp"></jsp:include>
 <!--   	<script>
	   	$(function () {
	   		$("#loginForm").submit(function () {
	   			$.ajax({
	   				url : "${base}/user/login",
	   				data : $("#loginForm").serialize(),
	   				success : function (res) {
	   					alert(res);
	   					return false;
	   				},
	   				fail : function(res) {
	   					alert("系统错误?!");
	   				}
	   			});
	   			return false;
	   		});
	   	});
   	</script> -->
  </head>

  <body>

    <jsp:include page="include/topMenu.jsp"></jsp:include>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; Company 2014</p>
      </footer>
    </div> <!-- /container -->


    <jsp:include page="include/foot.jsp"></jsp:include>
  </body>
</html>
