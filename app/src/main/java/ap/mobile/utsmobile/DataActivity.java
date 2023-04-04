package ap.mobile.utsmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private StatusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        this.findViewById(R.id.btnShow).setOnClickListener(this);
        this.findViewById(R.id.btnDelete).setOnClickListener(this);
        this.recyclerView = this.findViewById(R.id.recyclerView);
        this.adapter = new StatusAdapter(this);
        this.adapter.setData(new ArrayList<>());

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShow:
                List<Person> people = new ArrayList<>();
                people.add(new Person("Saka Prasetyo", true));
                people.add(new Person("Hasan Prayoga", true));
                people.add(new Person("Parman Marbun", true));
                people.add(new Person("Ajimin Wijaya", false));
                people.add(new Person("Tami Puspasari", true));
                people.add(new Person("Suci Lestari", true));
                people.add(new Person("Maras Thamrin", false));
                people.add(new Person("Jasmin Usamah", true));
                people.add(new Person("Suci Rahimah", true));
                people.add(new Person("Safina Wahyuni", true));
                people.add(new Person("Luis Nashiruddin", true));
                people.add(new Person("Mutia Purwanti", true));
                people.add(new Person("Mila Hartati", true));
                people.add(new Person("Gabriella Namaga", false));
                people.add(new Person("Umi Mayasari", false));
                people.add(new Person("Ratih Utami", true));
                people.add(new Person("Aris Gunarto", true));
                people.add(new Person("Bagus Prabowo", true));
                people.add(new Person("Bakti Pangestu", false));
                people.add(new Person("Salsabila Permata", true));
                people.add(new Person("Artawan Iswahyudi", true));
                RecyclerView recyclerView = findViewById(R.id.recyclerView);

                recyclerView.setAdapter(adapter);
                adapter.setData(people);

                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.btnDelete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Hapus Satu Data?");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Random random = new Random();
                        int positionToRemove = random.nextInt(adapter.getItemCount());
                        adapter.removeItem(positionToRemove);
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.show();
                break;
        }
    }
}