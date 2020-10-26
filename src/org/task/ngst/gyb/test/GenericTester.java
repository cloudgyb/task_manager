package org.task.ngst.gyb.test;

import java.util.Date;

import org.junit.Test;

public class GenericTester {
///////////////////////////////default//////////////////////////////
	@Test
	public void TestDateToString(){
		Date d = new Date();
		System.out.println(d.getTime());
	}
}
