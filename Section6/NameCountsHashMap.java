package Section6;

/**
 * Use hashmap to resolve again NameCounts
 * @author liu.cheng
 *
 */

import acm.program.*;
import java.util.*;

public class NameCountsHashMap extends ConsoleProgram {

	public void run() {
		//ArrayList<HashMap<String,Integer>> arr = new ArrayList<HashMap<String, Integer>>();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		while(true) {
			String name = readLine("Enter a name: ");
			if(name.equals(SENTINEL)) break;
			if (map.containsKey(name) ) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}

			
//		//遍历keySet 效率较低
//		Iterator it = map.keySet().iterator();
//		while(it.hasNext()) {
//			String key = (String)it.next();
//			println(key + " counts " + map.get(key));
//		}
		
		//遍历entrySet 效率高
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			println(entry.getKey() + " counts " + entry.getValue());
		}
		
	}
	
	/* CONSTANTS */
	private static final String SENTINEL = "";
}
