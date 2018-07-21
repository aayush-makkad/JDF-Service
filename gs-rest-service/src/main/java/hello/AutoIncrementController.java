package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;

@RestController
public class AutoIncrementController {

	@RequestMapping("/auto")
	public String autoIncrement(@RequestParam("column")String col,
								@RequestParam("seed")int seed){
		
		try{
			process.setAutoIncrement(col, seed);
			return "OK";
		}catch(Exception e){
			return e.toString();
		}
	}
	
}
