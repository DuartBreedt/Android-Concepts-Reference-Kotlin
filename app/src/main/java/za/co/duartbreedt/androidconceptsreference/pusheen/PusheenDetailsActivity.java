package za.co.duartbreedt.androidconceptsreference.pusheen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityPusheenDetailsBinding;

public class PusheenDetailsActivity extends AppCompatActivity {

    private ActivityPusheenDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPusheenDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        List<String> pusheenNames = new ArrayList<String>(){{
            add("Vampire Pusheen");
            add("Donut Pusheen");
            add("Love Bird Pusheen");
            add("Snac Pusheen");
            add("Mask Pusheen");
            add("Summer Pusheen");
            add("Telephone Pusheen");
            add("Cake Pusheen");
            add("Scooter Pusheen");
            add("Relax Pusheen");
            add("Posh Pusheen");
            add("UFO Pusheen");
            add("Nessie Pusheen");
            add("Nessie Pusheen");
            add("Paris Pusheen");
            add("Snuggle Pusheen");
            add("Father Pusheen");
            add("Pudding Pusheen");
            add("Unicorn Pusheen");
            add("Ducky Pusheen");
            add("Bowtie Pusheen");
            add("Knitting Pusheen");
            add("Fishing Pusheen");
            add("Harry Pusheen");
            add("McDonalds Pusheen");
            add("Pooping Pusheen");
            add("Pizza Pusheen");
            add("Christmas Sweater Pusheen");
            add("Smors Pusheen");
            add("Dragon Pusheen");
            add("Icecream Pusheen");
        }};

        setupPusheenRecyclerView(pusheenNames);
    }

    private void setupPusheenRecyclerView(List<String> pusheenNames) {
        PusheenAdapter adapter = new PusheenAdapter(pusheenNames);
        binding.pusheenRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        binding.pusheenRecyclerView.setLayoutManager(layoutManager);
    }
}