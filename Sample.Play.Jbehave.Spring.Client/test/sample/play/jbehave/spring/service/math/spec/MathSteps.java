package sample.play.jbehave.spring.service.math.spec;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.play.jbehave.spring.service.DoAddNumbersRequest;
import sample.play.jbehave.spring.service.DoAddNumbersResponse;
import sample.play.jbehave.spring.service.IMathService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Component
public class MathSteps {
    private DoAddNumbersRequest doAddNumbersRequest = new DoAddNumbersRequest();
    private DoAddNumbersResponse doAddNumbersResponse;

    @Autowired
    private IMathService mathService;

    @Given("First number = $firstNumber")
    public void firstNumberIs(int firstNumber) {
        this.doAddNumbersRequest.setFirstNumber(firstNumber);
    }

    @Given("Second number = $secondNumber")
    public void secondNumberIs(int secondNumber) {
        this.doAddNumbersRequest.setSecondNumber(secondNumber);
    }

    @When("Adding the First & Second number")
    public void addingTheFirstAndSecondNumber() {
        // Do something
        assertThat(mathService, notNullValue());
        //dummyService = new DummyService();
        doAddNumbersResponse = mathService.doAddNumbers(doAddNumbersRequest);
    }

    @Then("the addition's result is $expectedResult")
    public void theGridShouldLookLike(int expectedResult) {
        // Evaluate result
        assertThat(doAddNumbersResponse.getResult(), equalTo(expectedResult));
    }

}