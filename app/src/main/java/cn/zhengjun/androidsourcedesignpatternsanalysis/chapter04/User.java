package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter04;

/**
 * OKLine(HangZhou) co.,Ltd.
 * Author  : Zheng Jun
 * Email   : zhengjun@okline.cn
 * Date    : 2018/1/29 11:59
 * Summary : null
 */

public class User implements Cloneable{
    public int mAge;
    public String name;
    public String phone;
    public Address mAddress;

    @Override
    public String toString() {
        return "User{" +
                "mAge=" + mAge +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mAddress=" + mAddress +
                '}';
    }

    public User() {
        System.out.println("User.<init>");
    }

    @Override
    protected User clone(){
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new User();
        user.mAge=22;
        user.mAddress=new Address("武汉市","江夏区","金融港路");
        user.phone="15267129348";
        System.out.println("user = " + user);
        User clone = user.clone();
        System.out.println("clone = " + clone);
    }
}
//User.<init>
//user = User{mAge=22, name='null', phone='15267129348', mAddress=Address{mCity='武汉市', mDistrict='江夏区', mStreet='金融港路'}}
//clone = User{mAge=22, name='null', phone='15267129348', mAddress=Address{mCity='武汉市', mDistrict='江夏区', mStreet='金融港路'}}
