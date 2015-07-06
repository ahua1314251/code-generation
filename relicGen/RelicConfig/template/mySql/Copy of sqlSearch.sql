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
tc.* ,
    #set($i=0)
    #foreach($column in $columns)
    #set($i=$i+1)
    #if($i==$columns.size())
    mm.${column.getCOLUMN_NAME()}
    #else
    mm.${column.getCOLUMN_NAME()},
    #end
    #end
FROM
   `$tableName` mm ,
   (SELECT COUNT(*) AS  totalCount FROM `$tableName` m  ) AS tc
   WHERE 1=1 LIMIT 100000,100
;


END
;;
DELIMITER ;


