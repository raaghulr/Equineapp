package in.raaghulr.equineapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityAddHorse extends AppCompatActivity {
    EditText etbreed;
    EditText etdistingiushingmarks;
    EditText ettype;
    EditText etage;
    EditText etmicrochipnumber;
    EditText etheight ;
    EditText etweight ;
    Button Adddetails;
    DatabaseReference databaseHorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_horse);

        databaseHorse = FirebaseDatabase.getInstance().getReference("horse");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        etbreed = (EditText)findViewById(R.id.et_breed);
        etdistingiushingmarks = (EditText)findViewById(R.id.et_distingusihing_marks);
        ettype = (EditText)findViewById(R.id.et_type);
        etage = (EditText)findViewById(R.id.et_age);
        etmicrochipnumber = (EditText)findViewById(R.id.et_microchip_number);
        etheight = (EditText)findViewById(R.id.et_height);
        etweight = (EditText)findViewById(R.id.et_weight);
        Adddetails = (Button)findViewById(R.id.btn_add_details);

        Adddetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addhorse();

            }
        });



    }

    public void MtdClear(View v){
        etbreed.setText("", TextView.BufferType.EDITABLE);

        etdistingiushingmarks.setText("", TextView.BufferType.EDITABLE);
        ettype.setText("", TextView.BufferType.EDITABLE);
        etage.setText("", TextView.BufferType.EDITABLE);
        etmicrochipnumber.setText("", TextView.BufferType.EDITABLE);
        etheight.setText("", TextView.BufferType.EDITABLE);
        etweight.setText("", TextView.BufferType.EDITABLE);
        Toast.makeText(this, "Details Cleared!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void addhorse(){
        String breed = etbreed.getText().toString();
        String distingiushingmarks  = etdistingiushingmarks.getText().toString();
        String type =ettype.getText().toString();
        String age  = String.valueOf(etage.getText());
        String microchipnumber  = String.valueOf(etmicrochipnumber.getText());
        String height = String.valueOf(etheight.getText());
        String weight = String.valueOf(etweight.getText());
        if(!TextUtils.isEmpty(breed)){
            String id = databaseHorse.push().getKey();
            Horse newhorse = new Horse(id,breed,distingiushingmarks,type,age,microchipnumber,height,weight);
            databaseHorse.child(id).setValue(newhorse);
            Toast.makeText(this, "Horse Details Stored in Cloud!!!", Toast.LENGTH_SHORT).show();


        }
        else
        {
            Toast.makeText(this, "Please Enter Correct Value!!!", Toast.LENGTH_SHORT).show();
        }
    }

}
