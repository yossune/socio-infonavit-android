package com.neosmart.socio_infonavit_android.Modelos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.neosmart.socio_infonavit_android.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArPez
 */
public class AdapterBenevits extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


ArrayList<Benevits> data ;
Context context;

private static final int vistaunLocket =1;
    private static final int vistalocket =0;
    private static  int viewVisible ;

    public AdapterBenevits(ArrayList<Benevits> data, Context context) {
        this.data = data;
        this.context = context;
    }


    public class vHolderUnlocket  extends RecyclerView.ViewHolder{


        ImageView Imagenlog ;
        TextView txtDescription;
        public vHolderUnlocket(@NonNull @NotNull View itemView) {
            super(itemView);

            Imagenlog = (ImageView) itemView.findViewById(R.id.Imagenlog);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);


        }


    }
    public class vHolder extends RecyclerView.ViewHolder{

        //TextView textoProducto;
        ImageView Imagenlog2 ;
        Button btnLQuiero;
        public vHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            Imagenlog2 = (ImageView) itemView.findViewById(R.id.imageView);
            btnLQuiero = (Button) itemView.findViewById(R.id.button_LQuiero);


        }


    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        if (viewType==0){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view=  layoutInflater.inflate(R.layout.item_add  ,parent,false);
            return new vHolder(view);

        }else
            {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view=  layoutInflater.inflate(R.layout.item_benevist,parent,false);

                return new vHolderUnlocket(view);
            }

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        int viewTipe =getItemViewType(position);

if (data.get(position).isBloqueado()){
    vHolder unlocket = (vHolder) holder;
    Picasso.with(context)
            .load(data.get(position).vector_full_path
            )
            .fit()
            .centerInside().into(unlocket.Imagenlog2);
}else{
    vHolderUnlocket vHolde = (vHolderUnlocket) holder ;

    vHolde.txtDescription.setText(data.get(position).getDescription());

    Picasso.with(context)
            .load(data.get(position).getAlly().mini_logo_full_path)
            .fit()
            .centerInside().into(vHolde.Imagenlog);
}



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
     if (data.get(position).isBloqueado()){
            return  vistalocket;
        }else {
            return vistaunLocket;
        }

    }




}
