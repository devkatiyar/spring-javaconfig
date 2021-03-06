DROP PROCEDURE IF EXISTS INSERTPOSITIONS;

CREATE TABLE EMPLOYEE (
EMPLOYEE_ID bigint NOT NULL AUTO_INCREMENT,
EMPLOYEE_NO VARCHAR(30),
EMPLOYEE_TYPE VARCHAR(20),
PRIMARY KEY(EMPLOYEE_ID)
);

CREATE TABLE EMP_DETAIL(
EMPLOYEE_ID BIGINT NOT NULL , 
INS_ID VARCHAR(20) , 
SALARY int,
PRIMARY KEY(EMPLOYEE_ID ,INS_ID),
FOREIGN KEY(EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID)
);

CREATE PROCEDURE INSERTEMP(
IN EMPLOYEENO VARCHAR(30),
IN EMPLOYEETYPE VARCHAR(20),
IN INSID VARCHAR(20),
IN INSALARY INT,
OUT EMPID BIGINT
)
BEGIN
	DECLARE EMPLOYEEID BIGINT;
	IF EXISTS (SELECT EMPLOYEE_ID FROM EMPLOYEE WHERE EMPLOYEE_NO=EMPLOYEENO AND EMPLOYEE_TYPE=EMPLOYEETYPE) THEN
	SET @EMPLOYEEID=(SELECT EMPLOYEE_ID FROM EMPLOYEE WHERE EMPLOYEE_NO=EMPLOYEENO AND EMPLOYEE_TYPE=EMPLOYEETYPE);
	ELSE
	INSERT INTO EMPLOYEE (EMPLOYEE_NO ,EMPLOYEE_TYPE ) VALUES (EMPLOYEENO,EMPLOYEETYPE);
	SET @EMPLOYEEID=(SELECT LAST_INSERT_ID());
	END IF;
   INSERT INTO EMP_DETAIL(EMPLOYEE_ID,INS_ID,SALARY) VALUES (@EMPLOYEEID,INSID,INSALARY);
   SET EMPID=@EMPLOYEEID;
END


CALL INSERTEMP(100, 'c','IBM',100);

CALL INSERTEMP(101, 'AAA','BBB',100,@OUT);









