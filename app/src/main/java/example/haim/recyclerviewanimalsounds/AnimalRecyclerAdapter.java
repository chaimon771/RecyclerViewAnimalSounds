package example.haim.recyclerviewanimalsounds;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by DELL e7440 on 29/05/2017.
 */

public class AnimalRecyclerAdapter extends RecyclerView.Adapter<AnimalRecyclerAdapter.AnimalViewHolder> {
    //Properties:
    private List<Animal> animals;
    private LayoutInflater inflater;
    private Context context;



    //Constructor
    public AnimalRecyclerAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        animals = AnimalDataSource.getAnimals();
    }

    //instantiate the AnimalViewHolder and return it.
    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Create a view from xml -> view (v).
        View v = inflater.inflate(R.layout.animal_item, parent, false);
        //Create a new AnimalViewHolder (v).
        AnimalViewHolder vh = new AnimalViewHolder(v);
        //Return the AnimalViewHolder.
        return vh;
    }

    //shows the data inside the controls (Views)... setText, setImageResource.
    //DataBinding.
    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);
        holder.ivAnimal.setImageResource(animal.getImageResID());

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    /*
     * View Holder: holds the views: find the views by id. save the references to the views.
     */

    public class AnimalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivAnimal;

        public AnimalViewHolder(View v) {
            super(v);
            ivAnimal = (ImageView) v.findViewById(R.id.ivAnimal);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            //to know which item is pressed in the list
            int position = getAdapterPosition();

            //Play the sounds
            Animal a = animals.get(position);
            final MediaPlayer mediaPlayer = MediaPlayer.create(context, a.getSoundResID());
            mediaPlayer.start();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                v.animate().rotation(360).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        v.animate().rotation(0);
                    }
                });
            }

        }
    }
}
