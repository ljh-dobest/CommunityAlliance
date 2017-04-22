package com.issp.association.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.issp.association.App;
import com.issp.association.R;
import com.issp.association.base.view.BaseMvpActivity;
import com.issp.association.bean.ShareBean;
import com.issp.association.interfaces.IAddArticleView;
import com.issp.association.network.HttpUtils;
import com.issp.association.presenters.AddArticlePresenter;
import com.issp.association.utils.DisplayUtils;
import com.issp.association.utils.T;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultSubscriber;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;
import cn.finalteam.rxgalleryfinal.utils.ModelUtils;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by T-BayMax on 2017/4/19.
 */

public class AddArticleActivity extends BaseMvpActivity<IAddArticleView, AddArticlePresenter> implements IAddArticleView, View.OnLayoutChangeListener {


    @BindView(R.id.iv_ask_back)
    ImageView ivAskBack;
    @BindView(R.id.ll_ask_back)
    AutoLinearLayout llAskBack;
    @BindView(R.id.tv_ask_release)
    TextView tvAskRelease;
    @BindView(R.id.tv_preview)
    TextView tvPreview;
    @BindView(R.id.tv_image)
    TextView tvImage;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    RichEditor etContent;
    @BindView(R.id.et_deal_content)
    RichEditor etDealContent;
    @BindView(R.id.iv_ask_camera)
    ImageView ivAskCamera;
    @BindView(R.id.iv_ask_picture)
    ImageView ivAskPicture;
    @BindView(R.id.ll_ask_insert)
    AutoLinearLayout llAskInsert;
    @BindView(R.id.activity_ask)
    AutoRelativeLayout activityAsk;
    //屏幕高度

    private int screenHeight = 0;
    private int screenWidth = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;
    private int goldNum = 0;

