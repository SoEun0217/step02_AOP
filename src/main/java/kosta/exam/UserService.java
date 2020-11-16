package kosta.exam;

public class UserService {
	public String testHello() {
		System.out.println("UserService의 testHello()핵심기능입니다...");
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return "졸려";
	}
	
	public void insertHello(int i ,int j) {
		System.out.println("UserService의 insertHello(int i,int j)핵심기능입니다...");
		try {
			Thread.sleep(1500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
