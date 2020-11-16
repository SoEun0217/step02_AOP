package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("kosta/exam/applicationContext.xml");
		MessageService service = context.getBean("target",MessageService.class);//꼭 Interface로 해야된다..
		UserService user = context.getBean("target2",UserService.class);
		//J2SE가 Interface로 호출을 하는 것이기 때문이다..
		
		//MessageService service = context.getBean("target",MessageServiceImpl.class);
		
		/*
		 * service.engHello(); System.out.println("=============================");
		 */
		service.korHello();
		System.out.println("===========================");
		/*
		 * String result1= service.hello(); System.out.println("hello() 리턴결과 "+result1);
		 * System.out.println("========================="); int result =
		 * service.hello("소은"); System.out.println(" hello(String name) 리턴결과"+ result);
		 * System.out.println("================================");
		 * 
		 * String result3= user.testHello();
		 * System.out.println("testHello()의 리턴결과"+result3);
		 * System.out.println("==============================="); user.insertHello(1,
		 * 4); System.out.println("===============================");
		 */
	}

}
