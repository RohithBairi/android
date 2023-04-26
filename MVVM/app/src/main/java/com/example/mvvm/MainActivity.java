package com.example.mvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setViewModel(loginViewModel);
        binding.setLifecycleOwner(this);
       loginViewModel.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                User user = (User) o;
                if (user != null)
                    if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                        Toast.makeText(getApplicationContext(), "Email : " + user.getEmail() + " Password " + user.getPassword(), Toast.LENGTH_SHORT).show();
            }
        });
        /*loginViewModel.userMutableLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null)
                    if (user.getEmail().length() > 0 || user.getPassword().length() > 0)
                        Toast.makeText(getApplicationContext(), "Email : " + user.getEmail() + " Password " + user.getPassword(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}