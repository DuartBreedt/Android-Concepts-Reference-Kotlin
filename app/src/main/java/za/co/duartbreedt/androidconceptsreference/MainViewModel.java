package za.co.duartbreedt.androidconceptsreference;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MainViewModel() {
        Log.i("BOOTCAMP", "The MainViewModel was created!");
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        Log.i("BOOTCAMP", "The MainViewModel was cleared!");
    }
}
