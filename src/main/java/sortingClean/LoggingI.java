package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingI {
    long startTimeI=0;
   static long totalTimeI=0;
   static int num=0;

    @Pointcut("execution(void sortingClean.InsertionSort.sort(..))")
    private void selectI() {
    }
    @Before("selectI()")
    public void beforeAdvice(JoinPoint jp) {
        num++;
        if (startTimeI!=0) {
            startTimeI = System.currentTimeMillis();
        }
    }

    @After("selectI()")
    public void afterAdvice(JoinPoint jp) {
        totalTimeI += System.currentTimeMillis() - startTimeI;
    }
}
