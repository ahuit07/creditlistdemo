drop table IF EXISTS TBLCREDITDETAIL;
drop table IF EXISTS TBLCREDIT;
CREATE TABLE tblCredit
	(idCredit INT auto_increment PRIMARY KEY, 
	amount Double NOT NULL,
	terms Integer NOT NULL,
	rate Double NOT NULL,
	rateAmount Double NOT NULL,
	totalAmount Double NOT NULL);

CREATE TABLE tblCreditDetail
	(idCreditDetail INT auto_increment PRIMARY KEY, 
	idCredit Integer NOT NULL,
	payment_number Integer NOT NULL,
	amountDetail Double NOT NULL,
	payment_day Date NOT NULL,
	foreign key (idCredit) references tblCredit(idCredit));