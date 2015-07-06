DROP PROCEDURE IF EXISTS `uspSys_userUpdate001`;
DELIMITER ;;
CREATE  PROCEDURE `uspSys_userUpdate001`(
                p_ID  INT ,
                p_UserName  VARCHAR (100),
                p_Password  VARCHAR (100),
                p_Email  VARCHAR (100),
                p_LoginID  VARCHAR (100)
        )
BEGIN
UPDATE sys_user
SET              `ID` = p_ID,
                 `UserName` = p_UserName,
                 `Password` = p_Password,
                 `Email` = p_Email,
                 `LoginID` = p_LoginID
         WHERE ******* = ********

IF (@@rowcount<>0)
RETURN 0;
END

