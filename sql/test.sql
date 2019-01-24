
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_transfer_staff
-- ----------------------------
DROP TABLE IF EXISTS `admin_transfer_staff`;
CREATE TABLE `admin_transfer_staff` (
  `id` varchar(20) NOT NULL,
  `department_id` varchar(20) DEFAULT NULL,
  `object_department_id` varchar(20) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  `apply_staff_id` varchar(20) DEFAULT NULL,
  `object_staff_id` varchar(20) DEFAULT NULL,
  `transfer_type` varchar(20) DEFAULT NULL,
  `msg` varchar(500) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_transfer_staff
-- ----------------------------
INSERT INTO `admin_transfer_staff` VALUES ('1', 'DEP-1001', 'DEP-1006', 'nncq0003', 'nncq0002', 'nncq0003', 'in', '789', '同意');
INSERT INTO `admin_transfer_staff` VALUES ('1542076922554', 'DEP-1001', 'DEP-1006', 'nncq0008', 'nncq0002', 'nncq0003', 'in', '123', '同意');

-- ----------------------------
-- Table structure for admin_transfer_staff_copy1
-- ----------------------------
DROP TABLE IF EXISTS `admin_transfer_staff_copy1`;
CREATE TABLE `admin_transfer_staff_copy1` (
  `id` varchar(20) NOT NULL,
  `department_id` varchar(20) DEFAULT NULL,
  `object_department_id` varchar(20) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  `apply_staff_id` varchar(20) DEFAULT NULL,
  `object_staff_id` varchar(20) DEFAULT NULL,
  `transfer_type` varchar(20) DEFAULT NULL,
  `msg` varchar(500) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_transfer_staff_copy1
-- ----------------------------
INSERT INTO `admin_transfer_staff_copy1` VALUES ('1', 'DEP-1001', 'DEP-1006', 'nncq0003', 'nncq0002', 'nncq0003', 'in', '789', '同意');
INSERT INTO `admin_transfer_staff_copy1` VALUES ('1542076922554', 'DEP-1001', 'DEP-1006', 'nncq0008', 'nncq0002', 'nncq0003', 'in', '123', '同意');

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `apply_id` varchar(20) NOT NULL,
  `apply_name` varchar(255) DEFAULT NULL,
  `apply_type` varchar(20) DEFAULT NULL,
  `parent_id` varchar(20) DEFAULT NULL,
  `apply_staff_id` varchar(20) DEFAULT NULL,
  `check_staff_id` varchar(20) DEFAULT NULL,
  `apply_time` varchar(50) DEFAULT NULL,
  `check_time` varchar(50) DEFAULT NULL,
  `check_state` varchar(50) DEFAULT NULL,
  `check_msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`apply_id`),
  KEY `apply_staff_id` (`apply_staff_id`) USING BTREE,
  CONSTRAINT `apply_ibfk_1` FOREIGN KEY (`apply_staff_id`) REFERENCES `staff` (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of apply
-- ----------------------------
INSERT INTO `apply` VALUES ('APPLY-1001', '请假申请', 'staff_leave_apply', 'Leave-1001', 'nncq0000', 'nncq0001', '2018-11-02 09:20:32', '2018-11-08 14:24:30', '已通过', '给');
INSERT INTO `apply` VALUES ('APPLY-1002', '出差申请', 'staff_evection_apply', 'Evection-1001', 'nncq0000', 'nncq0001', '2018-11-02 09:21:20', '2018-11-08 14:27:29', '不通过', '情况不足');
INSERT INTO `apply` VALUES ('APPLY-1003', '调动申请', 'staff_transfer_apply', 'Transfer-1001', 'nncq0000', 'nncq0002', '2018-11-02 09:26:37', '2018-11-07 15:47:25', '已通过', '789');
INSERT INTO `apply` VALUES ('APPLY-1004', '加班申请', 'staff_overtime_apply', 'OverTime-1001', 'nncq0000', 'nncq0001', '2018-11-02 09:27:17', '2018-11-08 14:28:23', '不通过', ' 阿萨上单多阿萨斯多啊啊飒飒');
INSERT INTO `apply` VALUES ('APPLY-1005', '报销申请', 'staff_expense_apply', 'Expense-1001', 'nncq0000', 'nncq0001', '2018-11-02 09:28:20', '2018-11-08 14:30:17', '已通过', '测试');
INSERT INTO `apply` VALUES ('APPLY-1006', '离职申请', 'staff_quit_apply', 'Quit-1001', 'nncq0000', 'nncq0002', '2018-11-02 09:28:44', '2018-11-05 13:31:16', '已通过', '456');
INSERT INTO `apply` VALUES ('APPLY-1007', null, 'recruit', 'REC-1001', 'nncq0002', null, '2018-11-02 15:45:00', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1008', null, 'recruit', 'REC-1002', 'nncq0001', null, '2018-11-02 15:46:42', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1009', null, 'recruit', 'REC-1003', 'nncq0001', null, '2018-11-02 15:50:29', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1010', null, 'recruit', 'REC-1004', 'nncq0003', null, '2018-11-02 15:52:01', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1011', null, 'recruit', 'REC-1005', 'nncq0003', null, '2018-11-02 15:52:05', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1012', null, 'recruit', 'REC-1006', 'nncq0003', 'nncq0002', '2018-11-02 15:52:30', '2018-11-13 10:55:45', '已通过', '信息完整同意通过');
INSERT INTO `apply` VALUES ('APPLY-1013', null, 'recruit', 'REC-1007', 'nncq0001', null, '2018-11-02 15:59:00', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1014', '请假申请', 'staff_leave_apply', 'Leave-1002', 'nncq0002', null, '2018-11-05 16:19:25', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1015', '调动申请', 'staff_transfer_apply', 'Transfer-1002', 'nncq0003', 'nncq0002', '2018-11-07 15:48:32', '2018-11-07 15:49:57', '已通过', '789');
INSERT INTO `apply` VALUES ('APPLY-1016', '调动申请', 'staff_transfer_apply', 'Transfer-1003', 'nncq0003', null, '2018-11-08 14:09:40', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1017', '请假申请', 'staff_leave_apply', 'Leave-1003', 'nncq0001', null, '2018-11-08 14:44:09', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1018', '出差申请', 'staff_evection_apply', 'Evection-1002', 'nncq0001', null, '2018-11-08 14:44:51', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1019', '调动申请', 'staff_transfer_apply', 'Transfer-1004', 'nncq0001', null, '2018-11-08 14:47:43', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1020', '加班申请', 'staff_overtime_apply', 'OverTime-1002', 'nncq0001', null, '2018-11-08 14:48:07', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1021', '报销申请', 'staff_expense_apply', 'Expense-1002', 'nncq0001', null, '2018-11-08 14:48:26', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1022', '离职申请', 'staff_quit_apply', 'Quit-1002', 'nncq0001', null, '2018-11-08 14:48:45', null, '待审核', null);
INSERT INTO `apply` VALUES ('APPLY-1023', '调动申请', 'staff_transfer_apply', 'Transfer-1005', 'nncq0008', null, '2018-11-13 10:42:22', null, '待审核', null);

-- ----------------------------
-- Table structure for check_detailed
-- ----------------------------
DROP TABLE IF EXISTS `check_detailed`;
CREATE TABLE `check_detailed` (
  `check_detailed_id` int(11) NOT NULL AUTO_INCREMENT,
  `check_detailed_day` varchar(20) DEFAULT NULL,
  `check_detailed__time1` varchar(20) DEFAULT NULL,
  `check_detailed__time2` varchar(20) DEFAULT NULL,
  `check_detailed__time3` varchar(20) DEFAULT NULL,
  `check_detailed__time4` varchar(20) DEFAULT NULL,
  `check_detailed__time5` varchar(20) DEFAULT NULL,
  `check_detailed__time6` varchar(20) DEFAULT NULL,
  `check_detailed_state` varchar(50) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`check_detailed_id`) USING BTREE,
  KEY `fk_check_detailed_staff_id` (`staff_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of check_detailed
-- ----------------------------
INSERT INTO `check_detailed` VALUES ('1', '2018-10-31', '08:22:43', '12:11:00', '14:11:00', '17:31:00', '', '', '正常', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('2', '2018-11-01', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '早退', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('3', '2018-11-02', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '早退', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('4', '2018-11-04', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('5', '2018-11-05', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '正常', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('6', '2018-10-28', '08:22:43', '12:11:00', '14:11:00', '17:31:00', '', '', '正常', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('7', '2018-10-29', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('8', '2018-10-30', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('9', '2018-10-31', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('10', '2018-11-01', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '正常', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('11', '2018-11-02', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '正常', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('12', '2018-11-03', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('13', '2018-11-04', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('14', '2018-11-05', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '正常', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('15', '2018-10-31', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0003');
INSERT INTO `check_detailed` VALUES ('16', '2018-11-01', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0003');
INSERT INTO `check_detailed` VALUES ('17', '2018-11-02', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0003');
INSERT INTO `check_detailed` VALUES ('18', '2018-11-03', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0003');
INSERT INTO `check_detailed` VALUES ('19', '2018-11-04', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0003');
INSERT INTO `check_detailed` VALUES ('20', '2018-11-05', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0003');
INSERT INTO `check_detailed` VALUES ('21', '2018-11-01', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0004');
INSERT INTO `check_detailed` VALUES ('22', '2018-11-02', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0004');
INSERT INTO `check_detailed` VALUES ('23', '2018-11-03', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0004');
INSERT INTO `check_detailed` VALUES ('24', '2018-11-04', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0004');
INSERT INTO `check_detailed` VALUES ('25', '2018-11-05', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0004');
INSERT INTO `check_detailed` VALUES ('26', '2018-10-30', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0005');
INSERT INTO `check_detailed` VALUES ('27', '2018-10-31', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0005');
INSERT INTO `check_detailed` VALUES ('28', '2018-11-01', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0005');
INSERT INTO `check_detailed` VALUES ('29', '2018-11-02', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0005');
INSERT INTO `check_detailed` VALUES ('30', '2018-11-03', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0005');
INSERT INTO `check_detailed` VALUES ('31', '2018-11-04', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0005');
INSERT INTO `check_detailed` VALUES ('32', '2018-11-05', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0005');
INSERT INTO `check_detailed` VALUES ('33', '2018-10-28', '08:22:43', '12:11:00', '14:11:00', '17:31:00', '', '', '正常', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('34', '2018-10-29', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('35', '2018-10-30', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('36', '2018-10-31', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('37', '2018-11-01', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('38', '2018-11-02', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('39', '2018-11-03', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('40', '2018-11-04', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('41', '2018-11-05', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '旷工', 'nncq0006');
INSERT INTO `check_detailed` VALUES ('42', '2018-10-28', '08:22:43', '12:11:00', '14:11:00', '17:31:00', '', '', '正常', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('43', '2018-10-29', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('44', '2018-10-30', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('45', '2018-10-31', '08:22:43', '12:11:00', '14:11:00', '17:11:00', '', '', '正常', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('46', '2018-11-01', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '正常', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('47', '2018-11-02', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '正常', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('48', '2018-11-03', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('49', '2018-11-04', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('50', '2018-11-05', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '正常', 'nncq0008');
INSERT INTO `check_detailed` VALUES ('51', '2018-11-03', '08:22:43', '12:11:00', '14:11:00', '17:21:00', '', '', '', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('52', '2018-11-06', '13:22:22', '14:22:25', '15:50:35', '15:51:18', '15:58:55', '15:59:24', '旷工', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('53', '2018-11-07', '09:29:01', '10:01:20', '10:20:08', null, null, null, '旷工', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('54', '2018-11-09', '08:59:17', null, null, null, null, null, '旷工', 'nncq0001');
INSERT INTO `check_detailed` VALUES ('55', '2018-11-09', '08:59:40', null, null, null, null, null, '旷工', 'nncq0002');
INSERT INTO `check_detailed` VALUES ('57', '2018-11-13', '11:02:59', '11:03:06', '12:55:41', '12:55:50', '12:55:55', null, '旷工', 'nncq0002');

-- ----------------------------
-- Table structure for check_main
-- ----------------------------
DROP TABLE IF EXISTS `check_main`;
CREATE TABLE `check_main` (
  `check_id` int(11) NOT NULL AUTO_INCREMENT,
  `check_month` varchar(20) DEFAULT NULL,
  `check_attendance` int(11) DEFAULT NULL,
  `check_absence` int(11) DEFAULT NULL,
  `check_late` int(11) DEFAULT NULL,
  `check_early_retreat` int(11) DEFAULT NULL,
  `check_leave` int(11) DEFAULT NULL,
  PRIMARY KEY (`check_id`) USING BTREE,
  KEY `fk_check_staff_id` (`check_early_retreat`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of check_main
-- ----------------------------
INSERT INTO `check_main` VALUES ('1', '2018-10', '0', '0', '0', '0', '0');
INSERT INTO `check_main` VALUES ('2', '2018-11', '26', '50', '10', '2', '0');

-- ----------------------------
-- Table structure for check_rule
-- ----------------------------
DROP TABLE IF EXISTS `check_rule`;
CREATE TABLE `check_rule` (
  `id` int(11) DEFAULT NULL,
  `rule1` int(2) DEFAULT NULL,
  `rule2` int(2) DEFAULT NULL,
  `rule3` float(3,1) DEFAULT NULL,
  `rule4` int(2) DEFAULT NULL,
  `rule5` int(2) DEFAULT NULL,
  `rule6` float(3,1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_rule
-- ----------------------------
INSERT INTO `check_rule` VALUES ('0', '15', '30', '0.5', '15', '20', '0.5');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` varchar(20) NOT NULL,
  `company_name` varchar(20) NOT NULL,
  `company_address` varchar(255) NOT NULL,
  `company_phone` varchar(20) NOT NULL,
  `company_fax` varchar(30) DEFAULT NULL,
  `company_msg` varchar(500) DEFAULT NULL,
  `company_net` varchar(50) DEFAULT NULL,
  `salary_base` float DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '盛源行', '柳州4545245242', '077382961', '010-7308291', '广西盛源行电子信息股份有限公司成立于1999年5月26日，于2016年8月成功在新三板挂牌上市，股票代码：838676，是一家集软件产品的研发、软件应用开发fhfgh银行监过几个回合感冒刚好没过管机构和几个国家鸡冠花鸡冠花鸡冠花鸡冠花鸡冠花鸡冠花就广西盛源行电子信', 'www.shengyuanxing.com', '1600');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `contract_id` varchar(20) NOT NULL,
  `contract_long` int(11) DEFAULT NULL,
  `contract_msg` varchar(500) DEFAULT NULL,
  `contract_name` varchar(255) DEFAULT NULL,
  `contract_url` varchar(255) DEFAULT NULL,
  `contract_use_state` int(2) DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `fk_contract_staff_id` (`contract_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('CONT-1001', '90', '', '劳务合同', 'D:/sun_moon/company/contract/files/CONT-1001.docx', '0');
INSERT INTO `contract` VALUES ('CONT-1002', '80', '钱钱钱', '热额', 'D:/sun_moon/company/contract/files/CONT-1002.docx', '0');

-- ----------------------------
-- Table structure for contract_staff
-- ----------------------------
DROP TABLE IF EXISTS `contract_staff`;
CREATE TABLE `contract_staff` (
  `id` int(11) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  `contract_id` varchar(20) DEFAULT NULL,
  `contract_start_date` varchar(50) DEFAULT NULL,
  `contract_url` varchar(255) DEFAULT NULL,
  `contract_file_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract_staff
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` varchar(20) NOT NULL,
  `department_name` varchar(20) DEFAULT NULL,
  `department_describe` varchar(500) DEFAULT NULL,
  `department_use_state` int(2) DEFAULT NULL,
  `parent_id` varchar(20) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('DEP-1001', '日月股份', '公司', '1', '', null);
INSERT INTO `department` VALUES ('DEP-1002', '开发部', '开发部门', '0', 'DEP-1001', 'nncq0001');
INSERT INTO `department` VALUES ('DEP-1003', '销售部', '778781.负责完成公司下达的月、季、年度的市场销售目标。\r\n2.根据公司发展规划和市场情况，主导制定公司营销战略。\r\n3.负责营销计划的编制和落实：', '0', 'DEP-1001', 'nncq0001');
INSERT INTO `department` VALUES ('DEP-1004', '行政部 ', '负责日常事务', '0', 'DEP-1001', 'nncq0002');
INSERT INTO `department` VALUES ('DEP-1005', '财务部', '日常财务核算', '0', 'DEP-1001', 'nncq0000');
INSERT INTO `department` VALUES ('DEP-1006', '品管部', '售后服务工作', '0', 'DEP-1001', 'nncq0003');
INSERT INTO `department` VALUES ('DEP-1007', '技术1', '随便', '-1', 'DEP-1002', 'nncq0001');
INSERT INTO `department` VALUES ('DEP-1008', '测试部门', '', '-1', 'DEP-1002', 'nncq0001');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) NOT NULL,
  `file_url` varchar(255) NOT NULL,
  `parent_id` varchar(20) NOT NULL,
  `file_type` varchar(20) NOT NULL,
  PRIMARY KEY (`file_id`),
  KEY `fk_file_staff_id` (`file_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('10', '申请招聘.pdf', 'D:/sun_moon/release_recruit/files/1541144700674.pdf', 'APPLY-1007', 'recruit');
INSERT INTO `file` VALUES ('11', '操作系统简答题.doc', 'D:/sun_moon/release_recruit/files/1541144802429.doc', 'APPLY-1008', 'recruit');
INSERT INTO `file` VALUES ('12', 'aa.txt', 'D:/sun_moon/release_recruit/files/1541145029857.txt', 'APPLY-1009', 'recruit');
INSERT INTO `file` VALUES ('13', 'ad.gif', 'D:/sun_moon/release_recruit/files/1541145150483.gif', 'APPLY-1012', 'recruit');
INSERT INTO `file` VALUES ('14', 'Kali Linux无线渗透工具集教程WiFi篇v4.0.pdf', 'D:/sun_moon/release_recruit/files/1541145540754.pdf', 'APPLY-1013', 'recruit');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `staff_id` varchar(20) NOT NULL,
  `staff_password` varchar(30) NOT NULL,
  `staff_idcard` varchar(21) NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('nncq0000', '666666', '450999999999999999');
INSERT INTO `login` VALUES ('nncq0001', '666666', '450324199112282131');
INSERT INTO `login` VALUES ('nncq0002', '666666', '450913131822213121');
INSERT INTO `login` VALUES ('nncq0003', '666666', '450221199810120926');
INSERT INTO `login` VALUES ('nncq0004', '666666', '45092419970102561x');
INSERT INTO `login` VALUES ('nncq0005', '666666', '450000000000000000');
INSERT INTO `login` VALUES ('nncq0006', '666666', '450333333333333334');
INSERT INTO `login` VALUES ('nncq0007', '666666', '450924199701025614');
INSERT INTO `login` VALUES ('nncq0008', '666666', '45092419970102561x');

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg` (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `object_id` varchar(20) DEFAULT NULL,
  `msg_type` varchar(255) DEFAULT NULL,
  `msg_title` varchar(255) DEFAULT NULL,
  `msg_body` text,
  `read_staff_id` text,
  `send_id` varchar(255) DEFAULT NULL,
  `send_name` varchar(255) DEFAULT NULL,
  `send_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg
-- ----------------------------
INSERT INTO `msg` VALUES ('22', 'staff_id', 'nncq0002', 'sys', '去死吧什么', '去死吧什么鬼', ',nncq0002', 'nncq0002', '何志龙', '2018-11-02 13:16:22');
INSERT INTO `msg` VALUES ('23', 'staff_id', 'nncq0002', 'sys', '45645', '456456', ',nncq0002', 'nncq0002', '何志龙', '2018-11-02 13:18:54');
INSERT INTO `msg` VALUES ('24', 'staff_id', 'nncq0002', 'sys', '呸', '呸', ',nncq0001,nncq0002', 'nncq0001', '孟鹏', '2018-11-02 13:49:14');
INSERT INTO `msg` VALUES ('25', 'staff_id', 'nncq0001', 'sys', '狗日的', '狗日的', ',nncq0002,nncq0001', 'nncq0002', '何志龙', '2018-11-02 13:49:28');
INSERT INTO `msg` VALUES ('26', 'staff_id', 'nncq0002', 'sys', '你好', '你好', ',nncq0000,nncq0002', 'nncq0000', '薛鹏', '2018-11-02 13:51:57');
INSERT INTO `msg` VALUES ('27', 'staff_id', 'nncq0000', 'sys', '滚吧', '滚吧', ',nncq0002,nncq0000,nncq0000', 'nncq0002', '何志龙', '2018-11-02 13:52:10');
INSERT INTO `msg` VALUES ('28', 'staff_id', 'undefined', 'sys', '11111', '111111111111111', ',nncq0000', 'nncq0000', '薛鹏', '2018-11-02 13:52:39');
INSERT INTO `msg` VALUES ('29', 'staff_id', 'nncq0002', 'sys', '11111', '1111111', ',nncq0000,nncq0002', 'nncq0000', '薛鹏', '2018-11-02 13:53:08');
INSERT INTO `msg` VALUES ('30', 'staff_id', 'nncq0000', 'sys', '傻逼薛鹏', '傻逼薛鹏', ',nncq0002,nncq0000', 'nncq0002', '何志龙', '2018-11-02 13:53:46');
INSERT INTO `msg` VALUES ('31', 'staff_id', 'nncq0002', 'sys', '11', '11', ',nncq0000,nncq0002', 'nncq0000', '薛鹏', '2018-11-02 13:55:59');
INSERT INTO `msg` VALUES ('32', 'staff_id', 'nncq0003', 'sys', '神秘的消息', '神秘的消息', ',nncq0002,nncq0003,nncq0003', 'nncq0002', '何志龙', '2018-11-02 15:04:43');
INSERT INTO `msg` VALUES ('33', 'staff_id', 'nncq0001', 'sys', '牛逼', '牛逼', ',nncq0002,nncq0001', 'nncq0002', '何志龙', '2018-11-02 15:05:00');
INSERT INTO `msg` VALUES ('34', 'staff_id', 'nncq0002', 'sys', 'cecec', 'cecece', ',nncq0001,nncq0002', 'nncq0001', '孟鹏', '2018-11-02 15:05:31');
INSERT INTO `msg` VALUES ('35', 'staff_id', 'nncq0001', 'sys', 'sb', 'sb', ',nncq0002,nncq0001', 'nncq0002', '何志龙', '2018-11-02 15:14:19');
INSERT INTO `msg` VALUES ('36', 'staff_id', 'nncq0000', 'sys', '审核通知', '您于2018-11-02 09:28:44提交的离职申请已通过，请于30个工作日内完成工作交接，30个工作日后你无法登陆系统', ',nncq0002,nncq0000', 'nncq0002', null, '2018-11-05 13:31:16');
INSERT INTO `msg` VALUES ('37', 'staff_id', 'nncq0003', 'sys', '88888', '88888', ',nncq0002,nncq0003', 'nncq0002', '何志龙', '2018-11-07 15:04:50');
INSERT INTO `msg` VALUES ('38', 'staff_id', 'nncq0002', 'sys', '5', '5', ',nncq0003,nncq0002', 'nncq0003', '梁柳杰', '2018-11-07 15:05:12');
INSERT INTO `msg` VALUES ('39', 'staff_id', 'nncq0000', 'sys', '审核通知', '您于2018-11-02 09:26:37提交的调动申请已通过，请尽快前往人事部办理相关手续', ',nncq0002', 'nncq0002', null, '2018-11-07 15:47:25');
INSERT INTO `msg` VALUES ('40', 'staff_id', 'nncq0003', 'sys', '审核通知', '您于2018-11-07 15:48:32提交的调动申请已通过，请尽快前往人事部办理相关手续', ',nncq0002,nncq0003', 'nncq0002', null, '2018-11-07 15:49:57');
INSERT INTO `msg` VALUES ('41', 'staff_id', 'nncq0003', 'sys', '职员调动申请', '789<br><a href=staffManage/gotoTransferStaff?id=1 target=view_window>点击进入详细</a>', ',nncq0002,nncq0003', 'nncq0002', '何志龙', '2018-11-08 11:20:54');
INSERT INTO `msg` VALUES ('42', 'staff_id', 'nncq0002', 'sys', '职员调动申请反馈', '申请已被对方部门主管同意，现已将申请转发至人事管理，请耐心等待回馈消息', ',nncq0003,nncq0002', 'nncq0003', '系统反馈', '2018-11-08 13:51:56');
INSERT INTO `msg` VALUES ('43', 'staff_id', 'nncq0002', 'sys', '职员调动申请反馈', '申请已被对方部门主管拒绝', ',nncq0003,nncq0002', 'nncq0003', '系统反馈', '2018-11-08 13:53:19');
INSERT INTO `msg` VALUES ('44', 'staff_id', 'nncq0002', 'sys', '职员调动申请反馈', '申请已被对方部门主管同意，现已将申请转发至人事管理，请耐心等待回馈消息', ',nncq0003,nncq0002', 'nncq0003', '系统反馈', '2018-11-08 14:09:40');
INSERT INTO `msg` VALUES ('45', 'staff_id', 'nncq0000', 'sys', '审核通知', '您于2018-11-02 09:20:32发送的<br>请假申请已得到审核,该审核结果为 <br> “ 已通过”', ',nncq0001', 'nncq0001', null, '2018-11-08 14:24:30');
INSERT INTO `msg` VALUES ('46', 'staff_id', 'nncq0002', 'sys', '11', '11', ',nncq0001,nncq0002', 'nncq0001', '孟鹏', '2018-11-08 14:26:23');
INSERT INTO `msg` VALUES ('47', 'staff_id', 'nncq0000', 'sys', '审核通知', '您于2018-11-02 09:21:20发送的<br>出差申请已得到审核,该审核结果为 <br> “ 不通过”', ',nncq0001', 'nncq0001', null, '2018-11-08 14:27:29');
INSERT INTO `msg` VALUES ('48', 'staff_id', 'nncq0000', 'sys', '审核通知', '您于2018-11-02 09:27:17发送的<br>加班申请已得到审核,该审核结果为 <br> “ 不通过”', ',nncq0001', 'nncq0001', null, '2018-11-08 14:28:23');
INSERT INTO `msg` VALUES ('49', 'staff_id', 'nncq0000', 'sys', '审核通知', '您于2018-11-02 09:28:20发送的<br>报销申请已得到审核,该审核结果为 <br> “ 已通过”', ',nncq0001', 'nncq0001', null, '2018-11-08 14:30:17');
INSERT INTO `msg` VALUES ('50', 'staff_id', 'nncq0002', 'sys', '在吗', '在吗', ',nncq0001,nncq0002', 'nncq0001', '孟鹏', '2018-11-09 11:44:41');
INSERT INTO `msg` VALUES ('51', 'staff_id', 'nncq0002', 'sys', '？？？', '？？？', ',nncq0001,nncq0002', 'nncq0001', '孟鹏', '2018-11-11 16:34:58');
INSERT INTO `msg` VALUES ('52', 'staff_id', 'nncq0001', 'emailsys', '合同变更信息', '测试', ',nncq0001', 'nncq0001', '孟鹏', '2018-11-12 10:52:11');
INSERT INTO `msg` VALUES ('53', 'staff_id', 'nncq0003', 'sys', '职员调动申请', '123<br><a href=staffManage/gotoTransferStaff?id=1542076922554 target=view_window>点击进入详细</a>', ',nncq0002,nncq0003', 'nncq0002', '何志龙', '2018-11-13 10:42:02');
INSERT INTO `msg` VALUES ('54', 'staff_id', 'nncq0002', 'sys', '职员调动申请反馈', '申请已被对方部门主管同意，现已将申请转发至人事管理，请耐心等待回馈消息', ',nncq0003,nncq0002', 'nncq0003', '系统反馈', '2018-11-13 10:42:22');
INSERT INTO `msg` VALUES ('55', 'staff_id', 'nncq0003', 'sys', '8888', '8888', ',nncq0002,nncq0003', 'nncq0002', '何志龙', '2018-11-13 10:42:47');
INSERT INTO `msg` VALUES ('56', 'staff_id', 'nncq0001', 'emailsys', '合同变更信息', '123', ',nncq0002', 'nncq0002', '何志龙', '2018-11-13 10:44:44');
INSERT INTO `msg` VALUES ('57', 'staff_id', 'nncq0003', 'sys', '审核通知', '您于2018-11-02 15:52:30发送的<br>null已得到审核,该审核结果为 <br> “ 已通过”', ',nncq0002,nncq0003', 'nncq0002', null, '2018-11-13 10:55:45');
INSERT INTO `msg` VALUES ('58', 'staff_id', 'nncq0003', 'sys', '过过', '过过', ',nncq0002,nncq0003', 'nncq0002', '何志龙', '2018-11-13 10:58:20');
INSERT INTO `msg` VALUES ('59', 'staff_id', 'nncq0003', 'sys', 'hello', 'hello', ',nncq0001,nncq0003', 'nncq0001', '孟鹏', '2018-11-13 12:43:37');
INSERT INTO `msg` VALUES ('60', 'staff_id', 'nncq0001', 'sys', '你好', '你好', ',nncq0003,nncq0001', 'nncq0003', '梁柳杰', '2018-11-13 12:43:45');
INSERT INTO `msg` VALUES ('61', 'staff_id', 'nncq0001', 'sys', '你好!', '你好!', ',nncq0003', 'nncq0003', '梁柳杰', '2018-11-13 12:44:00');

-- ----------------------------
-- Table structure for mypay
-- ----------------------------
DROP TABLE IF EXISTS `mypay`;
CREATE TABLE `mypay` (
  `mypay_staff_id` varchar(20) NOT NULL,
  `mypay_time` varchar(20) DEFAULT NULL,
  `base_pay` varchar(20) DEFAULT NULL,
  `post_pay` varchar(20) DEFAULT NULL,
  `bonus` varchar(20) DEFAULT NULL,
  `achievements` varchar(20) DEFAULT NULL,
  `subsidy` varchar(20) DEFAULT NULL,
  `deduction` varchar(20) DEFAULT NULL,
  `social_insurance` varchar(20) DEFAULT NULL,
  `accumulation_fund` varchar(20) DEFAULT NULL,
  `individual_income_tax` varchar(20) DEFAULT NULL,
  `actual_pay` varchar(20) DEFAULT NULL,
  `mypay_msg` varchar(500) DEFAULT NULL,
  `mypay_moth` varchar(20) NOT NULL,
  `year_pay` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mypay_moth`,`mypay_staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mypay
-- ----------------------------
INSERT INTO `mypay` VALUES ('nncq0001', '2018-11-05', '1680.0', '0.0', '-1000', '0', null, '400.65', null, null, '0', '279.35', '新员工', '2018-10', '0');
INSERT INTO `mypay` VALUES ('nncq0002', '2018-11-05', '1680.0', '0.0', '0', '0', null, '400.65', null, null, '0', '1279.35', '', '2018-10', '0');
INSERT INTO `mypay` VALUES ('nncq0003', '2018-11-05', '1680.0', '0.0', '-1000', '0', null, '400.65', null, null, '0', '279.35', '新员工', '2018-10', '0');
INSERT INTO `mypay` VALUES ('nncq0005', '2018-11-13', '1600.0', '25000.0', '-500', '0', null, '400.65', null, null, '500', '25199.35', '', '2018-10', '0');
INSERT INTO `mypay` VALUES ('nncq0006', '2018-11-05', '1680.0', '0.0', '-1000', '0', null, '400.65', null, null, '0', '279.35', '新员工', '2018-10', '0');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(255) DEFAULT NULL,
  `notice_msg` varchar(255) DEFAULT NULL,
  `notice_time` varchar(20) DEFAULT NULL,
  `notice_staff_name` varchar(255) DEFAULT NULL,
  `read_staff_id` text,
  `notice_department_id` text,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('30', '职员：梁柳杰 调动公告', '123123123', '2018-11-02 13:40:13', '何志龙', ',nncq0002,nncq0001,nncq0003,nncq0000', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('31', '职员：梁柳杰 调动公告', '0011', '2018-11-02 14:41:19', '薛鹏', ',nncq0000,nncq0002,nncq0001', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('32', '职员：梁柳杰 调动公告', '管理员', '2018-11-02 14:52:37', '何志龙', ',nncq0002,nncq0000,nncq0001,nncq0003', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('33', '职员：天天 调动公告', '444', '2018-11-02 15:18:12', '薛鹏', ',nncq0000,nncq0003,nncq0001,nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('34', '职员：何志龙 调动公告', '9999', '2018-11-02 15:52:55', '何志龙', ',nncq0002,nncq0003,nncq0001,nncq0000', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('35', '职员：何志龙 调动公告', '456', '2018-11-05 08:57:04', '何志龙', ',nncq0002,nncq0000', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('36', '职员：何志龙 调动公告', '456', '2018-11-05 13:21:01', '何志龙', ',nncq0002,nncq0000,nncq0001', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('37', '工资发放公告', '工资已发放，请各位职员注意核查，如有疑问请联系人事部', '2018-11-05 15:54:02', '何志龙', ',nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,');
INSERT INTO `notice` VALUES ('38', '工资发放公告', '工资已发放，请各位职员注意核查，如有疑问请联系人事部', '2018-11-05 15:54:23', '何志龙', ',nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,');
INSERT INTO `notice` VALUES ('39', '789', '123', '2018-11-07 15:03:54', '何志龙', ',nncq0002,nncq0003', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('40', '职员：薛鹏 调动公告', '789+', '2018-11-07 15:47:14', '何志龙', ',nncq0002,nncq0003', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('41', '职员：梁柳杰 调动公告', '456', '2018-11-07 15:49:03', '何志龙', ',nncq0002,nncq0003', 'DEP-1002');
INSERT INTO `notice` VALUES ('42', '我！孟鹏最牛丕', '<p style=\"text-align: right;\"><b>强强强强强强<i>钱钱钱<u>氢气球<strike>', '2018-11-08 14:51:51', '孟鹏', ',nncq0001,nncq0002', 'DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006,DEP-1001');
INSERT INTO `notice` VALUES ('43', '绩效评估通知', '管理员已发起上月绩效评估,请点击下面链接参与评估<br><a href=gotoJsp?jsp=performanceEva target=view_window style=color:#1ea76f>绩效评估</a>', '2018-11-09 09:09:19', '何志龙', ',nncq0002,nncq0001,nncq0001', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006,');
INSERT INTO `notice` VALUES ('44', '绩效评估通知', '管理员已发起上月绩效评估,请点击下面链接参与评估<br><a href=gotoJsp?jsp=performanceEva target=view_window style=color:#1ea76f>绩效评估</a>', '2018-11-09 09:13:21', '何志龙', ',nncq0002,nncq0001,nncq0003', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006,');
INSERT INTO `notice` VALUES ('45', '绩效评估通知', '管理员已发起上月绩效评估,请点击下面链接参与评估<br><a href=gotoJsp?jsp=performanceEva target=view_window style=color:#1ea76f>绩效评估</a>', '2018-11-09 14:16:47', '孟鹏', ',nncq0001,nncq0004,nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006,');
INSERT INTO `notice` VALUES ('46', '123', '123', '2018-11-12 16:52:14', '何志龙', ',nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('47', '123', '123', '2018-11-12 16:54:40', '何志龙', ',nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('48', '123', '123', '2018-11-12 16:55:39', '何志龙', ',nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('49', '123', '123', '2018-11-12 16:56:47', '何志龙', ',nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('50', '123', '123', '2018-11-12 16:57:44', '何志龙', ',nncq0002,nncq0001,nncq0003,nncq0004,nncq0008,nncq0005', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');
INSERT INTO `notice` VALUES ('51', '绩效评估通知', '管理员已发起上月绩效评估,请点击下面链接参与评估<br><a href=gotoJsp?jsp=performanceEva target=view_window style=color:#1ea76f>绩效评估</a>', '2018-11-13 10:49:30', '何志龙', ',nncq0002,nncq0003', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006,');
INSERT INTO `notice` VALUES ('52', '工资发放公告', '工资已发放，请各位职员注意核查，如有疑问请联系人事部', '2018-11-13 10:54:01', '何志龙', ',nncq0002,nncq0003,nncq0001', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,');
INSERT INTO `notice` VALUES ('53', '绩效评估通知', '管理员已发起上月绩效评估,请点击下面链接参与评估<br><a href=gotoJsp?jsp=performanceEva target=view_window style=color:#1ea76f>绩效评估</a>', '2018-11-13 12:49:38', '梁柳杰', ',nncq0003,nncq0001', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006,');
INSERT INTO `notice` VALUES ('54', '职员：孟鹏 调动公告', '123', '2018-11-13 12:53:39', '梁柳杰', ',nncq0003,nncq0001,nncq0002', 'DEP-1001,DEP-1002,DEP-1003,DEP-1004,DEP-1005,DEP-1006');

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance` (
  `staff_id` varchar(20) NOT NULL,
  `month` varchar(20) NOT NULL,
  `performance` float DEFAULT NULL,
  PRIMARY KEY (`staff_id`,`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of performance
-- ----------------------------
INSERT INTO `performance` VALUES ('nncq0000', '2018-11', '250');
INSERT INTO `performance` VALUES ('nncq0001', '2018-11', '900');
INSERT INTO `performance` VALUES ('nncq0002', '2018-11', '1100');
INSERT INTO `performance` VALUES ('nncq0003', '2018-11', '3000');
INSERT INTO `performance` VALUES ('nncq0005', '2018-11', '1000');
INSERT INTO `performance` VALUES ('nncq0006', '2018-11', '999');
INSERT INTO `performance` VALUES ('nncq0008', '2018-11', '100');

-- ----------------------------
-- Table structure for position_table
-- ----------------------------
DROP TABLE IF EXISTS `position_table`;
CREATE TABLE `position_table` (
  `position_id` varchar(20) NOT NULL,
  `position_name` varchar(20) NOT NULL,
  `position_msg` varchar(255) DEFAULT NULL,
  `position_use_state` varchar(255) DEFAULT NULL,
  `post_id` varchar(20) DEFAULT NULL,
  `rank_level` int(5) DEFAULT NULL,
  `salaryBase` float DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position_table
-- ----------------------------
INSERT INTO `position_table` VALUES ('POS-1001', '管理员', '管理员', '0', 'POST-1001', '5', '5000');
INSERT INTO `position_table` VALUES ('POS-1002', '总经理', '', '0', 'POST-1011', '4', '25000');
INSERT INTO `position_table` VALUES ('POS-1003', '技术部经理', '', '0', 'POST-1001', '4', '18000');
INSERT INTO `position_table` VALUES ('POS-1004', '销售部经理', '', '0', 'POST-1001', '4', '18000');
INSERT INTO `position_table` VALUES ('POS-1005', '财务部经理', '', '0', 'POST-1001', '4', '18000');
INSERT INTO `position_table` VALUES ('POS-1006', '行政部经理', '', '0', 'POST-1001', '4', '18000');
INSERT INTO `position_table` VALUES ('POS-1007', '品管部经理', '', '0', 'POST-1001', '4', '18000');
INSERT INTO `position_table` VALUES ('POS-1008', '技术部主管', '', '0', 'POST-1011', '3', '12000');
INSERT INTO `position_table` VALUES ('POS-1009', '销售部主管', '', '0', 'POST-1012', '3', '12000');
INSERT INTO `position_table` VALUES ('POS-1010', '财务部主管', '', '0', 'POST-1014', '3', '12000');
INSERT INTO `position_table` VALUES ('POS-1011', '行政部主管', '', '0', 'POST-1013', '3', '12000');
INSERT INTO `position_table` VALUES ('POS-1012', '品管部主管', '', '0', 'POST-1015', '3', '12000');
INSERT INTO `position_table` VALUES ('POS-1013', '技术部普通职员', '', '0', 'POST-1011', '2', '8000');
INSERT INTO `position_table` VALUES ('POS-1014', '销售部普通职员', '', '0', 'POST-1012', '2', '8000');
INSERT INTO `position_table` VALUES ('POS-1015', '财务部普通职员', '', '0', 'POST-1014', '2', '8000');
INSERT INTO `position_table` VALUES ('POS-1016', '行政部普通职员', '', '0', 'POST-1013', '2', '8000');
INSERT INTO `position_table` VALUES ('POS-1017', '品管部普通职员', '', '0', 'POST-1015', '2', '8000');
INSERT INTO `position_table` VALUES ('POS-1018', '技术部实习生', '', '-1', 'POST-1011', '1', '3000');
INSERT INTO `position_table` VALUES ('POS-1019', '销售部实习生', '', '-1', 'POST-1012', '1', '3000');
INSERT INTO `position_table` VALUES ('POS-1020', '财务部实习生', '', '-1', 'POST-1014', '1', '3000');
INSERT INTO `position_table` VALUES ('POS-1021', '行政部实习生', '', '0', 'POST-1013', '1', '3000');
INSERT INTO `position_table` VALUES ('POS-1022', '品管部实习生', '', '0', 'POST-1015', '1', '3000');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` varchar(20) NOT NULL,
  `post_name` varchar(20) DEFAULT NULL,
  `post_msg` varchar(255) DEFAULT NULL,
  `powers` text,
  `post_use_state` int(2) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('POST-1001', '管理员', '管理员', '0-1-2-3-4-5-6-7-8-9-10-11-12-13-14-15-16-17-18-19-20-21-22-23-24-25-26-27-28-29-30-31-32-33-41-42-43-44-45-46-47-34-35-36-37-38-39-40-94-96-48-49-50-51-52-53-54-55-93-56-57-58-59-60-61-62-63-64-65-66-92-67-68-69-70-71-72-73-74-75-76-77-78-79-80-81-82-83-84-85-86-87-88-89-90-91-95', '0');
INSERT INTO `post` VALUES ('POST-1002', '开发部普通职员', '', '2', '-1');
INSERT INTO `post` VALUES ('POST-1003', '开发部主管', '管理开发部', '', '-1');
INSERT INTO `post` VALUES ('POST-1004', '销售部普通职员', '普通职员', '', '-1');
INSERT INTO `post` VALUES ('POST-1005', '销售部主管', '管理销售部', '', '-1');
INSERT INTO `post` VALUES ('POST-1006', '行政部普通职员', '普通职员', '', '-1');
INSERT INTO `post` VALUES ('POST-1007', '行政部主管', '管理行政部', '', '-1');
INSERT INTO `post` VALUES ('POST-1008', '财务部普通职员', '普通职员', '', '-1');
INSERT INTO `post` VALUES ('POST-1009', '财务部主管', '管理财务部', '', '-1');
INSERT INTO `post` VALUES ('POST-1010', '技术部普通职员', '普通职员', '', '-1');
INSERT INTO `post` VALUES ('POST-1011', '开发', '', '1-2-61-62-63-64-65-66-92-67-68-69-70-71-72-73-74-75-76-77-78-79-80-81-82-83-84-85-86-87-88-89-90', '0');
INSERT INTO `post` VALUES ('POST-1012', '销售', '', '2', '0');
INSERT INTO `post` VALUES ('POST-1013', '后勤', '', '2', '0');
INSERT INTO `post` VALUES ('POST-1014', '财务', '', '', '0');
INSERT INTO `post` VALUES ('POST-1015', '市场售后', '', '2', '0');
INSERT INTO `post` VALUES ('POST-1016', '员工', '', '2', '0');
INSERT INTO `post` VALUES ('POST-1017', '人事', '审核', '1-2-3-4-5-6-7-8-9-10-11-12-13-14-15-16-17-18-19-20-21-22-23-24-25-26-27-28-29-30-31-32-33-41-42-43-44-45-46-47-34-35-36-37-38-39-40-48-49-50-51-52-53-54-55-56-57-58-59-60-61-62-63-64-65-66-92-67-68-69-70-71-72-73-74-75-78-79-80-81-82-83-84-85-86', '0');
INSERT INTO `post` VALUES ('POST-1018', '打杂', '0', '', '0');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `power_id` int(11) NOT NULL,
  `power_name` varchar(20) DEFAULT NULL,
  `power_msg` varchar(255) DEFAULT NULL,
  `power_url` varchar(500) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('0', '高级管理员', '全部权限', '*', '-1');
INSERT INTO `power` VALUES ('1', '登录后台', '登陆后台', 'login?staffType=0', '0');
INSERT INTO `power` VALUES ('2', '普通登录', '普通职员登陆', 'login?staffType=1', '0');
INSERT INTO `power` VALUES ('3', '组织规划', '勾选全部', '', '0');
INSERT INTO `power` VALUES ('4', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/orgplan', '3');
INSERT INTO `power` VALUES ('5', '上班地点管理', '', '', '3');
INSERT INTO `power` VALUES ('6', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/addressManage', '5');
INSERT INTO `power` VALUES ('7', '添加地点', '', 'workAddress/addAddress', '5');
INSERT INTO `power` VALUES ('8', '修改地点', '', 'workAddress/updateAddress', '5');
INSERT INTO `power` VALUES ('9', '删除地点', '', 'workAddress/delAddress', '5');
INSERT INTO `power` VALUES ('10', '部门管理', null, null, '3');
INSERT INTO `power` VALUES ('11', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/departmentManage', '10');
INSERT INTO `power` VALUES ('12', '添加部门', '', 'department/addDepartment', '10');
INSERT INTO `power` VALUES ('13', '修改部门', '', 'department/updateDepartment', '10');
INSERT INTO `power` VALUES ('14', '删除部门', '', 'department/delDepartment', '10');
INSERT INTO `power` VALUES ('15', '职务管理', null, null, '3');
INSERT INTO `power` VALUES ('16', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/postManage', '15');
INSERT INTO `power` VALUES ('17', '添加职务', '', 'postManage/addPost', '15');
INSERT INTO `power` VALUES ('18', '修改职务', '', 'postManage/updatePost', '15');
INSERT INTO `power` VALUES ('19', '删除职务', '', 'postManage/delPost', '15');
INSERT INTO `power` VALUES ('20', '职级管理', null, null, '3');
INSERT INTO `power` VALUES ('21', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/rankManage', '20');
INSERT INTO `power` VALUES ('22', '添加职级', '', 'rankManage/add', '20');
INSERT INTO `power` VALUES ('23', '修改职级', '', 'rankManage/update', '20');
INSERT INTO `power` VALUES ('24', '删除职级', '', 'rankManage/del', '20');
INSERT INTO `power` VALUES ('25', '职位管理', null, null, '3');
INSERT INTO `power` VALUES ('26', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/positionManage', '25');
INSERT INTO `power` VALUES ('27', '添加职位', '', 'positionManage/add', '25');
INSERT INTO `power` VALUES ('28', '修改职位', '', 'positionManage/update', '25');
INSERT INTO `power` VALUES ('29', '删除职位', '', 'positionManage/del', '25');
INSERT INTO `power` VALUES ('30', '员工管理', null, null, '0');
INSERT INTO `power` VALUES ('31', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/staffManage', '30');
INSERT INTO `power` VALUES ('32', '添加职员', '', 'gotoJsp?jsp=admin/content/addStaff', '30');
INSERT INTO `power` VALUES ('33', '职员列表', '', '', '30');
INSERT INTO `power` VALUES ('34', '查看花名册', '', 'gotoJsp?jsp=admin/content/roster', '30');
INSERT INTO `power` VALUES ('35', '工号设置', '', 'gotoJsp?jsp=admin/content/staffIdSetting', '30');
INSERT INTO `power` VALUES ('36', '合同配置', '', '', '30');
INSERT INTO `power` VALUES ('37', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/contractManage', '36');
INSERT INTO `power` VALUES ('38', '添加合同', '', 'contractManage/add', '36');
INSERT INTO `power` VALUES ('39', '修改合同', '', 'contractManage/update', '36');
INSERT INTO `power` VALUES ('40', '删除合同', '', 'contractManage/del', '36');
INSERT INTO `power` VALUES ('41', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/staffTableList', '33');
INSERT INTO `power` VALUES ('42', '转正职员', '', 'staffManage/regularStaff', '33');
INSERT INTO `power` VALUES ('43', '调动职员', '', 'staffManage/transferStaff', '33');
INSERT INTO `power` VALUES ('44', '变更职员合同', '', 'staffManage/changeStaffContract', '33');
INSERT INTO `power` VALUES ('45', '重置职员密码', '', 'staffManage/resetPassword', '33');
INSERT INTO `power` VALUES ('46', '置职员离职', null, 'staffManage/quitStaff', '33');
INSERT INTO `power` VALUES ('47', '编辑职员信息', null, 'staffManage/updateStaffBase', '33');
INSERT INTO `power` VALUES ('48', '考勤管理', null, null, '0');
INSERT INTO `power` VALUES ('49', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/checkManage', '48');
INSERT INTO `power` VALUES ('50', '打卡配置', '', 'gotoJsp?jsp=admin/content/checkConfigure', '48');
INSERT INTO `power` VALUES ('51', '规则配置', '', 'gotoJsp?jsp=admin/content/checkRuleSetting', '48');
INSERT INTO `power` VALUES ('52', '考勤记录', '', '', '48');
INSERT INTO `power` VALUES ('53', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/checkRecord', '52');
INSERT INTO `power` VALUES ('54', '结算考勤', '', 'gotoJsp?jsp=admin/content/checkRecord', '52');
INSERT INTO `power` VALUES ('55', '补签', '', 'gotoJsp?jsp=admin/content/checkRecord', '52');
INSERT INTO `power` VALUES ('56', '排班', '', 'gotoJsp?jsp=admin/content/scheduling', '48');
INSERT INTO `power` VALUES ('57', '绩效评估', null, null, '0');
INSERT INTO `power` VALUES ('58', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/performanceEva', '57');
INSERT INTO `power` VALUES ('59', '评绩效', '', 'gotoJsp?jsp=admin/content/performanceEvaNew', '57');
INSERT INTO `power` VALUES ('60', '查看绩效历史', '', 'gotoJsp?jsp=admin/content/performanceEvaHistory', '57');
INSERT INTO `power` VALUES ('61', '招聘配置', null, null, '0');
INSERT INTO `power` VALUES ('62', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/recConfiguration', '61');
INSERT INTO `power` VALUES ('63', '申请招聘', '', 'gotoJsp?jsp=admin/content/recruitManage', '61');
INSERT INTO `power` VALUES ('64', '删除招聘', '', 'recruitManage/del', '61');
INSERT INTO `power` VALUES ('65', '统计报表', null, null, '0');
INSERT INTO `power` VALUES ('66', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/statStatement', '65');
INSERT INTO `power` VALUES ('67', '薪酬管理', null, null, '0');
INSERT INTO `power` VALUES ('68', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/salaryManage', '67');
INSERT INTO `power` VALUES ('69', '基本设置', '', 'gotoJsp?jsp=admin/content/salaryBase', '67');
INSERT INTO `power` VALUES ('70', '工资核对与发放', '', '', '67');
INSERT INTO `power` VALUES ('71', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/content/salaryCheck', '70');
INSERT INTO `power` VALUES ('72', '核对工资', '', 'salary/saveMonthSalaryCheck', '70');
INSERT INTO `power` VALUES ('73', '发放工资', '', 'salary/payBeforMonth', '70');
INSERT INTO `power` VALUES ('74', '工资发放历史查询', '', 'gotoJsp?jsp=admin/content/salaryHistory', '67');
INSERT INTO `power` VALUES ('75', '五险一金配置', '', 'gotoJsp?jsp=admin/content/risksGold', '67');
INSERT INTO `power` VALUES ('76', '培训与开发', '', '', '0');
INSERT INTO `power` VALUES ('77', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/trainingDevelopment', '76');
INSERT INTO `power` VALUES ('78', '审批中心', '', '', '0');
INSERT INTO `power` VALUES ('79', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/examineCentrality', '78');
INSERT INTO `power` VALUES ('80', '审核招聘申请', '', 'gotoJsp?jsp=admin/content/examineRrcruit', '78');
INSERT INTO `power` VALUES ('81', '审核请假申请', '', 'gotoJsp?jsp=admin/content/examineLeave', '78');
INSERT INTO `power` VALUES ('82', '审核出差申请', '', 'gotoJsp?jsp=admin/content/examineEvection', '78');
INSERT INTO `power` VALUES ('83', '审核调动申请', '', 'gotoJsp?jsp=admin/content/examineTransfer', '78');
INSERT INTO `power` VALUES ('84', '审核加班申请', '', 'gotoJsp?jsp=admin/content/examineOverTime', '78');
INSERT INTO `power` VALUES ('85', '审核报销申请', '', 'gotoJsp?jsp=admin/content/examineExpense', '78');
INSERT INTO `power` VALUES ('86', '审核离职申请', '', 'gotoJsp?jsp=admin/content/examineQuit', '78');
INSERT INTO `power` VALUES ('87', '公司账户', '', '', '0');
INSERT INTO `power` VALUES ('88', '访问此模块', '不勾选此项则无法访问该模块', 'gotoJsp?jsp=admin/companyAccount', '87');
INSERT INTO `power` VALUES ('89', '公司概况', '', 'gotoJsp?jsp=admin/content/companyProfile', '87');
INSERT INTO `power` VALUES ('90', '公司概况设置', '', 'gotoJsp?jsp=admin/content/company', '87');
INSERT INTO `power` VALUES ('91', '跨职级管理', '管理职级比自己高的职员', 'span', '-1');
INSERT INTO `power` VALUES ('92', '人员报表', '', 'gotoJsp?jsp=admin/content/staffCharts', '65');
INSERT INTO `power` VALUES ('93', '今日打卡记录', '', 'gotoJsp?jsp=admin/content/checkRecordToday', '52');
INSERT INTO `power` VALUES ('94', '职员合同管理', '', 'gotoJsp?jsp=admin/content/staffContractManage', '30');
INSERT INTO `power` VALUES ('95', '夸部门管理职员', '', 'span/department', '-1');
INSERT INTO `power` VALUES ('96', '调动申请', '', 'gotoJsp?jsp=admin/content/transferStaff', '30');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(20) NOT NULL,
  `product_type` varchar(20) NOT NULL,
  `product_model` varchar(20) NOT NULL,
  `product_cost` double NOT NULL,
  `product_price` double NOT NULL,
  `product_time` datetime NOT NULL,
  `product_ser` text,
  `staff_id` varchar(20) NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk-product_staff_id` (`staff_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `rank_id` int(11) NOT NULL AUTO_INCREMENT,
  `rank_name` varchar(255) DEFAULT NULL,
  `rank_level` int(5) DEFAULT NULL,
  `rank_msg` varchar(500) DEFAULT NULL,
  `rank_use_state` int(2) DEFAULT NULL,
  PRIMARY KEY (`rank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES ('5', '初级员工', '1', '', '0');
INSERT INTO `rank` VALUES ('6', '普通员工', '2', '', '0');
INSERT INTO `rank` VALUES ('7', '中级员工', '3', '', '0');
INSERT INTO `rank` VALUES ('8', '高级员工', '4', '', '0');
INSERT INTO `rank` VALUES ('9', '特级员工', '5', '', '0');

-- ----------------------------
-- Table structure for recruit
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit` (
  `rel_rec_id` varchar(20) NOT NULL,
  `position_id` varchar(20) DEFAULT NULL,
  `rel_rec_title` varchar(255) DEFAULT NULL,
  `rel_rec_desc` varchar(500) DEFAULT NULL,
  `rel_rec_number` int(11) DEFAULT NULL,
  `rel_rec_money` varchar(255) DEFAULT NULL,
  `rel_rec_use_state` int(2) DEFAULT NULL COMMENT '使用状态 -1删除 0正常',
  PRIMARY KEY (`rel_rec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruit
-- ----------------------------
INSERT INTO `recruit` VALUES ('REC-1001', 'POS-1018', '招聘实习生', '这是一个很详细的描述', '1', '2200', '0');
INSERT INTO `recruit` VALUES ('REC-1002', 'POS-1022', '实习生招聘', '测试', '50', '3000', '0');
INSERT INTO `recruit` VALUES ('REC-1003', 'POS-1003', '技术经理招聘', '测试', '10', '100000', '0');
INSERT INTO `recruit` VALUES ('REC-1004', 'POS-1004', '广纳贤才，来了就是一家人', '快来快来', '1', '15000', '-1');
INSERT INTO `recruit` VALUES ('REC-1005', 'POS-1004', '广纳贤才，来了就是一家人', '快来快来', '1', '15000', '-1');
INSERT INTO `recruit` VALUES ('REC-1006', 'POS-1004', '广纳贤才，来了就是一家人', '快来快来', '1', '15000', '0');
INSERT INTO `recruit` VALUES ('REC-1007', 'POS-1022', '后勤人员招聘', '测试', '50', '2000', '0');

-- ----------------------------
-- Table structure for recruit_apply
-- ----------------------------
DROP TABLE IF EXISTS `recruit_apply`;
CREATE TABLE `recruit_apply` (
  `apply_id` varchar(20) NOT NULL,
  `apply_name` varchar(20) NOT NULL,
  `apply_idcard` int(21) NOT NULL,
  `apply_birthday` date NOT NULL,
  `apply_sex` varchar(10) NOT NULL,
  `apply_marital_status` varchar(10) NOT NULL,
  `apply_address` varchar(200) NOT NULL,
  `apply_phone` varchar(20) NOT NULL,
  `apply_email` varchar(30) DEFAULT NULL,
  `apply_nation` varchar(20) NOT NULL,
  `apply_education` varchar(20) NOT NULL,
  `apply_political` varchar(20) NOT NULL,
  `apply_person_picture` varchar(100) DEFAULT NULL,
  `apply_idcard_picture` varchar(100) DEFAULT NULL,
  `apply_resume_url` varchar(100) DEFAULT NULL,
  `position_id` varchar(20) NOT NULL,
  PRIMARY KEY (`apply_id`),
  KEY `fk_apply_position_id` (`position_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruit_apply
-- ----------------------------

-- ----------------------------
-- Table structure for risks_gold
-- ----------------------------
DROP TABLE IF EXISTS `risks_gold`;
CREATE TABLE `risks_gold` (
  `id` int(11) NOT NULL,
  `p1` float DEFAULT NULL,
  `p2` float DEFAULT NULL,
  `p3` float DEFAULT NULL,
  `p4` float DEFAULT NULL,
  `p5` float DEFAULT NULL,
  `p6` float DEFAULT NULL,
  `c1` float DEFAULT NULL,
  `c2` float DEFAULT NULL,
  `c3` float DEFAULT NULL,
  `c4` float DEFAULT NULL,
  `c5` float DEFAULT NULL,
  `c6` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of risks_gold
-- ----------------------------
INSERT INTO `risks_gold` VALUES ('1', '219.93', '54.98', '13.74', '112', '0', '0', '522.34', '206.18', '13.74', '112', '10.99', '13.74');

-- ----------------------------
-- Table structure for scheduling
-- ----------------------------
DROP TABLE IF EXISTS `scheduling`;
CREATE TABLE `scheduling` (
  `month` varchar(20) NOT NULL,
  `dates` text,
  PRIMARY KEY (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scheduling
-- ----------------------------
INSERT INTO `scheduling` VALUES ('2018-10', '2018-10-03,2018-10-10,2018-10-17,2018-10-24,2018-10-04,2018-10-11,2018-10-18,2018-10-25');
INSERT INTO `scheduling` VALUES ('2018-11', '2018-11-03,2018-11-10,2018-11-17,2018-11-24,2018-11-04,2018-11-11,2018-11-18,2018-11-25');
INSERT INTO `scheduling` VALUES ('2018-12', '2018-12-01,2018-12-08,2018-12-15,2018-12-22,2018-12-29,2018-12-02,2018-12-09,2018-12-16,2018-12-23,2018-12-30');
INSERT INTO `scheduling` VALUES ('2019-1', '2019-01-05,2019-01-12,2019-01-19,2019-01-26,2019-01-06,2019-01-13,2019-01-20,2019-01-27');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` varchar(20) NOT NULL,
  `staff_name` varchar(20) DEFAULT NULL,
  `staff_birthday` varchar(20) DEFAULT NULL,
  `staff_certificates_type` varchar(50) DEFAULT NULL,
  `staff_certificates_number` varchar(50) DEFAULT NULL,
  `staff_sex` varchar(6) DEFAULT NULL,
  `staff_address` varchar(200) DEFAULT NULL,
  `staff_phone` varchar(20) DEFAULT NULL,
  `staff_email` varchar(100) DEFAULT NULL,
  `staff_in_date` varchar(20) DEFAULT NULL,
  `staff_education` varchar(20) DEFAULT NULL,
  `staff_idcard_picture_one` varchar(200) DEFAULT NULL,
  `staff_idcard_picture_tow` varchar(200) DEFAULT NULL,
  `staff_person_picture` varchar(200) DEFAULT NULL,
  `staff_state` varchar(10) DEFAULT NULL,
  `position_id` varchar(20) DEFAULT NULL,
  `department_id` varchar(20) DEFAULT NULL,
  `work_address_id` varchar(20) DEFAULT NULL,
  `staff_msg` varchar(500) DEFAULT NULL,
  `staff_type` varchar(50) DEFAULT NULL,
  `staff_marriage` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`staff_id`),
  KEY `fk_position_id` (`position_id`) USING BTREE,
  KEY `staff_id` (`staff_id`) USING BTREE,
  KEY `staff_id_2` (`staff_id`) USING BTREE,
  KEY `fk_department_id` (`department_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('nncq0000', '薛鹏', '2018-10-29', '身份证', '450999999999999999', '男', '', '13111111111', '987746356@qq.com', '2018-11-07', '博士', 'D:/sun_moon/staff/nncq0000/pic/imgOne.png', 'D:/sun_moon/staff/nncq0000/pic/imgTow.png', 'D:/sun_moon/staff/nncq0000/pic/imgThree.jpg', '已离职', 'POS-1001', 'DEP-1001', 'W-A-1001', '', '正式员工', '');
INSERT INTO `staff` VALUES ('nncq0001', '孟鹏', '2018-10-01', '身份证', '450324199112282131', '男', '柳州', '18176351090', '987746356@qq.con', '2018-10-28', '研究生', 'D:/sun_moon/staff/nncq0001/pic/imgOne.png', 'D:/sun_moon/staff/nncq0001/pic/imgTow.png', 'D:/sun_moon/staff/nncq0002/pic/imgThree.jpeg', '在职', 'POS-1002', 'DEP-1001', 'W-A-1001', '测试', '正式员工', '');
INSERT INTO `staff` VALUES ('nncq0002', '何志龙', '2018-10-31', '身份证', '450913131822213121', '男', '测试', '17777387677', '1092501244@qq.com', '2018-10-31', '博士', 'D:/sun_moon/staff/nncq0002/pic/imgOne.png', 'D:/sun_moon/staff/nncq0002/pic/imgTow.png', 'D:/sun_moon/staff/nncq0002/pic/imgThree.jpg', '在职', 'POS-1001', 'DEP-1001', 'W-A-1001', '测试', '正式员工', '已婚');
INSERT INTO `staff` VALUES ('nncq0003', '梁柳杰', '2018-10-30', '身份证', '450221199810120926', '女', '柳州', '18198231098', '1714372042@qq.com', '2018-10-31', '博士', 'D:/sun_moon/staff/nncq0003/pic/imgOne.png', 'D:/sun_moon/staff/nncq0003/pic/imgTow.png', 'D:/sun_moon/staff/nncq0003/pic/imgThree.jpeg', '已离职', 'POS-1001', 'DEP-1002', 'W-A-1004', '测试', '正式员工', '已婚');
INSERT INTO `staff` VALUES ('nncq0004', '请求', '', '身份证', '45092419970102561x', '男', '', '18207759586', '873614478@qq.com', '2018-11-01', '', 'D:/sun_moon/staff/nncq0004/pic/imgOne.jpg', 'D:/sun_moon/staff/nncq0004/pic/imgTow.jpg', 'D:/sun_moon/staff/nncq0004/pic/imgThree.png', '在职', 'POS-1002', 'DEP-1001', 'W-A-1002', '', '正式员工', '');
INSERT INTO `staff` VALUES ('nncq0005', '蒙鹏', '', '身份证', '450000000000000000', '女', '', '18200076895', '00000000@qq.com', '2018-10-30', '', 'D:/sun_moon/staff/nncq0005/pic/imgOne.png', 'D:/sun_moon/staff/nncq0005/pic/imgTow.png', 'D:/sun_moon/staff/nncq0005/pic/imgThree.png', '在职', 'POS-1002', 'DEP-1002', 'W-A-1002', '', '正式员工', '');
INSERT INTO `staff` VALUES ('nncq0006', '请求', '', '身份证', '450333333333333334', '男', '', '18207759586', '873614478@qq.com', '2018-10-28', '博士', 'D:/sun_moon/staff/nncq0006/pic/imgOne.jpg', 'D:/sun_moon/staff/nncq0006/pic/imgTow.jpg', 'D:/sun_moon/staff/nncq0006/pic/imgThree.jpg', '在职', 'POS-1001', 'DEP-1006', 'W-A-1005', '', '正式员工', '');
INSERT INTO `staff` VALUES ('nncq0007', '天天', '', '身份证', '450924199701025614', '男', '', '18207759586', '873614478@qq.com', '2018-10-31', '', 'D:/sun_moon/staff/nncq0007/pic/imgOne.png', 'D:/sun_moon/staff/nncq0007/pic/imgTow.png', 'D:/sun_moon/staff/nncq0007/pic/imgThree.jpg', '已离职', 'POS-1019', 'DEP-1001', 'W-A-1004', '', '正式员工', '');
INSERT INTO `staff` VALUES ('nncq0008', '孟婆', '2018-11-06', '身份证', '45092419970102561x', '女', '', '18207759586', '873614478@qq.com', '2018-10-28', '', 'D:/sun_moon/staff/nncq0008/pic/imgOne.jpg', 'D:/sun_moon/staff/nncq0008/pic/imgTow.jpg', 'D:/sun_moon/staff/nncq0008/pic/imgThree.jpg', '在职', 'POS-1017', 'DEP-1006', 'W-A-1003', '', '正式员工', '');

-- ----------------------------
-- Table structure for staffquit
-- ----------------------------
DROP TABLE IF EXISTS `staffquit`;
CREATE TABLE `staffquit` (
  `staffquit_name` varchar(20) NOT NULL,
  `staffquit_department` varchar(20) DEFAULT NULL,
  `staffquit_post` varchar(20) DEFAULT NULL,
  `staffquit_msg` varchar(255) DEFAULT NULL,
  `apply_time` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`staffquit_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffquit
-- ----------------------------

-- ----------------------------
-- Table structure for staff_contract
-- ----------------------------
DROP TABLE IF EXISTS `staff_contract`;
CREATE TABLE `staff_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` varchar(20) DEFAULT NULL,
  `contract_name` varchar(20) DEFAULT NULL,
  `start_time` varchar(20) DEFAULT NULL,
  `end_time` varchar(20) DEFAULT NULL,
  `contract_url` varchar(255) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `change_msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_contract
-- ----------------------------
INSERT INTO `staff_contract` VALUES ('5', 'nncq0001', '劳务合同', '2018-11-22', '2019-02-20', 'D:/sun_moon/staff/nncq0001/contract/1541056715807.docx', '已过期', '测试');
INSERT INTO `staff_contract` VALUES ('6', 'nncq0001', '劳务合同', '2018-11-01', '2019-01-30', 'D:/sun_moon/staff/nncq0001/contract/1541057229119.docx', '已过期', null);
INSERT INTO `staff_contract` VALUES ('7', 'nncq0002', '劳务合同', '2018-10-30', '2019-01-28', 'D:/sun_moon/staff/nncq0002/contract/1541057539993.docx', '使用中', null);
INSERT INTO `staff_contract` VALUES ('8', 'nncq0003', '劳务合同', '2018-11-05', '2019-02-03', 'D:/sun_moon/staff/nncq0003/contract/1541058155569.docx', '已过期', null);
INSERT INTO `staff_contract` VALUES ('9', 'nncq0003', '劳务合同', '2018-11-17', '2019-02-15', 'D:/sun_moon/staff/nncq0003/contract/1541058817231.docx', '使用中', null);
INSERT INTO `staff_contract` VALUES ('10', 'nncq0004', '劳务合同', '2018-11-05', '2019-02-03', 'D:/sun_moon/staff/nncq0004/contract/1541141648403.doc', '使用中', null);
INSERT INTO `staff_contract` VALUES ('11', 'nncq0005', '劳务合同', '2018-11-06', '2019-02-04', 'D:/sun_moon/staff/nncq0005/contract/1541142018565.doc', '使用中', null);
INSERT INTO `staff_contract` VALUES ('12', 'nncq0006', '劳务合同', '2018-10-30', '2019-01-28', 'D:/sun_moon/staff/nncq0006/contract/1541142663571.doc', '使用中', null);
INSERT INTO `staff_contract` VALUES ('13', 'nncq0007', '劳务合同', '2018-10-30', '2019-01-28', 'D:/sun_moon/staff/nncq0007/contract/1541143050618.xlsx', '使用中', null);
INSERT INTO `staff_contract` VALUES ('14', 'nncq0008', '劳务合同', '2018-10-29', '2019-01-27', 'D:/sun_moon/staff/nncq0008/contract/1541143744384.jpg', '使用中', null);
INSERT INTO `staff_contract` VALUES ('15', 'nncq0001', '劳务合同', '2018-11-30', '2019-02-28', 'D:/sun_moon/staff/nncq0001/contract/1541991132020.docx', '已过期', '合同到期');
INSERT INTO `staff_contract` VALUES ('16', 'nncq0001', '劳务合同', '2018-11-13', '2019-02-11', 'D:/sun_moon/staff/nncq0001/contract/1542077084262.png', '使用中', null);

-- ----------------------------
-- Table structure for staff_evection_apply
-- ----------------------------
DROP TABLE IF EXISTS `staff_evection_apply`;
CREATE TABLE `staff_evection_apply` (
  `evection_id` varchar(20) NOT NULL,
  `evection_staff_id` varchar(20) DEFAULT NULL,
  `evection_acc` varchar(20) DEFAULT NULL,
  `evection_acc_position` varchar(20) DEFAULT NULL,
  `evection_vehicle` varchar(50) DEFAULT NULL,
  `evection_start_time` varchar(50) DEFAULT NULL,
  `evection_end_time` varchar(50) DEFAULT NULL,
  `evection_path` varchar(255) DEFAULT NULL,
  `evection_msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`evection_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_evection_apply
-- ----------------------------
INSERT INTO `staff_evection_apply` VALUES ('Evection-1001', 'nncq0000', '梁柳杰', '经理', '小黄车', '2018-11-02', '2018-11-17', '云南', '去云南视察');
INSERT INTO `staff_evection_apply` VALUES ('Evection-1002', 'nncq0001', '去', '不知道', '坦克', '2018-11-15', '2018-11-20', '北上广', '泡妞');

-- ----------------------------
-- Table structure for staff_expense_apply
-- ----------------------------
DROP TABLE IF EXISTS `staff_expense_apply`;
CREATE TABLE `staff_expense_apply` (
  `expense_id` varchar(20) NOT NULL,
  `expense_staff_id` varchar(20) DEFAULT NULL,
  `expense_post` varchar(15) DEFAULT NULL,
  `expense_department` varchar(15) DEFAULT NULL,
  `expense_type` varchar(20) DEFAULT NULL,
  `expense_total_price` varchar(20) DEFAULT NULL,
  `expense_actual_price` varchar(20) DEFAULT NULL,
  `expense_msg` varchar(255) DEFAULT NULL,
  `expense_file` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_expense_apply
-- ----------------------------
INSERT INTO `staff_expense_apply` VALUES ('Expense-1001', 'nncq0000', '管理员', '日月股份', '交通费', '10000', '9000', '恢复度过二u发hi回复vi地方', null);
INSERT INTO `staff_expense_apply` VALUES ('Expense-1002', 'nncq0001', '管理员', '日月股份', '交通费', '111', '111', '灭蝇', null);

-- ----------------------------
-- Table structure for staff_id
-- ----------------------------
DROP TABLE IF EXISTS `staff_id`;
CREATE TABLE `staff_id` (
  `id` int(11) DEFAULT NULL,
  `prefix` varchar(255) DEFAULT NULL,
  `middle` varchar(255) DEFAULT NULL,
  `suffix` varchar(255) DEFAULT NULL,
  `separate` varchar(255) DEFAULT NULL,
  `auto` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_id
-- ----------------------------
INSERT INTO `staff_id` VALUES ('0', 'nncq', '0', '', '', 'on', '666666');

-- ----------------------------
-- Table structure for staff_leave_apply
-- ----------------------------
DROP TABLE IF EXISTS `staff_leave_apply`;
CREATE TABLE `staff_leave_apply` (
  `leave_id` varchar(20) NOT NULL,
  `leave_type` varchar(10) DEFAULT NULL,
  `leave_start_time` varchar(25) DEFAULT NULL,
  `leave_end_time` varchar(25) DEFAULT NULL,
  `leave_msg` varchar(255) DEFAULT NULL,
  `leave_staff_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_leave_apply
-- ----------------------------
INSERT INTO `staff_leave_apply` VALUES ('Leave-1001', '婚假', '2018-11-02', '2018-11-09', '我终于要结婚了', 'nncq0000');
INSERT INTO `staff_leave_apply` VALUES ('Leave-1002', '事假', '2018-11-05', '2018-11-22', '456', 'nncq0002');
INSERT INTO `staff_leave_apply` VALUES ('Leave-1003', '事假', '2018-11-08', '2018-11-09', '是【横滨', 'nncq0001');

-- ----------------------------
-- Table structure for staff_month_check
-- ----------------------------
DROP TABLE IF EXISTS `staff_month_check`;
CREATE TABLE `staff_month_check` (
  `month` varchar(20) NOT NULL,
  `staff_id` varchar(20) NOT NULL,
  `absence` float(11,0) DEFAULT NULL,
  `late` int(11) DEFAULT NULL,
  `early` int(11) DEFAULT NULL,
  `attendance` int(11) DEFAULT NULL,
  `attendance_need` int(11) DEFAULT NULL,
  `staff_leave` int(11) DEFAULT NULL,
  PRIMARY KEY (`month`,`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_month_check
-- ----------------------------
INSERT INTO `staff_month_check` VALUES ('2018-10', 'nncq0001', '0', '0', '0', '1', '1', '0');
INSERT INTO `staff_month_check` VALUES ('2018-10', 'nncq0002', '0', '0', '0', '1', '1', '0');
INSERT INTO `staff_month_check` VALUES ('2018-10', 'nncq0003', '0', '0', '0', '1', '1', '0');
INSERT INTO `staff_month_check` VALUES ('2018-10', 'nncq0004', '0', '0', '0', '1', '1', '0');
INSERT INTO `staff_month_check` VALUES ('2018-10', 'nncq0005', '0', '0', '0', '1', '1', '0');
INSERT INTO `staff_month_check` VALUES ('2018-10', 'nncq0006', '0', '0', '0', '1', '1', '0');
INSERT INTO `staff_month_check` VALUES ('2018-10', 'nncq0008', '0', '0', '0', '1', '1', '0');
INSERT INTO `staff_month_check` VALUES ('2018-11', 'nncq0001', '6', '0', '0', '4', '9', '0');
INSERT INTO `staff_month_check` VALUES ('2018-11', 'nncq0002', '7', '1', '2', '7', '9', '0');
INSERT INTO `staff_month_check` VALUES ('2018-11', 'nncq0003', '7', '3', '0', '3', '9', '0');
INSERT INTO `staff_month_check` VALUES ('2018-11', 'nncq0004', '7', '0', '0', '3', '9', '0');
INSERT INTO `staff_month_check` VALUES ('2018-11', 'nncq0005', '7', '0', '0', '3', '9', '0');
INSERT INTO `staff_month_check` VALUES ('2018-11', 'nncq0006', '7', '3', '0', '3', '9', '0');
INSERT INTO `staff_month_check` VALUES ('2018-11', 'nncq0008', '6', '3', '0', '3', '9', '0');

-- ----------------------------
-- Table structure for staff_overtime_apply
-- ----------------------------
DROP TABLE IF EXISTS `staff_overtime_apply`;
CREATE TABLE `staff_overtime_apply` (
  `overtime_id` varchar(20) NOT NULL,
  `overtime_staff_id` varchar(20) DEFAULT NULL,
  `overtime_department` varchar(20) DEFAULT NULL,
  `overtime_post` varchar(20) DEFAULT NULL,
  `overtime_start_time` varchar(50) DEFAULT NULL,
  `overtime_duration` varchar(50) DEFAULT NULL,
  `overtime_end_time` varchar(50) DEFAULT NULL,
  `overtime_msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`overtime_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_overtime_apply
-- ----------------------------
INSERT INTO `staff_overtime_apply` VALUES ('OverTime-1001', 'nncq0000', '管理员', '日月股份', '2018-11-02', '6', '2018-11-03', '加班使我快乐');
INSERT INTO `staff_overtime_apply` VALUES ('OverTime-1002', 'nncq0001', '管理员', '日月股份', '2018-11-19', '24', '2018-11-20', '喜欢加班');

-- ----------------------------
-- Table structure for staff_quit_apply
-- ----------------------------
DROP TABLE IF EXISTS `staff_quit_apply`;
CREATE TABLE `staff_quit_apply` (
  `quit_id` varchar(20) NOT NULL,
  `quit_staff_id` varchar(20) DEFAULT NULL,
  `quit_department` varchar(20) DEFAULT NULL,
  `quit_post` varchar(20) DEFAULT NULL,
  `quit_time` varchar(20) DEFAULT NULL,
  `quit_msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`quit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_quit_apply
-- ----------------------------
INSERT INTO `staff_quit_apply` VALUES ('Quit-1001', 'nncq0000', '日月股份', '管理员', '2018-11-03', '我要走了，世界那么大，我要去看看');
INSERT INTO `staff_quit_apply` VALUES ('Quit-1002', 'nncq0001', '日月股份', '管理员', '2018-11-20', '向往自由');

-- ----------------------------
-- Table structure for staff_transfer
-- ----------------------------
DROP TABLE IF EXISTS `staff_transfer`;
CREATE TABLE `staff_transfer` (
  `stafftransfer_id` int(11) NOT NULL,
  `stafftransfer_name` varchar(20) DEFAULT NULL,
  `stafftransfer_now_department` varchar(20) DEFAULT NULL,
  `stafftransfer_now_post` varchar(20) DEFAULT NULL,
  `stafftransfer_apply_time` varchar(50) DEFAULT NULL,
  `stafftransfer_fold_department` varchar(50) DEFAULT NULL,
  `stafftransfer_new_post` varchar(20) DEFAULT NULL,
  `stafftransfer_msg` varchar(255) DEFAULT NULL,
  `stafftransfer_now_department_idea` varchar(255) DEFAULT NULL,
  `stafftransfer_new_department_idea` varchar(255) DEFAULT NULL,
  `stafftransfer_hr_idea` varchar(255) DEFAULT NULL,
  `stafftransfer_manager_idea` varchar(255) DEFAULT NULL,
  `apply_time` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`stafftransfer_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_transfer
-- ----------------------------

-- ----------------------------
-- Table structure for staff_transfer_apply
-- ----------------------------
DROP TABLE IF EXISTS `staff_transfer_apply`;
CREATE TABLE `staff_transfer_apply` (
  `transfer_id` varchar(20) NOT NULL,
  `transfer_staff_id` varchar(20) DEFAULT NULL,
  `transfer_position_name_old` varchar(20) DEFAULT NULL,
  `transfer_department_name_old` varchar(20) DEFAULT NULL,
  `transfer_position_name_new` varchar(20) DEFAULT NULL,
  `transfer_department_name_new` varchar(20) DEFAULT NULL,
  `transfer_msg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transfer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff_transfer_apply
-- ----------------------------
INSERT INTO `staff_transfer_apply` VALUES ('Transfer-1001', 'nncq0000', '管理员', '日月股份', '技术部', '主管', '被梁柳杰欺负，我要调入别的部门');
INSERT INTO `staff_transfer_apply` VALUES ('Transfer-1002', 'nncq0003', '管理员', '开发部', '456', '456', '4567');
INSERT INTO `staff_transfer_apply` VALUES ('Transfer-1003', 'nncq0003', '仅调动部门', '品管部', '仅调动部门', '日月股份', '原由信息:789<br>该申请由系统转发，双方部门已同意');
INSERT INTO `staff_transfer_apply` VALUES ('Transfer-1004', 'nncq0001', '日月股份,管理员', null, '人事部,安全员', null, '适合安全员');
INSERT INTO `staff_transfer_apply` VALUES ('Transfer-1005', 'nncq0008', '仅调动部门', '品管部', '仅调动部门', '日月股份', '原由信息:123<br>该申请由系统转发，双方部门已同意');

-- ----------------------------
-- Table structure for work_address
-- ----------------------------
DROP TABLE IF EXISTS `work_address`;
CREATE TABLE `work_address` (
  `work_address_id` varchar(20) NOT NULL,
  `work_address_name` varchar(255) NOT NULL,
  `work_address_xy` varchar(30) NOT NULL,
  `work_address_use_state` int(11) NOT NULL,
  `range_on` varchar(5) DEFAULT NULL,
  `range_value` int(11) DEFAULT NULL,
  `wifi_on` varchar(5) DEFAULT NULL,
  `wifi_mac` varchar(255) DEFAULT NULL,
  `face` varchar(5) DEFAULT NULL,
  `finger` varchar(5) DEFAULT NULL,
  `morning_start` varchar(20) DEFAULT NULL,
  `morning_end` varchar(20) DEFAULT NULL,
  `afternoon_start` varchar(20) DEFAULT NULL,
  `afternoon_end` varchar(20) DEFAULT NULL,
  `night_start` varchar(20) DEFAULT NULL,
  `night_end` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`work_address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_address
-- ----------------------------
INSERT INTO `work_address` VALUES ('W-A-1001', '柳州桂中大道 工作地点', '109.573204,24.391685', '0', 'on', '100', 'on', 'ec:26:ca:fb:db:92', 'on', 'on', '09:00:00', '12:00:00', '14:00:00', '17:30:00', '', '');
INSERT INTO `work_address` VALUES ('W-A-1002', '德润小学', '109.451385,24.319317', '0', 'on', '0', 'on', 'ec:26:ca:fb:db:92', 'on', 'on', '09:00:00', '12:00:00', '13:00:00', '17:00:00', '', '');
INSERT INTO `work_address` VALUES ('W-A-1003', '水上乐园', '109.484155,24.321688', '0', 'on', '100', null, '', null, null, '08:00:00', '11:00:00', '14:00:00', '17:00:00', '', '');
INSERT INTO `work_address` VALUES ('W-A-1004', '黄牛岭', '109.225299,24.453661', '0', 'on', '100', null, '', null, null, '08:00:00', '11:00:00', '13:00:00', '17:00:00', '', '');
INSERT INTO `work_address` VALUES ('W-A-1005', '皇娘山', '109.494948,24.342629', '0', 'on', '100', null, '', null, null, '08:00:00', '11:00:00', '13:30:00', '17:30:00', '', '');
INSERT INTO `work_address` VALUES ('W-A-1006', '甜椒', '110.303628,25.265565', '0', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `work_address` VALUES ('W-A-1007', '柳州观塘', '109.573327,24.391772', '-1', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `work_address` VALUES ('W-A-1008', '测试', '109.466117,24.310426', '-1', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `work_address` VALUES ('W-A-1009', '哈哈', '109.465111,24.318329', '-1', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `work_address` VALUES ('W-A-1010', '官塘', '109.573224,24.391686', '0', null, null, null, null, null, null, null, null, null, null, null, null);


-- ----------------------------
-- View structure for apply_staff_recruit_1
-- ----------------------------
DROP VIEW IF EXISTS `apply_staff_recruit_1`;
CREATE   VIEW `apply_staff_recruit_1` AS select `apply`.`apply_id` AS `apply_id`,`apply`.`apply_name` AS `apply_name`,`apply`.`apply_type` AS `apply_type`,`apply`.`parent_id` AS `parent_id`,`apply`.`apply_staff_id` AS `apply_staff_id`,`apply`.`check_staff_id` AS `check_staff_id`,`apply`.`apply_time` AS `apply_time`,`apply`.`check_time` AS `check_time`,`apply`.`check_state` AS `check_state`,`apply`.`check_msg` AS `check_msg`,`staff`.`staff_name` AS `apply_staff_name`,`staff`.`department_id` AS `department_id` from (`apply` join `staff`) where (`apply`.`apply_staff_id` = `staff`.`staff_id`) ;

-- ----------------------------
-- View structure for apply_staff_recruit_2
-- ----------------------------
DROP VIEW IF EXISTS `apply_staff_recruit_2`;
CREATE   VIEW `apply_staff_recruit_2` AS select `p`.`apply_id` AS `apply_id`,`p`.`apply_name` AS `apply_name`,`p`.`apply_type` AS `apply_type`,`p`.`parent_id` AS `parent_id`,`p`.`apply_staff_id` AS `apply_staff_id`,`p`.`check_staff_id` AS `check_staff_id`,`p`.`apply_time` AS `apply_time`,`p`.`check_time` AS `check_time`,`p`.`check_state` AS `check_state`,`p`.`check_msg` AS `check_msg`,`p`.`apply_staff_name` AS `apply_staff_name`,`s`.`staff_name` AS `check_staff_name`,`p`.`department_id` AS `department_id` from (`apply_staff_recruit_1` `p` left join `staff` `s` on((`p`.`check_staff_id` = `s`.`staff_id`))) ;


-- ----------------------------
-- View structure for apply_quit_view
-- ----------------------------
DROP VIEW IF EXISTS `apply_quit_view`;
CREATE   VIEW `apply_quit_view` AS select `staff_quit_apply`.`quit_department` AS `quit_department`,`staff_quit_apply`.`quit_post` AS `quit_post`,`staff_quit_apply`.`quit_time` AS `quit_time`,`staff_quit_apply`.`quit_msg` AS `quit_msg`,`apply_staff_recruit_2`.`apply_id` AS `apply_id`,`apply_staff_recruit_2`.`apply_name` AS `apply_name`,`apply_staff_recruit_2`.`apply_type` AS `apply_type`,`apply_staff_recruit_2`.`parent_id` AS `parent_id`,`apply_staff_recruit_2`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_2`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_2`.`apply_time` AS `apply_time`,`apply_staff_recruit_2`.`check_time` AS `check_time`,`apply_staff_recruit_2`.`check_state` AS `check_state`,`apply_staff_recruit_2`.`check_msg` AS `check_msg`,`apply_staff_recruit_2`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_2`.`check_staff_name` AS `check_staff_name`,`staff`.`department_id` AS `department_id` from ((`apply_staff_recruit_2` join `staff_quit_apply`) left join `staff` on((`apply_staff_recruit_2`.`apply_staff_id` = `staff`.`staff_id`))) where (`apply_staff_recruit_2`.`parent_id` = `staff_quit_apply`.`quit_id`) ;


-- ----------------------------
-- View structure for apply_evection_view
-- ----------------------------
DROP VIEW IF EXISTS `apply_evection_view`;
CREATE   VIEW `apply_evection_view` AS select `apply_staff_recruit_2`.`apply_id` AS `apply_id`,`apply_staff_recruit_2`.`apply_name` AS `apply_name`,`apply_staff_recruit_2`.`apply_type` AS `apply_type`,`apply_staff_recruit_2`.`parent_id` AS `parent_id`,`apply_staff_recruit_2`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_2`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_2`.`apply_time` AS `apply_time`,`apply_staff_recruit_2`.`check_time` AS `check_time`,`apply_staff_recruit_2`.`check_state` AS `check_state`,`apply_staff_recruit_2`.`check_msg` AS `check_msg`,`apply_staff_recruit_2`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_2`.`check_staff_name` AS `check_staff_name`,`staff_evection_apply`.`evection_acc_position` AS `evection_acc_position`,`staff_evection_apply`.`evection_acc` AS `evection_acc`,`staff_evection_apply`.`evection_vehicle` AS `evection_vehicle`,`staff_evection_apply`.`evection_start_time` AS `evection_start_time`,`staff_evection_apply`.`evection_end_time` AS `evection_end_time`,`staff_evection_apply`.`evection_path` AS `evection_path`,`staff_evection_apply`.`evection_msg` AS `evection_msg`,`staff`.`department_id` AS `department_id` from ((`apply_staff_recruit_2` join `staff_evection_apply`) left join `staff` on((`apply_staff_recruit_2`.`apply_staff_id` = `staff`.`staff_id`))) where (`apply_staff_recruit_2`.`parent_id` = `staff_evection_apply`.`evection_id`) ;

-- ----------------------------
-- View structure for apply_expense_view
-- ----------------------------
DROP VIEW IF EXISTS `apply_expense_view`;
CREATE   VIEW `apply_expense_view` AS select `apply_staff_recruit_2`.`apply_id` AS `apply_id`,`apply_staff_recruit_2`.`apply_name` AS `apply_name`,`apply_staff_recruit_2`.`apply_type` AS `apply_type`,`apply_staff_recruit_2`.`parent_id` AS `parent_id`,`apply_staff_recruit_2`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_2`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_2`.`apply_time` AS `apply_time`,`apply_staff_recruit_2`.`check_time` AS `check_time`,`apply_staff_recruit_2`.`check_state` AS `check_state`,`apply_staff_recruit_2`.`check_msg` AS `check_msg`,`apply_staff_recruit_2`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_2`.`check_staff_name` AS `check_staff_name`,`staff_expense_apply`.`expense_post` AS `expense_post`,`staff_expense_apply`.`expense_department` AS `expense_department`,`staff_expense_apply`.`expense_type` AS `expense_type`,`staff_expense_apply`.`expense_total_price` AS `expense_total_price`,`staff_expense_apply`.`expense_actual_price` AS `expense_actual_price`,`staff_expense_apply`.`expense_msg` AS `expense_msg`,`staff`.`department_id` AS `department_id` from ((`apply_staff_recruit_2` join `staff_expense_apply`) left join `staff` on((`apply_staff_recruit_2`.`apply_staff_id` = `staff`.`staff_id`))) where (`apply_staff_recruit_2`.`parent_id` = `staff_expense_apply`.`expense_id`) ;

-- ----------------------------
-- View structure for apply_leave_view
-- ----------------------------
DROP VIEW IF EXISTS `apply_leave_view`;
CREATE   VIEW `apply_leave_view` AS select `apply_staff_recruit_2`.`apply_id` AS `apply_id`,`apply_staff_recruit_2`.`apply_name` AS `apply_name`,`apply_staff_recruit_2`.`apply_type` AS `apply_type`,`apply_staff_recruit_2`.`parent_id` AS `parent_id`,`apply_staff_recruit_2`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_2`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_2`.`apply_time` AS `apply_time`,`apply_staff_recruit_2`.`check_time` AS `check_time`,`apply_staff_recruit_2`.`check_state` AS `check_state`,`apply_staff_recruit_2`.`check_msg` AS `check_msg`,`apply_staff_recruit_2`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_2`.`check_staff_name` AS `check_staff_name`,`staff_leave_apply`.`leave_type` AS `leave_type`,`staff_leave_apply`.`leave_start_time` AS `leave_start_time`,`staff_leave_apply`.`leave_end_time` AS `leave_end_time`,`staff_leave_apply`.`leave_msg` AS `leave_msg`,`staff`.`department_id` AS `department_id` from ((`apply_staff_recruit_2` join `staff_leave_apply`) left join `staff` on((`apply_staff_recruit_2`.`apply_staff_id` = `staff`.`staff_id`))) where (`apply_staff_recruit_2`.`parent_id` = `staff_leave_apply`.`leave_id`) ;

-- ----------------------------
-- View structure for apply_overtime_view
-- ----------------------------
DROP VIEW IF EXISTS `apply_overtime_view`;
CREATE   VIEW `apply_overtime_view` AS select `apply_staff_recruit_2`.`apply_id` AS `apply_id`,`apply_staff_recruit_2`.`apply_name` AS `apply_name`,`apply_staff_recruit_2`.`apply_type` AS `apply_type`,`apply_staff_recruit_2`.`parent_id` AS `parent_id`,`apply_staff_recruit_2`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_2`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_2`.`apply_time` AS `apply_time`,`apply_staff_recruit_2`.`check_time` AS `check_time`,`apply_staff_recruit_2`.`check_state` AS `check_state`,`apply_staff_recruit_2`.`check_msg` AS `check_msg`,`apply_staff_recruit_2`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_2`.`check_staff_name` AS `check_staff_name`,`staff_overtime_apply`.`overtime_department` AS `overtime_department`,`staff_overtime_apply`.`overtime_post` AS `overtime_post`,`staff_overtime_apply`.`overtime_start_time` AS `overtime_start_time`,`staff_overtime_apply`.`overtime_duration` AS `overtime_duration`,`staff_overtime_apply`.`overtime_end_time` AS `overtime_end_time`,`staff_overtime_apply`.`overtime_msg` AS `overtime_msg`,`staff`.`department_id` AS `department_id` from ((`apply_staff_recruit_2` join `staff_overtime_apply`) left join `staff` on((`apply_staff_recruit_2`.`apply_staff_id` = `staff`.`staff_id`))) where (`apply_staff_recruit_2`.`parent_id` = `staff_overtime_apply`.`overtime_id`) ;



-- ----------------------------
-- View structure for apply_staff_recruit_3
-- ----------------------------
DROP VIEW IF EXISTS `apply_staff_recruit_3`;
CREATE   VIEW `apply_staff_recruit_3` AS select `recruit`.`rel_rec_id` AS `rel_rec_id`,`recruit`.`position_id` AS `position_id`,`recruit`.`rel_rec_title` AS `rel_rec_title`,`recruit`.`rel_rec_desc` AS `rel_rec_desc`,`recruit`.`rel_rec_number` AS `rel_rec_number`,`recruit`.`rel_rec_money` AS `rel_rec_money`,`recruit`.`rel_rec_use_state` AS `rel_rec_use_state`,`apply_staff_recruit_2`.`apply_id` AS `apply_id`,`apply_staff_recruit_2`.`apply_name` AS `apply_name`,`apply_staff_recruit_2`.`apply_type` AS `apply_type`,`apply_staff_recruit_2`.`parent_id` AS `parent_id`,`apply_staff_recruit_2`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_2`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_2`.`apply_time` AS `apply_time`,`apply_staff_recruit_2`.`check_time` AS `check_time`,`apply_staff_recruit_2`.`check_state` AS `check_state`,`apply_staff_recruit_2`.`check_msg` AS `check_msg`,`apply_staff_recruit_2`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_2`.`check_staff_name` AS `check_staff_name`,`apply_staff_recruit_2`.`department_id` AS `department_id` from (`recruit` left join `apply_staff_recruit_2` on((`apply_staff_recruit_2`.`parent_id` = `recruit`.`rel_rec_id`))) ;

-- ----------------------------
-- View structure for apply_staff_recruit_position
-- ----------------------------
DROP VIEW IF EXISTS `apply_staff_recruit_position`;
CREATE   VIEW `apply_staff_recruit_position` AS select `apply_staff_recruit_3`.`rel_rec_id` AS `rel_rec_id`,`apply_staff_recruit_3`.`position_id` AS `position_id`,`apply_staff_recruit_3`.`rel_rec_title` AS `rel_rec_title`,`apply_staff_recruit_3`.`rel_rec_desc` AS `rel_rec_desc`,`apply_staff_recruit_3`.`rel_rec_number` AS `rel_rec_number`,`apply_staff_recruit_3`.`rel_rec_money` AS `rel_rec_money`,`apply_staff_recruit_3`.`rel_rec_use_state` AS `rel_rec_use_state`,`apply_staff_recruit_3`.`apply_id` AS `apply_id`,`apply_staff_recruit_3`.`apply_name` AS `apply_name`,`apply_staff_recruit_3`.`apply_type` AS `apply_type`,`apply_staff_recruit_3`.`parent_id` AS `parent_id`,`apply_staff_recruit_3`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_3`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_3`.`apply_time` AS `apply_time`,`apply_staff_recruit_3`.`check_time` AS `check_time`,`apply_staff_recruit_3`.`check_state` AS `check_state`,`apply_staff_recruit_3`.`check_msg` AS `check_msg`,`apply_staff_recruit_3`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_3`.`check_staff_name` AS `check_staff_name`,`position_table`.`position_name` AS `position_name`,`apply_staff_recruit_3`.`department_id` AS `department_id`,`department`.`department_name` AS `department_name` from ((`apply_staff_recruit_3` left join `position_table` on((`apply_staff_recruit_3`.`position_id` = `position_table`.`position_id`))) left join `department` on((`apply_staff_recruit_3`.`department_id` = `department`.`department_id`))) ;

-- ----------------------------
-- View structure for apply_transfer_view
-- ----------------------------
DROP VIEW IF EXISTS `apply_transfer_view`;
CREATE   VIEW `apply_transfer_view` AS select `apply_staff_recruit_2`.`apply_id` AS `apply_id`,`apply_staff_recruit_2`.`apply_name` AS `apply_name`,`apply_staff_recruit_2`.`apply_type` AS `apply_type`,`apply_staff_recruit_2`.`parent_id` AS `parent_id`,`apply_staff_recruit_2`.`apply_staff_id` AS `apply_staff_id`,`apply_staff_recruit_2`.`check_staff_id` AS `check_staff_id`,`apply_staff_recruit_2`.`apply_time` AS `apply_time`,`apply_staff_recruit_2`.`check_time` AS `check_time`,`apply_staff_recruit_2`.`check_state` AS `check_state`,`apply_staff_recruit_2`.`check_msg` AS `check_msg`,`apply_staff_recruit_2`.`apply_staff_name` AS `apply_staff_name`,`apply_staff_recruit_2`.`check_staff_name` AS `check_staff_name`,`staff_transfer_apply`.`transfer_position_name_old` AS `transfer_position_name_old`,`staff_transfer_apply`.`transfer_department_name_old` AS `transfer_department_name_old`,`staff_transfer_apply`.`transfer_position_name_new` AS `transfer_position_name_new`,`staff_transfer_apply`.`transfer_department_name_new` AS `transfer_department_name_new`,`staff_transfer_apply`.`transfer_msg` AS `transfer_msg`,`staff`.`department_id` AS `department_id` from ((`staff_transfer_apply` join `apply_staff_recruit_2`) left join `staff` on((`apply_staff_recruit_2`.`apply_staff_id` = `staff`.`staff_id`))) where (`apply_staff_recruit_2`.`parent_id` = `staff_transfer_apply`.`transfer_id`) ;

-- ----------------------------
-- View structure for check_detailed_staff_work_address
-- ----------------------------
DROP VIEW IF EXISTS `check_detailed_staff_work_address`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `check_detailed_staff_work_address` AS select `check_detailed`.`check_detailed_id` AS `check_detailed_id`,`check_detailed`.`check_detailed_day` AS `check_detailed_day`,`check_detailed`.`check_detailed__time1` AS `check_detailed__time1`,`check_detailed`.`check_detailed__time2` AS `check_detailed__time2`,`check_detailed`.`check_detailed__time3` AS `check_detailed__time3`,`check_detailed`.`check_detailed__time4` AS `check_detailed__time4`,`check_detailed`.`check_detailed__time5` AS `check_detailed__time5`,`check_detailed`.`check_detailed__time6` AS `check_detailed__time6`,`check_detailed`.`check_detailed_state` AS `check_detailed_state`,`staff`.`staff_name` AS `staff_name`,`work_address`.`work_address_name` AS `work_address_name`,`check_detailed`.`staff_id` AS `staff_id`,`work_address`.`morning_start` AS `morning_start`,`work_address`.`morning_end` AS `morning_end`,`work_address`.`afternoon_start` AS `afternoon_start`,`work_address`.`afternoon_end` AS `afternoon_end`,`work_address`.`night_start` AS `night_start`,`work_address`.`night_end` AS `night_end` from ((`work_address` join `check_detailed`) join `staff`) where ((`check_detailed`.`staff_id` = `staff`.`staff_id`) and (`staff`.`work_address_id` = `work_address`.`work_address_id`)) ;

-- ----------------------------
-- View structure for department_staff
-- ----------------------------
DROP VIEW IF EXISTS `department_staff`;
CREATE   VIEW `department_staff` AS select `p`.`department_id` AS `department_id`,`p`.`department_name` AS `department_name`,`p`.`department_describe` AS `department_describe`,`p`.`department_use_state` AS `department_use_state`,`p`.`parent_id` AS `parent_id`,`c`.`department_name` AS `parent_name`,ifnull(`staff`.`staff_id`,'') AS `staff_id`,ifnull(`staff`.`staff_name`,'') AS `staff_name` from ((`department` `p` left join `department` `c` on((`p`.`parent_id` = `c`.`department_id`))) left join `staff` on((`p`.`staff_id` = `staff`.`staff_id`))) ;


-- ----------------------------
-- View structure for position_post
-- ----------------------------
DROP VIEW IF EXISTS `position_post`;
CREATE   VIEW `position_post` AS select `position_table`.`position_id` AS `position_id`,`position_table`.`position_name` AS `position_name`,`position_table`.`position_msg` AS `position_msg`,`position_table`.`position_use_state` AS `position_use_state`,`post`.`post_id` AS `post_id`,`post`.`post_name` AS `post_name`,`post`.`post_msg` AS `post_msg`,`post`.`powers` AS `powers`,`post`.`post_use_state` AS `post_use_state`,`position_table`.`rank_level` AS `rank_level`,`position_table`.`salaryBase` AS `salaryBase` from (`position_table` left join `post` on((`position_table`.`post_id` = `post`.`post_id`))) ;

-- ----------------------------
-- View structure for staff_leave_apply_view
-- ----------------------------
DROP VIEW IF EXISTS `staff_leave_apply_view`;
CREATE   VIEW `staff_leave_apply_view` AS select `staff_leave_apply`.`leave_id` AS `leave_id`,`staff_leave_apply`.`leave_type` AS `leave_type`,`staff_leave_apply`.`leave_start_time` AS `leave_start_time`,`staff_leave_apply`.`leave_end_time` AS `leave_end_time`,`staff_leave_apply`.`leave_msg` AS `leave_msg`,`staff_leave_apply`.`leave_staff_id` AS `leave_staff_id`,`apply`.`check_state` AS `check_state`,`apply`.`apply_name` AS `apply_name`,`apply`.`apply_type` AS `apply_type`,`apply`.`parent_id` AS `parent_id`,`apply`.`apply_staff_id` AS `apply_staff_id`,`apply`.`check_staff_id` AS `check_staff_id`,`apply`.`apply_time` AS `apply_time`,`apply`.`check_time` AS `check_time`,`apply`.`check_msg` AS `check_msg` from (`staff_leave_apply` join `apply`) where (`apply`.`parent_id` = `staff_leave_apply`.`leave_id`) ;

-- ----------------------------
-- View structure for staff_month_check_staff
-- ----------------------------
DROP VIEW IF EXISTS `staff_month_check_staff`;
CREATE   VIEW `staff_month_check_staff` AS select `staff_month_check`.`month` AS `month`,`staff_month_check`.`staff_id` AS `staff_id`,`staff_month_check`.`absence` AS `absence`,`staff_month_check`.`late` AS `late`,`staff_month_check`.`early` AS `early`,`staff_month_check`.`attendance` AS `attendance`,`staff_month_check`.`attendance_need` AS `attendance_need`,`staff`.`staff_name` AS `staff_name`,`staff_month_check`.`staff_leave` AS `staff_leave` from (`staff_month_check` join `staff`) where (`staff_month_check`.`staff_id` = `staff`.`staff_id`) ;


-- ----------------------------
-- View structure for staff_position
-- ----------------------------
DROP VIEW IF EXISTS `staff_position`;
CREATE   VIEW `staff_position` AS select `position_table`.`position_id` AS `position_id`,`position_table`.`position_name` AS `position_name`,`staff`.`staff_id` AS `staff_id`,`staff`.`staff_name` AS `staff_name`,`staff`.`department_id` AS `department_id`,`position_table`.`position_use_state` AS `position_use_state`,`post`.`powers` AS `powers`,`staff`.`staff_person_picture` AS `staff_person_picture`,`department`.`department_name` AS `department_name`,`position_table`.`rank_level` AS `rank_level`,`staff`.`staff_state` AS `staff_state` from (((`staff` join `position_table` on((`staff`.`position_id` = `position_table`.`position_id`))) join `post` on((`position_table`.`post_id` = `post`.`post_id`))) join `department`) where (`staff`.`department_id` = `department`.`department_id`) ;

-- ----------------------------
-- View structure for staff_position_department_work_address
-- ----------------------------
DROP VIEW IF EXISTS `staff_position_department_work_address`;
CREATE   VIEW `staff_position_department_work_address` AS select `staff`.`staff_id` AS `staff_id`,`staff`.`staff_name` AS `staff_name`,`staff`.`staff_birthday` AS `staff_birthday`,`staff`.`staff_certificates_type` AS `staff_certificates_type`,`staff`.`staff_certificates_number` AS `staff_certificates_number`,`staff`.`staff_sex` AS `staff_sex`,`staff`.`staff_address` AS `staff_address`,`staff`.`staff_phone` AS `staff_phone`,`staff`.`staff_email` AS `staff_email`,`staff`.`staff_in_date` AS `staff_in_date`,`staff`.`staff_education` AS `staff_education`,`staff`.`staff_idcard_picture_one` AS `staff_idcard_picture_one`,`staff`.`staff_idcard_picture_tow` AS `staff_idcard_picture_tow`,`staff`.`staff_person_picture` AS `staff_person_picture`,`staff`.`staff_state` AS `staff_state`,`staff`.`position_id` AS `position_id`,`staff`.`department_id` AS `department_id`,`staff`.`work_address_id` AS `work_address_id`,`staff`.`staff_msg` AS `staff_msg`,`work_address`.`work_address_name` AS `work_address_name`,`department`.`department_name` AS `department_name`,`position_table`.`position_name` AS `position_name`,`staff`.`staff_type` AS `staff_type`,`staff`.`staff_marriage` AS `staff_marriage` from (((`staff` left join `work_address` on((`staff`.`work_address_id` = `work_address`.`work_address_id`))) left join `department` on((`staff`.`department_id` = `department`.`department_id`))) left join `position_table` on((`staff`.`position_id` = `position_table`.`position_id`))) ;



-- ----------------------------
-- View structure for staff_pay_history
-- ----------------------------
DROP VIEW IF EXISTS `staff_pay_history`;
CREATE   VIEW `staff_pay_history` AS select `mypay`.`actual_pay` AS `actual_pay`,`staff_position_department_work_address`.`staff_name` AS `staff_name`,`staff_position_department_work_address`.`staff_id` AS `staff_id`,`staff_position_department_work_address`.`work_address_name` AS `work_address_name`,`staff_position_department_work_address`.`department_name` AS `department_name`,`staff_position_department_work_address`.`position_name` AS `position_name`,`mypay`.`mypay_moth` AS `mypay_moth`,`mypay`.`mypay_time` AS `mypay_time` from (`mypay` left join `staff_position_department_work_address` on((`staff_position_department_work_address`.`staff_id` = `mypay`.`mypay_staff_id`))) where ((`staff_position_department_work_address`.`staff_state` = '在职') and (`mypay`.`mypay_time` is not null)) ;


-- ----------------------------
-- View structure for staff_pay
-- ----------------------------
DROP VIEW IF EXISTS `staff_pay`;
CREATE   VIEW `staff_pay` AS select `mypay`.`actual_pay` AS `actual_pay`,`staff_position_department_work_address`.`staff_id` AS `staff_id`,`staff_position_department_work_address`.`work_address_name` AS `work_address_name`,`staff_position_department_work_address`.`department_name` AS `department_name`,`staff_position_department_work_address`.`position_name` AS `position_name`,`staff_position_department_work_address`.`staff_name` AS `staff_name`,`mypay`.`mypay_time` AS `mypay_time`,substring_index(group_concat(`mypay`.`mypay_moth` order by `mypay`.`mypay_moth` DESC separator ','),',',1) AS `mypay_moth` from (`staff_position_department_work_address` left join `mypay` on((`staff_position_department_work_address`.`staff_id` = `mypay`.`mypay_staff_id`))) where (`staff_position_department_work_address`.`staff_state` = '在职') group by `staff_position_department_work_address`.`staff_id` ;



-- ----------------------------
-- View structure for performance_view
-- ----------------------------
DROP VIEW IF EXISTS `performance_view`;
CREATE   VIEW `performance_view` AS select `staff_position_department_work_address`.`staff_id` AS `staff_id`,`staff_position_department_work_address`.`staff_name` AS `staff_name`,`staff_position_department_work_address`.`staff_sex` AS `staff_sex`,`staff_position_department_work_address`.`staff_phone` AS `staff_phone`,`staff_position_department_work_address`.`department_name` AS `department_name`,`staff_position_department_work_address`.`position_name` AS `position_name`,`staff_position_department_work_address`.`work_address_name` AS `work_address_name`,`performance`.`performance` AS `performance`,`performance`.`month` AS `month`,`staff_position_department_work_address`.`department_id` AS `department_id` from (`performance` left join `staff_position_department_work_address` on((`staff_position_department_work_address`.`staff_id` = `performance`.`staff_id`))) where (`staff_position_department_work_address`.`staff_state` = '在职') ;


-- ----------------------------
-- View structure for staff_work_address
-- ----------------------------
DROP VIEW IF EXISTS `staff_work_address`;
CREATE   VIEW `staff_work_address` AS select `work_address`.`work_address_id` AS `work_address_id`,`work_address`.`work_address_name` AS `work_address_name`,`work_address`.`work_address_xy` AS `work_address_xy`,`work_address`.`work_address_use_state` AS `work_address_use_state`,`work_address`.`range_on` AS `range_on`,`work_address`.`range_value` AS `range_value`,`work_address`.`wifi_on` AS `wifi_on`,`work_address`.`wifi_mac` AS `wifi_mac`,`work_address`.`face` AS `face`,`work_address`.`finger` AS `finger`,`work_address`.`morning_start` AS `morning_start`,`work_address`.`morning_end` AS `morning_end`,`work_address`.`afternoon_start` AS `afternoon_start`,`work_address`.`afternoon_end` AS `afternoon_end`,`work_address`.`night_start` AS `night_start`,`work_address`.`night_end` AS `night_end`,`staff`.`staff_id` AS `staff_id` from (`staff` join `work_address`) where (`staff`.`work_address_id` = `work_address`.`work_address_id`) ;

-- ----------------------------
-- View structure for transfer_staff_view
-- ----------------------------
DROP VIEW IF EXISTS `transfer_staff_view`;
CREATE   VIEW `transfer_staff_view` AS select `admin_transfer_staff`.`id` AS `id`,`admin_transfer_staff`.`department_id` AS `department_id`,`admin_transfer_staff`.`object_department_id` AS `object_department_id`,`admin_transfer_staff`.`staff_id` AS `staff_id`,`admin_transfer_staff`.`apply_staff_id` AS `apply_staff_id`,`admin_transfer_staff`.`object_staff_id` AS `object_staff_id`,`admin_transfer_staff`.`transfer_type` AS `transfer_type`,`admin_transfer_staff`.`msg` AS `msg`,`admin_transfer_staff`.`state` AS `state`,`staff`.`staff_name` AS `apply_staff_name`,`p`.`staff_name` AS `staff_name`,`department`.`department_name` AS `department_name`,`d2`.`department_name` AS `object_department_name` from ((((`admin_transfer_staff` left join `staff` on((`admin_transfer_staff`.`apply_staff_id` = `staff`.`staff_id`))) left join `staff` `p` on((`admin_transfer_staff`.`staff_id` = `p`.`staff_id`))) left join `department` on((`admin_transfer_staff`.`department_id` = `department`.`department_id`))) left join `department` `d2` on((`admin_transfer_staff`.`object_department_id` = `d2`.`department_id`))) ;

-- ----------------------------
-- View structure for work_add_prop
-- ----------------------------
DROP VIEW IF EXISTS `work_add_prop`;
CREATE   VIEW `work_add_prop` AS select `staff_work_address`.`work_address_name` AS `name`,count(`staff_work_address`.`work_address_name`) AS `value` from `staff_work_address` group by `staff_work_address`.`work_address_id` ;



-- ----------------------------
-- Function structure for getChildList
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildList`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `getChildList`(rootId varchar(100)) RETURNS varchar(2000) CHARSET utf8
BEGIN   
DECLARE str varchar(2000);  
DECLARE cid varchar(100);   
SET str = '$';   
SET cid = rootId;   
WHILE cid is not null DO   
    SET str = concat(str, ',', cid);   
    SELECT group_concat(department_id) INTO cid FROM department where FIND_IN_SET(parent_id, cid) > 0;   
END WHILE;   
RETURN str;   
END
;;
DELIMITER ;


-- ----------------------------
-- View structure for age_prop
-- ----------------------------
DROP VIEW IF EXISTS `age_prop1`;
CREATE   VIEW `age_prop1` AS select (case when ((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) <= 18) then '0-18' when (((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) > 18) and ((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) <= 22)) then '19-22' when (((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) > 22) and ((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) <= 25)) then '23-25' when (((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) > 25) and ((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) <= 30)) then '26-30' when (((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) > 30) and ((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) <= 40)) then '31-40' when ((date_format(from_days((to_days(now()) - to_days(`sun_moon`.`staff`.`staff_birthday`))),'%Y') + 0) > 40) then '40以上' end) AS `name` from `sun_moon`.`staff` where (`sun_moon`.`staff`.`staff_state` = '在职');


-- ----------------------------
-- View structure for age_prop
-- ----------------------------
DROP VIEW IF EXISTS `age_prop`;
CREATE   VIEW `age_prop` AS select `name` AS `name`,count(`name`) AS `value` from `age_prop1`  group by `name` ;

-- ----------------------------
-- View structure for pay_prop
-- ----------------------------
DROP VIEW IF EXISTS `pay_prop1`;
CREATE   VIEW `pay_prop1` AS select (case when (`sun_moon`.`mypay`.`actual_pay` <= 1600) then '0-1600' when ((`sun_moon`.`mypay`.`actual_pay` > 1600) and (`sun_moon`.`mypay`.`actual_pay` <= 3200)) then '1600-3200' when ((`sun_moon`.`mypay`.`actual_pay` > 3200) and (`sun_moon`.`mypay`.`actual_pay` <= 5000)) then '3200-5000' when ((`sun_moon`.`mypay`.`actual_pay` > 5000) and (`sun_moon`.`mypay`.`actual_pay` <= 8000)) then '5000-8000' when ((`sun_moon`.`mypay`.`actual_pay` > 8000) and (`sun_moon`.`mypay`.`actual_pay` <= 12000)) then '8000-12000' when ((`sun_moon`.`mypay`.`actual_pay` > 12000) and (`sun_moon`.`mypay`.`actual_pay` <= 20000)) then '12000-2000' when (`sun_moon`.`mypay`.`actual_pay` > 20000) then '20000以上' end) AS `name` from `sun_moon`.`mypay` where (`sun_moon`.`mypay`.`mypay_moth` = convert(concat(concat(year(curdate()),'-'),month((curdate() + interval -(1) month))) using utf8));


-- ----------------------------
-- View structure for pay_prop
-- ----------------------------
DROP VIEW IF EXISTS `pay_prop`;
CREATE   VIEW `pay_prop` AS select `name`, count(`name`) AS `value` from `pay_prop1`;
