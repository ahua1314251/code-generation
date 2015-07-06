DROP PROCEDURE IF EXISTS `uspSys_resourcesUpdate001`;
DELIMITER ;;

CREATE  PROCEDURE `uspSys_resourcesUpdate001`(
                p_id  INT ,
                p_resourceName  VARCHAR (50),
                p_resourceType  VARCHAR (10)
        )
BEGIN
INSERT INTO `sys_resources`
      (      `id`,
            `resourceName`,
            `resourceType`
         )
     VALUES
      (      p_id,
           p_resourceName,
           p_resourceType
      );
END
;;
DELIMITER ;
