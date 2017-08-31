package zy_video1;

import org.junit.Test;

import com.zhiyou100.video.utils.MailUtil;

public class TestEmail {
	
	
	@Test
	public void test01() throws Exception{
		MailUtil.send("945209899@qq.com", "6666", "6不6");
	}
}
