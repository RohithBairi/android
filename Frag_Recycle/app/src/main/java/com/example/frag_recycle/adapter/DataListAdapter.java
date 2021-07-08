package com.example.frag_recycle.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frag_recycle.AdapterCallback;
import com.example.frag_recycle.ItemClickListener;
import com.example.frag_recycle.R;
import com.example.frag_recycle.model.DataModel;


public class DataListAdapter extends ListAdapter<DataModel,DataListAdapter.ViewHolder> implements View.OnClickListener {

    Context mContxt;
    private AdapterCallback mAdapterCallback;
    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
//Constructor
public DataListAdapter(Context mContext) {
        super(DIFF_CALLBACK);
        mContxt = mContext;
         }
         public void registerCallback(AdapterCallback mActivityAdapterCallback){
             mAdapterCallback = mActivityAdapterCallback;
         }

//to check weather to items have same id or not
private static final DiffUtil.ItemCallback<DataModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<DataModel>() {
@Override
public boolean areItemsTheSame(DataModel oldItem, DataModel newItem) {
        return oldItem.getId() == newItem.getId();
        }
//to check weather to items have same contects or not
@SuppressLint("DiffUtilEquals")
@Override
public boolean areContentsTheSame(DataModel oldItem, DataModel newItem) {
        return oldItem.getName().equals(newItem.getName()) &&
        oldItem.getRollNumber()==newItem.getRollNumber();
        }
        };

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.data_list, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(getItem(position).getName());
        holder.rollNo.setText(String.valueOf(getItem(position).getRollNumber()));
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(mContxt,getItem(position).getData(),Toast.LENGTH_LONG).show();
//                if(mAdapterCallback!=null)
//                mAdapterCallback.onMethodCallback(getItem(position));
//            }
//        });
    holder.itemView.setOnClickListener(this::onClick);

        }

    @Override
    public void onClick(View view) {
        Log.d("Rohith ","Rohith 123123");
        TextView nameSong =  view.findViewById(R.id.tv_item_name);
        TextView nameAlbum =  view.findViewById(R.id.tv_item_rollNo);
        DataModel mDataModel = new DataModel(nameSong.getText().toString(),nameAlbum.getText().toString());
            if (clickListener != null) clickListener.onClick(view,mDataModel);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name, rollNo;
    ViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_item_name);
        rollNo = itemView.findViewById(R.id.tv_item_rollNo);


    }

    }


}