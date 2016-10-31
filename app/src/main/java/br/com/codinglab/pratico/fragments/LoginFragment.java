package br.com.codinglab.pratico.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.com.codinglab.pratico.R;
import br.com.codinglab.pratico.models.Skill;
import br.com.codinglab.pratico.rest.ApiClient;
import br.com.codinglab.pratico.services.SkillService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {

    @BindView(R.id.email_login_edit_text)
    EditText email;

    @BindView(R.id.password_login_edit_text)
    EditText password;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.login_button)
    public void doLogin() {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        boolean hasAnyValidationError = userEmail.isEmpty() || userPassword.isEmpty();

        if (userEmail.isEmpty()) {
            email.setError("Seu email não pode ficar em branco");
        }

        if (userPassword.isEmpty()) {
            password.setError("Sua senha não pode ficar em branco");
        }

        // TODO: implementar chamada para o login
    }

    @OnClick(R.id.go_for_sign_up_button)
    public void goForSignUp() {
        SignUpFragment signUpFragment = new SignUpFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, signUpFragment).addToBackStack(null).commit();
    }
}
