package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

//@Test
public class MyListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution started");
    }

    @Override
    public void onTestStart(ITestResult result) {
//        ITestListener.super.onTestStart(result);
        System.out.println("test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        ITestListener.super.onTestSuccess(result);
        System.out.println("test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        ITestListener.super.onTestFailure(result);
        System.out.println("test faild");
    }

    @Override
    public void onFinish(ITestContext context) {
//        ITestListener.super.onFinish(context);
        System.out.println("test execution finished");
    }
}
