package br.edu.ifsul.casa_automatizada.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.edu.ifsul.casa_automatizada.R;
import br.edu.ifsul.casa_automatizada.model.Area;
import br.edu.ifsul.casa_automatizada.model.Banheiro;
import br.edu.ifsul.casa_automatizada.model.Circulacao;
import br.edu.ifsul.casa_automatizada.model.Cozinha;
import br.edu.ifsul.casa_automatizada.model.Dormitorio;
import br.edu.ifsul.casa_automatizada.model.Estar;

public class MainActivity extends AppCompatActivity {

    Switch swLampadaArea, swLampadaBanheiro, swLampadaCirculacao, swLampadaCozinha, swLampadaDormitorio1, swLampadaDormitorio2,
            swLampadaDormitorio3, swLampadaEstar, swHVACDormitorio1, swHVACDormitorio2, swHVACDormitorio3;
    String TAG = "MainActivity";

    // leitura dos dados contidos no nó casa
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapeamento botões Switch
        swLampadaArea = findViewById(R.id.swLampadaArea);
        swLampadaBanheiro = findViewById(R.id.swLampadaBanheiro);
        swLampadaCirculacao = findViewById(R.id.swLampadaCirculacao);
        swLampadaCozinha = findViewById(R.id.swLampadaCozinha);
        swLampadaDormitorio1 = findViewById(R.id.swLampadaDormitorio1);
        swLampadaDormitorio2 = findViewById(R.id.swLampadaDormitorio2);
        swLampadaDormitorio3 = findViewById(R.id.swLampadaDormitorio3);
        swLampadaEstar = findViewById(R.id.swLampadaEstar);
        swHVACDormitorio1 = findViewById(R.id.swHVACDormitorio1);
        swHVACDormitorio2 = findViewById(R.id.swHVACDormitorio2);
        swHVACDormitorio3 = findViewById(R.id.swHVACDormitorio3);

        // leitura dos dados contidos no nó casa
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //area
        final DatabaseReference myRefArea = database.getReference("/").child("area");
        //banheiro
        final DatabaseReference myRefBanheiro = database.getReference("/").child("banheiro");
        //circulacao
        final DatabaseReference myRefCirculacao = database.getReference("/").child("circulacao");
        //cozinha
        final DatabaseReference myRefCozinha = database.getReference("/").child("cozinha");
        //dormitorio1
        final DatabaseReference myRefDormitorio1 = database.getReference("/").child("dormitorio1");
        //dormitorio2
        final DatabaseReference myRefDormitorio2 = database.getReference("/").child("dormitorio2");
        //dormitorio3
        final DatabaseReference myRefDormitorio3 = database.getReference("/").child("dormitorio3");
        //estar
        final DatabaseReference myRefEstar = database.getReference("/").child("estar");

        myRefArea.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Area area = dataSnapshot.getValue(Area.class);
                if(area.getLampada()) {
                    swLampadaArea.setChecked(true);
                } else {
                    swLampadaArea.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myRefBanheiro.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Banheiro banheiro = dataSnapshot.getValue(Banheiro.class);
                if(banheiro.getLampada()) {
                    swLampadaBanheiro.setChecked(true);
                } else {
                    swLampadaBanheiro.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRefCirculacao.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Circulacao circulacao = dataSnapshot.getValue(Circulacao.class);
                if(circulacao.getLampada()) {
                    swLampadaCirculacao.setChecked(true);
                } else {
                    swLampadaCirculacao.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRefCozinha.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Cozinha cozinha = dataSnapshot.getValue(Cozinha.class);
                if(cozinha.getLampada()) {
                    swLampadaCozinha.setChecked(true);
                } else {
                    swLampadaCozinha.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRefDormitorio1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Dormitorio dormitorio1 = dataSnapshot.getValue(Dormitorio.class);
                if(dormitorio1.getLampada()) {
                    swLampadaDormitorio1.setChecked(true);
                } else {
                    swLampadaDormitorio1.setChecked(false);
                }
                if(dormitorio1.getHvac()) {
                    swHVACDormitorio1.setChecked(true);
                } else {
                    swHVACDormitorio1.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRefDormitorio2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Dormitorio dormitorio2 = dataSnapshot.getValue(Dormitorio.class);
                if(dormitorio2.getLampada()) {
                    swLampadaDormitorio2.setChecked(true);
                } else {
                    swLampadaDormitorio2.setChecked(false);
                }
                if(dormitorio2.getHvac()) {
                    swHVACDormitorio2.setChecked(true);
                } else {
                    swHVACDormitorio2.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRefDormitorio3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Dormitorio dormitorio3 = dataSnapshot.getValue(Dormitorio.class);
                if(dormitorio3.getLampada()) {
                    swLampadaDormitorio3.setChecked(true);
                } else {
                    swLampadaDormitorio3.setChecked(false);
                }
                if(dormitorio3.getHvac()) {
                    swHVACDormitorio3.setChecked(true);
                } else {
                    swHVACDormitorio3.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRefEstar.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Estar estar = dataSnapshot.getValue(Estar.class);
                if(estar.getLampada()) {
                    swLampadaEstar.setChecked(true);
                } else {
                    swLampadaEstar.setChecked(false);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        swLampadaArea.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("area/lampada");
                }else{
                    desligar("area/lampada");
                }
            }
        });

        swLampadaEstar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("estar/lampada");
                }else{
                    desligar("estar/lampada");
                }
            }
        });

