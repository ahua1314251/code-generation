CREATE PROCEDURE [$schemaName].[$proName]
    #foreach($column in $columns)
    #if($velocityCount==$columns.size())
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE()
    #else
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE(),
    #end
    #end
AS
SELECT 
    #foreach($column in $columns)
    #if($velocityCount==$columns.size())
    [$column.getCOLUMN_NAME()]
    #else
    [$column.getCOLUMN_NAME()],
    #end
    #end
FROM [$schemaName].[$tableName]
WHERE 1=1

GO
GRANT EXECUTE
    ON OBJECT::[$schemaName].[$proName] TO [GSPApplicationRole]
    AS [$schemaName];

