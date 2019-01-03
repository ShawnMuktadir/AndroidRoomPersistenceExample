package com.example.admin.roompersistenceexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewUserFragment extends Fragment {

    TextView txt_view_info;


    public ViewUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_user, container, false);
        txt_view_info = view.findViewById(R.id.txt_view_info);

        List<User> users = MainActivity.myDatabase.myDao().getUsers();

        String info = " ";
        for (User user : users)
        {
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info + "\n\n" + "Id : "+id +"\n"+ "Name : "+name+"\n"+ "Email : "+email+"\n";
        }
        txt_view_info.setText(info);


        return view;
    }

}
