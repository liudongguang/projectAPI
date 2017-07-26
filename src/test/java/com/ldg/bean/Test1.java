package com.ldg.bean;

import com.shiro.bo.TShiroUsersExt;
import org.junit.Test;

/**
 * Created by LiuDongguang on 2017/7/26.
 */
public class Test1 {
    @Test
    public void t1() throws Exception {
        TShiroUsersExt user2 = new TShiroUsersExt();
        user2.setPassword("ccccccccccc");
        System.out.println(user2);
    }
}
