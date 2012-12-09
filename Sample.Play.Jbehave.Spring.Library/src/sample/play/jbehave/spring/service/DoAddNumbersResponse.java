package sample.play.jbehave.spring.service;

public class DoAddNumbersResponse {
    private Integer result;

    public DoAddNumbersResponse(Integer result) {
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }
}