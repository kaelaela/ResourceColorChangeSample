package me.kaelaela.sample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

public class DrawableColorChanger {

    public static Drawable changeColor(Context context,
                                       @ColorInt int colorId, @DrawableRes int resourceId) {
        Drawable changedDrawable = ContextCompat.getDrawable(context, resourceId);
        changedDrawable.setColorFilter(decreaseValue(colorId), PorterDuff.Mode.SRC_ATOP);
        return changedDrawable;
    }

    private static int decreaseValue(int color) {
        float hsv[] = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] = hsv[2] - 0.4f;
        if (hsv[2] < 0) {
            hsv[2] = 0f;
        }
        return Color.HSVToColor(hsv);
    }
}
