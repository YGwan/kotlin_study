# kotlin study

* '단국대 - 모바일 프로그래밍' 수업을 기반을 한 kotlin 공부.       
* 과제 및 개념 공부
* 시험을 통한 코드구현

## kotlin 추가적인 실습
### * BMI 프로그램
      * 기본 코드
      
      * findViewById를 통해 xml 위젯의 값을 가져옴
      
      * ceil을 통해 반올림 처리
      
      * math.pow를 통해 거듭제곱 처리
      
      * setText를 통해 위젯에 값 입력
 
### * Timer 프로그램

      * Android 시스템은 응용프로그램이 시작될 때 단일 스레드로 새로운 Linux 프로세스를 시작합니다(=> Main Thread).
      
      * Main Tread
        * main 스레드에서만 UI 제어 또는 관리
        
        * main 스레드에서 어떤 무거운 작업도 수행하지 않아야 합니다.
          * 기본적으로 막음 - 무거운 작업을 시행하면 앱이 정지한 것처럼 보이기 때문에
          * 허용하려면 allowMainThreadQueries() 명령어 사용
        
        * 무거운 태스크를 수행하려면 background 스레드를 작성합니다.
        
        * Android는 다른 스레드가 위젯과 직접 통신하는 것을 허용하지 않습니다. 오직 main 스레드만 가능하다.
        
        * Timer는 background Tread를 사용하여 데이터 처리를 했다.
      
 
 ### * Structure of the thread
 
        * Message Queue:
          * Message Queue은 특정 스레드에서 실행될 작업 목록(테이블, 실행 파일)이 있는 대기열입니다.
          * 스레드당 하나의 Message Queue만 가질 수 있다.
         
         * Looper
          * 메시지 큐를 통해 루프를 수행하고 해당 스레드로 메시지를 전송하여 처리합니다
          * 스레드당 고유한 Looper 하나만 있음.
          * Main 스레드가 자동으로 Looper를 생성합니다.
         
         * Handler
          * 스레드 메시지 대기열과 연결된 메시지 및 실행 가능한 오브젝트 전송 및 처리


<img width="953" alt="Tread" src="https://user-images.githubusercontent.com/50222603/143299249-62ab7bd4-79d4-4e03-be6d-5d13aaf6fd0d.png">
 
 
 ### * mnist 데이터셋 분석한 것을 바탕으로 안드로이드와 연결하기
 
 https://developer.android.com/codelabs/digit-classifier-tflite#0 사이트를 기반으로 연동
          
           --------- we already have trained model ---------
         
               * Create your MNIST model
               * Train with the data
               * Get the trained model
         
          --------- Convert  the  trained  TensorFlow  model  --------- 
                     with  the TensorFlow  Lite Converter
         
               * Convert to TensorFlow Lite model
               * Save model to file(mnist.tflite)
                
          ---------- Part of android.app coding  ----------
              
               * Create android app.
               * Import model file (Create interpreter)
               * Get input(Handwritten digit) from user
               * Run Inference
               * Show result
     
 
<https://user-images.githubusercontent.com/50222603/145235756-4d86c631-bb4b-4a4b-a757-48b77e774172.mov>
