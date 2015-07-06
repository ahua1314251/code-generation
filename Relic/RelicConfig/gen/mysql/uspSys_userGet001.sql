DROP PROCEDURE IF EXISTS `uspSys_userUpdate001`;
DELIMITER ;;
CREATE PROCEDURE `uspSys_userUpdate001`(
	p_***** INT
	)
BEGIN
SELECT 
                ID,
                UserName,
                Password,
                Email,
                LoginID
        FROM `sys_user`
WHERE ***** = P_******;
END
;;
DELIMITER ;


