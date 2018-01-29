package cn.zhengjun.androidsourcedesignpatternsanalysis.chapter04;

/**
 * OKLine(HangZhou) co.,Ltd.
 * Author  : Zheng Jun
 * Email   : zhengjun@okline.cn
 * Date    : 2018/1/29 12:26
 * Summary : null
 */

public class LoginSession {
    static LoginSession sLoginSession = null;

    private User mUser;

    public LoginSession() {
    }

    public LoginSession(User user) {
        mUser = user;
    }

    public User getUser() {
        return mUser;
    }
}
