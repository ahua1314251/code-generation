DROP PROCEDURE IF EXISTS `uspSys_userSearch001`;
DELIMITER ;;
CREATE PROCEDURE `uspSys_userSearch001`(
                p_limit INT,
                p_offset INT,
                p_sort VARCHAR(30),
                p_order VARCHAR(10),
                p_ID  INT ,
                p_LoginID  VARCHAR (50),
                p_Password  VARCHAR (50),
                p_UserName  VARCHAR (50),
                p_Email  VARCHAR (50),
                p_PhoneNumber  VARCHAR (30),
                p_Age  INT ,
                p_Img  VARCHAR (255),
                p_Sex  BIT ,
                p_QQ  VARCHAR (11),
                p_CreateBy  VARCHAR (50),
                p_CreateTime  DATETIME ,
                p_UpdateBy  VARCHAR (50),
                p_UpdateTime  DATETIME 
        	)
BEGIN
	     SET p_ID = RTRIM(LTRIM(IFNULL(p_ID,'')));
	     SET p_LoginID = RTRIM(LTRIM(IFNULL(p_LoginID,'')));
	     SET p_Password = RTRIM(LTRIM(IFNULL(p_Password,'')));
	     SET p_UserName = RTRIM(LTRIM(IFNULL(p_UserName,'')));
	     SET p_Email = RTRIM(LTRIM(IFNULL(p_Email,'')));
	     SET p_PhoneNumber = RTRIM(LTRIM(IFNULL(p_PhoneNumber,'')));
	     SET p_Age = RTRIM(LTRIM(IFNULL(p_Age,'')));
	     SET p_Img = RTRIM(LTRIM(IFNULL(p_Img,'')));
	     SET p_Sex = RTRIM(LTRIM(IFNULL(p_Sex,'')));
	     SET p_QQ = RTRIM(LTRIM(IFNULL(p_QQ,'')));
	     SET p_CreateBy = RTRIM(LTRIM(IFNULL(p_CreateBy,'')));
	     SET p_CreateTime = RTRIM(LTRIM(IFNULL(p_CreateTime,'')));
	     SET p_UpdateBy = RTRIM(LTRIM(IFNULL(p_UpdateBy,'')));
	     SET p_UpdateTime = RTRIM(LTRIM(IFNULL(p_UpdateTime,'')));
	 	 
	SET @p_totalCount = (SELECT count(*) FROM `sys_user` tc where  
              (p_ID='' OR tc.ID LIKE CONCAT('%',p_ID,'%')) and
               (p_LoginID='' OR tc.LoginID LIKE CONCAT('%',p_LoginID,'%')) and
               (p_Password='' OR tc.Password LIKE CONCAT('%',p_Password,'%')) and
               (p_UserName='' OR tc.UserName LIKE CONCAT('%',p_UserName,'%')) and
               (p_Email='' OR tc.Email LIKE CONCAT('%',p_Email,'%')) and
               (p_PhoneNumber='' OR tc.PhoneNumber LIKE CONCAT('%',p_PhoneNumber,'%')) and
               (p_Age='' OR tc.Age LIKE CONCAT('%',p_Age,'%')) and
               (p_Img='' OR tc.Img LIKE CONCAT('%',p_Img,'%')) and
               (p_Sex='' OR tc.Sex LIKE CONCAT('%',p_Sex,'%')) and
               (p_QQ='' OR tc.QQ LIKE CONCAT('%',p_QQ,'%')) and
               (p_CreateBy='' OR tc.CreateBy LIKE CONCAT('%',p_CreateBy,'%')) and
               (p_CreateTime='' OR tc.CreateTime LIKE CONCAT('%',p_CreateTime,'%')) and
               (p_UpdateBy='' OR tc.UpdateBy LIKE CONCAT('%',p_UpdateBy,'%')) and
               (p_UpdateTime='' OR tc.UpdateTime LIKE CONCAT('%',p_UpdateTime,'%'))
      );
	 
   
