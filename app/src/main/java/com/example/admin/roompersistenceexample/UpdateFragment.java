package com.example.admin.roompersistenceexample;


import android.os.Bundle;
import android.security.keystore.UserPresenceUnavailableException;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    EditText et_updateId,et_updateUsername,et_updateuserEmail;
    Button btn_update;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        et_updateId = view.findViewById(R.id.et_updateId);
        et_updateUsername = view.findViewById(R.id.et_updateUsername);
        et_updateuserEmail = view.findViewById(R.id.et_updateuserEmail);
        btn_update = view.findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(et_updateId.getText().toString());
                String name = et_updateUsername.getText().toString();
                String email = et_updateuserEmail.getText().toString();



                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User Updated Successfully", Toast.LENGTH_SHORT).show();

                et_updateId.setText("");
                et_updateUsername.setText("");
                et_updateuserEmail.setText("");
            }
        });

        return view;
    }

}
