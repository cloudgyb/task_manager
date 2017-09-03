------------------------创建数据库及授权用户-----------------------------------
Create user  'ngsttask'@'localhost' identified by 'ngsttask';
Create database task_manager;
Grant all privileges on task_manager.* to ngsttask@'localhost';


--------------------------------创建表--------------------------------------
---用户表-----
-- version :2
CREATE TABLE `users` (
  `uid` int(10) unsigned NOT NULL,
  `uname` varchar(12) NOT NULL,
  `upasswd` varchar(12) NOT NULL DEFAULT '123456',
  `uage` tinyint(2) unsigned DEFAULT NULL,
  `usex` enum('f','m') DEFAULT NULL,
  `uclass` varchar(15) DEFAULT NULL,
  `ugrade` tinyint(3) unsigned NOT NULL,
  `ucategory` tinyint(3) unsigned NOT NULL,
  `uqq` varchar(12) DEFAULT NULL,
  `upasswdques` varchar(50) DEFAULT NULL,
  `upasswdans` varchar(50) DEFAULT NULL,
  `uemail` varchar(50) DEFAULT NULL,
  `utel` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

----任务表------
create table task(
	 tid int unsigned primary key not null auto_increment, 
	 tname varchar(30) not null,
	 tstart date not null,
	 tend date not null,
	 tuid int unsigned not null,
	 tscope tinyint(2) unsigned not null,--对应users表中的ugrade（级别）
	 tdesc text,
	 taffix varchar(20),
	 constraint foreign key(tuid) references users(uid) on delete cascade 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  

-- insert into task values(1,'task1',current_date(),date('2016-11-10'),1415925612,15,'task1','D:/1.docx');
-- select u.uname,t.tname from users u,task t where u.ugrade = t.tscope;

-- alter table task drop foreign key task_ibfk_1;  --删除约束。
-- alter table task add constraint fk_tuid foreign key(tuid) references users(uid); --添加外键约束


----用户任务状态及任务数据存储表--------
-- version 2.0
CREATE TABLE `usertaskstatus` (
  `suid` int(10) unsigned NOT NULL,
  `stid` int(10) unsigned NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `donedate` date DEFAULT NULL,
  `ttext1` text,
  `ttext2` text,
  `staffix` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`suid`,`stid`),
  KEY `fk_stid` (`stid`),
  CONSTRAINT `fk_stid` FOREIGN KEY (`stid`) REFERENCES `task` (`tid`) ON DELETE CASCADE,
  CONSTRAINT `fk_suid` FOREIGN KEY (`suid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- insert into usertaskstatus values(1515925521,1,0,null,'dgfdgfjdsgfh','E:/li.rar');


----成绩表---------
create table grade(
	guid int unsigned not null, 
	gtid int unsigned not null,
	dealuid int unsigned,
	dealdate date,
	score float(5,2) not null,
	constraint pk_ut primary key(guid,gtid),
	constraint fk_guid foreign key(guid) references users(uid) on delete cascade,
	constraint fk_gtid foreign key(gtid) references task(tid) on delete cascade,
	constraint fk_duid foreign key(dealuid) references users(uid) on delete set null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------触发器----------------------------------------	
--为task创建触发器（当有有新任务添加时，自动将数据同步到用户任务状态表（usertaskstatus））
--更改mysql定界符,默认为;
delimiter || 
create trigger _insertafter_on_task
after insert on task
for each row
begin
	declare nodata int default 0;
	declare c int;
	declare cur CURSOR for select uid from users where ugrade=new.tscope;--定义游标
	DECLARE EXIT HANDLER FOR NOT FOUND SET nodata = 1;
	open cur;
	while nodata=0 do
  		fetch cur into c;
  		insert into usertaskstatus(suid,stid) value(c,new.tid);
	end while;
	close cur;
end||
delimiter ;

--为user表创建触发器（当有新用户添加时，自动为用户导入待完成任务列表）
delimiter ||
create trigger _insertafter_on_users
after insert on users
for each row
begin
	declare nodata int default 0;
	declare c int;
	declare cur CURSOR for select tid from task where new.ugrade=tscope;
	declare exit handler for not found set nodata = 1;
	open cur;
	while nodata=0 do
		fetch cur into c;
		insert into usertaskstatus(suid,stid) value(new.uid,c);
	end while;
	close cur;
end||
delimiter ;

-- 为成绩表创建触发器

