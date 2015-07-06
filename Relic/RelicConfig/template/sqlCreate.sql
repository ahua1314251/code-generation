CREATE PROCEDURE [$schemaName].[$proName]
    #foreach($column in $columns)
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE(),
    #end
AS
INSERT INTO [$schemaName].[$proName]
   (#foreach($column in $columns)
   [$column.getCOLUMN_NAME()],
   #end
   )
     VALUES
   (#foreach($column in $columns)
  @$column.getCOLUMN_NAME(),
  #end
 );

GO
GRANT EXECUTE
    ON OBJECT::[$schemaName].[$proName] TO [GSPApplicationRole]
    AS [$schemaName];