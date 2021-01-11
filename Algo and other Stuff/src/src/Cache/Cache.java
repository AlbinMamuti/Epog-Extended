package src.Cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class Cache {

	final int CAPACITY = 2;
	HashMap<Integer, Integer> data = new LinkedHashMap<Integer, Integer>();

	void add(int value) {
		if (data.size() >= CAPACITY) {
			int victim_count = Integer.MAX_VALUE;
			Integer victim = null;
			Set<Integer> keys = data.keySet();
			Iterator it = keys.iterator();
			while (it.hasNext()) {
				Integer next = (Integer) it.next();
				if (data.get(next) < victim_count) {
					victim = next;
					victim_count = data.get(next);
				}
			}
			data.remove(victim);
			data.put(value, 1);
		} else {
			data.put(value, 1);
		}
	}

	void access(int value) {
		Integer now = data.get(value);
		if (now == null) {
			add(value);
		} else {
			data.put(value, now + 1);
		}
	} // access
	void print()

	{
		data.entrySet().forEach(entry -> {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		});
	} // print} // Cache
}
