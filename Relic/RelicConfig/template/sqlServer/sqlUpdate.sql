CREATE PROCEDURE [$schemaName].[$proName]
    #foreach($column in $columns)
    #if($velocityCount==$columns.size())
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE()
    #else
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE(),
    #end
    #end
AS
UPDATE [$schemaName].[$tableName]
SET
    #foreach($column in $columns)	
    #if($velocityCount==$columns.size())
    [$column.getCOLUMN_NAME()] = @$column.getCOLUMN_NAME()
    #else
    [$column.getCOLUMN_NAME()] = @$column.getCOLUMN_NAME(),
    #end
    #end
WHERE 1 = 1

IF (@@rowcount<>0)
RETURN 0;

GO
GRANT EXECUTE
    ON OBJECT::[$schemaName].[$proName] TO [GSPApplicationRole]
    AS [$schemaName];
