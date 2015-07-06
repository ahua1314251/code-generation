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
UPDATE sys_menu
SET              `id` = p_id,
                 `menuId` = p_menuId,
                 `content` = p_content,
                 `url` = p_url,
                 `type` = p_type,
                 `icon` = p_icon
         WHERE ******* = ********

IF (@@rowcount<>0)
RETURN 0;
END

