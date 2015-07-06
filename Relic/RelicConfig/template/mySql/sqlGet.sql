DROP PROCEDURE IF EXISTS `$proName`;
DELIMITER ;;
CREATE PROCEDURE `$proName`(
	p_***** INT
	)
BEGIN
SELECT 
    #set($i=0)
    #foreach($column in $columns)
    #set($i=$i+1)
    #if($i==$columns.size())
    $column.getCOLUMN_NAME()
    #else
    $column.getCOLUMN_NAME(),
    #end
    #end
FROM `$tableName`
WHERE ***** = P_******;
END
;;
DELIMITER ;


