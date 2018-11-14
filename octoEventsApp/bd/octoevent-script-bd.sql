create database octoevent;

USE `octoevent`;
create table event (
`even_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`even_action`  varchar(50) DEFAULT NULL,
`even_number` int(10) unsigned NOT NULL,
`even_status` varchar(50) DEFAULT NULL,
`even_data_hr_criacao` datetime NOT NULL,
`even_title` varchar(100) DEFAULT NULL,  
`even_user` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`even_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;