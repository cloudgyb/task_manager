package org.task.ngst.gyb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@Deprecated
public class FileUtil {
	public static void uploadFile(File uploadFile,String outpath,String outfilename){
		File file = new File(outpath,outfilename);
		if(file.exists()){//判断要存入磁盘的文件是否存在
			file.delete();
		}
		InputStream is=null;
		OutputStream os = null;
		try {
			is = new FileInputStream(uploadFile);
			os = new FileOutputStream(new File(outpath,outfilename));
			byte[] buffer = new byte[512];
			int len = 0;
			while((len = is.read(buffer))!=-1){
				os.write(buffer, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.flush();
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void deleteFile(String filename){
		File file = new File(filename);
		if(file.exists()){//判断要存入磁盘的文件是否存在
			file.delete();
		}
	}
}
