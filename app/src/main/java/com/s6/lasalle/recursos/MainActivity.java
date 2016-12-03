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
import com.s6.lasalle.recursos.elementos.Clip;
import com.s6.lasalle.recursos.elementos.InsetDrawable;
import com.s6.lasalle.recursos.elementos.LayerList;
import com.s6.lasalle.recursos.elementos.LevelList;
import com.s6.lasalle.recursos.elementos.NinePatch;
import com.s6.lasalle.recursos.elementos.Scale;
import com.s6.lasalle.recursos.elementos.Shape;
import com.s6.lasalle.recursos.elementos.StateList;
import com.s6.lasalle.recursos.elementos.Transition;

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
        listaRecursos.add(new Recurso("Bitmap", getString(R.string.bitmap)));
        listaRecursos.add(new Recurso("Nine-patch files", getString(R.string.NinePatch)));
        listaRecursos.add(new Recurso("Layer list", getString(R.string.LayerList)));
        listaRecursos.add(new Recurso("State list", getString(R.string.StateList)));
        listaRecursos.add(new Recurso("Level list", getString(R.string.LevelList)));
        listaRecursos.add(new Recurso("Transition drawable", getString(R.string.Transition)));
        listaRecursos.add(new Recurso("Inset drawable", getString(R.string.Inset)));
        listaRecursos.add(new Recurso("Clip drawable", getString(R.string.Clip)));
        listaRecursos.add(new Recurso("Scale drawable", getString(R.string.Scale)));
        listaRecursos.add(new Recurso("Shape drawable", getString(R.string.Shape)));

        Adapter adapter = new Adapter(listaRecursos);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Recurso recurso = listaRecursos.get(position);

                Toast toast1 = Toast.makeText(getApplicationContext(), getString(R.string.toas1) + recurso.getName(), Toast.LENGTH_SHORT);
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
                }else if(position==3){
                    Intent intent = new Intent(getApplicationContext(), StateList.class);
                    startActivity(intent);
                }else if(position==4){
                    Intent intent = new Intent(getApplicationContext(), LevelList.class);
                    startActivity(intent);
                }else if(position==5){
                    Intent intent = new Intent(getApplicationContext(), Transition.class);
                    startActivity(intent);
                }else if(position==6){
                    Intent intent = new Intent(getApplicationContext(), InsetDrawable.class);
                    startActivity(intent);
                }else if(position==7){
                    Intent intent = new Intent(getApplicationContext(), Clip.class);
                    startActivity(intent);
                }else if(position==8){
                    Intent intent = new Intent(getApplicationContext(), Scale.class);
                    startActivity(intent);
                }else if(position==9){
                    Intent intent = new Intent(getApplicationContext(), Shape.class);
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
