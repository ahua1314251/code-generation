DROP PROCEDURE IF EXISTS `uspSys_menuUpdate001`;
DELIMITER ;;
CREATE PROCEDURE `uspSys_menuUpdate001`(
	p_***** INT
	)
BEGIN
SELECT 
                id,
                menuId,
                content,
                url,
                type,
                icon
        FROM `sys_menu`
WHERE ***** = P_******;
END
;;
DELIMITER ;


