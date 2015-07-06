DROP PROCEDURE IF EXISTS `uspSys_userCreate001`;
DELIMITER ;;

CREATE  PROCEDURE `uspSys_userCreate001`(
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
INSERT INTO `sys_user`
     (      `ID`,
            `LoginID`,
            `Password`,
            `UserName`,
            `Email`,
            `PhoneNumber`,
            `Age`,
            `Img`,
            `Sex`,
            `QQ`,
            `CreateBy`,
            `CreateTime`,
            `UpdateBy`,
            `UpdateTime`
         )
     VALUES
    (      p_ID,
           p_LoginID,
           p_Password,
           p_UserName,
           p_Email,
           p_PhoneNumber,
           p_Age,
           p_Img,
           p_Sex,
           p_QQ,
           p_CreateBy,
           p_CreateTime,
           p_UpdateBy,
           p_UpdateTime
      );
END
;;
DELIMITER ;
