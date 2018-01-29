package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter04;

/**
 * OKLine(HangZhou) co.,Ltd.
 * Author  : Zheng Jun
 * Email   : zhengjun@okline.cn
 * Date    : 2018/1/29 12:01
 * Summary : null
 */

public class Address {
    public String mCity;
    public String mDistrict;
    public String mStreet;

    public Address(String city, String district, String street) {
        mCity = city;
        mDistrict = district;
        mStreet = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "mCity='" + mCity + '\'' +
                ", mDistrict='" + mDistrict + '\'' +
                ", mStreet='" + mStreet + '\'' +
                '}';
    }
}
