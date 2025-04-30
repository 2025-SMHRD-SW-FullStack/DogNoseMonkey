package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        questions.add(new QuizDTO("Q1. for(int i=0; i<5; i++) { System.out.print(i); } 출력 결과는?", "01234"));
        questions.add(new QuizDTO("Q2. while(조건) 문에서 무한 루프를 만들려면 조건에 들어갈 말은?", "true"));
        questions.add(new QuizDTO("Q3. do-while 문은 최소 몇 번 이상 실행되는가? (한 글자)", "1"));
        questions.add(new QuizDTO("Q4. 다음 코드 실행 시 i 값은? int i=0; while(i<3){ i++; }", "3"));
        questions.add(new QuizDTO("Q5. for()문의 기본 구성은?", "초기화;조건;증감"));
        questions.add(new QuizDTO("Q6. break는 어떤 역할을 하나요?", "종료"));
        questions.add(new QuizDTO("Q7. continue는 어떤 역할을 하나요?", "건너뛰기"));
        questions.add(new QuizDTO("Q8. 다음 중 반복문이 아닌 것은? (if/while/for/do-while 중)", "if"));
        questions.add(new QuizDTO("Q9. for-each 문은 어떤 자료형에 자주 사용되나요?", "배열"));
        questions.add(new QuizDTO("Q10. 중첩 반복문이란 무엇인가요? (간단히: 반복문 안에 OOO)", "반복문"));
    }

    private void loadQuestions2() {
        questions.add(new QuizDTO("Q1. 클래스 외부에서 필드를 보호하기 위해 사용하는 접근 제어자는?\nA) public  B) private  C) static  D) abstract", "private"));
        questions.add(new QuizDTO("Q2. 두 개 이상의 생성자를 정의하는 것을 무엇이라고 하나요?\nA) 상속  B) 오버로딩  C) 오버라이딩  D) 캡슐화", "오버로딩"));
        questions.add(new QuizDTO("Q3. 하나의 메서드를 자식 클래스에서 다르게 구현하는 것은?\nA) 오버로딩  B) 다형성  C) 오버라이딩  D) 상속", "오버라이딩"));
        questions.add(new QuizDTO("Q4. 여러 클래스가 동일한 인터페이스를 구현하여 다른 동작을 하는 성질은?\nA) 캡슐화  B) 다형성  C) 상속  D) 추상화", "다형성"));
        questions.add(new QuizDTO("Q5. 객체 간 코드의 재사용성을 높여주는 OOP 특징은?\nA) 상속  B) 추상화  C) 다형성  D) 캡슐화", "상속"));
        questions.add(new QuizDTO("Q6. 인스턴스를 생성하지 않고 클래스명으로 직접 접근할 수 있는 키워드는?\nA) final  B) static  C) abstract  D) private", "static"));
        questions.add(new QuizDTO("Q7. 객체지향에서 속성과 동작을 하나로 묶는 개념은?\nA) 상속  B) 추상화  C) 캡슐화  D) 클래스", "캡슐화"));
        questions.add(new QuizDTO("Q8. 설계도 역할을 하며 인스턴스를 만들 수 없는 클래스는?\nA) static  B) 인터페이스  C) 추상 클래스  D) final 클래스", "추상 클래스"));
        questions.add(new QuizDTO("Q9. 메서드나 클래스에서 더 이상 오버라이딩할 수 없게 만드는 키워드는?\nA) final  B) static  C) abstract  D) private", "final"));
        questions.add(new QuizDTO("Q10. 클래스가 여러 개의 인터페이스를 동시에 구현할 수 있게 하는 자바 특징은?\nA) 다중상속  B) 다형성  C) 오버라이딩  D) 인터페이스", "인터페이스"));
    }
    
    private void loadQuestions3() {
        questions.add(new QuizDTO("Q1. Java에서 상속을 구현하는 데 사용되는 키워드는 무엇인가요?", "extends"));
        questions.add(new QuizDTO("Q2. 다음 중 Java에서 올바른 상속 구문은 무엇인가요?\nA) class Child : Parent {}\nB) class Child inherits Parent {}\nC) class Child extends Parent {}\nD) class Child implements Parent {}", "class Child extends Parent {}"));
        questions.add(new QuizDTO("Q3. 슈퍼 클래스의 생성자를 호출하기 위해 서브 클래스에서 사용하는 키워드는 무엇인가요?", "super"));
        questions.add(new QuizDTO("Q4. Java에서 상속의 주요 이점은 무엇인가요?\nA) 코드 재사용성\nB) 향상된 성능\nC) 더 나은 메모리 관리\nD) 더 빠른 컴파일 시간", "코드 재사용성"));
        questions.add(new QuizDTO("Q5. 클래스가 다른 클래스를 상속할 때 어떤 유형의 관계가 형성되나요?\nA) \"has-a\" 관계\nB) \"is-a\" 관계\nC) \"uses-a\" 관계\nD) \"depends-on\" 관계", "is-a"));
        questions.add(new QuizDTO("Q6. 다음 클래스 다이어그램에서 어떤 클래스가 슈퍼 클래스인가요?\n(UML 다이어그램, Vehicle -> Car)", "Vehicle"));
        questions.add(new QuizDTO("Q7. 서브 클래스에서 슈퍼 클래스의 메서드를 재정의하는 것을 무엇이라고 하나요?", "오버라이딩"));
        questions.add(new QuizDTO("Q8. 다음 코드의 출력은 무엇인가요?\nclass Animal {\n    String makeSound() {\n        return \"Generic Sound\";\n    }\n}\nclass Dog extends Animal {\n    String makeSound() {\n        return \"Bark\";\n    }\n}\npublic class Main {\n    public static void main(String[] args) {\n        Animal myDog = new Dog();\n        System.out.println(myDog.makeSound());\n    }\n}\n", "Bark"));
        questions.add(new QuizDTO("Q9. 다음 중 Java의 상속 유형에 대한 설명으로 올바른 것은 무엇인가요?\nA) Java는 다중 상속을 지원합니다.\nB) Java는 단일 상속만 지원합니다.\nC) Java는 인터페이스를 통한 다중 상속을 지원합니다.\nD) Java는 상속을 전혀 지원하지 않습니다.", "Java는 단일 상속만 지원합니다."));
        questions.add(new QuizDTO("Q10. 다음 클래스 선언에서 `final` 키워드의 목적은 무엇인가요? `final class MyClass {}`\nA) 클래스를 추상 클래스로 만듭니다.\nB) 클래스가 상속될 수 없도록 합니다.\nC) 클래스를 정적 클래스로 만듭니다.\nD) 클래스의 접근 수준을 private으로 설정합니다.", "클래스가 상속될 수 없도록 합니다."));
    }
    
}
