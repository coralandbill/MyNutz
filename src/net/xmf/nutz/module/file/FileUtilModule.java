package net.xmf.nutz.module.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.xmf.nutz.filter.UserLoginFilter;
import net.xmf.nutz.util.PropertiesParseUtil;
import net.xmf.nutz.util.UploadFileUtil;

import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.FieldMeta;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;

@At("/file")
@Filters({@By(type=UserLoginFilter.class)})
public class FileUtilModule{
	
	@At("/uploadFile")
	@Ok("jsp:file.uploadFile")
	public void toUploadFile(){
		
	}
	
	@At("/doUpload")
	@Ok("jsp:file.uploadFile")
	//缓存位置,文件上限大小,编码,最大文件个数 直接标注稍后使用json解析properties配置
	@AdaptBy(type=UploadAdaptor.class,args={"${app.root}/WEB-INF/tmp","8192", "UTF-8", "10" })
	public void doUploadFile(@Param("file") TempFile file, HttpServletRequest request,
			ServletContext context) {
		File f = file.getFile();                       // 这个是保存的临时文件
	    FieldMeta meta = file.getMeta();               // 这个原本的文件信息
	    String oldName = meta.getFileLocalName();    // 这个时原本的文件名称
	    Map map = PropertiesParseUtil.getImagePath(request);
	    UploadFileUtil.CopyFileByFile(f, map.get("path").toString()+"/"+oldName);
	    
	    
	}
	
}
