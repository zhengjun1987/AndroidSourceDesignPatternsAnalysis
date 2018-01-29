package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter04;

/**
 * OKLine(HangZhou) co.,Ltd.
 * Author  : Zheng Jun
 * Email   : zhengjun@okline.cn
 * Date    : 2018/1/29 10:00
 * Summary : null
 */

public class Client {
    public static void main(String[] args) {
        WordDocument wordDocument = new WordDocument();
        wordDocument.setText("This is a word document");
        wordDocument.addImage("Image1");
        wordDocument.addImage("Image2");
        wordDocument.addImage("Image3");
        wordDocument.show();

        System.out.println();

        WordDocument wordDocument1 = wordDocument.clone();
        wordDocument1.show();//拷贝后的内容和原来的一模一样,而且拷贝过程不会调用构造函数
        System.out.println("wordDocument1.getText()==wordDocument.getText() = " + (wordDocument1.getText() == wordDocument.getText()));//true
        //浅拷贝,也叫影子拷贝    并未将原始文档的字段重新构造,而是拷贝文档引用原始文档的字段
        System.out.println();
        wordDocument1.setText("This is a modified copy");
        wordDocument1.show();
        System.out.println();
        wordDocument.show();//修改拷贝的内容并不影响原来的内容
        System.out.println("wordDocument1.getImages().equals(wordDocument.getImages()) = " + wordDocument1.getImages().equals(wordDocument.getImages()));//true

        wordDocument1.setText("This is a modified copy");
        wordDocument1.addImage("哈哈哈.jpg");
        wordDocument1.show();
        System.out.println();
        wordDocument.show();//浅拷贝导致新旧文档指向同一个List引用
        System.out.println("wordDocument1.getImages().equals(wordDocument.getImages()) = " + wordDocument1.getImages().equals(wordDocument.getImages()));//true
    }
}
//2018年1月29日10:38:33版本
//        WordDocument.<init>
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a modified copy
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------

//2018年1月29日10:43:00版本
//WordDocument.<init>
//-------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//        wordDocument1.getText()==wordDocument.getText() = true
//
//        -------------Word Content Start-------------
//        mText = This is a modified copy
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//        wordDocument1.getImages().equals(wordDocument.getImages()) = true
//        -------------Word Content Start-------------
//        mText = This is a modified copy
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        image = 哈哈哈.jpg
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        image = 哈哈哈.jpg
//        ------------- Word Content End -------------
//        wordDocument1.getImages().equals(wordDocument.getImages()) = true

//2018年1月29日10:57:02版本
//WordDocument.<init>
//-------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//        wordDocument1.getText()==wordDocument.getText() = true
//
//        -------------Word Content Start-------------
//        mText = This is a modified copy
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//        wordDocument1.getImages().equals(wordDocument.getImages()) = true
//        -------------Word Content Start-------------
//        mText = This is a modified copy
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        image = 哈哈哈.jpg
//        ------------- Word Content End -------------
//
//        -------------Word Content Start-------------
//        mText = This is a word document
//        Image List:
//        image = Image1
//        image = Image2
//        image = Image3
//        ------------- Word Content End -------------
//        wordDocument1.getImages().equals(wordDocument.getImages()) = false