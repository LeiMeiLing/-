package cn.jasonone.servlet;

import cn.jasonone.bean.PetInfo;
import cn.jasonone.service.PetInfoService;
import cn.jasonone.service.impl.PetInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

@WebServlet("/pet")
public class PetInfoServlet extends HttpServlet {
    PetInfoService pis = new PetInfoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询并分页
        PageInfo<PetInfo> all = pis.findAll(1, 10);
        //获得gson对象
        Gson gson = new Gson();
        //输出json
        gson.toJson(all,resp.getWriter());
    }
}
