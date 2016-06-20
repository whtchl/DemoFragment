package android.example.com.demofragment;

/*import android.app.Fragment;
import android.app.FragmentManager;*/
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by tchl on 2016-06-16.
 */
public abstract  class SingleFragmentActivity extends FragmentActivity
{
    protected abstract Fragment createFragment();
    final static String TAG = "SingleFragmentActivity";


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e(TAG,"tchl onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        Log.e(TAG,"tchl onCreate");
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.id_fragment_container);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.id_fragment_container,fragment).commit();
        }
    }
}
