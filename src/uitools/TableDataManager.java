package uitools;

import java.util.ArrayList;
import java.util.List;

public interface TableDataManager {
		
		
	public ArrayList<String> getTableHeaders();
	
	public ArrayList<ArrayList<Object>> getTableData();
	
	public ArrayList<Object> getRowData(int row);
	
	public <T> List<T> getColumnData(String colName);
	
	public <T> List<T> getColumnData(int col);
	
	public boolean updateCell(int col, int row, Object value);
	
	
}
