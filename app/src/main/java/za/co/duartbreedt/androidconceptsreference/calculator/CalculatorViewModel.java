package za.co.duartbreedt.androidconceptsreference.calculator;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CalculatorViewModel extends ViewModel {

    public MutableLiveData<Integer> resultObservable = new MutableLiveData<>();

    // Create service to run tasks (Runnable) off the UI Thread
    private final ExecutorService executor = new ThreadPoolExecutor(
        1,               // Minimum number of threads even if they are idling
        10,          // Max number of threads before throwing a RejectedExecutionException
        1000L,          // Time before killing idle threads
        TimeUnit.MILLISECONDS,      // Time unit for the above
        new LinkedBlockingQueue<>() // A queue to hold all the tasks (Runnables)
    );

    public void calculate(int number) {

        // Create a new Runnable and execute it
        executor.execute(() -> {    // 1/2 Comment me out to experience a blocking call

            int result = giveMeThisNumberBackButSlower(number);

            // Send result into the LiveData stream
            resultObservable.postValue(result);

        });                         // 2/2 Comment me out to experience a blocking call
    }

    private int giveMeThisNumberBackButSlower(int n) {
        try {
            Thread.sleep(n * 1000L);
        } catch (InterruptedException e) {
            // Okay...
        }

        return n;
    }
}
