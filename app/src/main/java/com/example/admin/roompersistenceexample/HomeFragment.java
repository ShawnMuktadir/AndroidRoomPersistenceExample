package com.example.admin.roompersistenceexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedReader;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btn_addUser,btn_viewUser,btn_deleteUser,btn_updateUser;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btn_addUser = view.findViewById(R.id.btn_addUser);
        btn_addUser.setOnClickListener(this);

        btn_viewUser = view.findViewById(R.id.btn_viewUser);
        btn_viewUser.setOnClickListener(this);

        btn_deleteUser = view.findViewById(R.id.btn_deleteUser);
        btn_deleteUser.setOnClickListener(this);

        btn_updateUser = view.findViewById(R.id.btn_updateUser);
        btn_updateUser.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_addUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.btn_viewUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ViewUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.btn_deleteUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteFragment()).addToBackStack(null).commit();
                break;

            case R.id.btn_updateUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
