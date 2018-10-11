package com.example.zjf.recyclerviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
*@description
*
*@author zjf
*@date 2018/9/14 14:14
*/
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    //读取系统主题中的 android.R.attr.listDivider作为Item间的分割线，并且支持横向和纵向
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;
    private int mOrientation;

    public DividerItemDecoration(Context context,int orientation){
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    //Itemdecoration的onDraw()绘制会先于ItemView的onDraw()绘制，
    // 所以如果在Itemdecoration的onDraw()中绘制的内容在ItemView
    // 边界内，就会被ItemView遮挡住。

    //在 使用onDraw（）绘制时，需要先遍历RecyclerView 的所有ItemView
    // 分别获取它们的位置信息，然后再绘制内容
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        // RecyclerView 的左边界加上 paddingLeft距离 后的坐标位置
        final int left = parent.getPaddingLeft();
        // RecyclerView 的右边界减去 paddingRight 后的坐标位置
        final int right = parent.getWidth() - parent.getPaddingRight();
        // 即左右边界就是 RecyclerView 的 ItemView区域

        // 获取RecyclerView的Child view的个数
        final int childCount = parent.getChildCount();

        // 遍历每个RecyclerView的Child view
        // 分别获取它们的位置信息，然后再绘制内容
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
           RecyclerView v = new RecyclerView(parent.getContext());
            // 设置布局参数
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            // ItemView的下边界：ItemView 的 bottom坐标 + 距离RecyclerView底部距离 +translationY
            final int top = child.getBottom() + params.bottomMargin;
            // 绘制分割线的下边界 = ItemView的下边界+分割线的高度
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }


    private void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
