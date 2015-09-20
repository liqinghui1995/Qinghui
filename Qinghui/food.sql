/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : food

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2015-09-20 18:57:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aaa`
-- ----------------------------
DROP TABLE IF EXISTS `aaa`;
CREATE TABLE `aaa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` date DEFAULT NULL,
  `dname` varchar(20) DEFAULT NULL,
  `DiningRoomAddress` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aaa
-- ----------------------------
INSERT INTO `aaa` VALUES ('1', null, 'name0', 'address0');
INSERT INTO `aaa` VALUES ('2', null, 'name1', 'address1');
INSERT INTO `aaa` VALUES ('3', null, 'name2', 'address2');
INSERT INTO `aaa` VALUES ('4', null, 'name3', 'address3');
INSERT INTO `aaa` VALUES ('5', null, 'name4', 'address4');
INSERT INTO `aaa` VALUES ('6', null, 'name5', 'address5');
INSERT INTO `aaa` VALUES ('7', null, 'name0', 'address0');
INSERT INTO `aaa` VALUES ('8', null, 'name1', 'address1');
INSERT INTO `aaa` VALUES ('9', null, 'name2', 'address2');
INSERT INTO `aaa` VALUES ('10', null, 'name3', 'address3');
INSERT INTO `aaa` VALUES ('11', null, 'name4', 'address4');
INSERT INTO `aaa` VALUES ('12', null, 'name5', 'address5');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_name` varchar(20) DEFAULT NULL,
  `cart_price` varchar(20) DEFAULT NULL,
  `cart_number` varchar(20) DEFAULT NULL,
  `cart_alll` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `diningroom`
