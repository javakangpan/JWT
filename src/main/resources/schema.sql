drop table user if exists;
CREATE TABLE user(
  id bigint auto_increment,
  username varchar(255),
  password varchar(255),
  PRIMARY KEY (id)
);

INSERT INTO user VALUES (1, 'kangpan', '123456');