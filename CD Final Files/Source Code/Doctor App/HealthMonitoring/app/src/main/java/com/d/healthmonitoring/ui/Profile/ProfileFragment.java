package com.d.healthmonitoring.ui.Profile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.d.healthmonitoring.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {

    private ProfileViewModel slideshowViewModel;
    Button temp,heartbeat,ecg,medicine;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Profile");

//        final TextView textView = root.findViewById(R.id.text_alertnotification);
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });*
        SharedPreferences prefs = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        String token = prefs.getString("Token", null);//"No name defined" is the default value.
        String _id = prefs.getString("id", null);//"No name defined" is the default value.
        String name = prefs.getString("Name", null);//"No name defined" is the default value.
        String fname = prefs.getString("Fname", null);//"No name defined" is the default value.
        String address = prefs.getString("Address", null);//"No name defined" is the default value.
        String phone = prefs.getString("phone", null);//"No name defined" is the default value.
        String specialization = prefs.getString("Specialization", null);//"No name defined" is the default value.
        String qualification = prefs.getString("Qualification", null);//"No name defined" is the default value.
        String date = prefs.getString("Date", null);//"No name defined" is the default value.
        TextView Dname= root .findViewById(R.id.name);
        TextView Fathername= root.findViewById(R.id.fname);
        TextView Address= root .findViewById(R.id.address);
        TextView Phonenumber= root .findViewById(R.id.phone);
        TextView Specialization= root .findViewById(R.id.sep);
        TextView Qualification= root .findViewById(R.id.qual);
        TextView Date=root .findViewById(R.id.date);

        Dname.setText(name);
        Fathername.setText(fname);
        Address.setText(address);
        Specialization.setText(specialization);
        Phonenumber.setText(phone);
        Date.setText(date);
        Qualification.setText(qualification);
        return root;
    }
}
