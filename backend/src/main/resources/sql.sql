USE minions;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS env;
DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS error_summary;
DROP TABLE IF EXISTS summary;
DROP TABLE IF EXISTS entity_test;
DROP TABLE IF EXISTS intent_test;
DROP TABLE IF EXISTS error_cases;
DROP TABLE IF EXISTS case_entity;
DROP TABLE IF EXISTS cases;
DROP TABLE IF EXISTS intent;
DROP TABLE IF EXISTS entity;


CREATE TABLE users (
  id          INT AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP    NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                DEFAULT NULL,
  user_email  VARCHAR(100) NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        DEFAULT 'hzlixiaolei@corp.netease.com',
  user_name   VARCHAR(100) NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        DEFAULT 'hzlixiaolei',
  authority   TINYINT      NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        DEFAULT 3,
  PRIMARY KEY (id)
);

CREATE TABLE env (
  id          INT                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP    NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  DEFAULT NULL,
  url         VARCHAR(100) NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           DEFAULT 'http://inner-im.bot.163.com/',
  description VARCHAR(100) NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           DEFAULT 'bot测试环境',
  PRIMARY KEY (id)
);

CREATE TABLE report (
  id          INT                    AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP    NULL DEFAULT NULL,
  report_name VARCHAR(100) NOT NULL  DEFAULT '20170517_V101提测',
  is_valid    TINYINT      NOT NULL  DEFAULT 0,
  operator    INT          NOT NULL  DEFAULT 1,
  environment INT          NOT NULL  DEFAULT 1,
  -- 		version	tinyint		not null DEFAULT 1,
  PRIMARY KEY (id),
  FOREIGN KEY operator_index(operator) REFERENCES users (id),
  FOREIGN KEY env_index(environment) REFERENCES env (id)
);

CREATE TABLE summary (
  id            INT                 AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP NULL DEFAULT NULL,
  report_id   INT       NOT NULL  DEFAULT 1,
  is_contextual TINYINT NOT NULL    DEFAULT 0,
  case_num      INT     NOT NULL    DEFAULT 1000,
  case_passed   INT     NOT NULL    DEFAULT 800,
  PRIMARY KEY (id),
  FOREIGN KEY report_id_index(report_id) REFERENCES report (id)
);
CREATE TABLE entity_test (
  id          INT                 AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP NULL DEFAULT NULL,
  summary_id  INT       NOT NULL  DEFAULT 1,
  type        TINYINT   NOT NULL  DEFAULT 1,
  case_num    INT       NOT NULL  DEFAULT 1000,
  case_passed INT       NOT NULL  DEFAULT 800,
  PRIMARY KEY (id),
  FOREIGN KEY (summary_id) REFERENCES summary (id)
);

CREATE TABLE intent (
  id          INT                    AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP    NULL DEFAULT NULL,
  name        VARCHAR(100) NOT NULL  DEFAULT 'SHOPPING.inquire_order',
  domain      VARCHAR(100) NOT NULL  DEFAULT 'SHOPPING',
  description VARCHAR(100) NOT NULL  DEFAULT '订单查询',
  PRIMARY KEY (id)
);

CREATE TABLE intent_test (
  id          INT                 AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP NULL DEFAULT NULL,
  summary_id  INT       NOT NULL  DEFAULT 1,
  intent_id   INT       NOT NULL  DEFAULT 1,
  case_num    INT       NOT NULL  DEFAULT 1000,
  case_passed INT       NOT NULL  DEFAULT 800,
  PRIMARY KEY (id),
  FOREIGN KEY (summary_id) REFERENCES summary (id),
  FOREIGN KEY (intent_id) REFERENCES intent (id)
);
CREATE TABLE error_summary (
  id          INT                   AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP    NULL DEFAULT NULL,
  summary_id  INT       NOT NULL  DEFAULT 1,
  case_num    INT       NOT NULL  DEFAULT 18,
  error_desc  VARCHAR(100) NOT NULL DEFAULT '无法识别意图',
  PRIMARY KEY (id),
  FOREIGN KEY (summary_id) REFERENCES summary (id)
);

CREATE TABLE cases (
  id            INT                    AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP    NULL DEFAULT NULL,
  text        VARCHAR(100) NOT NULL  DEFAULT '{orderID=2335}，什么时候能发货？',
  utterance   VARCHAR(100) NOT NULL  DEFAULT '我这周三下午下的单，订单号是2335，什么时候能发货？',
  has_entity  TINYINT      NOT NULL  DEFAULT 1,
  intent_id   INT          NOT NULL  DEFAULT 1,
  is_contextual TINYINT    NOT NULL    DEFAULT 1,
  PRIMARY KEY (id),
  FOREIGN KEY (intent_id) REFERENCES intent (id)
);
CREATE TABLE error_cases (
  id          INT                   AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP    NULL DEFAULT NULL,
  case_id     INT       NOT NULL  DEFAULT 1,
  error_id    INT       NOT NULL  DEFAULT 1,
  error_type  TINYINT   NOT NULL  DEFAULT 0,
  error_info  VARCHAR(100) NOT NULL DEFAULT '意图“订单查询”无法识别',
  PRIMARY KEY (id),
  FOREIGN KEY (case_id) REFERENCES cases (id),
  FOREIGN KEY (error_id) REFERENCES error_summary (id)
);
CREATE TABLE entity (
  id           INT                    AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP     NULL DEFAULT NULL,
  entity_value VARCHAR(100) NOT NULL  DEFAULT 'datetime，orderid',
  entity_name  VARCHAR(100) NOT NULL  DEFAULT '周三下午；2335',
  PRIMARY KEY (id)
);
CREATE TABLE case_entity (
  id          INT                 AUTO_INCREMENT,
  create_time TIMESTAMP,
  modify_time TIMESTAMP NULL DEFAULT NULL,
  case_id     INT       NOT NULL  DEFAULT 1,
  entity_id   INT       NOT NULL  DEFAULT 1,
  PRIMARY KEY (id),
  FOREIGN KEY (case_id) REFERENCES cases (id),
  FOREIGN KEY (entity_id) REFERENCES entity (id)
);