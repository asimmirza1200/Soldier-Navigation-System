package com.f.healthmonitoring.awesomefirebase;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.f.healthmonitoring.Model.AssignData;
import com.f.healthmonitoring.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        MessageDataSource.MessagesCallbacks{

    public static final String USER_EXTRA = "USER";

    public static final String TAG = "ChatActivity";

    private ArrayList<Message> mMessages;
    private MessagesAdapter mAdapter;
    private String mRecipient;
    private ListView mListView;
    private Date mLastMessageDate = new Date();
    private String mConvoId;
    private MessageDataSource.MessagesListener mListener;
    private AssignData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         userData= (AssignData) getIntent().getSerializableExtra("Doctor");
        mRecipient = userData.getDoctorData().getDoctorname();

        mListView = (ListView)findViewById(R.id.messages_list);
        mMessages = new ArrayList<>();
        mAdapter = new MessagesAdapter(mMessages);
        mListView.setAdapter(mAdapter);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar(). setTitle(mRecipient);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton sendMessage = (FloatingActionButton) findViewById(R.id.send_message);
        sendMessage.setOnClickListener(this);

        String[] ids = {userData.getPatientData().getPhonenumber(),"-", userData.getDoctorData().getPhonenumber()};
        Arrays.sort(ids);
        mConvoId = ids[0]+ids[1]+ids[2];

        mListener = MessageDataSource.addMessagesListener(mConvoId, this);

    }

    public void onClick(View v) {
        EditText newMessageView = (EditText)findViewById(R.id.new_message);
        String newMessage = newMessageView.getText().toString();
        newMessageView.setText("");
        Message msg = new Message();
        msg.setDate(new Date());
        msg.setText(newMessage);
        msg.setSender(userData.getPatientData().getPhonenumber());

        MessageDataSource.saveMessage(userData,msg, mConvoId);
    }

    @Override
    public void onMessageAdded(Message message) {
        mMessages.add(message);
        mAdapter.notifyDataSetChanged();
        mListView.smoothScrollToPosition(mMessages.size()-1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MessageDataSource.stop(mListener);
    }


    private class MessagesAdapter extends ArrayAdapter<Message> {
        MessagesAdapter(ArrayList<Message> messages){
            super(MainActivity.this, R.layout.message, R.id.message, messages);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = super.getView(position, convertView, parent);
            Message message = getItem(position);

            TextView nameView = (TextView)convertView.findViewById(R.id.message);
            nameView.setText(message.getText());

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)nameView.getLayoutParams();

            if (message.getSender().equals(userData.getPatientData().getPhonenumber())){
                    nameView.setBackgroundResource(R.drawable.bubble_right_green);

                layoutParams.gravity = Gravity.RIGHT;
            }else{
                    nameView.setBackgroundResource(R.drawable.bubble_left_gray);

                layoutParams.gravity = Gravity.LEFT;
            }

            nameView.setLayoutParams(layoutParams);


            return convertView;
        }
    }
}
