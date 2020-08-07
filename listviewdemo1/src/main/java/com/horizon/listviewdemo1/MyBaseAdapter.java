package com.horizon.listviewdemo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @Author lhh
 * @ClasssName MyBaseAdapter
 * @Description
 * @UpdateDate 2020/8/7 10:15 AM
 */
public class MyBaseAdapter extends BaseAdapter {
    /**
     * 一个线性表，一个元素即为一个表单
     * 上下文和和获得模版的inflater
     * layout 是资源ID
     */
    private List<MyString> mList;
    private Context mContext;
    private int mLayout;

    private LayoutInflater inflater;
    public MyBaseAdapter(List<MyString> list, Context context, int layout){
        mList = list;
        mContext = context;
        mLayout = layout;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * @return 获得列表总行数
     */
    @Override
    public int getCount() {
        return mList.size();
    }

    /**
     * @param i 索引
     * @return 一个可以随便玩的地方（至少是在例子里返回了一个 mList 的子元素）
     */
    @Override
    public Object getItem(int i) {
        return i;
    }

    /**
     * @param i 元素id
     * @return
     * @see android.widget.Adapter#getItemId(int)
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 获得视图模版
     * @param i 当前正在描绘的列表下标
     * @param view 当前模版
     * @param viewGroup 缓存，每次一个单元划出屏幕就会进入此地方
     * @return View模版
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewCache cache = new ViewCache();
        if(view == null){
            view = inflater.inflate(mLayout, null);
            cache.testName = (TextView)view.findViewById(R.id.testname);
            cache.testMemo = (TextView)view.findViewById(R.id.testmemo);
            cache.testName.setText(mList.get(i).mTestName);
            cache.testMemo.setText(mList.get(i).mTestMemo);
            view.setTag(cache);
        }
        return view;
    }

    public final class ViewCache{
        public TextView testName;
        public TextView testMemo;
    }
}
