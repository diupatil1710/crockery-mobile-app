package com.Divya.crockerys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.Divya.crockerys.adapter.Model;
import com.Divya.crockerys.adapter.myadapter;

import java.util.ArrayList;
public class product_display extends AppCompatActivity {
    RecyclerView rcv;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);

        setTitle("Recycler and Card View Demo");

        rcv = (RecyclerView) findViewById(R.id.recview);
        //  rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new myadapter(dataqueue(),getApplicationContext());
        rcv.setAdapter(adapter);

        //LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //rcv.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);
    }
    public ArrayList<Model> dataqueue()
    {
        ArrayList<Model> holder=new ArrayList<>();

        Model ob1=new Model();
        ob1.setHeader("eCraftIndia decor");
        ob1.setDesc("Rs99");
        ob1.setImgname(R.drawable.e2);
        holder.add(ob1);

        Model ob2=new Model();
        ob2.setHeader("Manthan Polyresium set");
        ob2.setDesc("Rs149");
        ob2.setImgname(R.drawable.e12);
        holder.add(ob2);

        Model ob3=new Model();
        ob3.setHeader("LiteMart LED");
        ob3.setDesc("Rs89");
        ob3.setImgname(R.drawable.e11);
        holder.add(ob3);

        Model ob4=new Model();
        ob4.setHeader("Utsav Radha Krishna");
        ob4.setDesc("Rs139");
        ob4.setImgname(R.drawable.e8);
        holder.add(ob4);

        Model ob5=new Model();
        ob5.setHeader("Chhariya peacock");
        ob5.setDesc("Rs89");
        ob5.setImgname(R.drawable.e18);
        holder.add(ob5);

        Model ob6=new Model();
        ob6.setHeader("Aavi decorative showpiece");
        ob6.setDesc("Rs99");
        ob6.setImgname(R.drawable.e15);
        holder.add(ob6);

        Model ob7=new Model();
        ob7.setHeader("Ferns ganesh");
        ob7.setDesc("Rs199");
        ob7.setImgname(R.drawable.e10);
        holder.add(ob7);

        Model ob8=new Model();
        ob8.setHeader("Crozier Lamp");
        ob8.setDesc("Rs147");
        ob8.setImgname(R.drawable.e3);
        holder.add(ob8);

        Model ob9=new Model();
        ob9.setHeader("Mindfied 20");
        ob9.setDesc("Rs129");
        ob9.setImgname(R.drawable.e4);
        holder.add(ob9);

        Model ob10=new Model();
        ob10.setHeader("Maadi 360");
        ob10.setDesc("Rs90");
        ob10.setImgname(R.drawable.e19);
        holder.add(ob10);

        Model ob11=new Model();
        ob11.setHeader("Kawai wallshow");
        ob11.setDesc("Rs299");
        ob11.setImgname(R.drawable.e5);
        holder.add(ob11);

        Model ob12=new Model();
        ob11.setHeader("Arihant decor showpiece");
        ob11.setDesc("Rs89");
        ob11.setImgname(R.drawable.e6);
        holder.add(ob12);


        return holder;
    }
}