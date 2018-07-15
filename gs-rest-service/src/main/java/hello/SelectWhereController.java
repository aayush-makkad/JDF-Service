package hello;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import process.process;

@RestController
public class SelectWhereController {
	
	
	LinkedHashMap<String,Object> res = new LinkedHashMap<String,Object>();
	ArrayList<Object> intres = new ArrayList<Object>();
	
	@RequestMapping("/getwhere")
	public LinkedHashMap<String,Object> getWhere(@RequestParam("table") String table,
										   @RequestParam("column") String column,
										   @RequestParam("condition") String cond
															){
		
		intres = process.SelectWhere(table, column, cond);
		int i =0;
		res.clear();
		for(Object o : intres){
			i++;
			res.put("Column "+i+"-->", o);
			
		}
		
		return res;
		
	}

}
