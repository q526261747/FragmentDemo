package com.example.administrator.fragmentdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Administrator on 2017/12/12.
 */

public class ContentFragment extends Fragment{
    public interface ResultMsg{
        void sendMsg(String text);
    }
    private ResultMsg resultMsg = new ResultMsg() {
        @Override
        public void sendMsg(String text) {

        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_fragment,container,false);
        String result = null;
        if (getArguments()!=null) {
            result = getArguments().get("msg") + "";
        }
        EditText et = (EditText) view.findViewById(R.id.et);
        et.setText(result);
        resultMsg.sendMsg("来自fragment的消息");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        getActivity();
        resultMsg = (ResultMsg) context;
        super.onAttach(context);
    }

}
