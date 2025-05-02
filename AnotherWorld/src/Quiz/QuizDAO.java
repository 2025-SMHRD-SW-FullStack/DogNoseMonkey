package Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizDAO { 
    private List<QuizDTO> questions;

    public QuizDAO() {
        questions = new ArrayList<>();
    }

    public List<QuizDTO> getQuestions(int questionSet) {
        questions.clear(); // 기존 문제 제거
        if (questionSet == 1) {
            loadQuestions1();
        } else if (questionSet == 2) {
            loadQuestions2();
        } else if (questionSet == 3) {
        	loadQuestions3();
        }
        return questions;
    }

    private void loadQuestions1() {
        questions.add(new QuizDTO("Q1. for(int i=0; i<5; i++) System.out.print(i);  출력 결과는?\n보기: [1] 12 [2] 012 [3] 1234 [4] 01234", "4"));
        questions.add(new QuizDTO("Q2. while(조건) 문에서 무한 루프를 만들려면 조건에 들어갈 말은?\n보기: [1] false [2] true [3] not [4] and", "2"));
        questions.add(new QuizDTO("Q3. do-while 문은 최소 몇 번 이상 실행되는가?\n보기: [1] 0 [2] 1 [3] 2 [4] 3", "2"));
        questions.add(new QuizDTO("Q4. 다음 코드 실행 시 i 값은? int i=0; while(i<3){ i++; }\n보기: [1] 3 [2] 2 [3] 1 [4] 0", "1"));
        questions.add(new QuizDTO("Q5. for()문의 들어가는 식의 순서로 올바른 것은?\n보기: [1] 초기화;증감;조건 [2] 증감;초기화;조건 [3] 초기화;조건;증감 [4] 조건;초기화;증감", "3"));
        questions.add(new QuizDTO("Q6. break는 어떤 역할을 하나요?\n보기: [1] 종료 [2] 건너뛰기 [3] 시작 [4] 반복", "1"));
        questions.add(new QuizDTO("Q7. continue는 어떤 역할을 하나요?\n보기: [1] 시작 [2] 종료 [3] 반복 [4] 건너뛰기", "4"));
        questions.add(new QuizDTO("Q8. 다음 중 반복문이 아닌 것은?\n보기: [1] if [2] while [3] for [4] do-while", "1"));
        questions.add(new QuizDTO("Q9. for-each 문은 어떤 자료형에 자주 사용되나요?\n보기: [1] 정수 [2] 리스트 [3] 배열 [4] 상수", "3"));
        questions.add(new QuizDTO("Q10. 중첩 반복문이란 무엇인가요? (간단히: 반복문 안에 OOO)\n보기: [1] 루프문 [2] 조건문 [3] 반복문 [4] 취소문", "3"));
    }

    private void loadQuestions2() {
        questions.add(new QuizDTO("Q1. 클래스 외부에서 필드를 보호하기 위해 사용하는 접근 제어자는?\n보기: [1] public  [2] private  [3] static  [4] abstract", "2"));
        questions.add(new QuizDTO("Q2. 두 개 이상의 생성자를 정의하는 것을 무엇이라고 하나요?\n보기: [1] 상속  [2] 오버로딩  [3] 오버라이딩  [4] 캡슐화", "2"));
        questions.add(new QuizDTO("Q3. 하나의 메서드를 자식 클래스에서 다르게 구현하는 것은?\n보기: [1] 오버로딩  [2] 다형성  [3] 오버라이딩  [4] 상속", "3"));
        questions.add(new QuizDTO("Q4. 여러 클래스가 동일한 인터페이스를 구현하여 다른 동작을 하는 성질은?\n보기: [1] 캡슐화  [2] 다형성  [3] 상속  [4] 추상화", "2"));
        questions.add(new QuizDTO("Q5. 객체 간 코드의 재사용성을 높여주는 OOP 특징은?\n보기: [1] 상속  [2] 추상화  [3] 다형성  [4] 캡슐화", "1"));
        questions.add(new QuizDTO("Q6. 인스턴스를 생성하지 않고 클래스명으로 직접 접근할 수 있는 키워드는?\n보기: [1] final  [2] static  [3] abstract  [4] private", "2"));
        questions.add(new QuizDTO("Q7. 객체지향에서 속성과 동작을 하나로 묶는 개념은?\n보기: [1] 상속  [2] 추상화  [3] 캡슐화  [4] 클래스", "3"));
        questions.add(new QuizDTO("Q8. 설계도 역할을 하며 인스턴스를 만들 수 없는 클래스는?\n보기: [1] static  [2] 인터페이스  [3] 추상 클래스  [4] final 클래스", "3"));
        questions.add(new QuizDTO("Q9. 메서드나 클래스에서 더 이상 오버라이딩할 수 없게 만드는 키워드는?\n보기: [1] final  [2] static  [3] abstract  [4] private", "1"));
        questions.add(new QuizDTO("Q10. 클래스가 여러 개의 인터페이스를 동시에 구현할 수 있게 하는 자바 특징은?\n보기: [1] 다중상속  [2] 다형성  [3] 오버라이딩  [4] 인터페이스", "4"));
    }
    
    private void loadQuestions3() {
        questions.add(new QuizDTO("Q1. Java에서 상속을 구현하는 데 사용되는 키워드는 무엇인가요?(주관식)", "extends"));
        questions.add(new QuizDTO("Q2. 다음 중 Java에서 올바른 상속 구문은 무엇인가요?\n보기: [1] class Child : Parent {}\n[2] class Child inherits Parent {}\n[3] class Child extends Parent {}\n[4] class Child implements Parent {}", "3"));
        questions.add(new QuizDTO("Q3. 슈퍼 클래스의 생성자를 호출하기 위해 서브 클래스에서 사용하는 키워드는 무엇인가요?(주관식)\n", "super"));
        questions.add(new QuizDTO("Q4. Java에서 상속의 주요 이점은 무엇인가요?\n보기: [1] 코드 재사용성\n[2] 향상된 성능\n[3] 더 나은 메모리 관리\n[4] 더 빠른 컴파일 시간", "1"));
        questions.add(new QuizDTO("Q5. 클래스가 다른 클래스를 상속할 때 어떤 유형의 관계가 형성되나요?\n보기: [1] \"has-a\" 관계\n[2] \"is-a\" 관계\n[3] \"uses-a\" 관계\n[4] \"depends-on\" 관계", "2"));
        questions.add(new QuizDTO("Q6. 다음 클래스 다이어그램에서 어떤 클래스가 슈퍼 클래스인가요?(주관식)\n(UML 다이어그램, Vehicle -> Car)", "Vehicle"));
        questions.add(new QuizDTO("Q7. 서브 클래스에서 슈퍼 클래스의 메서드를 재정의하는 것을 무엇이라고 하나요?(주관식)\n", "오버라이딩"));
        questions.add(new QuizDTO("Q8. 다음 코드의 출력은 무엇인가요?(주관식)\nclass Animal {\n    String makeSound() {\n        return \"Generic Sound\";\n    }\n}\nclass Dog extends Animal {\n    String makeSound() {\n        return \"Bark\";\n    }\n}\npublic class Main {\n    public static void main(String[] args) {\n        Animal myDog = new Dog();\n        System.out.println(myDog.makeSound());\n    }\n}\n", "Bark"));
        questions.add(new QuizDTO("Q9. 다음 중 Java의 상속 유형에 대한 설명으로 올바른 것은 무엇인가요?\n보기: [1] Java는 다중 상속을 지원합니다.\n[2] Java는 단일 상속만 지원합니다.\n[3] Java는 인터페이스를 통한 다중 상속을 지원합니다.\n[4] Java는 상속을 전혀 지원하지 않습니다.", "2"));
        questions.add(new QuizDTO("Q10. 다음 클래스 선언에서 `final` 키워드의 목적은 무엇인가요? `final class MyClass {}`\n보기: [1] 클래스를 추상 클래스로 만듭니다.\n[2] 클래스가 상속될 수 없도록 합니다.\n[3] 클래스를 정적 클래스로 만듭니다.\n[4] 클래스의 접근 수준을 private으로 설정합니다.", "2"));
    }    
}
