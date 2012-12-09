package sample.play.jbehave.spring.service;

import org.springframework.stereotype.Service;

/**
 * Created by Xtremecodes.asia @2012
 * User: saintc0d3r@gmail.com
 * Date: 12/9/12
 * Time: 11:46 AM
 */

@Service
public class MathService implements IMathService {
    @Override
    public DoAddNumbersResponse doAddNumbers(DoAddNumbersRequest doAddNumbersRequest) {
        return new DoAddNumbersResponse(doAddNumbersRequest.getFirstNumber() + doAddNumbersRequest.getSecondNumber());
    }
}
