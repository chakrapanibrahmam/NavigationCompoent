package com.example.employeetestjava;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.employeetestjava.data.ProfileData;


public class ProfileDataFragment extends Fragment {

    private EditText etName,etData,etAddress;
    private Button nextButton;
    private String name,date,address;


    public static ProfileDataFragment newInstance(String param1, String param2) {
        ProfileDataFragment fragment = new ProfileDataFragment();
        return fragment;
    }

    public ProfileDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_data, container, false);
        etName =(EditText) v.findViewById(R.id.editTextName);
        etData =(EditText) v.findViewById(R.id.editTextDate);
        etAddress =(EditText) v.findViewById(R.id.editTextAddress);
        nextButton = (Button) v.findViewById(R.id.next_button);

        etData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                date = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                name = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                address = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileData profileData = new ProfileData(name,date,address);
                 NavDirections action = ProfileDataFragmentDirections.actionProfileDataFragmentToProfessionDetailsFragment(profileData);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return v;
    }
}