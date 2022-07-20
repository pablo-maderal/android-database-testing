package com.pobs.database_testing;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.pobs.database_testing.model.Poll;
import com.pobs.database_testing.retrofit.PollApi;
import com.pobs.database_testing.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PollDemo extends AppCompatActivity {

    private Button testDB_btn, btn_a, btn_b, btn_c, displayStats_btn;
    private CheckBox testDB_checkbox;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polldemo);

        RetrofitService retrofitService = new RetrofitService();
        PollApi pollApi = retrofitService.getRetrofit().create(PollApi.class);

        //TODO  clean up this method, might be able to make more elegant/easier to read

        initializeViews();
        testDB_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pollApi.testConnection()
                        .enqueue(new Callback<Poll>() {
                            @Override
                            public void onResponse(Call<Poll> call, Response<Poll> response) {
                                testDB_checkbox.setChecked(true);
                                enable_disable_views(true);
                            }

                            @Override
                            public void onFailure(Call<Poll> call, Throwable t) {
                                Toast.makeText(PollDemo.this, "fail", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "error ");

                            }
                        });

            }
        });

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pollApi.increment_a()
                        .enqueue(new Callback<Poll>() {
                            @Override
                            public void onResponse(Call<Poll> call, Response<Poll> response) {
                                Toast.makeText(PollDemo.this, "successfully incremented in the database", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Poll> call, Throwable t) {
                                Toast.makeText(PollDemo.this, "Failure", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pollApi.increment_b()
                        .enqueue(new Callback<Poll>() {
                            @Override
                            public void onResponse(Call<Poll> call, Response<Poll> response) {
                                Toast.makeText(PollDemo.this, "successfully incremented in the database", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Poll> call, Throwable t) {
                                Toast.makeText(PollDemo.this, "Failure", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pollApi.increment_c()
                        .enqueue(new Callback<Poll>() {
                            @Override
                            public void onResponse(Call<Poll> call, Response<Poll> response) {
                                Toast.makeText(PollDemo.this, "successfully incremented in the database", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Poll> call, Throwable t) {
                                Toast.makeText(PollDemo.this, "Failure", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


        displayStats_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pollApi.testConnection()
                        .enqueue(new Callback<Poll>() {
                            @Override
                            public void onResponse(Call<Poll> call, Response<Poll> response) {
                                String s;
                                s = getPollPercentages(response.body());
                                Toast.makeText(PollDemo.this, s, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Poll> call, Throwable t) {

                            }
                        });
            }
        });

    }


    private void initializeViews() {
        testDB_btn = findViewById(R.id.polldemo_testdb_btn);
        testDB_checkbox = findViewById(R.id.polldemo_testdb_checkbox);
        btn_a = findViewById(R.id.polldemo_btn_a);
        btn_b = findViewById(R.id.polldemo_btn_b);
        btn_c = findViewById(R.id.polldemo_btn_c);
        displayStats_btn = findViewById(R.id.polldemo_displaystats_btn);

        enable_disable_views(false);


    }

    private void enable_disable_views(Boolean bool) {
        btn_a.setEnabled(bool);
        btn_b.setEnabled(bool);
        btn_c.setEnabled(bool);
        displayStats_btn.setEnabled(bool);
    }

    private String getPollPercentages(Poll poll) {
        int a, b, c, x, y, z, sum;
        a = poll.getCol_a();
        b = poll.getCol_b();
        c = poll.getCol_c();
        sum = (a + b + c);
        x = calculatePercent(a, sum);
        y = calculatePercent(b, sum);
        z = calculatePercent(c, sum);
        return "A has " + a + " entries, making it " + x + "% \n" +
                "B has " + b + " entries, making it " + y + "% \n" +
                "C has " + c + " entries, making it " + z + "% ";

    }

    private int calculatePercent(int numerator, int denominator) {
        float percent = numerator / (float) denominator;
        return (int) Math.round(percent * 100);
    }


}


