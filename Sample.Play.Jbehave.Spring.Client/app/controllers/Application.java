package controllers;

import play.Logger;
import play.api.modules.spring.Spring;
import play.mvc.Controller;
import play.mvc.Result;
import sample.play.jbehave.spring.service.DoAddNumbersRequest;
import sample.play.jbehave.spring.service.IMathService;

import java.util.Map;

import views.html.*;

public class Application extends Controller {
    private static IMathService mathService = Spring.getBeanOfType(IMathService.class);

    //<editor-fold desc="-- Actions --">

    /**
     * Display index.scala.html page with initial values on its form
     * HTML Method: GET
     * URL: /
     * @return index.scala.html page
     */
    public static Result index(){
        return index(0,0,"");
    }

    /**
     * Receive form's values where is submitted from index.scala.html.
     * HTML Method: POST
     * URL: /addNumbers
     * @return index.scala.html.page which carries the math addition's result
     */
    public static Result addNumbers(){
        // Proceed only if math service is available
        if ( !initialiseMathService() ){
            return badRequest("Math service is unavailable");
        }

        Map<String, String[]> submittedValues = request().body().asFormUrlEncoded();
        int firstNumber = getSubmittedNumber("firstNumber", submittedValues);
        int secondNumber = getSubmittedNumber("secondNumber", submittedValues);

        return index(firstNumber, secondNumber, doAddNumbers(firstNumber, secondNumber).toString());
    }

    //</editor-fold>

    //<editor-fold desc=":: Helper Methods ::">
    private static Result index(Integer firstNumber, Integer secondNumber, String result) {
        return ok( index.render(".:: Play 2.0 & Spring's Sample ::.", "Let us do simple math. Adding 2 numbers through this page :D",
                                firstNumber.toString(), secondNumber.toString(), result) );
    }

    private static int getSubmittedNumber(String inputName, Map<String, String[]> submittedValues) {
        // TODO: Clean up the inputs
        if (submittedValues.get(inputName).length > 0){
            return tryParseInt(submittedValues.get(inputName)[0]);
        }
        return 0;
    }

    private static boolean initialiseMathService() {
        if (mathService == null){
            try{
                mathService = Spring.getBeanOfType(IMathService.class);
            }
            catch (Exception exception){
                exception.printStackTrace();
                String errorMessage = String.format("Error:%s. StackTrace:%s", exception.getMessage(), exception.getStackTrace());
                Logger.of("application").error( errorMessage );
            }
        }
        return mathService != null;
    }

    private static Integer doAddNumbers(int firstNumber, int secondNumber){
        DoAddNumbersRequest request = new DoAddNumbersRequest();
        request.setFirstNumber(firstNumber);
        request.setSecondNumber(secondNumber);
        return mathService.doAddNumbers(request).getResult();
    }

    private static int tryParseInt(String rawInt){
        try{
            return Integer.parseInt(rawInt);
        }
        catch(Exception exception){
            exception.printStackTrace();
            String errorMessage = String.format("Error: %s; StackTrace: %s", exception.getMessage(), exception.getStackTrace());
            Logger.of("application").error(errorMessage);
        }
        return 0;
    }
    //</editor-fold>
}
