package com.d.healthmonitoring.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;


import com.d.healthmonitoring.Activities.AddMedicineActivity;
import com.d.healthmonitoring.Model.PatientData;
import com.d.healthmonitoring.R;
import com.d.healthmonitoring.api_response.ApiClient;
import com.d.healthmonitoring.api_response.ApiInterface;
import com.d.healthmonitoring.awesomefirebase.MainActivity;
import com.d.healthmonitoring.ui.home.HomeFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class AllPatientListAdapter extends RecyclerView.Adapter<AllPatientListAdapter.MyViewHolder> implements Filterable {

    private List<PatientData> patientList;
    private List<PatientData> filterpatientlist;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView patientname, disease, phonenumber;
        public Button profiles,send;

        public MyViewHolder(View view) {
            super(view);
            patientname = (TextView) view.findViewById(R.id.dname);
            disease = (TextView) view.findViewById(R.id.disease);
            phonenumber = (TextView) view.findViewById(R.id.phone);
            send = (Button) view.findViewById(R.id.send);



        }
    }


    public AllPatientListAdapter(List<PatientData> moviesList, Context context) {
        this.patientList = moviesList;
        this.filterpatientlist = moviesList;
        this.context=context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_list_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         final PatientData movie = filterpatientlist.get(position);
        holder.patientname.setText(movie.getPatientname());
        holder.disease.setText(movie.getDisease());
        holder.phonenumber.setText(movie.getPhonenumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assignDoctor(movie.getId());
//                Intent mainIntent = new Intent(context, ProfileActivityPatient.class);
//                mainIntent.putExtra("Patient",(Serializable) movie);
//
//                context.startActivity(mainIntent);
            }
        });
        holder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(context, MainActivity.class);
                mainIntent.putExtra("Patient",(Serializable) movie);

                context.startActivity(mainIntent);
            }
        });


    }
//    public void showNotification(Context context, String title, String body, Intent intent) {
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        int notificationId = 1;
//        String channelId = "channel-01";
//        String channelName = "Channel Name";
//        int importance = NotificationManager.IMPORTANCE_HIGH;
//        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            NotificationChannel mChannel = new NotificationChannel(
//                    channelId, channelName, importance);
//            AudioAttributes audioAttributes = new AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                    .build();
//            mChannel.setSound(alarmSound, audioAttributes);
//            notificationManager.createNotificationChannel(mChannel);
//
//        }
//
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle(title)
//                .setSound(alarmSound)
//                .setContentText(body);
//
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//        stackBuilder.addNextIntent(intent);
//        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
//                0,
//                PendingIntent.FLAG_UPDATE_CURRENT
//        );
//        mBuilder.setContentIntent(resultPendingIntent);
//
//        notificationManager.notify(notificationId, mBuilder.build());
//    }

    private void assignDoctor(String id) {


        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);


        /**
         GET List Resources
         **/
        SharedPreferences prefs = context.getSharedPreferences("login", MODE_PRIVATE);
        String token = prefs.getString("Token", null);//"No name defined" is the default value.
        String _id = prefs.getString("id", null);//"No name defined" is the default value.

        Call<ResponseBody> call = apiInterface.assignDoctor("Bearer "+token,_id,id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {


                    HomeFragment frag = new HomeFragment();
                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.nav_host_fragment,frag,"Test Fragment");
                    transaction.commit();



                } else {

                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(context, "Invalid Credential", Toast.LENGTH_SHORT).show();
                Log.e("jhjhj",t.getMessage());
            }
        });



    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filterpatientlist = patientList;
                } else {
                    List<PatientData> filteredList = new ArrayList<>();
                    for (PatientData row : patientList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getPatientname().toLowerCase().contains(charString.toLowerCase()) ||(row.getFathername().toLowerCase()).contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    filterpatientlist = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterpatientlist;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterpatientlist = (ArrayList<PatientData>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return filterpatientlist.size();
    }
}
