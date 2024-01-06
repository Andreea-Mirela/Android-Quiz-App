package com.example.firstquizz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Intrebare> listaIntrebari = new ArrayList<Intrebare>();
    
    ProgressBar progressBar;
    TextView textViewProgressBar;
    TextView textViewIntrebare;
    ImageView imageView;
    TextView textViewVarianta1;
    TextView textViewVarianta2;
    TextView textViewVarianta3;
    Button btnTrimite;

    private Integer pozitieIntrebareCurenta = 1;
    private Integer pozitieVariantaSelectata = 0;
    private Integer nrRaspunsuriCorecte = 0;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Integer cod = (Integer) getIntent().getSerializableExtra("cod");
        if( cod == 0 )
            initializareIntrebariIncepator();
        else
            initializareIntrebariExperimentat();
        initializareComponente();
        seteazaIntrebarea();

        textViewVarianta1.setOnClickListener(this);
        textViewVarianta2.setOnClickListener(this);
        textViewVarianta3.setOnClickListener(this);
        btnTrimite.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void seteazaAspectDefaultRaspunsuri() {
        ArrayList<TextView> raspunsuri = new ArrayList<TextView>();
        raspunsuri.add(0, textViewVarianta1);
        raspunsuri.add(1, textViewVarianta2);
        raspunsuri.add(2, textViewVarianta3);
        for (TextView raspuns : raspunsuri) {
            raspuns.setTextColor(Color.parseColor("#1e4537"));
            raspuns.setTypeface(Typeface.DEFAULT);
            raspuns.setBackground(ContextCompat.getDrawable(this, R.drawable.custom_tv_cat));
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    void seteazaIntrebarea() {

        seteazaAspectDefaultRaspunsuri();

        if(pozitieIntrebareCurenta == listaIntrebari.size())
        {
            btnTrimite.setText(R.string.finalizeaza);
        } else {
            btnTrimite.setText(R.string.trimite);
        }

        Intrebare intrebareCurenta = listaIntrebari.get(pozitieIntrebareCurenta - 1);

        progressBar.setProgress(pozitieIntrebareCurenta);
        textViewProgressBar.setText(pozitieIntrebareCurenta + " / " + progressBar.getMax());
        textViewIntrebare.setText(intrebareCurenta.text);
        imageView.setImageResource(intrebareCurenta.idImagine);
        textViewVarianta1.setText(intrebareCurenta.raspuns1);
        textViewVarianta2.setText(intrebareCurenta.raspuns2);
        textViewVarianta3.setText(intrebareCurenta.raspuns3);
    }

    void initializareComponente() {
        progressBar = findViewById(R.id.stanciu_andreea_third_pb);
        textViewProgressBar = findViewById(R.id.stanciu_andreea_third_tv_pb);
        textViewIntrebare = findViewById(R.id.stanciu_andreea_third_tv_intrebare);
        imageView = findViewById(R.id.stanciu_andreea_third_iv);
        textViewVarianta1 = findViewById(R.id.stanciu_andreea_third_tv_cat1);
        textViewVarianta2 = findViewById(R.id.stanciu_andreea_third_tv_cat2);
        textViewVarianta3 = findViewById(R.id.stanciu_andreea_third_tv_cat3);
        btnTrimite=findViewById(R.id.stanciu_andreea_third_btn);
    }

    void initializareIntrebariIncepator() {

        Intrebare intrebarea1 = new Intrebare(1,
                getString(R.string.text1),
                R.drawable.int1,
                getString(R.string.raspuns11),
                getString(R.string.raspuns12),
                getString(R.string.raspuns13),
                1
        );
        listaIntrebari.add(intrebarea1);

        Intrebare intrebarea2 = new Intrebare(2,
                getString(R.string.text2),
                R.drawable.int2,
                getString(R.string.raspuns21),
                getString(R.string.raspuns22),
                getString(R.string.raspuns23),
                2
        );
        listaIntrebari.add(intrebarea2);

        Intrebare intrebarea3 = new Intrebare(3,
                getString(R.string.text3),
                R.drawable.int3,
                getString(R.string.raspuns31),
                getString(R.string.raspuns32),
                getString(R.string.raspuns33),
                1
        );
        listaIntrebari.add(intrebarea3);

        Intrebare intrebarea4 = new Intrebare(4,
                getString(R.string.text4),
                R.drawable.int4,
                getString(R.string.raspuns41),
                getString(R.string.raspuns42),
                getString(R.string.raspuns43),
                3
        );
        listaIntrebari.add(intrebarea4);
        Intrebare intrebarea5 = new Intrebare(5,
                getString(R.string.text5),
                R.drawable.int4,
                getString(R.string.raspuns51),
                getString(R.string.raspuns52),
                getString(R.string.raspuns53),
                3
        );
        listaIntrebari.add(intrebarea5);
    }

    void initializareIntrebariExperimentat()
    {
        Intrebare intrebarea1 = new Intrebare(1,
                getString(R.string.enunta0),
                R.drawable.inta1,
                getString(R.string.raspunsa01),
                getString(R.string.raspunsa02),
                getString(R.string.raspunsa03),
                1

        );
        listaIntrebari.add(intrebarea1);
        Intrebare intrebarea2 = new Intrebare(2,
                getString(R.string.enunta1),
                R.drawable.inta2,
                getString(R.string.raspunsa11),
                getString(R.string.raspunsa12),
                getString(R.string.raspunsa13),
                2
                );
        listaIntrebari.add(intrebarea2);
        Intrebare intrebarea3 = new Intrebare(3,
                getString(R.string.enunta2),
                R.drawable.inta3,
                getString(R.string.raspunsa21),
                getString(R.string.raspunsa22),
                getString(R.string.raspunsa23),
                3

                );
        listaIntrebari.add(intrebarea3);
        Intrebare intrebarea4 = new Intrebare(4,
                getString(R.string.enunta4),
                R.drawable.inta4,
                getString(R.string.raspunsa41),
                getString(R.string.raspunsa42),
                getString(R.string.raspunsa43),
                2

                );
        listaIntrebari.add(intrebarea4);
        Intrebare intrebarea5 = new Intrebare(5,
                getString(R.string.enunta5),
                R.drawable.inta5,
                getString(R.string.raspunsa51),
                getString(R.string.raspunsa52),
                getString(R.string.raspunsa53),
                3
                );
        listaIntrebari.add(intrebarea5);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stanciu_andreea_third_tv_cat1:
                seteazaAspectRaspunsSelectat(textViewVarianta1,1);
                break;
            case R.id.stanciu_andreea_third_tv_cat2:
                seteazaAspectRaspunsSelectat(textViewVarianta2,2);
                break;
            case R.id.stanciu_andreea_third_tv_cat3:
                seteazaAspectRaspunsSelectat(textViewVarianta3,3);
                break;
            case R.id.stanciu_andreea_third_btn:
                if(pozitieVariantaSelectata == 0){
                    pozitieIntrebareCurenta++;

                    if(pozitieIntrebareCurenta <= listaIntrebari.size())
                    {
                        seteazaIntrebarea();
                        textViewVarianta1.setEnabled(true);
                        textViewVarianta2.setEnabled(true);
                        textViewVarianta3.setEnabled(true);
                    } else {
                        Intent intent = new Intent(this,FourthActivity.class);
                        intent.putExtra("raspunsuri_corecte",nrRaspunsuriCorecte);
                        startActivity(intent);
                        //Toast.makeText(this,"Ai terminat cu succes jocul", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Intrebare intrebareCurenta = listaIntrebari.get(pozitieIntrebareCurenta-1);
                    if(!intrebareCurenta.idRaspunsCorect.equals(pozitieVariantaSelectata)){
                        afiseazaCorectitudineRaspuns(pozitieVariantaSelectata,R.drawable.custom_wrong_tv_cat);
                    } else {
                        nrRaspunsuriCorecte++;
                    }
                    afiseazaCorectitudineRaspuns(intrebareCurenta.idRaspunsCorect,R.drawable.custom_correct_tv_cat);
                    textViewVarianta1.setEnabled(false);
                    textViewVarianta2.setEnabled(false);
                    textViewVarianta3.setEnabled(false);

                    if(pozitieIntrebareCurenta == listaIntrebari.size()) {
                        btnTrimite.setText(R.string.finalizeaza);
                    } else {
                        btnTrimite.setText(R.string.urmatoarea_intrebare);

                    }

                    pozitieVariantaSelectata = 0;
                }
                break;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void afiseazaCorectitudineRaspuns(int raspuns, int drawabaleView)
    {
        switch (raspuns){
            case 1:
                textViewVarianta1.setBackground(ContextCompat.getDrawable(this,drawabaleView));
                break;
            case 2:
                textViewVarianta2.setBackground(ContextCompat.getDrawable(this,drawabaleView));
                break;
            case 3:
                textViewVarianta3.setBackground(ContextCompat.getDrawable(this,drawabaleView));
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    void seteazaAspectRaspunsSelectat(TextView textView, Integer raspunsSelectat) {

        seteazaAspectDefaultRaspunsuri();

        pozitieVariantaSelectata = raspunsSelectat;
        textView.setTextColor(Color.parseColor("#00342d"));
        textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.custom_selected_tv_cat));

    }
}