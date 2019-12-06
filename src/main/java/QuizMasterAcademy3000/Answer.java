package QuizMasterAcademy3000;

public class Answer {

    private int id;
    private int questionid;
    private String answer;
    private boolean rightanswer; //1 if yes, 0 if no. Kan vara en boolean istället

    public Answer(int id, int questionid, String answer, boolean rightanswer) {
        this.id = id;
        this.questionid = questionid;
        this.answer = answer;
        this.rightanswer = rightanswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(boolean rightanswer) {
        this.rightanswer = rightanswer;
    }
}


