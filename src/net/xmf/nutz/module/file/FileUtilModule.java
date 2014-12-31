package net.xmf.nutz.module.file;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import net.xmf.nutz.bean.HyUser;
import net.xmf.nutz.bean.UploadImage;
import net.xmf.nutz.filter.UserLoginFilter;
import net.xmf.nutz.module.CommonModule;
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
public class FileUtilModule extends CommonModule{
	
	@At("/uploadFile")
	@Ok("jsp:file.uploadFile")
	public void toUploadFile(@Param("map") Map<String, Object> map,HttpServletRequest request){
		List <UploadImage> upList = dao.query(UploadImage.class, null);
		if(map!=null){
			System.out.println("========map:"+map.get("msg").toString());
		}
		if(upList!=null){
			request.setAttribute("upList", upList);
		}
	}
	
	@At("/doUpload")
	//@Ok("jsp:file.uploadFile")
	@Ok("redirect:/file/uploadFile?map=${obj}")
	//缓存位置,文件上限大小,编码,最大文件个数 直接标注稍后使用json解析properties配置
	@AdaptBy(type=UploadAdaptor.class,args={"${app.root}/WEB-INF/tmp","8192", "UTF-8", "10" })
	public Map<String,Object> doUploadFile(@Param("file") TempFile file, HttpServletRequest request,
			ServletContext context) {
		Map<String,Object> map = new HashMap<String,Object>();
		/*File f = file.getFile();                       // 这个是保存的临时文件
	    FieldMeta meta = file.getMeta();               // 这个原本的文件信息
	    String oldName = meta.getFileLocalName();    // 这个时原本的文件名称
	    Map map = PropertiesParseUtil.getImagePath(request);
	    UploadFileUtil.CopyFileByFile(f, map.get("path").toString()+"/"+oldName);
	    
	    HyUser hyUser = (HyUser)request.getSession().getAttribute(HyUser.SESSION_NAME);
	    
	    UploadImage uploadImage = new UploadImage();
	    uploadImage.setImageDescri("图片说明");
	    uploadImage.setImageName(oldName);
	    uploadImage.setImageTitle(oldName);
	    uploadImage.setImagePath(map.get("path").toString()+"/"+oldName);
	    uploadImage.setUploadDate(new Date());
	    uploadImage.setUserId(hyUser.getId());
	    dao.insert(uploadImage);*/
	    map.put("msg", "上传成功!");
		return map;
	}
	
}
