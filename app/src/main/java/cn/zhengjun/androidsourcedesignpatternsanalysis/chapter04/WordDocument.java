package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter04;

import java.util.ArrayList;
import java.util.List;

/**
 * OKLine(HangZhou) co.,Ltd.
 * Author  : Zheng Jun
 * Email   : zhengjun@okline.cn
 * Date    : 2018/1/29 9:52
 * Summary : null
 */

public class WordDocument implements Cloneable {
    private String mText;
    private ArrayList<String> mImages = new ArrayList<>();

    public WordDocument() {
        System.out.println("WordDocument.<init>");
    }

    @Override
    protected WordDocument clone() {
        try {
            WordDocument clone = (WordDocument) super.clone();//clone()是Object类的方法,Cloneable只是一个标识接口
            clone.mText = this.mText;
//            clone.mImages = this.mImages;//浅拷贝
            clone.mImages = (ArrayList<String>) this.mImages.clone();//深拷贝2018-1-29 10:55:50
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getText() {
        return mText;
    }

    public List<String> getImages() {
        return mImages;
    }

    public void setText(String text) {
        mText = text;
    }

    public boolean addImage(String img) {
        return mImages.add(img);
    }

    public void show(){
        System.out.println("-------------Word Content Start-------------");
        System.out.println("mText = " + mText);
        System.out.println("Image List:");
        for (String image : mImages) {
            System.out.println("image = " + image);
        }
        System.out.println("------------- Word Content End -------------");
    }
}
