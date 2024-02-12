package practice_Thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {
    static final ForkJoinPool pool = new ForkJoinPool(); // 쓰레드 풀을 생성

    public static void main(String[] args) {
        long from = 1L, to = 100_000_000L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis(); // 시작 시간 초기화
        Long result = pool.invoke(task);
        System.out.println("Elapsed time(4 Core):"+ (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
        System.out.println();
        result = 0L;
        start = System.currentTimeMillis(); // 시작시간 초기화
        for(long i = from; i<=to; i++)
            result += i;

        System.out.println("Elapsed time(1 Core):"+ (System.currentTimeMillis() - start));
        System.out.printf("sum of %d~%d=%d%n", from, to, result);
    }
}
class SumTask extends RecursiveTask<Long> { // RecursiveTask를 상속받는다.
    long from, to;

    SumTask(long from, long to){
        this.from = from;
        this.to = to;
    }

    public Long compute(){
        long size = to - from + 1; // from <= i <= to

        if(size <= 5) // 더할 숫자가 5개 이하면
                return sum(); // 숫자의 합을 반환. sum()은 from부터 to까지의 수를 더해서 반환.

        // 범위를 반으로 나눠서 두 개의 작업을 생성
        long half = (from+to)/2;

        SumTask leftSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half+1, to);

        leftSum.fork(); // 작업(leftSum)을 작업 큐에 넣는다.

        return rightSum.compute() + leftSum.join();

    }
    long sum() {
        long tmp = 0L;

        for(long i = from; i<=to; i++)
            tmp += i;

        return tmp;
    }
}