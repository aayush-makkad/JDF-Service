package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;


@RestController
public class serviceController {
	
	
	LinkedHashMap<String,Object> res = new LinkedHashMap<String,Object>();
	ArrayList<Object> get = new ArrayList<Object>();
	
	@RequestMapping("/getall")
	public HashMap<String,Object> _serice(@RequestParam(value="table", defaultValue="test_table") String tablename){
		
		
		get = process.SelectAll(tablename);
		int i =0;
		res.clear();
		for(Object o : get){
			i++;
			res.put("Column "+i+"-->", o);		
		}
		return res;
		}
	
	
	
}
