package com.example.tablayoutcrud.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayoutcrud.MainActivity;
import com.example.tablayoutcrud.R;
import com.example.tablayoutcrud.adapter.SearchAdapter;
import com.example.tablayoutcrud.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearch extends Fragment {
    private SearchAdapter searchAdapter;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private List<Cat> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = view.findViewById(R.id.searchView);
        recyclerView = view.findViewById(R.id.rview);
        searchAdapter = new SearchAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(manager);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }

            private void filter(String newText) {
                List<Cat> filteredList = new ArrayList<>();
                for(Cat cat:list){
                    if(cat.getName().toLowerCase().contains(newText.toLowerCase())){
                        filteredList.add(cat);
                    }
                }
                if(filteredList.isEmpty()){
                    Toast.makeText(getContext(), "Khong tim thay", Toast.LENGTH_SHORT).show();
                } else {
                    searchAdapter.setList(filteredList);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        list = ((MainActivity)getActivity()).list;
    }
}
