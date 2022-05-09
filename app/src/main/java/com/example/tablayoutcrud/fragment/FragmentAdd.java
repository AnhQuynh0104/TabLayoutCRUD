package com.example.tablayoutcrud.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayoutcrud.MainActivity;
import com.example.tablayoutcrud.R;
import com.example.tablayoutcrud.adapter.CatAdapter;
import com.example.tablayoutcrud.adapter.SpinnerAdapter;
import com.example.tablayoutcrud.model.Cat;

public class FragmentAdd extends Fragment implements CatAdapter.CatItemListener {
    private CatAdapter catAdapter;
    private Spinner spinner;
    private EditText editName, editPrice, editDesc;
    private Button btnThem, btnSua;
    private RecyclerView recyclerView;
    private int[] imgs = {R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,
            R.drawable.cat4, R.drawable.cat5, R.drawable.cat6};
    private int positionSua;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        initView(view);
        catAdapter = new CatAdapter((MainActivity) getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(catAdapter);
        catAdapter.setCatItemListener(this);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = spinner.getSelectedItem().toString();
                int img;
                try{
                    img = Integer.parseInt(i);
                    double price = Double.parseDouble(editPrice.getText().toString());
                    Cat cat = new Cat(img, editName.getText().toString(), price, editDesc.getText().toString());
                    catAdapter.add(cat);
                } catch (NumberFormatException e){

                }
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i = spinner.getSelectedItem().toString();
                int img;
                try{
                    img = Integer.parseInt(i);
                    double price = Double.parseDouble(editPrice.getText().toString());
                    Cat cat = new Cat(img, editName.getText().toString(), price, editDesc.getText().toString());
                    catAdapter.update(cat, positionSua);
                    btnSua.setEnabled(false);
                    btnThem.setEnabled(true);
                } catch (NumberFormatException e){

                }
            }
        });
    }

    private void initView(View v) {
        spinner = v.findViewById(R.id.spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(imgs);
        spinner.setAdapter(adapter);
        editName= v.findViewById(R.id.editName);
        editPrice= v.findViewById(R.id.editPrice);
        editDesc= v.findViewById(R.id.editDesc);
        btnSua = v.findViewById(R.id.btnSua);
        btnThem = v.findViewById(R.id.btnThem);
        recyclerView = v.findViewById(R.id.rview);
        btnSua.setEnabled(false);
    }

    @Override
    public void onItemClick(View v, int position) {
        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        positionSua = position;
        Cat cat = catAdapter.getItem(position);
        int img = cat.getImg();
        int p = 0;
        for(int i = 0; i < imgs.length; i++){
            if(img == imgs[i]){
                p = i;
                break;
            }
        }
        spinner.setSelection(p);
        editName.setText(cat.getName());
        editPrice.setText(cat.getPrice()+"");
        editDesc.setText(cat.getDesc());
    }
}
