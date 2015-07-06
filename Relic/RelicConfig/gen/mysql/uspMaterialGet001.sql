DROP PROCEDURE IF EXISTS `uspMaterialUpdate001`;
DELIMITER ;;
CREATE PROCEDURE `uspMaterialUpdate001`(
	p_***** INT
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
WHERE ***** = P_******;
END
;;
DELIMITER ;


