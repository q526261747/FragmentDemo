package com.example.administrator.fragmentdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ContentFragment.ResultMsg {
    String result = null;
    Button frag_btn;
    ContentFragment contentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag_btn = (Button) findViewById(R.id.bt_frag);
        frag_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                if (contentFragment==null){
                    contentFragment = new ContentFragment();
                } else {//防止Fragment already active异常
                    transaction.remove(contentFragment);

                    contentFragment = new ContentFragment();
                }
                Bundle bundle = new Bundle();
                bundle.putString("msg","activity发的消息");
                contentFragment.setArguments(bundle);//activity-》fragment

                transaction.replace(R.id.frag,contentFragment);

                transaction.commit();
            }
        });
    }

    @Override
    public void sendMsg(String text) {
        result=text;
        Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
    }
}
