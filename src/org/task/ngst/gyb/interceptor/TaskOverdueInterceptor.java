package org.task.ngst.gyb.interceptor;

import java.util.Date;
import java.util.Map;

import org.task.ngst.gyb.entity.Task;
import org.task.ngst.gyb.service.TaskDaoService;
import org.task.ngst.gyb.service.imple.TaskDaoServiceImple;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TaskOverdueInterceptor extends AbstractInterceptor{
	
	/**
	 * 对用户做、修改或删除过期的任务进行拦截
	 */
	private static final long serialVersionUID = 29435438602052235L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		String[] tid = (String[]) parameters.get("tid");//获取action链接后的参数
		
		TaskDaoService tds = new TaskDaoServiceImple();
		Task task = tds.getTaskById(Integer.parseInt(tid[0]));
		if(task.getTend().getTime()<(new Date()).getTime()){//任务是否过期
			return "taskoverdue";
		}
		return invocation.invoke();
	}
	
}
