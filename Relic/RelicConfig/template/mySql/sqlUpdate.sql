DROP PROCEDURE IF EXISTS `$proName`;
DELIMITER ;;
CREATE  PROCEDURE `$proName`(
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
UPDATE $tableName
SET #set($i=0)
    #foreach($column in $columns)
     #set($i=$i+1)
     #if($i==$columns.size())
    `$column.getCOLUMN_NAME()` = p_$column.getCOLUMN_NAME()
     #else
    `$column.getCOLUMN_NAME()` = p_$column.getCOLUMN_NAME(),
    #end
    #end
WHERE ******* = ********

IF (@@rowcount<>0)
RETURN 0;
END

