package com.example.galal1.clientapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import static android.R.attr.id;

/**
 * Created by Galal1 on 7/10/2018.
 */

public class PatientTwoStreamingDetection extends AppCompatActivity implements View.OnClickListener{
    String ipadress = "192.168.1.105";
    //Intent intent;
    Socket client;
    int port = 7777;
    TextView dataView;




    OutputStream outputStream2;
    OutputStreamWriter outputStreamWriter2;
    BufferedWriter bufferedWriter2;

    public BufferedReader bufferedReader2;
    public InputStream InputStream2;
    public InputStreamReader inputStreamReader2;

    private LineChart mChart1;
    private LineChart mChart2;
    private LineChart mChart3;
    private LineChart mChart4;
    private LineChart mChart5;
    private LineChart mChart6;
    private LineChart mChart7;
    private LineChart mChart8;







    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient_two_streaming_detection);
        final Button play_pause = (Button) findViewById(R.id.play_pause_togglebtn);
        //dataView = (TextView) findViewById(R.id.streaming_data_view);


        mChart1 = (LineChart) findViewById(R.id.chart1);
        mChart2 = (LineChart) findViewById(R.id.chart2);
        mChart3 = (LineChart) findViewById(R.id.chart3);
        mChart4 = (LineChart) findViewById(R.id.chart4);
        mChart5 = (LineChart) findViewById(R.id.chart5);
        mChart6 = (LineChart) findViewById(R.id.chart6);
        mChart7 = (LineChart) findViewById(R.id.chart7);
        mChart8 = (LineChart) findViewById(R.id.chart8);



        setChart(mChart1,"Channel(1)");
        setChart(mChart2,"Channel(2)");
        setChart(mChart3,"Channel(3)");
        setChart(mChart4,"Channel(4)");
        setChart(mChart5,"Channel(5)");
        setChart(mChart6,"Channel(6)");
        setChart(mChart7,"Channel(7)");
        setChart(mChart8,"Channel(8)");

        play_pause.setOnClickListener( this);





        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        /*
        intent = getIntent();
        ipadress = intent.getStringExtra("IP_AD");

        */







    }

    private void addEntry(String string,LineChart Chart) {

        LineData data = Chart.getData();

        if (data != null) {

            ILineDataSet set = data.getDataSetByIndex(0);
            // set.addEntry(...); // can be called as well

            if (set == null) {
                set = createSet();
                data.addDataSet(set);
            }


            //Float.valueOf(String);

            data.addEntry(new Entry(set.getEntryCount(),Float.valueOf(string)), 0);

            data.notifyDataChanged();

            // let the chart know it's data has changed
            Chart.notifyDataSetChanged();

            // limit the number of visible entries
            Chart.setVisibleXRangeMaximum(20);
            // mChart.setVisibleYRange(30, AxisDependency.LEFT);

            // move to the latest entry
            Chart.moveViewToX(data.getEntryCount());

            // this automatically refreshes the chart (calls invalidate())
            // mChart.moveViewTo(data.getXValCount()-7, 55f,
            // AxisDependency.LEFT);

        }
    }



    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Dynamic Data");
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(ColorTemplate.getHoloBlue());
        set.setCircleColor(Color.WHITE);
        set.setLineWidth(2f);
        set.setCircleRadius(4f);
        set.setFillAlpha(65);
        set.setFillColor(ColorTemplate.getHoloBlue());
        set.setHighLightColor(Color.rgb(244, 117, 117));
        set.setValueTextColor(Color.WHITE);
        set.setValueTextSize(9f);
        set.setDrawValues(false);
        return set;
    }


    public void setChart(LineChart Chart, String channelNumber){
        Chart.getDescription().setEnabled(true);
        Chart.getDescription().setText(channelNumber);

        // enable touch gestures
        Chart.setTouchEnabled(true);

        // enable scaling and dragging
        Chart.setDragEnabled(true);
        Chart.setScaleEnabled(true);
        Chart.setDrawGridBackground(false);

        // if disabled, scaling can be done on x- and y-axis separately
        Chart.setPinchZoom(true);

        // set an alternative background color
        Chart.setBackgroundColor(Color.LTGRAY);

        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);

        // add empty data
        Chart.setData(data);

        // get the legend (only possible after setting data)
        Legend l1 = Chart.getLegend();

        // modify the legend ...
        l1.setForm(Legend.LegendForm.LINE);
        l1.setTypeface(Typeface.DEFAULT);
        l1.setTextColor(Color.WHITE);

        XAxis x1 = Chart.getXAxis();
        x1.setTypeface(Typeface.DEFAULT);
        x1.setTextColor(Color.WHITE);
        x1.setDrawGridLines(false);
        x1.setAvoidFirstLastClipping(true);
        x1.setEnabled(true);

        YAxis leftAxis1 = Chart.getAxisLeft();
        leftAxis1.setTypeface(Typeface.DEFAULT);
        leftAxis1.setTextColor(Color.WHITE);
        leftAxis1.setGranularity(100f);
        leftAxis1.setGranularityEnabled(true);

        //leftAxis1.setAxisMaximum(100f);
        //leftAxis1.setAxisMinimum(-100f);
        leftAxis1.setDrawGridLines(true);

        YAxis rightAxis1 = Chart.getAxisRight();
        rightAxis1.setEnabled(false);


    }
    public void closebtn(View v) throws IOException {
        if(v.getId()==R.id.closebtn){
            client.close();
        }

    }



    @Override
    public void onClick(View v) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client=new Socket();
                    SocketAddress server = new InetSocketAddress(ipadress,port);
                    client.connect(server);
                    PatientTwoStreamingDetection.this.runOnUiThread(new Runnable() {
                        public void run() {
                            //Do your UI operations like dialog opening or Toast here
                            if(client.isConnected()) Toast.makeText(PatientTwoStreamingDetection.this, "Connected", Toast.LENGTH_SHORT).show();

                        }
                    });
                    outputStream2=client.getOutputStream();
                    outputStreamWriter2=new OutputStreamWriter(outputStream2);
                    bufferedWriter2=new BufferedWriter(outputStreamWriter2);
                    bufferedWriter2.write("Streaming\n");
                    bufferedWriter2.flush();

                    ///////////////////////////////

                    InputStream2 = client.getInputStream();
                    inputStreamReader2=new InputStreamReader(InputStream2);
                    bufferedReader2 = new BufferedReader(inputStreamReader2);



                    try{

                        for(;;){

                            String message =  bufferedReader2.readLine();
                            if(message.contains("b")){
                                message = message.replace("b","");

                                final MediaPlayer mp = MediaPlayer.create(PatientTwoStreamingDetection.this, R.raw.alarm);
                                mp.start();
                                NotificationManager notificationManager =
                                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                                int notifyId = 1;
                                String channelId = "some_channel_id";

                                Notification notification = new Notification.Builder(PatientTwoStreamingDetection.this)
                                        .setContentTitle("Alarm")
                                        .setContentText("Patient 2 may have a seizure")
                                        .setSmallIcon(R.drawable.appicon)
                                        .setShowWhen(true)
                                        .build();

                                notificationManager.notify(id, notification);
                            }
                            final String[] parts = message.split("a",16);





                            if(message.length()!=0){
                                PatientTwoStreamingDetection.this.runOnUiThread(new Runnable() {
                                    public void run() {


                                        //Do your UI operations like dialog opening or Toast here
                                        //dataView.setText(parts[8]+"    "+parts[9]);
                                        addEntry(parts[8],mChart1);
                                        addEntry(parts[9],mChart2);
                                        addEntry(parts[10],mChart3);
                                        addEntry(parts[11],mChart4);
                                        addEntry(parts[12],mChart5);
                                        addEntry(parts[13],mChart6);
                                        addEntry(parts[14],mChart7);
                                        addEntry(parts[15],mChart8);

                                    }
                                });


                            }

                        }


                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }


                }
                catch (UnknownHostException e2) {
                    e2.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    Log.d("Time out", "Time");
                }
            }
        }).start();


    }
    public void onBackPressed(){
        super.onBackPressed();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //finish();
    }

}