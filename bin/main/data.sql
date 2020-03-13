SET SQL_SAFE_UPDATES = 0;
delete from jagdi.user;
SET SQL_SAFE_UPDATES = 1;
INSERT INTO `jagdi`.`user` (`id`,`password`, `username`, `active`) VALUES (1,'admin', 'admin', b'1')