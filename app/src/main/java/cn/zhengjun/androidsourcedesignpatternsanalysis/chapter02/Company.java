package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * Author  : Zheng Jun
 * Email   : zhengjun1987@outlook.com
 * Date    : 2018/1/7
 * Summary : 在这里描述Class的主要功能
 */

public class Company {
    private List<Staff> staffList = new ArrayList<>();

    public boolean add(Staff staff) {
        return staffList.add(staff);
    }

    public void showAll(){
        for (Staff staff : staffList) {
            System.out.println(staff.getClass().getSimpleName()+"  "+staff.toString());
        }
    }

    public static void main(String[] args) {
        Company company = new Company();
        CEO ceo = CEO.getInstance();
        CEO ceo1 = CEO.getInstance();
        VP vp1 = new VP();
        VP vp2 = new VP();
        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();

        company.add(ceo);
        company.add(ceo1);
        company.add(vp1);
        company.add(vp2);
        company.add(staff1);
        company.add(staff2);
        company.add(staff3);

        company.showAll();
    }
}
//        CEO  cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02.CEO@377dca04
//        CEO  cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02.CEO@377dca04
//        VP  cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02.VP@728938a9
//        VP  cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02.VP@21b8d17c
//        Staff  cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02.Staff@6433a2
//        Staff  cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02.Staff@5910e440
//        Staff  cn.zhengjun.androidsourcedesignpatternsanalysis.chapter02.Staff@6267c3bb
