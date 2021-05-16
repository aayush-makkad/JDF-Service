package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;

@RestController
public class ChangeTableNameController {
	
	@RequestMapping("changetable")
	public String changeTableName(@RequestParam("oldname")String oldname,
								  @RequestParam("newname")String newname){
		try{
			process.ChangeTableName(newname, oldname);
			return "table name "+oldname+" changed to "+newname;
		}catch(Exception e){
			return e.toString();
		}
		
	}
	

}
