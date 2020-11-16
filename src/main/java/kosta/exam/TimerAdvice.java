package kosta.exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 *  공통기능 구현   - 사전 , 사후 처리 (around방식)
 *  
 *   around방식 : 매개변수로 ProceedingJoinPoint  선언
 *   
 *   - 사전 : 현재 시간 구하기
 *   
 *   - 사후 : 현재 시간 구하기, 사후시간 - 사전시간 = 총 소요시간 
 *   
 *   - joinPoint : 기본 메소드에 대한 시그너쳐의 정보를 제공한다.
 *   			  (modifier, 리턴타입, 메소드이름, 인수 .. 정보제공)
 *   
 *   - ProceedingJoinPoint : JoinPoint를 확장한 개념으로 실제 joinPoint(타겟대상)를 호출
 *   						할 수 있는 메소드를 제공한다.
 *   
 *    리턴타입 : Object -> proceed()메소드를 호출한 후 그 메소드가 리턴한 값을
 *    						받아서 다시 리턴해준다.
 *   
 *   즉, around방식을 사용할 때는 ProceedingJoinPint를 이용해서
 *   타겟대상을 호출해준다.
 * */
public class TimerAdvice{

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//사전처리
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LOG] "+methodName + " 호출 되기 전 사전처리...");
		StopWatch sw = new StopWatch();
		sw.start();
		
		//실제타겟대상인 메소드(joinPoint)를 호출
		
		Object obj = joinPoint.proceed();
		
		//사후처리
		
		sw.stop();
		System.out.println("[LOG] "+methodName +"의 리턴값 obj = "+obj);
		System.out.println("[LOG] "+methodName +"의 총 실행시간 : "+sw.getTotalTimeMillis()+"ms");
		System.out.println("[LOG] "+methodName +"의 호출완료 \n");
		
		return obj;//꼭 다시 리턴해주어야한다.!!!
		
	}
}





