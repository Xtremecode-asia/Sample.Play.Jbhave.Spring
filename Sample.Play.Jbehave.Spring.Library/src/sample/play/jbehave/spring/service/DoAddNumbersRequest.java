package sample.play.jbehave.spring.service;

public class DoAddNumbersRequest {
    private int firstNumber;
    private int secondNumber;

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }
}