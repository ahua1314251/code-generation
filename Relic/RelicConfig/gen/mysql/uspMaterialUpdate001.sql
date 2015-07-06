DROP PROCEDURE IF EXISTS `uspMaterialUpdate001`;
DELIMITER ;;
CREATE  PROCEDURE `uspMaterialUpdate001`(
                p_ID  INT ,
                p_MaterialName  VARCHAR (30),
                p_MaterialQuantity  INT ,
                p_ApplicableModels  VARCHAR (30),
                p_MaterialPrice  VARCHAR (30),
                p_Customer  VARCHAR (30),
                p_Leader  VARCHAR (30),
                p_Remark  VARCHAR (300),
                p_EntryTime  DATETIME ,
                p_OutTime  DATETIME 
        )
BEGIN
UPDATE material
SET              `ID` = p_ID,
                 `MaterialName` = p_MaterialName,
                 `MaterialQuantity` = p_MaterialQuantity,
                 `ApplicableModels` = p_ApplicableModels,
                 `MaterialPrice` = p_MaterialPrice,
                 `Customer` = p_Customer,
                 `Leader` = p_Leader,
                 `Remark` = p_Remark,
                 `EntryTime` = p_EntryTime,
                 `OutTime` = p_OutTime
         WHERE ******* = ********

IF (@@rowcount<>0)
RETURN 0;
END

