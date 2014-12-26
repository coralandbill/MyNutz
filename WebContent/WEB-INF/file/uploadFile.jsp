<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>文件上传</title>
		<jsp:include page="/include/top.jsp"></jsp:include>
	</head>
	<body>
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
		<jsp:include page="/include/foot.jsp"></jsp:include>
	</body>
</html>