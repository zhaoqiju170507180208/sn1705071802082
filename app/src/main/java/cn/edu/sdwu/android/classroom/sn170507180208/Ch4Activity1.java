package cn.edu.sdwu.android.classroom.sn170507180208;

import android.app.WallpaperManager;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Ch4Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载界面，不要写文件名，使用资源id来引用资源
        setContentView(R.layout.layout_ch4_1);

        //1) 获取普通界面组件
        Button button=(Button) findViewById(R.id.button1);
        ImageView imageView=(ImageView)findViewById(R.id.ch4_iv);

        //2)实现事件监听类
        button.setOnClickListener(new MyClickListener() );

        //3)使用内部匿名类注册监听器
        imageView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                //设置壁纸
                WallpaperManager wallpaperManager=(WallpaperManager)getSystemService(WALLPAPER_SERVICE);
                try{
                    wallpaperManager.setResource(R.raw.img);
                }catch (Exception e){
                    Log.e(Ch4Activity1.class.toString(),e.toString());
                }

                return true;
            }
        });
    }
    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Log.i(Ch4Activity1.class.toString(),"button click");
        }


    }







}