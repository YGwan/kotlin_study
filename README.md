# kotlin study1
## 코틀린의 class 초기화 방법

 #* 방법 1: init{}블럭 사용. 
    init 블록에는 클래스의 객체가 만들어질 때 실행될 초기화 코드가 들어간다. 
    init 블록은 주로 primary constructor과 함께 사용된다.
  
 * 방법 2: constructor 사용.   
    1. primary constructor. 
    1개만 사용 가능, class header부분에 위치함. 
    ex) class Car(var model:String, var color:String)
    
  
  *secondary constructor 사용. 
      primary가 존재한다면 secondary는 무조건 primary에게 직간접적으로 생성을 위임해야한다.
      여러개를 사용 할 수 있다.
   
   * 실행 순서. 
      init블록이 부생성자보다 먼저 실행됨!
