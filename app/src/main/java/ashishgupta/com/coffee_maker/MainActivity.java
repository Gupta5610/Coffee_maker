package ashishgupta.com.coffee_maker;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static EditText name;
    private static CheckBox cream,choclate;

    TextView OrderDeatils,Quantity;
    int base_price=5,extra_cream=1,extra_choclate=2,quant=0,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.Name);
        OrderDeatils=(TextView)findViewById(R.id.OrderDetails);
        Quantity=(TextView)findViewById(R.id.Quantity);
        cream=(CheckBox)findViewById(R.id.cream);
        choclate=(CheckBox)findViewById(R.id.choclate);
        Quantity.setText("0");
        OrderDeatils.setText("0$");
    }

    public void onclick(View view)
    {
        switch (view.getId())
        {
            case R.id.Increement: quant ++;
                                  change_text();
                                  break;
            case R.id.Decreement: quant--;
                                  change_text();
                                  break;
            case R.id.Order : show();
                              break;

        }
    }
    public void addon(View view)
    {change_text();}
    public void change_text()
    {
        Quantity.setText(String.valueOf(quant));
        if(quant<0)
        {
            Toast.makeText(getApplicationContext(),"Quantity can be Negative",Toast.LENGTH_SHORT).show();
            quant=0;
        }
        if(cream.isChecked()&&choclate.isChecked())
            total=(base_price+extra_choclate+extra_cream)*quant;
        else if(cream.isChecked())
            total=(base_price+extra_cream)*quant;
        else if(choclate.isChecked())
            total=(base_price+extra_choclate)*quant;
        else
            total=(base_price)*quant;

        OrderDeatils.setText(total+"$");
    }

    public void show()
    {
        OrderDeatils.setText("Total Amount Payable : "+total+"$\nName : "+name.getText().toString());
    }
}
