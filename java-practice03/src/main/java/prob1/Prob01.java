package prob1;

public class Prob01 {

	public static void main(String[] args) {
		Member member = new Member();
		member.setId("1");
		member.setName("홍길동");
		member.setPoint(5);
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getPoint());

	}

}
