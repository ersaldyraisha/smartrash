package com.ersaldyraisha.smartrash;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ersaldyraisha.smartrash.API.ApiClient;
import com.ersaldyraisha.smartrash.API.ApiInterface;
import com.ersaldyraisha.smartrash.Adapter.TrashAdapter;
import com.ersaldyraisha.smartrash.Model.Distance;
import com.ersaldyraisha.smartrash.Model.ResponseHTTP;
import com.ersaldyraisha.smartrash.Model.Trash;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvDistance, tvStatus, tvName, tvCreated, tvColor, tvAddress;
    private ApiInterface apiInterface;
    private TrashAdapter trashAdapter;
    private RecyclerView recyclerView;
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tvDistance = (TextView) findViewById(R.id.tvDistance);
//        tvStatus = (TextView) findViewById(R.id.tvStatus);
        tvName = (TextView) findViewById(R.id.tvName);
        tvColor = (TextView) findViewById(R.id.tvColor);
        tvAddress = (TextView) findViewById(R.id.tvAddress);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerTrashView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);


        getData();

    }

    private void getData(){
        Call<ResponseHTTP> call = apiInterface.getTrash();

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Fetching Data...");

        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        progressDialog.show();

        call.enqueue(new Callback<ResponseHTTP>() {
            @Override
            public void onResponse(Call<ResponseHTTP> call, Response<ResponseHTTP> response) {
                progressDialog.dismiss();
                Log.d(TAG, "Respond " + response.raw());
                if(response.body().getStatus().equals("ok")){
                    List<Distance> distance = response.body().getDistanceList();
                    List<Trash> trash = response.body().getTrashList();
                    tvName.setText(trash.get(0).getTrashName().toString());
                    tvColor.setText(trash.get(0).getColor().toString());
                    tvAddress.setText(trash.get(0).getAddress().toString());

                    trashAdapter = new TrashAdapter(distance, R.layout.trash_list, MainActivity.this);
                    recyclerView.setAdapter(trashAdapter);


                }else{
                    Toast.makeText(MainActivity.this, "Failed to Get Data!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseHTTP> call, Throwable t) {
                progressDialog.dismiss();
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "Failed to Get Data!", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuRefresh) {
            getData();
        }
        return super.onOptionsItemSelected(item);
    }
}
