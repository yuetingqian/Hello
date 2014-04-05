import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;

public class ReadExcel {

	public static void main(String[] args) {
		Sheet sheet;
		Workbook book = null;

		try {
			book = Workbook.getWorkbook(new File(
					"C:\\Users\\yuetingqian\\Desktop\\a.xls"));
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(0);
		for (int i = 1; i < sheet.getRows(); i++) {
			String name = sheet.getCell(0, i).getContents();
			String id = sheet.getCell(1, i).getContents();
			System.out.println(name + id);
		}
		book.close();

	}
}
