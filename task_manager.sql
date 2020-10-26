-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: task_manager
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `guid` int(10) unsigned NOT NULL,
  `gtid` int(10) unsigned NOT NULL,
  `dealuid` int(10) unsigned DEFAULT NULL COMMENT '成绩批改者ID',
  `dealdate` date DEFAULT NULL COMMENT '成绩打分日期',
  `score` float(5,2) NOT NULL COMMENT '分数',
  PRIMARY KEY (`guid`,`gtid`),
  KEY `fk_gtid` (`gtid`),
  KEY `fk_duid` (`dealuid`),
  CONSTRAINT `fk_duid` FOREIGN KEY (`dealuid`) REFERENCES `users` (`uid`) ON DELETE SET NULL,
  CONSTRAINT `fk_gtid` FOREIGN KEY (`gtid`) REFERENCES `task` (`tid`) ON DELETE CASCADE,
  CONSTRAINT `fk_guid` FOREIGN KEY (`guid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1415925611,1,NULL,NULL,0.00),(1415925611,4,1415925612,'2020-10-25',100.00);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tname` varchar(30) NOT NULL COMMENT '任务名称',
  `tstart` date NOT NULL COMMENT '任务开始日期',
  `tend` date NOT NULL COMMENT '任务结束日期',
  `tuid` int(10) unsigned NOT NULL COMMENT '任务发布者ID',
  `tscope` tinyint(2) unsigned NOT NULL COMMENT '该任务试用的范围，例如14，代表14级的任务',
  `tdesc` text COMMENT '任务描述',
  `taffix` varchar(20) DEFAULT NULL COMMENT '任务相关附件的存储路径',
  PRIMARY KEY (`tid`),
  KEY `tuid` (`tuid`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`tuid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='任务表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'任务1','2020-10-25','2020-10-28',1415925611,14,'这是一个任务！',NULL),(2,'学习Python语法','2020-10-25','2020-10-31',1415925612,15,'1、学习Python基础语法\r\n2、完成大作业','1603625163543.zip'),(3,'学习Java语法','2020-10-25','2020-10-27',1415925612,14,'如果我们确实是呢？如果是这样的话，要么我们会死去以让宇宙保持和平，要么我们会活到足够长的时间，人类将散布在星际之间。见鬼，我们甚至可能会发明时间旅行，把事情搞得一团糟。\r\n\r\n考虑到目前可信证据的优势，情况似乎就是这样。这种可能性是真实的吗？答案是，不完全是。','1603625280081.zip'),(4,'学习Java语法','2020-10-25','2020-10-29',1415925612,14,'delimiter || \r\ncreate trigger _insertafter_on_task\r\nafter insert on task\r\nfor each row\r\nbegin\r\n	declare nodata int default 0;\r\n	declare c int;\r\n	declare cur CURSOR for select uid from users where ugrade=new.tscope;-- 定义游标\r\n	DECLARE EXIT HANDLER FOR NOT FOUND SET nodata = 1;\r\n	open cur;\r\n	while nodata=0 do\r\n  		fetch cur into c;\r\n  		insert into usertaskstatus(suid,stid) value(c,new.tid);\r\n	end while;\r\n	close cur;\r\nend||\r\ndelimiter ;\r\n\r\n-- 为user表创建触发器（当有新用户添加时，自动为用户导入待完成任务列表）\r\ndelimiter ||\r\ncreate trigger _insertafter_on_users\r\nafter insert on users\r\nfor each row\r\nbegin\r\n	declare nodata int default 0;\r\n	declare c int;\r\n	declare cur CURSOR for select tid from task where new.ugrade=tscope;\r\n	declare exit handler for not found set nodata = 1;\r\n	open cur;\r\n	while nodata=0 do\r\n		fetch cur into c;\r\n		insert into usertaskstatus(suid,stid) value(new.uid,c);\r\n	end while;\r\n	close cur;\r\nend||\r\ndelimiter ;','1603625508216.zip');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger _insertafter_on_task
    after insert on task
    for each row
begin
    declare nodata int default 0;
    declare c int;
    declare cur CURSOR for select uid from users where ugrade=new.tscope;-- 定义游标
    DECLARE EXIT HANDLER FOR NOT FOUND SET nodata = 1;
    open cur;
    while nodata=0 do
            fetch cur into c;
            insert into usertaskstatus(suid,stid) value(c,new.tid);
        end while;
    close cur;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `uid` int(10) unsigned NOT NULL,
  `uname` varchar(12) NOT NULL,
  `upasswd` varchar(12) NOT NULL DEFAULT '123456',
  `uage` tinyint(2) unsigned DEFAULT NULL,
  `usex` enum('f','m') DEFAULT NULL,
  `uclass` varchar(15) DEFAULT NULL COMMENT '班级，例如cloud1,代表云计算1班',
  `ugrade` tinyint(3) unsigned NOT NULL COMMENT '用户年级，例如14，代表14级用户',
  `ucategory` tinyint(3) unsigned NOT NULL COMMENT '用户类别，0社团成员，1管理员，2维护人员',
  `uqq` varchar(12) DEFAULT NULL,
  `uemail` varchar(50) DEFAULT NULL,
  `utel` varchar(15) DEFAULT NULL,
  `upasswdques` varchar(50) DEFAULT NULL COMMENT '密保问题',
  `upasswdans` varchar(50) DEFAULT NULL COMMENT '密保答案',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1415925611,'gengyuanbo','123456',14,'f','cloud4',14,0,'','','','你的名字','哈哈'),(1415925612,'geng','123456',14,'f','cloud4',14,1,NULL,NULL,NULL,NULL,NULL),(1415925613,'SuperManager','123456',21,'f','cloud1',14,2,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger _insertafter_on_users
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
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `usertaskstatus`
--

DROP TABLE IF EXISTS `usertaskstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertaskstatus` (
  `suid` int(10) unsigned NOT NULL,
  `stid` int(10) unsigned NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '任务状态，0未完成，1已完成',
  `donedate` date DEFAULT NULL COMMENT '完成日期',
  `ttext1` text,
  `staffix` varchar(20) DEFAULT NULL COMMENT '该任务用户上传的附件存储路径',
  `ttext2` text,
  PRIMARY KEY (`suid`,`stid`),
  KEY `fk_stid` (`stid`),
  CONSTRAINT `fk_stid` FOREIGN KEY (`stid`) REFERENCES `task` (`tid`) ON DELETE CASCADE,
  CONSTRAINT `fk_suid` FOREIGN KEY (`suid`) REFERENCES `users` (`uid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务状态表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertaskstatus`
--

LOCK TABLES `usertaskstatus` WRITE;
/*!40000 ALTER TABLE `usertaskstatus` DISABLE KEYS */;
INSERT INTO `usertaskstatus` VALUES (1415925611,1,1,'2020-10-25','asdasdsadsad',NULL,'dasdasdsad'),(1415925611,4,1,'2020-10-25','发生的范德萨发斯蒂芬',NULL,'范德萨范德萨发的'),(1415925612,4,0,NULL,NULL,NULL,NULL),(1415925613,1,0,NULL,NULL,NULL,NULL),(1415925613,3,0,NULL,NULL,NULL,NULL),(1415925613,4,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usertaskstatus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-26 16:40:32
