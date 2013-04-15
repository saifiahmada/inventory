-- MySQL dump 10.13  Distrib 5.5.28, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: temppro
-- ------------------------------------------------------
-- Server version	5.5.28-0ubuntu0.12.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `temppro`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `temppro` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `temppro`;

--
-- Table structure for table `trio_mstaccessrole`
--

DROP TABLE IF EXISTS `trio_mstaccessrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trio_mstaccessrole` (
  `VMENUID` varchar(20) NOT NULL,
  `VROLEID` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VSTAT` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`VMENUID`,`VROLEID`),
  KEY `FK24D538EDCC051BD5` (`VROLEID`),
  KEY `FK24D538EDC2EEAF67` (`VMENUID`),
  CONSTRAINT `FK24D538EDC2EEAF67` FOREIGN KEY (`VMENUID`) REFERENCES `trio_mstmenu` (`VMENUID`),
  CONSTRAINT `FK24D538EDCC051BD5` FOREIGN KEY (`VROLEID`) REFERENCES `trio_mstrole` (`VROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trio_mstaccessrole`
--

LOCK TABLES `trio_mstaccessrole` WRITE;
/*!40000 ALTER TABLE `trio_mstaccessrole` DISABLE KEYS */;
INSERT INTO `trio_mstaccessrole` (`VMENUID`, `VROLEID`, `DCREA`, `DMODI`, `VCREABY`, `VMODIBY`, `VSTAT`) VALUES ('T10GLADM001','RO_ADMIN','2013-02-21 08:53:34',NULL,'saifi',NULL,'A'),('T10GLADM002','RO_ADMIN','2013-02-21 08:53:46',NULL,'saifi',NULL,'A'),('T10GLADM003','RO_ADMIN','2013-02-21 08:53:56',NULL,'saifi',NULL,'A'),('T10GLADM004','RO_ADMIN','2013-02-21 08:54:08',NULL,'saifi',NULL,'A'),('T10GLADM005','RO_ADMIN','2013-02-21 08:54:18',NULL,'saifi',NULL,'A'),('T10GLDSG001','RO_ADMIN','2013-02-13 14:25:31',NULL,'saifi',NULL,'A'),('T10GLLAP001','RO_ACC','2013-02-20 10:15:01','2013-02-20 10:15:01','saifi','saifi','A'),('T10GLLAP001','RO_ADMIN','2013-02-13 14:29:28',NULL,'saifi',NULL,'A'),('T10GLLAP002','RO_ADMIN','2013-02-13 14:29:40',NULL,'saifi',NULL,'A'),('T10GLMST001','RO_ADMIN','2013-02-12 23:45:50',NULL,'saifi',NULL,'A'),('T10GLMST002','RO_ADMIN','2013-02-21 09:03:58',NULL,'saifi',NULL,'A'),('T10GLMST003','RO_ADMIN','2013-02-21 09:04:22',NULL,'saifi',NULL,'A'),('T10GLMST006','RO_ACC','2013-02-20 10:15:32','2013-02-20 10:15:32','saifi','saifi','A'),('T10GLTRN001','RO_ADMIN','2013-02-13 14:30:14',NULL,'saifi',NULL,'A'),('T10GLUTL001','RO_ADMIN','2013-02-19 09:29:13','2013-02-19 09:29:13','saifi','saifi','A'),('T10GLUTL002','RO_ADMIN','2013-02-20 08:34:56',NULL,'saifi',NULL,'A');
/*!40000 ALTER TABLE `trio_mstaccessrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trio_mstcabang`
--

DROP TABLE IF EXISTS `trio_mstcabang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trio_mstcabang` (
  `KD_PRS` varchar(3) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `ALM_PRS` varchar(40) DEFAULT NULL,
  `FAX` varchar(11) DEFAULT NULL,
  `KD_PRS2` varchar(3) DEFAULT NULL,
  `NM_PRS` varchar(35) DEFAULT NULL,
  `TELP1` varchar(11) DEFAULT NULL,
  `TELP2` varchar(11) DEFAULT NULL,
  `TELP3` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`KD_PRS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trio_mstcabang`
--

LOCK TABLES `trio_mstcabang` WRITE;
/*!40000 ALTER TABLE `trio_mstcabang` DISABLE KEYS */;
INSERT INTO `trio_mstcabang` (`KD_PRS`, `DCREA`, `DMODI`, `VCREABY`, `VMODIBY`, `ALM_PRS`, `FAX`, `KD_PRS2`, `NM_PRS`, `TELP1`, `TELP2`, `TELP3`) VALUES ('CH7','2013-02-20 10:18:38',NULL,'saifi',NULL,'JL. PERINTIS KEMERDEKAAN','123 345',NULL,'CV. TRIO MOTOR PERINTIS','890',NULL,NULL),('CH9','2013-02-19 16:13:29',NULL,'saifi',NULL,'JL. PELITA RAYA NO.62 RT.16 BUNTOK','052522537',NULL,'PT TRIO MOTOR BUNTOK 2013','052522537',NULL,NULL);
/*!40000 ALTER TABLE `trio_mstcabang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trio_mstmenu`
--

DROP TABLE IF EXISTS `trio_mstmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trio_mstmenu` (
  `VMENUID` varchar(11) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `NORDERER` int(11) DEFAULT NULL,
  `VIMAGE` varchar(30) DEFAULT NULL,
  `VLOCATION` varchar(30) DEFAULT NULL,
  `VPARENT` varchar(6) DEFAULT NULL,
  `VTITLE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`VMENUID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trio_mstmenu`
--

LOCK TABLES `trio_mstmenu` WRITE;
/*!40000 ALTER TABLE `trio_mstmenu` DISABLE KEYS */;
INSERT INTO `trio_mstmenu` (`VMENUID`, `DCREA`, `DMODI`, `VCREABY`, `VMODIBY`, `NORDERER`, `VIMAGE`, `VLOCATION`, `VPARENT`, `VTITLE`) VALUES ('T10GLADM001','2013-02-21 08:49:06',NULL,'saifi',NULL,1,'/image/favicon.ico','/mst/mstMenu.zul','M6ADM','Master Menu'),('T10GLADM002','2013-02-21 08:49:30',NULL,'saifi',NULL,2,'/image/favicon.ico','/mst/mstUser.zul','M6ADM','Master User'),('T10GLADM003','2013-02-21 08:49:52',NULL,'saifi',NULL,3,'/image/favicon.ico','/mst/mstRole.zul','M6ADM','Master Role'),('T10GLADM004','2013-02-21 08:50:40',NULL,'saifi',NULL,4,'/image/favicon.ico','/mst/mstAccessRole.zul','M6ADM','Master Access Role'),('T10GLADM005','2013-02-21 08:51:18',NULL,'saifi',NULL,5,'/image/favicon.ico','/mst/mstUserRole.zul','M6ADM','Master User Role'),('T10GLDSG001','2013-02-12 18:21:05','2013-02-12 18:21:05','saifi','saifi',1,'/image/favicon.ico','dsgLaporan.zul','M3DSG','Design Laporan'),('T10GLDSG002','2013-02-12 20:56:44',NULL,'saifi',NULL,1,'/image/favicon,ico','dsgNeraca','M3DSG','Design Neraca'),('T10GLDSG003','2013-02-12 21:05:35',NULL,'saifi',NULL,1,'/image/favicon.ico','dsgNeraacaLR.zul','M3DSG','Neraca LR'),('T10GLLAP001','2013-02-12 18:12:49',NULL,'saifi',NULL,1,'/image/favicon.ico','laporan.zul','M4LAP','Laporan'),('T10GLLAP002','2013-02-12 18:24:11',NULL,'saifi',NULL,1,'/image/favicon.ico','lap2.zul','M4LAP','Laporan 2'),('T10GLMST001','2013-02-21 08:57:27','2013-02-21 08:57:27','saifi','saifi',1,'/image/favicon.ico','/mst/mstCabang.zul','M1MST','Master Cabang'),('T10GLMST002','2013-02-21 09:01:56','2013-02-21 09:01:56','saifi','saifi',2,'/image/favicon.ico','/mst/mstPerkiraan.zul','M1MST','Master Perkiraan'),('T10GLMST003','2013-02-21 09:02:22','2013-02-21 09:02:22','saifi','saifi',3,'/image/favicon.ico','/mst/mstAcc3.zul','M1MST','Master Acc 3'),('T10GLMST004','2013-02-21 09:02:42','2013-02-21 09:02:42','saifi','saifi',4,'/image/favicon.ico','/mst/mstAcc4.zul','M1MST','Master Acc 4'),('T10GLMST005','2013-02-21 09:03:08','2013-02-21 09:03:08','saifi','saifi',5,'/image/favicon.ico','/mst/mstAcc5.zul','M1MST','Master Acc 5'),('T10GLMST006','2013-02-21 09:03:27','2013-02-21 09:03:27','saifi','saifi',6,'/image/favicon.ico','/mst/mstAcc6.zul','M1MST','Master Acc 6'),('T10GLMST007','2013-02-15 11:37:58','2013-02-15 11:37:59','saifi','saifi',7,'/image/favicon.ico','/mst/mstPerkiraan.zul','M1MST','Master Perkiraan'),('T10GLTRN001','2013-02-12 17:55:03',NULL,'saifi',NULL,1,'/image/favicon.ico','trnCabang.zul','M2TRN','Transaksi'),('T10GLUTL001','2013-02-21 10:19:56','2013-02-21 10:19:56','saifi','saifi',1,'/image/favicon.ico','ulutily.zul','M5UTL','Koneksi DB Cabang 1'),('T10GLUTL002','2013-02-21 10:20:17','2013-02-21 10:20:17','saifi','saifi',2,'/image/favicon.ico','/mst/test.zul','M5UTL','Koneksi DB Cabang 2'),('T10GLUTL003','2013-02-20 09:52:48','2013-02-20 09:52:48','saifi','saifi',3,'/image/favicon','utility3.zul','M5UTL','Utility 3');
/*!40000 ALTER TABLE `trio_mstmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trio_mstrole`
--

DROP TABLE IF EXISTS `trio_mstrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trio_mstrole` (
  `VROLEID` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VROLENAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trio_mstrole`
--

LOCK TABLES `trio_mstrole` WRITE;
/*!40000 ALTER TABLE `trio_mstrole` DISABLE KEYS */;
INSERT INTO `trio_mstrole` (`VROLEID`, `DCREA`, `DMODI`, `VCREABY`, `VMODIBY`, `VROLENAME`) VALUES ('RO_ACC','2013-02-16 09:39:23',NULL,'saifi',NULL,'ROLE ACC'),('RO_ADMIN','2013-02-12 22:10:51',NULL,'saifi',NULL,'ROLE  PERTAMA'),('RO_CONFIG','2013-02-20 09:55:14',NULL,'saifi',NULL,'ROLE CONFIG'),('RO_MANAGER','2013-02-20 10:12:05','2013-02-20 10:12:05','saifi','saifi','ROLE MANAGER'),('RO_NEW','2013-02-20 10:12:03','2013-02-20 10:12:03','saifi','saifi','ROLE NEW');
/*!40000 ALTER TABLE `trio_mstrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trio_mstuser`
--

DROP TABLE IF EXISTS `trio_mstuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trio_mstuser` (
  `VUSERNAME` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VPASSWORD` varchar(64) NOT NULL,
  `VSTAT` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`VUSERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trio_mstuser`
--

LOCK TABLES `trio_mstuser` WRITE;
/*!40000 ALTER TABLE `trio_mstuser` DISABLE KEYS */;
INSERT INTO `trio_mstuser` (`VUSERNAME`, `DCREA`, `DMODI`, `VCREABY`, `VMODIBY`, `VPASSWORD`, `VSTAT`) VALUES ('arya','2013-02-20 09:31:46',NULL,'saifi',NULL,'5f4dcc3b5aa765d61d8327deb882cf99','A'),('iyar','2013-02-20 09:41:33','2013-02-20 09:41:33','saifi','saifi','5a22e6c339c96c9c0513a46e44c39683','A'),('manager','2013-02-18 22:48:38',NULL,'saifi',NULL,'1d0258c2440a8d19e716292b231e3190','A'),('philip','2013-02-20 09:44:56','2013-02-20 09:44:56','saifi','saifi','5a22e6c339c96c9c0513a46e44c39683','A'),('rahma','2013-02-16 11:35:32',NULL,'saifi',NULL,'b007b7d6520a7b3dcccd2a1ec2891009','A'),('raja','2013-02-20 09:44:51','2013-02-20 09:44:51','saifi','saifi','c3e617dfdd863651055e3e93a0216a9b','A'),('saifi','2013-02-12 11:19:06','2013-02-12 11:19:06','saifi','saifi','815775af77fe36aea6236f9eedeaee32','A'),('surya','2013-02-21 08:15:59',NULL,'saifi',NULL,'5f4dcc3b5aa765d61d8327deb882cf99','A');
/*!40000 ALTER TABLE `trio_mstuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trio_mstuserrole`
--

DROP TABLE IF EXISTS `trio_mstuserrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trio_mstuserrole` (
  `VROLEID` varchar(20) NOT NULL,
  `VUSERNAME` varchar(20) NOT NULL,
  `DCREA` datetime DEFAULT NULL,
  `DMODI` datetime DEFAULT NULL,
  `VCREABY` varchar(20) DEFAULT NULL,
  `VMODIBY` varchar(20) DEFAULT NULL,
  `VSTAT` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`VROLEID`,`VUSERNAME`),
  KEY `FK6B9E1094E8C4A26F` (`VUSERNAME`),
  KEY `FK6B9E1094CC051BD5` (`VROLEID`),
  CONSTRAINT `FK6B9E1094CC051BD5` FOREIGN KEY (`VROLEID`) REFERENCES `trio_mstrole` (`VROLEID`),
  CONSTRAINT `FK6B9E1094E8C4A26F` FOREIGN KEY (`VUSERNAME`) REFERENCES `trio_mstuser` (`VUSERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trio_mstuserrole`
--

LOCK TABLES `trio_mstuserrole` WRITE;
/*!40000 ALTER TABLE `trio_mstuserrole` DISABLE KEYS */;
INSERT INTO `trio_mstuserrole` (`VROLEID`, `VUSERNAME`, `DCREA`, `DMODI`, `VCREABY`, `VMODIBY`, `VSTAT`) VALUES ('RO_ACC','rahma','2013-02-19 10:04:10',NULL,'saifi',NULL,'A'),('RO_ADMIN','arya','2013-02-20 10:17:48','2013-02-20 10:17:48','saifi','saifi','A'),('RO_ADMIN','saifi','2013-02-12 23:10:53',NULL,'saifi',NULL,'A');
/*!40000 ALTER TABLE `trio_mstuserrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-02-21 17:04:38
