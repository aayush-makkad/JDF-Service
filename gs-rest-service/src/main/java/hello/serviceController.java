package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;


@RestController
public class serviceController {

	
	@RequestMapping("/service")
	public ArrayList<Object> _serice(){
		
		return process.SelectAll("test_table");
		
	}
	
	
}
