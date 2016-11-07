DROP PROCEDURE IF EXISTS `uspMaterialSearch001`;
DELIMITER ;;
CREATE PROCEDURE `uspMaterialSearch001`(
                p_limit INT,
                p_offset INT,
                p_sort VARCHAR(30),
                p_order VARCHAR(10),
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
	     SET p_ID = RTRIM(LTRIM(IFNULL(p_ID,'')));
	     SET p_MaterialName = RTRIM(LTRIM(IFNULL(p_MaterialName,'')));
	     SET p_MaterialQuantity = RTRIM(LTRIM(IFNULL(p_MaterialQuantity,'')));
	     SET p_ApplicableModels = RTRIM(LTRIM(IFNULL(p_ApplicableModels,'')));
	     SET p_MaterialPrice = RTRIM(LTRIM(IFNULL(p_MaterialPrice,'')));
	     SET p_Customer = RTRIM(LTRIM(IFNULL(p_Customer,'')));
	     SET p_Leader = RTRIM(LTRIM(IFNULL(p_Leader,'')));
	     SET p_Remark = RTRIM(LTRIM(IFNULL(p_Remark,'')));
	     SET p_EntryTime = RTRIM(LTRIM(IFNULL(p_EntryTime,'')));
	     SET p_OutTime = RTRIM(LTRIM(IFNULL(p_OutTime,'')));
	 	 
	SET @p_totalCount = (SELECT count(*) FROM `material` tc where  
              (p_ID='' OR tc.ID LIKE CONCAT('%',p_ID,'%')) and
               (p_MaterialName='' OR tc.MaterialName LIKE CONCAT('%',p_MaterialName,'%')) and
               (p_MaterialQuantity='' OR tc.MaterialQuantity LIKE CONCAT('%',p_MaterialQuantity,'%')) and
               (p_ApplicableModels='' OR tc.ApplicableModels LIKE CONCAT('%',p_ApplicableModels,'%')) and
               (p_MaterialPrice='' OR tc.MaterialPrice LIKE CONCAT('%',p_MaterialPrice,'%')) and
               (p_Customer='' OR tc.Customer LIKE CONCAT('%',p_Customer,'%')) and
               (p_Leader='' OR tc.Leader LIKE CONCAT('%',p_Leader,'%')) and
               (p_Remark='' OR tc.Remark LIKE CONCAT('%',p_Remark,'%')) and
               (p_EntryTime='' OR tc.EntryTime LIKE CONCAT('%',p_EntryTime,'%')) and
               (p_OutTime='' OR tc.OutTime LIKE CONCAT('%',p_OutTime,'%'))
      );
	 
   
SELECT * FROM
( SELECT
     @p_totalCount as totalCount,
                mm.ID,
                mm.MaterialName,
                mm.MaterialQuantity,
                mm.ApplicableModels,
                mm.MaterialPrice,
                mm.Customer,
                mm.Leader,
                mm.Remark,
                mm.EntryTime,
                mm.OutTime
        FROM
   `material` mm 
   Where 
              (p_ID='' OR mm.ID LIKE CONCAT('%',p_ID,'%')) and
               (p_MaterialName='' OR mm.MaterialName LIKE CONCAT('%',p_MaterialName,'%')) and
               (p_MaterialQuantity='' OR mm.MaterialQuantity LIKE CONCAT('%',p_MaterialQuantity,'%')) and
               (p_ApplicableModels='' OR mm.ApplicableModels LIKE CONCAT('%',p_ApplicableModels,'%')) and
               (p_MaterialPrice='' OR mm.MaterialPrice LIKE CONCAT('%',p_MaterialPrice,'%')) and
               (p_Customer='' OR mm.Customer LIKE CONCAT('%',p_Customer,'%')) and
               (p_Leader='' OR mm.Leader LIKE CONCAT('%',p_Leader,'%')) and
               (p_Remark='' OR mm.Remark LIKE CONCAT('%',p_Remark,'%')) and
               (p_EntryTime='' OR mm.EntryTime LIKE CONCAT('%',p_EntryTime,'%')) and
               (p_OutTime='' OR mm.OutTime LIKE CONCAT('%',p_OutTime,'%'))
          limit 0,500 ) AS result
    order by
              case  when p_order= 'asc' and p_sort='ID'  then  result.ID end asc,
     case  when p_order= 'desc' and p_sort='ID'  then result.ID end desc,
                 case  when p_order= 'asc' and p_sort='MaterialName'  then  result.MaterialName end asc,
     case  when p_order= 'desc' and p_sort='MaterialName'  then result.MaterialName end desc,
                 case  when p_order= 'asc' and p_sort='MaterialQuantity'  then  result.MaterialQuantity end asc,
     case  when p_order= 'desc' and p_sort='MaterialQuantity'  then result.MaterialQuantity end desc,
                 case  when p_order= 'asc' and p_sort='ApplicableModels'  then  result.ApplicableModels end asc,
     case  when p_order= 'desc' and p_sort='ApplicableModels'  then result.ApplicableModels end desc,
                 case  when p_order= 'asc' and p_sort='MaterialPrice'  then  result.MaterialPrice end asc,
     case  when p_order= 'desc' and p_sort='MaterialPrice'  then result.MaterialPrice end desc,
                 case  when p_order= 'asc' and p_sort='Customer'  then  result.Customer end asc,
     case  when p_order= 'desc' and p_sort='Customer'  then result.Customer end desc,
                 case  when p_order= 'asc' and p_sort='Leader'  then  result.Leader end asc,
     case  when p_order= 'desc' and p_sort='Leader'  then result.Leader end desc,
                 case  when p_order= 'asc' and p_sort='Remark'  then  result.Remark end asc,
     case  when p_order= 'desc' and p_sort='Remark'  then result.Remark end desc,
                 case  when p_order= 'asc' and p_sort='EntryTime'  then  result.EntryTime end asc,
     case  when p_order= 'desc' and p_sort='EntryTime'  then result.EntryTime end desc,
                 case  when p_order= 'asc' and p_sort='OutTime'  then  result.OutTime end asc,
     case  when p_order= 'desc' and p_sort='OutTime'  then result.OutTime end desc
            LIMIT p_limit OFFSET p_offset
;

END
;;
DELIMITER ;


