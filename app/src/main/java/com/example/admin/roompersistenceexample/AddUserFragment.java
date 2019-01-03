package com.example.admin.roompersistenceexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.admin.roompersistenceexample.MainActivity.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText et_id,et_name,et_email;
    private Button btn_save;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        et_id = view.findViewById(R.id.et_id);
        et_name = view.findViewById(R.id.et_name);
        et_email = view.findViewById(R.id.et_email);
        btn_save = view.findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int user_id = Integer.parseInt(et_id.getText().toString());
                String user_name = et_name.getText().toString();
                String user_email = et_email.getText().toString();

                User user = new User();
                user.setId(user_id);
                user.setName(user_name);
                user.setEmail(user_email);

                MainActivity.myDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User Added Successfully!!!", Toast.LENGTH_SHORT).show();

                et_id.setText("");
                et_name.setText("");
                et_email.setText("");


            }
        });



        return view;
    }

}
