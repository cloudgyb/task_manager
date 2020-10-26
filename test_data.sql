-- users测试数据
insert into task_manager.users (uid, uname, upasswd, uage, usex, uclass, ugrade, ucategory, uqq, uemail, utel, upasswdques, upasswdans) values (1415925611, 'gengyuanbo', 123456, 14, 'f', 'cloud4', 14, 0, '', '', '', '你的名字', '哈哈');
insert into task_manager.users (uid, uname, upasswd, uage, usex, uclass, ugrade, ucategory, uqq, uemail, utel, upasswdques, upasswdans) values (1415925612, 'geng', 123456, 14, 'f', 'cloud4', 14, 1, null, null, null, null, null);
insert into task_manager.users (uid, uname, upasswd, uage, usex, uclass, ugrade, ucategory, uqq, uemail, utel, upasswdques, upasswdans) values (1415925613, 'SuperManager', 123456, 21, 'f', 'cloud1', 14, 2, null, null, null, null, null);

-- task
insert into task_manager.task (tid, tname, tstart, tend, tuid, tscope, tdesc, taffix) values (1, '任务1', '2020-10-25', '2020-10-28', 1415925611, 14, '这是一个任务！', null);
insert into task_manager.task (tid, tname, tstart, tend, tuid, tscope, tdesc, taffix) values (2, '学习Python语法', '2020-10-25', '2020-10-31', 1415925612, 15, '1、学习Python基础语法2、完成大作业', '1603625163543.zip');
insert into task_manager.task (tid, tname, tstart, tend, tuid, tscope, tdesc, taffix) values (3, '学习Java语法', '2020-10-25', '2020-10-27', 1415925612, 14, '如果我们确实是呢？如果是这样的话，要么我们会死去以让宇宙保持和平，要么我们会活到足够长的时间，人类将散布在星际之间。见鬼，我们甚至可能会发明时间旅行，把事情搞得一团糟。考虑到目前可信证据的优势，情况似乎就是这样。这种可能性是真实的吗？答案是，不完全是。', '1603625280081.zip');
insert into task_manager.task (tid, tname, tstart, tend, tuid, tscope, tdesc, taffix) values (4, '学习Java语法', '2020-10-25', '2020-10-29', 1415925612, 14, '测试测试测试测试测试。', '1603625508216.zip');


-- grade
insert into task_manager.grade (guid, gtid, dealuid, dealdate, score) values (1415925611, 1, null, null, 0);
insert into task_manager.grade (guid, gtid, dealuid, dealdate, score) values (1415925611, 4, 1415925612, '2020-10-25', 100);


-- usertaskstatus
insert into task_manager.usertaskstatus (suid, stid, status, donedate, ttext1, staffix, ttext2) values (1415925611, 1, 1, '2020-10-25', 'asdasdsadsad', null, 'dasdasdsad');
insert into task_manager.usertaskstatus (suid, stid, status, donedate, ttext1, staffix, ttext2) values (1415925611, 4, 1, '2020-10-25', '发生的范德萨发斯蒂芬', null, '范德萨范德萨发的');
insert into task_manager.usertaskstatus (suid, stid, status, donedate, ttext1, staffix, ttext2) values (1415925612, 4, 0, null, null, null, null);
insert into task_manager.usertaskstatus (suid, stid, status, donedate, ttext1, staffix, ttext2) values (1415925613, 1, 0, null, null, null, null);
insert into task_manager.usertaskstatus (suid, stid, status, donedate, ttext1, staffix, ttext2) values (1415925613, 3, 0, null, null, null, null);
insert into task_manager.usertaskstatus (suid, stid, status, donedate, ttext1, staffix, ttext2) values (1415925613, 4, 0, null, null, null, null);
