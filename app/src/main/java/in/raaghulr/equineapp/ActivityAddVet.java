package in.raaghulr.equineapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityAddVet extends AppCompatActivity {
    EditText etname;
    EditText etcompanyname;
    EditText etmobile;
    EditText etlandline;
    EditText etemail;
    EditText etbank ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         etname = (EditText)findViewById(R.id.et_name);
         etcompanyname = (EditText)findViewById(R.id.et_company_name);
         etmobile = (EditText)findViewById(R.id.et_mobile_number);
         etlandline = (EditText)findViewById(R.id.et_landline_number);
         etemail = (EditText)findViewById(R.id.et_email);
         etbank = (EditText)findViewById(R.id.et_bank_details);



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
