CREATE PROCEDURE [main].[uspSys_userUpdate001]
    AS
UPDATE [main].[sys_user]
SET
    WHERE 1 = 1

IF (@@rowcount<>0)
RETURN 0;

GO
GRANT EXECUTE
    ON OBJECT::[main].[uspSys_userUpdate001] TO [GSPApplicationRole]
    AS [main];