    private String path;
    File file;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);

        App.activityMap.put("AddArticleActivity", AddArticleActivity.this);
        ButterKnife.bind(this);
        ModelUtils.setDebugModel(true);
        //获取屏幕高度
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        screenWidth = this.getWindowManager().getDefaultDisplay().getWidth();
        //阀值设置为屏幕高度的1/3
        keyHeight = screenHeight / 4;
        initView();
    }


    private void initView() {
        etDealContent.setEditorHeight(300);
        activityAsk.addOnLayoutChangeListener(this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorString) {
        T.showShort(AddArticleActivity.this, errorString);
    }

    @Override
    public void uploadPicturesView(String data) {
        String imgUrl = HttpUtils.IMAGE_RUL + data;
        etDealContent.insertImage(imgUrl, "dachshund");
        T.showShort(AddArticleActivity.this, "上传成功");
    }

    @Override
    public void publishAnArticleView(String data) {

        T.showShort(AddArticleActivity.this, data);
        AddArticleActivity.this.finish();
    }

    @Override
    public AddArticlePresenter initPresenter() {
        return new AddArticlePresenter();
    }

    @OnClick({R.id.ll_ask_back, R.id.tv_image, R.id.et_title, R.id.et_content, R.id.et_deal_content, R.id.iv_ask_camera,
            R.id.iv_ask_picture,  R.id.tv_preview, R.id.tv_ask_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_ask_back:
                AddArticleActivity.this.finish();
                break;
            case R.id.tv_image:
                if (etDealContent.requestFocus()) {
                    RxGalleryFinal
                            .with(AddArticleActivity.this)
                            .image()
                            .radio()
                            .crop()
                            .imageLoader(ImageLoaderType.PICASSO)
                            .subscribe(new RxBusResultSubscriber<ImageRadioResultEvent>() {
                                @Override
                                protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                    path = imageRadioResultEvent.getResult().getOriginalPath();
                                    file = new File(path);
                                    Picasso.with(getBaseContext()).load(file).into(new Target() {
                                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                                        @Override
                                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                            tvImage.setBackground(new BitmapDrawable(getResources(), bitmap));
                                        }

                                        @Override
                                        public void onBitmapFailed(Drawable errorDrawable) {

                                        }

                                        @Override
                                        public void onPrepareLoad(Drawable placeHolderDrawable) {

                                        }
                                    });
                                }
                            }).openGallery();
                }
                break;
            case R.id.et_title:
                break;
            case R.id.et_content:
                break;
            case R.id.et_deal_content:
                break;
            case R.id.iv_ask_camera:

                break;
            case R.id.iv_ask_picture:
                RxGalleryFinal
                        .with(AddArticleActivity.this)
                        .image()
                        .radio()
                        .crop()
                        .imageLoader(ImageLoaderType.PICASSO)
                        .subscribe(new RxBusResultSubscriber<ImageRadioResultEvent>() {
                            @Override
                            protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                String path = imageRadioResultEvent.getResult().getOriginalPath();
                                File file = new File(path);
                                Map<String, String> params = new HashMap<String, String>(0);
                                params.put("userId", "111");
                                presenter.uploadPicturesPresenter(params, file, "file");
                            }
                        }).openGallery();
                break;

            case R.id.tv_preview://预览
                releaseArticle(false);
                break;
            case R.id.tv_ask_release://发布
                showComfirmDialog();
                break;
        }
    }
    public void showComfirmDialog() {
        final android.app.AlertDialog ComfirmDialog = new android.app.AlertDialog.Builder(this).create();
        ComfirmDialog.show();
        Window window = ComfirmDialog.getWindow();
        WindowManager.LayoutParams lp = ComfirmDialog.getWindow().getAttributes();
        lp.width = DisplayUtils.dp2px(AddArticleActivity.this, 300);//定义宽度
        lp.height = DisplayUtils.dp2px(AddArticleActivity.this, 200);//定义高度
        ComfirmDialog.getWindow().setAttributes(lp);
        window.setContentView(R.layout.comfirm_dialog_layout);
        TextView tv_reminder = (TextView) window.findViewById(R.id.tv_reminder);
        tv_reminder.setText("确定发布内容");
        Button btn_comfirm_dialog_comfirm = (Button) window.findViewById(R.id.btn_comfirm_dialog_comfirm);
        ImageView iv_comfirm_dialog_cancel = (ImageView) window.findViewById(R.id.iv_comfirm_dialog_cancel);
        btn_comfirm_dialog_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                releaseArticle(true);
            }
        });
        iv_comfirm_dialog_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComfirmDialog.dismiss();
            }
        });
    }
    private void releaseArticle(boolean isRelease){
        String title = etTitle.getText().toString().trim();                //标题
        String content = etContent.getHtml().trim();             //非交易内容
        String dealContent = etDealContent.getHtml();         //交易内容
        if (title.equals("")) {
            T.showLong(AddArticleActivity.this, "分享文章标题不能为空！");
            return;
        }
        if (content.equals("")) {
            T.showLong(AddArticleActivity.this, "干货分享简介不能为空！");
            return;
        }
        if (dealContent.equals("")) {
            T.showLong(AddArticleActivity.this, "分享文章内容不能为空！");
            return;
        }
        if (null==file){
            T.showLong(AddArticleActivity.this, "请选择背景图片！");
            return;
        }
        if (isRelease) {
            Map<String, String> formData = new HashMap<String, String>(0);
            formData.put("userId", "111");
            formData.put("arctitle", title);
            formData.put("synopsis", content);
            formData.put("shareContent", dealContent);
            presenter.publishAnArticlePresenter(formData, file, "file");
        }else {
            ShareBean bean=new ShareBean();
            bean.setUserId("111");
            bean.setTitle(title);
            bean.setSynopsis(content);
            bean.setContent(dealContent);
            bean.setImage(path);

            Intent intent=new Intent(AddArticleActivity.this,PreviewActivity.class);
            intent.putExtra("bean",bean);
            startActivity(intent);
        }
    }


    /**
     * 布局底部移动超过屏幕高度的四分之一则判断软键盘弹出或关闭
     */
    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
            llAskInsert.setVisibility(View.VISIBLE);
        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
            llAskInsert.setVisibility(View.INVISIBLE);
        }
    }

    public static void setLayoutY(View view, int y) {
        ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        margin.setMargins(margin.leftMargin, y, margin.rightMargin, y + margin.height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
        view.setLayoutParams(layoutParams);
    }

    public int getViewHeight(final View messureView) {
        return messureView.getMeasuredHeight();
    }

}
