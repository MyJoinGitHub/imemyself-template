package com.imemyself.template.common;

import java.io.Serializable;

/**
 * 一对参数对象类型
 * @param <X>
 * @param <Y>
 */
public class Pair<X,Y>  implements Serializable {
    /**
     * 第一个参数
     */
    private X x;

    /**
     * 第二个参数
     */
    private Y y;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public Y getY() {
        return y;
    }

    public void setY(Y y) {
        this.y = y;
    }
}
