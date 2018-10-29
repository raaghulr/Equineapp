package in.raaghulr.equineapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ActivityAddVet extends AppCompatActivity {
    EditText etname;
    EditText etcompanyname;
    EditText etmobile;
    EditText etlandline;
    EditText etemail;
    EditText etbank ;
    Button Adddetails;
    FirebaseFirestore mFirestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vet);

        mFirestore = FirebaseFirestore.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         etname = (EditText)findViewById(R.id.et_name);
         etcompanyname = (EditText)findViewById(R.id.et_company_name);
         etmobile = (EditText)findViewById(R.id.et_mobile_number);
         etlandline = (EditText)findViewById(R.id.et_landline_number);
         etemail = (EditText)findViewById(R.id.et_email);
         etbank = (EditText)findViewById(R.id.et_bank_details);
         Adddetails = (Button)findViewById(R.id.btn_add_details);

         Adddetails.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String name = etname.getText().toString();
                 String companyname  = etcompanyname.getText().toString();
                 String mobile = String.valueOf(etmobile.getText());
                 String landline  = String.valueOf(etlandline.getText());
                 String email  = etemail.getText().toString();
                 String bank = etbank.getText().toString();

                 Map<String,String> struserMap = new HashMap<>();
                 struserMap.put("Name",name);
                 struserMap.put("Company Name",companyname);
                 struserMap.put("Email",email);
                 struserMap.put("Bank Details",bank);
                 struserMap.put("Mobile Number",mobile);
                 struserMap.put("Landline Number", landline);

                 mFirestore.collection("Vet")
                         .add(struserMap)
                         .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                     @Override
                     public void onSuccess(DocumentReference documentReference) {
                         Toast.makeText(ActivityAddVet.this, "Vet Details added to FireStore database!!!", Toast.LENGTH_SHORT).show();
                     }
                 })
                         .addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         String error = e.getMessage();
                         Toast.makeText(ActivityAddVet.this,"Error : "+ error, Toast.LENGTH_SHORT).show();
                     }
                 });

             }
         });



    }

    public void MtdClear(View v){
        etname.setText("", TextView.BufferType.EDITABLE);

        etcompanyname.setText("", TextView.BufferType.EDITABLE);
        etmobile.setText("", TextView.BufferType.EDITABLE);
        etlandline.setText("", TextView.BufferType.EDITABLE);
        etemail.setText("", TextView.BufferType.EDITABLE);
        etbank.setText("", TextView.BufferType.EDITABLE);
        Toast.makeText(this, "Details Cleared!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
