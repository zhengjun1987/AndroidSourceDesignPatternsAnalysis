package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter04;

/**
 * OKLine(HangZhou) co.,Ltd.
 * Author  : Zheng Jun
 * Email   : zhengjun@okline.cn
 * Date    : 2018/1/29 12:04
 * Summary : null
 */

public class LoginImpl implements Login {
    private User mUser;

    public void setUser(User user) {
        mUser = user;
    }

    @Override
    public void login() {
        User user = new User();
        user.mAge =22;
        user.name="Zheng Jun";
        user.mAddress=new Address("杭州市","滨江区","滨盛路");
        setUser(user);
    }
}
