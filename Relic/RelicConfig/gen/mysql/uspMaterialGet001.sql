DROP PROCEDURE IF EXISTS `uspMaterialGet001`;
DELIMITER ;;
CREATE PROCEDURE `uspMaterialGet001`(
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
SELECT 
                ID,
                MaterialName,
                MaterialQuantity,
                ApplicableModels,
                MaterialPrice,
                Customer,
                Leader,
                Remark,
                EntryTime,
                OutTime
        FROM `material`
WHERE ID = P_ID;
END
;;
DELIMITER ;


