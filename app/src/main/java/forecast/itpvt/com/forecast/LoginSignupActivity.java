package forecast.itpvt.com.forecast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginSignupActivity extends AppCompatActivity {

    private Button register;
    TextView skip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);





        Button startedBtn = (Button) findViewById(R.id.login_btn_get_started);
        register=(Button)findViewById(R.id.register);
        skip=(TextView)findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSignupActivity.this,MainActivity.class);
                String urlskip="http://forecast.com.pk/";
                intent.putExtra("URL",urlskip);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginSignupActivity.this,MainActivity.class);
                String urlreg="http://www.forecast.com.pk/index.php/customer/account/create/";
                intent.putExtra("URL",urlreg);
                startActivity(intent);
            }
        });
        startedBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(LoginSignupActivity.this, MainActivity.class);

                String urlslogin="http://www.forecast.com.pk/index.php/customer/account/login/";
                intent.putExtra("URL",urlslogin);
                startActivity(intent);
//                startActivity(new Intent().setClass(v.getContext(), WebActivity.class));
            }
        });
    }
}
