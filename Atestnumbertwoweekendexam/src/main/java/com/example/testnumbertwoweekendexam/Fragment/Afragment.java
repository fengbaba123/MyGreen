package com.example.testnumbertwoweekendexam.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.testnumbertwoweekendexam.DaoMaster;
import com.example.testnumbertwoweekendexam.DaoSession;
import com.example.testnumbertwoweekendexam.R;
import com.example.testnumbertwoweekendexam.Students;
import com.example.testnumbertwoweekendexam.StudentsDao;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**

 */
public class Afragment extends Fragment {

    private Button kaishidianming;
    private TextView textView;
    private List<Students> list;

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.arg1 == 6){

                Random random = new Random();


                textView.setText(list.get(random.nextInt(list.size())).getName());


            }

        }
    };
    private Timer timer;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_afragment, null);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getActivity(), "sws", null);

        DaoMaster daoMaster = new DaoMaster(helper.getReadableDb());

        DaoSession daoSession = daoMaster.newSession();

        StudentsDao studentsDao = daoSession.getStudentsDao();

        list = studentsDao.queryBuilder().where(StudentsDao.Properties.Id.between(0, 999)).list();


        kaishidianming = (Button) view.findViewById(R.id.btn_kaishidianming);

        textView = (TextView) view.findViewById(R.id.textview_name);


        kaishidianming.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                timer = new Timer();

                timer.schedule(new TimerTaskDemo(),1000,1000);



//                Random random = new Random();
//
//                i = random.nextInt(list.size()+1);


//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        textView.setText(list.get(i).getName());
//
//                    }
//                });
            }
        });

        view.findViewById(R.id.btn_jieshu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                timer.cancel();
            }
        });

        return view;
    }

    class TimerTaskDemo extends TimerTask{


        @Override
        public void run() {
            Message message = Message.obtain();

            message.arg1 = 6;

            handler.sendMessage(message);
        }
    }
}
