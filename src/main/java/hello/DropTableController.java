package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;

@RestController
public class DropTableController {
	
	@RequestMapping("droptable")
	public String droptable(@RequestParam("table") String table){
		
		try{
			
			process.DropTable(table);
			return "Table "+table+" dropped succesfully!";
		}catch(Exception e){
			return e.toString();
		}
		
	}
	

}
