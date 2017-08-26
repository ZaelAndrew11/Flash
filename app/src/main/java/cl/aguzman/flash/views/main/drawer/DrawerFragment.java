package cl.aguzman.flash.views.main.drawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import cl.aguzman.flash.R;
import cl.aguzman.flash.data.CurrentUser;
import cl.aguzman.flash.views.login.LoginActivity;

public class DrawerFragment extends Fragment {
    public DrawerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drawer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView logoutTv = (TextView) view.findViewById(R.id.logoutTv);
        logoutTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .signOut(getActivity())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                               Intent intent = new Intent(getActivity(), LoginActivity.class);
                               startActivity(intent);
                                getActivity().finish();
                            }
                        });
            }
        });

        TextView emailTv = (TextView) view.findViewById(R.id.emailTv);
        emailTv.setText(new CurrentUser().email());
    }
}
