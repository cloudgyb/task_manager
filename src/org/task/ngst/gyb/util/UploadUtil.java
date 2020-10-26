package org.task.ngst.gyb.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class UploadUtil {
	public static String memberUploadRootPath = null;
	public static String adminUploadRootPath = null;
	static {
		Properties prop = new Properties();
		InputStream is = null;
		is = UploadUtil.class.getResourceAsStream("/org/task/ngst/gyb/conf/upload.properties"); 
		try {
			prop.load(is);
			if(OS.getOSName().equalsIgnoreCase(OS.OS_WINDOWS)) {
				memberUploadRootPath = prop.getProperty("widows_memberUploadRootPath");
				adminUploadRootPath = prop.getProperty("windows_adminUploadRootPath");
			}else if(OS.getOSName().equalsIgnoreCase(OS.OS_LINUX)){
				memberUploadRootPath = prop.getProperty("linux_memberUploadRootPath");
				adminUploadRootPath = prop.getProperty("linux_adminUploadRootPath");
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		File memberpath = new File(memberUploadRootPath);
		File adminpath = new File(adminUploadRootPath);
		if(!memberpath.exists()){
			memberpath.mkdirs();
		}
		if(!adminpath.exists()){
			adminpath.mkdirs();
		}
	}
	
	public static void copyFile(InputStream in,OutputStream out){
		BufferedInputStream bis = new BufferedInputStream(in);
		int n = 0; byte[] b = new byte[512];
		try {
			while((n = bis.read(b))!=-1){
				out.write(b, 0, n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				out.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void copyFile(String srcfile,String dstfile){
		File srcf = new File(srcfile);
		File dstf = new File(dstfile);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(srcf);
			fos = new FileOutputStream(dstf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		copyFile(fis, fos);
	}
	public static void copyFile(File srcfile,File dstfile){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(srcfile);
			fos = new FileOutputStream(dstfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		copyFile(fis, fos);
	}
	public static void memberUploadFile(File srcFile,String dstFileName){
		File dstF = new File(memberUploadRootPath,dstFileName);
		copyFile(srcFile,dstF);
	}
	public static void adminUploadFile(File srcFile,String dstFileName){
		File dstF = new File(adminUploadRootPath,dstFileName);
		copyFile(srcFile,dstF);
	}
	public static void adminDeleteOldFile(String fileName){
		File file = new File(adminUploadRootPath,fileName);
		deleteFile(file);
	}
	public static void memberDeleteOldFile(String fileName){
		File file = new File(memberUploadRootPath,fileName);
		deleteFile(file);
	}
	
	public static void deleteFile(File file){
		if(file.exists()){
			file.delete();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(memberUploadRootPath);
		System.out.println(adminUploadRootPath);
	}
}
