package com.example.admin.roompersistenceexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {

    EditText et_deleteUserId;
    Button btn_delete;


    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        et_deleteUserId = view.findViewById(R.id.et_deleteUserId);
        btn_delete = view.findViewById(R.id.btn_delete);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(et_deleteUserId.getText().toString());

                User user = new User();
                user.setId(id);

                MainActivity.myDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(), "User Deleted Successfully", Toast.LENGTH_SHORT).show();

                et_deleteUserId.setText("");
            }
        });

        return view;
    }

}
