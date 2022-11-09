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

import com.example.employeetestjava.data.ProfessionalData;
import com.example.employeetestjava.data.ProfileData;


public class ProfessionDetailsFragment extends Fragment {

    private EditText company,dateOfJoining,designation,address;
    private Button submit;
    private String companyValue,dateOfjoiningValue,designationValue,addressValue;


    public ProfessionDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profession, container, false);
        ProfileData args = ProfessionDetailsFragmentArgs.fromBundle(getArguments()).getProfileArguments();

        company = v.findViewById(R.id.editTextCompany);
        dateOfJoining = v.findViewById(R.id.editTextDOJ);
        designation = v.findViewById(R.id.editTextTextPersonName2);
        address = v.findViewById(R.id.editTextTextPersonName3);
        submit = v.findViewById(R.id.submit_button);

        TextWatcher();

        ProfileData profileData = new ProfileData(args.getName(),args.getData(),args.getAddress());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfessionalData professionalData = new ProfessionalData(companyValue,designationValue,dateOfjoiningValue,addressValue,profileData);
                NavDirections action = ProfessionDetailsFragmentDirections.actionProfessionDetailsFragmentToOverallDetailsFragment(professionalData);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return v;
    }

    private void TextWatcher(){
        company.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                companyValue = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        dateOfJoining.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                dateOfjoiningValue = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        designation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                designation.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        designationValue = charSequence.toString();
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                addressValue = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}