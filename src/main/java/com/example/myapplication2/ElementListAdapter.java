package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ElementListAdapter extends RecyclerView.Adapter<ElementListAdapter.ElementViewHolder> {

    private LayoutInflater mLayoutInFlater;
    private List<Element> mElementList;

    public ElementListAdapter(Context context){
        mLayoutInFlater = LayoutInflater.from(context);
        this.mElementList = null;
    }
    Element pierwszy = new Element("wartosc");

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //utworzenie layoutu wiersza na podstawie XML
        View wiersz =mLayoutInFlater.inflate(R.layout.wiersz,null);

        return new ElementViewHolder(wiersz);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        //holder.label1.setTag(mElementList.get(position));
        Element value = mElementList.get(position);
        holder.label1.setTag(position);
        holder.label1.setText(value.getKolumna2());
    }

    @Override
    public int getItemCount() {
        if(mElementList !=null)
            return mElementList.size();
        return 0;
    }

    public void setElementList(List<Element>elementList){
        this.mElementList = elementList;
        notifyDataSetChanged();
    }

    public class ElementViewHolder extends RecyclerView.ViewHolder  {
            TextView label1;
            TextView label2;
            View glowny;
        public ElementViewHolder(@NonNull View itemView) {
            super(itemView);
            this.glowny = itemView;
            label1 = glowny.findViewById(R.id.textView1);
            label2 = glowny.findViewById(R.id.textView2);
        }
    }
}













