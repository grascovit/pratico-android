package br.com.codinglab.pratico.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.codinglab.pratico.R;
import br.com.codinglab.pratico.fragments.LoginFragment;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            LoginFragment loginFragment = new LoginFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, loginFragment).commit();
        }
    }
}
