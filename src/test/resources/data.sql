DROP TABLE IF EXISTS currency_mapping;

CREATE TABLE currency_mapping (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(10) NOT NULL,
  chinese VARCHAR(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO currency_mapping (code, chinese) VALUES
  ('USD', '美元'), ('HKD', '港幣'), ('GBP', '英磅'), ('EUR', '歐元') ;