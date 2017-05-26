package br.com.uniara.buscacep.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.activeandroid.Model;

import java.util.List;

import br.com.uniara.buscacep.R;
import br.com.uniara.buscacep.database.dao.LocalDAO;
import br.com.uniara.buscacep.database.model.Local;

/**
 * Created by andreguedes on 24/05/17.
 */

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.LocalViewHolder> {

    private Context context;
    private List<Model> locais;

    public LocalAdapter(Context context, List<Model> locais) {
        this.context = context;
        this.locais = locais;
    }

    @Override
    public LocalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_locais, parent, false);
        return new LocalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LocalViewHolder holder, final int position) {
        final Local local = (Local) locais.get(position);

        if (local != null) {
            holder.txtCidade.setText(local.getCidade());
            holder.txtCep.setText(local.getCep());

            holder.btnExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LocalDAO.getInstance().remove(local);
                    locais.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return locais != null ? locais.size() : 0;
    }

    class LocalViewHolder extends RecyclerView.ViewHolder {

        TextView txtCidade, txtCep;
        ImageButton btnExcluir;

        public LocalViewHolder(View itemView) {
            super(itemView);

            txtCidade = (TextView) itemView.findViewById(R.id.txtCidade);
            txtCep = (TextView) itemView.findViewById(R.id.txtCep);
            btnExcluir = (ImageButton) itemView.findViewById(R.id.btnExcluir);
        }

    }

}