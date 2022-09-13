package cl.isisur.proyectoapp;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,detalles;
        ImageView imagenperfil;

        public ViewHolder( View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.texnombre);
            detalles=(TextView) itemView.findViewById(R.id.texinfo);
            imagenperfil=(ImageView) itemView.findViewById(R.id.imageperfil);
        }
    }

    public List<PerfilModelo> listaperfil;

    public RecyclerViewAdaptador(List<PerfilModelo> listaperfil) {
        this.listaperfil = listaperfil;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.nombre.setText(listaperfil.get(position).getNombre());
        holder.detalles.setText(listaperfil.get(position).getDetalles());
        holder.imagenperfil.setImageResource(listaperfil.get(position).getImgperfil());
    }

    @Override
    public int getItemCount() {
        return listaperfil.size();
    }
}
