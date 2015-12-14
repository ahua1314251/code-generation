public class $table.getTABLE_NAMEFU(){
	#foreach($column in $columns)
	private $column.getTYPE_NAME_Java() $column.getCOLUMN_NAMEFL();
	#end
	
	#foreach($column in $columns)
	public void set${column.getCOLUMN_NAMEFU()}($column.getTYPE_NAME_Java() $column.getCOLUMN_NAMEFL()){
		this.$column.getCOLUMN_NAMEFL() = $column.getCOLUMN_NAMEFL();
	}

	public $column.getTYPE_NAME_Java() get${column.getCOLUMN_NAMEFU()}(){
		 return this.$column.getCOLUMN_NAMEFL();
	 }
	#end
}