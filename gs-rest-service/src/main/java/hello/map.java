package hello;

import process.process;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class map {
	
	@RequestMapping("/map")
	public String map(){
		
		try{
			process.CreateMappings();
			return "Mappings done OK";
			
		}
		catch(Exception e){
			return e.toString();
		}
		
	}
	

}
