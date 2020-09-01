package com.f.healthmonitoring.Adapter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.f.healthmonitoring.Activities.MainActivity;
import com.f.healthmonitoring.Model.Medicine;
import com.f.healthmonitoring.R;

import java.util.ArrayList;
import java.util.List;

import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.recyclerview.widget.RecyclerView;

public class MedicineListAdapter extends RecyclerView.Adapter<MedicineListAdapter.MyViewHolder> implements Filterable {

    private List<Medicine> medicineList;
    private List<Medicine> filterMedicineList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView medicinename,prescriptedBy,symptoms,disease;

        public MyViewHolder(View view) {
            super(view);
            medicinename = (TextView) view.findViewById(R.id.medicine);
            prescriptedBy = (TextView) view.findViewById(R.id.prescripted);
            symptoms = (TextView) view.findViewById(R.id.symptoms);
            disease = (TextView) view.findViewById(R.id.disease);




        }
    }


    public MedicineListAdapter(List<Medicine> moviesList, Context context) {
        this.medicineList = moviesList;
        this.filterMedicineList = moviesList;
        this.context=context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medicine_list_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         final Medicine movie = filterMedicineList.get(position);
        holder.medicinename.setText(movie.getMedicine());
        holder.prescriptedBy.setText(movie.getDisease());
        holder.symptoms.setText(movie.getSymptom());
        holder.disease.setText(movie.getDisease());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "anxhag", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class );
                showNotification(context,"zaad","asdad",intent);
            }
        });

    }
    public void showNotification(Context context, String title, String body, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            mChannel.setSound(alarmSound, audioAttributes);
            notificationManager.createNotificationChannel(mChannel);

        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setSound(alarmSound)
                .setContentText(body);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(intent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        mBuilder.setContentIntent(resultPendingIntent);

        notificationManager.notify(notificationId, mBuilder.build());
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filterMedicineList = medicineList;
                } else {
                    List<Medicine> filteredList = new ArrayList<>();
                    for (Medicine row : medicineList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getMedicine().toLowerCase().contains(charString.toLowerCase()) ) {
                            filteredList.add(row);
                        }
                    }

                    filterMedicineList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterMedicineList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterMedicineList = (ArrayList<Medicine>) filterResults.values;

                // refresh the list with filtered data
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return filterMedicineList.size();
    }
}
