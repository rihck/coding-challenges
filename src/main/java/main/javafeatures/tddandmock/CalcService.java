package main.javafeatures.tddandmock;

/**
 * Main Class CalcService that has dependency on AddService that we should mock in our tests.
 */
public class CalcService {
    private AddService addService;

    public CalcService(AddService addService) {
        this.addService = addService;
    }

    public int calc(int num1, int num2) {
        System.out.println("**--- CalcService calc executed ---**");
        return addService.add(num1, num2);
    }
}
