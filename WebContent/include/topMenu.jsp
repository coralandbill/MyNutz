  <%@page import="net.xmf.nutz.bean.HyUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
   <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">首页</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
	        <ul class="nav navbar-nav">
	            <li class="#home"><a href="#">Home</a></li>
	            <li><a href="#about">About</a></li>
	            <li><a href="#contact">Contact</a></li>
	            <li class="active">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
	              <ul class="dropdown-menu" role="menu">
	                <li><a href="<%=request.getContextPath() %>/file/uploadFile">上传文件</a></li>
	                <li><a href="#">Another action</a></li>
	                <li><a href="#">Something else here</a></li>
	                <li class="divider"></li>
	                <li class="dropdown-header">Nav header</li>
	                <li><a href="#">Separated link</a></li>
	                <li><a href="#">One more separated link</a></li>
	              </ul>
	            </li>
	          </ul>
	          <%
	          	HyUser hyUser = (HyUser)request.getSession().getAttribute("user");
	          %>
	          <%
	          	if(hyUser==null){
	          %>
	            <form class="navbar-form navbar-right" role="form" action="<%=request.getContextPath() %>/user/login" method="post">
		            <div class="form-group">
		              <input type="text" name="loginName" placeholder="邮箱/手机号" class="form-control">
		            </div>
		            <div class="form-group">
		              <input type="password" name="password" placeholder="密码" class="form-control">
		            </div>
		            <button type="submit" class="btn btn-success">登 录</button>
	            </form>
	         <% 
	          	}else{
	         %>
	         	<ul class="nav navbar-nav">
		         	 <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.realName} <span class="caret"></span></a>
		              <ul class="dropdown-menu" role="menu">
		                <li><a href="#">个人信息</a></li>
		                <li><a href="#">Another action</a></li>
		                <li><a href="#">Something else here</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">操作</li>
		                <li><a href="#">注 销</a></li>
		                <li><a href="#">One more separated link</a></li>
		              </ul>
		            </li>
		         </ul>
	         <% 
	          	}
	         %>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>