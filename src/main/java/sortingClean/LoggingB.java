package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingB {
    long startTimeB=0;
   static  long totalTimeB=0;
   static int num=0;

    @Pointcut("execution(void sortingClean.BubbleSort.sort(..))")
    private void selectB() {
    }
    @Before("selectB()")
    public void beforeAdvice(JoinPoint jp) {
        num++;
        if (startTimeB!=0) {
            startTimeB = System.currentTimeMillis();
        }
    }

    @After("selectB()")
    public void afterAdvice(JoinPoint jp) {
        totalTimeB += System.currentTimeMillis() - startTimeB;
    }
}
