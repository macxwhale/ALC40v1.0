package com.example.alc40;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class IntroViewPageAdapter extends PagerAdapter {

    Context mContext;

    List<ScreenItem> mListScreen;

    public IntroViewPageAdapter(Context mContext, List<ScreenItem> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View LayoutScreen = inflator.inflate(R.layout.layout_screen, null);

        ImageView imgSlide = LayoutScreen.findViewById(R.id.introImg);
        TextView title = LayoutScreen.findViewById(R.id.intoTitle);
        TextView desc = LayoutScreen.findViewById(R.id.introDesc);

        title.setText(mListScreen.get(position).getTitle());
        desc.setText(mListScreen.get(position).getDesc());
        imgSlide.setImageResource(mListScreen.get(position).getScreenTag());

        container.addView(LayoutScreen);

        return LayoutScreen;

    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
