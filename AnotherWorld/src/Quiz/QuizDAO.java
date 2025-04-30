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
}

