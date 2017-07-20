package com.example.demo_greendao2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo_greendao2.db.DaoMaster;
import com.example.demo_greendao2.db.DaoSession;
import com.example.demo_greendao2.db.User;
import com.example.demo_greendao2.db.UserDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.btnAdd)
    Button button;
    @Bind(R.id.btnDel)
    Button button2;
    @Bind(R.id.btnUpdate)
    Button button3;
    @Bind(R.id.btnQuery)
    Button button4;
    private UserDao userDao;
    private Random random;
    private String tag = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //new helper, helper是Daomaster里的内部类
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MainActivity.this, "user.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();

    }


    @OnClick({R.id.btnAdd, R.id.btnDel, R.id.btnUpdate, R.id.btnQuery})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                insert();
                break;
            case R.id.btnDel:
                delete();
                break;
            case R.id.btnUpdate:
                updateData();
                break;
            case R.id.btnQuery:
                query();
                break;
        }
    }

    private void updateData() {

        User user = userDao.queryBuilder()
                .where(UserDao.Properties.Username.eq("wzq816"))
                .build().unique();
        user.setNickname("android");
        userDao.update(user);

    }

    private void delete() {
        User user = userDao.queryBuilder()
                .where(UserDao.Properties.Id.eq(5))
                .build().unique();

        userDao.delete(user);

    }

    private void query() {
        List<User> users = userDao.queryBuilder()
                .where(UserDao.Properties.Id.between(2, 999)).limit(100)
                .build().list();
        for (User user : users) {
            Log.e(tag, "query: " + user.toString());
        }

    }

    private void queryByName() {

    }


    private void insert() {
        random = new Random();
        for (int i = 0; i < 10; i++) {
            User user = new User(null, "wzq" + random.nextInt(999), "湖边雨");
            userDao.insert(user);
        }

    }
}
