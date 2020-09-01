package com.d.healthmonitoring.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.d.healthmonitoring.Adapter.PatientListAdapter;
import com.d.healthmonitoring.Model.AllAssignPatient;
import com.d.healthmonitoring.Model.AssignData;
import com.d.healthmonitoring.R;
import com.d.healthmonitoring.api_response.ApiClient;
import com.d.healthmonitoring.api_response.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    private HomeViewModel seeAllDoctorViewModel;
    RecyclerView recyclerView;
    private List<AssignData> doctors;
private AllAssignPatient allDoctor;
    private ProgressBar progressBar;

    private SearchView searchView;
    private PatientListAdapter list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seeAllDoctorViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_see_all_patients, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");

        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_view);
        searchView = (SearchView)root.findViewById(R.id.search);
        list = new PatientListAdapter(new ArrayList<AssignData>(), getContext());

        progressBar=(ProgressBar)root.findViewById(R.id.progress_doctor);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                list.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                list.getFilter().filter(newText);


                return false;
            }
        });
        prepareMovieData();

        return root;
    }
    private void prepareMovieData() {



        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

       progressBar.setVisibility(View.VISIBLE);

        /**
         GET List Resources
         **/
        SharedPreferences prefs = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        String token = prefs.getString("Token", null);//"No name defined" is the default value.
        String _id = prefs.getString("id", null);//"No name defined" is the default value.
        Call<AllAssignPatient> call = apiInterface.getAssignPatient("Bearer "+token,_id);
        call.enqueue(new Callback<AllAssignPatient>() {
            @Override
            public void onResponse(Call<AllAssignPatient> call, Response<AllAssignPatient> response) {
                progressBar.setVisibility(View.INVISIBLE);

                if (response.isSuccessful()) {

                    list = new PatientListAdapter(response.body().getResult(), getContext());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(list);
                } else {

                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            private Intent getIntent() {
                return null;
            }

            @Override
            public void onFailure(Call<AllAssignPatient> call, Throwable t) {
                call.cancel();
                progressBar.setVisibility(View.GONE);

                Log.e("gfgf",t.getMessage());
            }
        });

    }

    private SharedPreferences getSharedPreferences(String login, int modePrivate) {
        return null;
    }
}


