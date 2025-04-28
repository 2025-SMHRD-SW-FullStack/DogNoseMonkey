import java.util.Scanner;

public class TeamClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아무 숫자나 입력 : ");
		int num = sc.nextInt();
		System.out.println("한번 더 입력하시오 >> ");
		int num1 = sc.nextInt();
		
		System.out.println("팀장 첫번째");
		System.out.println("서명우 바보");  
		System.out.println("홍준모 바보");
		System.out.println("김승혁 바보");
		System.out.println("Team 개코원숭이");
		System.out.println("나만의 작업공간 branch");
		System.out.println(num);
		System.out.println(num1);
	}
}