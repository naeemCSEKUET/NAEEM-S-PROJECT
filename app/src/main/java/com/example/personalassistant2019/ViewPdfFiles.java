package com.example.personalassistant2019;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewPdfFiles extends AppCompatActivity {

    ListView mypdflistView;
    DatabaseReference databaseReference;
    List<UplodPdf>uplodPdfs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf_files);

        mypdflistView=(ListView)findViewById(R.id.listviewId1);
        uplodPdfs=new ArrayList<>();
        viewAllfiles();
        mypdflistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UplodPdf uplodPdf=uplodPdfs.get(position);
                Intent intent=new Intent();
                intent.setType(Intent.ACTION_VIEW);

                intent.setData(Uri.parse(uplodPdf.getUrl()));
                startActivity(intent);
            }
        });
    }

    private void viewAllfiles() {
        databaseReference= FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postsnapshot: dataSnapshot.getChildren())
                {
                    UplodPdf uplodPdf=postsnapshot.getValue(UplodPdf.class);
                    uplodPdfs.add(uplodPdf);

                }

                String [] uploads=new String[uplodPdfs.size()];

                for(int i=0;i<uploads.length;i++)
                {
                    uploads[i]=uplodPdfs.get(i).getName();

                }
                ArrayAdapter<String>stringArrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads)
                {

                    @Override
                    public View getView(int position,  View convertView,  ViewGroup parent) {

                        View view=super.getView(position, convertView, parent);
                        TextView textView=(TextView)view.findViewById(android.R.id.text1);
                        textView.setTextColor(Color.BLACK);


                        return view;
                    }
                };
                mypdflistView.setAdapter(stringArrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
