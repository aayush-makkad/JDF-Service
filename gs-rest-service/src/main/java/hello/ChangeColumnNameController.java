package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;

@RestController
public class ChangeColumnNameController {

	@RequestMapping("/changecol")
	public String changeColName(@RequestParam("table")String table,
								@RequestParam("oldname")String oldname,
								@RequestParam("newname")String newname){
		
		
		try{
			process.ChangeColumnName(table, oldname, newname);
			return "Column name of table "+table+" changed from "+oldname+" to "+newname;
		}catch(Exception e){
			return e.toString();
		}
		
	}
	
}
