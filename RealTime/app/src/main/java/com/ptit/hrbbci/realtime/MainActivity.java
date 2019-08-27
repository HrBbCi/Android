package com.ptit.hrbbci.realtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity {

    private Socket mSocket;
    ListView lvUser, lvChat;
    EditText etContent;
    ImageButton ivAdd, ivSend;
    ArrayList<String> arrUser;
    ArrayAdapter adapterUser;
    ArrayList<String> arrChat;
    ArrayAdapter adapterChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convert();


        try {
            mSocket = IO.socket("http://192.168.1.5:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        mSocket.connect();

//        mSocket.on("server-send-data",receiveData);
//        mSocket.emit("client-send-data","Lap trinh android");

        mSocket.on("server-send-result", receiveResultRegister);

        //nhan du lieu tu server
        mSocket.on("server-send-result", receiveResultListUser);
        mSocket.on("server-send-chat", receiveResultListChat);

        arrUser = new ArrayList<>();
        adapterUser = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrUser);
        arrChat = new ArrayList<>();
        adapterChat = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrChat);
        lvChat.setAdapter(adapterChat);

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etContent.getText().toString().length() > 0) {
                    //Gui du lieu toi server
                    mSocket.emit("client-register-user", etContent.getText().toString());
                }
            }
        });

        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etContent.getText().toString().length() > 0) {
                    //Gui du lieu toi server
                    mSocket.emit("client-send-chat", etContent.getText().toString());
                }
            }
        });
    }

    private void convert() {
        lvUser = findViewById(R.id.lvUser);
        lvChat = findViewById(R.id.lvChat);
        etContent = findViewById(R.id.etContent);
        ivAdd = findViewById(R.id.ivAddUser);
        ivSend = findViewById(R.id.ivSendUser);
    }

    private Emitter.Listener receiveResultRegister = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObject = (JSONObject) args[0];
                    try {
                        boolean exits = jsonObject.getBoolean("result");
                        if (exits == true) {
                            //Da ton tai
                        } else {
                            //DK thanh cong
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    };

    private Emitter.Listener receiveResultListUser = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObject = new JSONObject();
                    JSONArray jsonArray = null;
                    try {
                        jsonArray = jsonObject.getJSONArray("danhsach");
                        arrUser.clear();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            String username = jsonArray.getString(i);
                            arrUser.add(username);
                        }
                        adapterUser.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    };

    private Emitter.Listener receiveResultListChat = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject jsonObject = (JSONObject) args[0];
                    try {
                        String content = jsonObject.getString("chatContent");
                        arrChat.add(content);
                        adapterChat.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    };
}
