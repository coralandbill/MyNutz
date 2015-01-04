package net.xmf.nutz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class UploadFileUtil {

	/***
	 * 搬运文件至指定位置
	 * @param file 需要搬运的文件对象
	 * @param path 需要搬运到的文件路径
	 */
	public static void CopyFileByFile(File file,String path){
		FileInputStream inputStream = null;
	    FileOutputStream outputStream = null;
	    FileChannel incChannel = null;
	    FileChannel outChannel = null;
		try {
			inputStream = new FileInputStream(file);
			File file2 = new File(path);
			outputStream = new FileOutputStream(file2);
			incChannel = inputStream.getChannel();
			outChannel = outputStream.getChannel();
		    try {
		    	incChannel.transferTo(0, incChannel.size(), outChannel);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
				outputStream.close();
				incChannel.close();
				outChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
