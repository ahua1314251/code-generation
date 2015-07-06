CREATE PROCEDURE [main].[uspRoleUpdate001]
            @RoleID  INT,
                @CountryCode  CHAR(2),
                @LevelTypeID  INT,
                @Name  NVARCHAR(30),
                @Code  NVARCHAR(10),
                @Active  BIT,
                @Available  BIT,
                @ReportingRoleCategory  NVARCHAR(50),
                @ReportingRole  NVARCHAR(50),
                @CreatedBy  NVARCHAR(30),
                @CreatedTime  DATETIME2,
                @LastUpdatedBy  NVARCHAR(30),
                @LastUpdatedTime  DATETIME2
        AS
UPDATE [main].[Role]
SET
            [RoleID] = @RoleID,
                [CountryCode] = @CountryCode,
                [LevelTypeID] = @LevelTypeID,
                [Name] = @Name,
                [Code] = @Code,
                [Active] = @Active,
                [Available] = @Available,
                [ReportingRoleCategory] = @ReportingRoleCategory,
                [ReportingRole] = @ReportingRole,
                [CreatedBy] = @CreatedBy,
                [CreatedTime] = @CreatedTime,
                [LastUpdatedBy] = @LastUpdatedBy,
                [LastUpdatedTime] = @LastUpdatedTime
        WHERE 1 = 1

IF (@@rowcount<>0)
RETURN 0;

GO
GRANT EXECUTE
    ON OBJECT::[main].[uspRoleUpdate001] TO [GSPApplicationRole]
    AS [main];
