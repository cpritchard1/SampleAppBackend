CREATE SCHEMA IF NOT EXISTS DEV01;

DROP TABLE DEV01.USER_ACCOUNT;

CREATE TABLE IF NOT EXISTS DEV01.USER_ACCOUNT
(
	USER_ID INT AUTO_INCREMENT
		PRIMARY KEY,
	USER_NAME VARCHAR(30) NOT NULL,
	GENDER VARCHAR(1) NOT NULL,
	PASSWORD VARCHAR(30) NOT NULL,
	CONSTRAINT USER_ACCOUNT_USER_NAME_UINDEX
		UNIQUE (USER_NAME)
);