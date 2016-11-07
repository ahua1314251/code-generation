CREATE PROCEDURE [$schemaName].[$proName]
       #foreach($column in $columns)
    #if($velocityCount==$columns.size())
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE()
    #else
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE(),
    #end
    #end
AS
INSERT INTO [$schemaName].[$proName]
     (#foreach($column in $columns)
   #if($velocityCount==$columns.size())
   [$column.getCOLUMN_NAME()]
   #else
   [$column.getCOLUMN_NAME()],
   #end
   #end
   )
     VALUES
   (#foreach($column in $columns)
  #if($velocityCount==$columns.size())
  @$column.getCOLUMN_NAME()
  #else
  @$column.getCOLUMN_NAME(),
  #end
  #end
 );

GO
GRANT EXECUTE
    ON OBJECT::[$schemaName].[$proName] TO [GSPApplicationRole]
    AS [$schemaName];