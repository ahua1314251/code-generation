DROP PROCEDURE IF EXISTS `uspSys_userUpdate001`;
DELIMITER ;;
CREATE  PROCEDURE `uspSys_userUpdate001`(
                p_ID  INT ,
                p_LoginID  VARCHAR (50),
                p_Password  VARCHAR (50),
                p_UserName  VARCHAR (50),
                p_Email  VARCHAR (50),
                p_PhoneNumber  VARCHAR (30),
                p_Age  INT ,
                p_Img  VARCHAR (255),
                p_Sex  BIT ,
                p_QQ  VARCHAR (11),
                p_CreateBy  VARCHAR (50),
                p_CreateTime  DATETIME ,
                p_UpdateBy  VARCHAR (50),
                p_UpdateTime  DATETIME 
        )
BEGIN
UPDATE sys_user
SET              `ID` = p_ID,
                 `LoginID` = p_LoginID,
                 `Password` = p_Password,
                 `UserName` = p_UserName,
                 `Email` = p_Email,
                 `PhoneNumber` = p_PhoneNumber,
                 `Age` = p_Age,
                 `Img` = p_Img,
                 `Sex` = p_Sex,
                 `QQ` = p_QQ,
                 `CreateBy` = p_CreateBy,
                 `CreateTime` = p_CreateTime,
                 `UpdateBy` = p_UpdateBy,
                 `UpdateTime` = p_UpdateTime
         WHERE ID = p_ID;

END
;;
DELIMITER ;
