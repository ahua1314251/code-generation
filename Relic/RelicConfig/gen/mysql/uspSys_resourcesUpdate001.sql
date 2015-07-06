DROP PROCEDURE IF EXISTS `uspSys_resourcesUpdate001`;
DELIMITER ;;
CREATE  PROCEDURE `uspSys_resourcesUpdate001`(
                p_id  INT ,
                p_resourceName  VARCHAR (50),
                p_resourceType  VARCHAR (10)
        )
BEGIN
UPDATE sys_resources
SET              `id` = p_id,
                 `resourceName` = p_resourceName,
                 `resourceType` = p_resourceType
         WHERE ******* = ********

IF (@@rowcount<>0)
RETURN 0;
END

