package com.example.travel;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.travel.activitys.CountryActivity;
import com.example.travel.activitys.LoginActivity;
import com.example.travel.activitys.ProfileActivity;
import com.example.travel.adapters.TravelLocationsAdapter;
import com.example.travel.data.LocationsData;
import com.example.travel.models.TravelLocation;
import com.example.travel.tools.ExampleDialog;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity implements TravelLocationsAdapter.OnClickItemListener, ExampleDialog.ExampleDialogListener {

    TravelLocationsAdapter adapter;
    BiometricPrompt prompt;
    Executor executor;
    MainActivity activity = this;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationsViewPager = findViewById(R.id.locationsViewPager);

        LocationsData locationsData = new LocationsData();
        List<TravelLocation> travelLocations = locationsData.getTravelLocations();

        adapter = new TravelLocationsAdapter(travelLocations);
        adapter.setOnClickListener(this);

        CardView imageProfile = findViewById(R.id.cardProfilePicture);
        registerForContextMenu(imageProfile);

        locationsViewPager.setAdapter(adapter);

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);

        executor = Executors.newSingleThreadExecutor();

        prompt = new BiometricPrompt.Builder(this)
                .setTitle("Вхід відбитком пальця")
                .setSubtitle("Підзаголовок")
                .setDescription("Опис")
                .setNegativeButton("Відміна", executor, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Вхід відмінено", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).build();
    }

    @Override
    public void onItemClick(int position) {
        if (position == 0){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        } else if (position == 1){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        } else if (position == 2){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        } else if (position == 3){
            Intent intent = new Intent(getApplicationContext(), CountryActivity.class);
            intent.putExtra("id", position);
            startActivity(intent);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Авторизація");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.option_1:
                prompt.authenticate(new CancellationSignal(), executor, new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });
                return true;
            case R.id.option_2:
                Intent intent2 = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent2);
                return true;
            case R.id.option_3:
                openDialog();
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void openDialog() {
        ExampleDialog dialog = new ExampleDialog();
        dialog.show(getSupportFragmentManager(), "example dialog");
    }

    public void onYesClicked() {
        finish();
    }

    @Override
    public void onBackPressed() {
        openDialog();
    }
}
