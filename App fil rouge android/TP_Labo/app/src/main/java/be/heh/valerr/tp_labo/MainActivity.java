package be.heh.valerr.tp_labo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   // private static final int CODE_ACTIVITE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extratxt = this.getIntent().getExtras();
        if(extratxt != null){
            Toast.makeText(getApplicationContext(),"Votre login est " + extratxt.getString("login")) + "\n" + "votre password est : "  + extratxt.getString("pwd") + "\n" + "Votre e-mail est : " + extratxt.getString("email") + "\n",Toast.LENGTH_SHORT).show();
        }
    }

    public void onMainClickManager(View v) {
        switch (v.getId()){
            case R.id.bt_main_children:
                startActivityForResult(new Intent(this,ChildrenActivity.class),CODE_ACTIVITE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CODE_ACTIVITE:
                switch (resultCode){
                    case RESULT_OK:
                        Toast.makeText(getApplicationContext(), "Action validée depuis l'enfant", Toast.LENGTH_SHORT).show();
                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(getApplicationContext(),"Action annulée depuis l'enfant", Toast.LENGTH_SHORT).show();
                        return;
                }
                return;
        }
    }
}
