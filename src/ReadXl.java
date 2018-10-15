
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXl {
private static final String FILEPath="C:\\Users\\test\\Downloads\\standupReport.xlsx";
public String toString() { 
    return  FILEPath ;
} 

public List excelData() {
	
List Names=new ArrayList();
	
	FileInputStream fis=null;
	try {
		fis=new FileInputStream(FILEPath);
		Workbook wb=new XSSFWorkbook(fis);
		int index=wb.getActiveSheetIndex();
		Sheet sheet=wb.getSheetAt(index);
		Iterator<Row> rowIterator=sheet.iterator();
		while(rowIterator.hasNext()) {
			
			ListsReq listreq=null;;
			Row row= rowIterator.next();
			String names="";
			String status="";
			String time="";
			for (int i = 0; i < row.getLastCellNum(); i++) {
				Cell cell=row.getCell(i);
				if(cell!=null) {
					
					if(i==0) {
						names = cell.getStringCellValue();
					}
					if(i==1) {
						DataFormatter df = new DataFormatter();
						//String value = df.formatCellValue(cell);
						status = df.formatCellValue(cell);
					}
					if(i==2) {
						time = cell.getStringCellValue();
					}
					
				}
			}
			listreq = new ListsReq(names, status, time);
			Names.add(listreq);
		}
		fis.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Names;
}
}
