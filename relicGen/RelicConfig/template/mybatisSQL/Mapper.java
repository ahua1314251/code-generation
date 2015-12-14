
public interface ${table.getTABLE_BEAN_NAME()}Mapper {                
	insertSelective(${table.getTABLE_NAMEFU()}  ${table.getTABLE_NAMEFL()});
	
	updateSelective(${table.getTABLE_NAMEFU()}  ${table.getTABLE_NAMEFL()});
	
	deleteById(Long id);
}

 