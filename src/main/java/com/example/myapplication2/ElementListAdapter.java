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
        try {
            mOnItemClickListener = (OnItemClickListener)context.getApplicationContext();
            //należy zapewnić obsługę wyjątku ClassCastExeptation
        }catch(ClassCastException e){

        }
    }


    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //utworzenie layoutu wiersza na podstawie XML
        View wiersz =mLayoutInFlater.inflate(R.layout.wiersz,null);

        return new ElementViewHolder(wiersz);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
       // holder.
        //holder.label1.setTag(mElementList.get(position));
        Element value = mElementList.get(position);
        holder.label1.setTag(position);
        holder.label1.setText(value.getManufacturer());
        holder.label2.setTag(position);
        holder.label2.setText(value.getModel());
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

    public Element getElementAt(int position){
        return mElementList.get(position);
    }


    public class ElementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView label1;
            TextView label2;
            View glowny;
        public ElementViewHolder(@NonNull View itemView) {
            super(itemView);
            this.glowny = itemView;
            label1 = glowny.findViewById(R.id.textView1);
            label2 = glowny.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

//    public void remove(RecyclerView.ViewHolder viewHolder){
//        mElementList.remove(viewHolder.getAdapterPosition());
//    }



    //referencja do Listenera(informuje o kliknięciu wiersza)
    private OnItemClickListener mOnItemClickListener;

    //informuje jaki element wybrano
    public interface OnItemClickListener {
        void OnItemClickListener(Element element);
    }


}













