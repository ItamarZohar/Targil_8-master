package sortingClean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingM {
    long startTimeM=0;
    static long totalTimeM=0;
   static int num=0;

    @Pointcut("execution(void sortingClean.MergeSort.sort(..))")
    private void selectM() {
    }
    @Before("selectM()")
    public void beforeAdvice(JoinPoint jp) {
        num++;
        if (startTimeM!=0) {
            startTimeM = System.currentTimeMillis();
        }
    }

    @After("selectM()")
    public void afterAdvice(JoinPoint jp) {
        totalTimeM += System.currentTimeMillis() - startTimeM;
    }
}