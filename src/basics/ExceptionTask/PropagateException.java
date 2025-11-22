package model;

public class PropagateException {

    public void exceptionMethod() throws Exception {
        throw new Exception(" exception happened");
    }

    public void callingMethod() throws Exception {
        exceptionMethod();
    }

}
