package com.example.portusnav.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
    
    TextView txt;
    Button btn;
    String ticNum;
    Query query = connectedRef.collections("tickets").whereEqualTo("id", ticNum);

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference connectedRef = database.getReference("/tickets");
  
    CollectionReference ticketTable = database.collection("tickets");
    
    private HomeViewModel homeViewModel;

    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        txt = (TextView) findViewById(R.id.editTextTextPersonName);
        btn = (Button) findViewById(R.id.itineraryButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             ticNum = txt.getText().toString();
            }
        });
        Ticket createTicket = dbQuery(DataSnapshot snapshot, query);
        System.out.println("Hello " + createTicket.fname);
        System.out.println("You are departing from " + createTicket.dept + " at " + 
                           createTicket.time);
        System.out.println("You should arrive 45 minutes before to expedite your check-in and security screening process");
        return root;
    }
    public Ticket dbQuery(DataSnapshot snap, Query query){
        Ticket tic = query.get();
        Ticket tic2 = snap.getChild.getValue(Ticket.class);
        return tic;
}
