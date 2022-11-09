package com.example.employeetestjava;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeetestjava.data.ProfessionalData;
import com.example.employeetestjava.data.ProfileData;
import com.example.employeetestjava.data.Results;
import com.example.employeetestjava.data.UserData;
import com.example.employeetestjava.retrofit.RestClient;
import com.example.employeetestjava.retrofit.UserListAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlinx.coroutines.GlobalScope;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class OverallDetailsFragment extends Fragment {

    private TextView nameTV,dateTV,addressTV,company,designation;

    public OverallDetailsFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overall_details, container, false);

        getUserDataFromAPI();

        ProfessionalData getArgsData = OverallDetailsFragmentArgs.fromBundle(getArguments()).getProfessionalArgs();

        nameTV = view.findViewById(R.id.nameText);
        dateTV = view.findViewById(R.id.dateText);
        addressTV = view.findViewById(R.id.address);
        company = view.findViewById(R.id.companyText);
        designation = view.findViewById(R.id.designationText);

        addressTV.setText(getArgsData.getAddress());
        company.setText(getArgsData.getCompany());
        designation.setText(getArgsData.getDesignation());
        nameTV.setText(getArgsData.getProfileData().getName());
        dateTV.setText(getArgsData.getProfileData().getData());

        return view;
    }

    private void getUserDataFromAPI(){
        RestClient.createService(UserListAPI.class).getUserList()
                .enqueue(new Callback<UserData>() {
                    @Override
                    public void onResponse(Call<UserData> call, Response<UserData> response) {
                       if(response.code() == 200){
                           Toast.makeText(getActivity(),"succesfully connected to API",Toast.LENGTH_LONG).show();
                       }


                    }

                    @Override
                    public void onFailure(Call<UserData> call, Throwable t) {
                        Toast.makeText(getContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                    }
                });


    }
}