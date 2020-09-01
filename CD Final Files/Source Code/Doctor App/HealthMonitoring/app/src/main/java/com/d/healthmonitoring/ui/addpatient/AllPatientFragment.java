package com.d.healthmonitoring.ui.addpatient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.d.healthmonitoring.Model.AllPatient;
import com.d.healthmonitoring.Model.AssignData;
import com.d.healthmonitoring.Model.PatientData;
import com.d.healthmonitoring.R;
import com.d.healthmonitoring.Adapter.AllPatientListAdapter;
import com.d.healthmonitoring.api_response.ApiClient;
import com.d.healthmonitoring.api_response.ApiInterface;

import java.util.ArrayList;
import java.util.List;

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

import static android.content.Context.MODE_PRIVATE;

public class AllPatientFragment extends Fragment {

    private AllPatientViewModel seeallPatientsViewModel;
    RecyclerView recyclerView;
    private List<AssignData> doctors;
private AllPatient allPatients;
    private ProgressBar progressBar;

    private SearchView searchView;
    private AllPatientListAdapter list;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        seeallPatientsViewModel =
                ViewModelProviders.of(this).get(AllPatientViewModel.class);
        View root = inflater.inflate(R.layout.fragment_see_all_patients, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Select Patient");

        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_view);
        searchView = (SearchView)root.findViewById(R.id.search);
        list = new AllPatientListAdapter(new ArrayList<PatientData>(), getContext());

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
        Call<AllPatient> call = apiInterface.getAllPatient("Bearer "+token);
        call.enqueue(new Callback<AllPatient>() {
            @Override
            public void onResponse(Call<AllPatient> call, Response<AllPatient> response) {
                progressBar.setVisibility(View.INVISIBLE);

                if (response.isSuccessful()) {

                    list = new AllPatientListAdapter(response.body().getResult(), getContext());
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
            public void onFailure(Call<AllPatient> call, Throwable t) {
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


