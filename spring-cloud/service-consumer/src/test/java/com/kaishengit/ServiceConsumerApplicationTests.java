package com.kaishengit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceConsumerApplicationTests {

	@Test
	public void contextLoads() {
	}

	Map<String,String> map = new ConcurrentHashMap<>();

	List list = Collections.synchronizedList(new ArrayList<>());

	@Test
	public void hashMapText(){

		Map<Integer, String> stringMap = new HashMap();
		stringMap.put(1,"nihao");
		stringMap.put(4323, "hehe");
		stringMap.put(123123, "哈哈哈哈哈哈哈");

		Set<Map.Entry<Integer, String>> entries = stringMap.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
		while (iterator.hasNext()){
			Map.Entry<Integer, String> next = iterator.next();
			Integer key = next.getKey();
			String value = next.getValue();
			System.out.println(key + value);
		}


	}

}
