package com.Divya.crockerys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Divya.crockerys.adapter.CategoryAdapter;
import com.Divya.crockerys.adapter.RecentlyViewedAdapter;
import com.Divya.crockerys.model.Category;
import com.Divya.crockerys.model.RecentlyViewed;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static com.Divya.crockerys.R.drawable.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView, recentlyViewedRecycler;
//    DiscountedProductAdapter discountedProductAdapter;
//    List<DiscountedProducts> discountedProductsList;
    FirebaseAuth auth;
    FirebaseUser user;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    ImageView loginbtn;
    ImageView logout,e1,e2,e3;

    TextView allCategory,textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        loginbtn = findViewById(R.id.loginbtn);
        logout = findViewById(R.id.logout);
        textView2 = findViewById(R.id.textView2);
//        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        auth=FirebaseAuth.getInstance();
        user= auth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        else{
            textView2.setText(user.getEmail());
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });





//        products.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, display_view2.class);
//                startActivity(i);
//            }
//        });

        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, product_display.class);
                startActivity(i);
            }
        });

        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, product_view3.class);
                startActivity(i);
            }
        });
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, display_view2.class);
                startActivity(i);
            }
        });



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });

        // adding data to model
//        discountedProductsList = new ArrayList<>();
//        discountedProductsList.add(new DiscountedProducts(1, R.drawable.c3));
//        discountedProductsList.add(new DiscountedProducts(2, R.drawable.c7));
//        discountedProductsList.add(new DiscountedProducts(3, R.drawable.cc1));
//        discountedProductsList.add(new DiscountedProducts(4, R.drawable.c5));
//        discountedProductsList.add(new DiscountedProducts(5, R.drawable.e10));
//        discountedProductsList.add(new DiscountedProducts(6, R.drawable.c2));

        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.c3));
        categoryList.add(new Category(2, R.drawable.c6));
        categoryList.add(new Category(3, R.drawable.e15));
        categoryList.add(new Category(4, R.drawable.e14));
        categoryList.add(new Category(5, R.drawable.e13));
        categoryList.add(new Category(6, R.drawable.e1));
        categoryList.add(new Category(7, R.drawable.e4));
        categoryList.add(new Category(8, R.drawable.c7));

        // adding data to model
       recentlyViewedList = new ArrayList<>();
       recentlyViewedList.add(new RecentlyViewed("Anixa cup","","Rs180","","", R.drawable.c3, R.drawable.c3));
       recentlyViewedList.add(new RecentlyViewed("Manthan set showpiece", "","Rs199","","", R.drawable.e13, R.drawable.e13));
       recentlyViewedList.add(new RecentlyViewed("Cello sapphira","", "Rs399","","", R.drawable.k4, R.drawable.k4));
       recentlyViewedList.add(new RecentlyViewed("Nellam plate","",  "Rs330","","", R.drawable.k8, R.drawable.k8));

//        setDiscountedRecycler(discountedProductsList);
       setCategoryRecycler(categoryList);
       setRecentlyViewedRecycler(recentlyViewedList);

    }

//    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        discountRecyclerView.setLayoutManager(layoutManager);
//        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
//        discountRecyclerView.setAdapter(discountedProductAdapter);
//    }


    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
    //Now again we need to create a adapter and model class for recently viewed items.
    // lets do it fast.
}
