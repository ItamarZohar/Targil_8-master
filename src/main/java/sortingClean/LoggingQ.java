package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingQ {
    long startTimeQ=0;
    static long totalTimeQ=0;
    static int num=0;

    @Pointcut("execution(void sortingClean.QuickSort.sort(..))")
    private void selectQ() {
    }
    @Before("selectQ()")
    public void beforeAdvice(JoinPoint jp) {
        num++;
        if (startTimeQ!=0) {
            startTimeQ = System.currentTimeMillis();
        }
    }

    @After("selectQ()")
    public void afterAdvice(JoinPoint jp) {
        totalTimeQ += System.currentTimeMillis() - startTimeQ;
    }
}