-- ----------------------------
DROP TABLE IF EXISTS `diningroom`;
CREATE TABLE `diningroom` (
  `DiningRoomStartPrice` int(11) NOT NULL,
  `DiningRoomSold` int(11) NOT NULL,
  `DiningRoomCurrentDistance` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DiningRoomName` varchar(20) DEFAULT NULL,
  `DiningRoomAddress` varchar(20) DEFAULT NULL,
  `DiningRoomImage` varchar(50) DEFAULT NULL,
  `DiningRoomLevel` varchar(50) DEFAULT NULL,
  `DiningRoomClasses` varchar(50) DEFAULT NULL,
  `DiningRoomFreight` varchar(50) DEFAULT NULL,
  `DiningRoomSendTime` varchar(50) DEFAULT NULL,
  `DiningRoomUserAppraise` varchar(50) DEFAULT NULL,
  `DiningRoomActivityFavorable` varchar(50) DEFAULT NULL,
  `DiningRoomIDPhoto` varchar(50) DEFAULT NULL,
  `DiningRoomShopHours` varchar(50) DEFAULT NULL,
  `DiningRoomIntroduce` varchar(50) DEFAULT NULL,
  `DiningRoomConn` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diningroom
-- ----------------------------
INSERT INTO `diningroom` VALUES ('14', '26', '1', '1', '食也佳', '上地', 'syj.jpg', 'xing.PNG', '中餐简餐', '免费', '26-46分', '', '在线支付满50立减25', 'zhenJ1.jpg', '08:00-20:30', '多谢您的支持与厚爱，食也佳尽心尽力为您服务！', null);
INSERT INTO `diningroom` VALUES ('20', '135', '1', '2', '贝波熊', '海淀区 上地八街与上地东路交叉口', 'bei.jpg', 'xing.PNG', '中餐简餐', '免费', '30-50分', null, '在线支付满50立减25，满30减15', 'zhenJ2.jpg', '08:00-22:00', '主要美食有照烧鸡米饭、土豆牛肉饭、米饭、每份盖饭加2元,送', null);
INSERT INTO `diningroom` VALUES ('15', '4', '1', '3', '平记桂林米粉', '北京市海淀区上地西路21号', 'bei.jpg', 'xing.PNG', '中餐西餐', '免费', '27-47分', '', '餐厅支持在线支付', 'zhenJ1.jpg', '08:00-22:00', '感谢亲的支持，为了不耽误亲们的就餐时间。', null);
INSERT INTO `diningroom` VALUES ('20', '12', '2', '4', '爱尚饭', '上地东路', 'shang.jpg', 'xing.PNG', '川菜', '免费', '30-50分', null, '餐厅支持在线支付在线支付满50立减25', 'zhenJ2.jpg', '08:00-22:00', '爱尚饭,爱尚饭单人餐,仅售15.8元,市场价最高18元的爱尚饭单人餐,节假日通用,轻松一刻,美食同享', null);
INSERT INTO `diningroom` VALUES ('10', '17', '2', '5', '立旺桂林米粉（辉煌国际）', '上地十街辉煌国际地下美食城', 'bei.jpg', 'xing.PNG', '中餐西餐', '免费', '30-50分', '', '餐厅支持在线支付', 'zhenJ2.jpg', '10:00-20:00', '本店推荐您在“外卖超人”订餐--饭点较忙，本店优先配送网上订单', null);
INSERT INTO `diningroom` VALUES ('30', '338', '4', '6', '湘正府大碗饭', '上地东路', 'xiang.jpg', 'xing.PNG', '湘菜', '免费', '30-50分', null, '在线支付满50立减25', 'zhenJ1.jpg', '08:00-22:00', '湘正府大碗饭 百度糯米至低折扣!日料 自助 随时可以退!', null);
INSERT INTO `diningroom` VALUES ('15', '27', '3', '7', '别人家紫菜包饭', '上地南路公交站东51米', 'bei.jpg', 'xing.PNG', '日韩料理', '免费', '30-50分', '', '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-20:00', '每一份都是厨娘纯手工现做，午餐请在11点前下单，送餐时间会更准时哦。谢谢~', null);
INSERT INTO `diningroom` VALUES ('20', '165', '2', '8', '果麦', '辉煌国际美食广场', 'guo.jpg', 'xing.PNG', '饮料小吃', '免费', '44-64分', null, '餐厅支持在线支付在线支付满50立减25', 'zhenJ2.jpg', '09:00-22:00', '果麦De鲜饮创作(...来欧美汇吃饭,等餐的时候去买了果麦', null);
INSERT INTO `diningroom` VALUES ('20', '3', '4', '9', '辣溢有道', '清河三街72号2号楼1层南起第2间', 'la.jpg', 'xing.PNG', '川菜', '￥3', '44-64分', null, '餐厅支持在线支付在线支付满50立减25', 'zhenJ1.jpg', '10:00-23:59', '尊敬的顾客您好  为了保证您用餐愉快  请您提前订餐我们承诺1个小时内保证送达', null);
INSERT INTO `diningroom` VALUES ('100', '542', '5', '10', '蜜芙烘焙', '北京西站', 'bei.jpg', 'xing.PNG', '西式糕点', '免费', '25-30分', null, '在线支付满50立减35', 'zhenJ1.jpg', '10:00-23:59', '感谢亲的支持，为了不耽误亲们的就餐时间。', null);
INSERT INTO `diningroom` VALUES ('80', '98', '10', '11', '麻库&麻辣小龙虾（北京）', '中关村东路智财大厦', 'maku.jpg', 'xing.PNG', '生鲜', '￥10', '34-54分', null, '在线支付满30立减15', 'zhenJ1.jpg', '10:00-14:00  15:00-23:00', '为确保口感，每份订单都出单现做，制作和配送都需要时间，希望客官们提前1-2小时下单哦~', null);
INSERT INTO `diningroom` VALUES ('101', '541', '6', '12', '龙虾物语', '北京北站', 'bei.jpg', 'xing.PNG', '中餐', '免费', '10-27分', null, '在线支付满45立减16', 'zhenJ1.jpg', '10:00-23:59', '好吃不贵', null);
INSERT INTO `diningroom` VALUES ('20', '514', '1', '13', '吉香斋黄焖鸡米饭', '北京市海淀区上地东路群英科技园东门对面', 'men.jpg', 'xing.PNG', '中餐简餐', '免费', '18-38分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-21:00', '为了能及时用餐，希望大家提前一个小时以上预订。避免高峰', null);
INSERT INTO `diningroom` VALUES ('102', '543', '7', '14', '人民公社', '五道口', 'bei.jpg', 'xing.PNG', '中餐', '免费', '27-47分', null, '在线支付满50立减25', 'zhenJ1.jpg', '10:00-23:59', '口感一流 ', null);
INSERT INTO `diningroom` VALUES ('70', '348', '12', '15', '小鲜肉', '北京朝阳区媒体村天畅园2号楼', 'bei.jpg', 'xing.PNG', '饮料小吃', '￥5', '27-47分', null, '在线支付满50立减25', 'zhenJ1.jpg', '10:00-23:59', '每日海鲜海南空运到货椰子', null);
INSERT INTO `diningroom` VALUES ('103', '544', '6', '16', '饭工厂', '五道口', 'bei.jpg', 'xing.PNG', '中餐', '免费', '15分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-23:59', '良心饭菜好吃不贵', null);
INSERT INTO `diningroom` VALUES ('30', '46', '3', '17', '鑫卖家', '北京市海淀区安宁庄前街东口', 'bei.jpg', 'xing.PNG', '中餐西餐', '￥3', '40-60分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-23:59', '刚刚上线···望大家多多支持！良心外卖 家的味道', null);
INSERT INTO `diningroom` VALUES ('104', '545', '6', '18', '雷的披萨', '五道口', 'bei.jpg', 'xing.PNG', '西式快餐', '免费', '10-20分', null, '在线支付满50立减25', 'zhenJ1.jpg', '10:00-23:59', '您的满意才是我们的最大的快乐', null);
INSERT INTO `diningroom` VALUES ('0', '29', '3', '19', '相聚时刻', '上地马连洼北路1号院1号楼商铺', 'bei.jpg', 'xing.PNG', '中餐西餐', '￥2', '30-50分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-23:59', '本店推荐您在“外卖超人”订餐--饭点较忙', null);
INSERT INTO `diningroom` VALUES ('105', '546', '3', '20', '叮当快餐', '五道口', 'bei.jpg', 'xing.PNG', '中式快餐', '免费', '15分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '9:00-18：00', '您的关注是我们动力', null);
INSERT INTO `diningroom` VALUES ('20', '7', '563', '21', '有吃有喝', '上地西路与上地六街交叉口', 'bei.jpg', 'xing.PNG', '中餐西餐', '免费', '30-50分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-23:00', '本店推荐用外卖超人订餐，饭点较忙，电话长占线，本店优先配送网上订单', null);
INSERT INTO `diningroom` VALUES ('106', '547', '3', '22', '樱之花', '五道口', 'bei.jpg', 'xing.PNG', '日韩料理', '免费', '20-30分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '9:00-18：00', '多谢您的支持与厚爱，食也佳尽心尽力为您服务！', null);
INSERT INTO `diningroom` VALUES ('128', '242', '13', '23', '辣妹龙虾', '朝阳区媒体村天畅园2号楼', 'bei.jpg', 'xing.PNG', '中餐西餐', '￥10', '50-70分', null, '在线支付满30立减15', 'zhenJ1.jpg', '10:00-23:59', '本店推荐您在“外卖超人” 订餐--饭店较忙，电话长占线，本店优先配送网上订单', null);
INSERT INTO `diningroom` VALUES ('107', '548', '3', '24', '梦路 ', '五道口', 'bei.jpg', 'xing.PNG', '中式简餐', '免费', '40分', null, '在线支付满50立减25', 'zhenJ1.jpg', '10:00-23:59', '好吃不贵', null);
INSERT INTO `diningroom` VALUES ('0', '29', '25', '25', '米芾精品', '上地', 'bei.jpg', 'xing.PNG', '中餐西餐', '免费', '30-40分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-23:59', '随时随地，想吃吃，想喝喝', null);
INSERT INTO `diningroom` VALUES ('108', '549', '2', '26', '芙蓉社', '五道口', 'bei.jpg', 'xing.PNG', '中餐', '免费', '30分', null, '在线支付满50立减30', 'zhenJ1.jpg', '9:00-18：00', '吃饱喝好 ', null);
INSERT INTO `diningroom` VALUES ('20', '1', '533', '27', '好吃鲜饺子馆', '上地五街建材城', 'bei.jpg', 'xing.PNG', '中餐西餐', '免费', '30分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '10:00-23:59', '本店推荐“外卖超人” 订餐--饭店较忙，电话长占线，本店优先配送网上订单。', null);
INSERT INTO `diningroom` VALUES ('109', '550', '2', '28', '乐天快餐', '五道口 ', 'bei.jpg', 'xing.PNG', '中式简餐', '免费', '20-30分', null, '餐厅支持在线支付', 'zhenJ1.jpg', '9:00-18：00', '刚刚上线···望大家多多支持', null);
INSERT INTO `diningroom` VALUES ('10', '30', '2', '29', '健康午餐', '上地7街', 'la.jpg', 'xing.PNG', '中餐西餐', '免费', '30分', null, '餐厅支持在线支付', null, '10:00-23:59', '请在11：00前下订单。', null);
INSERT INTO `diningroom` VALUES ('110', '551', '3', '30', '小清泉', '五道口', 'la.jpg', 'xing.PNG', '中式简餐', '免费', '20-30分', null, '在线支付满50立减15', null, '9:00-18：00', '好吃 简单味道很棒', null);

-- ----------------------------
-- Table structure for `homeviewimg`
-- ----------------------------
DROP TABLE IF EXISTS `homeviewimg`;
CREATE TABLE `homeviewimg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `viewpagerurl` varchar(20) DEFAULT NULL,
  `imgurl` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of homeviewimg
-- ----------------------------
INSERT INTO `homeviewimg` VALUES ('1', 'images/view1.png', null);
INSERT INTO `homeviewimg` VALUES ('2', 'images/view2.png', null);

-- ----------------------------
-- Table structure for `nourishmentfood`
-- ----------------------------
DROP TABLE IF EXISTS `nourishmentfood`;
CREATE TABLE `nourishmentfood` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `food_name` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `food_price` double DEFAULT NULL,
  `sales_volume` int(11) DEFAULT NULL,
  `flag` varchar(20) DEFAULT NULL,
  `foodintro` varchar(255) DEFAULT NULL,
  `shop_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nourishmentfood
-- ----------------------------
INSERT INTO `nourishmentfood` VALUES ('2', '春饼', 'chunbing_Spring.jpg', '12', '19', '0', '春天你居然不吃春饼', '2');
INSERT INTO `nourishmentfood` VALUES ('3', '韭菜炒鸡蛋', 'jiucai_Spring.jpg', '13', '22', '0', '提高免疫力。调低血压，缓冲贫血', '3');
INSERT INTO `nourishmentfood` VALUES ('4', '芹菜粥', 'qincaizhou_Spring.jpg', '8', '21', '0', '平肝清热，止咳，健胃，降压降脂', '13');
INSERT INTO `nourishmentfood` VALUES ('5', '鲫鱼豆腐汤', 'jiyudoufutang_Spring.jpg', '30', '6', '0', '配用豆腐，益气养血、健脾宽中，豆腐亦富有营养，含蛋白质较高', '17');
INSERT INTO `nourishmentfood` VALUES ('6', '凉拌香椿', 'liangbanxiangchun_Spring.jpg', '12', '42', '1', '开胃健脾,抗衰老,美容,清热利湿', '1');
INSERT INTO `nourishmentfood` VALUES ('7', '蓑衣黄瓜-清凉一夏', 'douchipaigu_Summer.jpg', '12', '33', '1', '软嫩滑爽，香脆可口', '1');
INSERT INTO `nourishmentfood` VALUES ('8', '夏季烤箱菜-烤鸭胸', 'kaoyaxiong_Summer.jpg', '40', '11', '1', '适用于体内有热、上火的人食用；发低热、体质虚弱、食欲不振、大便干燥和水肿的人，食之更佳', '1');
INSERT INTO `nourishmentfood` VALUES ('9', '金盏虾仁-清淡肉食', 'xiaren_Summer.jpg', '34', '29', '1', '壮阳益肾,通乳,滋补,补充多种营养', '1');
INSERT INTO `nourishmentfood` VALUES ('10', '夏季驱蚊祖传秘方菜', 'quwen_Summer.jpg', '20', '2', '1', '清除蚊子没烦恼,效果媲美蚊香', '1');
INSERT INTO `nourishmentfood` VALUES ('11', '开胃餐-韩国泡菜锅', 'hanguopaocai_Summer.jpg', '30', '23', '1', '增进人体骨质健康和预防贫血的作用', '1');
INSERT INTO `nourishmentfood` VALUES ('12', '豉汁蒸排骨-夏季蒸菜', 'douchipaigu_Summer.jpg', '25', '30', '1', '适宜于气血不足，阴虚纳差者。', '1');
INSERT INTO `nourishmentfood` VALUES ('13', '香菇鸡汤', 'xianggujitang_Fall.jpg', '30', '11', '2', '温中益气、补虚填精、健脾胃、活血脉、强筋骨的功效', '1');
INSERT INTO `nourishmentfood` VALUES ('14', '芹菜鸡胗', 'qincaijizhen_Fall.png', '28', '33', '2', '用于饮食积滞，小儿疳积。鸡胗有较强的消食化积作用，并能健运脾胃。', '1');
INSERT INTO `nourishmentfood` VALUES ('15', '南北杏润肺汤', 'runfeirang_Fall.png', '19', '18', '2', '润肺化痰、清热解毒,滋阴强肾，提高自身免疫力润肺化痰、清热解毒,滋阴强肾，提高自身免疫力', '1');
INSERT INTO `nourishmentfood` VALUES ('16', '茄泥蛋黄面', 'qienidanhuangmian_Fall.png', '20', '33', '2', '有助于清热解暑，对于容易长痱子、生疮疖的人，尤为适宜', '1');
INSERT INTO `nourishmentfood` VALUES ('17', '鲜蚝包菜面', 'xianhaobaocaimian_Fall.png', '38', '24', '2', '平肝潜阳，镇惊安神，软坚散结，收敛固涩', '1');
INSERT INTO `nourishmentfood` VALUES ('18', '干煎小黄鱼', 'ganjianxiaohuangyu_Fall.png', '40', '5', '2', '性味甘平,具有补虚益精,调中止痢之功效;用于久病体虚,神疲力乏及痢疾', '1');
INSERT INTO `nourishmentfood` VALUES ('19', '开胃拌黄瓜', 'kaiweibanhuanggua_Fall.png', '8', '13', '2', '除热，利水，解毒，清热利尿', '1');
INSERT INTO `nourishmentfood` VALUES ('20', '酸豆角炒肉末', 'jidanchaoxiaren_Winter.jpg', '22', '39', '2', '头脑清晰，有解渴健脾、益气生津', '1');
INSERT INTO `nourishmentfood` VALUES ('21', '猪肉白菜豆腐炖粉皮', 'zhuyoudunfentiao_Winter.jpg', '50', '14', '3', '改善缺铁性贫血;具有补肾养血，滋阴润燥的功效', '1');
INSERT INTO `nourishmentfood` VALUES ('22', '青红萝卜焖牛肉', 'qinghongluobodunniurou_Winter.jpg', '27', '43', '3', '补铁小能手 帮忙增强免疫力', '1');
INSERT INTO `nourishmentfood` VALUES ('23', '鸡蛋炒虾仁', 'jidanchaoxiaren_Winter.jpg', '20', '66', '3', '滋阴强肾，提高自身免疫力壮阳益肾,', '1');
INSERT INTO `nourishmentfood` VALUES ('24', '四喜丸子', 'sixiwanzi_Winter.jpg', '25', '32', '3', '活血脉、强筋骨的功效', '1');
INSERT INTO `nourishmentfood` VALUES ('25', '酱烧排骨', 'jiangshaopaigu_Winter.jpg', '28', '30', '3', '增进人体骨质健康和预防贫血的作用', '1');
INSERT INTO `nourishmentfood` VALUES ('26', '碗蒸肉（扣肉)', 'kourou_Winter.jpg', '30', '20', '3', '平肝清热，止咳，健胃，软糯不油腻', '1');
INSERT INTO `nourishmentfood` VALUES ('27', '土豆炖牛肉 ', 'tudoudunniurou_D.jpg', '30', '16', '4', '荤素搭配，要啥有啥！', '1');
INSERT INTO `nourishmentfood` VALUES ('28', '小鸡炖蘑菇', 'xiaojidunmogu_D.jpg', '25', '22', '4', ' 传统经典美味。', '1');
INSERT INTO `nourishmentfood` VALUES ('29', '干锅手撕包菜', 'ganguoshousibao_D.jpg', '18', '20', '4', '上手才有感觉啊！', '1');
INSERT INTO `nourishmentfood` VALUES ('30', '木瓜炖排骨', 'muguapaigu_D.jpg', '20', '8', '4', ' 改善口味，木瓜哦~>O<！', '1');
INSERT INTO `nourishmentfood` VALUES ('31', '萝卜炖羊肉', 'luobodunyangrou_D.jpg', '25', '5', '4', ' 有菜有肉，还怕不够？', '1');
INSERT INTO `nourishmentfood` VALUES ('32', '凉拌香辣土豆片       ', 'liangbanxianglatudoupian_D.jpg', '18', '13', '4', '凉？不，要辣！', '1');
INSERT INTO `nourishmentfood` VALUES ('33', '干炒牛河 ', 'gancaoniuhe_D.jpg', '15', '33', '4', ' 新菜品，错过就是过错啊！', '1');
INSERT INTO `nourishmentfood` VALUES ('34', '红烧排骨', 'hongshaopaigu_D.jpg', '25', '16', '4', '要的就是这个味！', '1');
INSERT INTO `nourishmentfood` VALUES ('35', '鲶鱼烧豆腐', 'nianyushaodoufu_D.jpg', '20', '10', '4', ' 促进营养吸收', '1');
INSERT INTO `nourishmentfood` VALUES ('36', '青椒炒木耳', 'qingjiaochaomuer_D.jpg', '18', '45', '4', '清淡，静心！', '1');
INSERT INTO `nourishmentfood` VALUES ('37', '梅菜扣肉', 'maicaikourou_D.jpg', '30', '20', '4', '来就来个肥而不腻的！\r\n来就来个肥而不腻的！\r\n 来就来个肥而不腻的！', '1');
INSERT INTO `nourishmentfood` VALUES ('38', '青椒炒腊肉', 'qingjiaochalarou_D.jpg', '20', '32', '4', '辣不是重点，不腻才是特点。', '1');
INSERT INTO `nourishmentfood` VALUES ('39', '清炒西兰花 ', 'qingchaxilanhua_D.jpg', '18', '53', '4', '软嫩滑爽，香脆可口！', '1');
INSERT INTO `nourishmentfood` VALUES ('40', '鱼香茄子煲 ', 'yuxiangqijiebao_D.jpg', '25', '16', '4', ' 清热去火的不二选择！', '1');
INSERT INTO `nourishmentfood` VALUES ('41', '地三鲜 ', 'disanxian_D.jpg', '20', '23', '4', '地地道道的鲜味！', '1');
INSERT INTO `nourishmentfood` VALUES ('42', '酸奶芝士沙拉', 'suannaizhishishala_D.jpg', '15', '39', '4', ' 保持头脑清晰，轻松一整天', '1');
INSERT INTO `nourishmentfood` VALUES ('43', '苦瓜炒蛋 ', 'kuguachaodan_D.jpg', '18', '20', '4', '   苦尽甘来 ！', '1');
INSERT INTO `nourishmentfood` VALUES ('44', '酱焖鲫鱼豆腐', 'jiangmenjiyudoufu_Y.jpg', '15', '31', '5', '优质高蛋白丰富，可使头脑保持敏锐，对理解和记忆\r\r\n功能有重要作用', '1');
INSERT INTO `nourishmentfood` VALUES ('45', '葱烧鲫鱼', 'congshaojiyu_Y.jpg', '32', '12', '5', '鲫鱼所含的蛋白质质优、易于消化吸收，鲫鱼汤不但\r\r\n味香汤鲜', '1');
INSERT INTO `nourishmentfood` VALUES ('46', '木耳肉片', 'muerroupian_Y.jpg', '13', '43', '5', '木耳中的核酸含量较为丰富', '1');
INSERT INTO `nourishmentfood` VALUES ('47', '西兰花拌木耳', 'xilanhuabanmuer_Y.jpg', '23', '42', '5', '对脾胃虚弱、水肿、溃疡有很好的治疗作用', '1');
INSERT INTO `nourishmentfood` VALUES ('48', '石榴汁银耳果冻', 'shiliuzhiyinerguodong_Y.jpg', '12', '52', '5', '可补肾、润肺、提神，对慢性支气管炎、体虚、肾虚\r\r\n都好有辅助治疗作用', '1');
INSERT INTO `nourishmentfood` VALUES ('49', '银耳红枣雪梨汤', 'yinerhongzaoxuelitang_Y.jpg', '32', '62', '5', '具有较强的滋补作用', '1');
INSERT INTO `nourishmentfood` VALUES ('50', '果粒烧汁鲈鱼', 'guolishaozhiluyu_Y.jpg', '23', '62', '5', '鲈鱼富含蛋白质、维生素A、B族维生素、钙、镁、锌', '1');
INSERT INTO `nourishmentfood` VALUES ('51', '肉末啤酒鲈鱼', 'roumopijiuluyu_Y.jpg', '23', '62', '5', '能够益肾安胎、健脾补气，可治胎动不安、生产少乳\r\r\n等症', '1');
INSERT INTO `nourishmentfood` VALUES ('52', '火腿蒸鲈鱼', 'huotuizhengluyu_Y.jpg', '23', '54', '5', '既容易消化，又能防治水肿、贫血头晕等症状', '1');
INSERT INTO `nourishmentfood` VALUES ('53', '茄汁蒸鲈鱼', 'qiezhizhengluyu_Y.jpg', '12', '53', '5', '含较多的铜元素，能保护心脏，维持神经系统的正常\r\r\n功能', '1');
INSERT INTO `nourishmentfood` VALUES ('54', '凉拌鸡丝', 'liangbanjisi_Y.jpg', '12', '53', '5', '鸡肉中蛋白质的含量较高，是优质的蛋白质来源', '1');
INSERT INTO `nourishmentfood` VALUES ('55', '凉拌鸡蛋', 'liangbanjidan_Y.jpg', '13', '65', '6', '脂肪含量较低，还有磷、铁、铜、锌、维生素等', '1');
INSERT INTO `nourishmentfood` VALUES ('56', '麻辣凉拌鸡丝', 'malaliangbanjisi_Y.jpg', '15', '65', '6', '含有对人体生长发育有重要作用的磷脂类', '1');
INSERT INTO `nourishmentfood` VALUES ('57', '凉拌鸡胗', 'liangbanjizhen_Y.jpg', '17', '66', '6', '对营养不良、畏寒怕冷、乏力疲劳、月经不调、贫血\r\r\n、虚弱等症有很好的食疗作用', '1');
INSERT INTO `nourishmentfood` VALUES ('58', '豆豉鲮鱼油麦菜', 'douchijiyuyoumaicai_Y.jpg', '16', '43', '6', '含有大量维生素和大量钙、铁、蛋白质、脂肪、维生\r\r\n素A、VB1、VB2等营养成分', '1');
INSERT INTO `nourishmentfood` VALUES ('59', '油麦菜烧豆腐', 'youmaicaishaodoufu_Y.jpg', '21', '23', '6', '具有降低胆固醇、治疗神经衰弱、清燥润肺、化痰止\r\r\n咳等功效', '1');
INSERT INTO `nourishmentfood` VALUES ('60', '葱茸油麦菜', 'congeryoumaicai_Y.jpg', '23', '65', '6', '低热量、高营养的蔬菜', '1');
INSERT INTO `nourishmentfood` VALUES ('61', '豆瓣酱香油麦菜', 'doubanjiangxiangyoumaicai_Y.jpg', '45', '65', '6', '有利于身体健康，增强抵抗力', '1');
INSERT INTO `nourishmentfood` VALUES ('62', '玉米烧排骨', 'yumishaopaigu_Y.jpg', '54', '24', '6', '可以减少或预防龋齿', '1');
INSERT INTO `nourishmentfood` VALUES ('63', '酱味鸭', 'jiangweiya_Y.jpg', '23', '65', '6', '可以不用担心血糖的升高', '1');
INSERT INTO `nourishmentfood` VALUES ('64', '鸡小腿烧土豆', 'jixiaotuishaotudou_Y.jpg', '42', '24', '6', '可以避免因吃糖而引发的乳腺癌', '1');
INSERT INTO `nourishmentfood` VALUES ('65', '糖醋小排骨', 'tangsuxiaopaigu_Y.jpg', '21', '65', '6', '可以有效减少肥胖或抑制肥胖的增加', '1');
INSERT INTO `nourishmentfood` VALUES ('66', '口水鸡', 'koushuiji_Y.jpg', '12', '23', '6', '可以避免因多吃糖导致缺乏钙而引发骨折', '1');
INSERT INTO `nourishmentfood` VALUES ('67', '盐焗虾仁', 'yanjuxiaren_Y.jpg', '32', '34', '6', '可以避免多吃糖诱发的胃炎和胃溃疡', '1');
INSERT INTO `nourishmentfood` VALUES ('68', '盐水鸭', 'yanshuiya_Y.jpg', '12', '24', '6', '温中益气、补精添髓、强筋健骨、活血调经', '1');
INSERT INTO `nourishmentfood` VALUES ('69', '盐爆里脊', 'yanbaoliji_Y.jpg', '14', '5', '7', '能使皮肤看起来光滑润泽而不易干燥粗糙', '1');
INSERT INTO `nourishmentfood` VALUES ('70', '红烧肉', 'hongshaorou_Y.jpg', '15', '24', '7', '能使皮肤富有弹性不易松驰', '1');
INSERT INTO `nourishmentfood` VALUES ('71', '盐焗鸡', 'yanjuji_Y.jpg', '16', '65', '7', '利于人体对多种维生素的吸收，防止皮肤老化\r\n  3.韭菜花炒鸭胗', '1');
INSERT INTO `nourishmentfood` VALUES ('72', '拆鱼汤浸茼蒿', 'chaiyutangjintonghao_Y.jpg', '18', '24', '7', '具有增强人体抵抗力、延缓衰老、美白皮肤等作用', '1');
INSERT INTO `nourishmentfood` VALUES ('73', '脆皮瓜花', 'cuipiguahua_Y.jpg', '15', '54', '7', '利于人体对多种维生素的吸收，防止皮肤老化', '1');
INSERT INTO `nourishmentfood` VALUES ('74', '韭菜花炒鸭胗', 'jiucaihuachaoyazhen_Y.jpg', '34', '24', '7', '可以帮助细胞修复、促进伤口的愈合', '1');
INSERT INTO `nourishmentfood` VALUES ('75', '莲藕虾仁', 'lianouxiaren_Y.jpg', '23', '24', '7', '促进骨胶原的生物合成。利于组织创伤口的更快愈合5.蘑菇沙拉', '1');
INSERT INTO `nourishmentfood` VALUES ('76', '蘑菇沙拉', 'mogushala_Y.jpg', '18', '24', '7', '促进氨基酸中酪氨酸和色氨酸的代谢，延长肌体寿命', '1');
INSERT INTO `nourishmentfood` VALUES ('77', '清炒莲藕', 'qingchaolianou_Y.jpg', '19', '24', '7', '改善铁、钙和叶酸的利用', '1');
INSERT INTO `nourishmentfood` VALUES ('78', '烧肉焖笋', 'shaoroumensun_Y.jpg', '45', '24', '7', '促进牙齿和骨骼的生长，防止牙床出血', '1');
INSERT INTO `nourishmentfood` VALUES ('79', '蒜蓉蒸丝瓜', 'suanrongzhengsigua_Y.jpg', '35', '24', '7', '增强肌体对外界环境的抗应激能力和免疫力', '1');
INSERT INTO `nourishmentfood` VALUES ('80', '火腿蒸鲈鱼', 'huotuizhengluyu_Y.jpg', '20', '54', '7', '既容易消化，又能防治水肿、贫血头晕等症状', '1');
INSERT INTO `nourishmentfood` VALUES ('81', '米饭', 'mifan.jpg', '3', '200', '8', '主食', '1');
INSERT INTO `nourishmentfood` VALUES ('82', '馒头', 'mantou.jpg', '2', '150', '8', '主食', '1');
INSERT INTO `nourishmentfood` VALUES ('83', '脉动', 'maidong.jpg', '5', '100', '9', '饮料', '1');
INSERT INTO `nourishmentfood` VALUES ('84', '营养快线', 'yingyangkuaixian.jpg', '6', '99', '9', '饮料', '1');
INSERT INTO `nourishmentfood` VALUES ('85', '王老吉', 'wanglaoji.jpg', '6', '150', '9', '饮料', '1');

-- ----------------------------
-- Table structure for `orderinfo`
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_time` varchar(20) DEFAULT NULL,
  `order_restaurant` varchar(20) DEFAULT NULL,
  `order_money` varchar(20) DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `order_info` varchar(20) DEFAULT NULL,
  `order_logo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `searchcity`
-- ----------------------------
DROP TABLE IF EXISTS `searchcity`;
CREATE TABLE `searchcity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(20) DEFAULT NULL,
  `districtid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of searchcity
-- ----------------------------
INSERT INTO `searchcity` VALUES ('1', '北京', '1');
INSERT INTO `searchcity` VALUES ('2', '天津', '2');
INSERT INTO `searchcity` VALUES ('3', '上海', '3');

-- ----------------------------
-- Table structure for `searchdistrict`
-- ----------------------------
DROP TABLE IF EXISTS `searchdistrict`;
CREATE TABLE `searchdistrict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district` varchar(20) DEFAULT NULL,
  `cityid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of searchdistrict
-- ----------------------------
INSERT INTO `searchdistrict` VALUES ('1', '五道口', '1');
INSERT INTO `searchdistrict` VALUES ('2', '西二旗', '1');
INSERT INTO `searchdistrict` VALUES ('3', '上地', '1');
INSERT INTO `searchdistrict` VALUES ('4', '塘沽', '2');
INSERT INTO `searchdistrict` VALUES ('5', '浦东', '3');

-- ----------------------------
-- Table structure for `useraddress`
-- ----------------------------
DROP TABLE IF EXISTS `useraddress`;
CREATE TABLE `useraddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of useraddress
-- ----------------------------
INSERT INTO `useraddress` VALUES ('1', '111', '1');
INSERT INTO `useraddress` VALUES ('2', '1144', '1');
INSERT INTO `useraddress` VALUES ('3', '11', '8');
INSERT INTO `useraddress` VALUES ('4', '1', '7');
INSERT INTO `useraddress` VALUES ('5', 'admin1289', '7');
INSERT INTO `useraddress` VALUES ('6', 'Version111111', '7');
INSERT INTO `useraddress` VALUES ('7', '123456', '7');
INSERT INTO `useraddress` VALUES ('8', '33333', '7');
INSERT INTO `useraddress` VALUES ('9', '4', '7');
INSERT INTO `useraddress` VALUES ('10', '66', '7');
INSERT INTO `useraddress` VALUES ('11', '', '7');
INSERT INTO `useraddress` VALUES ('12', '777', '7');
INSERT INTO `useraddress` VALUES ('13', '741', '7');

-- ----------------------------
-- Table structure for `usergift`
-- ----------------------------
DROP TABLE IF EXISTS `usergift`;
CREATE TABLE `usergift` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `imgurl` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usergift
-- ----------------------------
INSERT INTO `usergift` VALUES ('1', 'one', 'images/gift1.png', '1000');
INSERT INTO `usergift` VALUES ('2', 'two', 'images/gift2.png', '2000');
INSERT INTO `usergift` VALUES ('3', 'three', 'images/gift3.png', '3000');
INSERT INTO `usergift` VALUES ('4', 'four', 'images/gift4.png', '4000');
INSERT INTO `usergift` VALUES ('5', 'five', 'images/gift5.png', '5000');
INSERT INTO `usergift` VALUES ('6', 'six', 'images/gift6.png', '6000');

-- ----------------------------
-- Table structure for `usergiftrecord`
-- ----------------------------
DROP TABLE IF EXISTS `usergiftrecord`;
CREATE TABLE `usergiftrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `giftid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usergiftrecord
-- ----------------------------
INSERT INTO `usergiftrecord` VALUES ('1', '3', '1');
INSERT INTO `usergiftrecord` VALUES ('2', '3', '1');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_address` varchar(200) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_nickname` varchar(20) DEFAULT NULL,
  `user_coin` int(11) DEFAULT NULL,
  `user_record` int(11) DEFAULT NULL,
  `addressid` varchar(200) DEFAULT NULL,
  `ticklingid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '13241218965', '123456', null, null, '老毕', '0', '0', null, null);
