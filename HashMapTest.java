
import java.util.*;

import acm.program.ConsoleProgram;

public class HashMapTest extends ConsoleProgram {

	public void run() {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("ABC", "123");
		println(map.get("ABC"));
		
		map.put("ABC", "456");
		println(map.get("ABC"));
	}
	
	
	
}
