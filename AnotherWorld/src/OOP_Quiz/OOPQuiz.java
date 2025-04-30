package OOP_Quiz;

public class OOPQuiz {

    // Question 클래스 정의 (정답 비교 기능 포함)
    static class Question {
        String questionText;
        String correctAnswer;

        Question(String questionText, String correctAnswer) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
        }

        boolean isCorrect(String userAnswer) {
            return userAnswer.trim().equals(correctAnswer);
        }
    }

    // 문제와 정답을 담은 배열
    public Question[] getQuestions() {
        return new Question[] {
            new Question("Q1. 클래스 외부에서 필드를 보호하기 위해 사용하는 접근 제어자는?\nA) public  B) private  C) static  D) abstract", "private"),
            new Question("Q2. 두 개 이상의 생성자를 정의하는 것을 무엇이라고 하나요?\nA) 상속  B) 오버로딩  C) 오버라이딩  D) 캡슐화", "오버로딩"),
            new Question("Q3. 하나의 메서드를 자식 클래스에서 다르게 구현하는 것은?\nA) 오버로딩  B) 다형성  C) 오버라이딩  D) 상속", "오버라이딩"),
            new Question("Q4. 여러 클래스가 동일한 인터페이스를 구현하여 다른 동작을 하는 성질은?\nA) 캡슐화  B) 다형성  C) 상속  D) 추상화", "다형성"),
            new Question("Q5. 객체 간 코드의 재사용성을 높여주는 OOP 특징은?\nA) 상속  B) 추상화  C) 다형성  D) 캡슐화", "상속"),
            new Question("Q6. 인스턴스를 생성하지 않고 클래스명으로 직접 접근할 수 있는 키워드는?\nA) final  B) static  C) abstract  D) private", "static"),
            new Question("Q7. 객체지향에서 속성과 동작을 하나로 묶는 개념은?\nA) 상속  B) 추상화  C) 캡슐화  D) 클래스", "캡슐화"),
            new Question("Q8. 설계도 역할을 하며 인스턴스를 만들 수 없는 클래스는?\nA) static  B) 인터페이스  C) 추상 클래스  D) final 클래스", "추상 클래스"),
            new Question("Q9. 메서드나 클래스에서 더 이상 오버라이딩할 수 없게 만드는 키워드는?\nA) final  B) static  C) abstract  D) private", "final"),
            new Question("Q10. 클래스가 여러 개의 인터페이스를 동시에 구현할 수 있게 하는 자바 특징은?\nA) 다중상속  B) 다형성  C) 오버라이딩  D) 인터페이스", "인터페이스")
        };
    }
}