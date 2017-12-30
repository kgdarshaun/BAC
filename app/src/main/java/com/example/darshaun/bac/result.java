package com.example.darshaun.bac;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class result extends AppCompatActivity {

    String compressor_model, dryer_model, filter_gp3, filter_zp1, filter_zo01, filter_zc01, air_reciever, auto_drain;
    float compressor_price, dryer_price, filter_gp3_price, filter_zp1_price, filter_zo01_price, filter_zc01_price, air_reciever_price, auto_drain_price;

    float total, selected_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        float temp;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        int pressure = prefs.getInt("pressure",0);
        int cfm = prefs.getInt("cfm",0);
        int capacity = prefs.getInt("capacity",0);
        String model = prefs.getString("model","");
        int discount = prefs.getInt("discount",0);

        //Toast.makeText(this,String.valueOf(pressure),Toast.LENGTH_SHORT).show();

        compressor_model_calc(pressure,cfm);
        temp = (compressor_price*discount)/100;
        compressor_price = compressor_price-temp;

        dryer_model_calc(cfm);
        temp = (dryer_price*discount)/100;
        dryer_price = dryer_price-temp;

        filter_calc(cfm);
        temp = (filter_gp3_price*discount)/100;
        filter_gp3_price = filter_gp3_price-temp;
        temp = (filter_zp1_price*discount)/100;
        filter_zp1_price = filter_zp1_price-temp;
        temp = (filter_zo01_price*discount)/100;
        filter_zo01_price = filter_zo01_price-temp;
        temp = (filter_zc01_price*discount)/100;
        filter_zc01_price = filter_zc01_price-temp;

        air_reciever_calc(capacity);
        temp = (air_reciever_price*discount)/100;
        air_reciever_price = air_reciever_price-temp;

        auto_drain_calc(model);
        temp = (auto_drain_price*discount)/100;
        auto_drain_price = auto_drain_price-temp;

        total = compressor_price + dryer_price + filter_gp3_price + filter_zp1_price + filter_zo01_price + filter_zc01_price + air_reciever_price + auto_drain_price;

        TextView tv7 = findViewById(R.id.textView7);
        tv7.setText(String.format("%.2f",total));

        TextView tv9 = findViewById(R.id.textView9);
        tv9.setText(String.format("%.2f",0.00));

        TextView tv11 = (TextView) findViewById(R.id.textView11);
        tv11.setText(compressor_model);
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb1.setText(String.format("%.2f", compressor_price));
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox1);
                if ( isChecked )
                {
                    selected_total = selected_total + compressor_price;
                }
                else{
                    selected_total = selected_total - compressor_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;
                }
                tv.setText(String.format("%.2f",selected_total));
            }
            });

        TextView tv13 = (TextView) findViewById(R.id.textView13);
        tv13.setText(dryer_model);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb2.setText(String.format("%.2f", dryer_price));
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox2);
                float temp = Float.parseFloat(tv.getText().toString());
                float pr = Float.parseFloat(cb.getText().toString());
                if ( isChecked )
                {
                    selected_total = selected_total + dryer_price;
                }
                else{
                    selected_total = selected_total - dryer_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;
                }
                tv.setText(String.format("%.2f",selected_total));
            }
        });

        TextView tv15 = (TextView) findViewById(R.id.textView15);
        tv15.setText(filter_gp3);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb3.setText(String.format("%.2f", filter_gp3_price));
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox3);
                float temp = Float.parseFloat(tv.getText().toString());
                float pr = Float.parseFloat(cb.getText().toString());
                if ( isChecked )
                {
                    selected_total = selected_total + filter_gp3_price;
                }
                else{
                    selected_total = selected_total - filter_gp3_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;
                }
                tv.setText(String.format("%.2f",selected_total));
            }
        });

        TextView tv17 = (TextView) findViewById(R.id.textView17);
        tv17.setText(filter_zp1);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb4.setText(String.format("%.2f", filter_zp1_price));
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox4);
                float temp = Float.parseFloat(tv.getText().toString());
                float pr = Float.parseFloat(cb.getText().toString());
                if ( isChecked )
                {
                    selected_total = selected_total + filter_zp1_price;
                }
                else{
                    selected_total = selected_total - filter_zp1_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;
                }
                tv.setText(String.format("%.2f",selected_total));
            }
        });

        TextView tv19 = (TextView) findViewById(R.id.textView19);
        tv19.setText(filter_zo01);
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
        cb5.setText(String.format("%.2f", filter_zo01_price));
        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox5);
                float temp = Float.parseFloat(tv.getText().toString());
                float pr = Float.parseFloat(cb.getText().toString());
                if ( isChecked )
                {
                    selected_total = selected_total + filter_zo01_price;
                }
                else{
                    selected_total = selected_total - filter_zo01_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;
                }
                tv.setText(String.format("%.2f",selected_total));
            }
        });

        TextView tv21 = (TextView) findViewById(R.id.textView21);
        tv21.setText(filter_zc01);
        CheckBox cb6 = (CheckBox) findViewById(R.id.checkBox6);
        cb6.setText(String.format("%.2f", filter_zc01_price));
        cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox6);
                float temp = Float.parseFloat(tv.getText().toString());
                float pr = Float.parseFloat(cb.getText().toString());
                if ( isChecked )
                {
                    selected_total = selected_total + filter_zc01_price;
                }
                else{
                    selected_total = selected_total - filter_zc01_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;
                }
                tv.setText(String.format("%.2f",selected_total));
            }
        });

        TextView tv23 = (TextView) findViewById(R.id.textView23);
        tv23.setText(air_reciever);
        CheckBox cb7 = (CheckBox) findViewById(R.id.checkBox7);
        cb7.setText(String.format("%.2f", air_reciever_price));
        cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox7);
                float temp = Float.parseFloat(tv.getText().toString());
                float pr = Float.parseFloat(cb.getText().toString());
                if ( isChecked )
                {
                    selected_total = selected_total + air_reciever_price;
                }
                else{
                    selected_total = selected_total - air_reciever_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;
                }
                tv.setText(String.format("%.2f",selected_total));
            }
        });

        TextView tv25 = (TextView) findViewById(R.id.textView25);
        tv25.setText(auto_drain);
        CheckBox cb8 = (CheckBox) findViewById(R.id.checkBox8);
        cb8.setText(String.format("%.2f", auto_drain_price));
        cb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                TextView tv = (TextView) findViewById(R.id.textView9);
                CheckBox cb = (CheckBox) findViewById(R.id.checkBox8);
                float temp = Float.parseFloat(tv.getText().toString());
                float pr = Float.parseFloat(cb.getText().toString());
                if ( isChecked )
                {
                    selected_total = selected_total + auto_drain_price;
                }
                else{
                    selected_total = selected_total - auto_drain_price;
                    if(selected_total<1)
                        selected_total= (float) 0.00;

                }
                tv.setText(String.format("%.2f",selected_total));
            }
        });

    }

    public void compressor_model_calc(int pressure, int cfm){
        if(pressure == 7){
            if(cfm>0) {
                if (cfm > 32) {
                    if (cfm > 42) {
                        if (cfm > 58) {
                            if (cfm > 90) {
                                if (cfm > 114) {
                                    if (cfm > 130) {
                                        if (cfm > 184) {
                                            if (cfm > 232) {
                                                if (cfm > 260) {
                                                    compressor_model = "-NA-";
                                                    compressor_price = 0;
                                                } else {
                                                    compressor_model = "BAC-SD-60";
                                                    compressor_price =  674083;
                                                }
                                            } else {
                                                compressor_model = "BAC-SD-50";
                                                compressor_price =  569735;
                                            }
                                        } else {
                                            compressor_model = "BAC-SD-40";
                                            compressor_price =  517561;
                                        }
                                    } else {
                                        compressor_model = "BAC-SD-30";
                                        compressor_price =  356167;
                                    }
                                } else {
                                    compressor_model = "BAC-SD-25";
                                    compressor_price =  338775;
                                }
                            } else {
                                compressor_model = "BAC-SD-20";
                                compressor_price =  321383;
                            }
                        } else {
                            compressor_model = "BAC-SD-15";
                            compressor_price =  274546;
                        }
                    } else {
                        compressor_model = "BAC-SD-10";
                        compressor_price =  227273;
                    }
                } else {
                    compressor_model = "BAC-SD-7.2";
                    compressor_price =  207273;
                }
            } else {
                compressor_model = "-NA-";
                compressor_price = 0;
            }
        }
        else if(pressure == 8){
            if(cfm>0) {
                if (cfm > 28) {
                    if (cfm > 39) {
                        if (cfm > 54) {
                            if (cfm > 80) {
                                if (cfm > 107) {
                                    if (cfm > 126) {
                                        if (cfm > 179) {
                                            if (cfm > 221) {
                                                if (cfm > 251) {
                                                    compressor_model = "-NA-";
                                                    compressor_price = 0;
                                                } else {
                                                    compressor_model = "BAC-SD-60";
                                                    compressor_price =  674083;
                                                }
                                            } else {
                                                compressor_model = "BAC-SD-50";
                                                compressor_price =  569735;
                                            }
                                        } else {
                                            compressor_model = "BAC-SD-40";
                                            compressor_price =  517561;
                                        }
                                    } else {
                                        compressor_model = "BAC-SD-30";
                                        compressor_price =  356167;
                                    }
                                } else {
                                    compressor_model = "BAC-SD-25";
                                    compressor_price =  338775;
                                }
                            } else {
                                compressor_model = "BAC-SD-20";
                                compressor_price =  321383;
                            }
                        } else {
                            compressor_model = "BAC-SD-15";
                            compressor_price =  274546;
                        }
                    } else {
                        compressor_model = "BAC-SD-10";
                        compressor_price =  227273;
                    }
                } else {
                    compressor_model = "BAC-SD-7.2";
                    compressor_price =  207273;
                }
            } else {
                compressor_model = "-NA-";
                compressor_price = 0;
            }
        }
        else if(pressure == 10){
            if(cfm>0) {
                if (cfm > 24) {
                    if (cfm > 34) {
                        if (cfm > 46) {
                            if (cfm > 64) {
                                if (cfm > 89) {
                                    if (cfm > 108) {
                                        if (cfm > 160) {
                                            if (cfm > 205) {
                                                if (cfm > 229) {
                                                    compressor_model = "-NA-";
                                                    compressor_price = 0;
                                                } else {
                                                    compressor_model = "BAC-SD-60";
                                                    compressor_price =  674083;
                                                }
                                            } else {
                                                compressor_model = "BAC-SD-50";
                                                compressor_price =  569735;
                                            }
                                        } else {
                                            compressor_model = "BAC-SD-40";
                                            compressor_price =  517561;
                                        }
                                    } else {
                                        compressor_model = "BAC-SD-30";
                                        compressor_price =  356167;
                                    }
                                } else {
                                    compressor_model = "BAC-SD-25";
                                    compressor_price =  338775;
                                }
                            } else {
                                compressor_model = "BAC-SD-20";
                                compressor_price =  321383;
                            }
                        } else {
                            compressor_model = "BAC-SD-15";
                            compressor_price =  274546;
                        }
                    } else {
                        compressor_model = "BAC-SD-10";
                        compressor_price =  227273;
                    }
                } else {
                    compressor_model = "BAC-SD-7.2";
                    compressor_price =  207273;
                }
            } else {
                compressor_model = "-NA-";
                compressor_price = 0;
            }
        }
    }

    public void dryer_model_calc(int cfm){
        if(cfm>0) {
            if (cfm > 20) {
                if (cfm > 40) {
                    if (cfm > 50) {
                        if (cfm > 60) {
                            if (cfm > 80) {
                                if (cfm > 100) {
                                    if (cfm > 150) {
                                        if (cfm > 200) {
                                            if (cfm > 250) {
                                                if(cfm > 300){
                                                    if( cfm > 400){
                                                        dryer_model = "-NA-";
                                                        dryer_price = 0;
                                                    } else{
                                                        dryer_model = "BAC-RDS-400";
                                                        dryer_price =  313500;
                                                    }
                                                } else{
                                                    dryer_model = "BAC-RDS-300";
                                                    dryer_price =   238500;
                                                }
                                            } else {
                                                dryer_model = "BAC-RDS-250";
                                                dryer_price =   226500;
                                            }
                                        } else {
                                            dryer_model = "BAC-RDS-200";
                                            dryer_price =   185185;
                                        }
                                    } else {
                                        dryer_model = "BAC-RDS-150";
                                        dryer_price =   142506;
                                    }
                                } else {
                                    dryer_model = "BAC-RDS-100";
                                    dryer_price =   129584;
                                }
                            } else {
                                dryer_model = "BAC-RDS-80";
                                dryer_price =   99190;
                            }
                        } else {
                            dryer_model = "BAC-RDS-60";
                            dryer_price =   88452;
                        }
                    } else {
                        dryer_model = "BAC-RDS-50";
                        dryer_price =   79534;
                    }
                } else {
                    dryer_model = "BAC-RDS-40";
                    dryer_price =   77350;
                }
            } else {
                dryer_model = "BAC-RDS-20";
                dryer_price =   51961;
            }
        } else {
            dryer_model = "-NA-";
            dryer_price = 0;
        }
    }

    public void filter_calc(int cfm){
        if(cfm>0) {
            if (cfm > 35) {
                if (cfm > 50) {
                    if (cfm > 75) {
                        if (cfm > 125) {
                            if (cfm > 200) {
                                if (cfm > 310) {
                                    if (cfm > 450) {
                                        filter_gp3 = "-NA-";
                                        filter_gp3_price = 0;
                                        filter_zp1 = "-NA-";
                                        filter_zp1_price = 0;
                                        filter_zo01 = "-NA-";
                                        filter_zo01_price = 0;
                                        filter_zc01 = "-NA-";
                                        filter_zc01_price = 0;
                                    } else {
                                        filter_gp3 = "BAC-PF-450-3";
                                        filter_gp3_price = 48000;
                                        filter_zp1 = "BAC-PF-450-0.1";
                                        filter_zp1_price = 49000;
                                        filter_zo01 = "BAC-PF-450-0.01";
                                        filter_zo01_price = 49400;
                                        filter_zc01 = "BAC-PF-450-0.01C";
                                        filter_zc01_price = 50000;
                                    }
                                } else {
                                    filter_gp3 = "BAC-PF-310-3";
                                    filter_gp3_price = 38800;
                                    filter_zp1 = "BAC-PF-310-0.1";
                                    filter_zp1_price = 39400;
                                    filter_zo01 = "BAC-PF-310-0.01";
                                    filter_zo01_price = 40400;
                                    filter_zc01 = "BAC-PF-310-0.01C";
                                    filter_zc01_price = 41000;
                                }
                            } else {
                                filter_gp3 = "BAC-PF-200-3";
                                filter_gp3_price = 34400;
                                filter_zp1 = "BAC-PF-200-0.1";
                                filter_zp1_price = 34600;
                                filter_zo01 = "BAC-PF-200-0.01";
                                filter_zo01_price = 35400;
                                filter_zc01 = "BAC-PF-200-0.01C";
                                filter_zc01_price = 036200;
                            }
                        } else {
                            filter_gp3 = "BAC-PF-125-3";
                            filter_gp3_price = 17600;
                            filter_zp1 = "BAC-PF-125-0.1";
                            filter_zp1_price = 17800;
                            filter_zo01 = "BAC-PF-125-0.01";
                            filter_zo01_price = 18400;
                            filter_zc01 = "BAC-PF-125-0.01C";
                            filter_zc01_price = 19000;
                        }
                    } else {
                        filter_gp3 = "BAC-PF-75-3";
                        filter_gp3_price = 9760;
                        filter_zp1 = "BAC-PF-75-0.1";
                        filter_zp1_price = 10360;
                        filter_zo01 = "BAC-PF-75-0.01";
                        filter_zo01_price = 10511;
                        filter_zc01 = "BAC-PF-75-0.01C";
                        filter_zc01_price = 11261;
                    }
                } else {
                    filter_gp3 = "BAC-PF-50-3";
                    filter_gp3_price = 8559;
                    filter_zp1 = "BAC-PF-50-0.1";
                    filter_zp1_price = 8859;
                    filter_zo01 = "BAC-PF-50-0.01";
                    filter_zo01_price = 9009;
                    filter_zc01 = "BAC-PF-50-0.01C";
                    filter_zc01_price = 9610;
                }
            } else {
                filter_gp3 = "BAC-PF-35-3";
                filter_gp3_price =  7808;
                filter_zp1 = "BAC-PF-35-0.1";
                filter_zp1_price =  8258;
                filter_zo01 = "BAC-PF-35-0.01";
                filter_zo01_price =  8408;
                filter_zc01 = "BAC-PF-35-0.01C";
                filter_zc01_price =  9009;
            }
        } else {
            filter_gp3 = "-NA-";
            filter_gp3_price = 0;
            filter_zp1 = "-NA-";
            filter_zp1_price = 0;
            filter_zo01 = "-NA-";
            filter_zo01_price = 0;
            filter_zc01 = "-NA-";
            filter_zc01_price = 0;
        }
    }

    public void air_reciever_calc(int capacity){
        if(capacity == 250){
            air_reciever = "BAC-AR-250";
            air_reciever_price = 18182;
        }
        else if(capacity == 500){
            air_reciever = "BAC-AR-VR-500";
            air_reciever_price = 32910;
        }
        else if(capacity == 1000){
            air_reciever = "BAC-AR-VR-1000";
            air_reciever_price = 57000;
        }
        else if(capacity == 1500){
            air_reciever = "BAC-AR-VR-1500";
            air_reciever_price = 77505;
        }
        else if(capacity == 2000){
            air_reciever = "BAC-AR-VR-2000";
            air_reciever_price = 97000;
        }
    }

    public void auto_drain_calc(String model){
        if(model.equals("Low Discharge")){
            auto_drain = "BAC-AD-LD";
            auto_drain_price = 3300;
        }
        else if(model.equals("High Discharge")){
            auto_drain = "BAC-AD-HD";
            auto_drain_price = 3600;
        }
        else if(model.equals("Float Type")){
            auto_drain = "BAC-AD-FT";
            auto_drain_price = 5250;
        }
        else if(model.equals("High Pressure")){
            auto_drain = "BAC-AD-HP";
            auto_drain_price = 7500;
        }
    }


}
