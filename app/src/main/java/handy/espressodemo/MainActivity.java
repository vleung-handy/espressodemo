package handy.espressodemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import handy.espressodemo.fragment.LoginFragment;
import handy.espressodemo.fragment.SplashFragment;
import handy.espressodemo.fragment.UserDetailsFragment;

public class MainActivity extends AppCompatActivity implements
        SplashFragment.SplashLoginClickListener,
        LoginFragment.UserLoginSuccessListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.help_fab_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        switchContentFragment(new SplashFragment(), false);
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.help_dialog_title)
                .setMessage(R.string.help_dialog_content)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }

    @Override
    public void onSplashLoginClicked() {
        switchContentFragment(new LoginFragment(), true);
    }

    @Override
    public void onUserLoginSuccess() {
        switchContentFragment(new UserDetailsFragment(), true);
    }

    private void switchContentFragment(Fragment newFragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
