package com.s6.lasalle.recursos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.s6.lasalle.recursos.elementos.Bitmap_r;
import com.s6.lasalle.recursos.elementos.LayerList;
import com.s6.lasalle.recursos.elementos.NinePatch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView List;
    private ArrayList<Recurso> listaRecursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recursos();
    }

    public void recursos() {
        List = (RecyclerView) findViewById(R.id.recycler_view);
        List.setHasFixedSize(true);

        listaRecursos = new ArrayList<>();
        listaRecursos.add(new Recurso("Bitmap", "Visualización de una imagen PNG"));
        listaRecursos.add(new Recurso("Nine-patch files", "Este recurso hace..."));
        listaRecursos.add(new Recurso("Layer list", "Este recurso hace..."));
        listaRecursos.add(new Recurso("State list", "Este recurso hace..."));
        listaRecursos.add(new Recurso("Level list", "Este recurso hace..."));
        listaRecursos.add(new Recurso("Transition drawable", "Este recurso hace..."));
        listaRecursos.add(new Recurso("Inset drawable", "Este recurso hace..."));
        listaRecursos.add(new Recurso("Clip drawable", "Este recurso hace..."));
        listaRecursos.add(new Recurso("Scale drawable", "Este recurso hace..."));
        listaRecursos.add(new Recurso("Shape drawable", "Este recurso hace..."));

        Adapter adapter = new Adapter(listaRecursos);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Recurso recurso = listaRecursos.get(position);

                Toast toast1 = Toast.makeText(getApplicationContext(), "Has seleccionado "+ recurso.getName(), Toast.LENGTH_SHORT);
                toast1.show();
                if(position==0){
                    Intent intent = new Intent(getApplicationContext(), Bitmap_r.class);
                    startActivity(intent);
                }else if(position==1){
                    Intent intent = new Intent(getApplicationContext(), NinePatch.class);
                    startActivity(intent);
                }else if(position==2){
                    Intent intent = new Intent(getApplicationContext(), LayerList.class);
                    startActivity(intent);
                }
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        List.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(List.getContext(), layoutManager.getOrientation());
        List.addItemDecoration(dividerItemDecoration);

        List.setItemAnimator(new DefaultItemAnimator());
        List.setAdapter(adapter);
    }

    public static class Adapter extends RecyclerView.Adapter<Adapter.RecursoViewHolder> {

        private OnItemClickListener onItemClickListener;
        private ArrayList<Recurso> listaRecursos;

        public Adapter(ArrayList<Recurso> data) {this.listaRecursos = data;}

        public Adapter.RecursoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            RecursoViewHolder viewHolder = new RecursoViewHolder(view);

            return viewHolder;
        }

        public void onBindViewHolder(Adapter.RecursoViewHolder holder, int position) {
            final Recurso recurso = listaRecursos.get(position);
            holder.bindRecurso(recurso);
        }

        @Override
        public int getItemCount() {
            return listaRecursos.size();
        }

        public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        public class RecursoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView Title;
            private TextView Description;

            public RecursoViewHolder(View view) {
                super(view);

                Title = (TextView) view.findViewById(R.id.title);
                Description = (TextView) view.findViewById(R.id.details);

                view.setOnClickListener(this);
            }

            public void bindRecurso(Recurso r) {
                Title.setText(r.getName());
                Description.setText(r.getDetails());
            }

            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) onItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}
