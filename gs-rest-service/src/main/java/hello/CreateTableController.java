package hello;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xml.processing.XMLdataStaging;

@RestController
public class CreateTableController {
	
	
	@RequestMapping("/create")
	public String createTable(HttpServletRequest request){
		
		String br;
	
		try {
			 br = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return e.toString();
		}
		if(!br.equalsIgnoreCase(null)){
			
			//return br;
			try {
				PrintWriter pr = new PrintWriter("process-create.xml");
				pr.write(br);
				pr.close();
				XMLdataStaging.main(null);
				return br;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				return e.toString();
			}
			
			
		}else{
			return "Empty Body";
		}
	}
	

}
