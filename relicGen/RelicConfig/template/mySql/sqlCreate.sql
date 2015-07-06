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
INSERT INTO `$tableName`
   #set($i=0)
  (#foreach($column in $columns)
   #set($i=$i+1)
   #if($i==$columns.size())
   `$column.getCOLUMN_NAME()`
   #else
   `$column.getCOLUMN_NAME()`,
   #end
   #end
   )
     VALUES
   #set($i=0)
 (#foreach($column in $columns)
   #set($i=$i+1)
   #if($i==$columns.size())
   p_$column.getCOLUMN_NAME()
   #else
   p_$column.getCOLUMN_NAME(),
   #end
  #end
 );
END
;;
DELIMITER ;
