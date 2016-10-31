package br.com.codinglab.pratico.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.codinglab.pratico.R;
import br.com.codinglab.pratico.models.User;
import br.com.codinglab.pratico.rest.ApiClient;
import br.com.codinglab.pratico.services.UserService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpFragment extends Fragment {

    @BindView(R.id.first_name_sign_up_edit_text)
    EditText firstName;

    @BindView(R.id.last_name_sign_up_edit_text)
    EditText lastName;

    @BindView(R.id.email_sign_up_edit_text)
    EditText email;

    @BindView(R.id.password_sign_up_edit_text)
    EditText password;

    @BindView(R.id.cpf_sign_up_edit_text)
    EditText cpf;

    @BindView(R.id.phone_sign_up_edit_text)
    EditText phone;

    public SignUpFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.sign_up_button)
    public void doSignUp() {
        String userFirstName = firstName.getText().toString();
        String userLastName = lastName.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        String userCpf = cpf.getText().toString();
        String userPhone = phone.getText().toString();

        if (userFirstName.isEmpty()) {
            firstName.setError("Seu nome não pode ficar em branco");
        }

        if (userLastName.isEmpty()) {
            lastName.setError("Seu sobrenome não pode ficar em branco");
        }

        if (userEmail.isEmpty()) {
            email.setError("Seu email não pode ficar em branco");
        }

        if (userPassword.isEmpty() || userPassword.length() < 6) {
            password.setError("Sua senha deve possuir pelo menos 6 caracteres");
        }

        if (userCpf.isEmpty() || userCpf.length() != 11) {
            cpf.setError("Seu CPF deve possuir exatamente 11 caracteres");
        }

        if (userPhone.isEmpty()) {
            phone.setError("Seu telefone não pode ficar em branco. Informe um telefone celular ou residencial");
        }

        boolean hasAnyValidationError = userFirstName.isEmpty() || userLastName.isEmpty() ||
                userEmail.isEmpty() || userPassword.isEmpty() || userPassword.length() < 6 ||
                userCpf.isEmpty() || userCpf.length() != 11 || userPhone.isEmpty();

        if (!hasAnyValidationError) {
            User user = new User(userFirstName, userLastName, userEmail, userPassword, userCpf);
            createUserSignUpCall(user).enqueue(createUserSignUpCallback());
        }
    }

    private Call<User> createUserSignUpCall(User user) {
        return ApiClient.createService(UserService.class).createUser(user);
    }

    private Callback<User> createUserSignUpCallback() {
        return new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        };
    }
}
