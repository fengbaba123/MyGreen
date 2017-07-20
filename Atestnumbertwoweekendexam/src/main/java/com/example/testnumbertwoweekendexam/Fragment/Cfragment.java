package com.example.testnumbertwoweekendexam.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testnumbertwoweekendexam.DaoMaster;
import com.example.testnumbertwoweekendexam.DaoSession;
import com.example.testnumbertwoweekendexam.R;
import com.example.testnumbertwoweekendexam.Students;
import com.example.testnumbertwoweekendexam.StudentsDao;


/**

 */
public class Cfragment extends Fragment {


    private EditText editText;
    private StudentsDao studentsDao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cfragment, null);

              DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getActivity(), "sws", null);

                      DaoMaster daoMaster = new DaoMaster(helper.getReadableDb());

                      DaoSession daoSession = daoMaster.newSession();

        studentsDao = daoSession.getStudentsDao();

        Button btn_queding  = (Button) view.findViewById(R.id.btn_queding);

        editText = (EditText) view.findViewById(R.id.edittext_name);

        btn_queding.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String name = editText.getText().toString().trim();

                Students students = new Students(null,name);

                studentsDao.insert(students);


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(getActivity(), "添加数据完成", Toast.LENGTH_SHORT).show();

                        editText.setText(null);
                    }
                });


            }
        });


        return view;
    }
}
