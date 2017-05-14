USE `testdb`;
DROP procedure IF EXISTS `INSERTEMP`;

DELIMITER $$
USE `testdb`$$
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
END$$

DELIMITER ;

