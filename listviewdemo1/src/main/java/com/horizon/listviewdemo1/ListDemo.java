package com.horizon.listviewdemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.Cache;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * @author androiddeveloper
 */
public class ListDemo extends AppCompatActivity {

    private ListView mListView;
    private List<MyString> mList;
    private MyBaseAdapter mMyBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo);
        mListView = this.findViewById(R.id.listView);
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyString myString = new MyString();
            myString.mTestMemo = "Memo"+i;
            myString.mTestName = "Name"+i;
            mList.add(myString);
        }
        mMyBaseAdapter = new MyBaseAdapter(mList, this, R.layout.layout_list);
        mListView.setAdapter(mMyBaseAdapter);

        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "df"+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
class MyString{
    public String mTestName;
    public String mTestMemo;
}
