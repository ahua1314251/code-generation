DROP PROCEDURE IF EXISTS `uspSys_menuUpdate001`;
DELIMITER ;;

CREATE  PROCEDURE `uspSys_menuUpdate001`(
                p_id  INT ,
                p_menuId  VARCHAR (10),
                p_content  VARCHAR (20),
                p_url  VARCHAR (50),
                p_type  VARCHAR (10),
                p_icon  VARCHAR (20)
        )
BEGIN
INSERT INTO `sys_menu`
      (      `id`,
            `menuId`,
            `content`,
            `url`,
            `type`,
            `icon`
         )
     VALUES
      (      p_id,
           p_menuId,
           p_content,
           p_url,
           p_type,
           p_icon
      );
END
;;
DELIMITER ;
