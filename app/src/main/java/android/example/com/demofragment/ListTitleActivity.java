package android.example.com.demofragment;

import android.support.v4.app.Fragment;
public class ListTitleActivity extends SingleFragmentActivity {
    private ListTitleFragment mListFragment;
    @Override
    protected Fragment createFragment()
    {
        mListFragment = new ListTitleFragment();
        return mListFragment;
    }
}
