package handy.espressodemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import handy.espressodemo.R;


public class LoginFragment extends Fragment {

    //for easy demo purposes only, don't actually do this
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private EditText mUsernameText;
    private EditText mPasswordText;
    private TextView mBadCredentialsText;
    public interface UserLoginSuccessListener {
        void onUserLoginSuccess();
    }

    private UserLoginSuccessListener mCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (UserLoginSuccessListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUsernameText = (EditText) getView().findViewById(R.id.username_text);
        mPasswordText = (EditText) getView().findViewById(R.id.password_text);
        mBadCredentialsText = (TextView) getActivity().findViewById(R.id.bad_credentials_text);

        Button loginButton = (Button) view.findViewById(R.id.submit_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLoginButtonClick();
            }
        });
    }

    private void handleLoginButtonClick()
    {
        if(credentialsValid())
        {
            mBadCredentialsText.setVisibility(View.INVISIBLE);
            mCallback.onUserLoginSuccess();
        }
        else
        {
            mBadCredentialsText.setVisibility(View.VISIBLE);
        }
    }

    private boolean credentialsValid()
    {
        String username = mUsernameText.getText().toString();
        String password = mPasswordText.getText().toString();

        return (USERNAME.equals(username) && PASSWORD.equals(password));
    }

}
