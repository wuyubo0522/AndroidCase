package com.yb.autograph.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yb.autograph.R;
import com.yb.autograph.db.AppInfo;
import com.yb.common.utils.ToastUtil;

import java.util.List;

/**
 * 类说明：获取签名界面的MD5值
 *
 * @author 裕博
 * Date: 2019/9/12
 * Time: 16:06
 */
public class AppInfoAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {

    public AppInfoAdapter(int layoutResId, @Nullable List<AppInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfo item) {
        try {
            try {
                ImageView icon = helper.getView(R.id.icon);
                icon.setImageDrawable(item.getIcon());
            } catch (Exception e) {
                e.printStackTrace();
            }
            helper.setText(R.id.tv_appName, item.getName() + "\n" + item.getPackageName() + "\n" + item.getSign());
            helper.getView(R.id.btn_0).setOnClickListener(view -> {
                // 一键复制
                ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                assert cm != null;
                cm.setPrimaryClip(ClipData.newPlainText(null, item.getName() + "\n" + item.getPackageName() + "\n" + item.getSign()));
                ToastUtil.showToastShort(mContext,"一键复制成功啦！");
            });
            helper.getView(R.id.btn_1).setOnClickListener(view -> {
                // 单纯的复制当前应用的MD5值
                ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                assert cm != null;
                cm.setPrimaryClip(ClipData.newPlainText(null, item.getSign()));
                ToastUtil.showToastShort(mContext,"MD5到手啦！");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
