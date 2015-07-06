DROP PROCEDURE IF EXISTS `uspSys_resourcesUpdate001`;
DELIMITER ;;
CREATE PROCEDURE `uspSys_resourcesUpdate001`(
	p_***** INT
	)
BEGIN
SELECT 
                id,
                resourceName,
                resourceType
        FROM `sys_resources`
WHERE ***** = P_******;
END
;;
DELIMITER ;


