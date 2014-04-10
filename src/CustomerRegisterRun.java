import java.io.File;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class CustomerRegisterRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sheet sheet;
		Workbook book = null;
		CustomerRegister customerRegister = new CustomerRegister();
		XStream xstream = new XStream();
		customerRegister.setCustomerType("C");
		customerRegister.setDevicNum("test");
		customerRegister.setIdentityType("I");
		customerRegister.setLoginPassWord("");
		customerRegister.setLoginPwdStrength("A");
		customerRegister.setPayPassword("");
		customerRegister.setPayPwdStrength("A");
		customerRegister.setProperty("1");
		customerRegister.setRegType("common");
		customerRegister.setRegChannel("M-10001");
		customerRegister.setRegWay("M");

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
		String name;
		String identityNumber;
		String regAccount;
		for (int i = 1; i < sheet.getRows(); i++) {
			name = sheet.getCell(0, i).getContents();
			identityNumber = sheet.getCell(1, i).getContents();
			regAccount = sheet.getCell(2,i).getContents();
			System.out.println(name + identityNumber);
			customerRegister.setRealName(name);
			customerRegister.setIdentityNumber(identityNumber);
			customerRegister.setRegAccount(regAccount);
			String xml = xstream.toXML(customerRegister);
			System.out.println(xml);
		}
		book.close();


	}

}
