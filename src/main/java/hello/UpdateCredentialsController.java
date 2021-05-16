package hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entry.input.MappingPropertyHandler;

@RestController
public class UpdateCredentialsController {
	
	
	
	@RequestMapping("/credentials")
	public String updateCredentials(@RequestParam("connection") String connString,
									@RequestParam("db") String database,
									@RequestParam("user") String user,
									@RequestParam("pass") String pass){
		try{
		new MappingPropertyHandler(connString,database,user,pass);
		return "OK";
		}
		catch(Exception e){
			return e.toString();
		}
		
		
	}
	

}
