package android.example.com.demofragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.ContentFrameLayout;

/**
 * Created by tchl on 2016-06-20.
 */
public class ContentActivity extends SingleFragmentActivity {
    private ContentFragment mContentFragment;
    @Override
    protected Fragment createFragment() {
        String title  = getIntent().getStringExtra(ContentFragment.ARGUMENT);
        mContentFragment = ContentFragment.newInstance(title);
        return mContentFragment;
    }
}
