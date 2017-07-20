package com.example.testnumbertwoweekendexam.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.testnumbertwoweekendexam.DaoMaster;
import com.example.testnumbertwoweekendexam.DaoSession;
import com.example.testnumbertwoweekendexam.ListViewAdapter;
import com.example.testnumbertwoweekendexam.R;
import com.example.testnumbertwoweekendexam.Students;
import com.example.testnumbertwoweekendexam.StudentsDao;

import java.util.ArrayList;
import java.util.List;


/**

 */
public class Bfragment extends Fragment {


    private ListView listView;

    private List<String> lists;
    private StudentsDao studentsDao;
    private ListViewAdapter listViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bfragment, null);


        listView = (ListView) view.findViewById(R.id.listview_demo);

              DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getActivity(), "sws", null);

                      DaoMaster daoMaster = new DaoMaster(helper.getReadableDb());

                      DaoSession daoSession = daoMaster.newSession();

        studentsDao = daoSession.getStudentsDao();


        List<Students> list = studentsDao.queryBuilder().where(StudentsDao.Properties.Id.between(0,999)).list();


        lists = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){

            lists.add(list.get(i).getName());
        }


        listViewAdapter = new ListViewAdapter(getActivity(), this.lists);

        listView.setAdapter(listViewAdapter);

        listViewAdapter.notifyDataSetChanged();


        return view;
    }



}
