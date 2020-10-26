# 高校学习类社团任务管理系统

## 开发技术以及运行环境要求
  - 语言Java1.7+
  - 运行容器Tomcat7+
  - IDE：Eclipse
  - WEB框架Struts2.5+JSP
  - 数据库MySQL5+
  - 前端HTML5+CSS3+JQuery
 
## 运行步骤
 1. 克隆项目到本地，导入项目到Eclipse或者IDEA
 2. 在mysql中创建task_manager数据库，将task_manager.sql导入到task_manager数据库。
 3. 将测试数据test_data.sql导入到数据库
 4. 更改数据库连接配置
     > 在src/org/task/ngst/gyb/conf/jdbc.properties中更改数据库连接配置
 5. 更改并创建文件上传路径
     > 项目某些功能需要上传文件，根据需要可以更改配置路径，在src/org/task/ngst/gyb/conf/upload.properties中
       项目支持Windows和linux环境，所以根据你的环境配置
       ```
        widows_memberUploadRootPath=D:\\taskmanager\\taskfile\\member
        linux_memberUploadRootPath=/taskmanager/taskfile/menber
        windows_adminUploadRootPath=D:\\taskmanager\\taskfile\\admin
        linux_adminUploadRootPath=/taskmanager/taskfile/admin
       ```
      ***注意在你本地需要手动创建这些目录***
  6. 如果你在IDEA中运行项目，你可能还需要配置一个tomcat，具体可以自行百度。
  
  ## 默认账户与密码
   - 社团成员：1415925611 123456
   - 管 理员 : 1415925612 123456
   - 维护人员：1415925613 123456
  
  
  
