package ie.ul.adrianosullivan.foodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodAdaptor extends RecyclerView.Adapter<FoodAdaptor.FoodViewHolder> {
    private List<Food> mFoods = new ArrayList<>();
    private Random mRandom = new Random();
    private RecyclerView mRecyclerView;

    public void addFood() {
        mFoods.add(0, new Food());
        notifyDataSetChanged();
        notifyItemInserted(0);
        notifyItemRangeChanged(0, mFoods.size());
       // mRecyclerView.scrollToPosition(0);
    }
    public void removeFood(int index) {
        mFoods.remove(index);
        notifyItemRemoved(index);
        notifyItemRangeChanged(0, mFoods.size());

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        final Food food = mFoods.get(i);
       // foodViewHolder.mImageview.setImageResource(mFoods.get(i).getImageResourceId());
       // foodViewHolder.mName.setText(mFoods.get(i).getName());
       // foodViewHolder.mRatingBar.setNumStars((int) mFoods.get(i).getRating());

    }

    @Override
    public int getItemCount() {
        return mFoods.size();
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
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    removeFood(getAdapterPosition());
                    return true;
                }
            });
            mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                                                        @Override
                                                        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                                                            if (fromUser) {
                                                                Food currentFood = mFoods.get(getAdapterPosition());
                                                                currentFood.setRating(rating);
                                                            }
                                                        }
                                                    }
            );
        }
    }

}
