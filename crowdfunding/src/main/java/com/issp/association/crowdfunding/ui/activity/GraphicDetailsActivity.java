package com.issp.association.crowdfunding.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.issp.association.crowdfunding.R;
import com.issp.association.crowdfunding.bean.ProductRewardBean;
import com.issp.association.crowdfunding.network.HttpUtils;
import com.issp.association.crowdfunding.utils.T;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.zhy.autolayout.AutoLayoutActivity;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.http.okhttp.callback.StringCallback;

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
import okhttp3.Call;

import static android.R.attr.data;

/**
 * 图文详情
 * Created by T-BayMax on 2017/4/22.
 */

public class GraphicDetailsActivity extends AutoLayoutActivity implements View.OnLayoutChangeListener {


    @BindView(R.id.lt_main_title_left)
    TextView ltMainTitleLeft;
    @BindView(R.id.lt_main_title)
    TextView ltMainTitle;
    @BindView(R.id.lt_main_title_right)
    TextView ltMainTitleRight;
    @BindView(R.id.et_content)
    RichEditor etContent;
    @BindView(R.id.iv_ask_camera)
    ImageView ivAskCamera;
    @BindView(R.id.iv_ask_picture)
    ImageView ivAskPicture;
    @BindView(R.id.ll_ask_insert)
    AutoLinearLayout llAskInsert;
    @BindView(R.id.ll_insert)
    LinearLayout llInsert;
    //屏幕高度
    private int screenHeight = 0;
    private int screenWidth = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;
    private int goldNum = 0;


    private int REQUEST_CONTENT = 200;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_details);
        ModelUtils.setDebugModel(true);
        ButterKnife.bind(this);
        initView();
        llInsert.addOnLayoutChangeListener(this);
    }
    private void initView(){
        ltMainTitleLeft.setText("取消");
        ltMainTitleLeft.setCompoundDrawables(null,null,null,null);
        ltMainTitleRight.setText("保存");
        ltMainTitleRight.setCompoundDrawables(null,null,null,null);
        etContent.setPlaceholder("请输入项目详情");
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

    @OnClick({R.id.lt_main_title_left, R.id.lt_main_title_right, R.id.iv_ask_camera, R.id.iv_ask_picture})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lt_main_title_left:
                GraphicDetailsActivity.this.finish();
                break;
            case R.id.lt_main_title_right:
                submit();
                break;
            case R.id.iv_ask_camera:
                break;
            case R.id.iv_ask_picture:
                RxGalleryFinal
                        .with(GraphicDetailsActivity.this)
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
                               // presenter.uploadPicturesPresenter(params, file, "file");
                                HttpUtils.sendFormatPostRequest("/files",params,file,"file", new StringCallback() {
                                    @Override
                                    public void onError(Call call, Exception e, int id) {
                                        T.showShort(GraphicDetailsActivity.this, "上传失败");
                                    }

                                    @Override
                                    public void onResponse(String response, int id) {
                                        String imgUrl = HttpUtils.IMAGE_RUL + response;
                                        etContent.insertImage(imgUrl, "dachshund");
                                        T.showShort(GraphicDetailsActivity.this, "上传成功");
                                    }
                                });
                            }
                        }).openGallery();
                break;
        }
    }
    private void submit() {
       if (etContent.getHtml().equals("")) {
           if(etContent.getHtml().toString().trim().equals("")){

               T.showLong(GraphicDetailsActivity.this,"请输入文字详情");
               return;
           }
           return;
       }
        Intent it = new Intent();
        it.putExtra("productReward", etContent.getHtml());
        setResult(REQUEST_CONTENT, it);
        GraphicDetailsActivity.this.finish();
    }
}
