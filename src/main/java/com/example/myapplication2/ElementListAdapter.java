package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ElementListAdapter extends RecyclerView.Adapter<ElementListAdapter.ElementViewHolder> {

    private LayoutInflater mLayoutInFlater;
    private List<Element> mElementList;
    //referencja do Listenera(informuje o kliknięciu wiersza)
//    private OnItemClickListener mOnItemClickListener;
    private OnItemClickListener mOnClickListener;
    public ElementListAdapter(Context context){
        mLayoutInFlater = LayoutInflater.from(context);
        this.mElementList = null;
        try {
            //mOnClickListener = (OnItemClickListener)context.getApplicationContext();
            mOnClickListener = (MainActivity)context;

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
        //holder.onClick(mElementList.get(position));
        //holder.label1.setTag(mElementList.get(position));
        Element value = mElementList.get(position);
        holder.label1.setTag(position);
        holder.label1.setText(value.getManufacturer());
        holder.label2.setTag(position);
        holder.label2.setText(value.getModel());
    }
//    @Override
//    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
//        holder.
//    }
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
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    if(mOnClickListener !=null)
//                    mOnClickListener.onItemClickListener(mElementList.get(position));
//                }
//            });
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
                    if(mOnClickListener !=null)
                    mOnClickListener.onItemClickListener(mElementList.get(position));
        }
    }
        public interface OnItemClickListener {
            void onItemClickListener(Element element);
        }

        public void setOnItemClickListener(OnItemClickListener mOnClickListener){
            this.mOnClickListener = mOnClickListener;
        }



//        @Override
//        public void onClick(View v) {
//            //powiadomienie (mOnItemClickListener) który został wybrany
//            int position = getAdapterPosition();
//            if(mOnItemClickListener !=null)
//            mOnItemClickListener.OnItemClickListener(mElementList.get(position));
//            //mOnItemClickListener.notify();
//        }
//
//
//
//
//
//
//    //informuje jaki element wybrano
//    public interface OnItemClickListener {
//        void OnItemClickListener(Element element);
//    }


}













