package Quiz;

// DTO (Data Transfer Object) - 퀴즈 문제 정보를 담는 클래스
public class QuizDTO {
    private String questionText;
    private String correctAnswer;

    public QuizDTO(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(String userAnswer) {
        return userAnswer.trim().equals(correctAnswer);
    }
}
