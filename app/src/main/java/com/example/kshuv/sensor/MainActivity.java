package com.example.kshuv.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager  mSensorManger;

    TextView number,sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //my method
        getandprintSensors();
    }

    public void getandprintSensors() {
        number=findViewById(R.id.number);
        sensor=findViewById(R.id.sensor);

        //get the sensormenager

        mSensorManger=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //list of all sensor avilable

        List<Sensor> deviceSensor =mSensorManger.getSensorList(Sensor.TYPE_ALL);

        //print how many sensor avilable

        number.setText(deviceSensor.size()+"Sensor Available");

        String SensorStringList=new String("");

        Sensor temp;
        int i,serial;

        for(i=0;i<deviceSensor.size();i++){
            temp=deviceSensor.get(i);
            serial=i+1;
            SensorStringList=SensorStringList+serial+" ."+temp.getName()+"\n\n";

        }
        if (i>0){
            SensorStringList="Sensors :\n"+SensorStringList;
            sensor.setText(SensorStringList);
        }

    }
}
