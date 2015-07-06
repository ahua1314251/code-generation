CREATE PROCEDURE [$schemaName].[$proName]
    #foreach($column in $columns)
    @$column.getCOLUMN_NAME()  $column.getTYPE_NAME()$column.getCOLUMN_SIZE(),
    #end
AS
UPDATE [$schemaName].[$tableName]
SET
    #foreach($column in $columns)	
    [$column.getCOLUMN_NAME()] = @$column.getCOLUMN_NAME(),
    #end
WHERE ******* = ********

IF (@@rowcount<>0)
RETURN 0;

GO
GRANT EXECUTE
    ON OBJECT::[$schemaName].[$proName] TO [GSPApplicationRole]
    AS [$schemaName];
