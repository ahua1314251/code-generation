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
INSERT INTO `material`
      (      `ID`,
            `MaterialName`,
            `MaterialQuantity`,
            `ApplicableModels`,
            `MaterialPrice`,
            `Customer`,
            `Leader`,
            `Remark`,
            `EntryTime`,
            `OutTime`
         )
     VALUES
      (      p_ID,
           p_MaterialName,
           p_MaterialQuantity,
           p_ApplicableModels,
           p_MaterialPrice,
           p_Customer,
           p_Leader,
           p_Remark,
           p_EntryTime,
           p_OutTime
      );
END
;;
DELIMITER ;
