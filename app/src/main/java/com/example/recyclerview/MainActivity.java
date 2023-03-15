package com.example.recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerContactAdapter.itemClicked {

    RecyclerView recyclerView;
    FloatingActionButton btnDialogueBox;
    EditText etName,etNumber;
    Button btnAdd;
    ArrayList<contact> arrContacts = new ArrayList<>();
    RecyclerContactAdapter  adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyceContact);
        btnDialogueBox = findViewById(R.id.btnDialogueBox);

        btnDialogueBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                etName = dialog.findViewById(R.id.etName);
                etNumber=dialog. findViewById(R.id.etNumber);
                btnAdd  = dialog.findViewById(R.id.btnAction);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name =etName.getText().toString();
                        String num = etNumber.getText().toString();

                        if(name.isEmpty()){
                            Toast.makeText(MainActivity.this,"plz Enter the name",Toast.LENGTH_SHORT).show();
                        }
                        if(num.isEmpty()){
                            Toast.makeText(MainActivity.this,"plz Enter the Number",Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new contact(name,num));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrContacts .add( new contact( R.drawable.b,"parwez","12345"));
        arrContacts .add( new contact( R.drawable.a,"arish","56789"));
        arrContacts .add( new contact( R.drawable.girl,"moshi","01234"));
        arrContacts .add( new contact( R.drawable.person,"asif","98765"));
        arrContacts .add( new contact( R.drawable.b,"parwez","12345"));
        arrContacts .add( new contact( R.drawable.a,"arish","56789"));
        arrContacts .add( new contact( R.drawable.girl,"moshi","01234"));
        arrContacts .add( new contact( R.drawable.person,"asif","98765"));
        arrContacts .add( new contact( R.drawable.b,"parwez","12345"));
        arrContacts .add( new contact( R.drawable.a,"arish","56789"));
        arrContacts .add( new contact( R.drawable.girl,"moshi","01234"));
        arrContacts .add( new contact( R.drawable.person,"asif","98765"));

        adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,"this is clicked "+arrContacts.get(index).name,Toast.LENGTH_SHORT).show();;
    }
}