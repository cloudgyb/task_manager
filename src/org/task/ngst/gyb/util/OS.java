package org.task.ngst.gyb.util;

public class OS {
	public static final String OS_WINDOWS = "Windows";
	public static final String OS_LINUX = "Linux";
	public static final String OS_MAC = "mac";
	
	public static String getOSName(){
		String osName = System.getProperty("os.name");
		if(osName.indexOf("Windows")!=-1){
			return OS_WINDOWS;
		}else if(osName.indexOf("Linux")!=-1){
			return OS_LINUX;
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(getOSName());
	}
}
