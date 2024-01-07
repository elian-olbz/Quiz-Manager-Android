package com.google.android.material.resources;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources {
    private MaterialResources() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r3, (r0 = r4.getResourceId(r5, 0)));
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList getColorStateList(android.content.Context r3, android.content.res.TypedArray r4, @androidx.annotation.StyleableRes int r5) {
        /*
            boolean r2 = r4.hasValue(r5)
            if (r2 == 0) goto L_0x0014
            r2 = 0
            int r0 = r4.getResourceId(r5, r2)
            if (r0 == 0) goto L_0x0014
            android.content.res.ColorStateList r1 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r3, r0)
            if (r1 == 0) goto L_0x0014
        L_0x0013:
            return r1
        L_0x0014:
            android.content.res.ColorStateList r1 = r4.getColorStateList(r5)
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.MaterialResources.getColorStateList(android.content.Context, android.content.res.TypedArray, int):android.content.res.ColorStateList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r3, (r0 = r4.getResourceId(r5, 0)));
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable getDrawable(android.content.Context r3, android.content.res.TypedArray r4, @androidx.annotation.StyleableRes int r5) {
        /*
            boolean r2 = r4.hasValue(r5)
            if (r2 == 0) goto L_0x0014
            r2 = 0
            int r0 = r4.getResourceId(r5, r2)
            if (r0 == 0) goto L_0x0014
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r3, r0)
            if (r1 == 0) goto L_0x0014
        L_0x0013:
            return r1
        L_0x0014:
            android.graphics.drawable.Drawable r1 = r4.getDrawable(r5)
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.MaterialResources.getDrawable(android.content.Context, android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    @Nullable
    public static TextAppearance getTextAppearance(Context context, TypedArray attributes, @StyleableRes int index) {
        int resourceId;
        if (!attributes.hasValue(index) || (resourceId = attributes.getResourceId(index, 0)) == 0) {
            return null;
        }
        return new TextAppearance(context, resourceId);
    }

    @StyleableRes
    static int getIndexWithValue(TypedArray attributes, @StyleableRes int a, @StyleableRes int b) {
        return attributes.hasValue(a) ? a : b;
    }
}
