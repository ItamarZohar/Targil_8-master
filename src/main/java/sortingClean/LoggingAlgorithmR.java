package sortingClean;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAlgorithmR {

    @Pointcut("execution(void sortingClean.AlgorithmRunner.runAlgorithms(..))")
    private void selectAr() {
    }

@Before("selectAr()")
public void Bfore(){}

    @After("selectAr()")
    public void AfterAdvice() {
        long sunTotalTime = LoggingM.totalTimeM + LoggingQ.totalTimeQ + LoggingI.totalTimeI + LoggingB.totalTimeB;
        System.out.println("Total time of running all sort functions was " + sunTotalTime + " ms\n" +"In detail:");

        if (LoggingQ.totalTimeQ != 0) {
            System.out.println("Function sort in QuickSort ran " + LoggingQ.num + " times and took in total " + LoggingQ.totalTimeQ + " ms");
        }

        if (LoggingB.totalTimeB != 0) {
            System.out.println("Function sort in BubbleSort ran " + LoggingB.num + " times and took in total " + LoggingB.totalTimeB + " ms");
        }

        if(LoggingM.totalTimeM!=0)
        {
            System.out.println("Function sort in MergeSort ran " +  LoggingM.num +" times and took in total " + LoggingM.totalTimeM + " ms");

        }

        if(LoggingI.totalTimeI!=0)
        {
            System.out.println("Function sort in InsertionSort ran " +  LoggingI.num +" times and took in total " + LoggingI.totalTimeI+ " ms");

        }
    }


}
