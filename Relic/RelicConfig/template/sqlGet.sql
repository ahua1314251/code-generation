CREATE PROCEDURE [$schemaName].[$proName]
	@***** INT
AS
SELECT 
    #foreach($column in $columns)	
    [$column.getCOLUMN_NAME()],
    #end
FROM [$schemaName].[$tableName]
WHERE ***** = @******

GO
GRANT EXECUTE
    ON OBJECT::[$schemaName].[$proName] TO [GSPApplicationRole]
    AS [$schemaName];

