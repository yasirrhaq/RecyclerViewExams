package ap.mobile.utsmobile;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter {

    private final Context context;
    List<Person> data;

    StatusAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void setData(List<Person> data) {
        this.data = data;
    }

    public List<Person> getData() {
        return this.data;
    }

    class StatusVH extends RecyclerView.ViewHolder {

        TextView tvNama;
        TextView tvStatus;

        public StatusVH(@NonNull View itemView) {
            super(itemView);
            this.tvNama = itemView.findViewById(R.id.tvNamaPerson);
            this.tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(this.context).inflate(R.layout.item_person, parent, false);
        return new StatusVH(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StatusVH vh = (StatusVH) holder;
        Person person = data.get(position);
        vh.tvNama.setText(person.nama);
        if (person.status) {
            vh.tvStatus.setText("Online");
        } else {
            vh.tvStatus.setText("Offline");
            vh.tvStatus.setTextColor(Color.RED);
        }
    }
    public void removeItem(int position) {
        getData().remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getData().size());
    }

    @Override
    public int getItemCount() {
        return getData().size();
    }
}
