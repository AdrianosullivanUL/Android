package ie.ul.adrianosullivan.foodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FoodAdaptor extends RecyclerView.Adapter<FoodAdaptor.FoodViewHolder>{
    public void addFood()
    {

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageview;
        private TextView mName;
        private RatingBar mRatingBar;
    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageview = itemView.findViewById(R.id.food_pic);
        mName = itemView.findViewById(R.id.name);
        mRatingBar = itemView.findViewById(R.id.rating_bar);

    }
}

}
