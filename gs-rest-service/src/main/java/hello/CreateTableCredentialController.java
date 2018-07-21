package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;

@RestController
public class CreateTableCredentialController {
	
	@RequestMapping("/init")
	public String updateCred(@RequestParam("connect")String connectString,
							 @RequestParam("table")String table,
							 @RequestParam("user")String user,
							 @RequestParam("pass")String pass){
		try{
		process.UpdateCredentials(connectString, table, user, pass);
		return "OK";
		}catch(Exception e){
			return e.toString();
		}
		
		
		
	}

}
