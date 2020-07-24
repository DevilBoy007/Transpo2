package com.example.portusnav.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.portusnav.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference connectedRef = database.getReference("/tickets");
    //DatabaseReference myRef = database.getInstance().getReference("/tickets");

    private HomeViewModel homeViewModel;

    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {
        connectedRef.addValueEventListener(new ValueEventListener() {
            
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Ticket ticket = dataSnapshot.getValue(Ticket.class);
                System.out.println("Hello "+ticket.fname+", in order to make your flight at "+ticket.time+" from "+ticket.dept+", you should arrive 45 minutes before boarding");
            }
            
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(getTag(), "Listener was cancelled");
            }
        });
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }
}
