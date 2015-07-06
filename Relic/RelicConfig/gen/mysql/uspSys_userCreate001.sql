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
INSERT INTO `sys_user`
      (      `ID`,
            `UserName`,
            `Password`,
            `Email`,
            `LoginID`
         )
     VALUES
      (      p_ID,
           p_UserName,
           p_Password,
           p_Email,
           p_LoginID
      );
END
;;
DELIMITER ;
