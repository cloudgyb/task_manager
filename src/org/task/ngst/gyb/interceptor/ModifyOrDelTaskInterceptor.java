package org.task.ngst.gyb.interceptor;

import java.util.Map;

import org.task.ngst.gyb.entity.Grade;
import org.task.ngst.gyb.service.GradeDaoService;
import org.task.ngst.gyb.service.imple.GradeDaoServiceImple;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ModifyOrDelTaskInterceptor extends AbstractInterceptor{

	/**
	 * 对修改或删除已评出成绩任务进行拦截
	 */
	private static final long serialVersionUID = -7210050036227886996L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> parameter = invocation.getInvocationContext().getParameters();
		//获取Action链接后参数
		String[] uid = (String[])parameter.get("uid");
		String[] tid = (String[])parameter.get("tid");
		System.out.println(uid[0]+"------"+tid[0]);
		GradeDaoService gds = new GradeDaoServiceImple();
		Grade g = gds.getGradeByGuidAndGtid(Integer.parseInt(uid[0]), Integer.parseInt(tid[0]));
		if(g!=null&&g.getDealUid()==0){//如果成绩为空，则此任务还没有评成绩，可以进行修改或删除
			return invocation.invoke();
		}
		return "notallow";
	}
	
}
