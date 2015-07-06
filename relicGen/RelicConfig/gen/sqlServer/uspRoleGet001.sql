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
SELECT 
            [RoleID],
                [CountryCode],
                [LevelTypeID],
                [Name],
                [Code],
                [Active],
                [Available],
                [ReportingRoleCategory],
                [ReportingRole],
                [CreatedBy],
                [CreatedTime],
                [LastUpdatedBy],
                [LastUpdatedTime]
        FROM [main].[Role]
WHERE 1=1

GO
GRANT EXECUTE
    ON OBJECT::[main].[uspRoleUpdate001] TO [GSPApplicationRole]
    AS [main];

