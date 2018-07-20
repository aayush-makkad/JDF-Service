package hello;

import process.process;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DropColumnController {

	@RequestMapping("/dropcol")
	public String dropCol(@RequestParam("table") String table,@RequestParam("column") String column){
		
		try{
			process.DropColumn(table, column);
			return "Column "+column+" from "+table+" dropped!";
			
		}catch(Exception e){
			return e.toString();
		}
		
		
	}
	
	
}
