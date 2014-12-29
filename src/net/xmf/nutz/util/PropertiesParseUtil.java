package net.xmf.nutz.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.nutz.log.Log;
import org.nutz.log.Logs;

public class PropertiesParseUtil {
	
	private static Log log = Logs.getLog(PropertiesParseUtil.class);
	
	/***
	 * 获取配置的上传图片路径(java类适用)
	 * @return
	 */
	public static String getImagePath(){
		InputStream inputStream = null;
		String spath = "";
		try {
			 inputStream = new BufferedInputStream(new FileInputStream("conf/common.properties"));
			 Properties properties = new Properties();
			 try {
				properties.load(inputStream);
				spath = properties.getProperty("upImagePath");
				if("*".equals(spath)){
					spath = PropertiesParseUtil.class.getResource("/").getPath();
					if(spath.indexOf("classes")>0){
						spath = spath.substring(0, spath.length()-8)+"WEB-INF/tmp/";
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			log.error("解析common.properties异常,文件不存在或者配置错误,请检查!");
			e.printStackTrace();
		}
		return spath;
	}
	
	/***
	 * 获取配置的上传图片路径(请求专用)
	 * @return
	 */
	public static Map<String,Object> getImagePath(HttpServletRequest request){
		InputStream inputStream = null;
		String spath = "";
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			 inputStream = new BufferedInputStream(new FileInputStream(request.getSession().getServletContext().getRealPath("/")+"WEB-INF/classes/common.properties"));
			 Properties properties = new Properties();
			 try {
				properties.load(inputStream);
				spath = properties.getProperty("upImagePath");
				if("*".equals(spath)){
					spath = request.getSession().getServletContext().getRealPath("/");
					if(spath.indexOf("classes")>0){
						/*spath = spath.substring(0, spath.length()-8)+"WEB-INF\tmp";*/
						spath = spath.substring(0, spath.length()-8)+"tmp";
					}else{
						spath = spath+"tmp";
					}
				}
				map.put("path", spath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			log.error("解析common.properties异常,文件不存在或者配置错误,请检查!");
			e.printStackTrace();
		}
		log.debug("上传图片路径为:"+spath);
		return map;
	}
	
	public static void main(String[] args) {
		String spath = PropertiesParseUtil.getImagePath();
		System.out.println("=====spath:"+spath);
	}

}
