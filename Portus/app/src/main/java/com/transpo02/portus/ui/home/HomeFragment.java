package com.example.portusnav.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
    
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    DocumentReference docRef = database.collection("tickets").document("ticket");
    private HomeViewModel homeViewModel;

    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        txt = (EditText) findViewById(R.id.ticketentry);
        btn = (Button) findViewById(R.id.itineraryButton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             ticNum = txt.getText().toString();
             docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Ticket ticket = documentSnapshot.toObject(Ticket.class);
                System.out.println("Hello " + ticket.fname);
                System.out.println("You are departing from " + ticket.deptCity + " at " + ticket.deptTime);
                System.out.println("You should arrive 45 minutes before to expedite your check-in and security screening process")
    }
});
            }
        });
        return root;
    }
