package android.example.com.demofragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

/**
 * Created by tchl on 2016-06-20.
 */
public class ListTitleFragment extends ListFragment {
    public static final int REQUEST_DETAIL = 0x110;
    private List<String> mTitles = Arrays.asList("Hello","World","Android");
    private int mCurrentPos;
    private ArrayAdapter<String> mAdapter;



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(mAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,mTitles));
    }

/*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       */
/* super.onListItemClick(l, v, position, id);*//*

        mCurrentPos = position;
        Snackbar.make(v, "你好啊", Snackbar.LENGTH_LONG)
                .setAction("delete", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "delete", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
*/
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCurrentPos = position;
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        intent.putExtra(ContentFragment.ARGUMENT, mTitles.get(position));
        startActivityForResult(intent, REQUEST_DETAIL);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("TAG", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETAIL) {
            mTitles.set(mCurrentPos, mTitles.get(mCurrentPos) + " -- " + data.getStringExtra(ContentFragment.RESPONSE));
            mAdapter.notifyDataSetChanged();
        }
    }

}
