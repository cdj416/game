package com.alipayjf.game.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipayjf.game.R;

public class ColumnItemView extends RelativeLayout{
    private RelativeLayout itemBox;
    private TextView tvLeft,tvRight;
    private View bottomLine;

    //获取初始数据
    private Drawable leftImageDrawble;
    private Drawable rightImageDrawble;
    private String leftText = "",rightText = "";
    private boolean showLine;

    public ColumnItemView(Context context) {
        super(context);
        initLayoutView();
    }

    public ColumnItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.itemColum);
        leftImageDrawble = a.getDrawable(R.styleable.itemColum_leftImage);
        rightImageDrawble = a.getDrawable(R.styleable.itemColum_rightImage);

        leftText = a.getString(R.styleable.itemColum_leftText);
        rightText = a.getString(R.styleable.itemColum_rightText);
        showLine = a.getBoolean(R.styleable.itemColum_lineShow,false);
        initLayoutView();
    }

    public ColumnItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayoutView();
    }

    public void initLayoutView() {
        View view = View.inflate(getContext(), R.layout.view_column_item, this);
        itemBox = view.findViewById(R.id.itemBox);
        tvLeft = view.findViewById(R.id.leftText);
        tvRight = view.findViewById(R.id.rightText);
        bottomLine = view.findViewById(R.id.bottomLine);

        //设置文字
        if (!TextUtils.isEmpty(leftText)) {
            tvLeft.setText(leftText);
        }
        if (!TextUtils.isEmpty(rightText)) {
            tvRight.setText(rightText);
        }

        if(leftImageDrawble != null){
            setDrawble(tvLeft,leftImageDrawble,1);
        }
        if(rightImageDrawble != null){
            setDrawble(tvRight,rightImageDrawble,2);
        }

        if(showLine){
            bottomLine.setVisibility(VISIBLE);
        }
    }

    /*
    * 设置图片
    * */
    private void setDrawble(TextView tv,Drawable imgId,int type){
        imgId.setBounds(0,0,70,70);
        if(type == 1){
            tv.setCompoundDrawables(imgId,null,null,null);
        }else{
            tv.setCompoundDrawables(null,null,imgId,null);
        }
       /* Drawable drawable =getResources().getDrawable(imgId);
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        if(type == 1){
            tv.setCompoundDrawables(drawable,null,null,null);
        }else{
            tv.setCompoundDrawables(null,null,drawable,null);
        }*/
    }

    /*
    * 设置右边的文字内容
    * */
    public void setRightText(String text){
        tvRight.setText(text);
    }

    /*
    * 设置右边文字的颜色
    * */
    public void setRightTextColor(int colorId){
        tvRight.setTextColor(getResources().getColor(colorId));
    }

}
