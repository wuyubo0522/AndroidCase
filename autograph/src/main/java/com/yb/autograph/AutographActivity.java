package com.yb.autograph;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.ImmersionBar;
import com.yb.autograph.adapter.AppInfoAdapter;
import com.yb.autograph.db.AppInfo;
import com.yb.common.ARouterManager;
import com.yb.common.base_mvc.BaseActivityC;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * 类说明：获取前面的Activity
 *
 * @author 裕博
 * Date: 2019/9/12
 * Time: 10:25
 */
@Route(path = ARouterManager.AUTOGRAPH)
public class AutographActivity extends BaseActivityC {

    private ImageView imageView;

    private RecyclerView rvAppList;

    private EditText etLookup;

    private Button btSearch;

    private List<AppInfo> appInfo = new ArrayList<>();

    private List<AppInfo> searchData = new ArrayList<>();

    private AppInfoAdapter appInfoAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_autograph;
    }

    @Override
    public void init() {
        // 设置沉浸式状态
        ImmersionBar.with(this).init();
        initControl();
        // 设置数据列表
        appInfoAdapter = new AppInfoAdapter(R.layout.item_appinfo, appInfo);
        // 开启适配器动画
        appInfoAdapter.openLoadAnimation();
        rvAppList.setLayoutManager(new LinearLayoutManager(this));
        rvAppList.setAdapter(appInfoAdapter);
        // 获取列表当中需要的信息
        getPackInfo();
        initClick();
    }

    /**
     * 初始化控件
     */
    private void initControl() {
        imageView = findViewById(R.id.iv_return);
        rvAppList = findViewById(R.id.rv_app_list);
        etLookup = findViewById(R.id.et_lookup);
        btSearch = findViewById(R.id.bt_search);
    }

    /**
     * 设置所有控件的点击事件
     */
    private void initClick() {
        imageView.setOnClickListener(view -> {
            // 关闭当前页面
            finish();
        });
        btSearch.setOnClickListener(view -> {
            String etLookupStr = etLookup.getText().toString();
            if (TextUtils.isEmpty(etLookupStr)) {
                showToastShort("搜索值不能为空！");
            } else {
                if (btSearch.getText().toString().equals(this.getResources().getString(R.string.search))) {
                    // 按钮内的值是搜索
                    search(etLookupStr);
                    btSearch.setText(R.string.cancel);
                } else if (btSearch.getText().toString().equals(this.getResources().getString(R.string.cancel))) {
                    // 按钮内的值是取消,清空搜索集合里面的数据
                    searchData.clear();
                    // 判断应用信息集合里面是否有数据，如果没有数据重新获取，减少不必要的消耗
                    if (appInfo.size() > 0) {
                        appInfoAdapter.setNewData(appInfo);
                    } else {
                        getPackInfo();
                    }
                    btSearch.setText(R.string.search);
                    etLookup.setText("");
                }
                // 隐藏软件盘
                hideInput();
            }
        });
    }

    /**
     * 获取包名里面的信息
     */
    private void getPackInfo() {
        Intent main = new Intent(Intent.ACTION_MAIN, null);
        main.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> launchables = getPackageManager().queryIntentActivities(main, PackageManager.MATCH_ALL);
        // 清空信息集合
        appInfo.clear();
        for (ResolveInfo resolveInfo : launchables) {
            String packageName = resolveInfo.activityInfo.packageName;
            try {
                PackageInfo packageInfo = getPackageManager().getPackageInfo(packageName, 0);
                if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
                    //第三方应用
                    String name = resolveInfo.loadLabel(getPackageManager()).toString();
                    Drawable drawable = resolveInfo.loadIcon(getPackageManager());
                    appInfo.add(new AppInfo(drawable, name, packageName));
                } else {
                    //系统应用
                    String name = resolveInfo.loadLabel(getPackageManager()).toString();
                    Drawable drawable = resolveInfo.loadIcon(getPackageManager());
                    appInfo.add(new AppInfo(drawable, name, packageName));
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (appInfo != null) {
            for (AppInfo appInfo : appInfo) {
                getSign(appInfo);
            }
        }
        appInfoAdapter.setNewData(appInfo);
    }

    @SuppressLint("PackageManagerGetSignatures")
    private Signature[] getRawSignature(String paramString) {
        if ((paramString == null) || (paramString.length() == 0)) {
            return null;
        }
        PackageManager localPackageManager = getPackageManager();
        PackageInfo localPackageInfo;
        try {
            localPackageInfo = localPackageManager.getPackageInfo(paramString, PackageManager.GET_SIGNATURES);
            if (localPackageInfo == null) {
                return null;
            }
        } catch (PackageManager.NameNotFoundException localNameNotFoundException) {
            return null;
        }
        return localPackageInfo.signatures;
    }

    /**
     * 开始获得签名 * @param packageName 包名
     *
     * @param appInfo 应用信息
     */
    private void getSign(AppInfo appInfo) {
        Signature[] arrayOfSignature = getRawSignature(appInfo.getPackageName());
        if ((arrayOfSignature == null) || (arrayOfSignature.length == 0)) {
            return;
        }
        String messageDigest = getMessageDigest(arrayOfSignature[0].toByteArray());
        appInfo.setSign(messageDigest);
    }

    public String getMessageDigest(byte[] paramArrayOfByte) {
        char[] arrayOfChar1 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        try {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramArrayOfByte);
            byte[] arrayOfByte = localMessageDigest.digest();
            int i = arrayOfByte.length;
            char[] arrayOfChar2 = new char[i * 2];
            int j = 0;
            int k = 0;
            while (true) {
                if (j >= i) {
                    return new String(arrayOfChar2);
                }
                int m = arrayOfByte[j];
                int n = k + 1;
                arrayOfChar2[k] = arrayOfChar1[(0xF & m >>> 4)];
                k = n + 1;
                arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
                j++;
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }

    /**
     * 搜索相关的方法
     */
    private void search(String etLookupStr) {
        for (int i = 0; i < appInfo.size(); i++) {
            String packName = appInfo.get(i).getPackageName();
            String name = appInfo.get(i).getName();
            // 判断是否是开发者输入的包名和应用名称
            if (packName.contains(etLookupStr) || name.contains(etLookupStr)) {
                searchData.add(appInfo.get(i));
            }
        }
        appInfoAdapter.setNewData(searchData);
    }

    /**
     * 隐藏键盘
     */
    protected void hideInput() {
        InputMethodManager imm = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        }
        View v = getWindow().peekDecorView();
        if (null != v) {
            assert imm != null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
    }
}
