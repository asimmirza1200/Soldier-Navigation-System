package com.f.healthmonitoring.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.f.healthmonitoring.Activities.ProfileActivityDoctor;
import com.f.healthmonitoring.Activities.SendMassageActivity;
import com.f.healthmonitoring.Model.AssignData;
import com.f.healthmonitoring.R;
import com.f.healthmonitoring.awesomefirebase.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.MyViewHolder> implements Filterable {

    private List<AssignData> doctorList;
    private List<AssignData> filterdoctorist;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView doctorname, specialization, phonenumber;
        public Button profiles,send;

        public MyViewHolder(View view) {
            super(view);
            doctorname = (TextView) view.findViewById(R.id.dname);
            specialization = (TextView) view.findViewById(R.id.spec);
            phonenumber = (TextView) view.findViewById(R.id.phone);
            send = (Button) view.findViewById(R.id.send);



        }
    }


    public DoctorListAdapter(List<AssignData> moviesList, Context context) {
        this.doctorList = moviesList;
        this.filterdoctorist = moviesList;
        this.context=context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctor_list_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         final AssignData movie = filterdoctorist.get(position);
        holder.doctorname.setText(movie.getDoctorData().getDoctorname());
        holder.specialization.setText(movie.getDoctorData().getSpecialization());
        holder.phonenumber.setText(movie.getDoctorData().getPhonenumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(context, ProfileActivityDoctor.class);
                mainIntent.putExtra("Doctor",(Serializable) movie);

                context.startActivity(mainIntent);
            }
        });
        holder.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(context, MainActivity.class);
                mainIntent.putExtra("Doctor",(Serializable) movie);

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
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filterdoctorist = doctorList;
                } else {
                    List<AssignData> filteredList = new ArrayList<>();
                    for (AssignData row : doctorList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getDoctorData().getDoctorname().toLowerCase().contains(charString.toLowerCase()) ||(row.getDoctorData().getSpecialization().toLowerCase()).contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    filterdoctorist = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterdoctorist;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterdoctorist = (ArrayList<AssignData>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return filterdoctorist.size();
    }
}
