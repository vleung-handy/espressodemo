package handy.espressodemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import handy.espressodemo.R;


public class SplashFragment extends Fragment {
    public interface SplashLoginClickListener{
        void onSplashLoginClicked();
    }

    private SplashLoginClickListener mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (SplashLoginClickListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button loginButton = (Button) view.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onSplashLoginClicked();
            }
        });
    }

}
