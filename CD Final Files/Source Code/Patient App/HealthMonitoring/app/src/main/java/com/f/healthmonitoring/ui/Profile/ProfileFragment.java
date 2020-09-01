package com.f.healthmonitoring.ui.Profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.f.healthmonitoring.Activities.CheckEcgActivity;
import com.f.healthmonitoring.Activities.CheckHeartbeatActivity;
import com.f.healthmonitoring.Activities.CheckTemperatureActivity;
import com.f.healthmonitoring.Adapter.MedicineListAdapter;
import com.f.healthmonitoring.Model.AssignData;
import com.f.healthmonitoring.Model.Medicine;
import com.f.healthmonitoring.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {

    private ProfileViewModel ProfileViewModel;


    RecyclerView recyclerView;
    private List<Medicine> medicines;
    private SearchView searchView;
    private MedicineListAdapter list;
    Button temp,heartbeat,ecg;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Profile");

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
//        ProfileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        temp=(Button)root.findViewById(R.id.temp);
        heartbeat=(Button)root.findViewById(R.id.heart);
        ecg=(Button)root.findViewById(R.id.ecg);
        SharedPreferences prefs = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        String token = prefs.getString("Token", null);//"No name defined" is the default value.
        String _id = prefs.getString("id", null);//"No name defined" is the default value.
        String name = prefs.getString("Name", null);//"No name defined" is the default value.
        String fname = prefs.getString("Fname", null);//"No name defined" is the default value.
        String address = prefs.getString("Address", null);//"No name defined" is the default value.
        String phone = prefs.getString("phone", null);//"No name defined" is the default value.
        String disease = prefs.getString("Disease", null);//"No name defined" is the default value.
        final String deviceid = prefs.getString("Deviceid", null);//"No name defined" is the default value.
        String date = prefs.getString("Date", null);//"No name defined" is the default value.

        heartbeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), CheckHeartbeatActivity.class);
                intent.putExtra("id",deviceid);

                startActivity(intent);
            }
        });

        ecg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(getContext(), CheckEcgActivity.class);
                intent1.putExtra("id",deviceid);

                startActivity(intent1);
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 =new Intent(getContext(), CheckTemperatureActivity.class);
                intent2.putExtra("id",deviceid);

                startActivity(intent2);
            }
        });
       TextView pname= root.findViewById(R.id.pname);
        TextView Fathername= root.findViewById(R.id.pfname);
        TextView Address= root.findViewById(R.id.paddress);
        TextView Disease= root.findViewById(R.id.pdisease);
        TextView Phonenumber= root.findViewById(R.id.pphone);
        TextView Date= root.findViewById(R.id.pdate);
        TextView Deviceid= root.findViewById(R.id.deviceid);

        pname.setText(name);
        Fathername.setText(fname);
        Address.setText(address);
        Disease.setText(disease);
        Phonenumber.setText(phone);
        Date.setText(date);
        Deviceid.setText(deviceid);

        return root;

    }
}