package cn.jasonone.servlet;

import cn.hutool.jwt.JWTUtil;
import cn.jasonone.bean.UserInfo;
import cn.jasonone.filter.BodyHttpServletRequestWrapper;
import cn.jasonone.sevice.UserInfoService;
import cn.jasonone.sevice.impl.UserInfoServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class UserInfoServlet extends HttpServlet {
    private UserInfoService  userInfoService=new UserInfoServiceImpl();
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = (SqlSession) req.getAttribute("sqlSession");
        userInfoService.setSqlSession(sqlSession);
        try {
            String requestURI = req.getRequestURI();
            // 去除contextPath
            requestURI = requestURI.substring(req.getContextPath().length());
            switch (requestURI) {
                case "/user/register":
                    register((BodyHttpServletRequestWrapper) req, resp);
                    break;
                default:
                    super.doPut(req, resp);
            }
            // 如果没有异常，提交事务
            sqlSession.commit();
        } catch (IOException e) {
            // 如果有异常，回滚事务
            sqlSession.rollback();
            throw new RuntimeException(e);
        }
    }
    private void register(BodyHttpServletRequestWrapper req, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        String body = req.getBody();
        UserInfo userInfo = gson.fromJson(body, UserInfo.class);

        userInfoService.register(userInfo);
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "注册成功");
        resp.getWriter().write(gson.toJson(result));
    }
}
