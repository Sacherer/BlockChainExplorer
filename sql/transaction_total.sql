SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transaction_detail
-- ----------------------------
DROP TABLE IF EXISTS `transaction_detail`;
CREATE TABLE `transaction_detail`
(
  `tx_detail_id` bigint(20) not null auto_increment,
  `txid`         char(64)   NOT NULL,
  `address`      varchar(70),
  `type`         tinyint,
  `amount`       double,
  PRIMARY KEY (`tx_detail_id`),
  index `idx_txid` (`txid`),
  index `idx_address` (`address`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;