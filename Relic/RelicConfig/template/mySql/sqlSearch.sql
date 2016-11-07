DROP PROCEDURE IF EXISTS `$proName`;
DELIMITER ;;
CREATE PROCEDURE `$proName`(
                p_limit INT,
                p_offset INT,
                p_sort VARCHAR(30),
                p_order VARCHAR(10),
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
	 #foreach($column in $columns)
    SET p_$column.getCOLUMN_NAME() = RTRIM(LTRIM(IFNULL(p_$column.getCOLUMN_NAME(),'')));
	 #end
	 
	SET @p_totalCount = (SELECT count(*) FROM `$tableName` tc where  
     #foreach($column in $columns)
    #if($velocityCount==$columns.size()) 
     (p_$column.getCOLUMN_NAME()='' OR tc.${column.getCOLUMN_NAME()} LIKE CONCAT('%',p_$column.getCOLUMN_NAME(),'%'))
   #else
     (p_$column.getCOLUMN_NAME()='' OR tc.${column.getCOLUMN_NAME()} LIKE CONCAT('%',p_$column.getCOLUMN_NAME(),'%')) and
   #end
   #end);
	 
   
SELECT * FROM
( SELECT
     @p_totalCount as totalCount,
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
   `$tableName` mm 
   Where 
     #foreach($column in $columns)
    #if($velocityCount==$columns.size()) 
     (p_$column.getCOLUMN_NAME()='' OR mm.${column.getCOLUMN_NAME()} LIKE CONCAT('%',p_$column.getCOLUMN_NAME(),'%'))
   #else
     (p_$column.getCOLUMN_NAME()='' OR mm.${column.getCOLUMN_NAME()} LIKE CONCAT('%',p_$column.getCOLUMN_NAME(),'%')) and
   #end
   #end
    limit 0,500 ) AS result
    order by
     #foreach($column in $columns)
    #if($velocityCount==$columns.size()) 
     case  when p_order= 'asc' and p_sort='${column.getCOLUMN_NAME()}'  then  result.${column.getCOLUMN_NAME()} end asc,
     case  when p_order= 'desc' and p_sort='${column.getCOLUMN_NAME()}'  then result.${column.getCOLUMN_NAME()} end desc
    #else
     case  when p_order= 'asc' and p_sort='${column.getCOLUMN_NAME()}'  then  result.${column.getCOLUMN_NAME()} end asc,
     case  when p_order= 'desc' and p_sort='${column.getCOLUMN_NAME()}'  then result.${column.getCOLUMN_NAME()} end desc,
    #end
    #end
    LIMIT p_limit OFFSET p_offset
;

END
;;
DELIMITER ;


