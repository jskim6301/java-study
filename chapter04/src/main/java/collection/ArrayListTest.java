package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("고길동");
		
		//순회1
		int count = list.size();
		for(int i=0;i<count;i++) {
			String s = list.get(i);
			System.out.println(s);
		}

		list.remove(1);
		list.remove(new String("둘리"));//값이 같은 객체를 비교하여 제거한다.  (다른 객체라도 값이 같으면 삭제)
		
		//순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		
		//순회3(for~each)
		for(String s : list) {
			System.out.println(s);
		}
		
	}

}
