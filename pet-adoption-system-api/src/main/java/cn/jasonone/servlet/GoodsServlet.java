package cn.jasonone.servlet;

import cn.jasonone.bean.GoodsInfo;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import cn.jasonone.service.GoodsInfoService;
import cn.jasonone.service.impl.GoodsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/petstore")
public class GoodsServlet extends HttpServlet {
    GoodsInfoService gs = new GoodsInfoServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        int pageNum = 1;
        int pageSize =10;
        if (page != null){
            pageNum = Integer.parseInt(page);
        }
        if (limit != null){
            pageSize = Integer.parseInt(limit);
        }
        PageInfo<GoodsInfo> goods= gs.findAll(pageNum,pageSize);
        Gson gson = new Gson();
        gson.toJson(goods,resp.getWriter());
    }
}
