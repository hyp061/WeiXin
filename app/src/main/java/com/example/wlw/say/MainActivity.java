package com.example.wlw.say;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private EditText mEidtText;
    private Button mButton;
    private MsgAdapter mMsgAdpter;
    private List<Msg> mMsgList=new ArrayList<Msg>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        mMsgAdpter=new MsgAdapter(this,R.layout.list_item_msg,mMsgList);
        mListView= (ListView) findViewById(R.id.activity_main_list_view);
        mListView.setAdapter(mMsgAdpter);
        mButton= (Button) findViewById(R.id.bt_sent);
        mEidtText= (EditText) findViewById(R.id.eT_input);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=mEidtText.getText().toString();
                if (!"".equals(content)){
                    Msg msg =new Msg(content,Msg.TYPE_SENT);
                    mMsgList.add(msg);
                    mMsgAdpter.notifyDataSetChanged();
                    mListView.setSelection(mMsgList.size());
                    mEidtText.setText("");
                }
            }
        });

    }

    private  void initMsgs(){
        mMsgList.add(new Msg("小明，你妈妈叫你回家吃饭!",Msg.TYPE_RECEIVEO));
        mMsgList.add(new Msg("你认错人了！我不是小明",Msg.TYPE_SENT));
    }
}
