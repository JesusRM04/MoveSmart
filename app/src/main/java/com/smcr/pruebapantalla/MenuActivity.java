package com.smcr.pruebapantalla;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.smcr.pruebapantalla.databinding.MenuBinding;

public class MenuActivity extends AppCompatActivity {
    MenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.bottomNavMenu.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.uno) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.dos) {
                replaceFragment(new MapaFragment());
            } else if (item.getItemId() == R.id.tres) {
                replaceFragment(new RutasFragment());
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
