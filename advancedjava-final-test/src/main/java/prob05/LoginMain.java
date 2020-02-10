package prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LoginMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		List<User> joinUsers = new ArrayList<User>();
		joinUsers.add( new User( "john", "1234") );//db에 저장되 있다 생각
		
		System.out.println("아이디를 입력하시오 : ");
		String id = scanner.nextLine();
		
		System.out.println("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();
		
		/*
		 *  로그인 처리 부분을 완성 합니다.
		 *  
		 *  
		 */
		
		try {
			User user = new User(id,password);
			
			login(joinUsers,user);
			System.out.println("로그인 성공");
		}catch(UserNotFoundException e) {
			System.out.println(e);
		}catch(PasswordDismatchException e) {
			System.out.println(e);
		}
		

	}
	
	public static void login(List<User> users, User user ) throws UserNotFoundException, PasswordDismatchException {
		if( !users.contains(user) ){
			throw new UserNotFoundException();
		}
		
		User savedUser = users.get( users.indexOf( user ) );//user 객체에 해당하는 인덱스값을 가져와서 저장된 user객체 변수 저장
		
		if( !savedUser.getPassword().equals( user.getPassword()) ){
			throw new PasswordDismatchException();
		}
	}
}
