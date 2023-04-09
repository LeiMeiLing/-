package cn.jasonone.sevice.impl;

import cn.hutool.core.util.RandomUtil;
import cn.jasonone.bean.UserInfo;
import cn.jasonone.mapper.UserInfoMapper;
import cn.jasonone.sevice.UserInfoService;
import lombok.Setter;
import org.apache.ibatis.session.SqlSession;

public class UserInfoServiceImpl implements UserInfoService {
    @Setter
    private SqlSession sqlSession;
    @Override
    public void register(UserInfo userInfo) {
        // 生成盐
        String salt = RandomUtil.randomString(6);
        userInfo.setSalt(salt);
        userInfo.setPassword(salt+userInfo.getPassword()+salt);
        sqlSession.getMapper(UserInfoMapper.class).insertSelective(userInfo);
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        return null;
    }
}
