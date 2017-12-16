package annmeet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.annmeet.domain.User;
import com.cn.annmeet.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void test() {
		User user = new User();
		user.setMobile("13071850611");
		user.setNickname("POM");
		user.setPassword("dd2db8bc");
		user.setUsername("zhzwsjc1000");
		userMapper.insert(user);
	}
}