INSERT INTO `userinfo` VALUES ('2', '13681476212', '123456', null, null, '13681476212', '0', '0', null, null);
INSERT INTO `userinfo` VALUES ('3', '18235043997', 'linashabi', null, null, '18235043997', '0', '0', null, null);
INSERT INTO `userinfo` VALUES ('4', '18335762760', 'lina1314', null, null, '18335762760', '0', '0', null, null);
INSERT INTO `userinfo` VALUES ('5', '15710038112', '123456', null, null, '马梓皓', '0', '0', null, null);
INSERT INTO `userinfo` VALUES ('6', '123321', '123321', null, null, '哈哈', '0', '0', null, null);
INSERT INTO `userinfo` VALUES ('7', '13269653274', '123456', null, null, '13269653274', '0', '0', null, null);
INSERT INTO `userinfo` VALUES ('8', '1', '1111111', null, null, '1', '0', '0', null, null);

-- ----------------------------
-- Table structure for `usertickling`
-- ----------------------------
DROP TABLE IF EXISTS `usertickling`;
CREATE TABLE `usertickling` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertickling
-- ----------------------------
INSERT INTO `usertickling` VALUES ('1', '1', 'asdasd', '13681476212');
INSERT INTO `usertickling` VALUES ('2', '9', 'wthjgggt', '12345');
INSERT INTO `usertickling` VALUES ('3', '9', 'wthjgggt', '12345');
INSERT INTO `usertickling` VALUES ('4', '9', 'wthjgggt', '12345');
