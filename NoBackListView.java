package com.kuyun.tv.widget;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.kuyun.tv.debug.Console;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ListView;

public class NoBackListView extends ListView {

    /**
     *解决当ListView item长度不正确时出现灰色背景 
     * */
    
    public NoBackListView(Context context) {
        super(context);
        this.makeTransparent();
    }

    public NoBackListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.makeTransparent();
    }

    public NoBackListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.makeTransparent();
    }

    /**
     * 当版本为2.3。3以上时，调用其listview属性，并赋值为空
     * */
    private void makeTransparent() {
        if (Build.VERSION.SDK_INT >= 9) {
            try {

                Method overscrollFooterMethod = NoBackListView.class.getMethod("setOverscrollFooter", new Class[] { Drawable.class });
                Method overscrollHeaderMethod = NoBackListView.class.getMethod("setOverscrollHeader", new Class[] { Drawable.class });

                try {
                    overscrollFooterMethod.invoke(this, new Object[] { null });
                    overscrollHeaderMethod.invoke(this, new Object[] { null });
                } catch (IllegalArgumentException e) {
                    if(Console.isPrintStackTrace){
                        e.printStackTrace();
                    }
                } catch (IllegalAccessException e) {
                    if(Console.isPrintStackTrace){
                        e.printStackTrace();
                    }
                } catch (InvocationTargetException e) {
                    if(Console.isPrintStackTrace){
                        e.printStackTrace();
                    }
                }
            } catch (SecurityException e) {
                if(Console.isPrintStackTrace){
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                if(Console.isPrintStackTrace){
                    e.printStackTrace();
                }
            }
        }
    }

}