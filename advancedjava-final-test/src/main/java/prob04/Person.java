package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	public Person() {
		age = 12;
		name = "";
		numberOfPerson++;
		
	}
	public Person( String name ){
		age = 12;
		this.name = name;
		numberOfPerson++;
	}
	
	public Person(int age, String name){
		this(name);
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void selfIntroduce(){
		System.out.println("내 이름은 "+this.name+"이며, 나이는 "+this.age+"입니다.");
		
		// "내 이름은 ...이며, 나이는 ...살입니다." 출력함
		// 예) 내이름은 김철수이며, 나이는 19살 입니다.
	}

	static int getPopulation(){
		return numberOfPerson;
	}
}