SELECT * FROM
( SELECT
     @p_totalCount as totalCount,
                mm.ID,
                mm.LoginID,
                mm.Password,
                mm.UserName,
                mm.Email,
                mm.PhoneNumber,
                mm.Age,
                mm.Img,
                mm.Sex,
                mm.QQ,
                mm.CreateBy,
                mm.CreateTime,
                mm.UpdateBy,
                mm.UpdateTime
        FROM
   `sys_user` mm 
   Where 
              (p_ID='' OR mm.ID LIKE CONCAT('%',p_ID,'%')) and
               (p_LoginID='' OR mm.LoginID LIKE CONCAT('%',p_LoginID,'%')) and
               (p_Password='' OR mm.Password LIKE CONCAT('%',p_Password,'%')) and
               (p_UserName='' OR mm.UserName LIKE CONCAT('%',p_UserName,'%')) and
               (p_Email='' OR mm.Email LIKE CONCAT('%',p_Email,'%')) and
               (p_PhoneNumber='' OR mm.PhoneNumber LIKE CONCAT('%',p_PhoneNumber,'%')) and
               (p_Age='' OR mm.Age LIKE CONCAT('%',p_Age,'%')) and
               (p_Img='' OR mm.Img LIKE CONCAT('%',p_Img,'%')) and
               (p_Sex='' OR mm.Sex LIKE CONCAT('%',p_Sex,'%')) and
               (p_QQ='' OR mm.QQ LIKE CONCAT('%',p_QQ,'%')) and
               (p_CreateBy='' OR mm.CreateBy LIKE CONCAT('%',p_CreateBy,'%')) and
               (p_CreateTime='' OR mm.CreateTime LIKE CONCAT('%',p_CreateTime,'%')) and
               (p_UpdateBy='' OR mm.UpdateBy LIKE CONCAT('%',p_UpdateBy,'%')) and
               (p_UpdateTime='' OR mm.UpdateTime LIKE CONCAT('%',p_UpdateTime,'%'))
          limit 0,500 ) AS result
    order by
              case  when p_order= 'asc' and p_sort='ID'  then  result.ID end asc,
     case  when p_order= 'desc' and p_sort='ID'  then result.ID end desc,
                 case  when p_order= 'asc' and p_sort='LoginID'  then  result.LoginID end asc,
     case  when p_order= 'desc' and p_sort='LoginID'  then result.LoginID end desc,
                 case  when p_order= 'asc' and p_sort='Password'  then  result.Password end asc,
     case  when p_order= 'desc' and p_sort='Password'  then result.Password end desc,
                 case  when p_order= 'asc' and p_sort='UserName'  then  result.UserName end asc,
     case  when p_order= 'desc' and p_sort='UserName'  then result.UserName end desc,
                 case  when p_order= 'asc' and p_sort='Email'  then  result.Email end asc,
     case  when p_order= 'desc' and p_sort='Email'  then result.Email end desc,
                 case  when p_order= 'asc' and p_sort='PhoneNumber'  then  result.PhoneNumber end asc,
     case  when p_order= 'desc' and p_sort='PhoneNumber'  then result.PhoneNumber end desc,
                 case  when p_order= 'asc' and p_sort='Age'  then  result.Age end asc,
     case  when p_order= 'desc' and p_sort='Age'  then result.Age end desc,
                 case  when p_order= 'asc' and p_sort='Img'  then  result.Img end asc,
     case  when p_order= 'desc' and p_sort='Img'  then result.Img end desc,
                 case  when p_order= 'asc' and p_sort='Sex'  then  result.Sex end asc,
     case  when p_order= 'desc' and p_sort='Sex'  then result.Sex end desc,
                 case  when p_order= 'asc' and p_sort='QQ'  then  result.QQ end asc,
     case  when p_order= 'desc' and p_sort='QQ'  then result.QQ end desc,
                 case  when p_order= 'asc' and p_sort='CreateBy'  then  result.CreateBy end asc,
     case  when p_order= 'desc' and p_sort='CreateBy'  then result.CreateBy end desc,
                 case  when p_order= 'asc' and p_sort='CreateTime'  then  result.CreateTime end asc,
     case  when p_order= 'desc' and p_sort='CreateTime'  then result.CreateTime end desc,
                 case  when p_order= 'asc' and p_sort='UpdateBy'  then  result.UpdateBy end asc,
     case  when p_order= 'desc' and p_sort='UpdateBy'  then result.UpdateBy end desc,
                 case  when p_order= 'asc' and p_sort='UpdateTime'  then  result.UpdateTime end asc,
     case  when p_order= 'desc' and p_sort='UpdateTime'  then result.UpdateTime end desc
            LIMIT p_limit OFFSET p_offset
;

END
;;
DELIMITER ;


