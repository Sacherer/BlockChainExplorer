SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blockchain
-- ----------------------------
DROP TABLE IF EXISTS `blockchain`;
CREATE TABLE `blockchain` (
  `blockchain_id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL ,
  `type` varchar(20) NOT NULL,
  `shortname` varchar(10),
  PRIMARY KEY (`blockchain_id`),
  unique `idx_name_type`(`name`,`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
INSERT INTO `blockchain` VALUES ('1', 'Bitcoin', 'testnet', 'BTCTest');
INSERT INTO `blockchain` VALUES ('2', 'Ethereum', 'main', 'ETH');