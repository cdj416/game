package com.alipayjf.game.custom_view;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipayjf.game.R;
import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

public class SelectPictureView extends RelativeLayout {
    private TextView tv_add;
    private ImageView iv_add;
    private LoadCompleted completed;

    public interface LoadCompleted{
        void uploadImg(File file);
    }

    public SelectPictureView(Context context) {
        super(context);
        initLayoutView();
    }

    public SelectPictureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayoutView();
    }

    public SelectPictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayoutView();
    }

    public void initLayoutView() {
       View view = View.inflate(getContext(), R.layout.view_select_picture, this);
       tv_add = view.findViewById(R.id.tv_add);
        iv_add = view.findViewById(R.id.iv_add);
    }

    /*
    * 图片选择回调
    * */
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    File file = new File(selectList.get(0).getCompressPath());
                    Glide.with(getContext())
                            .load(file).into(iv_add);
                    if(completed != null){
                        completed.uploadImg(file);
                    }
                    break;
            }
        }
    }

    /*
    * 初始化
    * */
    public void setCompleted(LoadCompleted completed){
        this.completed = completed;
    }

    /*
     * 选择图片方式弹框
     * */
    public void selectPhoto(final Context mContext){
        final Dialog dialog = new Dialog(mContext, R.style.DialogTheme);
        View view = View.inflate(mContext, R.layout.dialog_select_photo_box,null);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.bottom_in_out);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        dialog.findViewById(R.id.album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                PictureSelector.create((Activity) mContext)
                        .openGallery(PictureMimeType.ofImage())
                        .selectionMode(PictureConfig.SINGLE)// 多选 or 单选
                        .enableCrop(true)// 是否裁剪
                        .compress(true)// 是否压缩
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });

        dialog.findViewById(R.id.photograph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                PictureSelector.create((Activity) mContext)
                        .openCamera(PictureMimeType.ofImage())
                        .maxSelectNum(1)
                        .enableCrop(true)// 是否裁剪
                        .compress(true)// 是否压缩
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });

        dialog.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    /*
    * 设置网络图片的显示
    * */
    public void showImg(String imgUrl){
        Glide.with(getContext())
                .load(imgUrl).into(iv_add);
    }

}
