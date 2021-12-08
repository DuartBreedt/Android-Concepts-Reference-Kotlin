package za.co.duartbreedt.androidconceptsreference;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class UsernameViewModel extends ViewModel {

    public UsernameViewModel() {
        Log.i("BOOTCAMP", "The UsernameViewModel was created!");
    }

    private String username = "NO_USERNAME";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        Log.i("BOOTCAMP", "The UsernameViewModel was cleared!");
    }
}