        swLampadaDormitorio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("dormitorio1/lampada");
                }else{
                    desligar("dormitorio1/lampada");
                }
            }
        });
        swLampadaDormitorio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("dormitorio2/lampada");
                }else{
                    desligar("dormitorio2/lampada");
                }
            }
        });
        swLampadaDormitorio3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("dormitorio3/lampada");
                }else{
                    desligar("dormitorio3/lampada");
                }
            }
        });

        swHVACDormitorio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("dormitorio1/hvac");
                }else{
                    desligar("dormitorio1/hvac");
                }
            }
        });
        swHVACDormitorio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("dormitorio2/hvac");
                }else{
                    desligar("dormitorio2/hvac");
                }
            }
        });
        swHVACDormitorio3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("dormitorio3/hvac");
                }else{
                    desligar("dormitorio3/hvac");
                }
            }
        });

        swLampadaBanheiro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("banheiro/lampada");
                }else{
                    desligar("banheiro/lampada");
                }
            }
        });
        swLampadaCirculacao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("circulacao/lampada");
                }else{
                    desligar("circulacao/lampada");
                }
            }
        });
        swLampadaCozinha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ligar("cozinha/lampada");
                }else{
                    desligar("cozinha/lampada");
                }
            }
        });




    }
    public void ligar(String comodo){
        myRef.child(comodo).setValue(true);
        myRef.child("ledAzul").setValue(true);
        myRef.child("ledVermelho").setValue(false);
        Toast.makeText(MainActivity.this ,nomeAmbiente(comodo).concat(" ligado"), Toast.LENGTH_SHORT).show();
    }
    public void desligar(String comodo){
        myRef.child(comodo).setValue(false);
        myRef.child("ledVermelho").setValue(true);
        myRef.child("ledAzul").setValue(false);
        Toast.makeText(MainActivity.this ,nomeAmbiente(comodo).concat(" desligado"), Toast.LENGTH_SHORT).show();
    }
    public String nomeAmbiente(String nome){
        switch (nome){
            case "estar/lampada":
                return "Lampada Estar";
            case "cozinha/lampada":
                return "Lampada Cozinha";
            case "dormitorio1/lampada":
                return "Lampada Dormitorio 1";
            case "dormitorio1/hvac":
                return "Ar-condicionado Dormitorio 1";
            case "dormitorio2/lampada":
                return "Lampada Dormitorio 2";
            case "dormitorio2/hvac":
                return "Ar-condicionado Dormitorio 2";
            case "dormitorio3/lampada":
                return "Lampada Dormitorio 3";
            case "dormitorio3/hvac":
                return "Ar-condicionado Dormitorio 3";
            case "circulacaoLampada":
                return "Lampada Circulação";
            case "area/lampada":
                return "Lampada Area";
            case "banheiro/lampada":
                return "Lampada Banheiro";
            case "area/Lampada":
                return "Lampada Area";

        }
        return " ";
    }
}
