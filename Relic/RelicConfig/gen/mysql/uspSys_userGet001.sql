DROP PROCEDURE IF EXISTS `uspSys_userGet001`;
DELIMITER ;;
CREATE PROCEDURE `uspSys_userGet001`(
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
SELECT 
                ID,
                LoginID,
                Password,
                UserName,
                Email,
                PhoneNumber,
                Age,
                Img,
                Sex,
                QQ,
                CreateBy,
                CreateTime,
                UpdateBy,
                UpdateTime
        FROM `sys_user`
WHERE LoginID = p_LoginID;
END
;;
DELIMITER ;


