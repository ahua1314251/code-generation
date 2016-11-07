DROP PROCEDURE IF EXISTS `$proName`;
DELIMITER ;;
CREATE PROCEDURE `$proName`(
    #set($i=0)
    #foreach($column in $columns)
    #set($i=$i+1)
    #if($i==$columns.size())
    p_$column.getCOLUMN_NAME()  $column.getTYPE_NAME() $column.getCOLUMN_SIZE()
    #else
    p_$column.getCOLUMN_NAME()  $column.getTYPE_NAME() $column.getCOLUMN_SIZE(),
    #end
    #end
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
WHERE 1=1;
END
;;
DELIMITER ;


