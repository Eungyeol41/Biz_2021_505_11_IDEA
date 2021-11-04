# Spring 개념에 DI(Dependency Injection), IOC(Inversion of Control)
* DI(Dependency Injection): 의존성 주입 
* IOC(Inversion of Control): 제어의 역전
* Ioc Container: DI를 수행하는 Ioc의 실질적인 주체

## 일반적인 클래스 간의 결합
* 클래스의 method를 사용하고자 하면, 필요한 곳에서 객체를 선언과 생성을 한다.  
Class obj = new Class()와 같은 코드로 생성을 한다.  
obj.method() 메서드를 호출하여 필요한 연산을 수행한다.
* Class 코드에서 다른 클래스를 결합하여 또 다른 연산을 수행할 경우  
또 Class1 obj1 = new Class1() 등의 코드를 사용하여 객체를 생성한다.  
만약 Class 코드에서 Class1의 다른 요소를 사용하고 싶으면 상당히 많은 부분의 코드 변경이 필요할 수 있다.  
이러한 변경은 결국 전체 프로젝트의 결합도를 높여 유지보수를 어렵게 한다.

# ICBMS: 4차 산업혁명 시대를 말하는 단어
* I: Information, Internet
* C: Communication
* B: BigData
* M: Mobile
* S: Security

## 6차산업
* 1차 산업: 농수임산림업 등을 통해서 얻어지는 자연 생산물
* 2차 산업: 1차산업에서 생산된 생산물을 공장에서 가공한 공산품
* 3차 산업: 1, 2차 산업에서 생산된 생산물과 공산품을 유통하는 서비스와 기타 모든 서비스 산업
* 6차 산업: 1 + 2 + 3 = 6, 직접 생산 직접 유통, 직접 소비의 시대

# ICT(정보통신기술)