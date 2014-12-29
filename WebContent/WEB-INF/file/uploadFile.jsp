<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
<!--     <link rel="icon" href="../../favicon.ico">
 -->
    <title>文件上传</title>

    <!-- Custom styles for this template -->
    <link href="/css/jumbotron.css" rel="stylesheet">
    <jsp:include page="/include/top.jsp"></jsp:include>
  </head>

  <body>

	<jsp:include page="/include/topMenu.jsp"></jsp:include>

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
      <div>
		<form role="form" method="post" name="uploadForm" id="uploadForm" action="<%=request.getContextPath() %>/file/doUpload" enctype="multipart/form-data">
			<div class="form-group">
			    <label for="file">File input</label>
			    <input type="file" id="file" name="file" emptyInfo="请选择要上传的资源文件！">
			    <p class="help-block">请选择需要上传的文件</p>
			</div>
			<button type="submit" class="btn btn-default">上 传</button>
		</form>
	 </div>
      <hr>

      <footer>
        <p>&copy; Company 2014</p>
      </footer>
    </div> <!-- /container -->
	<jsp:include page="/include/foot.jsp"></jsp:include>
  </body>
</html>
