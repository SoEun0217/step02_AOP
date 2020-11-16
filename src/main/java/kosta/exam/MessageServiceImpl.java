package kosta.exam;

import org.springframework.aop.framework.AopContext;

public class MessageServiceImpl implements MessageService {

	@Override
	public void korHello() {
		System.out.println("MessageServiceImpl의 korHello()메소드의 핵심 기능입니다.");
		try {
			Thread.sleep(1000);//지연시간 주기
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("########################################");
		//engHello()호출해본다..
		//this.engHello();
		//내가 직접 다른 메소드를 호출하면 사전사후처리 불가한다.
		//proxy server에 연결이 되어야 가능하지만 지금같은 상황은 직접 호출하게 된것 - 사전후 처리하지못한다..
		
		//현재 AOP proxy Server에서 직접 호출을 요청한다.
		MessageService service = (MessageService)AopContext.currentProxy();
		service.engHello();
		System.out.println("#######################################");
	}

	@Override
	public void engHello() {
		System.out.println("MessageServiceImpl의 engHello()메소드의 핵심 기능입니다.");
		try {
			Thread.sleep(1500);//지연시간 주기
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String hello() {
		System.out.println("MessageServiceImpl의 hello()메소드의 핵심 기능입니다.");
		try {
			Thread.sleep(1500);//지연시간 주기
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return "안녕";
	}

	@Override
	public int hello(String name) {
		System.out.println("MessageServiceImpl의  hello(String name)메소드의 핵심 기능입니다.");
		try {
			Thread.sleep(2000);//지연시간 주기
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return 100;
	}

}
